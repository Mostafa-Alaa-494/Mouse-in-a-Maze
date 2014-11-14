import java.util.LinkedList;

public class IDS extends Search {
	Node root;
	int depth;
	LinkedList<Tile> tiles = new LinkedList<Tile>();

	public IDS(Grid g) {
		super.q = new LinkedList<Node>();
		root = new Node(g, null, 0);
		tiles = g.tiles;
	}

	public Node GeneralSearch(Problem p, int l) {
		while (true) {
			for (depth = 0; depth < l; depth++) {
				q.addFirst(root);
				if (q.isEmpty())
					return null;
				if (p.goalTest(q.getFirst().getState()))
					return q.removeFirst();
				expand(q.removeFirst());
			}
		}
	}

	public void expand(Node n) {
		Grid data = n.getState();
		LinkedList<Grid> childrenToBe = data.getAllPossibleMoves(tiles);
		for (int i = 0; i < childrenToBe.size(); i++) {
			Node child = new Node(childrenToBe.get(i), n, n.getDepth() + 1);
			q.addFirst(child);
		}
	}
}
