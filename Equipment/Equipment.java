package Equipment;

public abstract class Equipment {
    public String name;
    public int price;
    public int attack = 0;
    public int defense = 0;
    public int health = 0;
    public int speed = 0;

    public int getPrice(){
        return price;
    }
}
