package labTASK06;
public class ConcurrentStudentMap {
    static String[] keys = new String[5000];
    static int[] values = new int[5000];
    static int count = 0;
    public static synchronized void insert(String name, int mark) {
        keys[count] = name;
        values[count] = mark;
        count++;}
    public static void main(String[] args) throws InterruptedException {
        Thread[] threads = new Thread[5];
        long startTime = System.currentTimeMillis();
        for (int t = 0; t < 5; t++) {
            final int threadId = t;
            threads[t] = new Thread(() -> {
                for (int i = 0; i < 1000; i++) {
                    insert("Student_" + threadId + "_" + i, 70);}
            });
            threads[t].start();}
        for (int t = 0; t < 5; t++) {
            threads[t].join();}
        long endTime = System.currentTimeMillis();
        System.out.println("Threads: 5");
        System.out.println("Expected Entries: 5000");
        System.out.println("Actual Entries: " + count);
        System.out.println("Execution Time: " + (endTime - startTime) + " ms");
}}