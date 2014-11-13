import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class SearchProblem {

	Queue<Node> queue;
	ArrayList<Pair> ops;
	int expanded;
	int totCost;

	public static void main(String... args) {
		Grid g = GenGrid();

		MiM(g, "gr", true);

	}

	public SearchProblem(String strat) {
		strat = strat.toLowerCase();
		queue = null;
		if (strat.equals("df"))
			queue = new DFSQueue<>();
		else if (strat.equals("bf"))
			queue = new BFSQueue<>();
		else if (strat.equals("gr"))
			queue = new Greedy<>();

		expanded = 0;

	}

	public static Grid GenGrid() {
		return new Grid();
	}

	public static void MiM(Grid g, String strat, boolean visual) {

		SearchProblem p = new SearchProblem(strat);
		LinkedList<Pair> sol = p.search(g);

		if (sol == null) {
			System.out.println("No solution has been found!");
			return;
		}
		if (visual) {
			System.out.println(g);
			Scanner sc = new Scanner(System.in);
			for (Pair pair : sol) {
				System.out.println();
				sc.next();
				g = g.move(pair.block, pair.forward);
			}
		}
		System.out.println(sol);
		System.out.println("Total Cost: " + p.totCost);
		System.out.println("Expanded nodes: " + p.expanded);

	}

	public LinkedList<Pair> search(Grid g) {
		queue.push(new Node(g, null, 0, 0, null));
		ops = new ArrayList<>();
		for (int i = 0; i < g.getMax(); i++) {
			ops.add(new Pair((byte) i, true));
			ops.add(new Pair((byte) i, false));
		}
		while (!queue.isEmpty()) {
			Node n = queue.pop();
			Grid head = n.state;
			if (!goalTest(head)) {
				expand(n);
				expanded++;
				if (expanded % 10000 == 0)
					System.out.println("-- " + expanded + " expanded --");

			} else {
				totCost = n.cost;
				return formSol(n);
			}
		}
		return null;
	}

	public LinkedList<Pair> formSol(Node head) {

		LinkedList<Pair> sol = new LinkedList<>();
		while (head.parent != null)
			sol.addFirst(head.op);

		return sol;

	}

	public void expand(Node n) {
		Grid g = n.state;
		Collections.shuffle(ops);
		for (int i = 0; i < ops.size(); i++) {
			Pair p = ops.get(i);
			Grid newG = g.move(p.block, p.forward);
			if (newG == null)
				continue;
			queue.push(new Node(newG, n, n.depth + 1, n.cost + 1, p));
		}
	}

	public boolean goalTest(Grid g) {
		return g.getBlock(2, 5) == -1;
	}

	public static class Pair {
		byte block;
		boolean forward;

		public Pair(byte b, boolean f) {
			block = b;
			forward = f;
		}

		public String toString() {
			return "Move block " + block + (forward ? " forward" : "backward");
		}
	}

}
