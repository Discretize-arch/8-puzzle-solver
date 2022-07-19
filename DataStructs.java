package assign;

import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;

//creates data structures needed to use algorithms
public class DataStructs {
	public Queue<Nodes> queue;
	public Stack<Nodes> stack;
	public PriorityQueue<Nodes> pQueue;
	private int maxQueueSize;
	public HashMap<Integer,Nodes> visited; 
	
	public DataStructs(){
		queue = new LinkedList<Nodes>();
		stack = new Stack<Nodes>();
		pQueue = new PriorityQueue<Nodes>();
		visited = new HashMap<Integer,Nodes>();}
	
	public void  makePQueue(Comparator c) {
		pQueue = new PriorityQueue<Nodes>(c); }
	
	public void queueSize(){
		if(queue.size()>maxQueueSize) {
			maxQueueSize = queue.size();
		}
	}
}