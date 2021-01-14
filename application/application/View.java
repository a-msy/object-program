package application;

import javafx.scene.Group;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;

class View extends Group{
	int width = 25;
	int FrogWidth=20;
	int loopX=0; 
	int loopY=0;
	int dx[] = {0, 1, 0, -1};
	int dy[] = {1, 0, -1, 0};
	
	ImageView view[][] = new ImageView[width][width];
	Wall wall[][] = new Wall[width][width];
	Man man;
	Image img_man;
	Image blank;
	Image img;
	
	public View(Image img,Image img_man, Image blank) {
		this.blank = blank;
		this.img_man = img_man;
		this.img = img;
		this.initialize();
		this.setWall();
		this.makeMaze();
		this.setImage();
		this.setSG();
		this.initializeMan(1, 1);
	}
	
	public void initialize() {
		for (int i = 0 ; i < width ; i++){
		      for (int j = 0 ; j < width ; j++){
		    	  wall[i][j] = new Wall(false,i,j,0);
		      }
		}
		System.out.println("initialize Done");
	}
	public void setWall() {
		for (int i = 0 ; i < width ; i++){
			wall[0][i].isWall = true;
			wall[width-1][i].isWall = true;
			wall[i][0].isWall = true;
			wall[i][width-1].isWall = true;
		  }
		System.out.println("SetWall Done");
	}
	
	public void makeMaze() {
		/*　棒倒し法　*/
				/* 基準点をセット */
	    for (int i = 0 ; i < (width/2) ; i++){
	      for (int j = 0 ; j < (width/2); j++){
	        wall[i * 2][j * 2].isWall = true;
	      }
	    }
	    /* 基準点をセット */
	    
	    /* 迷路作成 */
	    for (int i = 1 ; i <(width/2); i++){
	      for (int j = 1 ; j <(width/2); j++){
	        if (i == 1){
	          int d = (int)(Math.random() * 4);
	          wall[i * 2 + dx[d]][j * 2 + dy[d]].isWall=true;
	        }else{
	          boolean flag = true;
	          while(flag){
	            int d = (int)(Math.random() * 3);
	            if (wall[i * 2 + dx[d]][j * 2 + dy[d]].isWall() == false){
	              wall[i * 2 + dx[d]][j * 2 + dy[d]].isWall = true;
	              flag = false;
	            }
	          }
	        }
	      }
	    }
	    System.out.println("makeMaze Done");
	}
	
	public void initializeMan(int x, int y) {
		man = new Man(x,y);
		view[x][y].setImage(img_man);
		System.out.println("initializeMan Done");
	}
	
	public void removeMan(int x, int y) {
		view[x][y].setImage(blank);
	}
	
	public void reSetMan(int x, int y) {
		view[x][y].setImage(img_man);
	}
	
	public void showDialog(String str) {
		Alert dialog = new Alert(AlertType.INFORMATION);
		dialog.setHeaderText(null);
		dialog.setContentText(str);
		dialog.showAndWait();
	}
	
	public void setImage() {
		  /* 迷路作成 */
	    for (int i = 0 ; i < width ; i++){
		      for (int j = 0 ; j < width ; j++){
		    	  //すべて白で埋める
		    	  view[i][j] = new ImageView(blank);
		  		  view[i][j].setX(i*FrogWidth);
		  		  view[i][j].setY(j*FrogWidth);
		  		  getChildren().add(view[i][j]);
		  			
		    	  if(wall[i][j].isWall() == true) {
		  			view[i][j].setImage(img);
		    	  }
		      }
		}
	    System.out.println("setImage Done");
	}
	
	public void setSG() {
		wall[1][1].role=1;
		wall[width-2][width-2].role=2;
		view[width-2][width-2].setImage(new Image("application/doron.png",20,0,true,true));
		System.out.println("setSG Done");
	}
	
	public void reView() {
		for (int i = 0 ; i < width ; i++){
		      for (int j = 0 ; j < width ; j++){
		    	  getChildren().remove(view[i][j]);
		      }
		 }
		this.initialize();
		this.setWall();
		this.makeMaze();
		this.setImage();
		this.setSG();
		this.initializeMan(1, 1);
	}
}
