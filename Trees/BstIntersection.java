import java.lang.Math;
import java.util.*;
class Node{
    int data;
    Node left,right;
    Node (int d){
        data=d;
        left=right=null;
    }
}
class BstIntersection{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0){
            int n1=sc.nextInt(); // size of 1st bst
            Node root1=null;
            Node root2=null;
            for(int i=0;i<n1;i++){
                int a=sc.nextInt();
                if(root1==null)
                    root1=new Node(a);
                else{
                    insert(root1,a);
                }
            }
            int n2=sc.nextInt(); //size of second bst
            for(int i=0;i<n2;i++){
                int a=sc.nextInt();
                if(root2==null)
                    root2=new Node(a);
                else{
                    insert(root2,a);
                }
            }
            BST g=new BST();
            g.printCommon(root1,root2);
            System.out.println();
        }
    }
    public static Node insert(Node root,int a){
        if(root==null)
            return new Node(a);
        if(root.data>a){
            root.left=insert(root.left,a);
        }
        if(root.data<a)
            root.right=insert(root.right,a);
        return root;
    }
}


class BST
{
    ArrayList<Integer> arr1 = new ArrayList<Integer>();

    ArrayList<Integer> arr2 = new ArrayList<Integer>();

    public void inorder(Node root, ArrayList<Integer> ar){
        if(root == null)
            return;
        else{
            inorder(root.left,ar);
            ar.add(root.data);
            inorder(root.right,ar);
        }
    }


    void Merge(ArrayList<Integer> a, ArrayList<Integer> b){
        int i=0,j=0;
        int m = a.size(), n= b.size();

        while(i<m && j<n){
            if(a.get(i) < b.get(j)){
                i++;
            }
            else if(a.get(i) > b.get(j)){
                j++;
            }
            else{
                System.out.print(a.get(i) +" ");
                i++;
                j++;
            }
        }

    }

  // prints the common nodes in both the bst's

    public void printCommon(Node root1,Node root2)
    {
        inorder(root1,arr1);
        inorder(root2, arr2);
        Merge(arr1,arr2);
    }
}

