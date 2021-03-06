import Node.BinaryTreeNode;
/**
 * The Lowest Common Ancestor of two nodes n1 and n2 is Node x such that x will be
 * the lowest
 * node which has n1 and n2
 * as it's descendant.
 *
 * resources/BinarySearchTreeLowestCommonAncestor.png
 * resources/BinarySearchTreeLowestCommonAncestorTracing.png
 *
 * Start with the root
 * If root.data > n1.data and root.data > n2.data then lowest common ancestor will be
 * in left subtree
 * If root.data < n1.data and root.data < n2.data then lowest common ancestor will be
 * in right subtree
 * If step 2 and 3 are false then root is the lowest common ancestor and return it.
 *
 *
 * Time Complexity: O(N), where N is the number of nodes in the BST.
 * In the worst case we might be visiting all the nodes of the BST.

 Space Complexity: O(N). This is because the maximum amount of space utilized by the recursion stack would be N
 since the height of a skewed BST could be N.

 Iterative approach

 Time Complexity: O(N)
 Space Complexity: O(1)
 */
public class BinarySearchTreeLowestCommonAncestor {

    private static BinaryTreeNode root = null;

    private static BinaryTreeNode getLCA(BinaryTreeNode root, BinaryTreeNode n1, BinaryTreeNode n2) {
        if (root == null) {
            return null;
        }

        if (root.data > n1.data && root.data > n2.data) {
            return getLCA(root.left, n1, n2);
        } else if (root.data < n1.data && root.data < n2.data) {
            return getLCA(root.right, n1, n2);
        }

        //If you are here that mean root is the Lowest Common Ancestor
        return root;
    }

    public static BinaryTreeNode getLCAIterative(BinaryTreeNode root, BinaryTreeNode n1, BinaryTreeNode n2) {

        BinaryTreeNode node = root;

        while (node != null) {

            if (node.data < n1.data && node.data < n2.data) {
                node = node.right;
            } else if (node.data > n1.data && node.data > n2.data) {
                node = node.left;
            } else {
                return node; //found
            }
        }
        return null;
    }

    private static boolean find(int n) {
        BinaryTreeNode current = root;

        while (current != null) {
            if (current.data == n) {
                return true;
            } else if (current.data > n) {
                current = current.left;
            } else if (current.data < n) {
                current = current.right;
            }
        }
        return false;
    }

    private static BinaryTreeNode insert(int id, BinaryTreeNode root) {
        BinaryTreeNode newNode = new BinaryTreeNode(id);

        if (root == null) {
            return newNode;
        }

        if (id <= root.data) {
            root.left = insert(id, root.left);
        } else {
            root.right = insert(id, root.right);
        }
        return root;
    }

    public static void main(String[] args) {
        root = insert(3, root);
        root = insert(8, root);
        root = insert(1, root);
        root = insert(4, root);
        root = insert(6, root);
        root = insert(2, root);
        root = insert(10, root);
        root = insert(9, root);
        root = insert(20, root);
        root = insert(25, root);
        root = insert(15, root);
        root = insert(16, root);

        BinaryTreeNode node1 = new BinaryTreeNode(6);
        BinaryTreeNode node2 = new BinaryTreeNode(20);

        BinaryTreeNode lca = getLCA(root, node1, node2);

        System.out.println("The lowest common ancestor between 6 and 20 is " + lca.data);

        BinaryTreeNode lca10 = getLCAIterative(root, node1, node2);

        System.out.println("The lowest common ancestor between 6 and 20 iteratively   is " + lca10.data);

        BinaryTreeNode node3 = new BinaryTreeNode(3);
        BinaryTreeNode node4 = new BinaryTreeNode(10);

        BinaryTreeNode lca1 = getLCA(root, node3, node4);

        System.out.println("The lowest common ancestor between 3 and 10 is " + lca1.data);

        BinaryTreeNode node5 = new BinaryTreeNode(16);
        BinaryTreeNode node6 = new BinaryTreeNode(2);

        BinaryTreeNode lca2 = getLCA(root, node5, node6);

        System.out.println("The lowest common ancestor between 16 and 2 is " + lca2.data);

        BinaryTreeNode node7 = new BinaryTreeNode(40);
        BinaryTreeNode node8 = new BinaryTreeNode(50);

        BinaryTreeNode lca3 = getLCA(root, node7, node8);

        if (lca3 == null) {
            System.out.println("Both nodes are not present");
        } else {
            System.out.println("The lowest common ancestor between 40 and 50 is " + lca3.data);
        }

        //If one node is present and other is not
        BinaryTreeNode node9 = new BinaryTreeNode(40);
        BinaryTreeNode node10 = new BinaryTreeNode(20);

        if (find(40) && find(20)) {
            BinaryTreeNode lca4 = getLCA(root, node9, node10);

            if (lca4 == null) {
                System.out.println("Both nodes are not present");
            } else {
                System.out.println("The lowest common ancestor between 40 and 20 is " + lca4.data);
            }
        } else {
            System.out.println("One of the node or both nodes are not present");
        }
    }
}
