public abstract class Tile {
	private int id;
	private char type;
	private int size;
	private int[] x = { -1, -1 };
	private int[] y = { -1, -1 };
	
	static int staticID = 2;
	
	public Tile() {
		this.setId(0);
		this.setType(' ');
		this.setSize(0);
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
