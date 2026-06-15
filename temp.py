import os
import json

# Input Paths (1.21 Singular Folders)
OLD_RECIPE_DIR = "src/main/resources/data/craftablemusic/recipe"
OLD_LOOT_DIR = "src/main/resources/data/craftablemusic/loot_table"

# Output Paths (1.20.1 Plural Folders)
NEW_RECIPE_DIR = "src/main/resources/data/craftablemusic/recipes"
NEW_LOOT_DIR = "src/main/resources/data/craftablemusic/loot_tables"

def convert_recipes():
    if not os.path.exists(OLD_RECIPE_DIR):
        print(f"Skipping recipes: '{OLD_RECIPE_DIR}' folder not found.")
        return

    os.makedirs(NEW_RECIPE_DIR, exist_ok=True)
    
    for filename in os.listdir(OLD_RECIPE_DIR):
        if filename.endswith(".json"):
            old_path = os.path.join(OLD_RECIPE_DIR, filename)
            new_path = os.path.join(NEW_RECIPE_DIR, filename)
            
            with open(old_path, "r", encoding="utf-8") as f:
                data = json.load(f)
            
            # 1. Convert Condition Block to Forge 1.20.1 Style
            data["conditions"] = [
                {
                    "type": "craftablemusic:vanilla_craftings"
                }
            ]
            
            # 2. Fix the Recipe Result Tag (1.21 uses 'id', 1.20.1 uses 'item')
            if "result" in data:
                if isinstance(data["result"], dict) and "id" in data["result"]:
                    data["result"]["item"] = data["result"].pop("id")
                elif isinstance(data["result"], str):
                    # If it was just a raw string item ID, wrap it into a 1.20.1 object
                    data["result"] = {"item": data["result"], "count": 1}
            
            with open(new_path, "w", encoding="utf-8") as f:
                json.dump(data, f, indent=2)
            print(f"[RECIPE] Converted: {filename}")

def convert_loot_tables():
    if not os.path.exists(OLD_LOOT_DIR):
        print(f"Skipping loot tables: '{OLD_LOOT_DIR}' folder not found.")
        return

    os.makedirs(NEW_LOOT_DIR, exist_ok=True)
    
    for filename in os.listdir(OLD_LOOT_DIR):
        if filename.endswith(".json"):
            old_path = os.path.join(OLD_LOOT_DIR, filename)
            new_path = os.path.join(NEW_LOOT_DIR, filename)
            
            with open(old_path, "r", encoding="utf-8") as f:
                data = json.load(f)
            
            # Recurse through the loot table structure to swap 'id' -> 'name' for item entries
            if "pools" in data:
                for pool in data["pools"]:
                    if "entries" in pool:
                        for entry in pool["entries"]:
                            if entry.get("type") == "minecraft:item" and "id" in entry:
                                entry["name"] = entry.pop("id")
            
            with open(new_path, "w", encoding="utf-8") as f:
                json.dump(data, f, indent=2)
            print(f"[LOOT] Converted: {filename}")

if __name__ == "__main__":
    print("Starting automatic 1.21 -> 1.20.1 asset conversion...\n")
    convert_recipes()
    convert_loot_tables()
    print("\nDone! You can now safely delete the old singular 'recipe' and 'loot_table' folders.")