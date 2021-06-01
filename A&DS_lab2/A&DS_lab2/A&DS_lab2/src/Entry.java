public class Entry {
    public static void main(String[] args) {
        Tree tree = new Tree();
        System.out.println("Замір на 500 елементів");
        long start = System.nanoTime();
        for (int i = 0; i < 500; i++){
            tree.add(i);
        }
        long end = System.nanoTime();
        System.out.println("Додавання 500 ел-ів: " + (end - start) + " наносекунд");
        start = System.nanoTime();
        tree.sum();
        end = System.nanoTime();
        System.out.println("Обчислення суми 500 ел-ів: " + (end - start) + " наносекунд");
        start = System.nanoTime();
        for (int i = 0; i < 500; i++){
            tree.remove(i);
        }
        end = System.nanoTime();
        System.out.println("Видалення 500 ел-ів: " + (end - start) + " наносекунд");


        System.out.println("_________________");

        Tree tree1 = new Tree();
        System.out.println("Замір на 5000 елементів");
        start = System.nanoTime();
        for (int i = 0; i < 5000; i++){
            tree1.add(i);
        }
        end = System.nanoTime();
        System.out.println("Додавання 5000 ел-ів: " + (end - start) + " наносекунд");
        start = System.nanoTime();
        tree1.sum();
        end = System.nanoTime();
        System.out.println("Обчислення суми 5000 ел-ів: " + (end - start) + " наносекунд");
        start = System.nanoTime();
        for (int i = 0; i < 5000; i++){
            tree1.remove(i);
        }
        end = System.nanoTime();
        System.out.println("Видалення 5000 ел-ів: " + (end - start) + " наносекунд");
    }
}
