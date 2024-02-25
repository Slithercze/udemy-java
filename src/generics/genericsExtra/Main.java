package generics.genericsExtra;

import generics.genericsExtra.model.LPAStudent;
import generics.genericsExtra.model.Student;
import generics.genericsExtra.util.QueryItem;
import generics.genericsExtra.util.QueryList;

import java.util.ArrayList;
import java.util.List;

record Employee(String name) implements QueryItem{

    @Override
    public boolean matchFieldValue(String fieldName, String value) {
        return false;
    }
}

public class Main {
    public static void main(String[] args) {

        int studentCount = 10;
        List<Student> students = new ArrayList<>();
        for (int i = 0; i < studentCount; i++) {
            students.add(new Student());
        }
        students.add(new LPAStudent());
//        printList(students);
        printMoreLists(students);
        List<LPAStudent> lpaStudents = new ArrayList<>();
        for (int i = 0; i < studentCount; i++) {
            lpaStudents.add(new LPAStudent());
        }
//        printList(lpaStudents);
        printMoreLists(lpaStudents);

        testList(new ArrayList<String>(List.of("Able","Barry","Charlie")));
        testList(new ArrayList<Integer>(List.of(1,2,3)));

        var queryList = new QueryList<>(lpaStudents);
        var matches = queryList.getMatches("Course", "Python");
        printMoreLists(matches);

        var students2021 = QueryList.getMatches(students,"YearStarted", "2021");
        printMoreLists(students2021);

//        QueryList<Employee> employeeList = new QueryList<>();  neprojde protoze to musi jeste inheritovat Student classu
    }

    public static void printMoreLists(List<? extends Student> students) {

//        Student last = students.get(students.size()-1);
//        students.set(0,last); dont know which lpastudent or student to use that why error

        for (var student : students) {
            System.out.println(student.getYearStarted() + " : " + student);
        }
        System.out.println();
    }

    public static void testList(List<?> list) {
        for (var element : list) {
            if (element instanceof String s) {
                System.out.println("String: " + s.toUpperCase());
            } else if (element instanceof Integer i) {
                System.out.println("Integer: " + i.floatValue());
            }
        }
    }

//    public static void testList(List<String> list){ //same erasure means that integer and string is converted into Object so its not overloading method
//        for(var elements: list){
//            System.out.println("String: " + elements.toUpperCase());
//        }
//    }
//    public static void testList(List<Integer> list){
//        for(var elements: list){
//            System.out.println("Integer: " + elements.floatValue());
//        }
//    }

//    public static <T extends Student> void printList(List<T> students) {
//
//        for (var student : students) {
//            System.out.println(student.getYearStarted() + " : " + student);
//        }
//        System.out.println();
//    }
}
