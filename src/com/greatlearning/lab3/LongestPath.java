package com.greatlearning.lab3;

import java.util.ArrayList;

public class LongestPath {
	
	static class Node{
		int data;
		Node left, right;
	}
	
	public static Node newNode(int data) {
		Node temp = new Node();
		temp.data = data;
		temp.left = null;
		temp.right = null;
		
		return temp;
	}
	
	public static ArrayList<Integer> findLongestPath(Node root){
		if (root == null) {
			ArrayList<Integer> output = new ArrayList<>();
			return output;
		}
		//Recursive call on right node
		ArrayList<Integer> rightNodeList = findLongestPath(root.right);
		
		//Recursive call on left node
		ArrayList<Integer> leftNodeList = findLongestPath(root.left);
		
		//Compare size of left and right array
		if (rightNodeList.size() < leftNodeList.size()) {
			leftNodeList.add(root.data);
		}else {
			rightNodeList.add(root.data);
		}
		return (leftNodeList.size() > rightNodeList.size() ? leftNodeList:rightNodeList);
	}

	public static void main(String[] args) {

		Node root = newNode(10);
		root.left = newNode(8);
		root.right = newNode(13);
		root.left.left = newNode(7);
		root.left.right = newNode(9);
		root.left.left.left = newNode(6);
		root.right.left = newNode(15);
		root.right.right = newNode(100);
		//root.right.left.left = newNode(1);
		//root.right.left.left.left = newNode(17);
		
		ArrayList<Integer> resultList = findLongestPath(root);
		int resultListSize = resultList.size();
		
		//Print the longest path elements in list
		System.out.println("The Longest path in the Binary Tree is: ");
		for(int i=resultListSize - 1; i>=0 ; i--) {
			if(i == 0)
				System.out.print(resultList.get(i));
			else
				System.out.print(resultList.get(i) + "->");
		}
	}

}
