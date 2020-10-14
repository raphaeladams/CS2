import java.util.ArrayList;

public class BinaryTree 
{
    private String     data;
    private BinaryTree leftChild;
    private BinaryTree rightChild;
    
    // A constructor that takes root data only and
    // makes a tree with no children (i.e., a leaf)
    public BinaryTree(String d) 
    {
        data = d;
        leftChild = null;
        rightChild = null;
    }
    
    // A constructor that takes root data as well as two subtrees
    // which then become children to this new larger tree.
    public BinaryTree(String d, BinaryTree left, BinaryTree right)
    {
        data = d;
        leftChild = left;
        rightChild = right;
    }
    
    // Get methods
    public String getData() { return data; }
    public BinaryTree getLeftChild() { return leftChild; }
    public BinaryTree getRightChild() { return rightChild; }
    
    // Set methods
    public void setData(String d) { data = d; }
    public void setLeftChild(BinaryTree left) { leftChild = left; }
    public void setRightChild(BinaryTree right) { rightChild = right; }
    
    
    // Return the height of the tree
    public int height()  
    {
        // Base case: if there are no more children, return 1
        if (leftChild == null && rightChild == null)
        {
            return 1;
        }
        
        // Recursive case: one or neither child is null
        if (leftChild == null)
        {
            return 1 + rightChild.height();
        }
        else if (rightChild == null)
        {
            return 1 + leftChild.height();
        }
        else
        {
            return 1 + Math.max(leftChild.height(),
                                rightChild.height());
        }
    }
    
    
    // Return all the leaves of the tree
    public ArrayList<String> leafData()  
    {
        ArrayList<String> result = new ArrayList<String>();
        
        if (data != null) 
        {
            // Base case: check if the current tree is a leaf, and if so,
            // add the data
            if ((leftChild == null) && (rightChild == null))
            {
                result.add(data);
            }
        }
        
        // Recursive case: collect the leaves of the children and add them
        if (leftChild != null)
        {
            result.addAll(leftChild.leafData());
        }
        if (rightChild != null)
        {
            result.addAll(rightChild.leafData());
        }
        
        // Return all the leaves part of this tree
        return result;
    }


    // Return whether or not a tree has the same structure and contents as another tree
    public boolean hasSameContentsAs(BinaryTree tree)  
    {
        if (data.equals(tree.data)) // first check if this node's data matches
        {
            // Base case: if neither object has any more children, return true
            if (leftChild == null && rightChild == null)
            {
                return (leftChild == tree.leftChild && 
                    rightChild == tree.rightChild);
            }
            
            // Recursive case: one or neither child is null
            if (leftChild == null)
            {
                return (leftChild == tree.leftChild && 
                    tree.rightChild != null &&
                    rightChild.hasSameContentsAs(tree.rightChild));
            }
            else if (rightChild == null)
            {
                return (rightChild == tree.rightChild && 
                    tree.leftChild != null &&
                    leftChild.hasSameContentsAs(tree.leftChild));
            }
            else
            {
                return (tree.leftChild != null &&
                    leftChild.hasSameContentsAs(tree.leftChild) &&
                    tree.rightChild != null &&
                    rightChild.hasSameContentsAs(tree.rightChild));
            }
        }
        else
        {
            return false; // node data does not match
        }
    }


    // Return the total number of nodes in the tree
    public int numberOfNodes()  
    {
        // Base case: if there are no children, return 1
        if (leftChild == null && rightChild == null)
        {
            return 1;
        }
        
        // Recursive case: one or neither child is null
        if (leftChild == null)
        {
            return 1 + rightChild.numberOfNodes();
        }
        else if (rightChild == null)
        {
            return 1 + leftChild.numberOfNodes();
        }
        else
        {
            return 1 + leftChild.numberOfNodes() + 
                rightChild.numberOfNodes();
        }
    }
}
