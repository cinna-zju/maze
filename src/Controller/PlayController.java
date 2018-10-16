package Controller;


import Model.Maze;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

public class PlayController {
    
    private Maze mazeData;
    
    public PlayController(Maze mazeSrc){
        mazeData = mazeSrc;
    }
    
    public void handle(KeyEvent e) {

        //play.handle(event, ch);
        if(e.getCode() == KeyCode.W){
            checkAndMove(0, -1);

        }
        if(e.getCode()== KeyCode.A){
            checkAndMove(-1, 0);
        }
        if(e.getCode()== KeyCode.S){
            checkAndMove(0, 1);
        }
        if(e.getCode()== KeyCode.D){
            checkAndMove(1, 0);
        }
        
    }

    private void checkAndMove(int dx, int dy){
        int x = mazeData.ch.posX+dx;
        int y = mazeData.ch.posY+dy;
        if( x < 0 || x >= mazeData.size || y < 0 || y >= mazeData.size) return;
        if(mazeData.grid[y][x].getId() != null) return;

        mazeData.grid[mazeData.ch.posY][mazeData.ch.posX].setGraphic(null);

        mazeData.ch.posX = x;
        mazeData.ch.posY = y;
//        System.out.println(x+" "+y);

    }


    
}
