public class Mage extends Character {
    public Mage() {
        super("Mage", 15, 15, 10, 4, 1, 3, 3); // super always first call in constructor 
        this.setStr((int)(Math.random() * 15.0) + 10);
        this.setDef((int)(Math.random() * 20.0) + 10);
        this.setName("M");
    }

    public void attack(Character c) {
        if(this.getHp() > 0){
            this.setStr(this.getStr() * 2);
            super.attack(c);
            this.setHp(this.getHp() - (this.getHp() / 4));
        } else {
            super.attack(c);
        }
    }
}