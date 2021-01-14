package kadai;
import javafx.scene.input.MouseEvent;

public class MyTurtleFrame extends TurtleFrame {        
    /** TurtleFrame を、デフォルトの大きさ(400x400) で作成する。 */
    public MyTurtleFrame(double width, double height) {
    	System.out.println("MyTurtleFrame\n");
    	 rootgroup.setOnMouseMoved((MouseEvent e) -> {
    		 System.out.println("Moved\nx:"+e.getX()+"\ny:"+e.getY()+"\n\n");
             mousePosition = new Point(e.getX(), e.getY()); 
             cd.countDown();
         });
    	 rootgroup.setOnMouseClicked((MouseEvent e) -> {
    		 System.out.println("Clicked\nx:"+e.getX()+"\ny:"+e.getY()+"\n\n");
             mousePosition = new Point(e.getX(), e.getY()); 
             cd.countDown();
         });
    }
    
		public MyTurtleFrame() {
			// TODO 自動生成されたコンストラクター・スタブ
			this(400,400);
		}
		
}
