package Character.MythicalCreature;
import Character.Character;

public class MythicalCreature extends Character{
    public MythicalCreature(String name, Category category, int price, int attack, int defense, int health, int speed) {
        this.name = name;
        this.category = category;
        this.price = price;
        this.attack = attack;
        this.defense = defense;
        this.health = health;
        this.speed = speed;
    }
}
