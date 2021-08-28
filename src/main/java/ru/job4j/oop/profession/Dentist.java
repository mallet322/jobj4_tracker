package ru.job4j.oop.profession;

/**
 * Класс описывающий хирурга, наследника стоматолога. В переопределнном от родителя методе установке диагноза стоматолог
 * тоже ставит всем ковид, тяжелые времена...
 */
public class Dentist extends Doctor {

    /**
     * Переменная описывает стоматолога, работает ли он в частной клинике, или в муниципальной.
     * (true - частная, false - муниципальная)
     */
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

    /**
     * Метод описывающий работу стоматолога - удалять зубы.
     */
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
