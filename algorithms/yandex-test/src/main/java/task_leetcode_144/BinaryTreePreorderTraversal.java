package task_leetcode_144;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePreorderTraversal {
    private static final List<Integer> answer = new ArrayList<>();

    public static void main(String[] args) {

    }


    public static List<Integer> preorderTraversal(TreeNode root) {
        stackRoll(root);
        return answer;
    }

    public static void stackRoll (TreeNode node){
        if (node == null){
           return;
        }
        answer.add(node.val);
        stackRoll(node.left);
        stackRoll(node.right);
    }
}
