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

	public static void main (String[] args) {
		insert(30);
		insert(50);
		insert(15);
		insert(20);
		insert(10);
		insert(40);
		insert(60);
		inorder(root);
	}
}


