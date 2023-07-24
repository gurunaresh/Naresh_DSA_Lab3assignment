package com.greatlearning.bst;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

//Node definition and initialization
class Node {
	int key;
	Node left;
	Node right;

	public Node(int data) {
		this.key = data;
		left = right = null;
	}
}

public class BSTSumPair {
	Node node;

	Node insertNode(Node node, int key) {
//		Create a new Node
		if (node == null) {
			node = new Node(key);
			return node;
		}
		if (key < node.key) {
			node.left = insertNode(node.left, key);
		} else if (key > node.key) {
			node.right = insertNode(node.right, key);
		} else {
			System.out.println("Cant have duplicate values");
			return node;
		}
		return node;
	}

//Definition of inorder traversal
	public void inOrder(Node root) {
		if (root == null) {
			return;
		} else {
			inOrder(root.left);
			System.out.print(root.key + " ");
			inOrder(root.right);
		}

	}

	public void findSumPair(Node node2, int targetSum) {
		// TODO Auto-generated method stub
		Set<Integer> set = new HashSet<>();
		if (!findPairUtil(node2, targetSum, set)) {
			System.err.println("The Pair doesn't exists");
		}
	}

	private boolean findPairUtil(Node node2, int targetSum, Set<Integer> set) {
		// TODO Auto-generated method stub
		if (node2 == null)
			return false;
		if (findPairUtil(node2.left, targetSum, set))
			return true;
		int diff = targetSum - node2.key;
		if (set.contains(diff)) {
			System.out.println("Pair is found (" + diff + "," + node2.key + ")");
			return true;
		} else
			set.add(node2.key);

		return findPairUtil(node2.right, targetSum, set);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int targetSum;
		Scanner sc = new Scanner(System.in);

		BSTSumPair bst = new BSTSumPair();

		// Insert the nodes to the tree
		bst.node = bst.insertNode(bst.node, 40);
		bst.node = bst.insertNode(bst.node, 20);
		bst.node = bst.insertNode(bst.node, 60);
		bst.node = bst.insertNode(bst.node, 10);
		bst.node = bst.insertNode(bst.node, 30);
		bst.node = bst.insertNode(bst.node, 50);
		bst.node = bst.insertNode(bst.node, 70);

//		Print the inorder traversal of the tree
		System.out.println("Inorder of the tree:");
		bst.inOrder(bst.node);

		System.out.println("Enter the target sum:");
		targetSum = sc.nextInt();

//		Find the sum pair
		bst.findSumPair(bst.node, targetSum);
		sc.close();
	}
}
