public class Horizontal extends Tile {
	
	public Horizontal(int id, int []x, int []y) {
		super.setId(id);
		super.setType('h');
		super.setSize(2);
		super.setX(x);
		super.setY(y);
	}
}