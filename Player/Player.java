package Player;

import Character.Archer.Archer;
import Character.Healer.Healer;
import Character.Knight.Knight;
import Character.Mage.Mage;
import Character.MythicalCreature.MythicalCreature;

public class Player {
    private String name;
    private String userName;
    private short xp;
    private int coins;
    private String homeGround;

    //Army
    private Archer archer;
    private Healer healer;
    private Knight knight;
    private Mage mage;
    private MythicalCreature mythicalCreature;
    
    public Player(String name, String userName, String homeGround){
        this.name = name;
        this.userName = userName;
        this.coins = 500;
        this.homeGround = homeGround;
        xp = 0;
    }

    // Archer getter and setter
    public void setArcher(Archer archer){
        this.archer = archer;  
    }
    public Archer getArcher(){
        return archer;
    }
    
    // Healer getter and setter
    public void setHealer(Healer healer){
        this.healer = healer;
    }
    public Healer getHealer(){
        return healer;
    }

    // Knight getter and setter
    public void setKnight(Knight knight){
        this.knight = knight;
    }
    public Knight getKnight(){
        return knight;
    }

    // Mage getter and setter
    public void setMage(Mage mage){
        this.mage = mage;
    }
    public Mage getMage(){
        return mage;
    }

    // MythicalCreature getter and setter
    public void setMythicalCreature(MythicalCreature mythicalCreature){
        this.mythicalCreature = mythicalCreature;
    }
    public MythicalCreature getMythicalCreature(){
        return mythicalCreature;
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