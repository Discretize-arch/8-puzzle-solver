package assign;
import java.util.List;

//Depth first search
//Runtime: anywhere from 13000 ms to 137 ms if cached
public class DFS implements Search {
	
	private Nodes root;
	public DFS(Nodes node) {
		this.root = node;
	}
	
	public boolean search() { 
		DataStructs dataStructs = new DataStructs();
		Nodes node = root;
		//let root be a stack
		dataStructs.stack.push(node);
		//pop current node if not empty
		while(!(dataStructs.stack.isEmpty())) {
			node = dataStructs.stack.pop();
			//if v hasn't been discovered, label as discovered
			dataStructs.visited.put(node.hashCode(), node);
			if (node.goal()) {
				PathActions p = new PathActions(root, node,dataStructs);
				p.printPath();
				return true;
			}
			
			//keep directions in list
			Directional s = new Directional();
			List<Nodes> list = s.giveDirection(node);
			
			//see if node has been visited
			for(Nodes n: list) {
				boolean ans = dataStructs.visited.containsKey(n.hashCode()); 
				if(ans==false ){
					if(!(dataStructs.stack.contains(n))) {
						dataStructs.stack.push(n);
					}
				}
			}
		}
		return false;
	}
}
