package Character.Healer;
import Character.Character;

public class Healer extends Character {
    public Healer(String name) {
        this.attack_priority = 5;
        this.defense_priority = 1;
        switch (name) {
            case "Soother":
                this.name = name;
                this.category = "Sunchild";
                this.price = 95;this.attack = 10;this.defense = 8;this.health = 9;this.speed = 6;
                break;
            case "Medic":
                this.name = name;
                this.category = "Highlander";
                this.price = 125;this.attack = 12;this.defense = 9;this.health = 10;this.speed = 7;
                break;
            case "Alchemist":
                this.name = name;
                this.category = "Marshlander";
                this.price = 150;this.attack = 13;this.defense = 13;this.health = 13;this.speed = 13;
                break;
            case "Saint":
                this.name = name;
                this.category = "Mystic";
                this.price = 200;this.attack = 16;this.defense = 14;this.health = 17;this.speed = 9;
                break;
            case "Lightbringer":
                this.name = name;
                this.category = "Sunchild";
                this.price = 260;this.attack = 17;this.defense = 15;this.health = 19;this.speed = 12;
                break;
    
            default:
                System.out.println("Invalid Healer name. Please choose from the list.");
                break;
        }
    }
    
    @Override
    public void attack(Character character, double effect){
        double heal = 0.5*this.attack*effect;
        character.setHealth(Math.round((character.getHealth() +heal) * 10) / 10.0);
    }
    

    
}