import java.util.ArrayList;

public class MouseInAMaze extends Problem {
	ArrayList<String> o = new ArrayList<String>();
	Grid grid;

	public MouseInAMaze() {
		o.add(0, "r");
		o.add(1, "l");
		o.add(2, "u");
		o.add(3, "d");
		grid = new Grid();
		super.setOperators((o));
		super.setInitialState(null);
		super.setStateSpace(null);
	}

	public boolean goalTest(Grid g) {
		return g.satisfiesGoalTest();
	}

	public int pathCost() {
		return 0;
	}

	public void start() {
		grid.generateMap();
		grid.printGrid();
		BFS bfs = new BFS(grid);
		Node sol = bfs.GeneralSearch(this);
//		DFS dfs = new DFS(grid);
//		Node sol = dfs.GeneralSearch(this);
//		IDS ids = new IDS(grid);
//		Node sol = ids.GeneralSearch(this,5);
		if (sol == null)
			System.out.println("FAILURE");
		else {
			System.out.println("SUCCESS");
			sol.getState().printGrid();
		}
	}

	public static void main(String[] args) {
		MouseInAMaze game = new MouseInAMaze();
		game.start();
	}
}
