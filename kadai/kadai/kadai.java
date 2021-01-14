package kadai;

/*
 * Turtle Frameの変数宣言をprotectedなどに変更
 * MyTurtleFrameコンストラクタ呼び出しにて，マウス移動の判定を作成．
 * 変更を加えたすべてのファイルをkadaiというパッケージにした
 * */

public class kadai{
	static Point p;
	public static void main(String[] args) {
		MyTurtleFrame f =new MyTurtleFrame(400,400);
		Turtle m = new Turtle();
		m.up();
		f.add(m);
		while(true) {
			p = f.getMousePosition();
			m.moveTo(p.x, p.y);
		}
	}
}
