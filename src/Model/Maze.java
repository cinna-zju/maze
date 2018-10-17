package Model;



public class Maze {
    public int size;

    public Character ch;
    public String[][] src;

    private int MonsterNum;
    private int TreasureNum;
    private int PotionNum;


    public int getMonsterNum(){return MonsterNum;}
    public int getTreasureNum(){return TreasureNum;}
    public int getPotionNum(){return PotionNum;}

    public int[][] isOpen = {
            {1,1,1,1,1,1,1,1},
            {1,1,1,1,1,1,1,1},
            {1,0,1,1,0,1,0,0},
            {1,0,1,1,0,1,1,1},
            {1,0,1,1,0,1,0,0},
            {1,0,1,1,0,1,1,1},
            {1,0,1,1,0,1,1,1},
            {1,1,0,0,1,1,1,1},
    };



    public Maze(){
        size = 8;
        src = new String[size][size];
        ch = new Character(3,1,"");
    }





}
