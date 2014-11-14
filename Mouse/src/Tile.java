public abstract class Tile {
	private int id;
	private char type;
	private int size;
	private int[] x;
	private int[] y;
	
	static int staticID = 2;
	
	public Tile() {
	}

	public Tile(char type, int size, int[] x, int[] y) {
		this.setId(staticID);
		this.setType(type);
		this.setSize(size);
		staticID++;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public char getType() {
		return type;
	}

	public void setType(char c) {
		this.type = c;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public int[] getX() {
		return x;
	}

	public void setX(int[] x) {
		this.x = x;
	}

	public int[] getY() {
		return y;
	}

	public void setY(int[] y) {
		this.y = y;
	}

}
