
public class Main {
    public static void main(String[] args) {
        BinarySearchTree tree=new BinarySearchTree();
        tree.insert(8);
        tree.insert(5);
        tree.insert(90);
        tree.insert(7);
        tree.insert(4);


        tree.inorder();
        tree.postorder();
        tree.preorder();

        tree.disp();
    }
}