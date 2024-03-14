package Character;
import java.io.Serializable;

import Equipment.Equipment;

public abstract class Character implements Serializable{
    protected String category;
    protected String name;
    protected int price;
    protected int attack;
    protected int defense;
    protected double health;
    protected int speed;
    protected int attack_priority;
    protected int defense_priority;
    protected double attack_bonus;
    protected double health_bonus;
    
    
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
                        this.attack_bonus = 0.2;
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
                        this.speed -= 1;          
                    }
                    else if(this.category == "Sunchild"){
                        this.attack -= 1;         
                    }
                    else if(this.category == "Mystic"){
                        this.health_bonus = 0.1;
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

    public double getHealth(){
        return health;
    }
    public void setHealth(double health){
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
    public double getbonus_attack(){
        return this.attack_bonus;
    }
    public double getbonus_health(){
        return this.health_bonus;
    }

    public void attack(Character character, double effect ){
        double damage = 0.5*this.attack*effect - 0.1*character.getDefense();
        character.setHealth(Math.round((character.getHealth() - damage) * 10) / 10.0);
    }
}



