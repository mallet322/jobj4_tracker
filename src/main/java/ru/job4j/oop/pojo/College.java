package ru.job4j.oop.pojo;

public class College {

    public static void main(String[] args) {
        Student student = new Student();
        student.setFIO("Ivanov Ivan Ivanovich");
        student.setGroup("Intern group");
        student.setAdmissionDate("22.07.2021");
        System.out.println(student);
    }

}
