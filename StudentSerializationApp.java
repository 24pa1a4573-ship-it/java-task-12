import java.io.*;

class Student implements Serializable {
    private static final long serialVersionUID = 1L;

    private int id;
    private String name;
    private String course;
    private transient double gpa;

    public Student(int id, String name, String course, double gpa) {
        this.id = id;
        this.name = name;
        this.course = course;
        this.gpa = gpa;
    }

    public void display() {
        System.out.println("ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Course: " + course);
        System.out.println("GPA: " + gpa);
    }
}

public class StudentSerializationApp {
    public static void main(String[] args) {
        Student student = new Student(101, "Rahul", "Computer Science", 8.7);

        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("student.ser"));
            oos.writeObject(student);
            oos.close();

            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("student.ser"));
            Student restored = (Student) ois.readObject();
            ois.close();

            System.out.println("Deserialized Student Data:\n");
            restored.display();

        } catch (IOException e) {
            System.out.println("IO Error");
        } catch (ClassNotFoundException e) {
            System.out.println("Class Not Found");
        }
    }
}