package com.dino13513.craftablemusic;

import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.arguments.StringArgumentType;
import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import com.mojang.brigadier.context.StringRange;
import com.mojang.brigadier.suggestion.Suggestion;
import com.mojang.brigadier.suggestion.Suggestions;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.network.chat.Component;
import net.minecraft.server.MinecraftServer;
import net.neoforged.neoforge.event.RegisterCommandsEvent;

import java.util.ArrayList;
import java.util.List;

public class ModCommands {

    public static void onRegisterCommands(RegisterCommandsEvent event) {
        CommandDispatcher<CommandSourceStack> dispatcher = event.getDispatcher();

        // 1. Overwrite vanilla /debug and restrict to Level 2 (Game Masters/Admins)
        LiteralArgumentBuilder<CommandSourceStack> customDebugWrapper = Commands.literal("debug")
                .requires(source -> source.hasPermission(2))

                .then(Commands.argument("arguments", StringArgumentType.greedyString())

                        // 2. The Autocomplete Fix: Safely fetch remaining text and shift ranges
                        .suggests((context, builder) -> {
                            String remainingInput = builder.getRemaining();
                            var parseResults = dispatcher.parse(remainingInput, context.getSource());

                            return dispatcher.getCompletionSuggestions(parseResults)
                                    .thenApply(suggestions -> {
                                        List<Suggestion> shiftedSuggestions = new ArrayList<>();
                                        int offset = builder.getStart();

                                        // Shift each individual suggestion
                                        for (Suggestion suggestion : suggestions.getList()) {
                                            StringRange originalRange = suggestion.getRange();
                                            StringRange shiftedRange = StringRange.between(
                                                    originalRange.getStart() + offset,
                                                    originalRange.getEnd() + offset
                                            );
                                            shiftedSuggestions.add(new Suggestion(shiftedRange, suggestion.getText(), suggestion.getTooltip()));
                                        }

                                        // Shift the global suggestion box
                                        StringRange originalGlobalRange = suggestions.getRange();
                                        StringRange shiftedGlobalRange = StringRange.between(
                                                originalGlobalRange.getStart() + offset,
                                                originalGlobalRange.getEnd() + offset
                                        );

                                        return new Suggestions(shiftedGlobalRange, shiftedSuggestions);
                                    });
                        })

                        // 3. The Execution & Whisper Trick
                        .executes(context -> {
                            String subCommand = StringArgumentType.getString(context, "arguments");
                            CommandSourceStack source = context.getSource();
                            MinecraftServer server = source.getServer();

                            if (server != null) {
                                // Intercept system messages and redirect them to the executor only
                                CommandSource interceptor = new CommandSource() {
                                    @Override
                                    public void sendSystemMessage(Component message) {
                                        source.sendSystemMessage(message);
                                    }

                                    @Override
                                    public boolean acceptsSuccess() { return true; }

                                    @Override
                                    public boolean acceptsFailure() { return true; }

                                    @Override
                                    public boolean shouldInformAdmins() {
                                        return false; // Blocks the server-wide broadcast
                                    }
                                };

                                // Execute silently at permission level 4
                                CommandSourceStack silentAdminStack = source
                                        .withSource(interceptor)
                                        .withPermission(4);

                                server.getCommands().performPrefixedCommand(silentAdminStack, subCommand);
                                return 1;
                            }
                            return 0;
                        })
                );

        // Register the wrapped command, overwriting the vanilla node
        dispatcher.register(customDebugWrapper);
    }
}