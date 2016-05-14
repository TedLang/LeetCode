/*102. Binary Tree Level Order Tranversal
Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).

For example:
Given binary tree {3,9,20,#,#,15,7},
    3
   / \
  9  20
    /  \
   15   7
return its level order traversal as:
[
  [3],
  [9,20],
  [15,7]
]*/
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root == null)
			return null;
		List<List<Integer>> result = new ArrayList<ArrayList<Integer>>();
		if(root.left == null && root.right == null){
		    ArrayList<Integer> rootOnly = new ArrayList<Integer>();
		    rootOnly.add(root.val);
		    result.add(rootOnly);
		} else {
			ArrayList<TreeNode> nextLayer = new ArrayList<TreeNode>();
			ArrayList<TreeNode> currLayer = new ArrayList<TreeNode>();
			ArrayList<Integer> currLevel = new ArrayList<Integer>();

			currLevel.add(root.val);
			result.add(currLevel);

			if(root.left != null){
			    nextLayer.add(root.left);
			}
			if(root.right != null){
			    nextLayer.add(root.right);
			}

			while(nextLayer.size() != 0){
			    currLayer = nextLayer;
			    nextLayer.clear();
			    currLevel.clear();
				for(int i=0; i<currLayer.size(); i++){
				    TreeNode tmp = currLayer.get(i);
				    if(tmp != null){
				        currLevel.add(tmp.val);
				        if(tmp.left != null){
				            nextLayer.add(tmp.left);
				        }
				        if(tmp.right != null){
				            nextLayer.add(tmp.right);
				        }
				    }
				}
			}
		}
		return result;
    }
}
