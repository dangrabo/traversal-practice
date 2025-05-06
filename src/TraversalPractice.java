public class TraversalPractice {
  
  /**
   * Prints the odd values of the nodes in a tree.
   * Each value is printed on a separate line.
   * The nodes are traversed post-order.
   * 
   * @param node The root of the tree to print
   */
  public static void printOddNodes(Node<Integer> node) {
    if (node == null) return;
    printOddNodes(node.left);
    printOddNodes(node.right);
    if (node.value % 2 == 1) System.out.println(node.value);
  }

  /**
   * Prints the values of the nodes that have exactly one child in a tree.
   * Each value is printed on a separate line.
   * The nodes are traversed pre-order.
   * 
   * @param <T> The type of value the nodes hold
   * @param node The root of the tree to print
   */
  public static <T> void printNodesWithOneChild(Node<T> node) {
    if (node == null) return;
    if (node.left == null && node.right != null) System.out.println(node.value);
    if (node.right == null && node.left != null) System.out.println(node.value);
    printNodesWithOneChild(node.left);
    printNodesWithOneChild(node.right);
  }

    /**
   * Returns the sum of the values of all nodes in a tree.
   * Edge Case:
   *   Returns 0 if node is null
   *  
   * @param node The root of the tree
   * @return the sum 
   */
  public static int treeSum(Node<Integer> node) {
    if (node == null) return 0;
    return node.value + treeSum(node.left) + treeSum(node.right);
  }

  /**
   * Returns the maximum value stored in a tree.
   * Assumes all values are positive.
   * Edge case:
   *   Returns 0 if node is null.
   * 
   * @param node The root of the tree
   * @return the max value
   */
  public static int maxVal(Node<Integer> node) {
    if (node == null) return 0;
    int currentMax = node.value;
    int left = maxVal(node.left);
    int right = maxVal(node.right);
    if (left > currentMax) currentMax = left;
    if (right > currentMax) currentMax = right;
    return currentMax;
  }

  /**
   * Returns the number of levels in the tree.
   * Edge cases: 
   *   Returns 0 if node is null, returns 1 if there is only a root with no children.
   * 
   * @param <T> The type of value the nodes hold
   * @param node The root of the tree
   * @return The number of levels in the tree
   */
  public static <T> int numLevels(Node<T> node) {
    if (node == null) return 0;
    int left = 1 + numLevels(node.left);
    int right = 1 + numLevels(node.right);
    if (left > right) return left;
    else return right;
  }

  public static void main(String[] args) {
    /*
     *         99
     *       /    \
     *     45      82
     *    /  \        \
     *   9   5       16
     */

     // Replace the below line to create a tree 
     // as represented in the diagram above
     Node<Integer> smallTree = new Node<>(99, 
                                  new Node<Integer>(45, 
                                      new Node<Integer>(9, null, null), 
                                      new Node<Integer>(5, null, null)), 
                                  new Node<Integer>(82, 
                                      null, 
                                      new Node<Integer>(16, null, null)));
System.out.println(" ");
System.out.println(maxVal(smallTree));
System.out.println(treeSum(smallTree));
System.out.println(numLevels(smallTree));



    /*
     *              42
     *          /       \
     *       17           63
     *      /  \            \
     *     9    21           87
     *    /    /  \          /
     *   3    19   25     76
    */

    Node<Integer> largeTree = new Node<>(42,
        new Node<>(17, // 17 is left child of 42
                new Node<>(9, // 9 is the left child of 17
                        new Node<>(3, null, null), // 3 is the left child of 9
                        null), // no right child of 9
                new Node<>(21, // 21 is the right child of 17
                        new Node<>(19, null, null), // 19 is the left child of 21
                        new Node<>(25, null, null))), // 25 is the right child of 21
        new Node<>(63, // 63 is right child of 42
                null, // no left child of 63
                new Node<>(87, // 87 is right child of 63
                        new Node<>(76, null, null), // 76 is the left child of 87
                        null))); // no right child of 87
  }
}