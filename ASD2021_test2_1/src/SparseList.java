import java.util.Arrays;
//size, time O(n) - загальна складність
public class SparseList{
    private static final int INIT_CAPACITY = 100;
    private static float INCR_COEFF = 2; //коефіцієнт, на який збільшуватиметься масив, при перевищенні ліміту по елементах

    private int capacity;
    private int[] array;
    private int elements = 0;

    public SparseList() {//time O(1), size O(1)
        capacity = INIT_CAPACITY;
        array = new int[capacity];
    }

    public SparseList(int capacity) {//time O(1), size O(n)
        this.capacity = capacity;
        array = new int[capacity];
    }


    public int get(int index){ //time O(1)
        return array[index];
    }

    public void remove(int index) { //time O(n), size O(n)
        if (index > array.length - 1){
            throw new IndexOutOfBoundsException("Індекс виходить за межі списку (" + array.length + ")");
        }
        int[] tempArr = new int[array.length];
        for (int i = 0; i < index; i++){
            tempArr[i] = array[i];
        }
        for (int i = index + 1; i < array.length; i++){
            tempArr[i - 1] = array[i];
        }
        array = tempArr;
        elements--;
    }
    public void set(int index, int data){ //time, size O(n)
        if (index > array.length - 1){
            int coeff = index/(array.length - 1);
            INCR_COEFF = coeff + 1;
            arrayIncrease();
        }
        if (isFirst(index)){
            array[index] = index;
            elements++;
            return;
        }
        if (isLast(index)){
            array[index] = array.length - index - 1;
            elements++;
            return;
        }
        array[index] = data;
        elements++;
    }

    public int getLength(){
        return elements;
    }

    private boolean isLast(int index){ //time O(n)
        for (int i = index + 1; i < array.length; i++){
            if(array[i] != 0){
                return false;
            }
        }
        return true;
    }

    private boolean isFirst(int index){ //time O(n)
        for (int i = index - 1; i >= 0; i--){
            if(array[i] != 0){
                return false;
            }
        }
        return true;
    }

    public void sortNonEmpty(){ // time, size O(n)
        int[] tempArr = new int[elements]; //size O(n)
        int j = 0;
        for (int i = 0; i < array.length; i++){ //
            if (array[i] != 0){
                tempArr[j] = array[i];
                j++;
            }
        }
        Arrays.sort(tempArr); //quick sort is used here, so time O(n*log(n)), size O(n)
        j = 0;
        for (int i = 0; i < array.length; i++){ //time O(n)
            if (array[i] != 0){
                array[i] = tempArr[j];
                j++;
            }
        }
    }

    private void arrayIncrease(){ //time O(n), size O(n)
        capacity *= INCR_COEFF;
        int[] newArr = new int[capacity];
        System.arraycopy(array, 0, newArr, 0, array.length);
        array = newArr;
    }
    



}