package assign;

import java.util.Comparator;
import java.util.List;

//Uniform Cost Search: Djikstra's algorithm variant
//Runtime: 5-6 ms
public class UCS implements Search {
	private Nodes root;
	
	public UCS(Nodes node) {
		this.root = node;
	}
	
	private class newComparator implements Comparator<Nodes>{
		public int compare(Nodes a, Nodes b) {
			return a.getMaxCost() - b.getMaxCost();
		}
	}
	
	public boolean search() {
		DataStructs dataStructs = new DataStructs();
		dataStructs.makePQueue(new newComparator());
		//start at the root
		Nodes node = root;
		dataStructs.pQueue.add(node);
		//while priorityQueue is not empty, visit. Save visits as a hash
		while(!(dataStructs.pQueue.isEmpty())) {
			node = dataStructs.pQueue.poll();
			dataStructs.visited.put(node.hashCode(), node);
			//return if goal is found, end search
			if(node.goal()) {
				PathActions p = new PathActions(root,node,dataStructs);
				p.printPath();
				return true;
			}
			
			// Directional created to give next moves from given node
			Directional s = new Directional();
			List<Nodes> list = s.giveDirection(node); // stores potential moves
			
			//Check your hashes to see if node has been visited
			for(Nodes n: list) {
				boolean ans = dataStructs.visited.containsKey(n.hashCode()); 
				//checks pQueue if there is a node with higher cost
				if(ans==false) {
					if(!(dataStructs.pQueue.contains(n))){
					dataStructs.pQueue.add(n);
					}
				}
			}
		}
		return false;
	}
}

