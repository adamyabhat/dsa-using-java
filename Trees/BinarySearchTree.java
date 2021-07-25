class Node{
    Node left;
    int val;
    Node right;
    Node(int val){
        this.val=val;
    }
}

class BinarySearchTree {   
    static Node root = null;
    static int prev = Integer.MIN_VALUE;
        
    public static Node insert(Node root, int key){
        if(root==null) {
            return new Node(key);
        }
        if (root.val > key) { root.left = insert(root.left, key);}
        if (root.val < key) { root.right = insert(root.right, key);}   
        return root;
    }
        
    public static void inorder(Node head){
        if(head == null) return;
        inorder(head.left);
        System.out.println(head.val);
        inorder(head.right);
    }

    public static Node delete(Node root, int key) {
        if (root == null) { return root; }

        if (root.val > key) { root.left = delete(root.left,key); }
        else if (root.val < key) { root.right = delete(root.right,key); }
        else {
            if (root.left == null) { return root.right; }
            else if (root.right == null) { return root.left; }
            root.val = minValue(root.right);
            root.right = delete(root.right,root.val);
        }
        return root;
    }

    public static int minValue(Node root) {
        int minValue = root.val;
        while(root.left != null){
            minValue = root.left.val;
            root = root.left;
        }
        return minValue;
    }

    public static boolean isBST(Node root)
    {
        if (root == null) return true;
        if (root.left != null && root.val <= root.left.val) return false;
        if (root.right != null && root.val >= root.right.val) return false;
        return isBST(root.left) && isBST(root.right);
    }

	public static void main (String[] args) {
		root = insert(root,100);
		insert(root,101);
		insert(root,50);
		insert(root,75);
		insert(root,30);
		insert(root,45);
		insert(root,48);
		insert(root,49);
		insert(root,46);
		insert(root,35);
		insert(root,36);
		insert(root,33);
        delete(root,100);
        delete(root,45);
        delete(root,49);
        delete(root,30);
        System.out.println("isbst : " + isBST(root));
		inorder(root);
	}
}


