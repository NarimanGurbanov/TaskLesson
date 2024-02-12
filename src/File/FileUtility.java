package File;

import entity.Teacher;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;

public class FileUtility {

    public static void writeToTextFile(String message) throws IOException { //vermish oldugum texti file yazacaq

        Path path = Paths.get("myfile.txt");
        Files.write(path, message.getBytes(), StandardOpenOption.CREATE);
    }

    public static void writeToImageFile(String imagePath) throws IOException { //vermish oldugum texti file yazacaq
        byte[] bytes = Files.readAllBytes(Paths.get(imagePath));

        Path path = Paths.get("C:/Users/n.gurbanov/Desktop/copy2.png");
        Files.write(path, bytes, StandardOpenOption.CREATE);
    }

    public static void readFromTextFile(String filePath) throws IOException {
        byte[] bytes = Files.readAllBytes(Paths.get(filePath));
        String text = new String(bytes, StandardCharsets.UTF_8);
        System.out.println(text);
    }

    public static void writeObjToFile() throws IOException {

        try  (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("teacher"))){
            Teacher teacher = new Teacher();
            teacher.setFirstName("Nariman");
            teacher.setLastName("Gurbanov");

            oos.writeObject(teacher);
            oos.flush();

        }
    }

    public static void readObj () throws Exception {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("teacher"))){
            Object o = ois.readObject();
            Teacher t = (Teacher) o;
            System.out.println(t.toString());

        }
    }

    public static void writeTextToFileIO_1 (String text) throws Exception {
        try (FileOutputStream fos = new FileOutputStream("mytextfile1.txt")) {
            fos.write(text.getBytes(StandardCharsets.UTF_8));
        }
    }

    public static void writeImageToFileIO_1 (String image) throws Exception {
        try (FileOutputStream fos = new FileOutputStream("myimgfile.jpg")) {
            fos.write(Files.readAllBytes(Paths.get(image)));
        }
    }

    public static void writeTextToFileIO_2 (String text) throws Exception {
        try (FileWriter fw = new FileWriter("mytextfile2.txt");
             BufferedWriter bw = new BufferedWriter(fw)) {

                bw.write(text);
                bw.newLine();
                bw.flush();

        }
    }

    public static void readFile (String fileName) throws Exception {
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        }
    }
}
