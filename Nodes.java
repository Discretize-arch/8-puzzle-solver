package assign;
import java.util.ArrayList;
import java.util.List;

public class Nodes {
		
	int[][]  state = new int [3][3];
	List<Nodes> children;
	Nodes parent;
	int emptyRow;
	int emptyColumn;
	Directors direction;
	String stringState;
	
	//needed for UCS
	int cost;
	int maxCost;
	
	//constructor
	public Nodes(int [][] state) {
		this.state = state;
		this.children = new ArrayList<Nodes>();
		this.parent = null;
		this.cost = 0;
		this.maxCost = 0;
		this.stringState = stringBoard();
		this.direction = null;
		for(int i = 0; i <= 2; i++) {
			for(int j = 0; j <= 2; j++) {
				if(state[i][j]==0) {
					this.emptyRow = i;
					this.emptyColumn = j;
					break;
				}
			}
		}
		
	}
	
	//prints board as string 
	public String stringBoard() {
		StringBuilder sb = new StringBuilder();
		for (int i =0; i<state.length; i++) {
			for(int j = 0; j<state[i].length;j++ ) {
				sb.append(state[i][j]);
			}
		}
		return sb.toString();
	}
	
	//add child to node
	public void addChild(Nodes child) {
		child.setParent(this);
		child.setMaxCost(child.getCost());
		this.children.add(child);
	
	}
	
	//getters and setters
	
	public Nodes getParent() {
		return parent;
	}
	public void setParent(Nodes parent) {
		this.parent = parent;
	}
	
	public int getRowBlank() {
		return emptyRow;
	}
	
	public int getColBlank() {
		return emptyColumn;
	}
	
	public int [][] getGrid(){
		return state;
	}
	
	public int getCost() {
		return this.cost;
	}
	
	public List<Nodes> getChildren(){
		return children;
	}
	public void setChildren(List<Nodes> childrens) {
		this.children =  childrens;
	}
	
	public void setDir(Directors d) {
		this.direction = d;
	}
	public Directors getDir() {
		return direction;
	}
	
	public String getString() {	
		return stringState;
	}
	
	public void setCost(int i) {
		this.cost = i;
	}
	public void setMaxCost(int i) {
		this.maxCost = this.getParent().getMaxCost() + i;
	}
	
	public int getMaxCost() {
		return maxCost;
	}
	public Nodes createChild(int a, int b) {
		int n[][] = new int[state.length][state.length];
		for(int i=0; i<state.length; i++)
			  for(int j=0; j<state[i].length; j++)
			    n[i][j]=state[i][j];
		n[emptyRow][emptyColumn] = n[a][b];
		int cost = state[a][b]; 
		n[a][b] = 0;
		Nodes child = new Nodes(n);
		child.setCost(cost);
		addChild(child);
		return child;
	}
	
	public boolean goal() {
		boolean result = false;
		int [][] goal = {{1,2,3},{8,0,4},{7,6,5}};
		Nodes goalNode = new Nodes(goal);
		result = this.equals(goalNode);
		return result;
	}
	
	@Override
	public boolean equals(Object object ) {
		
		if(!(object instanceof Nodes)) {
			return false;
		}
		Nodes check = (Nodes) object;
		
		return check.getString().equals(this.getString());
	}
	
	public int hashCode() {	
		int result = 17;
		result = 37 * result + this.getString().hashCode();
		return result;
	}
	
	public Nodes secondNode() {
		Nodes second = new Nodes(this.getGrid());
		second.setParent(this.getParent());
		second.setDir(this.getDir());
		second.setCost(this.getCost());
		second.setMaxCost(this.getCost());
		second.setChildren(this.getChildren());
		return second;
	}
}
