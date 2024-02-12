package service;

import common.MyService;
import entity.Teacher;

import java.io.*;
import java.util.Scanner;

public class TeacherService  {


    private static Teacher[] teachers = null;

    private static final String FILE_NAME = "teachers";




    private void readTeachersFromFile() {
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
            teachers = (Teacher[]) inputStream.readObject();
            System.out.println("Teacherden data Read olundu");
        }  catch (Exception e) {
            System.out.println("Error reading teacher : " + e.getMessage());
        }
    }


    private void writeTeachersToFile(Teacher[] teachers) {
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            outputStream.writeObject(teachers);
            System.out.println("Teacher data-si write olundu");
        } catch (IOException e) {
            System.out.println("Error writing teacher : " + e.getMessage());
        }
    }

    public  void showMenu () {

        boolean exit = true;
        while (exit) {
            readTeachersFromFile();

            System.out.println("Hansi emeliyyati etmek isteyirsiz? ");
            System.out.println("0. ilk defe yaratmaq \n" +
                    "1. yenisini yaratmaq \n" +
                    "2. yenilemek (update) \n" +
                    "3. silmek \n" +
                    "4. axtarmaq \n" +
                    "5. hamisini gormek \n" +
                    "6. exit");

            int action = new Scanner(System.in).nextInt();


            switch (action) {
                case 0:
                    teachers = initializeTeacher();
                    break;
                case 1:
                    teachers = initializeNewTeacher(teachers);
                    break;
                case 2:
                    updateTeacher(teachers);
                    break;
                case 3:
                    deleteTeacher(teachers);
                    break;
                case 4:
                    findTeacher(teachers);
                    break;
                case 5:
                    printAll(teachers);
                    break;
                case 6:
                    exit=false;
                    break;
                default:
                    System.out.println("Sehv secim !");
                    exit=false;
                    break;
            }
        }
    }


    public Teacher[] initializeTeacher() {
        System.out.println("Nece nefer muellim qeydiyyatdan kecirdeceksiz: ");
        int count = new Scanner(System.in).nextInt();

        Teacher[] teachers = new Teacher[count];

        //Teleb ele ve yarat

        for (int i = 0; i < count; i++) {

            System.out.println("Qeydiyyat nomresi: " + (i + 1));
            teachers[i] = requireAndCreate();
        }

        //Yaradilanlari capa ver
        printAll(teachers);
        writeTeachersToFile(teachers);
        return teachers;

    }


    public Teacher[] initializeNewTeacher(Teacher[] teachers) {
        System.out.println("neche nefer yaratmaq isteyirsiz?");
        int additionalCount = new Scanner(System.in).nextInt();
        Teacher[] newTeacher = new Teacher[teachers.length + additionalCount];
        for (int i = 0; i < teachers.length; i++) {
            newTeacher[i] = teachers[i];
        }

        for (int i = teachers.length; i < newTeacher.length; i++) {
            newTeacher[i] = requireAndCreate();
        }
        printAll(newTeacher);
        writeTeachersToFile(newTeacher);
        return newTeacher;
    }

    public void updateTeacher(Teacher[] teachers) {
        System.out.println("Necenci muellimi update etmek isteyirsen");
        int updateNumber = new Scanner(System.in).nextInt();
        System.out.println("Hansi xanani update etmek isteyirsen? (name,surname,age,salary)");
        String field = new Scanner(System.in).nextLine();
        if (field.equals("name")) {
            System.out.println("Adini daxil edin: ");
            teachers[updateNumber-1].setFirstName(new Scanner(System.in).nextLine());
        } else if (field.equals("surname")) {
            System.out.println("Soyadini daxil edin: ");
            teachers[updateNumber-1].setLastName(new Scanner(System.in).nextLine());
        } else if (field.equals("age")) {
            System.out.println("Yashini daxil edin: ");
            teachers[updateNumber-1].setAge(new Scanner(System.in).nextInt());
        } else if (field.equals("salary")) {
            System.out.println("Emekhaqqini daxil edin: ");
            teachers[updateNumber-1].setSalary(new Scanner(System.in).nextDouble());
        }
        printAll(teachers);
        writeTeachersToFile(teachers);
    }

    public void deleteTeacher(Teacher[] teachers) {
        System.out.println("Necenci yerdeki muellimi silmek isteyirsen? ");
        int choose = new Scanner(System.in).nextInt();
        teachers[choose - 1] = null;
        printAll(teachers);
        writeTeachersToFile(teachers);
    }

    public void findTeacher(Teacher[] teachers) {
        System.out.println("Axtardiginiz ad/soyadi daxil edin");
        String text = new Scanner(System.in).nextLine();
        for (int i = 0; i < teachers.length; i++) {
            if (teachers != null && (text.equals(teachers[i].getFirstName()) || (text.equals(teachers[i].getLastName())))) {
                System.out.println("Sizin axtardiginiz ad/soyad muellim var:  " + teachers[i]);
            }

        }
    }


     public  void printAll(Teacher[] teachers) {
        System.out.println("Qeydiyyatdan kecen muellimler: ");
        for (int i = 0; i < teachers.length; i++) {
            if (teachers[i] != null) {
                System.out.println((i + 1) + ". " + teachers[i]);
            }
        }
    }

    private static Teacher requireAndCreate() {
        Teacher teacher = new Teacher();

        System.out.println("Muellimin adini daxil edin: ");
        teacher.setFirstName(new Scanner(System.in).nextLine());
        System.out.println("Muellimin soyadini daxil edin: ");
        teacher.setLastName(new Scanner(System.in).nextLine());
        System.out.println("Muellimin yashini daxil edin: ");
        teacher.setAge(new Scanner(System.in).nextInt());
        System.out.println("Muelimin emekhaqqisini daxil edin: ");
        teacher.setSalary(new Scanner(System.in).nextDouble());
        return teacher;

    }
}
