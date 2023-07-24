
import java.util.*;

public class pairSum {
	
	public static class Node {
		int data;
		Node left, right;
	};

	public static Node NewNode(int data){
		Node temp = new Node();
		temp.data = data;
		temp.left = null;
		temp.right = null;
		return temp;
	}

	
	public static Node insert(Node root, int key){
		if (root == null) return NewNode(key);
		if (key < root.data) root.left = insert(root.left, key);
		else root.right = insert(root.right, key);
		return root;
	}

	static boolean findPair(Node root, int sum, HashSet<Integer> set){

		if (root == null)
         return false;
		if (findPair(root.left, sum, set))
         return true;

		if (set.contains(sum - root.data)){

			System.out.println("Pair is (" + (sum - root.data) + "," + root.data + ")");
			return true;
		}
		else
         set.add(root.data);

		return findPair(root.right, sum, set);
	}

	static void findPair(Node root, int sum){
		HashSet<Integer> set = new HashSet<Integer>();
		if (!findPair(root, sum, set))
			System.out.print("Nodes are not found.\n");
	}


	public static void main(String[] args){
		Node root = null;

		root = insert(root, 4);
		root = insert(root, 2);
		root = insert(root, 6);
		root = insert(root, 1);
		root = insert(root, 3);
		root = insert(root, 5);
		root = insert(root, 7);

		int sum = 13;
		findPair(root, sum);
	}
}
