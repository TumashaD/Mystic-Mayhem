package Serialization;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import Player.Player; // Add missing import statement for Player class

public class Serialization {
    
    public static <T> T deepCopy(T object) {
        try {
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(bos);
            oos.writeObject(object); // Serialize the object
            ByteArrayInputStream bis = new ByteArrayInputStream(bos.toByteArray());
            ObjectInputStream ois = new ObjectInputStream(bis);
            return (T) ois.readObject(); // Deserialize the object to a new instance
            
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

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

    public static List<Player> deserializing() {
        List<Player> list = new ArrayList<Player>();
        try {
            FileInputStream fileStream2 = new FileInputStream("./Save/playerData.ser");
            ObjectInputStream savedPlayerData = new ObjectInputStream(fileStream2);
            list = (List<Player>) savedPlayerData.readObject();
            savedPlayerData.close();
        } catch (FileNotFoundException e) { 
            System.out.print("");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
}
