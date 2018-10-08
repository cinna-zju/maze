package Model;

public class Monster {
    private int ATK;
    private int HP;

    Monster(int HP, int ATK){this.HP = HP; this.ATK = ATK;}

    public int getATK(){return ATK;}
    public int getHP(){return HP;}

}
