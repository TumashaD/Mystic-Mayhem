package Character;
import java.io.Serializable;

import Equipment.Equipment;
import Equipment.Armour.Armour;
import Equipment.Artifacts.Artifact;

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

    protected Armour armour;
    protected Artifact artifact;


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
    public void setArmour(Armour armour){
        if (this.armour == null) {
            this.armour = new Armour(armour.getName());
            this.attack = this.attack + armour.attack;
            this.defense = this.defense + armour.defense;
            this.health = this.health + armour.health;
            this.speed = this.speed + armour.speed;
            this.price = (int) (this.price + armour.price*0.2);
        }
        else{
            this.attack = this.attack - this.armour.attack + armour.attack;
            this.defense = this.defense - this.armour.defense + armour.defense;
            this.health = this.health - this.armour.health + armour.health;
            this.speed = this.speed - this.armour.speed + armour.speed;
            this.price = (int) (this.price - this.armour.price*0.2 + armour.price*0.2);
            this.armour = armour;
        }
    }

    public void setArtifact(Artifact artifact){
        if (this.artifact == null) {
            this.artifact = new Artifact(artifact.getName());
            this.attack = this.attack + artifact.attack;
            this.defense = this.defense + artifact.defense;
            this.health = this.health + artifact.health;
            this.speed = this.speed + artifact.speed;
            this.price = (int) (this.price + artifact.price*0.2);
        }
        else{
            this.attack = this.attack - this.artifact.attack + artifact.attack;
            this.defense = this.defense - this.artifact.defense + artifact.defense;
            this.health = this.health - this.artifact.health + artifact.health;
            this.speed = this.speed - this.artifact.speed + artifact.speed;
            this.price = (int) (this.price - this.artifact.price*0.2 + artifact.price*0.2);
            this.artifact = artifact;
        }
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

    public String getArmourName() {
        if (armour == null) {
            return "";
        }
        else{
            return armour.getName();
        }
    }

    public String getArtifactName() {
        if (artifact == null) {
            return "";
        }
        else{
            return artifact.getName();
        }
    }

    public void attack(Character character){}
}



