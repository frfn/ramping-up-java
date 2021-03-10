package DataStructure_Queue;

/**
 * Remove() had an error, but is fixed.
 */

public class ArrayQueue<X> {
    public static void main(String[] args) {
        ArrayQueue<Integer> arr = new ArrayQueue<>(5);

        arr.add(1);
        arr.add(2);
        arr.add(3);
        arr.add(4);
        arr.add(5);

        arr.remove();

        arr.add(6);

        System.out.println(arr.toString());
    }

    private X[] data;

    // Hot Spot
    private int front, end;

    public ArrayQueue(int size){
        if(size <= 0){
            data = (X[]) new Object[10];
        }
        else{
            data = (X[]) new Object[size];
        }

        // Hot Spot
        front = end = -1;
    }

    private void increaseSize(){
        X[] temp = (X[]) new Object[data.length * 2];
        for(int i = 0; i < data.length; i++){
            temp[i] = data[i];
        }
        data = temp;
    }

    public boolean isEmpty(){
        return front == -1;
    }

    public void add(X item){
        // Hot Spot
        if(((end+1) == data.length)){
            increaseSize();
        }

        if(isEmpty()){
            ++front;
        }
        data[++end] = item;
    }

    public int size(){
        return front == -1 && end == -1 ? 0 : end-front+1;
    }

    // Key Method
    public X remove(){
        if(isEmpty()){
            throw new IllegalArgumentException("Empty queue...");
        }

        X item = null;

        if(front == end){
            item = data[front];
            data[front] = null;
            front = end = -1;
        }
        else{
            item = data[front];
            data[front] = null;
            ++front;
        }

        return item;
    }

    public String toString(){
        StringBuilder sb = new StringBuilder();

        // Hot Spot
        for(int i = front; i<=end; i++){
            sb.append(data[i] + ", ");
        }
        return sb.toString();
    }

}
