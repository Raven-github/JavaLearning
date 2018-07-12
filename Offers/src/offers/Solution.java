package offers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Solution {
	public static void main(String[] args) {
		TreeNode n1 = new TreeNode(1);
		TreeNode n2 = new TreeNode(2);
		TreeNode n3 = new TreeNode(3);
		TreeNode n4 = new TreeNode(4);
		TreeNode n5 = new TreeNode(5);
		TreeNode n6 = new TreeNode(6);
		TreeNode n7 = new TreeNode(7);
		n1.right = n2;
		n1.left = n3;
		n3.left = null;
		n3.right = null;
		n2.left = n6;
		n2.right = null;

		// System.out.println(new Solution().TreeDepth(n1));
		// Long s = System.currentTimeMillis();
		// System.out.println(new Solution().Convert(n1).val);
		// System.out.println(System.currentTimeMillis()-s);
		ListNode l1 = new ListNode(1);
		ListNode l2 = new ListNode(2);
		ListNode l3 = new ListNode(3);
		ListNode l4 = new ListNode(4);
		ListNode l5 = new ListNode(5);
		ListNode l6 = new ListNode(6);
		l1.next = l2;
		l2.next = l3;
		l3.next = l4;
		l5.next = l3;
		l6.next = l5;
		// System.out.println(new Solution().FindFirstCommonNode(l1, null).val);

		// System.out.println(new Solution().EntryNodeOfLoop(l1).val);
		// System.out.println(new Solution().deleteDuplication(l1));
		/*
		 * l1 = new Solution().deleteDuplication(l1); while (l1 != null) {
		 * System.out.println(l1.val); l1 = l1.next; }
		 */
		// System.out.println(new Solution().StrToInt("-123"));
		// Long s1 = System.currentTimeMillis();
		// System.out.println(new Solution().GetUglyNumber_Solution(1000));
		// System.out.println(System.currentTimeMillis() - s1);
		//
		// //HashSet<String> ss=new HashSet<>();
		// ArrayList<String> ss=new ArrayList<>();
		// ss.add("bb");
		// ss.add("aa");
		// System.out.println(ss);
		// String ss = "aaaaaaaabbbbbssdsdsdsdsccssssssk";
		// int x = new Solution().FirstNotRepeatingChar(ss);
		// System.out.println(x);
		// System.out.println(ss.charAt(x));
		// int[] a = { 0, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3, 4, 5, 6, 7 };
		// // System.out.println(new Solution().InversePairs(a));
		// System.out.println(new Solution().GetNumberOfK(a, 2));
		int[] a = { 4, 6, 2, 2, 3, 3, 8, 8, 9, 9, 1000000, 1000000 };
		int[] num1 = new int[1];
		int[] num2 = new int[1];
		new Solution().FindNumsAppearOnce(a, num1, num2);
		// System.out.println(num1[0] + "------------------" + num2[0]);
		// System.out.println(new Solution().FindContinuousSequence(9));
		// int[] num = { 0, 0, 0, 0, 9 };
		// System.out.println(new Solution().FindNumbersWithSum(num, -9));
		// String ss = "student. a am I";
		// System.out.println(new Solution().ReverseSentence(ss));
		// System.out.println(new Solution().isContinuous(num));
		// ArrayList<TreeNode> ad = new ArrayList<>();
		// ad.add(null);
		// System.out.println(ad.size());
		// Long s1 = System.currentTimeMillis();
		// System.out.println(new Solution().LastRemaining_Solution(10000, 2));
		// System.out.println(System.currentTimeMillis() - s1);
		//System.out.println(new Solution().Print(n1));
		System.out.println(new Solution().Serialize(n1));
	}

	public boolean duplicate(int numbers[], int length, int[] duplication) {
		if(numbers.length==0 || numbers==null){
			return false;
		}
	}
	
	
	public String Serialize(TreeNode root) {
		if (root == null) {
			return "#!";
		}
		StringBuilder sb=new StringBuilder();
		ArrayList<ArrayList<TreeNode>> list=Print(root);
		sb.append(root.val+"!");
		for (int i = 1; i < list.size(); i++) {
			ArrayList<TreeNode> temp=list.get(i-1);
			int count=0;
			for(int j=0;j<temp.size();j++){
				if(temp.get(j).left!=null){
					sb.append(list.get(i).get(count++).val+"!");
				}else{
					sb.append("#!");
				}
				
				if(temp.get(j).right!=null){
					sb.append(list.get(i).get(count++).val+"!");
				}else{
					
					sb.append("#!");
				}
			}
		}
		return sb.toString();
	}

	public TreeNode Deserialize(String str) {
		return null;
	}

	ArrayList<ArrayList<TreeNode>> Print(TreeNode pRoot) {
		ArrayList<ArrayList<TreeNode>> listAll = new ArrayList<ArrayList<TreeNode>>();
		if (pRoot == null) {
			return listAll;
		}
		Queue<TreeNode> qu = new LinkedList<TreeNode>();
		qu.add(pRoot);
		TreeNode nus = null;// 空指针标记
		qu.add(nus);
		listAll.add(new ArrayList<TreeNode>());
		while (!qu.isEmpty()) {
			TreeNode temp = qu.poll();
			if (temp != nus) {
				listAll.get(listAll.size() - 1).add(temp);
				if (temp.left != null)
					qu.add(temp.left);
				if (temp.right != null)
					qu.add(temp.right);
			} else {
				if (qu.isEmpty()) {
					break;
				}
				qu.add(nus);
				listAll.add(new ArrayList<TreeNode>());
			}
		}
		return listAll;
	}

	public ArrayList<ArrayList<Integer>> Print1(TreeNode pRoot) {
		ArrayList<ArrayList<Integer>> listAll = new ArrayList<ArrayList<Integer>>();
		if (pRoot == null) {
			return listAll;
		}
		int high = treeHigh(pRoot);
		ArrayList<Stack<TreeNode>> sts = new ArrayList<Stack<TreeNode>>();
		for (int i = 0; i < high; i++) {
			sts.add(new Stack<TreeNode>());
		}
		sts.get(0).add(pRoot);
		boolean left_right = true;
		for (int i = 0; i < high; i++) {
			Stack<TreeNode> tmp = sts.get(i);
			ArrayList<Integer> list = new ArrayList<Integer>();
			if (i == high - 1) {
				while (!tmp.isEmpty()) {
					TreeNode temp = tmp.pop();
					list.add(temp.val);
				}
				listAll.add(list);
				break;
			}
			Stack<TreeNode> next = sts.get(i + 1);

			while (!tmp.isEmpty()) {
				TreeNode temp = tmp.pop();
				list.add(temp.val);
				if (left_right) {
					if (temp.left != null)
						next.push(temp.left);
					if (temp.right != null)
						next.push(temp.right);
				} else {
					if (temp.right != null)
						next.push(temp.right);
					if (temp.left != null)
						next.push(temp.left);
				}
			}
			listAll.add(list);
			left_right = !left_right;
		}

		return listAll;
	}

	public int LastRemaining_Solution(int n, int m) {
		if (n == 1) {
			return 0;
		}
		int[] list2 = new int[n];
		for (int i = 0; i < n; i++) {
			list2[i] = i;
		}
		return turnSomeOne(list2, m);
	}

	public int turnSomeOne(int[] list, int m) {
		if (list.length == 1) {
			return list[0];
		}
		int size = list.length;
		int removeChild = (m % size - 1) == -1 ? (list.length - 1) : (m % size - 1);
		// ArrayList<Integer> li=new ArrayList<>();
		int[] li = new int[size - 1];
		int place = 0;
		for (int i = removeChild + 1; i < size; i++) {
			li[place++] = list[i];
		}
		for (int i = 0; i < removeChild; i++) {
			li[place++] = list[i];
		}
		return turnSomeOne(li, m);
	}

	boolean isSymmetrical(TreeNode pRoot) {
		if (pRoot == null) {
			return false;
		}
		if (pRoot.left == null && pRoot.right == null) {
			return true;
		}
		Queue<TreeNode> left = new LinkedList<>();
		Queue<TreeNode> right = new LinkedList<>();
		ArrayList<TreeNode> leftNumbers = new ArrayList<>();
		ArrayList<TreeNode> rightNumbers = new ArrayList<>();
		left.add(pRoot.left);
		right.add(pRoot.right);
		while (!left.isEmpty()) {
			TreeNode temp = left.poll();
			leftNumbers.add(temp);
			if (temp.right != null || temp.left != null) {
				if (temp.right != null)
					right.add(temp.right);
				else {
					right.add(null);
				}
				if (temp.left != null)
					right.add(temp.left);
				else {
					right.add(null);
				}

			}
		}
		while (!right.isEmpty()) {
			TreeNode temp = right.poll();
			rightNumbers.add(temp);
			if (temp.right != null || temp.left != null) {
				if (temp.right != null)
					right.add(temp.right);
				else {
					right.add(null);
				}
				if (temp.left != null)
					right.add(temp.left);
				else {
					right.add(null);
				}
			}

		}
		if (leftNumbers.size() != rightNumbers.size()) {
			return false;
		} else {
			for (int i = 0; i < leftNumbers.size(); i++) {
				if (leftNumbers.get(i) != null && rightNumbers.get(i) == null) {
					return false;
				} else if (leftNumbers.get(i) == null && rightNumbers.get(i) != null) {
					return false;
				} else if (leftNumbers.get(i) != null && rightNumbers.get(i) != null) {
					if (leftNumbers.get(i).val != rightNumbers.get(i).val) {
						return false;
					}
				}

			}
		}
		return true;
	}

	public boolean isContinuous(int[] numbers) {
		int count = 0;
		Arrays.sort(numbers);
		for (int i = 0; i < numbers.length; i++) {
			if (numbers[i] == 0) {
				count++;
			} else {
				break;
			}
		}
		if (count == 0) {
			return isContinue(numbers);
		} else {
			System.out.println(isContinue(Arrays.copyOfRange(numbers, count, numbers.length)));
			if (isContinue(Arrays.copyOfRange(numbers, count, numbers.length))) {
				return true;
			} else {
				int[] a = Arrays.copyOfRange(numbers, count, numbers.length);
				for (int i = 0; i < a.length - 1; i++) {

					if (a[i] == a[i + 1]) {
						return false;
					} else if (a[i + 1] - a[i] >= 2) {
						count = count - (a[i + 1] - a[i] - 1);
					}
					if (count < 0) {
						return false;
					}

				}
			}
		}
		return true;

	}

	public boolean isContinue(int[] numbers) {
		for (int i = 0; i < numbers.length - 1; i++) {
			if (numbers[i] != numbers[i + 1] - 1) {
				return false;
			}
		}
		return true;
	}

	public String ReverseSentence(String str) {
		if (str.equals("")) {
			return str;
		}
		String[] string = str.split(" ");
		if (string.length == 1) {
			return string[0];
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < string.length; i++) {
			if (i == string.length - 1) {
				sb.append(string[string.length - 1 - i]);
			} else {
				sb.append(string[string.length - 1 - i] + " ");
			}
		}
		return sb.toString();
	}

	public String LeftRotateString(String str, int n) {
		if (str.equals("") || n <= 0 || n > str.length()) {
			return str;
		}
		StringBuilder sb = new StringBuilder(str);
		return new StringBuilder(sb.substring(n, sb.length())).append(sb.substring(0, n)).toString();
	}

	public ArrayList<Integer> FindNumbersWithSum(int[] array, int sum) {
		ArrayList<Integer> list = new ArrayList<>();
		if (array.length == 0 || array == null) {
			return list;
		}
		int start = 0;
		int end = 1;
		int length = array.length - 1;
		while (start < end && end <= length) {
			if (array[start] + array[end] == sum) {
				System.out.println(array[start] + "----------" + array[end]);
				if (list.size() > 0) {
					if (array[start] * array[end] < list.get(0) * list.get(1)) {
						list.remove(0);
						list.remove(1);
						list.add(array[start]);
						list.add(array[end]);
					}
				} else {
					list.add(array[start]);
					list.add(array[end]);
				}

				start++;
				length = end--;
				end = start + 1;
			} else if (array[start] + array[end] > sum) {
				start++;
				end = start + 1;
			} else if (array[start] + array[end] < sum) {
				end++;
			}
		}
		return list;
	}

	public ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
		ArrayList<ArrayList<Integer>> listAll = new ArrayList<ArrayList<Integer>>();
		int i = sum / 2 + 1;
		int start = 1;
		int end = 2;
		while (end <= i) {
			if (sumRange(start, end) == sum) {
				ArrayList<Integer> list = new ArrayList<>();
				for (int j = start; j <= end; j++) {
					list.add(j);
				}
				listAll.add(list);
				start = start + 1;
			} else if (sumRange(start, end) < sum) {
				end++;
			} else if (sumRange(start, end) > sum) {
				start++;
			}
		}
		return listAll;
	}

	public int sumRange(int start, int end) {
		return (start + end) * (end - start + 1) / 2;
	}

	public boolean IsBalanced_Solution(TreeNode root) {
		if (root == null) {
			return true;
		}
		return Math.abs(treeHigh(root.left) - treeHigh(root.right)) <= 1 ? true : false;
	}

	public int treeHigh(TreeNode node) {
		if (node == null) {
			return 0;
		}
		return Math.max(treeHigh(node.left), treeHigh(node.right)) + 1;
	}

	public void FindNumsAppearOnce(int[] array, int num1[], int num2[]) {
		// int size = Integer.MAX_VALUE;
		// int[] num = new int[size];
		// for (int i = 0; i < array.length; i++) {
		// num[array[i]]++;
		// }
		// boolean flag = false;
		// for (int i = 0; i < num.length; i++) {
		// if (num[i] == 1) {
		// if (flag) {
		// num2[0] = i;
		// } else {
		// num1[0] = i;
		// flag = true;
		// }
		// }
		// }
	}

	// 二叉树非递归中序遍历

	public int TreeDepth(TreeNode root) {
		if (root == null) {
			return 0;
		}
		return Math.max(TreeDepth(root.left), TreeDepth(root.right)) + 1;
	}

	public int GetNumberOfK(int[] array, int k) {
		if (array.length == 0 || array == null) {
			return 0;
		}
		int count = 0;
		int low = 0;
		int high = array.length - 1;
		int place = -1;
		while (low <= high) {
			int mid = (low + high) / 2;
			if (array[mid] == k) {
				place = mid;
				break;
			} else if (k < array[mid]) {
				high = mid - 1;
			} else {
				low = mid + 1;
			}
		}
		if (place == -1) {
			return count;
		}
		count++;
		low = place - 1;
		high = place + 1;
		while (high <= array.length - 1) {
			if (array[high] == k) {
				count++;
				high++;
			} else {
				break;
			}
		}
		while (low >= 0) {
			if (array[low] == k) {
				count++;
				low--;
			} else {
				break;
			}
		}
		return count;
	}

	public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
		if (pHead1 == null || pHead2 == null) {
			return null;
		}
		ListNode head1 = pHead1;
		ListNode head2 = pHead2;
		while (head1 != null && head2 != null) {
			head1 = head1.next;
			head2 = head2.next;
		}
		if (head1 != null) {
			while (head1 != null) {
				pHead1 = pHead1.next;
				head1 = head1.next;
			}
		}
		if (head2 != null) {
			while (head2 != null) {
				pHead2 = pHead2.next;
				head2 = head2.next;
			}
		}
		while (pHead1 != null && pHead2 != null) {
			if (pHead1 == pHead2) {
				return pHead1;
			}
			pHead1 = pHead1.next;
			pHead2 = pHead2.next;
		}
		return null;
	}

	public int InversePairs(int[] array) {
		if (array.length == 0 || array == null) {
			return 0;
		}
		int len = array.length;
		int p = len * (len - 1) / 2;
		System.out.println(p);
		return p % 1000000007;

	}

	public int FirstNotRepeatingChar(String str) {
		if (str == "") {
			return 0;
		}
		int[] array = new int[52];
		for (int i = 0; i < str.length(); i++) {
			char x = str.charAt(i);
			int c = 0;
			if (Character.isLowerCase(x)) {
				c = x - 'a';
			} else {
				c = x - 'A' + 26;
			}
			array[c]++;
		}
		for (int i = 0; i < str.length(); i++) {
			char x = str.charAt(i);
			int c = 0;
			if (Character.isLowerCase(x)) {
				c = x - 'a';
			} else {
				c = x - 'A' + 26;
			}
			if (array[c] == 1) {
				return i;
			}
			;
		}
		return 0;
	}

	public int GetUglyNumber_Solution(int index) {
		if (index <= 0) {
			return 0;
		}
		int[] num = new int[index + 1];
		num[1] = 1;
		int min2 = 1;
		int min3 = 1;
		int min5 = 1;
		for (int i = 2; i <= index; i++) {
			num[i] = Math.min(Math.min(num[min2] * 2, num[min3] * 3), num[min5] * 5);
			if (num[min2] * 2 == num[i])
				min2++;
			if (num[min3] * 3 == num[i])
				min3++;
			if (num[min5] * 5 == num[i])
				min5++;
		}
		return num[index];
	}

	public boolean isUgily(int i) {
		if (i % 2 != 0 && i % 5 != 0 && i % 3 != 0 && i == 1) {
			return true;
		}
		if (i % 2 != 0 && i % 5 != 0 && i % 3 != 0 && i != 1) {
			return false;
		}
		while (i % 2 == 0) {
			i = i / 2;
		}
		while (i % 5 == 0) {
			i = i / 5;
		}
		while (i % 3 == 0) {
			i = i / 3;
		}
		if (i == 1) {
			return true;
		} else {
			return false;
		}
	}

	public int mutil(int i) {
		if (i == 0) {
			return 1;
		}
		int result = 1;
		for (int j = 1; j <= i; j++) {
			result = result * 10;
		}
		return result;
	}

	public int StrToInt(String str) {
		if (str.equals("")) {
			return 0;
		}
		int num = 0;
		int flag = 1;
		if (str.charAt(0) == '+') {
			flag = 1;
			str = str.substring(1, str.length());
		} else if (str.charAt(0) == '-') {
			flag = -1;
			str = str.substring(1, str.length());
		}
		for (int i = 0; i < str.length(); i++) {
			if ((str.charAt(str.length() - 1 - i) >= '0' && str.charAt(str.length() - 1 - i) <= '9')) {
				int c = str.charAt(str.length() - 1 - i) - '0';
				num = num + c * mutil(i);
			} else {
				return 0;
			}
		}
		return num * flag;
	}

	/*
	 * public TreeNode Convert(TreeNode pRootOfTree) { if(pRootOfTree==null){
	 * return null; } Stack<TreeNode> stack=new Stack<TreeNode>(); TreeNode
	 * p=pRootOfTree; TreeNode pre=null; TreeNode root=null; boolean
	 * isFirst=true; while(p!=null|| !stack.isEmpty()){ while(p!=null){
	 * stack.push(p); p=p.left; } p=stack.pop(); if(isFirst){ root=p; pre=root;
	 * isFirst=false; }else{ pre.right=p; p.left=pre; pre=p; } p=p.left; }
	 * 
	 * return root; }
	 */

	/*
	 * boolean isSymmetrical(TreeNode pRoot) { if (pRoot==null) { return false;
	 * }
	 * 
	 * }
	 * 
	 * public boolean isLeftEqualRight(TreeNode root1,TreeNode root2){
	 * 
	 * }
	 */

	public TreeLinkNode GetNext(TreeLinkNode pNode) {
		if (pNode == null) {
			return null;
		}
		TreeLinkNode head = pNode;
		ArrayList<TreeLinkNode> list = new ArrayList<>();
		if (pNode.next != null) {
			if (pNode.next.next != null) {
				LNR(pNode.next.next, list);
			} else {
				LNR(pNode.next, list);
			}
		} else {
			LNR(pNode, list);
		}
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i) == head) {
				return i >= list.size() ? null : list.get(i + 1);
			}
		}
		return null;
	}

	public void LNR(TreeLinkNode pNode, ArrayList<TreeLinkNode> list) {
		if (pNode == null) {
			return;
		}
		LNR(pNode.left, list);
		list.add(pNode);
		LNR(pNode.right, list);
	}

	public ListNode deleteDuplication(ListNode pHead) {
		if (pHead == null) {
			return null;
		}
		if (pHead.next == null) {
			return pHead;
		}
		ListNode newHead = pHead;
		ListNode tempNode = pHead.next;
		if (tempNode.val != newHead.val) {
			newHead.next = deleteDuplication(tempNode);
			return newHead;
		} else {
			while (tempNode.val == newHead.val) {

				tempNode = tempNode.next;

			}
			return deleteDuplication(tempNode);
		}
	}

	public ListNode EntryNodeOfLoop(ListNode pHead) {
		if (pHead == null) {
			return null;
		}
		if (pHead.next == pHead) {
			return pHead;
		}
		// ArrayList<ListNode> list=new ArrayList<ListNode>();
		// while(pHead!=null){
		// if(list.contains(pHead)){
		// return pHead;
		// }
		// list.add(pHead);
		// pHead=pHead.next;
		// }
		// return null;
		ListNode pSlow = pHead;
		ListNode pFast = pHead;
		while (pFast != null) {
			pSlow = pSlow.next;
			pFast = pFast.next.next;
			if (pSlow == pFast) {
				pSlow = pHead;
				while (pSlow != pFast) {
					pSlow = pSlow.next;
					pFast = pFast.next;
				}
				return pSlow;
			}
		}
		return null;
	}

	// public ArrayList<String> Permutation(String str) {
	//
	// }
	//
	// public String[] strAppend(String str,ArrayList<String> list){
	// if(str.length()==2){
	// StringBuilder sbb=new StringBuilder(str);
	// String[] ss={sbb.toString(),sbb.reverse().toString()};
	// return ss;
	// }
	// StringBuilder sb=new StringBuilder(str);
	// for(int i=0;i<sb.length();i++){
	// sb.charAt(i)+strAppend(sb.replace(i, i+1, ''.toString()), list);
	// }
	// }

	public TreeNode Convert(TreeNode pRootOfTree) {
		if (pRootOfTree == null) {
			return null;
		}
		if (pRootOfTree.left == null && pRootOfTree.right == null) {
			return pRootOfTree;
		}
		TreeNode left = Convert(pRootOfTree.left);
		TreeNode p = left;
		while (p != null && p.right != null) {
			p = p.right;
		}
		if (left != null) {
			p.right = pRootOfTree;
			pRootOfTree.left = p;
		}

		TreeNode right = Convert(pRootOfTree.right);
		if (right != null) {
			right.left = pRootOfTree;
			pRootOfTree.right = right;
		}
		return left != null ? left : pRootOfTree;
	}

	public void getEvery(TreeNode root, ArrayList<TreeNode> list) {
		if (root == null) {
			return;
		}
		getEvery(root.left, list);
		list.add(root);
		getEvery(root.right, list);
	}

	public RandomListNode Clone(RandomListNode pHead) {
		if (pHead == null) {
			return null;
		}
		RandomListNode newHead = pHead;
		RandomListNode lastNode = pHead;
		RandomListNode tempNode = pHead.next;
		while (tempNode != null) {
			lastNode.next = tempNode;
			lastNode = tempNode;
			tempNode.next = tempNode;
		}
		tempNode = newHead.next;
		pHead = pHead.next;
		while (tempNode != null) {
			tempNode.random = pHead.random;
			tempNode = tempNode.next;
			pHead = pHead.next;
		}
		return newHead;
	}
}
