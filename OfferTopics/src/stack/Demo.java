package stack;

import java.util.ArrayList;

public class Demo {
	
	
	public static ArrayList<Integer> list=new ArrayList<Integer>();
	
	public static void main(String[] args) {
		TreeNode n1=new TreeNode(5);
		TreeNode n2=new TreeNode(4);
		TreeNode n3=new TreeNode(3);
		TreeNode n4=new TreeNode(2);
		TreeNode n5=new TreeNode(1);
		n1.left=n5;
		n1.right=n2;
		n5.left=n3;
		n5.right=n4;
		new Demo().LRN(n1, list);
		
		System.out.println(list);
	}
	
	public void LRN(TreeNode node,ArrayList<Integer> list){
		if(node==null){
			return ;
		}
		
		if(node.left!=null){
			LRN(node.left,list);
		}
		if(node.right!=null){
			LRN(node.right,list);
		}
		list.add(node.val);
	}

	
}
