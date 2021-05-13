package Studentwebsocket;

public class Student {
   
    private String studentName;
    private String studentId;
    private String studentAge;


    public Student (String name, String id,  String age) {
        this.studentName = name;
        this.studentId = id;
        this.studentAge = age;

    }

    public void setStudentName (String name) {
        this.studentName = name;
    }

    public void setStudentId (String id) {
        this.studentId = id;
    }
    public void setStudentAge(String age) {
        this.studentAge = age;
    }


    public String getStudentName () {
        return studentName;
    }

    public String getStudentId() {
        return studentId;
    }

    public String getStudentAge() {
        return studentAge;
    }



}
