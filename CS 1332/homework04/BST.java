import java.util.Collection;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Your implementation of a BST.
 *
 * @author Isaac Song
 * @version 1.0
 * @userid isong41
 * @GTID 903808112
 *
 * Collaborators: None
 *
 * Resources: QZJUnits, LucianJUnits, LimayeJunits, VemulapalliJUnits
 */
public class BST<T extends Comparable<? super T>> {

    /*
     * Do not add new instance variables or modify existing ones.
     */
    private BSTNode<T> root;
    private int size;

    /**
     * Constructs a new BST.
     *
     * This constructor should initialize an empty BST.
     *
     * Since instance variables are initialized to their default values, there
     * is no need to do anything for this constructor.
     */
    public BST() {
        // DO NOT IMPLEMENT THIS CONSTRUCTOR!
    }

    /**
     * Constructs a new BST.
     *
     * This constructor should initialize the BST with the data in the
     * Collection. The data should be added in the same order it is in the
     * Collection.
     *
     * Hint: Not all Collections are indexable like Lists, so a regular for loop
     * will not work here. However, all Collections are Iterable, so what type
     * of loop would work?
     *
     * @param data the data to add
     * @throws java.lang.IllegalArgumentException if data or any element in data
     *                                            is null
     */
    public BST(Collection<T> data) {
        if (data == null) {
            throw new IllegalArgumentException("data cannot be null");
        }

        for (T d : data) {
            if (d == null) {
                throw new IllegalArgumentException("element in data cannot be null");
            }

            add(d);
        }
    }

    /**
     * Adds the data to the tree.
     *
     * This must be done recursively.
     *
     * The data becomes a leaf in the tree.
     *
     * Traverse the tree to find the appropriate location. If the data is
     * already in the tree, then nothing should be done (the duplicate
     * shouldn't get added, and size should not be incremented).
     *
     * Must be O(log n) for best and average cases and O(n) for worst case.
     *
     * @param data the data to add
     * @throws java.lang.IllegalArgumentException if data is null
     */
    public void add(T data) {
        if (data == null) {
            throw new IllegalArgumentException("data cannot be null");
        }

        if (root == null) {
            size += 1;
            root = new BSTNode<T>(data);
            return;
        }

        addRecursive(root, data);
    }

    /**
     * Recursive add method for BST
     *
     * @param node current node
     * @param data data to insert
     */
    private void addRecursive(BSTNode<T> node, T data) {
        // go down right
        if (data.compareTo(node.getData()) > 0) {
            if (node.getRight() == null) {
                size += 1;
                node.setRight(new BSTNode<T>(data));
                return;
            }

            addRecursive(node.getRight(), data);
            return;
        }

        // go down left
        if (data.compareTo(node.getData()) < 0) {
            if (node.getLeft() == null) {
                size += 1;
                node.setLeft(new BSTNode<T>(data));
                return;
            }

            addRecursive(node.getLeft(), data);
            return;
        }

        return; // item exists already, no add
    }

    /**
     * Removes and returns the data from the tree matching the given parameter.
     *
     * This must be done recursively.
     *
     * There are 3 cases to consider:
     * 1: The node containing the data is a leaf (no children). In this case,
     * simply remove it.
     * 2: The node containing the data has one child. In this case, simply
     * replace it with its child.
     * 3: The node containing the data has 2 children. Use the successor to
     * replace the data. You MUST use recursion to find and remove the
     * successor (you will likely need an additional helper method to
     * handle this case efficiently).
     *
     * Do not return the same data that was passed in. Return the data that
     * was stored in the tree.
     *
     * Hint: Should you use value equality or reference equality?
     *
     * Must be O(log n) for best and average cases and O(n) for worst case.
     *
     * @param data the data to remove
     * @return the data that was removed
     * @throws java.lang.IllegalArgumentException if data is null
     * @throws java.util.NoSuchElementException   if the data is not in the tree
     */
    public T remove(T data) {
        if (data == null) {
            throw new IllegalArgumentException("data cannot be null");
        }

        if (root == null) {
            throw new NoSuchElementException("empty tree contains no data");
        }

        size -= 1;
        return removeRecursive(root, data, null);
    }

    /**
     * Recursive helper for node removal
     *
     * @param node current node
     * @param data data target to remove node
     * @param prev prev node
     * @return value of removed node
     */
    private T removeRecursive(BSTNode<T> node, T data, BSTNode<T> prev) {
        T result;

        if (node == null) {
            throw new NoSuchElementException("element not found");
        }

        // go down right
        if (data.compareTo(node.getData()) > 0) {
            return removeRecursive(node.getRight(), data, node);
        }

        // go down left
        if (data.compareTo(node.getData()) < 0) { 
            return removeRecursive(node.getLeft(), data, node);
        }

        result = node.getData();
        
        if (node.getLeft() == null && node.getRight() == null) {
            replaceNode(node, null, prev);

        } else if (node.getLeft() != null && node.getRight() == null) {
            replaceNode(node, node.getLeft(), prev);

        } else if (node.getLeft() == null && node.getRight() != null) {
            replaceNode(node, node.getRight(), prev);

        } else if (node.getLeft() != null && node.getRight() != null) {
            BSTNode<T> newNode;

            if (node.getRight().getLeft() == null) {
                newNode = node.getRight();
                node.setRight(node.getRight().getRight());
            } else {
                newNode = successorRecursive(node.getRight(), node);
            }

            newNode.setLeft(node.getLeft());
            newNode.setRight(node.getRight());
            replaceNode(node, newNode, prev);
        }

        return result;
    }

    /**
     * Helper function to replace node
     * @param node current node
     * @param replace node to replace
     * @param prev previous node
     */
    private void replaceNode(BSTNode<T> node, BSTNode<T> replace, BSTNode<T> prev) {
        if (prev == null) {
            root = replace;
        } else if (node.getData().compareTo(prev.getData()) > 0) {
            prev.setRight(replace);
        } else {
            prev.setLeft(replace);
        }
    }

    /**
     * Recursive helper to return successor node and remove successor node
     *
     * @param node current node
     * @param prev prev node
     * @return chosen successor node
     */
    private BSTNode<T> successorRecursive(BSTNode<T> node, BSTNode<T> prev) {
        BSTNode<T> replaceNode;

        // end of leaf left
        if (node.getLeft() == null) {
            replaceNode = node;
            prev.setLeft(node.getRight()); // patch together tree
            return replaceNode;
        }

        return successorRecursive(node.getLeft(), node);
    }

    /**
     * Returns the data from the tree matching the given parameter.
     *
     * This must be done recursively.
     *
     * Do not return the same data that was passed in. Return the data that
     * was stored in the tree.
     *
     * Hint: Should you use value equality or reference equality?
     *
     * Must be O(log n) for best and average cases and O(n) for worst case.
     *
     * @param data the data to search for
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
     * Recursive get method for BST
     *
     * @param node current node
     * @param data data to insert
     * @return target node
     */
    private BSTNode<T> getRecursive(BSTNode<T> node, T data) {
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
     * This must be done recursively.
     *
     * Hint: Should you use value equality or reference equality?
     *
     * Must be O(log n) for best and average cases and O(n) for worst case.
     *
     * @param data the data to search for
     * @return true if the parameter is contained within the tree, false
     * otherwise
     * @throws java.lang.IllegalArgumentException if data is null
     */
    public boolean contains(T data) {
        if (data == null) {
            throw new IllegalArgumentException("data cannot be null");
        }

        try {
            get(data);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }


    /**
     * Generate a pre-order traversal of the tree.
     *
     * This must be done recursively.
     *
     * Must be O(n).
     *
     * @return the preorder traversal of the tree
     */
    public List<T> preorder() {
        return preorderRecursive(root, new ArrayList<T>(size));
    }

    /**
     * Recursive helper function for preorder traversal.
     *
     * @param node current node
     * @param result result list of length tree size
     * @return result list of values
     */
    private List<T> preorderRecursive(BSTNode<T> node, List<T> result) {
        if (node == null) {
            return result;
        }

        result.add(node.getData());
        result = preorderRecursive(node.getLeft(), result);
        result = preorderRecursive(node.getRight(), result);

        return result;
    }

    /**
     * Generate an in-order traversal of the tree.
     *
     * This must be done recursively.
     *
     * Must be O(n).
     *
     * @return the inorder traversal of the tree
     */
    public List<T> inorder() {
        return inorderRecursive(root, new ArrayList<T>(size));
    }

    /**
     * Recursive helper function for inorder traversal.
     *
     * @param node current node
     * @param result result list of length tree size
     * @return result list of values
     */
    private List<T> inorderRecursive(BSTNode<T> node, List<T> result) {
        if (node == null) {
            return result;
        }

        result = inorderRecursive(node.getLeft(), result);
        result.add(node.getData());
        result = inorderRecursive(node.getRight(), result);

        return result;
    }

    /**
     * Generate a post-order traversal of the tree.
     *
     * This must be done recursively.
     *
     * Must be O(n).
     *
     * @return the postorder traversal of the tree
     */
    public List<T> postorder() {
        return postorderRecursive(root, new ArrayList<T>(size));
    }

    /**
     * Recursive helper function for postorder traversal.
     *
     * @param node current node
     * @param result result list of length tree size
     * @return result list of values
     */
    private List<T> postorderRecursive(BSTNode<T> node, List<T> result) {
        if (node == null) {
            return result;
        }

        result = postorderRecursive(node.getLeft(), result);
        result = postorderRecursive(node.getRight(), result);
        result.add(node.getData());

        return result;
    }
    /**
     * Generate a level-order traversal of the tree.
     *
     * This does not need to be done recursively.
     *
     * Hint: You will need to use a queue of nodes. Think about what initial
     * node you should add to the queue and what loop / loop conditions you
     * should use.
     *
     * Must be O(n).
     *
     * @return the level order traversal of the tree
     */
    public List<T> levelorder() {
        List<BSTNode<T>> queue = new ArrayList<BSTNode<T>>(size);
        List<T> result = new ArrayList<T>(size);

        queue.add(root);

        for (int i = 0; i < size; i++) {
            BSTNode<T> node = queue.get(i);
            result.add(node.getData());
            if (node.getLeft() != null) {
                queue.add(node.getLeft());
            }
            if (node.getRight() != null) {
                queue.add(node.getRight());
            }
        }

        return result;
    }

    /**
     * Returns the height of the root of the tree.
     *
     * This must be done recursively.
     *
     * A node's height is defined as max(left.height, right.height) + 1. A
     * leaf node has a height of 0 and a null child has a height of -1.
     *
     * Must be O(n).
     *
     * @return the height of the root of the tree, -1 if the tree is empty
     */
    public int height() {
        return heightRecursive(root, 0) - 1;
    }

    /**
     * Recursive helper for height.
     *
     * @param node current node
     * @param height current height
     * @return maximum root height
     */
    private int heightRecursive(BSTNode<T> node, int height) {
        if (node == null) {
            return height;
        }

        return Math.max(heightRecursive(node.getLeft(), height + 1), heightRecursive(node.getRight(), height + 1));
    }



    /**
     * Clears the tree.
     *
     * Clears all data and resets the size.
     *
     * Must be O(1).
     */
    public void clear() {
        size = 0;
        root = null;
    }

    /**
     * Finds and retrieves the k-largest elements from the BST in sorted order,
     * least to greatest.
     *
     * This must be done recursively.
     *
     * In most cases, this method will not need to traverse the entire tree to
     * function properly, so you should only traverse the branches of the tree
     * necessary to get the data and only do so once. Failure to do so will
     * result in an efficiency penalty.
     *
     * EXAMPLE: Given the BST below composed of Integers:
     *
     *                50
     *              /    \
     *            25      75
     *           /  \
     *          12   37
     *         /  \    \
     *        10  15    40
     *           /
     *          13
     *
     * kLargest(5) should return the list [25, 37, 40, 50, 75].
     * kLargest(3) should return the list [40, 50, 75].
     *
     * Should have a running time of O(log(n) + k) for a balanced tree and a
     * worst case of O(n + k), with n being the number of data in the BST
     *
     * @param k the number of largest elements to return
     * @return sorted list consisting of the k largest elements
     * @throws java.lang.IllegalArgumentException if k < 0 or k > size
     */
    public List<T> kLargest(int k) {
        if (k < 0) {
            throw new IllegalArgumentException("cannot have less than 0 items");
        }

        if (k > size) {
            throw  new IllegalArgumentException("cannot return more elements than size");
        }

        return klargestRecursive(root, k, new LinkedList<T>());
    }

    /**
     * Recursive helper for kLargest.
     *
     * @param node current node
     * @param k number of elements left to add
     * @param result result array to add to
     * @return result array
     */
    private LinkedList<T> klargestRecursive(BSTNode<T> node, int k, LinkedList<T> result) {
        if (node == null) {
            return result;
        }

        result = klargestRecursive(node.getRight(), k, result);
        if (result.size() == k) {
            return result;
        }
        result.addFirst(node.getData());
        result = klargestRecursive(node.getLeft(), k, result);

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
    public BSTNode<T> getRoot() {
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
