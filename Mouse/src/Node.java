	public class Node {
		private int id;
		private Grid state;
		private Node parent;
		private String operator;
		private int depth;
		private int cost;

		private static int COUNT = 0;

		public Node(Grid g, Node p, int d) {
			this.id = ++COUNT;
			this.state = g;
			this.parent = p;
			this.operator = null;
			this.depth = 0;
			this.cost = 1;
		}

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public Node getParent() {
			return parent;
		}

		public void setParent(Node parent) {
			this.parent = parent;
		}

		public Grid getState() {
			return state;
		}

		public void setState(Grid state) {
			this.state = state;
		}

		public String getOperator() {
			return operator;
		}

		public void setOperator(String operator) {
			this.operator = operator;
		}

		public int getDepth() {
			return depth;
		}

		public void setDepth(int depth) {
			this.depth = depth;
		}

		public int getCost() {
			return cost;
		}

		public void setCost(int cost) {
			this.cost = cost;
		}
	}
