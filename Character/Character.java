package Character;
import Equipment.Equipment;

public abstract class Character {
    protected enum Category {
        Highlander, Marshlander,Sunchild,Mystic
    }
    protected String name;
    protected int price;
    protected int attack;
    protected int defense;
    protected int health;
    protected int speed;
    protected Category category;
    
    public void attack(int damage){
        health -= 0.5*damage - 0.1*this.defense;
    }

    public void heal(int healing_power){
        this.health += 0.1*healing_power;
    }

    public void equipment(Equipment equipment){
        this.attack += equipment.attack;
        this.defense += equipment.defense;
        this.health += equipment.health;
        this.speed += equipment.speed;
        this.price += equipment.price*0.2;
    }

    
    public void setBattleGround(String battleGround){
        switch (battleGround) {
            case "Hillcrest":
                
                break;
            case "Marshland":
                    
                    break;
            case "Desert":
                
                break;
            case "Arcane":
                
                break;
        
            default:
                break;
        }
    }
}



