/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package llnode;

public class LinkedList {
	// head: reference variable to the first node of the list
    private LLnode head;
    
    // CONSTRUCTORS
    public LinkedList() {
        head = null;
    }
	
	/* Below are MANY methods that are used on Linked Lists.
	 * 
	 * Examples:
	 * search, insert, delete, isEmpty, sumNodes, and many more
	 */
	
	//
	// boolean | isEmpty()
	//
	public boolean isEmpty() {
		return head == null;
	}
	
	
	//
	// boolean | search(int)
	//
	public boolean search(int data) {
		return search(head, data);
	}
	//
	// boolean | search(LLnode, int)
	//
	private boolean search(LLnode p, int data) {
		LLnode helpPtr = p;
		while (helpPtr != null) {
			if (helpPtr.getData() == data)
				return true;
			helpPtr = helpPtr.getNext();			
		}
		return false;
	}


	//
	// boolean | search(int)
	//
	public LLnode findNode(int data) {
		return findNode(head, data);
	}
	//
	// boolean | search(LLnode, int)
	//
	private LLnode findNode(LLnode p, int data) {
		LLnode helpPtr = p;
		while (helpPtr != null) {
			if (helpPtr.getData() == data)
				return helpPtr;
			helpPtr = helpPtr.getNext();			
		}
		return null;
	}
        public int FindLargest() {
		return FindLargest(head);
	}
	//
	// boolean | search(LLnode, int)
	//
	private int FindLargest(LLnode head) {
		LLnode helpPtr = head;
                int largest =head.getData();
		while (helpPtr != null) {
			if (helpPtr.getData() >= largest){
			largest=helpPtr.getData();			
		}
		helpPtr=helpPtr.getNext();
        }
        return largest;
	}
        
        public int Data2ndNode (){
             return Data2ndNode (head);
            }
       private int Data2ndNode (LLnode head){
                return head.getNext().getData();
		
}
       
public void swapFirstLast(){
       swapFirstLast(head);
       }
       private void swapFirstLast(LLnode head){
           LLnode helpPtr = head;
           int swap =head.getData();
           while(helpPtr!=null){
               if(helpPtr.getNext()==null){
                   head.setData(helpPtr.getData());
                   helpPtr.setData(swap);
               }
               helpPtr=helpPtr.getNext();
           }
           
 
        } 
       
       public void countEvenOddNodes(){
countEvenOddNodes(head);
}
private void countEvenOddNodes(LLnode head ){
int EvenNodes=0;
int OddNodes=0;
LLnode helpPtr = head;
while(helpPtr!=null){
               if(helpPtr.getData()%2==0)
                   EvenNodes++;
               else
                OddNodes++;   
               helpPtr=helpPtr.getNext();
  }
System.out.println("Number of even nodes in the list is "+EvenNodes);
System.out.println("Number of odd nodes in the list is "+OddNodes);
}
public void addNodeAfter (int data){
addNodeAfter (head, data);
}
private void addNodeAfter (LLnode head, int data){
    LLnode p=findNode(data);
    LLnode thenew =new LLnode(data*2);
    thenew.setNext(p.getNext());
    p.setNext(thenew);

}

public void deleteNodeAfter(int data){
deleteNodeAfter(head, data);
}
private void deleteNodeAfter(LLnode head, int data){
    LLnode p=findNode(data);
    p.setNext(p.getNext().getNext());
}

public boolean hasOne() {
    if(head.getNext()==null)
        return true;
    else
        return false;
    
    
}      
	
	
	//
	// void | PrintList()
	//
	public void PrintList() {
		PrintList(head);
	}
	//
	// void | PrintList(LLnode)
	//
	private void PrintList(LLnode head) {
		// We need to traverse...so we need a help ptr
		LLnode helpPtr = head;
		// Traverse to correct insertion point
		while (helpPtr != null) {
			// Print the data value of the node
			System.out.print(helpPtr.getData() + ", ");
			// Step one node over
			helpPtr = helpPtr.getNext();
		}
		System.out.println();
	}
	
	
	//
	// void | PrintList()
	//
	public void ModifyAllNodes() {
		ModifyAllNodes(head);
	}
	//
	// void | PrintList(LLnode)
	//
	private void ModifyAllNodes(LLnode head) {
		// We need to traverse...so we need a help ptr
		LLnode helpPtr = head;
		// Traverse to correct insertion point
		while (helpPtr != null) {
			// We add 10 to the data value of each node
			helpPtr.setData(helpPtr.getData() + 10);
			// Step one node over
			helpPtr = helpPtr.getNext();
		}
	}
	
	
	//
	// int | sumNodes()
	//
	public int sumNodes() {
		return sumNodes(head);
	}
	//
	// int | sumNodes(BSTnode)
	//
	private int sumNodes(LLnode head) {
		// We need to traverse...so we need a help ptr
		LLnode helpPtr = head;
		int sum = 0; // counter
		// Traverse to correct insertion point
		while (helpPtr != null) {
			// Increase sum
			sum += helpPtr.getData();
			// Step one node over
			helpPtr = helpPtr.getNext();
		}
		return sum;
	}
	
	
	//
	// void | insert(int)
	//
	public void insert(int data) {
		head = insert(head, data);
	}
	//
	// LLnode | insert(LLnode, value)
	//
	private LLnode insert(LLnode head, int data) {
		// IF there is no list, newNode will be the first node, so just return it
		if (head == null || head.getData() > data) {
			head = new LLnode(data, head);
			return head;
		}
		
		// ELSE, we have a list. Insert the new node at the correct location
		else {
			// We need to traverse to the correct insertion location...so we need a help ptr
			LLnode helpPtr = head;
			// Traverse to correct insertion point
			while (helpPtr.getNext() != null) {
				if (helpPtr.getNext().getData() > data)
					break; // we found our spot and should break out of the while loop
				helpPtr = helpPtr.getNext();
			}
			// Now make the new node. Set its next to point to the successor node.
			// And then make the predecessor node point to the new node
			LLnode newNode = new LLnode(data, helpPtr.getNext());
			helpPtr.setNext(newNode);
		}
		// Return head
		return head;
	}
	
	
	//
	// void | delete(int)
	//
	public void delete(int data) {
		head = delete(head, data);
	}
	//
	// LLnode | delete(LLnode, value)
	//
	private LLnode delete(LLnode head, int data) {
		// We can only delete if the list has nodes (is not empty)
		if (!isEmpty()) {
			// IF the first node (at the head) has the data value we are wanting to delete
			// we found it. Delete by skipping the node and making head point to the next node.
			if (head.getData() == data) {
				head = head.getNext();
			}
			// ELSE, the data is perhaps somewhere else in the list...so we must traverse and look for it
			else {
				// We need to traverse to find the data we want to delete...so we need a help ptr
				LLnode helpPtr = head;
				// Traverse to correct deletion point
				while (helpPtr.getNext() != null) {
					if (helpPtr.getNext().getData() == data) {
						helpPtr.setNext(helpPtr.getNext().getNext());
						break; // we deleted the value and should break out of the while loop
					}
					helpPtr = helpPtr.getNext();
				}
			}
			// return the possibly updated head of the list
			return head;
		}
		return head;
	}
	
}