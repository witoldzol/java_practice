import java.util.*;

class Student{
  private int id;
  private String fname;
  private double cgpa;
  public Student(int id, String fname, double cgpa) {
    super();
    this.id = id;
    this.fname = fname;
    this.cgpa = cgpa;
  }
  public int getId() {
    return id;
  }
  public String getFname() {
    return fname;
  }
  public double getCgpa() {
    return cgpa;
  }
}

class StudentComparator implements Comparator<Student>{
  @Override
  public int compare(Student s1, Student s2){
    String s1Name = s1.getFname();
    String s2Name = s2.getFname();
    if(s1.getCgpa() == s2.getCgpa()){
      if(s1Name.compareTo(s2Name) == 0){
        return s1.getId() - s2.getId();
      }
      return s1Name.compareTo(s2Name);
    }
    double result = s2.getCgpa()*1000 - s1.getCgpa()*1000;
    return (int) result;
  }
}

public class Solution
{
  public static void main(String[] args){
    Scanner in = new Scanner(System.in);
    int testCases = Integer.parseInt(in.nextLine());

    List<Student> studentList = new ArrayList<Student>();

    while(testCases>0){
      int id = in.nextInt();
      String fname = in.next();
      double cgpa = in.nextDouble();

      Student st = new Student(id, fname, cgpa);
      studentList.add(st);

      testCases--;
    }
    StudentComparator comparator = new StudentComparator();
    Collections.sort(studentList, comparator);

    for(Student st: studentList){
      System.out.println(st.getFname());
    }
  }
}



