package DataStructureTree;

/**
 * 
 * @author Flexer
 * 
 * Trees are a recursive data structure. Uses lots of recursion!
 *
 * Binary tree
 *  - Starts as a root node
 *  - Will have two child nodes
 *  
 *  		o
 *  	   / \
 *  	  o   o
 *  	/   \
 *     o     o
 *  	
 *   
 *   
 *  - Adding data in Binary Tree
 *  	- less than root will go left in the tree
 *   	- greater than root will go left in the tree
 *   
 *   					Lincoln
 *   	 			 /			\
 *   		Jefferson			  Washington
 *   	     /     \				/		
 *   	 Jackson  Kennedy		Madison
 *   	/							 \
 *   Adams							Roosevelt	
 *   	\
 *   	Buchanan
 *   
 *   Tree is now unbalanced. 
 *   It is based on comparison, balancing does NOT matter at all.
 *   
 *   it is running logarithmic! O (n log n)
 *   Comes at a cost, most expensive!
 */

// X is data that extends Comparable, makes it possible to compare object
public class BasicBinaryTree<X extends Comparable<X> > {  // Binary Tree
	
	/**
	 * NOTE:
	 * 
	 * KET ATTRIBUTES:
	 * TreeNode root -- root node, the head
	 * int size -- the size of tree,  elements in tree
	 * 
	 */
	
	private TreeNode root;
	private int size;
	
	/**
	 * NOTE:
	 * 
	 * 
	 * KEY ATTRIBUTES:
	 * Constructor -- sets root to null && sets size to 0
	 * 
	 */
	
	public BasicBinaryTree() {  // once instantiated, will just make root null
		this.root = null;
		this.size = 0;
	}
	
	/**
	 * NOTE: This is the insert method that is UNIQUE to trees
	 * 
	 * KEY ATTRIBUTES:
	 * - Parameter: parent , child
	 * - If statement compares the data that is GOING TO BE added, child node, to parent node.
	 * 
	 * 			- if value is LESS than OR EQUAL to parent value:
	 * 				- if left node of parent is empty, add child node to left
	 * 				- else recursively call insert again, ( parent.getLeft(), child) !
	 * 
	 * 				EDIT: You can quickly implement if value is equal to parent, assign to left.
	 * 
	 * 			- if value is MORE than parent value:
	 * 				- if right node of parent is empty, add child node to right
	 * 				- else call insert again (parent.getRight(), child) !
	 * 
	 * 
	 */
	private void insert(TreeNode parent, TreeNode child) {
		
		// Less than 0 means it is less than, comparable makes it possible for Objects to be compared
		if(child.getData().compareTo(parent.getData()) < 0) {  
			
			// If left node is null, we've found out spot
			if(parent.getLeft() == null) {
				parent.setLeft(child);
				child.setParent(parent);
				size++;
			}
			
			// otherwise we need to call insert again and test (recursion)
			else {
				insert(parent.getLeft(), child);  // Mmm, keep dropping down to left if less than value!
			}
			
			/**
			 * Knowing the way the compiler works, and how recursion works... 
			 * parent.getLeft(), child, will be passed in insert and recursion will work!!!... mmm.
			 */
			
		}
		
		// if child is greater than parent, it goes to the right
		else if (child.getData().compareTo(parent.getData()) > 0){
			
			// if right value is null, spot is found
			if(parent.getRight() == null) {
				parent.setRight(child);
				child.setParent(parent);
				size++;
			}
			
			// otherwise call this method again
			else {
				insert(parent.getRight(), child);
			}
			
		}
		
		// if parent and child happen to be equal, we don't do anything
		// data in binary tree is unique and value already exists so it not added
		
		// BUT if you want to add and have duplicates, you can implement here!
		
	}
	
	/**
	 * NOTE: This is used in main.
	 * 
	 * KEY ATTRIBUTES:
	 * - Parameter: takes in value
	 * - TreeNode node: takes the value passed, and puts in node
	 * - if root is null, root is value
	 * - else call insert! 
	 * 		- insert method checks if value is less than (insert left) or if greater than  (insert right)
	 * 
	 */
	public void add(X data) {
		TreeNode node = new TreeNode(data);  // Instantiated a TreeNode called node with passed value of data 
		
		if(root == null) {   // Guard check, if root is empty, root will be node
			root = node;
			System.out.println("Root: " + root.getData());
			size++;
		}
		
		else {
			insert(root, node);  // Wow, this is insane, insert method also already increments the length
		}
	
	}
	
	/**
	 * Contains method();
	 * @param item
	 * @return
	 */
	public boolean contains(X item) {
		TreeNode current = getNode(item);
		
		if (current == null) {
			return false;
		}else {
			return true;
		}
	}
	
	/**
	 * Helper for contains
	 * @param data
	 * @return
	 */
	private TreeNode getNode(X data) {

		/**
		 * Note: This is an iterative approach
		 * 
		 * KEYT ATTRIBUTES:
		 * - current = root: starts from the head
		 * - if value is a match, return node
		 * - if value is less than, then current = current.getLeft();
		 * - if value is greater than, then current = current.getRight();
		 * 
		 * If no value is found, then return null;
		 *
		 */
		TreeNode current = root;
		
		while(current != null) {
			int val = data.compareTo(current.getData());
			
			// if node is a match
			if(val == 0) {
				return current;
			}
			
			// if node is less than 0, go to left side of tree
			else if(val < 0) {
				current = current.getLeft();
			}
			
			// if node is greater, go to right side of tree
			else {
				current = current.getRight();
			}
		}
		
		return null;
		
	}
	
	public boolean delete(X data) {
		 boolean deleted = false;
		 
		 if(root == null) {
			 return false;
		 }
		 
		 TreeNode current = getNode(data);
		 
		 if(current != null) {
			 
			 // If no children, unlink and set to null
			 if(current.getLeft() == null && current.getRight() == null) {
				 unlink(current, null);
				 deleted = true;
			 }
			 
			 // if has right child, replace current with right child
			 else if(current.getLeft() == null && current.getRight() != null) {
				 unlink(current, current.getRight());
				 deleted = true;
			 }
			 
			 // if has left child, replace with left child
			 else if(current.getLeft() != null && current.getRight() == null) {
				 unlink(current, current.getLeft());
				 deleted = true;
			 }
			 
			 // if has 2 children
			 else {
				 TreeNode child = current.getLeft();
				 while (child.getRight() != null && child.getLeft() != null) {
					 child = child.getRight();
				 }
				 
				 // When we get the right most leaf on the left side. Replace current node with this node
				 child.getParent().setRight(null);
				 
				 
				 child.setLeft(current.getLeft());
				 child.setRight(current.getRight());
				 
				 unlink(current, child);
				 deleted = true;
			 }
		 }
		 if (deleted) {
			 size--;
		 }
		 
		 return deleted;
	}
	
	private void unlink(TreeNode current, TreeNode newNode) {  // null is newNode
		// if this is the root node, we replace it differently
		if (current == root) {
			newNode.setLeft(current.getLeft());
			newNode.setRight(current.getRight());  			// so newNode = null in delete
			root = newNode;
		}
		else if (current.getParent().getRight() == current) {  // if it has an element on the right side
			current.getParent().setRight(newNode);  // that will be replaced
		}
		else {
			current.getParent().setLeft(newNode);
		}
		
	}
	
	
	public int size() {
		return size;
	}
	
	private class TreeNode {
		
		/**
		 * NOTE:
		 * 
		 * Node class is how the node is made.
		 * 
		 * KEY ATTRIBUTES:
		 * - X data
		 * - TreeNode left
		 * - TreeNode right
		 * - TreeNode parent
		 * 
		 * Then there are getters and setters for each one.
		 */
		
		/**
		 * These just contains references! So when you're calling getLeft, then getRight
		 *  - it will just get the reference of the left
		 *  	- then the reference of that node and get the right!
		 */
		private TreeNode left;
		private TreeNode right;
		private TreeNode parent; // may not be needed
		private X data;
		
		public TreeNode(X data) {
			this.data = data;
			left = right = parent = null;
		}
		
		public TreeNode getLeft() {
			return left;
		}

		public TreeNode getRight() {
			return right;
		}

		public TreeNode getParent() {
			return parent;
		}

		public X getData() {
			return data;
		}
		
		public void setRight(TreeNode right) {
			this.right = right;
		}
		
		public void setLeft(TreeNode left) {
			this.left = left;
		}

		public void setParent(TreeNode parent) {
			this.parent = parent;
		}

		public void setData(X data) {
			this.data = data;
		}
		
	}

}
