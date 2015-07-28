/*
Sorted insert for circular linked list
Write a function to insert a new value in a sorted Circular Linked List (CLL).
*/
/*
1) Linked List is empty:  
    a)  since new_node is the only node in CLL, make a self loop.      
          new_node->next = new_node;  
    b) change the head pointer to point to new node.
          *head_ref = new_node;
2) New node is to be inserted just before the head node:    
  (a) Find out the last node using a loop.
         while(current->next != *head_ref)
            current = current->next;
  (b) Change the next of last node. 
         current->next = new_node;
  (c) Change next of new node to point to head.
         new_node->next = *head_ref;
  (d) change the head pointer to point to new node.
         *head_ref = new_node;
3) New node is to be inserted somewhere after the head: 
   (a) Locate the node after which new node is to be inserted.
         while ( current->next!= *head_ref && 
             current->next->data < new_node->data)
         {   current = current->next;   }
   (b) Make next of new_node as next of the located pointer
         new_node->next = current->next;
   (c) Change the next of the located pointer
         current->next = new_node; 
*/
/*
notice:
涉及Java的参数传递问题 when there will create a stack to store the value, how to pass the value, similar to the stack space complexity about recursive funtion
if method has void return, it is hard to print out result in main function, e.g. get null pointer error
里面改了head指向 但外面的head仍然指向null
可以返回 赋值
可以外面加容器
可以写在一个类里
可以static head
*/
public class Sorted_Insert {
	
	public static CNode sortedInsert(CNode start, CNode new_node) {
		CNode current = start;
		
		if (current == null) {
			new_node.next = new_node;
			start = new_node;
	
		} else if (current.val >= new_node.val) {
			while (current.next != start) {
				current = current.next;
			}
			current.next = new_node;
			new_node.next = start;
			start = new_node; 
			
		} else {
			while (current.next != start && current.next.val < new_node.val) {
				current = current.next;
			}
			new_node.next = current.next;
			current.next = new_node;
		}
		return start;
	}
	
	public static class CNode {
		int val;
		CNode next;
		public CNode(int x) {
			val = x;
		}
	}
	
	public static void main(String[] args) {
		
		int[] arr = {12, 56, 2, 11, 1, 90};
		
		CNode start = null;
		
		for (int i = 0; i < 6; i++) {
			CNode tmp = new CNode(arr[i]);
			CNode rst = sortedInsert(start, tmp);
			start = rst;
		}

		int cnt = 0;
		while (cnt < 7) {
			System.out.print(start.val + " ");
			start = start.next;
			cnt++;
		}
	}
}
