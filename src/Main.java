import File.FileUtility;
import math.MathOperationType;
import service.TeacherService;

import java.io.IOException;

public class Main {


    public static void main(String[] args) throws Exception {

//        FileUtility.writeToImageFile("C:/Users/n.gurbanov/Desktop/Java.png");

//        FileUtility.readFromTextFile();
//       FileUtility.writeObjToFile();
//            FileUtility.readObj();

        TeacherService teacherService = new TeacherService();

        teacherService.showMenu();

    }
}