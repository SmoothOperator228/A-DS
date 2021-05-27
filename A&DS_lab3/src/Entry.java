public class Entry {
    public static void main(String[] args) {
        RBTest();
        System.out.println("======================================================================================================================================================");
        AVLTest();
    }

    public static void RBTest(){
        System.out.println("Red-Black Tree testing:");

        RBTree tree = new RBTree();
        final int TEST_AMOUNT = 10;
        long quickest = 0;
        long slowest = 0;
        long totalTime = 0;
        for(int i = 0; i < TEST_AMOUNT; i++){
            long start = System.nanoTime();
            for(int j = 0; j < 1_000_000; j++){
                tree.insert((int)(Math.random()*1000));
            }
            long end = System.nanoTime();
            long time = end - start;
            if(time > slowest){
                slowest = time;
            }
            if(i == 0){
                quickest = slowest;
            }
            if(time < quickest){
                quickest = time;
            }
            totalTime += time;

        }
        long average = totalTime/TEST_AMOUNT;
        System.out.println("Inserting 1 mil of random elements [0, 1000] " + TEST_AMOUNT + " times:");
        System.out.println("quickest: " + quickest + "ns, or " + (int)(quickest/1_000_000) + "ms");
        System.out.println("slowest: " + slowest + "ns, or " + (int)(slowest/1_000_000) + "ms");
        System.out.println("average: " + average + "ns, or " + (int)(average/1_000_000) + "ms");
        System.out.println("====================================================================");

        long sumTime = 0;
        {
            long start = System.nanoTime();

            int sum = tree.getSum();
            long end = System.nanoTime();
            sumTime = end - start;
        }

        System.out.println("Finding sum of 1 mil of random elements [0, 1000]:");
        System.out.println("time: " + sumTime + "ns, or " + (int)(sumTime/1_000_000) + "ms");
        System.out.println("====================================================================");

        RBTree tree1 = new RBTree();

        quickest = 0;
        slowest = 0;
        totalTime = 0;
        for(int i = 0; i < TEST_AMOUNT; i++){
            long start = System.nanoTime();
            for(int j = 0; j < 1_000_000; j++){
                tree1.insert(j);
            }
            long end = System.nanoTime();
            long time = end - start;
            if(time > slowest){
                slowest = time;
            }
            if(i == 0){
                quickest = slowest;
            }
            if(time < quickest){
                quickest = time;
            }
            totalTime += time;
        }
        average = totalTime/TEST_AMOUNT;

        System.out.println("Inserting 1 mil of ordered elements " + TEST_AMOUNT + " times:");
        System.out.println("quickest: " + quickest + "ns, or " + (int)(quickest/1_000_000) + "ms");
        System.out.println("slowest: " + slowest + "ns, or " + (int)(slowest/1_000_000) + "ms");
        System.out.println("average: " + average + "ns, or " + (int)(average/1_000_000) + "ms");
        System.out.println("====================================================================");

        quickest = 0;
        slowest = 0;
        totalTime = 0;
        for(int i = 0; i < TEST_AMOUNT; i++){
            long start = System.nanoTime();
            for(int j = 0; j < 1_000_000; j++){
                RBTree.Node node = tree1.searchTree(j);
            }
            long end = System.nanoTime();
            long time = end - start;
            if(time > slowest){
                slowest = time;
            }
            if(i == 0){
                quickest = slowest;
            }
            if(time < quickest){
                quickest = time;
            }
            totalTime += time;
        }

        average = totalTime/TEST_AMOUNT;

        System.out.println("Searching for 1 mil of ordered elements " + TEST_AMOUNT + " times:");
        System.out.println("quickest: " + quickest + "ns, or " + (int)(quickest/1_000_000) + "ms");
        System.out.println("slowest: " + slowest + "ns, or " + (int)(slowest/1_000_000) + "ms");
        System.out.println("average: " + average + "ns, or " + (int)(average/1_000_000) + "ms");
        System.out.println("====================================================================");



        quickest = 0;
        slowest = 0;
        totalTime = 0;
        for(int i = 0; i < TEST_AMOUNT; i++){
            long start = System.nanoTime();
            for(int j = 0; j < 1_000_000; j++){
                tree1.deleteNode(j);
            }
            long end = System.nanoTime();
            long time = end - start;
            if(time > slowest){
                slowest = time;
            }
            if(i == 0){
                quickest = slowest;
            }
            if(time < quickest){
                quickest = time;
            }
            totalTime += time;
        }

        average = totalTime/TEST_AMOUNT;

        System.out.println("Deleting 1 mil of ordered elements " + TEST_AMOUNT + " times:");
        System.out.println("quickest: " + quickest + "ns, or " + (int)(quickest/1_000_000) + "ms");
        System.out.println("slowest: " + slowest + "ns, or " + (int)(slowest/1_000_000) + "ms");
        System.out.println("average: " + average + "ns, or " + (int)(average/1_000_000) + "ms");
        System.out.println("====================================================================");

    }

    public static void AVLTest(){
        System.out.println("AVL Tree testing:");

        AVLTree tree = new AVLTree();
        final int TEST_AMOUNT = 10;
        long quickest = 0;
        long slowest = 0;
        long totalTime = 0;
        for(int i = 0; i < TEST_AMOUNT; i++){
            long start = System.nanoTime();
            for(int j = 0; j < 1_000_000; j++){
                tree.add((int)(Math.random()*1000));
            }
            long end = System.nanoTime();
            long time = end - start;
            if(time > slowest){
                slowest = time;
            }
            if(i == 0){
                quickest = slowest;
            }
            if(time < quickest){
                quickest = time;
            }
            totalTime += time;

        }
        long average = totalTime/TEST_AMOUNT;
        System.out.println("Adding 1 mil of random elements [0, 1000] " + TEST_AMOUNT + " times:");
        System.out.println("quickest: " + quickest + "ns, or " + (int)(quickest/1_000_000) + "ms");
        System.out.println("slowest: " + slowest + "ns, or " + (int)(slowest/1_000_000) + "ms");
        System.out.println("average: " + average + "ns, or " + (int)(average/1_000_000) + "ms");
        System.out.println("====================================================================");

        long sumTime = 0;
        {
            long start = System.nanoTime();

            int sum = tree.getSum();
            long end = System.nanoTime();
            sumTime = end - start;
        }

        System.out.println("Finding sum of 1 mil of random elements [0, 1000]:");
        System.out.println("time: " + sumTime + "ns, or " + (int)(sumTime/1_000_000) + "ms");
        System.out.println("====================================================================");

        AVLTree tree1 = new AVLTree();

        quickest = 0;
        slowest = 0;
        totalTime = 0;
        for(int i = 0; i < TEST_AMOUNT; i++){
            long start = System.nanoTime();
            for(int j = 0; j < 1_000_000; j++){
                tree1.add(j);
            }
            long end = System.nanoTime();
            long time = end - start;
            if(time > slowest){
                slowest = time;
            }
            if(i == 0){
                quickest = slowest;
            }
            if(time < quickest){
                quickest = time;
            }
            totalTime += time;
        }
        average = totalTime/TEST_AMOUNT;

        System.out.println("Inserting 1 mil of ordered elements " + TEST_AMOUNT + " times:");
        System.out.println("quickest: " + quickest + "ns, or " + (int)(quickest/1_000_000) + "ms");
        System.out.println("slowest: " + slowest + "ns, or " + (int)(slowest/1_000_000) + "ms");
        System.out.println("average: " + average + "ns, or " + (int)(average/1_000_000) + "ms");
        System.out.println("====================================================================");

        quickest = 0;
        slowest = 0;
        totalTime = 0;
        for(int i = 0; i < TEST_AMOUNT; i++){
            long start = System.nanoTime();
            for(int j = 0; j < 1_000_000; j++){
                boolean cont = tree1.contains(j);
            }
            long end = System.nanoTime();
            long time = end - start;
            if(time > slowest){
                slowest = time;
            }
            if(i == 0){
                quickest = slowest;
            }
            if(time < quickest){
                quickest = time;
            }
            totalTime += time;
        }

        average = totalTime/TEST_AMOUNT;

        System.out.println("Searching for 1 mil of ordered elements " + TEST_AMOUNT + " times:");
        System.out.println("quickest: " + quickest + "ns, or " + (int)(quickest/1_000_000) + "ms");
        System.out.println("slowest: " + slowest + "ns, or " + (int)(slowest/1_000_000) + "ms");
        System.out.println("average: " + average + "ns, or " + (int)(average/1_000_000) + "ms");
        System.out.println("====================================================================");



        quickest = 0;
        slowest = 0;
        totalTime = 0;
        for(int i = 0; i < TEST_AMOUNT; i++){
            long start = System.nanoTime();
            for(int j = 0; j < 1_000_000; j++){
                tree1.remove(j);
            }
            long end = System.nanoTime();
            long time = end - start;
            if(time > slowest){
                slowest = time;
            }
            if(i == 0){
                quickest = slowest;
            }
            if(time < quickest){
                quickest = time;
            }
            totalTime += time;
        }

        average = totalTime/TEST_AMOUNT;

        System.out.println("Removing 1 mil of ordered elements " + TEST_AMOUNT + " times:");
        System.out.println("quickest: " + quickest + "ns, or " + (int)(quickest/1_000_000) + "ms");
        System.out.println("slowest: " + slowest + "ns, or " + (int)(slowest/1_000_000) + "ms");
        System.out.println("average: " + average + "ns, or " + (int)(average/1_000_000) + "ms");
        System.out.println("====================================================================");
    }
}

