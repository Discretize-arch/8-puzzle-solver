package assign;

import java.util.ArrayList;
import java.util.List;

//Gives directions 
public class Directional {
	public Directional() {
	}
	
	public List<Nodes> giveDirection(Nodes node) {
		List<Nodes> list = new ArrayList<Nodes>();
		int row = node.getRowBlank();
		int column = node.getColBlank();
		
		if((column !=0 || column != 1 || column != 2) && (row !=0)) { 
			Nodes upNode = node.createChild(row - 1, column);
			upNode.setDir(Directors.Up);
			list.add(upNode);
		}
		
		if((column !=0 || column != 1 || column != 2) && (row !=2)) {
			Nodes downNode = node.createChild(row + 1, column);
			downNode.setDir(Directors.Down);
			list.add(downNode);
		}

		if((row != 0 || row != 1 || row != 2) && (column !=0)) {
			Nodes leftNode = node.createChild(row, column - 1);
			leftNode.setDir(Directors.Left);  
			list.add(leftNode);
		}
		
				if((row != 0 || row != 1 || row != 2) && (column !=2)) {
			Nodes rightNode = node.createChild(row, column+1);
			rightNode.setDir(Directors.Right);
			list.add(rightNode);
		}
		return list;
	}
}
