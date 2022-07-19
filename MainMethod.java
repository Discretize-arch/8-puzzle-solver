package assign;

//Course: ____CS3642_____
//Student name: __Leiko Niwano__
//Student ID: __000885139___
//Assignment #: ____1____
//Due Date: ____2/23/2022____
//Signature: ___Leiko Niwano___ 
//Score: _________________

import java.util.Scanner;
//import javax.swing.event.ListSelectionEvent;

public class MainMethod {

	public static void main(String[] args) {
		
		// Zero is empty slot
		//change to 
		int [][] start = {{2,8,3},{1,6,4},{7,0,5}};
		Nodes newNode = new Nodes(start);
		Search search = null;
		
		//basic ui
		System.out.println("1 -> UCS");
		System.out.println("2 -> DFS"); //might have to wait a while for this one
		System.out.println("3 -> BFS");
		try (Scanner scanner = new Scanner(System.in)) {
			int input = scanner.nextInt();
			switch(input) {
				case 1:
					search = new UCS(newNode);
					break;
				case 2:
					search = new DFS(newNode);
					break;
				case 3:							
					search = new BFS(newNode);
					break;
			}
		}
		long starter = System.currentTimeMillis();
		System.out.println("Search: ");
		search.search();
		long end = System.currentTimeMillis();
		System.out.print("Execution time is " + (end - starter) + " ms\n");
		System.out.print("//Course: " 
				+ "//Score: _________________");
		}
	}

enum Directors {
	Up, Down, Left, Right
}