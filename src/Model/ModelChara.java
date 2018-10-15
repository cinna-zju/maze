package Model;

public class ModelChara {
	
	private Integer life, power, defense;
	
	public ModelChara(Integer life, Integer power, Integer defense) {
		this.life = life;
		this.power = power;
		this.defense = defense;
	}
	// Setters
	public void setLife(Integer value) {
		this.life = value;
	}
	
	public void setPower(Integer value) {
		this.power = value;
	}
	
	public void setDefense(Integer value) {
		this.defense = value;
	}
	
	//Getters
	public Integer getLife() {
		return life;
	}
	
	public Integer getPower() {
		return power;
	}
	
	public Integer getDefense() {
		return defense;
	}
}
