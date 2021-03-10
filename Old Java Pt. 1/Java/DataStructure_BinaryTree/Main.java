package DataStructure_BinaryTree;

import java.util.Queue;

public class Main {

    public static void main(String[] args) {

        BinaryTree<Integer> bs = new BinaryTree<Integer>();

        bs.add(50);
        bs.add(30);
        bs.add(75);
        bs.add(40);
        bs.add(20);
        bs.add(15);
        bs.add(76);
        bs.add(80);
        bs.add(79);

        int height = bs.heightOfTree(bs.getRoot());

        System.out.println(height);

        //bs.printLevelOrder();
    }

}
