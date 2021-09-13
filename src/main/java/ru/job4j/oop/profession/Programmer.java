package ru.job4j.oop.profession;

public class Programmer extends Engineer {

    private String language;

    public Programmer(String name,
                      String surname,
                      String education,
                      String birthday,
                      String company) {
        super(name, surname, education, birthday, company);
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public Product development(Product product, String language) {
        product.setName(language + " application");
        product.setCategory("IT");
        return product;
    }

    public Product optimization(Product product) {
        product.setName("Java application");
        product.setCategory("IT");
        return product;
    }

}
