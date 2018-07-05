package sort.list;

public class Solution {
	public static void main(String[] args) {
		ListNode lis1 = new ListNode(1);
		ListNode lis2 = new ListNode(2);
		ListNode lis3 = new ListNode(3);
		ListNode lis4 = new ListNode(4);
		lis1.next = lis3;
//		lis3.next = lis2;
//		lis2.next = lis4;
		Solution.printList(lis1);
		System.out.println("------------------------------");
		Solution.printList(new Solution().sortList(lis1));

	}

	public ListNode sortList(ListNode head) {
		if(head==null){
			return null;
		}
		ListNode last = new ListNode(head.val);
		ListNode sortHead = new ListNode(head.val);
		ListNode node=head.next;
		while (node != null) {
			ListNode current = new ListNode(node.val);
			current.next = null;
			if (current.val >= sortHead.val) {
				ListNode temp = sortHead;
				current.next = temp;
				sortHead = current;
			} else if (current.val <= last.val) {
				last.next = current;
				last = current;
			} else {
				ListNode tempHead = sortHead;
				while (tempHead != null) {
					if (current.val < tempHead.val && current.val >= tempHead.next.val) {
						current.next = tempHead.next;
						tempHead.next = current;
						break;
					}
					tempHead = tempHead.next;
				}
			}
			node=node.next;
		}
		return sortHead;
	}

	public static void printList(ListNode head) {
		while (head != null) {
			System.out.println(head.val);
			head = head.next;
		}
	}
}
