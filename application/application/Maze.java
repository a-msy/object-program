package application;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.scene.input.KeyEvent;

public class Maze extends Application{
	int width = 25;
	
	Image img = new Image("application/frog2.png",20,0,true,true);
	Image img_man = new Image("application/syoumen.png",20,0,true,true);
	Image blank = new Image("application/muji150.png",20,0,true,true);
	View v;
	Scene scene;
	
	int oldx=0;
	int oldy=0;
	
	public static void main(String[] args) {
		launch(args);
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		v =  new View(img,img_man,blank);
		scene = new Scene(v, width*20, width*20);
		primaryStage.setScene(scene);
		primaryStage.show();
		scene.setOnKeyPressed(this::keyPressed);
	}
	
	//キー押し下げを検出
		private void keyPressed(KeyEvent e) {
			System.out.println("pressed:"+e.getCode());
			switch(e.getCode()) {
			case A:
				if(v.wall[v.man.getX()-1][v.man.getY()].isWall == false) {
					System.out.println("canGo");
					v.removeMan(v.man.getX(), v.man.getY());
					oldx = v.man.getX();
					v.man.x = oldx-1;
					v.reSetMan(v.man.x, v.man.y);
				}
				break;
			case D:
				if(v.wall[v.man.getX()+1][v.man.getY()].isWall == false) {
					System.out.println("canGo");
					v.removeMan(v.man.getX(), v.man.getY());
					oldx = v.man.getX();
					v.man.x = oldx+1;
					v.reSetMan(v.man.x, v.man.y);
				}
				break;
			case W:
				if(v.wall[v.man.getX()][v.man.getY()-1].isWall == false) {
					System.out.println("canGo");
					v.removeMan(v.man.getX(), v.man.getY());
					oldy =v.man.getY();
					v.man.y = oldy-1;
					v.reSetMan(v.man.x, v.man.y);
				}
				break;
			case S:
				if(v.wall[v.man.getX()][v.man.getY()+1].isWall == false) {
					System.out.println("canGo");
					v.removeMan(v.man.getX(), v.man.getY());
					oldy =v.man.getY();
					v.man.y = oldy+1;
					v.reSetMan(v.man.x, v.man.y);
				}
				break;
			case Q:
				v.removeMan(v.man.getX(), v.man.getY());
				oldy = v.man.getY();
				oldx = v.man.getX();
				v.man.x = width-2;
				v.man.y = width-2;
				v.reSetMan(width-2,width-2);
				break;
			default:
				break;
			}
			
			if(v.man.getX() == width-2 && v.man.getY() == width-2) {
				System.out.println("GOAL");
				v.showDialog("GOAL");
				v.reView();
			}
		}
}