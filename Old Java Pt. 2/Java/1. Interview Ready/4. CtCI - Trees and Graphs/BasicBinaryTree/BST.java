package BasicBinaryTree;

public class BST<X extends Comparable<X>> {
	
	private Node<X> root;
	private int size;
	
	public BST() {
		root = null;
		size = 0;
	}
	
	public boolean isEmpty() {
		return root == null;
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
	public void add(X data) {
		Node<X> node = new Node<X>(data);
		if(isEmpty()) {
			root = node;
		}
		else {
			insert(root, node);
		}
		size++;
	}
	
	private Node<X> search(X data){
		Node<X> found = null;
		Node<X> current = root;
		
		if(current == null) {
			return found;
		}
		
		while(current != null) {
			int val = current.getData().compareTo(data);
			
			if(val == 0) {
				found = current;
				return found;
			}
			else if(val <= 0) {
				current = current.getLeft();
			}
			else {
				current = current.getRight();
			}
		}
		
		return found;
		
	}
	private void redirectNode(Node<X> current, Node<X> node) {
		if(current == root) {
			node.setLeft(current.getLeft());
			node.setRight(current.getRight());
			root = node;
		}
		else if(current.getParent().getRight() == current){
			current.getParent().setRight(node);
		}
		else {
			current.getParent().setLeft(node);
		}
	}
	public Node<X> delete(X data){
	
		Node<X> deleted = null;
		
		if(root == null) {
			return deleted;
		}
		
		Node<X> current = search(data);
		
		if(current != null) {
			
			if(current.getLeft() == null && current.getRight() == null) {
				deleted = current;
				current = null; // this helps the process for GC
				// redirect node is SO helpful, it literally just redirects it to whatever the node argument is
				redirectNode(current, null); // will set the parent of current's left/right to null
			}
			else if(current.getLeft() != null && current.getRight() == null) {
				deleted = current;
				redirectNode(current, current.getLeft());
			}
			else if(current.getLeft() == null && current.getRight() != null) {
				deleted = current;
				redirectNode(current, current.getRight());
			}
			else {
				// if parent node has two children
				Node<X> child = current.getLeft();
				
				while(child.getLeft() != null && child.getRight() != null) {
					child = child.getRight();
				}
				
				if(child == current.getLeft()) {
					child.setRight(current.getRight());
					redirectNode(current, child);
				}
				else {
					child.getParent().setRight(null);
					child.setLeft(current.getLeft());
					child.setRight(current.getRight());
					redirectNode(current, child);
				}
			}
			
		}
		
		return deleted;
		
	}
	
	public Node<X> findMin(){
		if(isEmpty()) {
			return null;
		}
		Node<X> current = root;
		while(current.getLeft() != null) {
			current = current.getLeft();
		}
		return current;
	}
	public Node<X> findMax() {
		if(isEmpty()) {
			return null;
		}
		Node<X> current = root;
		while(current.getRight() != null) {
			current = current.getRight();
		}
		return current;
	}
	
	// recursive approaches
	public Node<X> search(Node<X> current, X data){
		if(current != null) {
			int val = current.getData().compareTo(data);
			
			if(val == 0) {
				return current;
			}
			if(val <= 0) {
				search(current.getLeft(), data);
			}
			else {
				search(current.getRight(), data);
			}
		}
		
		return null;
	}
	public Node<X> findMin(Node<X> current) {
		if(current == null) {
			return null;
		}
		else if(current.getLeft() == null) {
			return current;
		}
		else {
			return findMin(current.getLeft());
		}
	}
	public Node<X> findMax(Node<X> current) {
		if(current == null) {
			return null;
		}
		else if(current.getRight() == null) {
			return current;
		}
		else {
			return findMax(current.getRight());
		}
	}
	
	// Traversals
	// In Order
	public void inOrder(Node<X> current) {
		if(current != null) {
			inOrder(current.getLeft());
			System.out.println(current.getData() + ", ");
			inOrder(current.getRight());
		}
	}
	
	// Level Order - Queue class needs to be created first
	public void levelOrder(Node<X> root) {
		if(isEmpty()) {
			System.out.println("Empty tree...");
		}
		
		else {
			Queue<X> queue = new Queue<X>();
			
			queue.add(root);
			
			while(!queue.isEmpty()) {
				Node<X> current = queue.getHead();
				System.out.println(current.getData());
				
				if(current.getLeft() != null) {
					queue.add(current.getLeft());
				}
				
				if(current.getRight() != null) {
					queue.add(current.getRight());
				}
				
				queue.dequeue();
			}
			
			
		}
	}
	
	
	// Height of Tree solved with recursion
	public int heightOfTree(Node<X> current) {
		if(root == null) {
			return 0;
		}
		
		if(current == null) {
			return -1;
		}
		
		int h;
		int left = heightOfTree(current.getLeft());
		int right = heightOfTree(current.getRight());
		
		if(left > right) {
			h = left + 1;
		}
		else {
			h = right + 1;
		}
		
		return h;
	}

	// Is Tree a BST? solved with recursion
	public boolean isBST(Node<X> current, X minValue, X maxValue) {
		if(current == null) {
			return true;
		}
		
		if(current.getData().compareTo(minValue) > 0 && current.getData().compareTo(maxValue) <= 0
				&& isBST(current.getLeft(), minValue, current.getData()) 
				&& isBST(current.getRight(), current.getData(), maxValue)) {
			return true;
		}
		else {
			return false;
		}
	}
		
	public static class Queue<X> {
		// First In - First Out
		
		private Node<X> head, tail;
		private int size;
		
		public Queue() {
			head = null;
			size = 0;
		}
		
		public Node<X> getHead() {
			if(head == null) {
				return null;
			}
			else {
				return head;
			}
		}
		
		public boolean isEmpty() {
			return head == null;
		}
		
		public void add(Node<X> node) {
			if(head == null) {
				tail = node; 
				head = tail;
				size++;
				return;
			}
			else {
				tail.next = node;;
				tail = node;
				size++;
				return;
			}
		}
		
		public Node<X> dequeue() {
			Node<X> item = head;
			if(head == null) {
				System.out.println("Queue is empty...");
				return null;
			}
			else {
				head = head.next;
				size--;
				return item;
			}
		}
		
		
	}
	public static class Node<X> {
		private X data;
		private Node<X> next, left, right, parent;
		
		public Node(X data) {
			this.data = data;
			next = left = right = parent = null;
		}
		
		public Node<X> getNext() {
			return next;
		}
		public Node<X> getParent() {
			return parent;
		}
		public Node<X> getLeft() {
			return left;
		}
		public Node<X> getRight() {
			return right;
		}
		public X getData() {
			return data;
		}
		
		public void setNext(Node<X> node) {
			next = node;
		}
		public void setParent(Node<X> node) {
			parent = node;
		}
		public void setLeft(Node<X> node) {
			left = node;
		}
		public void setRight(Node<X> node) {
			right = node;
		}

	}
	
}