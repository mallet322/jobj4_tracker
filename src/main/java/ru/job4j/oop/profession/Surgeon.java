package ru.job4j.oop.profession;

/**
 * Класс описывающий хирурга, наследника доктора. В переопределнном от родителя методе установке диагноза хирург тоже
 * ставит всем ковид, тяжелые времена...
 */
public class Surgeon extends Doctor {

    public Surgeon(String name, String surname, String education, String birthday) {
        super(name, surname, education, birthday);
    }

    /**
     * Метод описывающий работу хирурга - проводить операции (Лечить людей по средством провдения операции).
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
