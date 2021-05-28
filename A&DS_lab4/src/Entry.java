public class Entry {
    public static void main(String[] args) {
        try{
            bHeapTest();
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
    }

    public static void bHeapTest() throws Exception {
        System.out.println("B-Heap testing");

        BHeap heap = new BHeap();
        final int TEST_AMOUNT = 10;
        long quickest = 0;
        long slowest = 0;
        long totalTime = 0;
        for(int i = 0; i < TEST_AMOUNT; i++){
            long start = System.nanoTime();
            for(int j = 0; j < 100_000; j++){
                heap.insert((int)(Math.random()*1000));
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
        System.out.println("Inserting 100k of random elements [0, 1000] " + TEST_AMOUNT + " times:");
        System.out.println("quickest: " + quickest + "ns, or " + (int)(quickest/1_000_000) + "ms");
        System.out.println("slowest: " + slowest + "ns, or " + (int)(slowest/1_000_000) + "ms");
        System.out.println("average: " + average + "ns, or " + (int)(average/1_000_000) + "ms");
        System.out.println("====================================================================");


        BHeap heap1 = new BHeap();

        quickest = 0;
        slowest = 0;
        totalTime = 0;
        for(int i = 0; i < TEST_AMOUNT; i++){
            long start = System.nanoTime();
            for(int j = 0; j < 100_000; j++){
                heap1.insert(j);
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

        System.out.println("Inserting 100k of ordered elements " + TEST_AMOUNT + " times:");
        System.out.println("quickest: " + quickest + "ns, or " + (int)(quickest/1_000_000) + "ms");
        System.out.println("slowest: " + slowest + "ns, or " + (int)(slowest/1_000_000) + "ms");
        System.out.println("average: " + average + "ns, or " + (int)(average/1_000_000) + "ms");
        System.out.println("====================================================================");

        long searchTime = 0;

        long searchStart = System.nanoTime();
        for(int j = 0; j < 100_000; j++){
            Integer val = heap1.search(j);
        }
        long searchEnd = System.nanoTime();
        searchTime = searchEnd - searchStart;



        System.out.println("Searching for 100k of ordered elements:");
        System.out.println("time: " + searchTime + "ns, or " + (int)(searchTime/1_000_000) + "ms");
        System.out.println("====================================================================");



        quickest = 0;
        slowest = 0;
        totalTime = 0;
        for(int i = 0; i < TEST_AMOUNT; i++){
            long start = System.nanoTime();
            for(int j = 0; j < 100_000; j++){
                heap1.delete();
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

        System.out.println("Deleting 100k of elements " + TEST_AMOUNT + " times:");
        System.out.println("quickest: " + quickest + "ns, or " + (int)(quickest/1_000_000) + "ms");
        System.out.println("slowest: " + slowest + "ns, or " + (int)(slowest/1_000_000) + "ms");
        System.out.println("average: " + average + "ns, or " + (int)(average/1_000_000) + "ms");
        System.out.println("====================================================================");
    }
}
