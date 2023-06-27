/*
 * implementation of a Binary Tree
 * Consider 2 classes in a tree. One is public (the main BT class with a public Node)
 * the second is the Node inside the tree (the private one which has value , left and right nodes)
 * we will be populating this tree with values and asking user if they want to add to left or rigth
 * and displaying accordingly
 */
import java.util.Scanner;
import org.w3c.dom.Node;

class BinaryTree {
    
    public BinaryTree (){

    }
    public Node root;

    private static class Node{
        int value;
        Node left;
        Node right;

        public Node(int value){
            this.value = value;
        }
    }
//just calls the main populate function multiple times. This is called by main
    public void populate(Scanner sc){ 
        System.out.println("Enter root node value");
        int value = sc.nextInt();
        root = new Node(value);
        populate(sc, root);
    }
//mian populate function
    public void populate(Scanner sc, Node node){ 

        System.out.println("Do you want to enter to the left of the node" +node.value);
        boolean left = sc.nextBoolean();
        if(left){
            System.out.println("Enter value to the left of the node");
            int value = sc.nextInt();
            node.left = new Node(value);
            populate(sc, node.left);
        }

        System.out.println("Do you want to enter to the right of the node " +node.value);
        boolean right = sc.nextBoolean();
        if(right){
            System.out.println("Enter value to the right of the node");
            int value = sc.nextInt();
            node.right = new Node(value);
            populate(sc, node.right);
        }
    }
    //just calls the main display function. This is called by main method
    public void display(){
        display(root, "");
    }
    //main display function
    private void display(Node node, String indent){
       if(root == null){
        return;
       }

      System.out.println( indent + node.value);
      display(node.left, indent + "\t");
      display(node.left, indent + "\t");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BinaryTree obj = new BinaryTree();
        obj.populate(sc); //populate tree with user inputs 
        obj.display(); //display tree in output
    }
}