package ru.job4j.oop.pojo;

public class Student {

    private String FIO;

    private String group;

    private String admissionDate;

    public Student() {
    }

    public Student(String FIO, String group, String admissionDate) {
        this.FIO = FIO;
        this.group = group;
        this.admissionDate = admissionDate;
    }

    public String getFIO() {
        return FIO;
    }

    public void setFIO(String FIO) {
        this.FIO = FIO;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public String getAdmissionDate() {
        return admissionDate;
    }

    public void setAdmissionDate(String admissionDate) {
        this.admissionDate = admissionDate;
    }

    @Override
    public String toString() {
        return "Student: " + System.lineSeparator() +
                "FIO: " + FIO + System.lineSeparator() +
                "Group: " + group + System.lineSeparator() +
                "AdmissionDate: " + admissionDate;
    }

}
