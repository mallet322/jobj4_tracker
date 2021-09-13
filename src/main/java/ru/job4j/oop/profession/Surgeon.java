package ru.job4j.oop.profession;

/**
 * Класс описывающий хирурга, наследника доктора.
 * В переопределенном от родителя методе установке диагноза хирург тоже ставит всем ковид,
 * тяжелые времена...
 */
public class Surgeon extends Doctor {

    /**
     * Переменная описывает классификацию хирурга.
     */
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

    /**
     * Метод описывающий работу хирурга - проводить операции
     * (Лечить людей по средством провдения операции).
     */
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
