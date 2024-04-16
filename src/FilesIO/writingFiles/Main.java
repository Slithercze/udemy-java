package FilesIO.writingFiles;

import FilesIO.writingFiles.student.Course;
import FilesIO.writingFiles.student.Student;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {

        String header = """
                Student Id,Country code,Enrolled Year,Age,Gender,\
                Experienced,Course code,Engagement Month,Engagement Year,\
                Engagement Type""";

        Course jmc = new Course("JMC", "Java Masterclass");
        Course pymc = new Course("PYC", "Python Masterclass");
        List<Student> students = Stream
                .generate(() -> Student.getRandomStudent(jmc, pymc))
                .limit(25)
                .toList();

//        System.out.println(header);
//        students.forEach(s -> s.getEngagementRecords().forEach(System.out::println));

        Path path = Path.of("src/FilesIO/writingFiles/students.csv");
//        try {
//            Files.writeString(path, header);
//            for (Student student : students) {
//                Files.write(path, student.getEngagementRecords(), StandardOpenOption.APPEND);
//            }
//        } catch (IOException e){
//            e.printStackTrace();
//        }
//        try {
//            List<String> data = new ArrayList<>();
//            data.add(header);
//            for (Student student : students) {
//                data.addAll(student.getEngagementRecords());
//            }
//            Files.write(path, data);
//        } catch (IOException e){
//            e.printStackTrace();
//        }

        //does not have line separator is more efficient
        try (BufferedWriter writer = Files.newBufferedWriter(Path.of("src/FilesIO/writingFiles/take2.csv"))) {
            writer.write(header);
            writer.newLine();
            int count = 0;
            for (Student student : students){
                for (var record : student.getEngagementRecords()){
                    writer.write(record);
                    writer.newLine();
                    count++;
                    if (count % 5 == 0){
                        Thread.sleep(2000);
                        System.out.print(".");
                    }
                    if (count % 10 == 0){
                        writer.flush();
                    }
                }
            }
        } catch (IOException e){
            e.printStackTrace();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        //has line separator
        try (FileWriter writer = new FileWriter("src/FilesIO/writingFiles/take3.csv")){
            writer.write(header);
            writer.write(System.lineSeparator());
            for (Student student : students){
                for (var record : student.getEngagementRecords()){
                    writer.write(record);
                    writer.write(System.lineSeparator());
                }
            }
        } catch (IOException e){
            e.printStackTrace();
        }

        //PrintWriter access to printXXX methods
        try (PrintWriter writer = new PrintWriter("src/FilesIO/writingFiles/take4.txt")){
            writer.println(header);
            for (Student student : students){
                for (var record : student.getEngagementRecords()){
                    String[] recordData = record.split(",");
                    writer.printf("%-12d%-5s%2d%4d%3d%-1s".formatted(
                            student.getStudentId(),
                            student.getCountry(),
                            student.getEnrollmentYear(),
                            student.getEnrollmentMonth(),
                            student.getEnrollmentAge(),
                            student.getGender()));
                    writer.printf("%-1s",
                            (student.hasExperience() ? 'Y' : 'N'));
                    writer.format("%-3s%10.2f%10s%-4s%-30s",
                            recordData[7],
                            student.getPercentComplete(recordData[7]),
                            recordData[8],
                            recordData[9],
                            recordData[10]
                            );
                    writer.println();
                }
            }
        } catch (IOException e){
            e.printStackTrace();
        }

    }
}
