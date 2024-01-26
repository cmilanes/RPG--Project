//Abstract means can't make any more "Mappable"(ie new Mappable()) objects, but can make arrays that store "Mappable" objects
public abstract class Mappable {
    private int currRow;
    private int currCol;
    public static final int STARTING_HP = 40;
    private int strength;
    private int health;
    private int defence;
    private String name;
    private int xp;
    
    public Mappable(String name, int str, int def, int exp, int r, int c){
        this.name = name;
        strength = str;
        defence = def;
        health = STARTING_HP;
        xp = exp;
        currRow = r;
        currCol = c;
    }

    public Mappable(String name, int r, int c){
        currRow = r;
        currCol = c;
        strength = (int)(Math.random() * 30.0);
        defence =  30 - strength;
        health = STARTING_HP;
        xp = 10;
        this.name = name;
        System.out.println(name + "\n" + "Str: " + strength + "\n" + "Def: " + defence + "\n" + "Hp: " + health + "\n" + "________________________");  
    }
    
    public Mappable(int r, int c){
        currRow = r;
        currCol = c;
    }

    public int getRow(){
        return currRow;
    }
    
    public int getCol(){
        return currCol;
    }
    
    public void setRow(int r){
        currRow = r;
    }
    
    public void setCol(int c){
        currCol = c;
    }

    public abstract String getSymbol();
    public abstract boolean isAttackable();
}