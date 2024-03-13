package Character.MythicalCreature;
import Character.Character;

public class MythicalCreature extends Character{
    public MythicalCreature(String name) {
        this.attack_priority = 3;
        this.defense_priority = 2;
       switch (name) {
        case "Dragon":
            this.name = name;
            this.category = "Marshlander";
            this.price = 120;this.attack = 12;this.defense = 14;this.health = 15;this.speed = 8;
            break;

        case "Phoenix":
            this.name = name;
            this.category = "Sunchild";
            this.price = 150;this.attack = 14;this.defense = 16;this.health = 17;this.speed = 10;
            break;
        
        case "Unicorn":
            this.name = name;
            this.category = "Highlander";
            this.price = 180;this.attack = 16;this.defense = 18;this.health = 19;this.speed = 12;
            break;
        
        case "Basilisk":
            this.name = name;
            this.category = "Mystic";
            this.price = 200;this.attack = 18;this.defense = 20;this.health = 20;this.speed = 14;
            break;
        
        case "Hydra":
            this.name = name;
            this.category = "Marshlander";
            this.price = 250;this.attack = 20;this.defense = 22;this.health = 22;this.speed = 16;
            break;
       
        default:
            System.out.println("Invalid Mythical Creature name. Please choose from the list.");
            break;
       }
    }
}
