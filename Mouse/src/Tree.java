import java.util.ArrayList;
import java.util.List;

public class Tree<Grid> {
    private Node<Grid> root;

    public Node<Grid> getRoot() {
		return root;
	}

	public Tree(Grid rootData) {
        root = new Node<Grid>();
        root.state = rootData;
        root.children = new ArrayList<Node<Grid>>();
    }

    public static class Node<Grid> {
        private Grid state;
		private Node<Grid> parent;
        private List<Node<Grid>> children;
        private String operator;
        private int depth;
        private int cost;
        
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
}
