package DataStructure_Stack;

public class ArrayStack<X> {

    public static void main(String[] args) {
        ArrayStack<Integer> stack = new ArrayStack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(1);
        stack.push(1);

        System.out.println(stack.toString());

        stack.pop();

        System.out.println();
        System.out.println(stack.toString());

        stack.push(3);

        System.out.println();
        System.out.println(stack.toString());

    }

    private X[] data;
    private int size;

    public ArrayStack(int dataSize){
        data = (X[]) new Object[dataSize];
        size = 0;
    }

    public ArrayStack(){
        this(10000);
    }

    private void increaseSize(){
        X[] temp = (X[]) new Object[data.length * 2];
        for(int i = 0; i < data.length; i++){
            temp[i] = data[i];
        }
        data = temp;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public void push(X item){
        if(size == data.length){
            increaseSize();
        }
        data[size++]=item;
    }

    public X pop(){
        if(isEmpty()){
            throw new IllegalArgumentException("Stack empty...");
        }
        return data[--size];
    }

    public X peek(int index){
        return data[index];
    }

    public String toString(){
        StringBuilder sb = new StringBuilder();
        for (int i=0; i<size; i++){
            sb.append(data[i] + ", ");
        }
        return sb.toString();
    }

}
