public class Knight extends Character {
    public Knight() {
        super("Knight", 10, 20, 10, 3, 7, 3, 2); // super always first call in constructor 
        this.setDef((int)(Math.random() * 30.0) + 15);
        this.setStr((int)(Math.random() * 15.0) + 5);
        this.setName("K");
    }

    public void attack(Character c) {
        this.setStr(this.getDef() * 2);
        super.attack(c);
        this.setStr(this.getStr() - this.getStr() / 8);
    }
}
