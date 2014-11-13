import java.util.Random;

public class Grid {

	private byte[][] blocks;
	private Random random;

	private int idv;
	private int idh;

	private int max;

	public static void main(String... args) {
		byte[][] b = new byte[6][6];
		b[5][2] = b[4][2] = b[3][2] = 2;

		Grid g = new Grid();
		g.blocks = b;
		System.out.println(g);
		System.out.println(g.move((byte) 2, false));

	}

	/*
	 * j MOVES HORIZONTALLY i MOVES VERTICALLy
	 */

	public Grid() {
		blocks = new byte[6][6];
		blocks[2][0] = blocks[2][1] = -1; // -1 symbols mouse
		idh = 1; // horizontal odd
		idv = 2; // vertical even
		random = new Random(System.currentTimeMillis());
		genRandomGrid();
		max = (idh > idv) ? idh : idv;
	}

	public Grid(Grid g) {
		blocks = new byte[6][6];
		for (int i = 0; i < blocks.length; i++) {
			for (int j = 0; j < blocks[i].length; j++) {
				blocks[i][j] = g.blocks[i][j];
			}
		}
	}

	private void genRandomGrid() {
		for (int i = 0; i < blocks.length; i++) {
			for (int j = 0; j < blocks[i].length; j++) {
				if (blocks[i][j] == 0) {
					try {
						genBlock(i, j);
					} catch (ArrayIndexOutOfBoundsException e) {
						blocks[i][j] = 0;
					}
				}
			}
		}
	}

	private void genBlock(int i, int j) throws ArrayIndexOutOfBoundsException {
		if (random.nextDouble() < 0.5)
			blocks[i][j] = 0;
		else if (random.nextDouble() < 0.5) {
			if (blocks[i][j + 1] == 0) {
				blocks[i][j] = (byte) idh;
				blocks[i][j + 1] = (byte) idh;
				idh += 2;
			} else {
				blocks[i][j] = 0;
			}
		} else if (random.nextDouble() < 0.5) {
			if (blocks[i + 1][j] == 0 && blocks[i + 2][j] == 0) {
				blocks[i][j] = (byte) idv;
				blocks[i + 1][j] = (byte) idv;
				blocks[i + 2][j] = (byte) idv;
				idv += 2;
			} else {
				blocks[i][j] = 0;
			}
		} else if (blocks[i + 1][j] == 0) {
			blocks[i][j] = (byte) idv;
			blocks[i + 1][j] = (byte) idv;
			idv += 2;
		} else {
			blocks[i][j] = 0;
		}
	}

	public String toString() {
		String s = "";
		for (int i = 0; i < blocks.length; i++) {
			for (int j = 0; j < blocks[i].length; j++) {
				s += "\t" + blocks[i][j];
			}
			s += "\n";
		}
		return s;
	}

	public Grid move(byte block, boolean forward) {
		try {
			return moveHelper(block, forward);
		} catch (ArrayIndexOutOfBoundsException e) {
			return null;
		}
	}

	private Grid moveHelper(byte block, boolean forward)
			throws ArrayIndexOutOfBoundsException {
		Grid g = new Grid(this);
		int step = forward ? 1 : -1;
		for (int i = 0; i < blocks.length; i++) {
			for (int j = 0; j < blocks[i].length; j++) {
				if (blocks[i][j] == block) {
					if (blocks[i][j] % 2 == 0) {
						while (blocks[i][j] == block)
							i += step;
						if (blocks[i][j] == 0) {
							while (i - step > -1 && i - step < blocks.length
									&& blocks[i - step][j] == block) {
								g.blocks[i][j] = g.blocks[i - step][j];
								i -= step;
							}
							g.blocks[i][j] = 0;
							return g;
						} else {
							return null;
						}
					} else {
						while (blocks[i][j] == block)
							j += step;
						if (blocks[i][j] == 0) {
							while (j - step > -1 && j - step < blocks[i].length
									&& blocks[i][j - step] == block) {
								g.blocks[i][j] = g.blocks[i][j - step];
								j -= step;
							}
							g.blocks[i][j] = 0;
							return g;
						} else {
							return null;
						}
					}
				}
			}
		}
		return null;
	}
	
	public int getMax() {
		return max;
	}
	
	public byte getBlock(int i, int j) {
		return blocks[i][j];
	}
}
