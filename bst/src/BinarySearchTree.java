class Node{
    int data;
    Node left;
    Node right;
    public Node(int data){
        this.data=data;
    }
}
public class BinarySearchTree {
    Node root;
    public void insert(int data) {
        root=insertrec(root,data);
    }
    public Node insertrec(Node root,int data){
        if(root==null){
            root=new Node(data);
        }
        else if(data< root.data){
            root.left=insertrec(root.left,data);
        }else if(data>root.data){
            root.right=insertrec(root.right,data);

        }
        return root;
    }
    public int getheight(Node root){
        if(root==null){
            return 0;
        }else{
            return 1+Math.max(getheight(root.left),getheight(root.right));
        }
    }
    public void disp(){
        int height=getheight(root);
        for(int i=1;i<=
                height;i++){
            printlevel(root,i);
        }
        System.out.println();

    }

    private void printlevel(Node root, int level) {
        if(root ==null){
            return ;
        }
        if(level==1){
            System.out.print(root.data+" ");
        }else{
            printlevel(root.left,level-1);
            printlevel(root.right,level-1);
        }
    }


    public void inorder(){
        inorderrec(root);
        System.out.println();
    }
    public void preorder(){
        preorderrec(root);
        System.out.println();


    }
    public void postorder(){
        postorderrec(root);
        System.out.println();
    }
    public static void inorderrec(Node root){
        if(root!=null){
            inorderrec(root.left);
            System.out.print(root.data+" ");
            inorderrec(root.right);
        }
    }
    private void preorderrec(Node root) {
        if (root != null) {
            System.out.print(root.data + " ");
            preorderrec(root.left);
            preorderrec(root.right);
        }
    }
    private void postorderrec(Node root) {
        if (root != null) {
            postorderrec(root.left);
            postorderrec(root.right);
            System.out.print(root.data + " ");
        }
    }
}
