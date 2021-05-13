package StudentCLI;

class Student {
    String name;
    String stu_id;
    int age;
    public Student() {
        this(" ", " ", 0);
    }
    public Student(String initName, String initId, int initAge) {
        name = initName;
        stu_id = initId;
        age = initAge;
    }
}

