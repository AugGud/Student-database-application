package studentdatabaseapp;

import java.util.Scanner;

public class studentDatabaseApp {
    public static void main(String[] args) {

        // Ask how many users we want to add
        System.out.print("Enter number of new students to enroll: ");
        Scanner in = new Scanner(System.in);
        int numOfStudents = in.nextInt();
        Student[] students = new Student[numOfStudents];

        // Create n number of students
        for (int n = 0; n < numOfStudents; n++) {
            students[n] = new Student();
            students[n].enroll();
            students[n].payTuition();
        }

        for (int i = 0; i < numOfStudents; i++) {
            System.out.println(students[i].showStatus());
        }
    }
}
