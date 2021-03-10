package DataStructure_ArrayList;

public class ArrayList<X> {

    private X[] list;
    private int length;

    public ArrayList(){
        list = (X[]) new Object[10];
        length = 0;
    }

    public boolean isEmpty(){
        return length == 0;
    }

    private void increaseSize(){
        X[] newArray = (X[]) new Object[list.length + 1];
        for(int i = 0; i<length; i++){
            newArray[i] = list[i];
        }
        list = newArray;
    }

    public void add(X item){
        if(list.length == length){
            increaseSize();
        }
        list[length++] = item;
    }

    public void addAtIndex(X item, int index){
        if(list.length == length) {
            increaseSize();
        }
        if(index < 0 || index > list.length){
            System.out.println("Invalid index, try again...");
        }
        if(list[index] == null){
            length = index;
            list[index] = item;
            length++;
            return;
        }
        else{
            for(int i = length+1; i > index; i--){
                list[i] = list[i-1];
            }
            list[index] = item;
            length++;
            return;
        }
    }

    public boolean delete(X item){
        if(isEmpty()){
            System.out.println("Empty list..."); return false;
        }
        for(int i = 0; i < length; i++){
            if(item.equals(list[i])){
                if(i == length-1){
                    list[length-1] = null;
                }

                for(int j = i + 1; j < length; j++){
                    list[i++] = list[j];
                }
                length--;
                return true;
            }
        }

        System.out.println("Cannot find item...");
        return false;
    }

    public boolean removeAtIndex(int index){
        if(isEmpty()){
            System.out.println("Empty list...");
            return false;
        }
        if(index < 0 || index >= length){
            System.out.println("Invalid index..."); return false;
        }
        else{
            for (int i = index; i < length; i++){
                list[i] = list[i+1];
            }
            length--;
            return true;
        }
    }

    public String toString(){
        StringBuilder build = new StringBuilder();
        for(int i = 0; i<length; i++){
            build.append(list[i] + ", ");
        }
        return build.toString();
    }

}
