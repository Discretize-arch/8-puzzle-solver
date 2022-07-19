package assign;
import java.util.List;

public class firstpart implements Search{
	Nodes start;
	public firstpart(Nodes node) {
		this.start = node;
	}
	
	public boolean search() {
		DataStructs dataStructs = new DataStructs();
		Nodes root = start;
		dataStructs.queue.add(root);
		//keep searching until queue is empty
		while(!(dataStructs.queue.isEmpty())) {
			root = dataStructs.queue.remove();
			dataStructs.visited.put(root.hashCode(), root);  
			//checks to see if root is at goal
			if (root.goal()) {
				PathActions p = new PathActions(start, root, dataStructs);
				p.printPath();
				return true;
			}
			
			Directional s = new Directional();
			List<Nodes> list = s.giveDirection(root);
			//continue to explore tree
			for(Nodes v: list) {
				boolean ans = dataStructs.visited.containsKey(v.hashCode());
				if(ans == false ){
					if(!(dataStructs.queue.contains(v))) {
					dataStructs.queue.add(v);
					dataStructs.queueSize();
					}
				}
			}
		}
		return false;
	}
}
