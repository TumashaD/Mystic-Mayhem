package Character.Mage;
import Character.Character;

public class Mage extends Character{
    public Mage(String name) {
        this.attack_priority = 4;
        this.defense_priority = 5;
      switch (name) {
        case "Warlock":
            this.name = name;
            this.category = Category.Marshlander;
            this.price = 100;this.attack = 12;this.defense = 7;this.health = 10;this.speed = 12;
            break;

        case "Sorcerer":
            this.name = name;
            this.category = Category.Marshlander;
            this.price = 130;this.attack = 14;this.defense = 8;this.health = 11;this.speed = 13;
            break;
        
        case "Enchanter":
            this.name = name;
            this.category = Category.Highlander;
            this.price = 160;this.attack = 16;this.defense = 10;this.health = 13;this.speed = 16;
            break;
        
        case "Conjurer":
            this.name = name;
            this.category = Category.Highlander;
            this.price = 195;this.attack = 18;this.defense = 15;this.health = 14;this.speed = 12;
            break;
        
        case "Eldritch":
            this.name = name;
            this.category = Category.Mystic;
            this.price = 270;this.attack = 19;this.defense = 17;this.health = 18;this.speed = 14;
            break;

        
      
        default:
            System.out.println("Invalid Mage name. Please choose from the list.");
            break;
      }
    }
}
