package service;

import common.MyService;
import entity.Student;

import java.util.Scanner;

public class StudentService  {

    private static Student[] students = null;


    public  void showMenu () {

        System.out.println("Hansi emeliyyati etmek isteyirsiz? ");
        System.out.println("0. ilk defe yaratmaq \n" +
                "1. yenisini yaratmaq \n" +
                "2. yenilemek (update) \n" +
                "3. silmek \n" +
                "4. axtarmaq \n" +
                "5. hamisini gormek");

        int action = new Scanner(System.in).nextInt();


        switch (action) {
            case 0:
                students=initializeStudents();
                break;
            case 1:
                students=initializeNewStudents(students);
                break;
            case 2:
                updateStudent(students);
                break;
            case 3:
                deleteStudent(students);
                break;
            case 4:
                findStudent(students);
                break;
            case 5:
                printAll(students);
                break;
            default:
                System.out.println("Sehv secim !");
                break;
        }
    }


    public Student[] initializeStudents() {
        System.out.println("How many students do you want to register?");
        int count = new Scanner(System.in).nextInt();

        Student[] students = new Student[count];

        for (int i = 0; i < count; i++) {
            System.out.println("Registration number: " + (i + 1));
            students[i] = requireAndCreate();
        }

        printAll(students);
        return students;
    }


    public Student[] initializeNewStudents(Student[] students) {
        System.out.println("How many additional students do you want to create?");
        int additionalCount = new Scanner(System.in).nextInt();
        Student[] newStudents = new Student[students.length + additionalCount];

        System.arraycopy(students, 0, newStudents, 0, students.length);

        for (int i = students.length; i < newStudents.length; i++) {
            newStudents[i] = requireAndCreate();
        }

        printAll(newStudents);
        return newStudents;
    }


    public void updateStudent(Student[] students) {
        System.out.println("Which student do you want to update?");
        int updateNumber = new Scanner(System.in).nextInt();
        System.out.println("Which field do you want to update? (name, surname, age, phoneNumber)");
        String field = new Scanner(System.in).nextLine();

        if (field.equals("name")) {
            System.out.println("Enter the new first name: ");
            students[updateNumber - 1].setFirstName(new Scanner(System.in).nextLine());
        } else if (field.equals("surname")) {
            System.out.println("Enter the new last name: ");
            students[updateNumber - 1].setLastName(new Scanner(System.in).nextLine());
        } else if (field.equals("age")) {
            System.out.println("Enter the new age: ");
            students[updateNumber - 1].setAge(new Scanner(System.in).nextInt());
        } else if (field.equals("phoneNumber")) {
            System.out.println("Enter the new phone number: ");
            students[updateNumber - 1].setPhoneNumber(new Scanner(System.in).nextLine());
        }

        printAll(students);
    }


    public void deleteStudent(Student[] students) {
        System.out.println("Which student do you want to delete?");
        int choose = new Scanner(System.in).nextInt();
        students[choose - 1] = null;
        printAll(students);
    }


    public void findStudent(Student[] students) {
        System.out.println("Enter the name/last name you are looking for");
        String text = new Scanner(System.in).nextLine();

        for (int i = 0; i < students.length; i++) {
            if (text.equals(students[i].getFirstName()) || text.equals(students[i].getLastName())) {
                System.out.println("The student you are looking for exists:  " + students[i]);
            } else {
                System.out.println("The student you are looking for does not exist");
            }
        }
    }


    public void printAll(Student[] students) {
        System.out.println("Registered students: ");
        for (int i = 0; i < students.length; i++) {
            if (students[i] != null) {
                System.out.println((i + 1) + ". " + students[i]);
            }
        }
    }


    public Student requireAndCreate() {
        Student student = new Student();

        System.out.println("Enter the student's first name: ");
        student.setFirstName(new Scanner(System.in).nextLine());
        System.out.println("Enter the student's last name: ");
        student.setLastName(new Scanner(System.in).nextLine());
        System.out.println("Enter the student's age: ");
        student.setAge(new Scanner(System.in).nextInt());
        System.out.println("Enter the student's phone number: ");
        student.setPhoneNumber(new Scanner(System.in).nextLine());

        return student;
    }
}
