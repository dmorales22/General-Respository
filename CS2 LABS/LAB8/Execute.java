public class Execute { 
	public static void main(String[] args) { 
		StackA A = new StackA(4); 
		
		A.push(2); 
		A.push(4); 
		A.push(3); 
		A.push(6); 
		
		A.pop(); 
		A.pop();
		A.pop();
		A.pop();
		
		System.out.println(A.peek()); 
		
		A.clear(); 
		
		System.out.println(A.peek()); 
		System.out.println(A.isEmpty()); 
		System.out.println(A.isFull()); 
		
		
		Node N = new Node(2); 
		StackL List = new StackL(N); 
		
		List.push(3); 
		List.push(4); 
		
		List.pop();
		
		System.out.println(List.peek()); 
		List.clear(); 
		System.out.println(List.peek());
		
		
		List.push(11); 
		System.out.println(List.peek() + " " + List.getSize());
		List.pop(); 
		System.out.println(List.peek()); 
		System.out.println(); 
		
		QueueA QA = new QueueA(3); 
		QA.enqueue(1); 
		QA.enqueue(2); 
		QA.enqueue(3); 
		QA.dequeue(); 
		QA.dequeue(); 
		QA.dequeue(); 
		QA.enqueue(6); 
		System.out.println(QA.peek()); 
		QA.clear(); 
		QA.dequeue();
		
		System.out.println(); 
		
		QueueL QL = new QueueL(N);
		
		QL.enqueue(7); 
		QL.enqueue(8); 
		QL.dequeue(); 
		QL.dequeue(); 
		System.out.println(QL.peek());
		QL.enqueue(12);
		QL.dequeue(); 
		System.out.println(QL.peek());
		QL.clear(); 
		System.out.println(QL.peek());
		QL.enqueue(2);
		System.out.println(QL.peek());
	}



}