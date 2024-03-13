package Serialization;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import Player.Player; // Add missing import statement for Player class

public class Serialization {
    
    // public static void serializing(List<Player> list){
    //     try{
    //         FileOutputStream fileStream1 = new FileOutputStream("./Save/playerData.ser");
    //         ObjectOutputStream os = new ObjectOutputStream(fileStream1);

    //         for (Player obj: list){
    //             os.writeObject(obj);
    //         } 
            
    //         os.close();

    //         System.out.println("Serialization is successful");
    //     }
    //     catch (IOException e){
    //         e.printStackTrace();
    //     }
    // }

    // public static List<Player> deserializing(){
    //     List<Player> list =new ArrayList<Player>();
    //     try{
    //         FileInputStream fileStream2 = new FileInputStream("./Save/playerData.ser");
    //         ObjectInputStream savedPlayerData = new ObjectInputStream(fileStream2);

    //         Player obj = null;
       
    //         while (savedPlayerData.available() > 0) {
    //             obj = (Player)savedPlayerData.readObject();
    //             list.add(obj);
    //         }
    //         savedPlayerData.close();
    //         System.out.println("Deserialization is successful");
            
    //     }
    //     catch (Exception e){
    //         e.printStackTrace();
    //     }
    //     return list;
    // }

    public static boolean serializing(List<Player> list){
        try{
            FileOutputStream fileStream1 = new FileOutputStream("./Save/playerData.ser");
            ObjectOutputStream os = new ObjectOutputStream(fileStream1);
            os.writeObject(list);
            os.close();
            return true;
        }
        catch (IOException e){
            e.printStackTrace();
            return false;
        }
    }

    public static List<Player> deserializing(){
        List<Player> list =new ArrayList<Player>();
        try{
            FileInputStream fileStream2 = new FileInputStream("./Save/playerData.ser");
            ObjectInputStream savedPlayerData = new ObjectInputStream(fileStream2);
            list = (List<Player>) savedPlayerData.readObject();
            savedPlayerData.close();
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return list;
    }
}
