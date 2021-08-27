package ru.job4j.oop.profession;

/**
 * Класс, описывающий пациента.
 */
public class Pacient {

    /**
     * Переменная - имя пациента.
     */
    private String name;

    /**
     * Состояние пациента (здоров - true, болен - false)
     */
    private boolean health;

    /**
     * Кол-во зубов пациента.
     */
    private int toothCount = 32;

    /**
     * Переменная - диагноз пациента.
     */
    private Diagnosis diagnosis;

    public Pacient() {
    }

    public Pacient(String name) {
        this.name = name;
    }

    public Pacient(String name, boolean health, Diagnosis diagnosis) {
        this.name = name;
        this.health = health;
        this.diagnosis = diagnosis;
    }

    public Pacient(String name, boolean health, int toothCount, Diagnosis diagnosis) {
        this.name = name;
        this.health = health;
        this.toothCount = toothCount;
        this.diagnosis = diagnosis;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Diagnosis getDiagnosis() {
        return diagnosis;
    }

    public void setDiagnosis(Diagnosis diagnosis) {
        this.diagnosis = diagnosis;
    }

    public boolean isHealth() {
        return health;
    }

    public void setHealth(boolean health) {
        this.health = health;
    }

    public int getToothCount() {
        return toothCount;
    }

    public void setToothCount(int toothCount) {
        this.toothCount = toothCount;
    }

}
