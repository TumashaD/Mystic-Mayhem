package Equipment.Artifacts;

import Equipment.Equipment;

public class Artifact extends Equipment{
    public Artifact(String name){
        switch(name){
            case "Excalibur":
                this.name = name;
                this.price = 150; this.attack= 2;
                break;
            case "Amulet":
                this.name = name;
                this.price = 200; this.attack = 1; this.defense = -1;this.health = 1; this.speed = 1;
                break;
            case "Crystal":
                this.name = name;
                this.price = 210; this.attack = 2; this.defense = 1; this.health = -1; this.speed = -1;
                break;
        }
    }
}
