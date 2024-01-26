
import java.util.Scanner;
public class Game{
    public static final boolean DEBUG = false;
    public static int classCheck = 0;

    public static void main(String[] args){
        MediaFile.setFileName("Save Data");
        Scanner plyrChoice = new Scanner(System.in);

        Map room = new Map();
        String input = "";
        int numInput = 0;
        int level = 0;
        int rounds = 0;

        Character enmy1 = null;
        Character enmy2 = null;
        Character[] foes = new Character[2];

        Character[] heroes = new Character[2];
        Character hero1 = null;
        Character hero2 = null;

        System.out.println("Would you like to load a previous save?(Y/N)");
        input = plyrChoice.next();
        //If a player selects to load a previous save
        if(input.toUpperCase().equals("Y")){
            hero1 = load();
            room.placeObject(hero1);
            heroes[0] = hero1;
            System.out.println("Welcome Back! Your previous stats were: \n" + hero1);

            System.out.println("What class is your teammate? Warrior, Mage, Knight, or Assassin? (W/M/K/A)");
            input = plyrChoice.next();
            //Initializes teammate class based on scanner values 
            if(input.toUpperCase().equals("W")){
                hero2 = new Warrior();
                heroes[1] = hero2;
                hero2.setName("Teammate W");
                hero2.setRow(1+(int)(Math.random() * 13.0));
                hero2.setCol(1+(int)(Math.random() * 13.0));
                room.placeObject(hero2);
            }else if(input.toUpperCase().equals("M")){
                hero2 = new Mage();
                heroes[1] = hero2;
                hero2.setName("Teammate M");
                hero2.setRow(1+(int)(Math.random() * 13.0));
                hero2.setCol(1+(int)(Math.random() * 13.0));
                room.placeObject(hero2);
            }else if(input.toUpperCase().equals("K")){
                hero2 = new Knight();
                heroes[1] = hero2;
                hero2.setName("Teammate K");
                hero2.setRow(1+(int)(Math.random() * 13.0));
                hero2.setCol(1+(int)(Math.random() * 13.0));
                room.placeObject(hero2);
            }else if(input.toUpperCase().equals("A")){
                hero2 = new Assassin();
                heroes[1] = hero2;
                hero2.setName("Teammate A");
                hero2.setRow(1+(int)(Math.random() * 13.0));
                hero2.setCol(1+(int)(Math.random() * 13.0));
                room.placeObject(hero2);
            }
            System.out.println(hero2);
            //Intializes enemy classes based on a random number from 0 - 3
            int enmy1Sel = (int)(Math.random() * 4.0);
            int enmy2Sel = (int)(Math.random() * 4.0);
            if(enmy1Sel == 0){
                enmy1 = new Warrior();
                foes[0] = enmy1;
                enmy1.setRow(1+(int)(Math.random() * 13.0));
                enmy1.setCol(1+(int)(Math.random() * 13.0));
                room.placeObject(enmy1);
            }else if(enmy1Sel == 1){
                enmy1 = new Mage();
                foes[0] = enmy1;
                enmy1.setRow(1+(int)(Math.random() * 13.0));
                enmy1.setCol(1+(int)(Math.random() * 13.0));
                room.placeObject(enmy1);
            }else if(enmy1Sel == 2){
                enmy1 = new Knight();
                foes[0] = enmy1;
                enmy1.setRow(1+(int)(Math.random() * 13.0));
                enmy1.setCol(1+(int)(Math.random() * 13.0));
                room.placeObject(enmy1);
            }else if(enmy1Sel == 3){
                enmy1 = new Assassin();
                foes[0] = enmy1;
                enmy1.setRow(1+(int)(Math.random() * 13.0));
                enmy1.setCol(1+(int)(Math.random() * 13.0));
                room.placeObject(enmy1);
            }

            if(enmy2Sel == 0){
                enmy2 = new Warrior();
                foes[1] = enmy2;
                enmy2.setRow(1+(int)(Math.random() * 13.0));
                enmy2.setCol(1+(int)(Math.random() * 13.0));
                room.placeObject(enmy2);
            }else if(enmy2Sel == 1){
                enmy2 = new Mage();
                foes[1] = enmy2;
                enmy2.setRow(1+(int)(Math.random() * 13.0));
                enmy2.setCol(1+(int)(Math.random() * 13.0));
                room.placeObject(enmy2);
            }else if(enmy2Sel == 2){
                enmy2 = new Knight();
                foes[1] = enmy2;
                enmy2.setRow(1+(int)(Math.random() * 13.0));
                enmy2.setCol(1+(int)(Math.random() * 13.0));
                room.placeObject(enmy2);
            }else if(enmy2Sel == 3){
                enmy2 = new Assassin();
                foes[1] = enmy2;
                enmy2.setRow(1+(int)(Math.random() * 13.0));
                enmy2.setCol(1+(int)(Math.random() * 13.0));
                room.placeObject(enmy2);
            }

            System.out.println('\u000C');
            // Main Gameplay loop for a continued game
            while(hero1.getHp() > 0 || enmy1.getHp() > 0 && enmy2.getHp() > 0 && level >= 5){
                System.out.println("An enemy team approaches!"); 
                room.printMap();
                System.out.println(hero1);
                System.out.println("What will you do? \n" + "1) Attack \n" + "2) Heal \n" + "3) Move \n" + "4) Save \n" +  "_________________________"); 
                numInput = Integer.valueOf(plyrChoice.next());
                if(numInput == 1){
                    if(hero1.inRange(enmy1) || hero1.inRange(enmy2)){
                        if(hero1.inRange(enmy1)){
                            hero1.attack(enmy1);
                        }else if(hero1.inRange(enmy2)){
                            hero1.attack(enmy2);
                        }else {
                            System.out.println("You are not in range.");
                        }
                    }
                    if(enmy1.inRange(hero1) && enmy1.getHp() > 0){
                        enmy1.attack(hero1);
                    } else if(enmy1.inRange(hero2) && enmy1.getHp() > 0){
                        enmy1.attack(hero2);
                    }
                    if(enmy2.inRange(hero1) && enmy2.getHp() > 0){
                        enmy2.attack(hero1);
                    }else if(enmy2.inRange(hero2) && enmy2.getHp() > 0){
                        enmy2.attack(hero2);
                    }
                    if(hero2.inRange(enmy1) && hero2.getHp() > 0){
                        hero2.attack(enmy1);
                    } else if(hero2.inRange(enmy1) && hero2.getHp() > 0){
                        hero2.attack(enmy1);
                    }
                    if(enmy1.getHp() <= 0){
                        room.removeObject(enmy1);
                    }
                    if(hero2.getHp() <= 0){
                        room.removeObject(hero2);
                    }
                    if(enmy2.getHp() <= 0){
                        room.removeObject(enmy2);
                    }
                    rounds ++;
                }else if(numInput == 2){
                    if(enmy1.getHp() > 0 && enmy1.inRange(hero1)){
                        enmy1.attack(hero1);
                    } else if(enmy1.getHp() > 0 && enmy1.inRange(hero2)){
                        enmy1.attack(hero2);
                    } 
                    if(enmy2.getHp() > 0 && enmy2.inRange(hero2)){
                        enmy2.attack(hero2);
                    }else if(enmy2.getHp() > 0 && enmy2.inRange(hero1)){
                        enmy2.attack(hero1);
                    }
                    hero1.heal();
                    hero2.heal();
                    System.out.println(hero1);
                    System.out.println(hero2);
                    rounds ++;
                }else if(numInput == 3){
                    System.out.println("Which direction do you want to move?(W,A,S,D)");
                    String moveInput = plyrChoice.next();
                    if(moveInput.equalsIgnoreCase("W")){
                        System.out.println("You can move up to: " + hero1.getAgility() + " spaces. How many?");
                        int spaces = Integer.valueOf(plyrChoice.next());
                        hero1.move("w",room,spaces);
                    } else if (moveInput.equalsIgnoreCase("A")){
                        System.out.println("You can move up to: " + hero1.getAgility() + " spaces. How many?");
                        int spaces = Integer.valueOf(plyrChoice.next());
                        hero1.move("a",room,spaces);
                    } else if (moveInput.equalsIgnoreCase("S")){
                        System.out.println("You can move up to: " + hero1.getAgility() + " spaces. How many?");
                        int spaces = Integer.valueOf(plyrChoice.next());
                        hero1.move("s",room,spaces);
                    }else if (moveInput.equalsIgnoreCase("D")){
                        System.out.println("You can move up to: " + hero1.getAgility() + " spaces. How many?");
                        int spaces = Integer.valueOf(plyrChoice.next());
                        hero1.move("d",room,spaces);
                    }

                    rounds ++;
                }else if(numInput == 4){
                    saveAndEnd(hero1);
                    break;
                }
                // AI movement
                /*if(hero2.inRange(enmy1) == false || hero2.inRange(enmy2) == false){
                if(hero2.getRow() + hero2.getRange() < enmy1.getRow()){
                hero2.move("w",room,hero2.getAgility());
                } else if(hero2.getRow() + hero2.getRange() > enmy1.getRow()){
                hero2.move("s",room,hero2.getAgility());
                } else if(hero2.getCol() + hero2.getRange() > enmy1.getCol()){
                hero2.move("a",room,hero2.getAgility());
                } else if(hero2.getCol() + hero2.getRange() < enmy1.getCol()){
                hero2.move("d",room,hero2.getAgility());
                } else if(hero2.getRow() + hero2.getRange() < enmy2.getRow()){
                hero2.move("w",room,hero2.getAgility());
                } else if(hero2.getRow() + hero2.getRange() > enmy2.getRow()){
                hero2.move("s",room,hero2.getAgility());
                } else if(hero2.getCol() + hero2.getRange() > enmy2.getCol()){
                hero2.move("a",room,hero2.getAgility());
                } else if(hero2.getCol() + hero2.getRange() < enmy2.getCol()){
                hero2.move("d",room,hero2.getAgility());
                }
                } 
                if(enmy1.inRange(hero1) == false || enmy1.inRange(hero2) == false){
                if(enmy1.getRow() + enmy1.getRange() < hero1.getRow()){
                hero2.move("w",room,hero2.getAgility());
                } else if(enmy1.getRow() + enmy1.getRange() > hero1.getRow()){
                hero2.move("s",room,hero2.getAgility());
                } else if(enmy1.getCol() + enmy1.getRange() > hero1.getCol()){
                hero2.move("a",room,hero2.getAgility());
                } else if(enmy1.getCol() + enmy1.getRange() < hero1.getCol()){
                hero2.move("d",room,hero2.getAgility());
                } else if(enmy1.getRow() + enmy1.getRange() < hero2.getRow()){
                hero2.move("w",room,hero2.getAgility());
                } else if(enmy1.getRow() + enmy1.getRange() > hero2.getRow()){
                hero2.move("s",room,hero2.getAgility());
                } else if(enmy1.getCol() + enmy1.getRange() > hero2.getCol()){
                hero2.move("a",room,hero2.getAgility());
                } else if(enmy1.getCol() + enmy1.getRange() < hero2.getCol()){
                hero2.move("d",room,hero2.getAgility());
                }
                } 
                if(enmy2.inRange(hero1) == false || enmy2.inRange(hero2) == false){
                if(enmy2.getRow() + enmy2.getRange() < hero1.getRow()){
                hero2.move("w",room,hero2.getAgility());
                } else if(enmy2.getRow() + enmy2.getRange() > hero1.getRow()){
                hero2.move("s",room,hero2.getAgility());
                } else if(enmy2.getCol() + enmy2.getRange() > hero1.getCol()){
                hero2.move("a",room,hero2.getAgility());
                } else if(enmy2.getCol() + enmy2.getRange() < hero1.getCol()){
                hero2.move("d",room,hero2.getAgility());
                } else if(enmy2.getRow() + enmy2.getRange() < hero2.getRow()){
                hero2.move("w",room,hero2.getAgility());
                } else if(enmy2.getRow() + enmy2.getRange() > hero2.getRow()){
                hero2.move("s",room,hero2.getAgility());
                } else if(enmy2.getCol() + enmy2.getRange() > hero2.getCol()){
                hero2.move("a",room,hero2.getAgility());
                } else if(enmy2.getCol() + enmy2.getRange() < hero2.getCol()){
                hero2.move("d",room,hero2.getAgility());
                }
                } */

                //Experience gain if enemies loose 
                if(enmy1.getHp() <= 0 && enmy2.getHp() <= 0){
                    System.out.println("GAME OVER " + hero1.getName() + " Won" + "\n" + "__________________________");
                    int exp = hero1.getXp() * rounds * 2; 
                    System.out.println("You gained " + exp + " expericence!" + "\n" + "___________________________");
                    while(exp >= 10){
                        System.out.println("What stat would you like to invest in? \n" + "1) Strength \n" + "2) Defence \n"+ "3) Health \n" +"______________________");
                        numInput = Integer.valueOf(plyrChoice.next());
                        if(numInput == 1){
                            hero1.setStr(hero1.getStr() + 10);
                            exp -= 10;
                            hero1.setXp(exp);
                            System.out.println("Your new Stats are: " + hero1);
                        } else if (numInput == 2){
                            hero1.setDef(hero1.getDef() + 10);
                            exp -= 10;
                            hero1.setXp(exp);
                            System.out.println("Your new Stats are: " + hero1);
                        } else if (numInput == 3){
                            hero1.setHp(hero1.getHp() + 10);
                            exp -= 10;
                            hero1.setXp(exp);
                            System.out.println("Your new Stats are: " + hero1);
                        } 
                    } 
                    enmy1Sel = 0;
                    enmy2Sel = 0;
                    enmy1Sel = (int)(Math.random() * 4.0);
                    enmy2Sel = (int)(Math.random() * 4.0);
                    if(enmy1Sel == 0){
                        enmy1 = new Warrior();
                        foes[0] = enmy1;
                        enmy1.setRow(1+(int)(Math.random() * 13.0));
                        enmy1.setCol(1+(int)(Math.random() * 13.0));
                        room.placeObject(enmy1);
                    }else if(enmy1Sel == 1){
                        enmy1 = new Mage();
                        foes[0] = enmy1;
                        enmy1.setRow(1+(int)(Math.random() * 13.0));
                        enmy1.setCol(1+(int)(Math.random() * 13.0));
                        room.placeObject(enmy1);
                    }else if(enmy1Sel == 2){
                        enmy1 = new Knight();
                        foes[0] = enmy1;
                        enmy1.setRow(1+(int)(Math.random() * 13.0));
                        enmy1.setCol(1+(int)(Math.random() * 13.0));
                        room.placeObject(enmy1);
                    }else if(enmy1Sel == 3){
                        enmy1 = new Assassin();
                        foes[0] = enmy1;
                        enmy1.setRow(1+(int)(Math.random() * 13.0));
                        enmy1.setCol(1+(int)(Math.random() * 13.0));
                        room.placeObject(enmy1);
                    }

                    if(enmy2Sel == 0){
                        enmy2 = new Warrior();
                        foes[1] = enmy2;
                        enmy2.setRow(1+(int)(Math.random() * 13.0));
                        enmy2.setCol(1+(int)(Math.random() * 13.0));
                        room.placeObject(enmy2);
                    }else if(enmy2Sel == 1){
                        enmy2 = new Mage();
                        foes[1] = enmy2;
                        enmy2.setRow(1+(int)(Math.random() * 13.0));
                        enmy2.setCol(1+(int)(Math.random() * 13.0));
                        room.placeObject(enmy2);
                    }else if(enmy2Sel == 2){
                        enmy2 = new Knight();
                        foes[1] = enmy2;
                        enmy2.setRow(1+(int)(Math.random() * 13.0));
                        enmy2.setCol(1+(int)(Math.random() * 13.0));
                        room.placeObject(enmy2);
                    }else if(enmy2Sel == 3){
                        enmy2 = new Assassin();
                        foes[1] = enmy2;
                        enmy2.setRow(1+(int)(Math.random() * 13.0));
                        enmy2.setCol(1+(int)(Math.random() * 13.0));
                        room.placeObject(enmy2);
                    }
                    level ++;
                }
                if(hero1.getHp() <= 0){
                    System.out.println("GAME OVER! The enemy team won!");
                    break;
                }
            }
        }else if(input.toUpperCase().equals("Y") && MediaFile.readString() == null){
            System.out.println("There are no availible save files.");
            //If player decides to start a new game
        }else if(input.toUpperCase().equals("N")){
            System.out.println("What class are you? Warrior, Mage, Knight, or Assassin?(W/M/K/A)");
            input = plyrChoice.next();
            if(input.toUpperCase().equals("W")){
                hero1 = new Warrior();
                heroes[0] = hero1; 
                classCheck = 1;
                hero1.setRow(1+(int)(Math.random() * 13.0));
                hero1.setCol(1+(int)(Math.random() * 13.0));
                room.placeObject(hero1);
            }else if(input.toUpperCase().equals("M")){
                hero1 = new Mage();
                heroes[0] = hero1;
                classCheck = 2;
                hero1.setRow(1+(int)(Math.random() * 13.0));
                hero1.setCol(1+(int)(Math.random() * 13.0));
                room.placeObject(hero1);
            }else if(input.toUpperCase().equals("K")){
                hero1 = new Knight();
                heroes[0] = hero1;
                classCheck = 3;
                hero1.setRow(1+(int)(Math.random() * 13.0));
                hero1.setCol(1+(int)(Math.random() * 13.0));
                room.placeObject(hero1);
            }else if(input.toUpperCase().equals("A")){
                hero1 = new Assassin();
                heroes[0] = hero1;
                classCheck = 4;
                hero1.setRow(1+(int)(Math.random() * 13.0));
                hero1.setCol(1+(int)(Math.random() * 13.0));
                room.placeObject(hero1);
            }
            System.out.println(hero1);
            System.out.println("What is your character's name?");
            input = plyrChoice.next();
            hero1.setName(input);

            System.out.println("What class is your teammate? Warrior, Mage, Knight, or Assassin? (W/M/K/A)");
            input = plyrChoice.next();
            if(input.toUpperCase().equals("W")){
                hero2 = new Warrior();
                heroes[1] = hero2;
                hero2.setName("TeammateW");
                hero2.setRow(1+(int)(Math.random() * 13.0));
                hero2.setCol(1+(int)(Math.random() * 13.0));
                room.placeObject(hero2);
            }else if(input.toUpperCase().equals("M")){
                hero2 = new Mage();
                heroes[1] = hero2;
                hero2.setName("TeammateM");
                hero2.setRow(1+(int)(Math.random() * 13.0));
                hero2.setCol(1+(int)(Math.random() * 13.0));
                room.placeObject(hero2);
            }else if(input.toUpperCase().equals("K")){
                hero2 = new Knight();
                heroes[1] = hero2;
                hero2.setName("TeammateK");
                hero2.setRow(1+(int)(Math.random() * 13.0));
                hero2.setCol(1+(int)(Math.random() * 13.0));
                room.placeObject(hero2);
            }else if(input.toUpperCase().equals("A")){
                hero2 = new Assassin();
                heroes[1] = hero2;
                hero2.setName("TeammateA");
                hero2.setRow(1+(int)(Math.random() * 13.0));
                hero2.setCol(1+(int)(Math.random() * 13.0));
                room.placeObject(hero2);
            }
            System.out.println(hero2);

            int enmy1Sel = (int)(Math.random() * 4.0);
            int enmy2Sel = (int)(Math.random() * 4.0);
            if(enmy1Sel == 0){
                enmy1 = new Warrior();
                foes[0] = enmy1;
                enmy1.setRow(1+(int)(Math.random() * 13.0));
                enmy1.setCol(1+(int)(Math.random() * 13.0));
                room.placeObject(enmy1);
            }else if(enmy1Sel == 1){
                enmy1 = new Mage();
                foes[0] = enmy1;
                enmy1.setRow(1+(int)(Math.random() * 13.0));
                enmy1.setCol(1+(int)(Math.random() * 13.0));
                room.placeObject(enmy1);
            }else if(enmy1Sel == 2){
                enmy1 = new Knight();
                foes[0] = enmy1;
                enmy1.setRow(1+(int)(Math.random() * 13.0));
                enmy1.setCol(1+(int)(Math.random() * 13.0));
                room.placeObject(enmy1);
            }else if(enmy1Sel == 3){
                enmy1 = new Assassin();
                foes[0] = enmy1;
                enmy1.setRow(1+(int)(Math.random() * 13.0));
                enmy1.setCol(1+(int)(Math.random() * 13.0));
                room.placeObject(enmy1);
            }

            if(enmy2Sel == 0){
                enmy2 = new Warrior();
                foes[1] = enmy2;
                enmy2.setRow(1+(int)(Math.random() * 13.0));
                enmy2.setCol(1+(int)(Math.random() * 13.0));
                room.placeObject(enmy2);
            }else if(enmy2Sel == 1){
                enmy2 = new Mage();
                foes[1] = enmy2;
                enmy2.setRow(1+(int)(Math.random() * 13.0));
                enmy2.setCol(1+(int)(Math.random() * 13.0));
                room.placeObject(enmy2);
            }else if(enmy2Sel == 2){
                enmy2 = new Knight();
                foes[1] = enmy2;
                enmy2.setRow(1+(int)(Math.random() * 13.0));
                enmy2.setCol(1+(int)(Math.random() * 13.0));
                room.placeObject(enmy2);
            }else if(enmy2Sel == 3){
                enmy2 = new Assassin();
                foes[1] = enmy2;
                enmy2.setRow(1+(int)(Math.random() * 13.0));
                enmy2.setCol(1+(int)(Math.random() * 13.0));
                room.placeObject(enmy2);
            }

            System.out.println('\u000C');
            //Main Gameplay loop for New Game
            while(hero1.getHp() > 0 || enmy1.getHp() > 0 && enmy2.getHp() > 0 && level >= 5){
                System.out.println("An enemy team approaches!"); 
                room.printMap();
                System.out.println(hero1);
                System.out.println("What will you do? \n" + "1) Attack \n" + "2) Heal \n" + "3) Move \n" + "4) Save \n" +  "_________________________"); 
                numInput = Integer.valueOf(plyrChoice.next());
                if(numInput == 1){
                    if(hero1.inRange(enmy1) || hero1.inRange(enmy2)){
                        if(hero1.inRange(enmy1)){
                            hero1.attack(enmy1);
                        }else if(hero1.inRange(enmy2)){
                            hero1.attack(enmy2);
                        }else {
                            System.out.println("You are not in range.");
                        }
                    }
                    if(enmy1.inRange(hero1) && enmy1.getHp() > 0){
                        enmy1.attack(hero1);
                    } else if(enmy1.inRange(hero2) && enmy1.getHp() > 0){
                        enmy1.attack(hero2);
                    }
                    if(enmy2.inRange(hero1) && enmy2.getHp() > 0){
                        enmy2.attack(hero1);
                    }else if(enmy2.inRange(hero2) && enmy2.getHp() > 0){
                        enmy2.attack(hero2);
                    }
                    if(hero2.inRange(enmy1) && hero2.getHp() > 0){
                        hero2.attack(enmy1);
                    } else if(hero2.inRange(enmy1) && hero2.getHp() > 0){
                        hero2.attack(enmy1);
                    }
                    if(enmy1.getHp() <= 0){
                        room.removeObject(enmy1);
                    }
                    if(hero2.getHp() <= 0){
                        room.removeObject(hero2);
                    }
                    if(enmy2.getHp() <= 0){
                        room.removeObject(enmy2);
                    }
                    rounds ++;
                }else if(numInput == 2){
                    if(enmy1.getHp() > 0 && enmy1.inRange(hero1)){
                        enmy1.attack(hero1);
                    } else if(enmy1.getHp() > 0 && enmy1.inRange(hero2)){
                        enmy1.attack(hero2);
                    } 
                    if(enmy2.getHp() > 0 && enmy2.inRange(hero2)){
                        enmy2.attack(hero2);
                    }else if(enmy2.getHp() > 0 && enmy2.inRange(hero1)){
                        enmy2.attack(hero1);
                    }
                    hero1.heal();
                    hero2.heal();
                    System.out.println(hero1);
                    System.out.println(hero2);
                    rounds ++;
                }else if(numInput == 3){
                    System.out.println("Which direction do you want to move?(W,A,S,D)");
                    String moveInput = plyrChoice.next();
                    if(moveInput.equalsIgnoreCase("W")){
                        System.out.println("You can move up to: " + hero1.getAgility() + " spaces. How many?");
                        int spaces = Integer.valueOf(plyrChoice.next());
                        hero1.move("w",room,spaces);
                    } else if (moveInput.equalsIgnoreCase("A")){
                        System.out.println("You can move up to: " + hero1.getAgility() + " spaces. How many?");
                        int spaces = Integer.valueOf(plyrChoice.next());
                        hero1.move("a",room,spaces);
                    } else if (moveInput.equalsIgnoreCase("S")){
                        System.out.println("You can move up to: " + hero1.getAgility() + " spaces. How many?");
                        int spaces = Integer.valueOf(plyrChoice.next());
                        hero1.move("s",room,spaces);
                    }else if (moveInput.equalsIgnoreCase("D")){
                        System.out.println("You can move up to: " + hero1.getAgility() + " spaces. How many?");
                        int spaces = Integer.valueOf(plyrChoice.next());
                        hero1.move("d",room,spaces);
                    }

                    rounds ++;
                }else if(numInput == 4){
                    saveAndEnd(hero1);
                    break;
                }
                // AI movement
                /*if(hero2.inRange(enmy1) == false || hero2.inRange(enmy2) == false){
                if(hero2.getRow() + hero2.getRange() < enmy1.getRow()){
                hero2.move("w",room,hero2.getAgility());
                } else if(hero2.getRow() + hero2.getRange() > enmy1.getRow()){
                hero2.move("s",room,hero2.getAgility());
                } else if(hero2.getCol() + hero2.getRange() > enmy1.getCol()){
                hero2.move("a",room,hero2.getAgility());
                } else if(hero2.getCol() + hero2.getRange() < enmy1.getCol()){
                hero2.move("d",room,hero2.getAgility());
                } else if(hero2.getRow() + hero2.getRange() < enmy2.getRow()){
                hero2.move("w",room,hero2.getAgility());
                } else if(hero2.getRow() + hero2.getRange() > enmy2.getRow()){
                hero2.move("s",room,hero2.getAgility());
                } else if(hero2.getCol() + hero2.getRange() > enmy2.getCol()){
                hero2.move("a",room,hero2.getAgility());
                } else if(hero2.getCol() + hero2.getRange() < enmy2.getCol()){
                hero2.move("d",room,hero2.getAgility());
                }
                } 
                if(enmy1.inRange(hero1) == false || enmy1.inRange(hero2) == false){
                if(enmy1.getRow() + enmy1.getRange() < hero1.getRow()){
                hero2.move("w",room,hero2.getAgility());
                } else if(enmy1.getRow() + enmy1.getRange() > hero1.getRow()){
                hero2.move("s",room,hero2.getAgility());
                } else if(enmy1.getCol() + enmy1.getRange() > hero1.getCol()){
                hero2.move("a",room,hero2.getAgility());
                } else if(enmy1.getCol() + enmy1.getRange() < hero1.getCol()){
                hero2.move("d",room,hero2.getAgility());
                } else if(enmy1.getRow() + enmy1.getRange() < hero2.getRow()){
                hero2.move("w",room,hero2.getAgility());
                } else if(enmy1.getRow() + enmy1.getRange() > hero2.getRow()){
                hero2.move("s",room,hero2.getAgility());
                } else if(enmy1.getCol() + enmy1.getRange() > hero2.getCol()){
                hero2.move("a",room,hero2.getAgility());
                } else if(enmy1.getCol() + enmy1.getRange() < hero2.getCol()){
                hero2.move("d",room,hero2.getAgility());
                }
                } 
                if(enmy2.inRange(hero1) == false || enmy2.inRange(hero2) == false){
                if(enmy2.getRow() + enmy2.getRange() < hero1.getRow()){
                hero2.move("w",room,hero2.getAgility());
                } else if(enmy2.getRow() + enmy2.getRange() > hero1.getRow()){
                hero2.move("s",room,hero2.getAgility());
                } else if(enmy2.getCol() + enmy2.getRange() > hero1.getCol()){
                hero2.move("a",room,hero2.getAgility());
                } else if(enmy2.getCol() + enmy2.getRange() < hero1.getCol()){
                hero2.move("d",room,hero2.getAgility());
                } else if(enmy2.getRow() + enmy2.getRange() < hero2.getRow()){
                hero2.move("w",room,hero2.getAgility());
                } else if(enmy2.getRow() + enmy2.getRange() > hero2.getRow()){
                hero2.move("s",room,hero2.getAgility());
                } else if(enmy2.getCol() + enmy2.getRange() > hero2.getCol()){
                hero2.move("a",room,hero2.getAgility());
                } else if(enmy2.getCol() + enmy2.getRange() < hero2.getCol()){
                hero2.move("d",room,hero2.getAgility());
                }
                } */

                //Experience gain if enemies loose 
                if(enmy1.getHp() <= 0 && enmy2.getHp() <= 0){
                    System.out.println("GAME OVER " + hero1.getName() + " Won" + "\n" + "__________________________");
                    int exp = hero1.getXp() * rounds * 2; 
                    System.out.println("You gained " + exp + " expericence!" + "\n" + "___________________________");
                    while(exp >= 10){
                        System.out.println("What stat would you like to invest in? \n" + "1) Strength \n" + "2) Defence \n"+ "3) Health \n" +"______________________");
                        numInput = Integer.valueOf(plyrChoice.next());
                        if(numInput == 1){
                            hero1.setStr(hero1.getStr() + 10);
                            exp -= 10;
                            hero1.setXp(exp);
                            System.out.println("Your new Stats are: " + hero1);
                        } else if (numInput == 2){
                            hero1.setDef(hero1.getDef() + 10);
                            exp -= 10;
                            hero1.setXp(exp);
                            System.out.println("Your new Stats are: " + hero1);
                        } else if (numInput == 3){
                            hero1.setHp(hero1.getHp() + 10);
                            exp -= 10;
                            hero1.setXp(exp);
                            System.out.println("Your new Stats are: " + hero1);
                        } 
                    } 
                    enmy1Sel = 0;
                    enmy2Sel = 0;
                    enmy1Sel = (int)(Math.random() * 4.0);
                    enmy2Sel = (int)(Math.random() * 4.0);
                    if(enmy1Sel == 0){
                        enmy1 = new Warrior();
                        foes[0] = enmy1;
                        enmy1.setRow(1+(int)(Math.random() * 13.0));
                        enmy1.setCol(1+(int)(Math.random() * 13.0));
                        room.placeObject(enmy1);
                    }else if(enmy1Sel == 1){
                        enmy1 = new Mage();
                        foes[0] = enmy1;
                        enmy1.setRow(1+(int)(Math.random() * 13.0));
                        enmy1.setCol(1+(int)(Math.random() * 13.0));
                        room.placeObject(enmy1);
                    }else if(enmy1Sel == 2){
                        enmy1 = new Knight();
                        foes[0] = enmy1;
                        enmy1.setRow(1+(int)(Math.random() * 13.0));
                        enmy1.setCol(1+(int)(Math.random() * 13.0));
                        room.placeObject(enmy1);
                    }else if(enmy1Sel == 3){
                        enmy1 = new Assassin();
                        foes[0] = enmy1;
                        enmy1.setRow(1+(int)(Math.random() * 13.0));
                        enmy1.setCol(1+(int)(Math.random() * 13.0));
                        room.placeObject(enmy1);
                    }

                    if(enmy2Sel == 0){
                        enmy2 = new Warrior();
                        foes[1] = enmy2;
                        enmy2.setRow(1+(int)(Math.random() * 13.0));
                        enmy2.setCol(1+(int)(Math.random() * 13.0));
                        room.placeObject(enmy2);
                    }else if(enmy2Sel == 1){
                        enmy2 = new Mage();
                        foes[1] = enmy2;
                        enmy2.setRow(1+(int)(Math.random() * 13.0));
                        enmy2.setCol(1+(int)(Math.random() * 13.0));
                        room.placeObject(enmy2);
                    }else if(enmy2Sel == 2){
                        enmy2 = new Knight();
                        foes[1] = enmy2;
                        enmy2.setRow(1+(int)(Math.random() * 13.0));
                        enmy2.setCol(1+(int)(Math.random() * 13.0));
                        room.placeObject(enmy2);
                    }else if(enmy2Sel == 3){
                        enmy2 = new Assassin();
                        foes[1] = enmy2;
                        enmy2.setRow(1+(int)(Math.random() * 13.0));
                        enmy2.setCol(1+(int)(Math.random() * 13.0));
                        room.placeObject(enmy2);
                    }
                    level++;
                }

                if(hero1.getHp() <= 0){
                    System.out.println("GAME OVER! The enemy team won!");
                    break;
                }

            }
        }
    }

    /** Saves current charater data fields into a text file called "Save Data"
     * @param: plyr is the character being saved 
     */
    public static void saveAndEnd(Character plyr){
        MediaFile.setFileName("Save Data");
        MediaFile.writeString("@" + plyr.getName() + "|" + "#" + plyr.getStr() + "|" + "*" + plyr.getDef() + "|" + "&" + plyr.getHp() + "|" + "$" + classCheck + "|" + "~" + plyr.getXp() + "|" + "^" + plyr.getRow() + "|" + "`" + plyr.getCol() + "|" + "<" + plyr.getRange() + "|" + ">" + plyr.getAgility());
        MediaFile.saveAndClose();
    }

    /** Loads previously saved text files named "Save Data"
     * Uses MediaFile class and methods
     */
    public static Character load(){
        MediaFile.setFileName("Save Data");
        String info = MediaFile.readString();
        Character plyr = null;
        String id = "";
        int str = 0;
        int def = 0;
        int hp = 0;
        int clss = 0;
        int exp = 0;
        int row = 0;
        int col = 0;
        int range = 0;
        int agil = 0;

        while(info != null){
            int pipe = info.indexOf("|");
            if(info.substring(0,pipe).indexOf("@") >= 0){
                id = info.substring(1, pipe);
            } else if(info.substring(0,pipe).indexOf("#") >= 0){
                str = Integer.valueOf(info.substring(1, pipe));
            }else if(info.substring(0,pipe).indexOf("*") >= 0){
                def = Integer.valueOf(info.substring(1, pipe));
            }else if(info.substring(0,pipe).indexOf("&") >= 0){
                hp = Integer.valueOf(info.substring(1, pipe));
            }else if(info.substring(0,pipe).indexOf("$") >= 0){
                clss = Integer.valueOf(info.substring(1, pipe));
            }else if(info.substring(0,pipe).indexOf("~") >= 0){
                exp = Integer.valueOf(info.substring(1, pipe));
            }else if(info.substring(0,pipe).indexOf("^") >= 0){
                row = Integer.valueOf(info.substring(1, pipe));
            }else if(info.substring(0,pipe).indexOf("`") >= 0){
                col = Integer.valueOf(info.substring(1, pipe));
            }else if(info.substring(0,pipe).indexOf("<") >= 0){
                range = Integer.valueOf(info.substring(1, pipe));
            }else if(info.substring(0,pipe).indexOf(">") >= 0){
                agil = Integer.valueOf(info.substring(1, pipe));
                break;
            }
            info = info.substring(pipe + 1);
        }

        plyr = new Warrior();
        if(clss == 1){
            plyr = new Warrior();
        }else if(clss == 2){
            plyr = new Mage();
        }else if(clss == 3){
            plyr = new Knight();
        }else if(clss == 4){
            plyr = new Assassin();
        }

        plyr.setName(id);
        plyr.setStr(str);
        plyr.setDef(def);
        plyr.setHp(hp);
        plyr.setXp(exp);
        plyr.setRow(row);
        plyr.setCol(col);
        return plyr;
    }

    public static void simulation(){
        Character hero = new Knight();
        Character foe = new Mage();
        int wins = 0;
        int losses = 0;
        int rounds = 0;
        int matches = 0;
        int tests = 100;
        for(int i = 0; i < tests; i++){
            while(hero.getHp() > 0 || foe.getHp() > 0){
                hero.attackTest(foe);
                if(hero.getHp() <= 0 || foe.getHp() <= 0   ){
                    break; 
                }
                foe.attackTest(hero);
                if(hero.getHp() <= 0 || foe.getHp() <= 0   ){
                    break; 
                }
                rounds ++;
            }
            matches += rounds;
            if(hero.getHp() <= 0){
                losses++;
                System.out.println("-------------------------");
                System.out.println("Loss in " + rounds + " rounds");
                hero.setHp(Character.STARTING_HP);
                foe.setHp(Character.STARTING_HP);
                rounds = 0;
            } else if(foe.getHp() <= 0){
                wins++;
                System.out.println("-------------------------");
                System.out.println("Won in " + rounds + " rounds");
                hero.setHp(Character.STARTING_HP);
                foe.setHp(Character.STARTING_HP);
                rounds = 0;
            }
        }

        System.out.println("_________________Results_________________" + "yaay");
        System.out.println("Wins: " + wins);
        System.out.println("Losses: " + losses);
        System.out.println("Win Percentage: " + (double)(wins * tests) / 100 + "%");
        System.out.println("Average amount of rounds: " + ((double)matches/tests));
    }
}
 