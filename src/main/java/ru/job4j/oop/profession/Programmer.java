package ru.job4j.oop.profession;

/**
 * Класс описывающий программиста, наследника инженера.
 * Программист разрабатывает и опитмизирует приложения
 */
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

    /**
     * Метод описывающий работу программиста - разрабатывать приложения.
     * @param product Продукт - приложение.
     *
     * @return Готовый продукт.
     */
    public Product development(Product product, String language) {
        product.setName(language + " application");
        product.setCategory("IT");
        return product;
    }

    /**
     * Метод описывающий работу программиста - оптимизировать приложения.
     * @param product Продукт - приложение.
     *
     * @return Оптимизированный продукт.
     */
    public Product optimization(Product product) {
        product.setName("Java application");
        product.setCategory("IT");
        return product;
    }

}
