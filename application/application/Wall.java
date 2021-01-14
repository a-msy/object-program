package application;

public class Wall{
	public boolean isWall=false;
	public int x;
	public int y;
	public int role = 0;
	/*
	 * ０：ただの床
	 * １：スタート
	 * ２：ゴール
	 * */
	public Wall(boolean isWall,int x, int y,int role) {
		this.isWall = isWall;//壁かどうか
		this.x = x;//左上の角の座標
		this.y = y;//左上の角の座標
		this.role = role;
	}
	public boolean isWall() {
		return this.isWall;
	}
	public int getX() {
		return this.x;
	}
	
	public int getY() {
		return this.y;
	}
	
	public int getRole() {
		return this.role;
	}
	
	public void debug() {
		System.out.println("x:"+getX()+" , "+"y:"+getY()+"\n"+"status:"+isWall()+"\nrole:"+getRole()+"\n\n");
	}
}