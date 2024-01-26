
public class Character extends Mappable{
    public static final int STARTING_HP = 40;
    private int strength;
    private int health;
    private int defence;
    private int agility;
    private int range;
    private String name;
    private int xp;

    public Character(String name, int str, int def, int exp, int r, int c, int range, int agil){
        super(r,c);
        name = name;
        strength = str;
        defence = def;
        health = STARTING_HP;
        xp = exp;
        this.range = range;
        this.agility = agil;
    }

    public Character(String name, int r, int c){
        super(r,c);
        strength = (int)(Math.random() * 30.0);
        defence =  30 - strength;
        health = STARTING_HP;
        xp = 10;
        this.name = name;
        System.out.println(name + "\n" + "Str: " + strength + "\n" + "Def: " + defence + "\n" + "Hp: " + health + "\n" + "________________________");  
    }

    public Character(int r, int c){
        super(r,c);
    }

    public String getName(){
        return name;
    } 

    public int getXp(){
        return xp;
    }

    public int getStr(){
        return strength;
    }

    public int getDef(){
        return defence;
    }

    public int getHp(){
        return health;
    }

    public int getRange(){
        return range;
    }

    public int getAgility(){
        return agility;
    }

    public void setName(String id){
        name = id;
    }

    public void setXp(int exp){
        xp = exp;
    }

    public void setHp(int hp){
        health = hp;
    }

    public void setDef(int def){
        defence = def;
    }

    public void setStr(int str){
        strength = str;
    }
    
    public boolean inRange(Character obj){
        if(obj.getRow() > this.getRow() + range || obj.getRow() < this.getRow() - range || obj.getCol() > this.getCol() + range || obj.getCol() < this.getCol() - range){
            return false;
        } else {
            return true;
        }
    }
    
    public void move(String direction, Map room, int spaces){
        if(direction.equalsIgnoreCase("w")){
            for(int i = 0; i < spaces; i++){
                if(room.canMove(this.getRow() - 1, this.getCol())){
                    room.removeObject(this);
                    this.setRow(this.getRow() - 1);
                }
            }
        } else if(direction.equalsIgnoreCase("a")){
            for(int i = 0; i < spaces; i++){
                if(room.canMove(this.getRow(), this.getCol() - 1)){
                    room.removeObject(this);
                    this.setCol(this.getCol() - 1);
                }
            }
        }else if(direction.equalsIgnoreCase("s")){
            for(int i = 0; i < spaces; i++){
                if(room.canMove(this.getRow() + 1, this.getCol())){
                    room.removeObject(this);
                    this.setRow(this.getRow() + 1);
                }
            }
        }else if(direction.equalsIgnoreCase("d")){
            for(int i = 0; i < spaces; i++){
                if(room.canMove(this.getRow(), this.getCol() + 1)){
                    room.removeObject(this);
                    this.setCol(this.getCol() + 1);
                }
            }
        }
        System.out.println('\u000C');
        room.placeObject(this);
        room.printMap();
    }

    @Override
    public String getSymbol() {
        return name.substring(0,1).toUpperCase();
    }

    @Override  
    public boolean isAttackable() {
        return true;
    }

    /** Calculates the damage you inflict on your opponent and decreases their hp as appropriate. This method
     * should also print the results of the attack (your actual attack, their actual defense and new hp).
     * @param: Character opp, the person you will attack
     * Postcondition: the hp of opp will be changed, as appropriate.
     * Postcondition: the hp of opp should never increase based off an attack.
     */
    public void attack(Character opp){
        int newAtk = (int)(Math.random() * strength);
        int newDef = (int)(Math.random() * opp.getDef());
        int opDmg = newAtk - newDef;
        int storeHp = opp.getHp();
        if(opDmg > 0){
            opp.setHp(opp.getHp() - opDmg);
        }
        if(opDmg < 0){
            opDmg = 0;
        }
        System.out.println(this.name +"'s Attack Damage: " + newAtk + "\n" + opp.getName() + "'s Original Health: " + storeHp + "\n" + opp.getName() + "'s Defence: " + newDef + "\n" + "Damage Dealt: " + opDmg + "\n" + opp.getName() +  "'s current health: " + opp.getHp() + "\n" + "________________________");
    }

    public void attackTest(Character opp){
        int newAtk = (int)(Math.random() * strength);
        int newDef = (int)(Math.random() * opp.getDef());
        int opDmg = newAtk - newDef;
        if(opDmg > 0){
            opp.setHp(opp.getHp() - opDmg);
        }
    }

    public void heal(){
        int heal = (int)(Math.random() * (health / 2));
        int hp = (health + heal);
        if(hp < health){
            health = hp;
        }
        System.out.println("You Healed: " + heal + " hp" + "\n" + "__________________________");
    }

    public String toString(){
        return name + "\n" + "STR: " + strength + "\n" + "DEF: " + defence  + "\n" + "HP: " + health + "\n" + "EXP: " + xp + "\n" + "Range: " + range + "\n" + "Agility: " + agility + "\n" + "_______________________";
    }
}
