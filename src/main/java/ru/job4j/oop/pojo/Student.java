package ru.job4j.oop.pojo;

public class Student {

    private String fio;

    private String group;

    private String admissionDate;

    public Student() {
    }

    public Student(String fio, String group, String admissionDate) {
        this.fio = fio;
        this.group = group;
        this.admissionDate = admissionDate;
    }

    public String getFio() {
        return fio;
    }

    public void setFio(String fio) {
        this.fio = fio;
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
        String ln = System.lineSeparator();
        return "Student: ".concat(ln)
                          .concat("FIO: ").concat(fio).concat(ln)
                          .concat("Group: ").concat(group).concat(ln)
                          .concat("AdmissionDate: ").concat(admissionDate);
    }

}
