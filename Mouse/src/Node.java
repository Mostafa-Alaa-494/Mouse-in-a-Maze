
public class Node {
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
}
