 //import com.sun.source.tree.Tree;
package bstproject;
import javax.swing.tree.TreeNode;

public class BinaryTree<E extends Comparable<E>>{
    protected TreeNode<E> root;
    protected int size = 0;
    protected String s1 = "";
    protected String s2 = "";
    protected String s3 = "";
    protected String temp1="";
    protected String temp2="";
    protected String temp3="";

    public BinaryTree() {
    }

    public BinaryTree(E[] objects){
        for(int  i =0; i<objects.length; i++ )
            insert(objects[i]);
    }

    public boolean search(E e){ // seraching elements
        TreeNode<E> current = root;
        while(current != null){
            if(e.compareTo(current.element)<0){
                current = current.left;
            }
            else if (e.compareTo(current.element) >0){
                current = current.right;
            }
            else
                return true;
        }
        return false;
    }


    public boolean insert(E e){ // inserting elements
        if( root == null)
            root = createNewNode(e);
        else {
            TreeNode<E> parent = null;
            TreeNode<E> current = root;
            while (current != null){
                if (e.compareTo(current.element)<0){
                    parent = current;
                    current = current.left;
                }
                else if (e.compareTo(current.element)>0){
                    parent = current;
                    current = current.right;
                }
                else
                    return false;
            }

            if (e.compareTo(parent.element)<0)
                parent.left = createNewNode(e);
            else
                parent.right = createNewNode(e);

        }
        size++; // updating the size whenever a node is added
        return true;
    }

    protected TreeNode<E> createNewNode (E e){
        return new TreeNode<E>(e);
    }

    protected String inorder(TreeNode<E> root){ // inorder traversal
        
        if (root == null) {
            temp1=temp1+"";
            //s=temp;
        }
        else{
        inorder(root.left);
        
        temp1=temp1+root.element+"  ";
        
        inorder(root.right);
         
        }
        s1=s1+temp1;
        temp1="";
        return s1;
        
    }

    protected String postorder(TreeNode<E> root) // postorder traversal
    {
        if (root == null){
            temp2=temp2+"";
        }
        else{
        
        postorder(root.left);
        postorder(root.right);
        temp2=temp2+root.element+"  ";
        }
        s2=s2+temp2;
        temp2="";
        return s2;
    }

    protected String preorder(TreeNode<E> root) // preorder traversal
    {
        if(root == null){
            temp3=temp3+"";
        }
        else{
        temp3=temp3+root.element+"  ";
        preorder(root.left);
        preorder(root.right);
        }
        s3=s3+temp3;
        temp3="";
        return s3;
    }

    public static class TreeNode<E extends Comparable<E>>{
        E element;
        TreeNode<E> left;
        TreeNode<E> right;

        public TreeNode(E e){
            element = e;
        }
    }
    

    public int getSize()
    {
        return size; // return the size of the tree
    }

    public TreeNode getRoot()
    {
        return root; // retur the root
    }
    
    /*         logic for finding the height of the tree
    if(root == null){
    return 0;
    }else{
    int L = treeHeight(root.left);
    int R = treeHeight(root.right);
        if(L>R){
        L=L+1;
    `   }
        else
            R=R+1;
    }
    */    
    public int treeHeight(TreeNode root){ // tree height
		if(root==null)return 0;
		return (1+ Math.max(treeHeight(root.left),treeHeight(root.right)));
	}

    public boolean delete(E e){ //deleting method
        TreeNode<E> parent = null;
        TreeNode<E> current = root;
        while(current != null){ // when current is not null
            if (e.compareTo(current.element)<0){
                parent = current;
                current = current.left;
            }
            else if (e.compareTo(current.element)> 0) {
                parent = current;
                current = current.right;
            }
            else
                break;
        }

        if(current == null){ // if current null
            return false;
        }

        if (current.left == null){ // left of current
            if(parent == null){
                root = current.right;
            }
            else
            {
                if(e.compareTo(parent.element)< 0)
                    parent.left = current.right;
                else
                    parent.right = current.right;
            }
        }
        else // right of current
        {
            TreeNode<E> parentOfRightMost = current;
            TreeNode<E> rightMost = current.left;

            while(rightMost.right != null){
                parentOfRightMost = rightMost;
                rightMost = rightMost.right;
            }
            current.element = rightMost.element;

            if (parentOfRightMost.right == rightMost)
                parentOfRightMost.right = rightMost.left;
            else
                parentOfRightMost.left = rightMost.left;
        }
        size--; // reducing the size as a element is deleted
        return true;

    }

   public void clear(){ // clear the tree
        root = null; // root node as null
        size = 0; // size of the tree as 0
    }
}