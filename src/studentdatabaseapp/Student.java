package studentdatabaseapp;

import java.util.Scanner;

public class Student {
    private String firstName;
    private String lastName;
    private int year;
    private int tuitionBalance = 0;
    private String studentID;
    private String courses = "";
    private static int coursePrice = 600;
    private static int id = 1000;

    // Student constructor: promt user to enter student name and year
    public Student() {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter student first name: ");
        this.firstName = in.nextLine();

        System.out.print("Enter student last name: ");
        this.lastName = in.nextLine();

        System.out.print("1 - Freshman\n2 - Sophomore\n3 - Junior\n4 - Senior\nEnter student grade level: ");
        this.year = in.nextInt();

        setStudentID();
    }

    // unique student id generator
    private void setStudentID() {
        // Grade level  + ID
        id++;
        this.studentID =  year + "" + id;
    }

    // course enrollment
    public void enroll() {
        // Get inside loop, user hits 0
        do {
            System.out.print("Enter course to enroll (Q to quit): ");
            Scanner in = new Scanner(System.in);
            String course = in.nextLine();
            if (!course.equals("Q")) {

                courses = courses + "\n    " + course;
                tuitionBalance = tuitionBalance + coursePrice;
            } else { 
                break; 
            }
        } while (1 != 0);
    }

    // view balance
    public void viewBalance() {
        if (tuitionBalance == 0) {
            System.out.println("You are not in debt.");
        } else if (tuitionBalance > 0) {
        System.out.println("You are " + tuitionBalance + "$ in debt.");
        } else {
            System.out.println("Heres the change " + (tuitionBalance * -1) + "$");
            System.out.println("You are not in debt.");
        }
    }

    // pay tuition
    public void payTuition() {
        viewBalance();
        System.out.print("Enter money: ");
        Scanner in = new Scanner(System.in);
        int payment = in.nextInt();
        tuitionBalance = tuitionBalance - payment;
        System.out.println("Thank you for you payment of " + payment + "$");
        viewBalance();
    }

    //check status
    public String showStatus() {
        return "Name: " + firstName + " " + lastName +
        "\nGrade: " + year +
        "\nStudent ID: " + studentID + 
        "\nCourses enrolled: " + courses +
        "\nBalance: " + tuitionBalance;
    }
}