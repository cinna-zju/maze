package Model;

import java.util.ArrayList;

public class Maze {
    private int Xsize;
    private int Ysize;
    private int Type;

    private int MonsterNum;
    private ArrayList<Integer> MonsterPosX;
    private ArrayList<Integer> MonsterPosY;

    private int TreasureNum;
    private ArrayList<Integer> TreasurePosX;
    private ArrayList<Integer> TreasurePosY;

    private int PotionNum;
    private ArrayList<Integer> PotionPosX;
    private ArrayList<Integer> PotionPosY;

    public int getMonsterNum(){return MonsterNum;}
    public int getTreasureNum(){return TreasureNum;}
    public int getPotionNum(){return PotionNum;}

    Maze(int Xsize, int Ysize, int Type){
        this.Xsize = Xsize;
        this.Ysize = Ysize;
        this.Type = Type;
        MonsterNum = 0;
        TreasureNum = 0;
        PotionNum = 0;

        MonsterPosX = new ArrayList<>();
        MonsterPosY = new ArrayList<>();
        TreasurePosX = new ArrayList<>();
        TreasurePosY = new ArrayList<>();
        PotionPosX = new ArrayList<>();
        PotionPosY = new ArrayList<>();
    }

    public void setMonster(int x, int y){
        MonsterPosX.add(x);
        MonsterPosY.add(y);

        MonsterNum++;

    }

    public void setTreasure(int x, int y){
        TreasurePosX.add(x);
        TreasurePosY.add(y);

        TreasureNum++;
    }

    public void setPotion(int x, int y){
        PotionPosX.add(x);
        PotionPosY.add(y);

        PotionNum++;
    }


}
