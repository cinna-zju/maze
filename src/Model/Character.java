package Model;

import Controller.Game;
import javafx.scene.image.Image;

public class Character {
	
	private Integer life, power, defense;
	public int posX;
	public int posY;
	public Image avatar;
	public Image avatarbg;
	public String name;
	public int jumpTimes;

	
	public Character(Integer life, Integer power, String name) {
		this.life = life;
		this.power = power;
		this.name = name;

		jumpTimes = 3;

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
				avatar = new Image("/img/king.png");
				avatarbg = new Image("/img/king_bg.png");
				break;

			}
			case "soldier":{
				avatar = new Image("/img/soldier.png");break;
			}

		}
	}




	// Setters
	public void setLife(Integer value) {
		this.life = value;
		if (value == 2){
            Game.pp.heart3.setDisable(true);
            Game.pp.heart2.setDisable(false);
        }
        if(value == 1){
            Game.pp.heart2.setDisable(true);
            Game.pp.heart1.setDisable(false);
        }
        if(value == 0){
            Game.pp.heart1.setDisable(true);
        }
        if(value == 3){
        	Game.pp.heart3.setDisable(false);
		}
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
