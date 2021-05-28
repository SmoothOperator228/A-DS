import java.util.ArrayList;

public class BHeap {
    public static ArrayList<Integer> list = new ArrayList<Integer>();

    public static void siftUp() {
        int current = list.size() - 1;
        while (current > 0) {
            int parent = (current - 1) / 2;
            if (list.get(parent) < list.get(current)) {
                //swap
                int temp = list.get(current);
                list.set(current, list.get(parent));
                list.set(parent, temp);
            }
            else {
                break;
            }
            //level++
            current = parent;
        }
    }

    public static void siftDown() {
        int current = 0;

        while (current <= list.size() - 1) {
            int leftChild = (2 * current) + 1;
            int rightChild = (2 * current) + 2;
            int locationOfMax = current;

            if ((leftChild <= list.size() - 1) && (rightChild <= list.size() - 1)) {
                if (list.get(rightChild) > list.get(current)) locationOfMax = rightChild;
                if (list.get(leftChild) > list.get(current)) locationOfMax = leftChild;
                if (locationOfMax != current) {
                    //swap
                    int temp = list.get(current);
                    list.set(current, list.get(locationOfMax));
                    list.set(locationOfMax, temp);
                } else {
                    break;
                }
                //level--
                current = locationOfMax;
            }
            else {
                break;
            }
        }

    }

    public int delete() throws Exception {
        if (list.isEmpty() == true) {
            throw new Exception("The Heap is empty");
        }
        if (list.size() == 1) {
            return list.remove(0);
        }
        int current = 0;
        int topValue = list.get(current);
        list.set(current, list.get(list.size() - 1));
        list.remove(list.size() - 1);
        siftDown();
        return topValue;

    }

    public void insert(int item) {
        list.add(item);
        siftUp();
    }


    public int size() {
        return list.size();
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }

    public String toString() {
        return list.toString();
    }

    public void heapSort() throws Exception {
        int tempVar;
        for (int i = 0; i < list.size()-1; i++)
        {
            for(int j = 0; j < list.size()-i-1; j++)
            {
                if(list.get(j) > list.get(j + 1))
                {
                    tempVar = list.get(j + 1);
                    list.set(j + 1, list.get(j));
                    list.set(j, tempVar);
                }
            }
        }
    }

    public Integer search(int element){
        for (Integer item : list) {
            if (item == element) {
                return item;
            }
        }
        return null;
    }


}
