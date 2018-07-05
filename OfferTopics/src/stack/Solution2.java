package stack;

import java.util.ArrayList;

public class Solution2 {

	public static void main(String[] args) {

		/*
		 * int[] a={1,2,3,4,5,6,7}; new Solution2().reOrderArray(a); for(int
		 * i=0;i<a.length;i++){ System.out.println(a[i]); }
		 */

		/*
		 * ListNode l1 = new ListNode(1); ListNode l2 = new ListNode(2);
		 * ListNode l3 = new ListNode(3); ListNode l4 = new ListNode(4);
		 * ListNode l5 = new ListNode(5); ListNode l6 = new ListNode(6);
		 * ListNode l7 = new ListNode(7); l1.next = l2; l2.next = l3; l3.next =
		 * l4; l4.next = l5; l5.next = l6; l6.next = l7;
		 * 
		 * ListNode l11 = new ListNode(2); ListNode l21 = new ListNode(3);
		 * ListNode l31 = new ListNode(4); ListNode l41 = new ListNode(6);
		 * ListNode l51 = new ListNode(9); l11.next = l21; l21.next = l31;
		 * l31.next = l41; l41.next = l51;
		 * 
		 * new Solution2().printList(new Solution2().Merge(l1, l11));
		 */

		/*TreeNode n1 = new TreeNode(5);
		TreeNode n2 = new TreeNode(3);
		TreeNode n3 = new TreeNode(3);
		TreeNode n4 = new TreeNode(2);
		TreeNode n5 = new TreeNode(1);
		n1.left = n5;
		n1.right = n2;
		n5.left = n3;
		n5.right = n4;

		TreeNode n6 = new TreeNode(3);
		TreeNode n7 = new TreeNode(2);
		TreeNode n8 = new TreeNode(1);
		n8.left = n6;
		n8.right = n7;

		System.out.println(new Solution2().HasSubtree(n1, n8));*/
		//int[][] num={{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
		int[][] num={{1,2,3},{4,5,6}};
		System.out.println(new Solution2().printMatrix(num));
	}

	
	public ArrayList<Integer> printMatrix(int [][] matrix) {
		   if(matrix==null){
			   return null;
		   }
	       int x=0;
	       int y=0;
	       ArrayList<Integer> num=new ArrayList<Integer>();
	       int xStart=0;
	       int xEnd=matrix.length-1;
	       int yStart=0;
	       int yEnd=matrix[0].length-1;
	       boolean flag=true;
	       while(xEnd>=xStart && yEnd>=yStart){
	    	   if(flag){
	    		   x=xStart;
	    		   y=yStart;
	    		   while(y<=yEnd){
	    			   num.add(matrix[x][y++]);
	    		   }
	    		   y--;
	    		   xStart++;
	    		   x=xStart;
	    		   while(x<=xEnd){
	    			   num.add(matrix[x++][y]);
	    		   }
	    		   x--;
	    		   yEnd--;
	    		   flag=false;
	    	   }else{
	    		   y=yEnd;
	    		   while(y>=yStart){
	    			   num.add(matrix[x][y--]);
	    		   }
	    		   y++;
	    		   xEnd--;
	    		   x=xEnd;
	    		   while(x>=xStart){
	    			   num.add(matrix[x--][y]);
	    		   }
	    		   x++;
	    		   yStart++;
	    		   flag=true;
	    	   }
	    	   System.out.println(xStart);
	    	   System.out.println(xEnd);
	    	   System.out.println(yStart);
	    	   System.out.println(yEnd);
	    	   System.out.println("----------------------");
	       }
	       return num;
    }
	
	
	
	
	public void Mirror(TreeNode root) {
		if(root==null){
			return ;
		}
		TreeNode temp=root.left;
		root.left=root.right;
		root.right=temp;
		Mirror(root.right);
		Mirror(root.left);
	}

	public boolean HasSubtree(TreeNode root1, TreeNode root2) {
		if (root2 == null) {
			return false;
		}
		if (root1 == null && root2 != null) {
			return false;
		}
		boolean flag = false;
		if (root1.val == root2.val) {
			flag = isChildren(root1, root2);
		}
		if (!flag) {
			flag = HasSubtree(root1.left, root2);
			if (!flag) {
				HasSubtree(root1.right, root2);
			}
		}
		return flag;

	}

	public boolean isChildren(TreeNode tree1, TreeNode tree2) {
		if (tree2 == null) {
			return true;
		}
		if (tree1 == null && tree2 != null) {
			return false;
		}
		if (tree1.val == tree2.val) {
			return isChildren(tree1.left, tree2.left) && isChildren(tree1.right, tree2.right);
		} else {
			return false;
		}
	}

	public void printList(ListNode head) {
		while (head != null) {
			System.out.println(head.val);
			head = head.next;
		}
	}

	public ListNode Merge(ListNode list1, ListNode list2) {
		if (list1 == null) {
			return list2;
		}
		if (list2 == null) {
			return list1;
		}
		/*
		 * ListNode newHead = null; ListNode tempNode = null; if (list1.val <=
		 * list2.val) { newHead = list1; tempNode = newHead; list1 = list1.next;
		 * } else { newHead = list2; tempNode = newHead; list2 = list2.next; }
		 * while (list1 != null && list2 != null) { if (list1.val <= list2.val)
		 * { tempNode.next = list1; tempNode = list1; list1 = list1.next; } else
		 * { tempNode.next = list2; tempNode = list2; list2 = list2.next; } } if
		 * (list1 != null) { tempNode.next = list1; } else { tempNode.next =
		 * list2; } return newHead;
		 */
		ListNode newHead = null;
		if (list1.val <= list2.val) {
			newHead = list1;
			newHead.next = Merge(list1.next, list2);
		} else {
			newHead = list2;
			newHead.next = Merge(list1, list2.next);
		}
		return newHead;
	}

	public ListNode ReverseList(ListNode head) {

		/*
		 * ListNode lastNode=new ListNode(head.val); lastNode.next=null;
		 * ListNode newHead=lastNode; while(head.next!=null){ ListNode temp=new
		 * ListNode(head.next.val); temp.next=newHead; newHead=temp;
		 * head=head.next; } return newHead;
		 */
		ListNode newHead = head;
		ListNode Node1 = null;
		// ListNode Node2=null;
		ListNode nodeOnly = head.next;
		// head.next=null;
		while (nodeOnly != null) {
			Node1 = nodeOnly.next;
			nodeOnly.next = newHead;
			newHead = nodeOnly;
			nodeOnly = Node1;
		}
		return newHead;
	}

	public ListNode FindKthToTail(ListNode head, int k) {
		if (head == null || k == 0) {
			return null;
		}
		ListNode one = head;
		ListNode two = head;
		int count = 0;
		while (one != null) {
			if (count == k - 1) {
				break;
			}
			one = one.next;
			count++;
		}
		if (one == null) {
			return null;
		}
		while (one.next != null) {
			two = two.next;
			one = one.next;
		}
		return two;
	}

	public void reOrderArray(int[] array) {
		int[] newArray = new int[array.length];
		int i = 0; // 新数组中奇数开始位置,
		int j = array.length - 1; // 新数组中偶数末尾位置，从后往前插入
		for (int x = 0; x < array.length; x++) { // 一次遍历，一个从前往后找奇数，一个从后往前找偶数
			if (array[x] % 2 != 0) { // 找奇数
				newArray[i] = array[x];
				i++;
			}
			if (array[array.length - 1 - x] % 2 == 0) { // 找偶数
				newArray[j] = array[array.length - 1 - x];
				j--;
			}
		}
		for (int x = 0; x < array.length; x++) { // 赋值给原数组
			array[x] = newArray[x];
		}
	}

	public double Power(double base, int exponent) {
		// Date d=new Date();
		if (exponent == 0) {
			return 1;
		}
		if (base == 0) {
			return 0;
		}
		double ba = base;
		int i = 1;
		int temp = Math.abs(exponent);
		while (true) {
			i = i * 2;
			base = base * base;
			if (i == temp) {
				return exponent > 0 ? base : 1 / base;
			} else if (i < temp && 2 * i > temp) {
				for (int j = i + 1; j <= temp; j++) {
					base = base * ba;
				}
				return exponent > 0 ? base : 1 / base;
			}
		}
	}

	public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
		ArrayList<ArrayList<Integer>> listAll = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> list = new ArrayList<Integer>();
		isEqual(root, target, listAll, list);
		return listAll;
	}

	public int sumList(ArrayList<Integer> list) {
		Integer sum = 0;
		for (Integer item : list) {
			sum += item;
		}
		return sum;
	}

	public void isEqual(TreeNode root, int target, ArrayList<ArrayList<Integer>> listAll, ArrayList<Integer> list) {
		if (root == null) {
			return;
		}
		list.add(root.val);
		if (sumList(list) == target && root.left == null && root.right == null) {
			listAll.add(new ArrayList<>(list));
		}
		if (root.left != null)
			isEqual(root.left, target, listAll, list);
		if (root.right != null)
			isEqual(root.right, target, listAll, list);
		list.remove(list.size() - 1);
	}
}
