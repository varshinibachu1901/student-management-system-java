import java.util.ArrayList;
import java.util.Scanner;

class Student {
    int id;
    String name;
    int marks;

    Student(int id, String name, int marks) {
        this.id = id;
        this.name = name;
        this.marks = marks;
    }

    void display() {
        System.out.println("ID: " + id +
                           ", Name: " + name +
                           ", Marks: " + marks);
    }
}

public class Main {
    public static void main(String[] args) {

        ArrayList<Student> students = new ArrayList<>();
        Scanner sc = new Scanner(System.in);

        while (true) {

            System.out.println("\n----- STUDENT MANAGEMENT -----");
            System.out.println("1. Add Student");
            System.out.println("2. Display Students");
            System.out.println("3. Search Student");
            System.out.println("4. Update Student");
            System.out.println("5. Delete Student");
            System.out.println("6. Exit");

            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();

            // ADD
            if (choice == 1) {

                if (students.size() >= 5) {
                    System.out.println("Maximum 5 students can be added!");
                    continue;
                }

                System.out.print("Enter ID: ");
                int id = sc.nextInt();

                sc.nextLine();

                System.out.print("Enter Name: ");
                String name = sc.nextLine();

                System.out.print("Enter Marks: ");
                int marks = sc.nextInt();

                students.add(new Student(id, name, marks));

                System.out.println("Student added successfully!");
            }

            // DISPLAY
            else if (choice == 2) {

                if (students.isEmpty()) {
                    System.out.println("No students available.");
                } else {

                    System.out.println("\nStudent Details:");

                    for (Student s : students) {
                        s.display();
                    }
                }
            }

            // SEARCH
            else if (choice == 3) {

                System.out.print("Enter ID to search: ");
                int id = sc.nextInt();

                boolean found = false;

                for (Student s : students) {

                    if (s.id == id) {
                        System.out.println("Student Found:");
                        s.display();
                        found = true;
                        break;
                    }
                }

                if (!found) {
                    System.out.println("Student not found!");
                }
            }

            // UPDATE
            else if (choice == 4) {

                System.out.print("Enter ID to update: ");
                int id = sc.nextInt();

                boolean found = false;

                for (Student s : students) {

                    if (s.id == id) {

                        sc.nextLine();

                        System.out.print("Enter new name: ");
                        s.name = sc.nextLine();

                        System.out.print("Enter new marks: ");
                        s.marks = sc.nextInt();

                        System.out.println("Student updated successfully!");

                        found = true;
                        break;
                    }
                }

                if (!found) {
                    System.out.println("Student not found!");
                }
            }

            // DELETE
            else if (choice == 5) {

                System.out.print("Enter ID to delete: ");
                int id = sc.nextInt();

                boolean found = false;

                for (int i = 0; i < students.size(); i++) {

                    if (students.get(i).id == id) {

                        students.remove(i);

                        System.out.println("Student deleted successfully!");

                        found = true;
                        break;
                    }
                }

                if (!found) {
                    System.out.println("Student not found!");
                }
            }

            // EXIT
            else if (choice == 6) {

                System.out.println("Program ended.");
                break;
            }

            else {
                System.out.println("Invalid choice!");
            }
        }

        sc.close();
    }
}
