package ru.job4j.oop.profession;

/**
 * Класс описывающий строителя, наследника инженера. Строитель проектирует и строит здания.
 */
public class Builder extends Engineer {

    private String buildingType;

    public Builder(String name, String surname, String education, String birthday, String company) {
        super(name, surname, education, birthday, company);
    }

    public String getBuildingType() {
        return buildingType;
    }

    public void setBuildingType(String buildingType) {
        this.buildingType = buildingType;
    }

    /**
     * Метод описывающий работу строителя - проектирование здания.
     *
     * @param product
     *         Продукт - чертеж здания.
     *
     * @return Готовый продукт.
     */
    public Product designingBuilding(Product product, String buildingType) {
        product.setName("Building plan");
        product.setCategory(buildingType);
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
