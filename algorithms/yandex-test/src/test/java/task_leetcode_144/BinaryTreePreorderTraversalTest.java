package task_leetcode_144;

import org.assertj.core.api.ListAssert;
import org.junit.jupiter.api.Test;


import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;


class BinaryTreePreorderTraversalTest {

    @Test
    void preorderTraversal() {
        TreeNode treeNode1 = new TreeNode(2, new TreeNode(1), new TreeNode(3));
        TreeNode treeNode2 = new TreeNode();
        TreeNode treeNode3 = new TreeNode(1);
        TreeNode treeNode4 = new TreeNode(4,
                new TreeNode(3, new TreeNode(2), new TreeNode(1)),
                new TreeNode(5, new TreeNode(8), new TreeNode(9)));


        assertAll(
                () ->assertThat(BinaryTreePreorderTraversal.preorderTraversal(treeNode4))
                        .hasSize(7).isNotEmpty(),
                () -> assertThat(BinaryTreePreorderTraversal.preorderTraversal(treeNode1))
                        .hasSize(3).isNotEmpty(),
                () -> assertThat(BinaryTreePreorderTraversal.preorderTraversal(treeNode2))
                        .isEmpty(),
                () -> assertThat(BinaryTreePreorderTraversal.preorderTraversal(treeNode3))
                        .hasSize(1).isNotEmpty().contains(1)

        );
    }
}