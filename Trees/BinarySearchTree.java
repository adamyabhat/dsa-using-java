class Node{
    Node left;
    int val;
    Node right;
    Node(int val){
        this.val=val;
    }
}

class BinarySearchTree {   
    static Node root;
        
    public static void insert(int key){
        Node node = new Node(key);
        if(root==null) {
            root = node;
            return;
        }
        Node prev=null;
        Node temp=root;
        while (temp!=null){
            if(temp.val>key){
                prev=temp;
                temp=temp.left;
            }
            else if (temp.val<key){
                prev=temp;
                temp=temp.right;
            }
        }
        if(prev.val>key)
            prev.left=node;
        else prev.right=node;
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

	public static void main (String[] args) {
		insert(100);
		insert(101);
		insert(50);
		insert(75);
		insert(30);
		insert(45);
		insert(48);
		insert(49);
		insert(46);
		insert(35);
		insert(36);
		insert(33);
        delete(root,100);
        delete(root,45);
        delete(root,49);
        delete(root,30);
        System.out.println("root : " + root.val);
		inorder(root);
	}
}


