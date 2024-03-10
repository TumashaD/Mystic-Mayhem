package Character.Healer;
import Character.Character;

public class Healer extends Character {
    public Healer(String name, Category category, int price, int attack, int defense, int health, int speed) {
        this.name = name;
        this.category = category;
        this.price = price;
        this.attack = attack;
        this.defense = defense;
        this.health = health;
        this.speed = speed;
    }
}