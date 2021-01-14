package application;

public class Man {
	public int x;
	public int y;
	
	public Man(int x,int y) {
		this.x=x;
		this.y=y;
	}
	
	public int getX() {
		return this.x;
	}
	
	public int getY() {
		return this.y;
	}
	
	public Man() {
		this(1,1);
	}
}
