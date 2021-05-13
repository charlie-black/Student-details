package StudentCLI;

import java.util.Scanner;

public class StudentCLI {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Input number of students:");
        int n = Integer.parseInt(in.nextLine().trim());
        System.out.println("Input Student Name, ID, Age:");
        Student stu = new Student();
        Student max = new Student();
        Student min = new Student(" ", " ", 100);

        for (int i = 0; i < n; i ++) {
            stu.name = in.next();
            stu.stu_id = in.next();
            stu.age = in.nextInt();
            if (max.age < stu.age) {
                max.name = stu.name;
                max.stu_id = stu.stu_id;
                max.age = stu.age;
            }
            if (min.age > stu.age) {
                min.name = stu.name;
                min.stu_id = stu.stu_id;
                min.age = stu.age;
            }

        }
        System.out.println("Student Details:");
        System.out.println("Name: "+max.name + ", " + "ID: "+max.stu_id + ", " + "Age: "+max.age);
        System.out.println(min.name + " " + min.stu_id + " " + min.age);
        in.close();
    }
}