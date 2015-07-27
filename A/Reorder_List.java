public class Reorder_List {
	public static void reorder(ListNode head) {
		if (head == null) {
			return;
		} else if (head.next == null) {
			return;
		}
		ListNode pre = findMidPre(head);
		ListNode right = pre.next;
		pre.next = null;
		right = reverse(right);
		pre.next = right;
	}
	
	public static ListNode reverse(ListNode node) {
		if (node == null) {
			return null;
		}
		
		ListNode dummy = new ListNode(0);
		while (node != null) {
			ListNode tmp = node.next;
			node.next = dummy.next;
			dummy.next = node;
			node = tmp;
		}
		return dummy.next;
	}
	
	public static ListNode findMidPre(ListNode node) {
		if (node == null) {
			return null;
		}
		
		ListNode fast = node.next;
		ListNode slow = node;
		while (fast != null && fast.next != null && fast.next.next != null) {
			fast = fast.next.next;
			slow = slow.next;
		}
		return slow;
	}
	
	public static class ListNode {
		int val;
		ListNode next;
		public ListNode(int x) {
			val = x;
		}
		
		public String printForward() {
			if (next != null) {
				return val + "->" + next.printForward();
			} else {
				return ((Integer) val).toString();
			}
		}
	}
	
	public static void main(String[] args) {
		ListNode n1 = new ListNode(1);
		ListNode n2 = new ListNode(2);
		ListNode n3 = new ListNode(3);
		ListNode n4 = new ListNode(4);
		ListNode n5 = new ListNode(5);
		// ListNode n6 = new ListNode(6);
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;
		n5.next = null;
		reorder(n1);
		System.out.print(n1.printForward());
	}
}
