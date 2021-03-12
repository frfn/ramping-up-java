package b_1_ArrayListX;

import java.util.Arrays;

// a generic, you can fill it with a type you like
public class MyArrayList<X> {

    private X list[];
    private int size;

    // for the sake of learning, this is unchecked casting! See the book mark on this on Google Chrome
    public MyArrayList() {
        list = (X[]) new Object[10];

        // init block
        {
            Arrays.fill(list, null);

            /*
            Same as:
            1. for(int i = 0; i < list.length; i++){
                   list[i] = null;
               }
            */

        }

        size = 0;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    private void increaseSize() {

        // Unchecked casting
        X[] newArray = (X[]) new Object[list.length + 10];

        // init block
        {
            Arrays.fill(newArray, null);
        }
        System.arraycopy(list, 0, newArray, 0, list.length);
        /*
        Same as:
        1. for(int i = 0; i < list.length; i++) {
               newArray[i] = list[i];
           }
        */
        list = newArray;
    }

    // adding
    public String add(X item){
        if(list.length == size) {
            increaseSize();
        }
        list[size++] = item;
        return item + " is successfully added.";
    }

    // add at index
    public String add(int index, X item) {
        if(list.length == size){
            increaseSize();
        }
        if(index < 0 || index > list.length){
            throw new IndexOutOfBoundsException();
        }
        if(list[index] == null){
            list[index] = item;
            size++;
            return item + " is successfully added.";
        } else {
            // if the size of array is 10, there can only 9 elements starting from 0.
            // So, if you were to go over by 1, it is an out of bounds error since the size will be greater
            // use: -1 OR either <= | >= to fix the 'off-by-one' error
            for(int i = list.length-1; i > index; i--) {
                list[i] = list[i-1];
            }
            list[index] = item;
            size++;
            return item + " is successfully added.";
        }
    }

    // delete item
    public String delete(X item){
        if(isEmpty()){
            return "Array is Empty";
        }
        for(int i = 0; i < list.length; i++){
            if(item.equals(list[i])){
                list[i] = null;
                size--;
                break;
            }
        }
        return item + " does not exist!";
    }

    // delete at index
    public String removeAtIndex(int index) {
        if(isEmpty()){
            return "Array is empty";
        }
        if(list[index] != null) {
            list[index] = null;
            return "You have successfully deleted an item at index " + index;
        }
        else {
            return "No item to be deleted at index " + index;
        }
    }

    // print
    public void print() {
        for(X item: list) {
            if(item != null)
                System.out.print(item + ", ");
        }
    }

    // size
    public void printSize(){
        System.out.println("\nTotal Size: " + size);
    }

}

class Main {
    public static void main(String[] args) {
        MyArrayList<Integer> list = new MyArrayList<Integer>(); // instantiate list

        // add items
        list.add(1);
        list.add(3, 10);
        list.add(7, 12);

        // remove item
        System.out.print(list.removeAtIndex(4));

        // view
        System.out.println();
        list.print();
    }
}