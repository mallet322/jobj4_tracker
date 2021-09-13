package ru.job4j.oop.profession;

public class Dentist extends Doctor {

     private boolean individual;

    public Dentist(String name, String surname, String education, String birthday, int grade) {
        super(name, surname, education, birthday, grade);
    }

    public boolean isIndividual() {
        return individual;
    }

    public void setIndividual(boolean individual) {
        this.individual = individual;
    }

    public void extractTooth(Pacient pacient, int toothCount) {
        int pacientToothCount = pacient.getToothCount();
        pacient.setToothCount(pacientToothCount - toothCount);
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
