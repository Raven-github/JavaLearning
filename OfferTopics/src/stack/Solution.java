package stack;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

public class Solution {

	public static void main(String[] args) {
		int[] se = {4,6,12,8,16,14,10};
		System.out.println(new Solution().VerifySquenceOfBST(se));
	}

	public class TreeNode {
		int val = 0;
		TreeNode left = null;
		TreeNode right = null;

		public TreeNode(int val) {
			this.val = val;

		}

	}

	public void addArray(TreeNode root, ArrayList<Integer> array) {
		if (root == null)
			return;
	}

	public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		if (root == null)
			return list;
		Deque<TreeNode> deque = new LinkedList<TreeNode>();

		deque.add(root);
		while (!deque.isEmpty()) {
			TreeNode t = deque.pop();
			list.add(t.val);
			if (t.left != null)
				deque.add(t.left);
			if (t.right != null)
				deque.add(t.right);
		}
		return list;
	}

	public void LRN(TreeNode root, ArrayList<Integer> array) {
		if (root == null) {
			return;
		}
		if (root.left != null) {
			LRN(root.left, array);
		}
		if (root.right != null) {
			LRN(root.right, array);
		}
		array.add(root.val);

	}

	public boolean splitArray(Integer[] se) {
		if (se.length == 0) {
			return true;
		} else if (se.length == 1) {
			return true;
		} else if (se.length == 3) {
			if(se[2]<se[0] && se[2]>se[1]){
				return false;
			}else{
				return true;
			}
		} else if (se.length == 2) {
			return true;
		} else if (se.length > 3) {
			ArrayList<Integer> pro = new ArrayList<>();
			ArrayList<Integer> next = new ArrayList<>();
			int i = 0;
			while(i < se.length - 1) {
				if (se[i] < se[se.length - 1]) {
					pro.add(se[i]);
					i++;
				} else {
					break;
				}
			}
			System.out.println("pro----"+pro);
			while (i < se.length - 1) {
				if(se[i]<se[se.length-1]){
					return false;
				}
				next.add(se[i]);
				i++;
			}
			System.out.println("next----"+next);
			Integer[] first = new Integer[pro.size()];
			Integer[] second = new Integer[next.size()];
			return splitArray(pro.toArray(first)) && splitArray(next.toArray(second));
		}
		return false;

	}

	public boolean VerifySquenceOfBST(int[] sequence) {

		if (sequence.length == 0) {
			return false;
		} else if (sequence.length == 1) {
			return true;
		}else if(sequence.length==2){
			return true;
		}
		Integer[] se = new Integer[sequence.length];
		for (int i = 0; i < se.length; i++) {
			se[i] = sequence[i];
		}		
		return splitArray(se);
	}

}
