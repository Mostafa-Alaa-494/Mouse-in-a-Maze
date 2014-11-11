public class Vertical extends Tile{

	public Vertical(int size, int[]x, int []y) {
		super.setId(staticID);
		super.setType('v');
		super.setSize(size);
		super.setX(x);
		super.setY(y);
		staticID++;
	}
}
