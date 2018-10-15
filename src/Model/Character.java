package Model;

import javafx.scene.image.Image;

public class Character {
	
	private Integer life, power, defense;
	public int posX;
	public int posY;
	private Image avator;
	
	public Character(Integer life, Integer power, Integer defense) {
		this.life = life;
		this.power = power;
		this.defense = defense;
		posX = 0;
		posY = 0;
		avator = new Image("/img/warrior.png");
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

	public void setAvator(String path){
	    avator = new Image(path);
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
