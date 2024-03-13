package Player;


import java.util.ArrayList;
import java.util.List;

import Character.Character;
import Character.Archer.Archer;
import Character.Healer.Healer;
import Character.Knight.Knight;
import Character.Mage.Mage;
import Character.MythicalCreature.MythicalCreature;
import java.util.Collections;

public class Player {
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
    public List<Character> list = new ArrayList<>();
    
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

    public void createArmyList(){
        list.add(archer);
        list.add(healer);
        list.add(knight);
        list.add(mage);
        list.add(mythicalCreature);
    }


    public List<Character> getAttackList(){

        createArmyList();

        List<Character> tempList = new ArrayList<>();
        int max_speed = 0;
        int max_index = 0;

        for(int i = 5; i > 0; i--){
            max_speed = 0;
            max_index = 0;

            for(int j = 0; j < i; j++){
                if(list.get(j).getSpeed() > max_speed){
                    max_speed = tempList.get(j).getSpeed();
                    max_index = j;
                }
                else if(list.get(j).getSpeed() == max_speed){
                    if(list.get(j).getAttack_priority() < tempList.get(max_index).getAttack_priority()){
                        max_index = j;
                    }
                }
            }
            tempList.add(list.get(max_index));
        }


        return tempList;
    }

    public List<Character> getDefenceList(){

        createArmyList();

        List<Character> tempList = new ArrayList<>();
        int min_difence = 100;
        int min_index = 0;

        for(int i = 5; i > 0; i--){
            min_difence = 100;
            min_index = 0;

            for(int j = 0; j < i; j++){
                if(list.get(j).getdiffence() < min_difence){
                    min_difence = tempList.get(j).getdiffence();
                    min_index = j;
                }
                else if(list.get(j).getdiffence() == min_difence){
                    if(list.get(j).getDefense_priority() < tempList.get(min_index).getDefense_priority()){
                        min_index = j;
                    }
                }
            }
            tempList.add(list.get(min_index));
        }

        return tempList;
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