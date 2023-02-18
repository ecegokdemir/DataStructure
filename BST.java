
public class BST {
    public static void main(String[] args) throws Exception {
        // BinarySearchTree bt = new BinarySearchTree();
       // bt.insert(15);
        // bt.insert(3);
        // bt.insert(11);
         // bt.insert(12);
         // bt.insert(10);
        // bt.insert(5);
        // bt.insert(7);
        
    }
}
class Node {
    int value;
     Node leftChild;
     Node rightChild;

    public Node(int value) {
        this.value = value;
        this.leftChild = null;
        this.rightChild = null;
    }

    public int getValue() {
        return value;
    }
    public void setValue(int value) {
        this.value = value;
    }
    public Node getLeftChild() {
        return leftChild;
    }
    public void setLeftChild(Node leftChild) {
        this.leftChild = leftChild;
    }
    public Node getRightChild() {
        return rightChild;
    }
    public void setRightChild(Node rightChild) {
        this.rightChild = rightChild;
    }

    

}

class BinarySearchTree{
     Node root;

    public void preorder(){
        preorder(root);
    }
    public void preorder(Node currentNode){
        if(currentNode == null)
            return;

        System.out.println(currentNode.getValue());
        preorder(currentNode.getLeftChild());
        preorder(currentNode.getRightChild());
            
    }

    public void postorder(){
        postorder(root);
    }
    public void postorder(Node currentNode){
        if(currentNode == null)
            return;

        postorder(currentNode.getLeftChild());
        postorder(currentNode.getRightChild());
        System.out.println(currentNode.getValue());
    }

    public void inorder(){
        inorder(root);
    }
    public void inorder(Node currentNode){
        if(currentNode == null)
            return;

        inorder(currentNode.getLeftChild());
        System.out.println(currentNode.getValue());    
        inorder(currentNode.getRightChild());
        
    }
    public void insert(int value){
        this.root= insert(root, value);
    }


    private Node insert(Node node, int value){
        if(node == null){
            node = new Node(value);
            return node;
        }
        if(value > node.value){
            node.rightChild = insert(node.rightChild,value);
        }
        else{
            node.leftChild = insert(node.leftChild, value);
        }
        return node;
        
    }

    public void delete(Node node,int data){
        if(root == null){
            return;
        }
        if(node.value == data){
            if(node.leftChild != null && node.rightChild != null){
                node = findMax(node);
            }else{
                node = null;
            }
        }else if(node.value < data){
            delete(node.rightChild,data);
        }else{
            delete(node.leftChild,data);
        }
    }
    public Node findMax(Node node){
        Node findNode = new Node(0);
        while(node.rightChild != null){
            findNode = node;
        }
        return findNode;
    }

}
