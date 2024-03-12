package Serialization;

import java.util.ArrayList;
import java.util.List;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import Player.Player;

public class Serialization {
    
    public static void serializing(List<Player> list){
        try{
            FileOutputStream fileStream1 = new FileOutputStream(".\\save\\playerData.ser");
            ObjectOutputStream os = new ObjectOutputStream(fileStream1);

            for (Player obj: list){
                os.writeObject(obj);
            } 
            
            os.close();

            System.out.println("Serialization is successful");
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }

    public static List<Player> deserializing(){
        List<Player> list =new ArrayList<Player>();
        try{
            FileInputStream fileStream2 = new FileInputStream(".\\save\\playerData.ser");
            ObjectInputStream savedPlayerData = new ObjectInputStream(fileStream2);

            Player obj = null;

            
            while (savedPlayerData.available() > 0) {
                obj = (Player)savedPlayerData.readObject();
                    list.add(obj);
            }
            savedPlayerData.close();
            System.out.println("Deserialization is successful");
            for (Player player: list){
                System.out.println(player.getName());
            }
            
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return list;
    }
}
