package Player;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import Character.Character;
import Character.Archer.Archer;
import Character.Healer.Healer;
import Character.Knight.Knight;
import Character.Mage.Mage;
import Character.MythicalCreature.MythicalCreature;
import Equipment.Equipment;
import Views.Block;
import Views.Board;
import java.io.Serializable;

public class Player implements Serializable{
    private static final long serialVersionUID = 5750795826548989086L;

    private String name;
    private String userName;
    private int xp;
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
        this.coins = 5000;
        this.homeGround = homeGround;
        this.xp = 1;
    }

    // Archer getter and setter
    public void setArcher(Archer archer){
        this.archer = archer;  
    }
    public Archer getArcher(){
        return archer;
    }

    public boolean buyArcher(Archer archer){
        int sellingPrice = this.archer.getPrice()*90/100;
        int coins = this.coins + sellingPrice - archer.getPrice();
        if (coins < 0){
            return false;
        }
        else{
            this.archer = archer;
            this.coins = coins;
            return true;
        }
    }


    
    // Healer getter and setter
    public void setHealer(Healer healer){
        this.healer = healer;
    }
    public Healer getHealer(){
        return healer;
    }
    public boolean buyHealer(Healer healer){
        int sellingPrice = this.healer.getPrice()*90/100;
        int coins = this.coins + sellingPrice - healer.getPrice();
        if (coins < 0){
            return false;
        }
        else{
            this.healer = healer;
            this.coins = coins;
            return true;
        }
    }

    // Knight getter and setter
    public void setKnight(Knight knight){
        this.knight = knight;
    }
    public Knight getKnight(){
        return knight;
    }
    public boolean buyKnight(Knight knight){
        int sellingPrice = this.knight.getPrice()*90/100;
        int coins = this.coins + sellingPrice - knight.getPrice();
        if (coins < 0){
            return false;
        }
        else{
            this.knight = knight;
            this.coins = coins;
            return true;
        }
    }

    // Mage getter and setter
    public void setMage(Mage mage){
        this.mage = mage;
    }
    public Mage getMage(){
        return mage;
    }
    public boolean buyMage(Mage mage){
        int sellingPrice = this.mage.getPrice()*90/100;
        int coins = this.coins + sellingPrice - mage.getPrice();
        if (coins < 0){
            return false;
        }
        else{
            this.mage = mage;
            this.coins = coins;
            return true;
        }
    }

    // MythicalCreature getter and setter
    public void setMythicalCreature(MythicalCreature mythicalCreature){
        this.mythicalCreature = mythicalCreature;
    }
    public MythicalCreature getMythicalCreature(){
        return mythicalCreature;
    }
    public boolean buyMythicalCreature(MythicalCreature mythicalCreature){
        int sellingPrice = this.mythicalCreature.getPrice()*90/100;
        int coins = this.coins + sellingPrice - mythicalCreature.getPrice();
        if (coins < 0){
            return false;
        }
        else{
            this.mythicalCreature = mythicalCreature;
            this.coins = coins;
            return true;
        }
    }

    public boolean buyEquipment(Equipment equipment){
        int coins = this.coins - equipment.getPrice();
        if (coins < 0){
            return false;
        }
        else{
            this.coins = coins;
            return true;
        }
    }

    public void setXp(int xp){
        this.xp = xp;
    }
    public int getXp(){
        return this.xp;
    }

    public void setCoins(double coins){
        this.coins = (int) Math.round(coins);
    }
    public int getCoins(){
        return coins;
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

    public String getUserName(){
        return userName;
    }

    public List<Character> getAttackers(){
        List<Character> attackPriority = new ArrayList<>(Arrays.asList(this.archer, this.healer, this.knight, this.mage, this.mythicalCreature));

        attackPriority.sort((c1, c2) -> {
            int speedCompare = Integer.compare(c2.getSpeed(), c1.getSpeed());
            if (speedCompare == 0) {
                // If speeds are equal, compare by type
                return Integer.compare(c1.getAttack_priority(), c2.getAttack_priority());
            }
            return speedCompare;
        });

        return attackPriority;
    }
    public List<Character> getDefenders(){
        List<Character> defencePriority = new ArrayList<>(Arrays.asList(this.archer, this.healer, this.knight, this.mage, this.mythicalCreature));

        defencePriority.sort((c1, c2) -> {
                    int defenceCompare = Integer.compare(c1.getdiffence(), c2.getdiffence());
                    if (defenceCompare == 0) {
                        // If defences are equal, compare by type
                        return Integer.compare(c1.getDefense_priority(), c2.getDefense_priority());
                    }
                    return defenceCompare;
                });
        return defencePriority;
    }

    public void setPlayerBattleGround(String battleGround){
        this.archer.setBattleGround(battleGround);
        this.healer.setBattleGround(battleGround);
        this.knight.setBattleGround(battleGround);
        this.mage.setBattleGround(battleGround);
        this.mythicalCreature.setBattleGround(battleGround);
    }


    public void displayCharacters(){
        // Creating the table
        Board board = new Board(120);

        // Title
        Block title = new Block(board, 105, 1, "Your Characters");
        title.setDataAlign(Block.DATA_CENTER);
        title.allowGrid(false);
        board.setInitialBlock(title);

        //Archer
        Block archerTitle = new Block(board, 20, 1,"ARCHER");
        title.setBelowBlock(archerTitle.setDataAlign(Block.DATA_CENTER));
        Block archerInfo = new Block(board, 20, 6, "NAME: " + archer.getName() + "\n" + "ATTACK: " + archer.getAttack() + "\n" + "DEFENSE: " + archer.getDefense() + "\n" + "HEALTH: " + archer.getHealth() + "\n" + "SPEED: " + archer.getSpeed());
        archerTitle.setBelowBlock(archerInfo);

        //Healer
        Block healerTitle = new Block(board, 20, 1,"HEALER");
        archerTitle.setRightBlock(healerTitle.setDataAlign(Block.DATA_CENTER));
        Block healerInfo = new Block(board, 20, 6, "NAME: " + healer.getName() + "\n" + "ATTACK: " + healer.getAttack() + "\n" + "DEFENSE: " + healer.getDefense() + "\n" + "HEALTH: " + healer.getHealth() + "\n" + "SPEED: " + healer.getSpeed());
        healerTitle.setBelowBlock(healerInfo);

        //Knight
        Block knightTitle = new Block(board, 20, 1,"KNIGHT");
        healerTitle.setRightBlock(knightTitle.setDataAlign(Block.DATA_CENTER));
        Block knightInfo = new Block(board, 20, 6, "NAME: " + knight.getName() + "\n" + "ATTACK: " + knight.getAttack() + "\n" + "DEFENSE: " + knight.getDefense() + "\n" + "HEALTH: " + knight.getHealth() + "\n" + "SPEED: " + knight.getSpeed());
        knightTitle.setBelowBlock(knightInfo);

        //Mage
        Block mageTitle = new Block(board, 20, 1,"MAGE");
        knightTitle.setRightBlock(mageTitle.setDataAlign(Block.DATA_CENTER));
        Block mageInfo = new Block(board, 20, 6, "NAME: " + mage.getName() + "\n" + "ATTACK: " + mage.getAttack() + "\n" + "DEFENSE: " + mage.getDefense() + "\n" + "HEALTH: " + mage.getHealth() + "\n" + "SPEED: " + mage.getSpeed());
        mageTitle.setBelowBlock(mageInfo);

        //Mythical Creature
        Block mythicalCreatureTitle = new Block(board, 20, 1,"MYTHICAL CREATURE");
        mageTitle.setRightBlock(mythicalCreatureTitle.setDataAlign(Block.DATA_CENTER));
        Block mythicalCreatureInfo = new Block(board, 20, 6, "NAME: " + mythicalCreature.getName() + "\n" + "ATTACK: " + mythicalCreature.getAttack() + "\n" + "DEFENSE: " + mythicalCreature.getDefense() + "\n" + "HEALTH: " + mythicalCreature.getHealth() + "\n" + "SPEED: " + mythicalCreature.getSpeed());
        mythicalCreatureTitle.setBelowBlock(mythicalCreatureInfo);

        System.out.println(board.invalidate().build().getPreview());        
    }
    
}