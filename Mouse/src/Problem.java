import java.util.ArrayList;

public abstract class Problem {
	private ArrayList<String> operators;
	private Node initialState;
	private ArrayList<Node> stateSpace;
	
	public boolean goalTest(Grid g){
		return false;
	}
	
	public int pathCost(){
		return 0;
	}
	public ArrayList<String> getOperators() {
		return operators;
	}

	public void setOperators(ArrayList<String> operators) {
		this.operators = operators;
	}

	public Node getInitialState() {
		return initialState;
	}

	public void setInitialState(Node initialState) {
		this.initialState = initialState;
	}

	public ArrayList<Node> getStateSpace() {
		return stateSpace;
	}

	public void setStateSpace(ArrayList<Node> stateSpace) {
		this.stateSpace = stateSpace;
	}
}
