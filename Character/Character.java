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
                    if(this.category == Category.Highlander){
                        this.attack += 1;
                        this.defense += 1;
                        this.attack += this.attack*0.2;
                    }
                    else if(this.category == Category.Marshlander){
                        this.speed -= 1;
                    }
                    else if(this.category == Category.Sunchild){
                        this.speed -= 1;
                    }
                    else if(this.category == Category.Mystic){
                        this.speed += 0.1*this.speed;
                    }
                break;
            case "Marshland":
                    if(this.category == Category.Marshlander){
                        this.defense += 2;           
                    }
                    else if(this.category == Category.Sunchild){
                        this.attack -= 1;         
                    }
                    else if(this.category == Category.Mystic){
                        this.speed -= 1;
                    }
                    break;
            case "Desert":
                if(this.category == Category.Marshlander){
                    this.health -= 1;           
                }
                else if(this.category == Category.Sunchild){
                    this.attack += 1;         
                }
                break;

            case "Arcane":
                if(this.category == Category.Marshlander || this.category == Category.Highlander){
                        this.defense -= 1; 
                        this.attack -= 1;          
                    }
                    else if(this.category == Category.Sunchild){
                        this.attack -= 1;         
                    }
                    else if(this.category == Category.Mystic){
                        this.attack += 2;
                    }
                break;
        
            default:
                break;
        }
    }
}



