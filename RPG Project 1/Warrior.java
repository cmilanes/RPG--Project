public class Warrior extends Character {
    public Warrior() {
        super("Warrior", 20, 10, 10, 5, 2, 1, 4); // super always first call in constructor 
        this.setStr((int)(Math.random() * 25.0) + 5);
        this.setDef((int)(Math.random() * 25.0) + 5);
        this.setName("W");
    }

    public void attack(Character c) {
        this.setStr(this.getStr() * 2);
        super.attack(c);
        this.setStr(this.getStr() / 2);
        this.setStr(this.getStr() - this.getStr() / 8);
    }
}

