package ru.job4j.oop.profession;

public class Surgeon extends Doctor {

    private String classification;

    public Surgeon(String name, String surname, String education, String birthday, int grade) {
        super(name, surname, education, birthday, grade);
    }

    public String getClassification() {
        return classification;
    }

    public void setClassification(String classification) {
        this.classification = classification;
    }

    public void performOperations(Pacient pacient) {
        heal(pacient);
    }

    @Override
    public Diagnosis establishingDiagnosis(Pacient pacient) {
        return super.establishingDiagnosis(pacient);
    }

    @Override
    public void heal(Pacient pacient) {
        super.heal(pacient);
    }

}
