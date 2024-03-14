package Equipment.Armour;
import Equipment.Equipment;

public class Armour extends Equipment{
    public Armour(String name){
        switch (name){
            case "Chainmail":
                this.name = name;
                this.price = 70;this.defense = 1;this.speed = -1;
                break;
            case "Regalia":
                this.name = name;
                this.price = 105;this.defense= 1;
                break;
            case "Fleece":
                this.name = name;
                this.price = 150;this.defense = 2;this.health = 1;this.speed = -1;
                break;
            default:
                this.name = "None";
                this.price = 0; this.defense = 0; this.health = 0; this.speed = 0;
                break;
        }
    }
}
