public class Node implements Comparable {
	Grid state;
	Node parent;
	int depth;
	int cost;
	SearchProblem.Pair op;

	public Node(Grid s, Node p, int d, int c, SearchProblem.Pair o) {
		state = s;
		parent = p;
		depth = d;
		cost = c;
		op = o;
	}

	@Override
	public int compareTo(Object arg0) {
		Node n2 = (Node) arg0;
		return (new Integer(cost)).compareTo(n2.cost);
	}
}
