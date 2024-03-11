package Character.Knight;
import Character.Character;

public class Knight extends Character {
    public Knight(String name) {
        switch (name) {
            case "Squire":
                this.name = name;
                this.category = Category.Marshlander;
                this.price = 85;this.attack = 8;this.defense = 9;this.health = 7;this.speed = 8;
                break;
            case "Cavalier": 
                this.name = name;
                this.category = Category.Highlander;
                this.price = 110;this.attack = 10;this.defense = 12;this.health = 7;this.speed = 10;
                break;
            case "Templar":
                this.name = name;
                this.category = Category.Sunchild;
                this.price = 155;this.attack = 14;this.defense = 16;this.health = 12;this.speed = 12;
                break;
            case "Zoro":
                this.name = name;
                this.category = Category.Highlander;
                this.price = 180;this.attack = 17;this.defense = 16;this.health = 13;this.speed = 14;
                break;
            case "Swiftblade":
                this.name = name;
                this.category = Category.Marshlander;
                this.price = 250;this.attack = 18;this.defense = 20;this.health = 17;this.speed = 13;
                break;

            default:
                System.out.println("Invalid Knight name. Please choose from the list.");
                break;
        }
    }
}