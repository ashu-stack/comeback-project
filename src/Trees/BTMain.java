package Trees;

import java.util.Scanner;

public class BTMain {

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode();
        Scanner scanner = new Scanner(System.in);
        treeNode.populateRoot(scanner);
        treeNode.display();

    }

}
