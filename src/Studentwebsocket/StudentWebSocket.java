package Studentwebsocket;

import java.util.*;

import java.io.IOException;
import java.net.*;
import java.io.PrintWriter;


public class StudentWebSocket {
    private static Scanner scanner;
    private static ArrayList<Student> students;
    private static String user;

    public static void main(String[] args) {  

        students = new ArrayList<Student>();
        scanner = new Scanner(System.in);
        System.out.print("Type your name : ");
        user = scanner.nextLine();
        addStudents();

        //Start server after input
        try (ServerSocket serverSocket = new ServerSocket(8000)) {
            do {
                try (Socket client = serverSocket.accept()) {
                    handleClient(client);
                }
            } while (true);
        }catch (IOException e) {
            System.out.println(e);
        }
       
        System.out.println("Thank You "+user);
    }



    public static void addStudents() {
        scanner = new Scanner(System.in);

        System.out.print("How many students do you want to add?: ");
        int a = scanner.nextInt();
        scanner.nextLine();
        if (a > 0) {
            int i = a;
            do {
                System.out.println();

                System.out.print("Enter a student name: ");
                String name = scanner.nextLine();

                System.out.print("Enter a student Id no: ");
                String id = scanner.nextLine();


                System.out.print("Enter a student Age: ");
                String age = scanner.nextLine();
                
                students.add(new Student(name, id, age)); //Add student to arraylist
                i--;
            } while (i > 0);
        }
        System.out.println("Successfully Added open your browser and type http://localhost:8000");
    }


    private static void handleClient(Socket client) throws IOException {
        System.out.println("Debug: got new client " + client.toString());
        PrintWriter out = new PrintWriter(client.getOutputStream());

        out.println("HTTP/1.1 200 OK");
        out.println("Content-Type: text/html");
        out.println("\r\n");
        out.println("<html>");
        out.println("<body>");
        out.println("<h1>Welcome, "+user+"<h2>");
        out.println("<h3>students List</h3>");
        int i = 0;    
        while (i<students.size()) {
            int currentStudent = i+1;
            out.println(String.valueOf("<p>"+currentStudent)+".) "+"Name: "+students.get(i).getStudentName()+", Age: "+students.get(i).getStudentAge()
            +", ID: "+students.get(i).getStudentId()+"</p>");
            System.out.println();
            i++;
        }
        out.println("</body>");
        out.println("</html>");

        out.flush();
        out.close();
        client.close();

    }
}
