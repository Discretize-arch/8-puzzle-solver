package assign;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//Shows the direction that empty square moves
public class PathActions {
	List<Nodes> path;
	DataStructs dataStructs;
	
	//constructor
	public PathActions(Nodes root, Nodes goalNode, DataStructs inf) {
		path = this.getPath(root, goalNode);
		this.dataStructs = inf;
	}
	
	//return the list of directions
	private List<Nodes> getPath(Nodes initialNode, Nodes goalNode) {
		Nodes tempNode = goalNode;
		List<Nodes> list = new ArrayList<Nodes>();
		
		while(!(tempNode.equals(initialNode))) {
			list.add(tempNode);
			tempNode = tempNode.getParent();
		}
		list.add(initialNode);
		return list;
	}
	
	public void printPath() {
		int size = path.size();
		for(int i = size - 1; i >= 0; i--) {
			System.out.println("Direction Empty Space Moved: " + path.get(i).getDir());
			//need deepToString due to 2d array
			System.out.println(Arrays.deepToString(path.get(i).getGrid()).replace("], ", "]\n").replace("[[", "[").replace("]]", "]"));
		}
	}
}
