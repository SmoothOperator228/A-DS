import java.lang.Exception;
import java.util.Arrays;

public class ArrayList {
//можем замутіть і з іншими типами даних, не тільки Object, Ви тіки скажіть
    private static final int INIT_CAPACITY = 10;
    private static float INCR_COEFF = 2; //коефіцієнт, на який збільшуватиметься масив, при перевищенні ліміту по елементах

    private int capacity;
    private Object[] array;
    private int elements = 0;

    public ArrayList() {
        capacity = INIT_CAPACITY;
        array = new Object[capacity];
    }

    public ArrayList(int capacity) {
        this.capacity = capacity;
        array = new Object[capacity];
    }

    public void add (Object obj){
        //додавання в кінець списку
        if(array.length <= elements){
            arrayIncrease();
        }
        array[elements] = obj;
        elements++;
    }

    public void add (Object obj, int index) throws IndexOutOfBoundsException{
        //тут же можна і виконати додавання в початок, вказавши 0 як індекс

        if(index > elements - 1){
            throw new IndexOutOfBoundsException("Стоять блять, міліція! " +
                    "Індекс виходить за межі списку (" + array.length + ")");
        }
        else if(index == elements){
            add(obj);//по-суті додавання в кінець списку
        }
        else {
            if(array.length <= elements){
                arrayIncrease();
            }
            Object[] tempArr = new Object[array.length + 1];
            for (int i = 0; i < index; i++){
                tempArr[i] = array[i];

            }
            tempArr[index] = obj;
            for (int i = index + 1; i <= array.length; i++){
                tempArr[i] = array[i - 1];
            }
            array = tempArr;
            elements++;

        }
    }

    public void remove(int index){
        //видалення елемента за індексом, по суті і є видаленням початкового, кінцевого та середнього елементів
        if (index > elements - 1){
            throw new IndexOutOfBoundsException("Стоять блять, міліція! " +
                    "Індекс виходить за межі списку (" + array.length + ")");
        }
        Object[] tempArr = new Object[array.length];
        for (int i = 0; i < index; i++){
            tempArr[i] = array[i];
        }
        for (int i = index + 1; i < array.length; i++){
            tempArr[i - 1] = array[i];
        }
        array = tempArr;
        elements--;
    }

    public void remove(Object obj) throws Exception{
        //видалення потрібного елементу
        if (getIndexOf(obj) >= 0){
            remove(getIndexOf(obj));
            return;
        }
        throw new Exception("Стоять блять, міліція! Об'єкт, який Ви хочете видалити," +
                " відсутній у цьому списку ");
    }

    public void replace(int index, Object obj){
        array[index] = obj;
    }

    public void replace(Object changed, Object changer) throws Exception {
        if (contains(changed)){
            replace(getIndexOf(changed), changer);
            return;
        }
        throw new Exception("Стоять блять, міліція! Об'єкт, який Ви хочете замінити," +
                " відсутній у цьому списку ");
    }






    public int getCapacity() {
        return array.length;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int getSize(){
        return elements;
    }

    public int getIndexOf(Object obj){
        //повертає індекс елемента, якщо не знайде цього елемента поверне -1
        for (int i = 0; i < array.length; i++){
            if (array[i].equals(obj)){
                return i;
            }
        }
        return -1;
    }

    public boolean contains(Object obj){
        return (getIndexOf(obj) >= 0);
    }

    private void arrayIncrease(){
        capacity *= INCR_COEFF;
        Object[] newArr = new Object[capacity];
        System.arraycopy(array, 0, newArr, 0, array.length);
        array = newArr;
    }


}