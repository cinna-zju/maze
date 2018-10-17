package Model;

import javafx.scene.image.Image;

public class Character {
	
	private Integer life, power, defense;
	public int posX;
	public int posY;
	public Image avatar;
	public String name;

	
	public Character(Integer life, Integer power, String name) {
		this.life = life;
		this.power = power;
		this.name = name;
		posX = 0;
		posY = 0;
		switch (this.name){
			case "professor":{
				avatar = new Image("/img/professor.png");break;
			}
			case "warrior":{
				avatar = new Image("/img/warrior.png");break;

			}
			case "king":{
				avatar = new Image("/img/king.png");break;

			}
			case "soldier":{
				avatar = new Image("/img/soldier.png");break;
			}

		}
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
