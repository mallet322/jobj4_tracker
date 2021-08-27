package ru.job4j.oop.profession;

/**
 * Класс описывающий доктора
 */
public class Doctor extends Profession {

    public Doctor(String name, String surname, String education, String birthday) {
        super(name, surname, education, birthday);
    }

    /**
     * Метод, описывающий работу врача - учтановка диагноза пациенту.
     * @param pacient Пациент.
     */
    public Diagnosis establishingDiagnosis(Pacient pacient) {
        Diagnosis diagnosis = new Diagnosis();
        diagnosis.setName("Covid-19");
        pacient.setDiagnosis(diagnosis);
        pacient.setHealth(false);
        return diagnosis;
    }

    /**
     * Метод, описывающий работу врача - лечение пациента.
     * @param pacient Больной пациент.
     */
    public void heal(Pacient pacient) {
        pacient.setHealth(true);
    }


}
