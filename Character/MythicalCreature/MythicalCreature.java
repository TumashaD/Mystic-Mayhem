package Character.MythicalCreature;
import Character.Character;

public class MythicalCreature extends Character{
    public MythicalCreature(String name) {
        this.attack_priority = 3;
        this.defense_priority = 2;
       switch (name) {
        case "Dragon":
            this.name = name;
            this.category = "Sunchild";
            this.price = 120;this.attack = 12;this.defense = 14;this.health = 15;this.speed = 8;
            break;

        case "Basilisk":
            this.name = name;
            this.category = "Marshlander";
            this.price = 165;this.attack = 15;this.defense = 11;this.health = 10;this.speed = 12;
            break;
       
        case "Hydra":
            this.name = name;
            this.category = "Marshlander";
            this.price = 205;this.attack = 12;this.defense = 16;this.health = 15;this.speed = 11;
            break;
        
        case "Phoenix":
            this.name = name;
            this.category = "Sunchild";
            this.price = 275;this.attack = 17;this.defense = 13;this.health = 17;this.speed = 19;
            break;

        case "Pegasus":
            this.name = name;
            this.category = "Mysitc";
            this.price = 340;this.attack = 14;this.defense = 18;this.health = 20;this.speed = 20;
            break;
        default:
            System.out.println("Invalid Mythical Creature name. Please choose from the list.");
            break;
       }
    }

    public void attack(Character character){
        double damage = 0.5*this.attack - 0.1*character.getDefense();
        character.setHealth((int)(character.getHealth() - damage));
    }
}
