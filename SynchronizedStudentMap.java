package labTASK06;
public class SynchronizedStudentMap {
    static String[] keys = new String[300];
    static int[] values = new int[300];
    static int count = 0;
    public static synchronized void addRecord(String name, int mark) {
        keys[count] = name;
        values[count] = mark;
        count++;
    }
    public static void main(String[] args) throws InterruptedException {
        Thread[] threads = new Thread[3];
        for (int t = 0; t < 3; t++) {
            final int threadId = t;
            threads[t] = new Thread(() -> {
                for (int i = 0; i < 100; i++) {
                    addRecord("Student_" + threadId + "_" + i, 50 + (i % 50));
                }
            });
            threads[t].start();
        }
        for (int t = 0; t < 3; t++) {
            threads[t].join();
        }
        System.out.println("Expected Entries: 300");
        System.out.println("Actual Entries: " + count);
    }
}