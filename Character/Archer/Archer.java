package Character.Archer;
import Character.Character;

public class Archer extends Character {
    public Archer(String name) {
        this.attack_priority = 1;
        this.defense_priority = 3;
        switch (name) {
            case "Shooter":
                this.name = name;
                this.category = "Highlander";
                this.price = 80;this.attack = 11;this.defense = 4;this.health = 6;this.speed = 9;
                break;
            case "Ranger":
                this.name = name;
                this.category = "Highlander";
                this.price = 115;this.attack = 14;this.defense = 5;this.health = 8;this.speed = 10;
                break;
            case "Sunfire": 
                this.name = name;
                this.category = "Sunchild";
                this.price = 160;this.attack = 15;this.defense = 5;this.health = 7;this.speed = 14;
                break;
            case "Zing":
                this.name = name;
                this.category = "Sunchild";
                this.price = 200;this.attack = 16;this.defense = 9;this.health = 11;this.speed = 14;
                break;
            case "Saggitarius":
                this.name = name;
                this.category = "Mystic";
                this.price = 230;this.attack = 18;this.defense = 7;this.health = 12;this.speed = 17;
                break;
        
            default:
                System.out.println("Invalid Archer name. Please choose from the list.");
                break;
        } 
    }
    
    @Override
    public void attack(Character character){
        double damage = 0.5*this.attack - 0.1*character.getDefense();
        character.setHealth((int)(character.getHealth() - damage));
    }
}