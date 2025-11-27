package Trees;

import java.util.Scanner;

public class TreeNode {
    private TreeNode root;
    int val;
     TreeNode left;
      TreeNode right;
     TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }

      public void populateRoot(Scanner scan){
          System.out.println("Enter root value");
          int rootval = scan.nextInt();
           root = new TreeNode(rootval);
          populateTree(scan,root);
      }

    private void populateTree(Scanner scan, TreeNode root) {
        System.out.println("Do you want value on the left of " + root.val);
        boolean left = scan.nextBoolean();
        if(left){
            System.out.println("Enter left node's value: ");
            int val = scan.nextInt();
            root.left = new TreeNode(val);
            populateTree(scan,root.left);
        }
        System.out.println("Do you want value on the right of " + root.val);
        boolean right = scan.nextBoolean();
        if(right){
            System.out.println("Enter right nodes value of " + root.val);
            int val = scan.nextInt();
            root.right = new TreeNode(val);
            populateTree(scan,root.right);
        }
    }
    public void display(){
         display(this.root, " ");

    }
    public void display(TreeNode node, String indent){
         if(node == null){
             return;
         }
        System.out.println(indent +  node.val);
         display(node.left, "");
         display(node.right, indent+ "\t");
    }


}
