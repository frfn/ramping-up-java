package BasicBinaryTree;

public class BinarySearchTree<X extends Comparable<X>> {
	
	public static void main(String[] args) {
		
		BinarySearchTree<Integer> bst = new BinarySearchTree<>();
		bst.add(50);
		bst.add(40);
		bst.add(60);
		bst.add(30);
		bst.add(45);
		bst.add(70);
		bst.add(65);
		bst.add(80);
		
		boolean found = bst.searchRec(bst.getRoot(), 80);
		System.out.println(found);
		
		
	}
	
	private Node<X> root;
	private int size;

	public BinarySearchTree() {
		root = null; size = 0;
	}
	
	public Node<X> getRoot(){
		return root;
	}
	
	public boolean isEmpty() {
		return root == null;
	}
	
	public void add(X data) {
		Node<X> node = new Node<X>(data);
		
		if(isEmpty()) {
			root = node; size++;
		}
		else {
			insert(root, node); size++;
		}
	}
	private void insert(Node<X> parent, Node<X> child) {
		
		if(child.getData().compareTo(parent.getData()) <= 0) {
			if(parent.getLeft() == null) {
				child.setParent(parent);
				parent.setLeft(child);
			}
			else {
				insert(parent.getLeft(), child);
			}
		}
		else if(child.getData().compareTo(parent.getData()) > 0) {
			if(parent.getRight() == null) {
				child.setParent(parent);
				parent.setRight(child);
			}
			else {
				insert(parent.getRight(), child);
			}
		}
	}
	
	public Node<X> delete(X data){
		Node<X> deletedNode = null;
		
		if(root == null) {
			return deletedNode;
		}
		
		Node<X> currentNode = getNode(data);
		
		if(currentNode != null) {
			if(currentNode.getLeft() == null && currentNode.getRight() == null) {
				deletedNode = currentNode;
				redirectNode(currentNode, null);
			}
			
			else if(currentNode.getLeft() == null && currentNode.getRight() != null) {
				deletedNode = currentNode;
				redirectNode(currentNode, currentNode.getRight());
			}
			
			else if(currentNode.getLeft() != null && currentNode.getRight() == null) {
				deletedNode = currentNode;
				redirectNode(currentNode, currentNode.getLeft());
			}
			else {
				Node<X> child = currentNode.getLeft();
				while(child.getLeft() != null && child.getRight() != null) {
					child = child.getRight();
				}
				
				if(child == currentNode.getLeft()) {
					child.setRight(currentNode.getRight());
					redirectNode(currentNode, child);
				}
				else {
				
					child.getParent().setRight(null);
					
					child.setLeft(currentNode.getLeft());
					child.setRight(currentNode.getRight());
					
					redirectNode(currentNode, child);
				}
			}
		}
		
		return deletedNode;
	}
	private void redirectNode(Node<X> current, Node<X> node) {
		if(current == root) {
			node.setLeft(current.getLeft());
			node.setRight(current.getRight());
			root = node;
		}
		else if(current.getParent().getRight() == current) {
			current.getParent().setRight(node);
		}
		else {
			current.getParent().setLeft(node);
		}
	}
	
	public boolean searchRec(Node<X> node, X data) {
		if(node != null) {
			int val = data.compareTo(node.getData());
			if(val == 0) {
				return true;
			}
			else if(val <= 0){
				searchRec(node.getLeft(), data);
			}
			else {
				searchRec(node.getRight(), data);
			}
		}
		
		return false;
		
	}
	public boolean search(X data) {
		if(isEmpty()) return false;
		
		Node<X> current = root;
		
		while(current != null) {
			int val = data.compareTo(current.getData());
			if(val == 0) {
				return true;
			}
			else if(val <= 0) {
				current = current.getLeft();
			}
			else {
				current = current.getRight();
			}
		}
		return false;
	}
	
	public Node<X> findMin(){
		Node<X> current = root;
		while(current.getLeft() != null) {
			current = current.getLeft();
		}
		return current;
	}
	public Node<X> findMin(Node<X> node){
		if(node == null) {
			return null;
		}
		else if(node.getLeft() == null) {
			return node;
		}
		else {
			return findMin(node.getLeft());
		}
	}

	public Node<X> findMax(){
		Node<X> current = root;
		while(current.getRight() != null) {
			current = current.getRight();
		}
		return current;
	}
	public Node<X> findMax(Node<X> node){
		if(node == null) {
			return null;
		}
		else if(node.getRight() == null) {
			return node;
		}
		else {
			return findMin(node.getRight());
		}
	}
	
	public Node<X> getNode(X data){
		if(isEmpty()) {
			System.out.println("Not in tree...");
			return null;
		}
		
		Node<X> current = root;
		while(current != null) {
			int val = data.compareTo(current.getData());
			if(val == 0) {
				return current;
			}
			else if(val <= 0) {
				current = current.getLeft();
			}
			else {
				current = current.getRight();
			}
		}
		
		return null;
	}
	
	public int heightOfTree(Node<X> node) {
		int h;
		if(node == null) {
			return -1;
		}
		
		int left = heightOfTree(node.getLeft());
		int right = heightOfTree(node.getRight());
		if(left > right) {
			h = 1 + left;
		}
		else {
			h = 1 + right;
		}
		
		return h;
	}
	
	/* Rubbish
	// Watch video on youtube again. Hehehe.
	// This approach is easy to think of, but not so efficient!
	// the way this works is that it checks if the nodes are a binary tree.
	// It will go left and compare the values, then go right
	// It will compare multiple times, so don't even study this any further.
	// Just know this is possible.
	//	public boolean isBinarySearchTree(Node<X> node) {
	//		if(node == null) return true;
	//		if(leftSubtreeLesser(node.getLeft(), node.getData()) 
	//				&& rightSubtreeGreater(node.getRight(), node.getData())
	//				&& isBinarySearchTree(node.getLeft())
	//				&& isBinarySearchTree(node.getRight())) 
	//		{
	//			return true;
	//		}
	//		else {
	//			return false;
	//		}
	//	}
	//	private boolean leftSubtreeLesser(Node<X> node, X value) {
	//		if(node == null) return true;
	//		if (node.getData().compareTo(value) <= 0
	//				&& leftSubtreeLesser(node.getLeft(), value) 
	//				&& leftSubtreeLesser(node.getRight(), value)) 
	//		{
	//			return true;
	//		}
	//		else {
	//			return false;
	//		}
	//	}
	//	private boolean rightSubtreeGreater(Node<X> node, X value) {
	//		if(node == null) return true;
	//		if (node.getData().compareTo(value) > 0
	//				&& rightSubtreeGreater(node.getLeft(), value) 
	//				&& rightSubtreeGreater(node.getRight(), value)) 
	//		{
	//			return true;
	//		}
	//		else {
	//			return false;
	//		}
	//	}
	*/
	
	// isBSTUtil is more efficient!
	public boolean isBSTUtil(Node<X> node, X minValue, X maxValue) {
		if(node == null) return true;
		
		if(node.getData().compareTo(minValue) > 0 && node.getData().compareTo(maxValue) <= 0
			&& isBSTUtil(node.getLeft(), minValue, node.getData())
			&& isBSTUtil(node.getRight(), node.getData(), maxValue)) 
		{
			return true;
		}
		else {
			return false;
		}
	}

	public void inOrder(Node<X> node) {
		if(node != null) {
			inOrder(node.getLeft());
			System.out.print(node.getData()+ ", ");
			inOrder(node.getRight());
		}
	}
	
	public void levelOrder(Node<X> node) {
		if(isEmpty()) {
			System.out.println("Empty list...");
			return;
		}
		
		Queue<X> queue = new Queue<X>();
		
		queue.enqueue(node);
		
		while(!queue.isEmpty()) {
			Node<X> current = queue.getFront();
			System.out.println(current.getData());
			
			if(current.getLeft() != null) {
				queue.enqueue(current.getLeft());
			}
			if(current.getRight() != null) {
				queue.enqueue(current.getRight());
			}
			
			queue.dequeue();
		}
		
	}
	// Linked List Queue, for levelOrder!
	private static class Queue<X> {
		Node<X> first, last;
		int length;
		public Queue() {
			first = last = null;
			length = 0;
		}
		public Node<X> getFront(){
			return first;
		}
		public boolean isEmpty() {
			return first == null;
		}
		public void enqueue(Node<X> node) {
			if(isEmpty()) {
				last = node;
				first = last;
				length++;
			}
			else {
				last.next = node;
				last = node;
				length++;
			}
		}
		public X dequeue() {
			if(isEmpty()) {
				System.out.println("Empty queue...");
			}
			else {
				X item = first.getData();
				first = first.next;
				length--;
				
				return item;
			}
			return null;
		}		
	}
	
	public static class Node<X> {
		
		private X data;
		private Node<X> left;
		private Node<X> right;
		private Node<X> parent;
		private Node<X> next;
		
		public Node(X data) {
			this.data = data;
			left = right = next = null;
		}
		
		public Node<X> getLeft(){
			return left;
		}
		public Node<X> getRight(){
			return right;
		}
		public Node<X> getParent(){
			return parent;
		}
		
		public X getData() {
			return data;
		}
		
		public void setLeft(Node<X> node) {
			left = node;
		}
		
		public void setRight(Node<X> node) {
			right = node;
		}

		public void setParent(Node<X> node) {	
			parent = node;
		}
		
		public void setData(X data) {
			this.data = data;
		}
		
	}

}
