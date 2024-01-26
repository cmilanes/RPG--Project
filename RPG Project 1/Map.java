
public class Map {
    private Mappable[][] grid;
    public Map(){
        MediaFile.setFileName("Map");
        String columns = MediaFile.readString();
        String rows = MediaFile.readString();
        grid = new Mappable[Integer.valueOf(rows)][Integer.valueOf(columns)];

        for(int r = 0; r < grid.length; r++){
            String info  = MediaFile.readString();
            String[] line = info.split(" ");
            for(int c = 0; c < grid[r].length; c++){
                if(Integer.valueOf(line[c]) == 1){
                    grid[r][c] = new Wall(r, c);
                }else if(Integer.valueOf(line[c]) == 2){
                    grid[r][c] = new Character(r,c);
                }
            }
        } 
    }

    public void placeObject(Mappable toPlace) {
        grid[toPlace.getRow()][toPlace.getCol()] = toPlace;
    }

    public void printMap() {
        System.out.println();
        for(int r = 0; r < grid.length; r++){
            for(int c = 0; c < grid[r].length; c++){
                if(grid[r][c] != null){
                    System.out.print(" " + grid[r][c].getSymbol());
                } else {
                    System.out.print(" -");
                }
            }
            System.out.println();
        }
    }

    public boolean canMove(int r, int c){
        if(grid[r][c] != null){
            return false;
        } else {
            return true;
        }
    }

    public void removeObject(Mappable orgPos){
        grid[orgPos.getRow()][orgPos.getCol()] = null;
    }

    public static void main(String args[]){
        Map room = new Map();
        room.printMap();
    }
}