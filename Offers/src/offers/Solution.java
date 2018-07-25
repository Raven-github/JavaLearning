package offers;

import java.time.chrono.MinguoChronology;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class Solution {
	public static void main(String[] args) {
		TreeNode n1 = new TreeNode(5);
		TreeNode n2 = new TreeNode(3);
		TreeNode n3 = new TreeNode(7);
		TreeNode n4 = new TreeNode(2);
		TreeNode n5 = new TreeNode(4);
		TreeNode n6 = new TreeNode(6);
		TreeNode n7 = new TreeNode(8);
		// /TreeNode n8 = new TreeNode(10);
		n1.right = n3;
		n1.left = n2;
		n3.left = n6;
		n3.right = n7;
		n2.left = n4;
		n2.right = n5;
		ListNode l1 = new ListNode(0);
		ListNode l2 = new ListNode(1);
		ListNode l3 = new ListNode(2);
		ListNode l4 = new ListNode(3);
		ListNode l5 = new ListNode(4);
		ListNode l6 = new ListNode(5);
		ListNode l7 = new ListNode(6);
		ListNode l8 = new ListNode(7);
		ListNode l9 = new ListNode(8);
		l1.next = l2;
		l2.next = l3;
		l3.next = l4;
		l4.next = l5;
		l5.next = l6;
		l6.next = l7;
		l7.next = l8;
		//l8.next = l9;

		new Solution().reorderList(l1);

	}

	public void reorderList(ListNode head) {
		if (head == null || head.next == null || head.next.next == null) {
			return;
		}
		// 找到中间节点
		ListNode slow = head, fast = head;
		while (fast.next != null && fast.next.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		ListNode rightHead = slow.next;
		slow.next = null;
		// 反转链表后半部分
		ListNode temp = rightHead;
		rightHead = rightHead.next;
		temp.next = null;
		while (rightHead != null) {
			ListNode tp = rightHead;
			rightHead = rightHead.next;
			tp.next = temp;
			temp = tp;
		}
		rightHead = temp;// 反转成功，开始合并
		boolean flag = true;
		ListNode newHead = new ListNode(0);
		ListNode cur = newHead;
		while (head != null || rightHead != null) {
			if (flag) {
				ListNode tm = head;
				head = head.next;
				cur.next = tm;
				cur = tm;
				flag = !flag;
			} else {
				ListNode tm = rightHead;
				rightHead = rightHead.next;
				cur.next = tm;
				cur = tm;
				flag = !flag;
			}
		}
		head = newHead.next;
	}

	public void print(ListNode head){
		ListNode temp=head;
		while(temp!=null){
			System.out.println(temp.val);
			temp=temp.next;
		}
		System.out.println("------------------");
	}
	/***
	 * Given a singly linked list L: L 0→L 1→…→L n-1→L n, reorder it to: L 0→L n
	 * →L 1→L n-1→L 2→L n-2→…
	 * 
	 * You must do this in-place without altering the nodes' values.
	 * 
	 * For example, Given{1,2,3,4}, reorder it to{1,4,2,3}.
	 * 
	 * @param head
	 */
	/*
	 * public void reorderList(ListNode head) { if(head==null || head.next==null
	 * || head.next.next==null){ return ; } ListNode[] res = divideList(head);
	 * ListNode left = res[0], right = res[1], midNode = res[2]; if (midNode ==
	 * null) { boolean flag = true; ListNode temp = right; right = right.next;
	 * temp.next = null; while (left != null || right != null) { if (flag) {
	 * ListNode tm = left; left = left.next; tm.next = temp; temp = tm; flag =
	 * !flag; } else { ListNode tm = right; right = right.next; tm.next = temp;
	 * temp = tm; flag = !flag; } } head = temp; } else { boolean flag=false;
	 * while (left != null || right != null) { if (flag) { ListNode tm = left;
	 * left = left.next; tm.next = midNode; midNode = tm; flag = !flag; } else {
	 * ListNode tm = right; right = right.next; tm.next = midNode; midNode = tm;
	 * flag = !flag; } } head = midNode; } while(head!=null){
	 * System.out.println(head.val); head=head.next; } }
	 * 
	 * public ListNode[] divideList(ListNode head) { ListNode left = null, right
	 * = null, midNode = null; if (head == null) { return null; } ListNode slow
	 * = head, fast = head, temp = head; while (fast.next != null &&
	 * fast.next.next != null) { slow = slow.next; fast = fast.next.next; }
	 * right = slow.next;
	 * 
	 * if (fast.next == null) { ListNode tn = temp.next; temp.next = null;
	 * ListNode flag = slow; while (tn != flag) { ListNode tp = tn.next; tn.next
	 * = temp; temp = tn; tn = tp; } left = temp; midNode = slow; midNode.next =
	 * null; } else { left = slow; ListNode tn = temp.next; temp.next = null;
	 * ListNode flag = slow.next; while (tn != flag) { ListNode tp = tn.next;
	 * tn.next = temp; temp = tn; tn = tp; } midNode = null;
	 * 
	 * } ListNode[] res = new ListNode[3]; res[0] = left; res[1] = right; res[2]
	 * = midNode; return res; }
	 */
	/***
	 * Sort a linked list in O(n log n) time using constant space complexity.
	 * 
	 * @param head
	 * @return
	 */
	public ListNode sortList(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		// ListNode right = getMid(head);
		// ListNode rightNext = right.next;
		// right.next = null;
		// return merget(sortList(head), sortList(rightNext));
		//// ListNode mid = getMid(head);
		//// ListNode midNext = mid.next;
		//// mid.next = null;
		//// return mergeSort(sortList(head), sortList(midNext));
		ArrayList<Integer> list = new ArrayList<>();
		while (head != null) {
			list.add(head.val);
			head = head.next;
		}
		Collections.sort(list);
		ListNode newHead = new ListNode(list.get(0));
		ListNode tempNode = newHead;
		for (int i = 1; i < list.size(); i++) {
			ListNode temp = new ListNode(list.get(i));
			tempNode.next = temp;
			tempNode = temp;
		}
		return newHead;
	}

	public ListNode getMiddelHead(ListNode head) {
		if (head == null) {
			return null;
		}
		ListNode fast = head;
		ListNode slow = head;
		while (fast.next != null && fast.next.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		return slow;
	}

	public ListNode merget(ListNode oneL, ListNode twoL) {
		if (oneL == null) {
			return twoL;
		} else if (twoL == null) {
			return oneL;
		}
		ListNode one = oneL;
		ListNode two = twoL;
		ListNode newList = new ListNode(0);
		ListNode tempNode = newList;
		while (one != null && two != null) {
			if (one.val <= two.val) {
				tempNode.next = one;
				one = one.next;
			} else {
				tempNode.next = two;
				two = two.next;
			}
			tempNode = tempNode.next;
		}
		if (one != null) {
			tempNode.next = one;
		}
		if (two != null) {
			tempNode.next = two;
		}
		return newList.next;
	}

	private ListNode getMid(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		ListNode slow = head, quick = head;
		while (quick.next != null && quick.next.next != null) {
			slow = slow.next;
			quick = quick.next.next;
		}
		return slow;
	}

	private ListNode mergeSort(ListNode n1, ListNode n2) {
		ListNode preHead = new ListNode(0);
		ListNode cur1 = n1;
		ListNode cur2 = n2;
		ListNode cur = preHead;
		while (cur1 != null && cur2 != null) {
			if (cur1.val < cur2.val) {
				cur.next = cur1;
				cur1 = cur1.next;
			} else {
				cur.next = cur2;
				cur2 = cur2.next;
			}
			cur = cur.next;
		}
		if (cur1 != null) {
			cur.next = cur1;
		}
		if (cur2 != null) {
			cur.next = cur2;
		}
		return preHead.next;
	}

	/***
	 * 找到出现一次的数
	 * 
	 * @param A
	 * @return
	 */
	public int singleNumber(int[] A) {
		if (A.length == 1) {
			return A[0];
		}
		Arrays.sort(A);
		for (int i = 0; i < A.length; i++) {
			if (i == 0) {
				if (A[i] != A[i + 1]) {
					return A[i];
				}
			} else if (i == A.length - 1) {
				if (A[i] != A[i - 1]) {
					return A[i];
				}
			} else {
				if (A[i] != A[i + 1] && A[i] != A[i - 1]) {
					return A[i];
				}
			}
		}
		return 0;
	}

	/***
	 * 异或的方法找到出现次数为1的数
	 * 
	 * @return
	 */
	public int singleNumber_two(int[] A) {
		int res = 0;
		for (int i = 0; i < A.length; i++) {
			res = res ^ A[i];
		}
		return res;
	}

	/***
	 * 二叉树的最大深度，递归方法
	 * 
	 * @param root
	 * @return
	 */
	public int maxDepth(TreeNode root) {
		if (root == null) {
			return 0;
		}
		return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
	}

	/***
	 * 二叉树的最大深度，层序遍历方法（队列实现）
	 * 
	 * @param root
	 * @return
	 */
	public int maxDepthQueue(TreeNode root) {
		if (root == null) {
			return 0;
		}
		Queue<TreeNode> qu = new LinkedList<TreeNode>();
		int deep = 0;// 记录深度
		qu.add(root);
		while (!qu.isEmpty()) {
			int size = qu.size();// 二叉树每一层的节点个数，把这些节点取出来，该层遍历结束，深度加1.
			for (int i = 0; i < size; i++) {
				TreeNode temp = qu.poll();
				if (temp.left != null) {
					qu.add(temp.left);
				}
				if (temp.right != null) {
					qu.add(temp.right);
				}
			}
			deep++;
		}
		return deep;
	}

}
