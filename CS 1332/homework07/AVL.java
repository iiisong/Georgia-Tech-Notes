import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * Your implementation of an AVL.
 *
 * @author Isaac Song
 * @version 1.0
 * @userid isong41
 * @GTID 903808112
 *
 * Collaborators: None
 *
 * Resources: QZ JUnits, Lucian JUnits, SoniJUnits
 */
public class AVL<T extends Comparable<? super T>> {

    // Do not add new instance variables or modify existing ones.
    private AVLNode<T> root;
    private int size;

    /**
     * Constructs a new AVL.
     *
     * This constructor should initialize an empty AVL.
     *
     * Since instance variables are initialized to their default values, there
     * is no need to do anything for this constructor.
     */
    public AVL() {
        // DO NOT IMPLEMENT THIS CONSTRUCTOR!
    }

    /**
     * Constructs a new AVL.
     *
     * This constructor should initialize the AVL with the data in the
     * Collection. The data should be added in the same order it is in the
     * Collection.
     *
     * @param data the data to add to the tree
     * @throws java.lang.IllegalArgumentException if data or any element in data
     *                                            is null
     */
    public AVL(Collection<T> data) {
        if (data == null) {
            throw new IllegalArgumentException("data cannot be null");
        }

        size = 0;
        for (T d : data) {
            add(d);
        }
    }

    /**
     * Adds the element to the tree.
     *
     * Start by adding it as a leaf like in a regular BST and then rotate the
     * tree as necessary.
     *
     * If the data is already in the tree, then nothing should be done (the
     * duplicate shouldn't get added, and size should not be incremented).
     *
     * Remember to recalculate heights and balance factors while going back
     * up the tree after adding the element, making sure to rebalance if
     * necessary.
     *
     * Hint: Should you use value equality or reference equality?
     *
     * @param data the data to add
     * @throws java.lang.IllegalArgumentException if data is null
     */
    public void add(T data) {
        if (data == null) {
            throw new IllegalArgumentException("data cannot be null");
        }

        // System.out.println("new node added: " + data + " =================================");
        root = addRecursive(root, data);
    }

    private AVLNode<T> addRecursive(AVLNode<T> node, T data) {
        // adding leaf node
        if (node == null) {
            AVLNode<T> newNode = new AVLNode<>(data);
            newNode.setHeight(0);
            newNode.setBalanceFactor(0);
            size += 1;
            return newNode;
        }

        // traversal
        if (data.compareTo(node.getData()) < 0) {
            node.setLeft(addRecursive(node.getLeft(), data));
        } else if (data.compareTo(node.getData()) > 0) {
            node.setRight(addRecursive(node.getRight(), data));
        } else {
            return node; // node exists
        }

        return balance(node); // balances
    }

    /**
     * Balances AVL with necessary rotations.
     *
     * @param node root node to balance from
     * @return root node of balanced AVL
     */
    private AVLNode<T> balance(AVLNode<T> node) {
        updateNode(node);

        AVLNode<T> temp;
        // end-right rotation
        if (node.getBalanceFactor() > 1) {
            // left-right
            if (node.getLeft().getBalanceFactor() < 0) {
                System.out.print("left-");
                // left rotation
                temp = node.getLeft();
                node.setLeft(temp.getRight());
                temp.setRight(temp.getRight().getLeft());
                node.getLeft().setLeft(temp);
                updateNode(temp);
            }

            // right rotation
            System.out.println("right rotation");
            temp = node.getLeft();
            node.setLeft(temp.getRight());
            temp.setRight(node);
            updateNode(node);
            updateNode(temp);
            return temp;
        }
        
        // end-left rotation
        if (node.getBalanceFactor() < -1) {
            // right-left
            if (node.getRight().getBalanceFactor() > 0) {
                System.out.print("right-");
                // right rotation
                temp = node.getRight();
                node.setRight(temp.getLeft());
                temp.setLeft(temp.getLeft().getRight());
                node.getRight().setRight(temp);
                updateNode(temp);
            }

            // left rotation
            System.out.println("left rotation");
            temp = node.getRight();
            node.setRight(temp.getLeft());
            temp.setLeft(node);
            updateNode(node);
            updateNode(temp);
            return temp;
        }

        System.out.println("no rotations ran");
        return node;
    }

    /**
     * 
     * @param data
     * @return
     */
    private void updateNode (AVLNode<T> node) {
        // setting height (mostly for non-leaves)
        // "null nodes" -1 height
        int leftHeight = node.getLeft() == null ? -1 : node.getLeft().getHeight();
        int rightHeight = node.getRight() == null ? -1 : node.getRight().getHeight();
        node.setHeight(Math.max(leftHeight + 1, rightHeight + 1));
        // System.out.println("lh = " + leftHeight + ", rh = " + rightHeight);

        // setting bf (mostly for non-leaves)
        node.setBalanceFactor(leftHeight - rightHeight);
        
        System.out.println("new height " + node.getHeight());
        System.out.println("new bf " + node.getBalanceFactor());
    }

    /**
     * Removes and returns the element from the tree matching the given
     * parameter.
     *
     * There are 3 cases to consider:
     * 1: The node containing the data is a leaf (no children). In this case,
     * simply remove it.
     * 2: The node containing the data has one child. In this case, simply
     * replace it with its child.
     * 3: The node containing the data has 2 children. Use the predecessor to
     * replace the data, NOT successor. As a reminder, rotations can occur
     * after removing the predecessor node.
     *
     * Remember to recalculate heights and balance factors while going back
     * up the tree after removing the element, making sure to rebalance if
     * necessary.
     *
     * Do not return the same data that was passed in. Return the data that
     * was stored in the tree.
     *
     * Hint: Should you use value equality or reference equality?
     *
     * @param data the data to remove
     * @return the data that was removed
     * @throws java.lang.IllegalArgumentException if data is null
     * @throws java.util.NoSuchElementException   if the data is not found
     */
    public T remove(T data) {
        if (data == null) {
            throw new IllegalArgumentException("data cannot be null");
        }

        System.out.println("remove ran ==============================================");

        AVLNode<T> resultNode = new AVLNode<T>(null); // smuggle result data
        root = removeRecursive(root, data, resultNode);

        return resultNode.getData();
    }

    private AVLNode<T> removeRecursive(AVLNode<T> node, T data, AVLNode<T> resultNode) {
        if (node == null) {
            throw new NoSuchElementException("cannot remove element not in AVL");
        }

        System.out.println("remove recurse");

        // traversal
        if (data.compareTo(node.getData()) < 0) {
            System.out.println("left");
            node.setLeft(removeRecursive(node.getLeft(), data, resultNode));
            return balance(node);
        } else if (data.compareTo(node.getData()) > 0) {
            System.out.println("right");
            node.setRight(removeRecursive(node.getRight(), data, resultNode));
            return balance(node);

        // found node
        } else {
            System.out.println("found node");
            
            resultNode.setData(node.getData()); // smuggle the data 
            AVLNode<T> replaceNode;
            size -= 1;

            // only left or both nodes
            if (node.getLeft() != null) {
                System.out.println("both children present");
                replaceNode = new AVLNode<T>(null);
                node.setLeft(getPredecessor(node.getLeft(), replaceNode));
                replaceNode.setLeft(node.getLeft());
                replaceNode.setRight(node.getRight());
                System.out.println("replace node with " + replaceNode.getData());
                return balance(replaceNode);

            // only right node
            } else if (node.getRight() != null) {
                System.out.println("right node present");
                replaceNode = node.getRight();
                replaceNode.setLeft(node.getLeft());
                updateNode(node);
                return balance(replaceNode);
            
            // leaf node
            } else {
                System.out.println("no children present");
                return null;
            }
        }
    }

    /** Removes and returns predecessor node through pointer reinforcement.
     * 
     * @param node current node
     * @param resultNode result node object
     * @return updated node
     */
    private AVLNode<T> getPredecessor(AVLNode<T> node, AVLNode<T> resultNode) {
        System.out.println("pred recurse");
        if (node.getRight() == null) {
            System.out.println("found predecessor");
            resultNode.setData(node.getData());
            resultNode.setHeight(node.getHeight());
            resultNode.setBalanceFactor(node.getBalanceFactor());
            return node.getLeft();
        }

        node.setRight(getPredecessor(node.getRight(), resultNode));
        return balance(node);
    }
    /**
     * Returns the element from the tree matching the given parameter.
     *
     * Hint: Should you use value equality or reference equality?
     *
     * Do not return the same data that was passed in. Return the data that
     * was stored in the tree.
     *
     * @param data the data to search for in the tree
     * @return the data in the tree equal to the parameter
     * @throws java.lang.IllegalArgumentException if data is null
     * @throws java.util.NoSuchElementException   if the data is not in the tree
     */
    public T get(T data) {
        if (data == null) {
            throw new IllegalArgumentException("data cannot be null");
        }

        if (root == null) {
            throw new NoSuchElementException("empty tree cannot have data in tree");
        }

        return getRecursive(root, data).getData();
    }

    
    /**
     * Recursive get method for BST/AVL
     *
     * @param node current node
     * @param data data to insert
     * @return target node
     */
    private AVLNode<T> getRecursive(AVLNode<T> node, T data) {
        // go down right
        if (data.compareTo(node.getData()) > 0) {
            if (node.getRight() == null) {
                throw new NoSuchElementException("data not in tree");
            }

            return getRecursive(node.getRight(), data);
        }

        // go down left
        if (data.compareTo(node.getData()) < 0) {
            if (node.getLeft() == null) {
                throw new NoSuchElementException("data not in tree");
            }

            return getRecursive(node.getLeft(), data);
        }

        return node; // item exists
    }

    /**
     * Returns whether or not data matching the given parameter is contained
     * within the tree.
     *
     * Hint: Should you use value equality or reference equality?
     *
     * @param data the data to search for in the tree.
     * @return true if the parameter is contained within the tree, false
     * otherwise
     * @throws java.lang.IllegalArgumentException if data is null
     */
    public boolean contains(T data) {
        try {
            return get(data) != null;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    /**
     * Returns the height of the root of the tree.
     *
     * Should be O(1).
     *
     * @return the height of the root of the tree, -1 if the tree is empty
     */
    public int height() {
        return root == null ? -1 : root.getHeight();
    }

    /**
     * Clears the tree.
     *
     * Clears all data and resets the size.
     */
    public void clear() {
        root = null;
        size = 0;
    }

    /**
     * Returns the data on branches of the tree with the maximum depth. If you
     * encounter multiple branches of maximum depth while traversing, then you
     * should list the remaining data from the left branch first, then the
     * remaining data in the right branch. This is essentially a preorder
     * traversal of the tree, but only of the branches of maximum depth.
     *
     * This must be done recursively.
     *
     * Your list should not have duplicate data, and the data of a branch should be
     * listed in order going from the root to the leaf of that branch.
     *
     * Should run in worst case O(n), but you should not explore branches that
     * do not have maximum depth. You should also not need to traverse branches
     * more than once.
     *
     * Hint: How can you take advantage of the balancing information stored in
     * AVL nodes to discern deep branches?
     *
     * Example Tree:
     *                           10
     *                       /        \
     *                      5          15
     *                    /   \      /    \
     *                   2     7    13    20
     *                  / \   / \     \  / \
     *                 1   4 6   8   14 17  25
     *                /           \          \
     *               0             9         30
     *
     * Returns: [10, 5, 2, 1, 0, 7, 8, 9, 15, 20, 25, 30]
     *
     * @return the list of data in branches of maximum depth in preorder
     * traversal order
     */
    public List<T> deepestBranches() {
        return deepestBranchesRecursive(root);
    }

    /**
     * Returns deepestBranches of node recursively.
     *
     * @param node current node
     * @return LinkedList of deepest branches
     */
    private List<T> deepestBranchesRecursive(AVLNode<T> node) {
        List<T> result = new LinkedList<T>();

        if (node == null) {
            return result;
        }

        result.add(node.getData());

        if (node.getLeft() != null && node.getLeft().getHeight() == node.getHeight() - 1) {
            result.addAll(deepestBranchesRecursive(node.getLeft()));
        }

        if (node.getRight() != null && node.getRight().getHeight() == node.getHeight() - 1) {
            result.addAll(deepestBranchesRecursive(node.getRight()));
        }

        return result;
    }


    /**
     * Returns a sorted list of data that are within the threshold bounds of
     * data1 and data2. That is, the data should be > data1 and < data2.
     *
     * This must be done recursively.
     *
     * Should run in worst case O(n), but this is heavily dependent on the
     * threshold data. You should not explore branches of the tree that do not
     * satisfy the threshold.
     *
     * Example Tree:
     *                           10
     *                       /        \
     *                      5          15
     *                    /   \      /    \
     *                   2     7    13    20
     *                  / \   / \     \  / \
     *                 1   4 6   8   14 17  25
     *                /           \          \
     *               0             9         30
     *
     * sortedInBetween(7, 14) returns [8, 9, 10, 13]
     * sortedInBetween(3, 8) returns [4, 5, 6, 7]
     * sortedInBetween(8, 8) returns []
     *
     * @param data1 the smaller data in the threshold
     * @param data2 the larger data in the threshold
     * @return a sorted list of data that is > data1 and < data2
     * @throws IllegalArgumentException if data1 or data2 are null
     * or if data1 > data2
     */
    public List<T> sortedInBetween(T data1, T data2) {
        if (data1 == null) {
            throw new IllegalArgumentException("data1 cannot be null");
        }

        if (data2 == null) {
            throw new IllegalArgumentException("data2 cannot be null");
        }

        if (data1.compareTo(data2) > 0) {
            throw new IllegalArgumentException("data1 cannot be greater than data2");
        }

        return sibRecursive(root, data1, data2);

    }

    /**
     * sortInBetween Recursive helper.
     * 
     * @param node current node
     * @param data1 lower bound
     * @param data2 upper bound
     * @return list of values
     */
    private List<T> sibRecursive (AVLNode<T> node, T data1, T data2) {
        List<T> result = new LinkedList<T>();

        if (node == null) {
            return result;
        }

        if (data1.compareTo(node.getData()) >= 0) {
            // System.out.println("left bound");
            result.addAll(sibRecursive(node.getRight(), data1, data2));
        } else if (data2.compareTo(node.getData()) <= 0) {
            // System.out.println("right bound");
            result.addAll(sibRecursive(node.getLeft(), data1, data2));
        } else {
            // System.out.println("in bounds");
            result.addAll(sibRecursive(node.getLeft(), data1, data2));
            result.add(node.getData());
            result.addAll(sibRecursive(node.getRight(), data1, data2));
        }
        
        return result;
    }


    /**
     * Returns the root of the tree.
     *
     * For grading purposes only. You shouldn't need to use this method since
     * you have direct access to the variable.
     *
     * @return the root of the tree
     */
    public AVLNode<T> getRoot() {
        // DO NOT MODIFY THIS METHOD!
        return root;
    }

    /**
     * Returns the size of the tree.
     *
     * For grading purposes only. You shouldn't need to use this method since
     * you have direct access to the variable.
     *
     * @return the size of the tree
     */
    public int size() {
        // DO NOT MODIFY THIS METHOD!
        return size;
    }
}
