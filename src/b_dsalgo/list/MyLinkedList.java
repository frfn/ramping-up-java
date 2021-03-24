package b_dsalgo.list;


import java.util.ArrayList;
import java.util.List;

public class MyLinkedList {

    List<Integer> list = new ArrayList<>();

    {
        list.add(10);

        list.toArray();
    }


}

class Node<X> {

    private X item;
    private int size;

    public Node(X item) {
        this.item = item;
        size = 0;
    }

}

class MyLinkedListMain {
    public static void main(String[] args){

    }
}