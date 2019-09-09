/**** This class defines the blueprint of a node that wraps information of a generic type T, 
 **** and that has 2 links to 2 potential "children" called left and right.
 **** Most of the code is given to you. You are asked to complete a few TODOs as shown below. 
 **** There are 3 TODOs in this file (TODO 1, TODO 2, and TODO 3).
 ****/

public class BTNode<T> {

    private T data;
    private BTNode<T> left;
    private BTNode<T> right;
    
    // Constructors ****************************************************************
    public BTNode() {}
    
    public BTNode(T d) {
        data = d;
        left = null;
        right = null;
    }
    
    // Setters *********************************************************************
    public void setData(T d) {
        data = d;   
    }
    
    public void setLeft(BTNode<T> L) {
        left = L;
    }
    
    public void setRight(BTNode<T> R) {
        right = R;
    }
    
    // Getters **********************************************************************
    public T getData() {
        return data;   
    }
    
    public BTNode<T> getLeft() {
        return left;   
    }
    
    public BTNode<T> getRight() {
        return right;   
    }
    
    // Other methods ***************************************************************
    /* printNode prints the content of the current node */
    public void printNode() {
        System.out.println(data.toString());   
    }

    /* Height computes the height of the current node */
    public int height() {
        if (this == null) {
			return -1;
		}
		
        if (right == null && left == null) { 
			return 0;
		}
		
        return 1 + Math.max(left.height(), right.height());
    }
    
    /* SizeBelow computes the number of nodes that are part of the subtree
     * originating at the current node, including this current node 
     * TODO 1. Complete the implementation of the method sizeBelow.
     * Your implementation must be RECURSIVE */
    public int sizeBelow() {
        if (this == null) { //If tree is null, it just returns zero. 
			return 0; 
		}
		
		if (right != null && left != null) { //If the left and right of that node is not null, it create two nodes from the left and right, and returns 2 and calls the method again twice.   
			BTNode<T> iterL = this.getLeft();
 			BTNode<T> iterR = this.getRight(); 
			return 2 + iterL.sizeBelow() + iterR.sizeBelow();
		}
		if (right != null && left == null) { //If right is not null and left is null, it creates a new node from the right, and returns 1 and calls the method again. 
			BTNode<T> iter = this.getRight(); 
			return 1 + iter.sizeBelow(); 
		}
		if (right == null && left != null) { //If left is not null and left is null, it creates a new node from the right, and returns 1 and calls the method again. 
			BTNode<T> iter = this.getLeft(); 
			return 1 + iter.sizeBelow(); 
		}
		return 0; //Returns 0 if there is no left or right node. 
    }
    
    /* hasLeft returns true if the current node has a non null left child, false otherwise 
     * TODO 2. Complete the implementation of the method hasLeft.
     */
    public boolean hasLeft() {
        if (this == null) { //Returns false if tree is empty. 
			return false; 
		}
		if (left != null) {  //Returns true if left node is not null. 
			return true; 
		}
		return false; //Returns false it left is null. 
    }
    
    /* hasRight returns true if the current node has a non null right child, false otherwise 
     * TODO 3. Complete the implementation of the method hasLeft.
     */
    public boolean hasRight() {
        if (this == null) { //Returns false if tree is empty.
			return false; 
		}
		if (right != null) { //Returns true if right node is not null. 
			return true; 
		}
		return false; //Returns false it right is null. 
    }
}