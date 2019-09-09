public class Node {

    private int data;
    private Node next;
    
    // Constructors ****************************************************************
    public Node() {}
    
    public Node(int d) {
        data = d;
        next = null;
    }
    
    // Setters *********************************************************************
    public void setData(int d) {
        data = d;   
    }
    
    public void setNext(Node N) {
        next = N;
    }
    
    // Getters **********************************************************************
    public int getData() {
        return data;   
    }
    
    public Node getNext() {
        return next;   
    }
    
    // Other methods ***************************************************************
    public int sizeFromNode() {
        Node iter = this;
        int size = 0;
        while (iter != null) {
            size++;
            iter = iter.getNext();
        }
        return size;
    }
    
    public void printNode() {
        System.out.println(data);   
    }
}