package Player;


import Character.Archer.Archer;
import Character.Healer.Healer;
import Character.Knight.Knight;
import Character.Mage.Mage;
import Character.MythicalCreature.MythicalCreature;
import java.io.Serializable;

public class Player implements Serializable{
    private String name;
    private String userName;
    private short xp;
    private int coins;
    private String homeGround;

    //Army
    public Archer archer;
    public Healer healer;
    public Knight knight;
    public Mage mage;
    public MythicalCreature mythicalCreature;
    
    public Player(String name, String userName, String homeGround){
        this.name = name;
        this.userName = userName;
        this.coins = 500;
        this.homeGround = homeGround;
        xp = 0;
    }

    public void setArcher(String name){
        archer = new Archer(name);
        
    }

    public void setHealer(String name){
        healer = new Healer(name);
    }

    public void setKnight(String name){
        knight = new Knight(name);
    }

    public void setMage(String name){
        mage = new Mage(name);
    }

    public void setMythicalCreature(String name){
        mythicalCreature = new MythicalCreature(name);
    }

    public void setXp(short xp){
        this.xp = xp;
    }
    public short getXp(){
        return xp;
    }
    public void setCoins(int coins){
        this.coins = coins;
    }
    public int getCoins(){
        return coins;
    }
    public void setHomeGround(String homeGround){
        this.homeGround = homeGround;
    }
    public String getHomeGround(){
        return homeGround;
    }
    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return name;
    }
    
}