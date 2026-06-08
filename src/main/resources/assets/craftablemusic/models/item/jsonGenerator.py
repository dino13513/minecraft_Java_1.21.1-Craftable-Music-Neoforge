import json
import os

# CONFIGURATION
MOD_ID = "craftablemusic"
item_names = ["BEER", "polish1_music_disc", "polish2_music_disc"]  # <-- Add all your item names here

# The standard Minecraft item model template
for name in item_names:
    model_data = {
        "parent": "minecraft:item/generated",
        "textures": {
            "layer0": f"{MOD_ID}:item/{name}"
        }
    }

    # Creates a separate file named 'item_name.json'
    file_name = f"{name}.json"
    with open(file_name, "w") as f:
        json.dump(model_data, f, indent=4)

print(f"Successfully generated {len(item_names)} item JSON files!")