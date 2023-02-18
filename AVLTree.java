public class AVLTree {
    public static void main(String[] args) throws Exception {
       
    }
}

class AvlTree{
    Node root;

    Node rightRotate(Node node){
        Node leftChild = node.left;
        Node rightOfLeftChild = leftChild.right;
        
        rightOfLeftChild = node;
        node.left = rightOfLeftChild;

        update(leftChild);
        update(node);  

        return leftChild;
    }
    Node leftRotate(Node node){
        Node rightChild = node.right;
        Node leftOfRightChild = rightChild.left;
        
        node.right = leftOfRightChild;
        leftOfRightChild = node;

        update(node);
        update(rightChild);

        return rightChild;
    }
    int getHeight(Node node){
        if(node == null){
            return 0;
        }
        return node.height;
    }
    void update(Node node){
        node.height = 1 + Math.max(getHeight(node.left), getHeight(node.right));
    }
    void insert(int value){
        this.root= insert(root, value);
    }

    Node insert(Node node, int value){
        if(node == null){
            node = new Node(value);
            return node;
        }
        if(value > node.value){
            node.right = insert(node.right,value);
        }
        else if(value < node.value){
            node.left = insert(node.left, value);
        }else{
           return node; 
        }
        update(node);

        int balance = getBalance(node);

        if(balance > 1 && value < node.left.value){
            node = rightRotate(node);
        }else if(balance > 1 && value > node.left.value){
            node.left = rightRotate(node);
            node = leftRotate(node);
        }
        if(balance < -1 && value >node.right.value){
            node = leftRotate(node);
        }else if(balance < -1 && value > node.right.value){
            node.right = leftRotate(node);
            node = rightRotate(node);
        }
        return node;
    }
    int getBalance(Node node){
        if(node == null){
            return 0;
        }
        return getHeight(node.left) - getHeight(node.right);
    }
}

class Node{
    Node left;
    Node right;
    int height;
    int value;
    
    Node(int value){
        this.value = value;
        this.height=1;
    }

}

