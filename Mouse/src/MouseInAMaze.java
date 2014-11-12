import java.util.ArrayList;

public class MouseInAMaze extends Problem {
	ArrayList<String> o = new ArrayList<String>();
	
	public MouseInAMaze() {
		o.add(0, "r");
		o.add(1, "l");
		o.add(2, "u");
		o.add(3, "d");
		super.setOperators((o));
		super.setInitialState(null);
		super.setStateSpace(null);
	}
	
	public static void main(){
		
	}
}
