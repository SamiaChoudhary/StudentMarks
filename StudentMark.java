package labTASK06;

public class StudentMark {
    public static void main(String[] args) {
        String[] names = {"Alice", "Bob", "Charlie", "Diana", "Ethan"};
        int[] marks = {85, 92, 78, 88, 95};

        System.out.println("All Student Records");
        for (int i = 0; i < names.length; i++) {
            System.out.println(names[i] + ": " + marks[i]);
        }
        for (int i = 0; i < names.length; i++) {
            if (names[i].equals("Charlie")) {
                marks[i] = 84;
                System.out.println("\nUpdated Charlie's Marks: " + marks[i]);
            }
        }
        for (int i = 0; i < names.length; i++) {
            if (names[i].equals("Bob")) {
                System.out.println("Marks of Bob: " + marks[i]);
            }
        }
        System.out.println("Total Students: " + names.length);
    }
}