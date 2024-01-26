public class Assassin extends Character {
    public Assassin() {
        super("Assassin", 30, 15, 10, 2, 4, 2, 4); // super always first call in constructor 
        this.setStr((int)(Math.random() * 25.0) + 10);
        this.setDef((int)(Math.random() * 15.0) + 5);
        this.setName("A");
    }

    public void attack(Character c) {
        this.setStr(this.getStr() + this.getStr() / 2);
        super.attack(c);
        this.setDef(this.getDef() - this.getDef() / 4);
        this.setStr(this.getStr() - this.getStr() / 2);
    }
}
