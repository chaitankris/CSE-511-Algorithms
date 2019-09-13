public class Bst {
    public class Node{
        int key;
        Node left,right;
        Node(int item){
            key = item;
            left =right = null;
        }
    }
     private Node root;
     private Bst(){
         root = null;
     }

     /* Inserting a record into bst; */
     private void insert(int key){
         root = insertRec(root,key);
     }
     private Node insertRec(Node root, int key){
         if(root  == null) return new Node(key);

         if(key<root.key) root.left = insertRec(root.left, key);
         else if(key>root.key) root.right = insertRec(root.right,key);

         return root;
     }



     /* Inorder Traversal */
     private void inorder(){
         inordertraversal(root);
     }
     private void inordertraversal(Node root){
         if(root!= null){
             inordertraversal(root.left);
             System.out.print(root.key +" ");
             inordertraversal(root.right);
         }
     }

    private void delete(int key){
         root = deleteNode(root,key);
    }
        // delete node


    Node deleteNode(Node root, int key)
    {
        if(root == null){
            return root;
        }

        if(root.key<key){
            root.right = deleteNode(root.right, key);
        }
        else if(root.key>key){
            root.left = deleteNode(root.left, key);
        }
        else{
            if(root.left == null){
                return root.right;
            }
            else if(root.right == null )
                return root.left;

            root.key = minValue(root.right);

            root.right = deleteNode(root.right, root.key);
        }

        return root;
    }
    int minValue(Node root)
    {
        int minv = root.key;
        while (root.left != null)
        {
            minv = root.left.key;
            root = root.left;
        }
        return minv;
    }


    public static void main(String[] args) {

         Bst tree = new Bst();
         tree.insert(8);
         tree.insert(3);
         tree.insert(6);
         tree.insert(2);
         tree.insert(12);
         tree.insert(15);
         tree.insert(10);
         tree.inorder();
         System.out.println(" After Deleting the 8:");
         tree.delete(8);
         tree.inorder();

    }
}

