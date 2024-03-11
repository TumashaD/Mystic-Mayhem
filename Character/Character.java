package Character;

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

    public void equipment(int attack, int defense, int health, int speed, int price){
        this.attack += attack;
        this.defense += defense;
        this.health += health;
        this.speed += speed;
        this.price += price*0.2;
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



