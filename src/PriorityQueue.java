import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Arrays;
import java.util.*;
import java.util.stream.Collectors;

/*
 * Create the Student and Priorities classes here.
 */
class Student {
  private int id;
  private String name;
  private double cgpa;

  public Student(int id, String name, double cgpa){
    this.id = id;
    this.name = name;
    this.cgpa = cgpa;
  }
  public int getID(){
    return this.id;
  }
  public String getName(){
    return this.name;
  }
  public double getCGPA(){
    return this.cgpa;
  }
}
class Priorities {
  ArrayList<Student> list;
  public Priorities(){
    this.list = new ArrayList<>();
  }

  List<Student> getStudents(List<String> events){
    events.forEach(e->{
      List<String> arr = Arrays.asList(e.split(" "));
      String operation = arr.get(0);
      if(operation.equals("ENTER")){
        String name = arr.get(1);
        double gp = Double.parseDouble(arr.get(2));
        int id = Integer.parseInt(arr.get(3));
        list.add(new Student(id, name, gp));
      } else {

        Comparator<Student> comparator = new Comparator<Student>() {
          @Override
          public int compare(Student s1, Student s2) {
            double gpa1 = s1.getCGPA()*1000;
            double gpa2 = s2.getCGPA()*1000;

            if (gpa1 == gpa2) {
              if (s1.getName().compareTo(s2.getName()) == 0 ) {
                if (s1.getID() > s2.getID()) {
                  return -1;
                }
              } else {
                return s1.getName().compareTo(s2.getName());
              }
            } else {
              if (gpa1> gpa2) return -1;
            }
            return 1;
          }
        };
        Collections.sort(list, comparator);
        String l = "";
        list.remove(0);
      }
    });
    return list;
  }


}

public class Solution {
  private final static Scanner scan = new Scanner(System.in);
  private final static Priorities priorities = new Priorities();

  public static void main(String[] args) {
    int totalEvents = Integer.parseInt(scan.nextLine());
    List<String> events = new ArrayList<>();

    while (totalEvents-- != 0) {
      String event = scan.nextLine();
      events.add(event);
    }

    List<Student> students = priorities.getStudents(events);

    if (students.isEmpty()) {
      System.out.println("EMPTY");
    } else {
      for (Student st: students) {
        System.out.println(st.getName());
      }
    }
  }
}
