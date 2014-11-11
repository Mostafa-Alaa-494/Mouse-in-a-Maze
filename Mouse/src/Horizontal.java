public class Horizontal extends Tile {
	
	public Horizontal(int []x, int []y) {
		super.setId(staticID);
		super.setType('h');
		super.setSize(2);
		super.setX(x);
		super.setY(y);
		staticID++;
	}
}
