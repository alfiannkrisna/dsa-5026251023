import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner read = new Scanner(Main.class.getResourceAsStream("treenumbers.txt"));

        BinarySearchTree treee = new BinarySearchTree();

        String angka = read.nextLine();
        for (String i : angka.split(" ")) {
            treee.insert(Integer.parseInt(i));
        }
        int target = read.nextInt();

        System.out.print("Preorder : ");
        treee.preOrder();

        System.out.print("Inorder : ");
        treee.inOrder();

        System.out.print("Postorder : ");
        treee.postOrder();

        System.out.println("Search " + target + " : " + treee.search(target));
        System.out.println("Nodes : " + treee.countNodes());
        System.out.println("Leaves : " + treee.countLeaves());

        read.close();
    }
}