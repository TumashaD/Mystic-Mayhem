package Character;
import Equipment.Equipment;

public abstract class Character {
    protected String category;
    protected String name;
    protected int price;
    protected int attack;
    protected int defense;
    protected int health;
    protected int speed;

    public int getPrice(){
        return this.price;
    }
    
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
                    if(this.category == "Highlander"){
                        this.attack += 1;
                        this.defense += 1;
                        this.attack += this.attack*0.2;
                    }
                    else if(this.category == "Marshlander"){
                        this.speed -= 1;
                    }
                    else if(this.category == "Sunchild"){
                        this.speed -= 1;
                    }
                    else if(this.category == "Mystic"){
                        this.speed += 0.1*this.speed;
                    }
                break;
            case "Marshland":
                    if(this.category == "Marshlander"){
                        this.defense += 2;           
                    }
                    else if(this.category == "Sunchild"){
                        this.attack -= 1;         
                    }
                    else if(this.category == "Mystic"){
                        this.speed -= 1;
                    }
                    break;
            case "Desert":
                if(this.category == "Marshlander"){
                    this.health -= 1;           
                }
                else if(this.category == "Sunchild"){
                    this.attack += 1;         
                }
                break;

            case "Arcane":
                if(this.category == "Marshlander" || this.category == "Highlander"){
                        this.defense -= 1; 
                        this.attack -= 1;          
                    }
                    else if(this.category == "Sunchild"){
                        this.attack -= 1;         
                    }
                    else if(this.category ==" Mystic"){
                        this.attack += 2;
                    }
                break;
        
            default:
                break;
        }
    }

}



