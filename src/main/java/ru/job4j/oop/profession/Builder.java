package ru.job4j.oop.profession;

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

    public Product designingBuilding(Product product, String buildingType) {
        product.setName("Building plan");
        product.setCategory(buildingType);
        return product;
    }

    public Product constructionBuilding(Product product) {
        product.setName("Building");
        product.setCategory("Building");
        return product;
    }

}
