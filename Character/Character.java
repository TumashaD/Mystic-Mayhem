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
    protected int attack_priority;
    protected int defense_priority;
    
    
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

    public String getName(){
        return name;
    }

    public int getAttack(){
        return attack;
    }
    public int getDefense(){
        return defense;
    }

    public int getHealth(){
        return health;
    }
    public void setHealth(int health){
        this.health = health;
    }

    public int getSpeed(){
        return speed;
    }
    public int getPrice(){
        return this.price;
    }
    public void setEquipment(Equipment equipment){
        this.attack += equipment.attack;
        this.defense += equipment.defense;
        this.health += equipment.health;
        this.speed += equipment.speed;
        this.price += equipment.price*0.2;
    }
    public final int getdiffence(){
        return this.defense;
    }
    
    public int getAttack_priority() {
        return attack_priority;
    }

    public int getDefense_priority() {
        return defense_priority;
    }

    public String getCategory() {
        return category;
    }
}



