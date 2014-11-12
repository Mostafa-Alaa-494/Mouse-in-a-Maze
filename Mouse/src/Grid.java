import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Random;

public class Grid {
	int[][] map = new int[6][6];
	LinkedList<Tile> tiles = new LinkedList<Tile>();
	private int bTiles;
	private int hTiles;
	private int v2Tiles;
	private int v3Tiles;

	public Grid() {
		bTiles = 0;
		hTiles = 0;
		v2Tiles = 0;
		v3Tiles = 0;
	}

	public void generateMap() {
		Mouse mouse = new Mouse();
		tiles.add(mouse);
		this.map[2][0] = 1;
		this.map[2][1] = 1;
		for (int i = 0; i < 6; i++) {
			for (int j = 0; j < 6; j++) {
				if (map[i][j] == 0) {
					int tileID = generateRandomTile(i, j);
					// System.out.println(tileID);
					this.map[i][j] = tileID;
					for (int k = 0; k < tiles.size(); k++) {
						if (tiles.get(k).getId() == tileID) {
							Tile tile = tiles.get(k);
							if (tile.getType() == 'h')
								this.map[i][j + 1] = tileID;
							else if (tile.getType() == 'v') {
								this.map[i + 1][j] = tileID;
								if (tile.getSize() == 3)
									this.map[i + 2][j] = tileID;
							}
						}
					}
				}
			}
		}
	}

	public int generateRandomTile(int x, int y) {
		// System.out.println("X = " + x);
		// System.out.println("Y = " + y);
		Random rand = new Random();
		int n = rand.nextInt(4) + 1;
		// System.out.println(n);
		if (n == 1) {
			// System.out.println("BLANK");
			int[] x1 = { x, x };
			int[] y1 = { y, y };
			Tile t = new Blank(x1, y1);
			this.setbTiles(bTiles++);
			return t.getId();
		} else if (n == 2) {
			if (y < 5 && map[x][y + 1] == 0) {
				// System.out.println("HORIZ");
				int[] x1 = { x, x };
				int[] y1 = { y, y + 1 };
				Tile t = new Horizontal(x1, y1);
				this.sethTiles(hTiles++);
				tiles.add(t);
				return t.getId();
			} else {
				return generateRandomTile(x, y);
			}
		} else if (n == 3) {
			if (x < 5 && map[x + 1][y] == 0) {
				// System.out.println("VERT2");
				int[] x1 = { x, x + 1 };
				int[] y1 = { y, y };
				Tile t = new Vertical(2, x1, y1);
				tiles.add(t);
				this.setV2Tiles(v2Tiles++);
				return t.getId();
			} else {
				return generateRandomTile(x, y);
			}
		} else if (n == 4) {
			if ((x < 4) && map[x + 1][y] == 0 && map[x + 2][y] == 0) {
				// System.out.println("VERT3");
				int[] x1 = { x, x + 2 };
				int[] y1 = { y, y };
				Tile t = new Vertical(3, x1, y1);
				tiles.add(t);
				this.setV3Tiles(v3Tiles++);
				return t.getId();
			} else {
				return generateRandomTile(x, y);
			}
		}
		return 0;
	}

	public Tile getTile(int id) {
		for (int k = 0; k < tiles.size(); k++) {
			if (tiles.get(k).getId() == id) {
				Tile tile = tiles.get(k);
				System.out.println("IF");
				return tile;
			}
			System.out.println(k);
		}
		System.out.println(tiles.size());
		System.out.println("NULL");
		return null;
	}

	public void printGrid() {
		for (int i = 0; i < 6; i++) {
			for (int j = 0; j < 6; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.print("\n");
		}
	}

	public boolean hasPossibleMoves(int id) {
		for (int k = 0; k < tiles.size(); k++) {
			if (tiles.get(k).getId() == id) {
				if (!getTilePossibleMoves(id).isEmpty()) {
					return true;
				}
			}
		}
		return false;
	}

	public ArrayList<int[][]> getTilePossibleMoves(int id) {
		ArrayList<int[][]> moves = new ArrayList<int[][]>(2);
		int[][] map2 = new int[6][6];
		int[][] map3 = new int[6][6];
		for (int i = 0; i < 6; i++) {
			for (int j = 0; j < 6; j++) {
				map2[i][j] = map[i][j];
				map3[i][j] = map[i][j];
			}
		}
		if (id == -1)
			return null;
		else {
			for (int k = 0; k < tiles.size(); k++) {
				if (tiles.get(k).getId() == id) {
					Tile tile = tiles.get(k);
					if (tile.getType() == 'h') {
						if (tile.getY()[1] + 1 <= 5
								&& map2[tile.getX()[0]][tile.getY()[1] + 1] == -1) {
							System.out.println("H1");
							map2[tile.getX()[0]][tile.getY()[0]] = -1;
							map2[tile.getX()[0]][tile.getY()[1] + 1] = tile
									.getId();
							moves.add(map2);
						}
						if (tile.getY()[0] - 1 >= 0
								&& map3[tile.getX()[0]][tile.getY()[0] - 1] == -1) {
							System.out.println("H2");
							map3[tile.getX()[0]][tile.getY()[1]] = -1;
							map3[tile.getX()[0]][tile.getY()[0] - 1] = tile
									.getId();
							moves.add(map3);
						}
					} else if (tile.getType() == 'v') {
						if (tile.getX()[1] + 1 <= 5
								&& map[tile.getX()[1] + 1][tile.getY()[0]] == -1) {
							System.out.println("V1");
							map2[tile.getX()[0]][tile.getY()[0]] = -1;
							map2[tile.getX()[1] + 1][tile.getY()[1]] = tile
									.getId();
							moves.add(map2);
						}
						if (tile.getX()[0] - 1 >= 0
								&& map[tile.getX()[0] - 1][tile.getY()[0]] == -1) {
							System.out.println("V2");
							map3[tile.getX()[1]][tile.getY()[0]] = -1;
							map3[tile.getX()[0] - 1][tile.getY()[0]] = tile
									.getId();
							moves.add(map3);
						}
					}
					for (int i = 0; i < moves.size(); i++) {
						System.out.println(moves.size());
						int[][] move1;
						move1 = moves.get(i);
						for (int z = 0; z < 6; z++) {
							for (int j = 0; j < 6; j++) {
								System.out.print(move1[z][j] + " ");
							}
							System.out.print("\n");
						}
					}
				}
			}
			return moves;
		}
	}

	public boolean satisfiesGoalTest(int[][] a) {
		int m = tiles.getFirst().getY()[1];
		for (int i = m; i < 6; i++) {
			if (a[2][i] != -1)
				return false;
		}
		return true;
	}

	public int getbTiles() {
		return bTiles;
	}

	public void setbTiles(int bTiles) {
		this.bTiles = bTiles;
	}

	public int gethTiles() {
		return hTiles;
	}

	public void sethTiles(int hTiles) {
		this.hTiles = hTiles;
	}

	public int getV2Tiles() {
		return v2Tiles;
	}

	public void setV2Tiles(int v2Tiles) {
		this.v2Tiles = v2Tiles;
	}

	public int getV3Tiles() {
		return v3Tiles;
	}

	public void setV3Tiles(int v3Tiles) {
		this.v3Tiles = v3Tiles;
	}

	public static void main(String[] args) {
		Grid grid = new Grid();
		System.out.println();
		grid.generateMap();
		grid.printGrid();
		System.out.print(grid.hasPossibleMoves(2));
	}
}
