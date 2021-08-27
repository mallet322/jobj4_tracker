package ru.job4j.oop.profession;

/**
 * Класс описывающий строителя, наследника инженера. Строитель проектирует и строит здания.
 */
public class Builder extends Engineer {

    public Builder(String name, String surname, String education, String birthday) {
        super(name, surname, education, birthday);
    }

    /**
     * Метод описывающий работу строителя - проектирование здания.
     *
     * @param product
     *         Продукт - чертеж здания.
     *
     * @return Готовый продукт.
     */
    public Product designingBuilding(Product product) {
        product.setName("Building plan");
        product.setCategory("Building");
        return product;
    }

    /**
     * Метод описывающий работу строителя - строительство здания.
     *
     * @param product
     *         Продукт - Здание.
     *
     * @return Готовый продукт.
     */
    public Product constructionBuilding(Product product) {
        product.setName("Building");
        product.setCategory("Building");
        return product;
    }

}
