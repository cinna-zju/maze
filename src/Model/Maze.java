package Model;

public class Maze {
    private int Xsize;
    private int Ysize;
    private int TYPE;

    private int MonsterNum;
    private int[] MonsterPosX;
    private int[] MonsterPosY;

    private int TreasureNum;
    private int[] TreasurePosX;
    private int[] TreasurePosY;

    private int PotionNum;
    private int[] PotionPosX;
    private int[] PotionPosY;

    public int getMonsterNum(){return MonsterNum;}
    public int getTreasureNum(){return TreasureNum;}
    public int getPotionNum(){return PotionNum;}


}
