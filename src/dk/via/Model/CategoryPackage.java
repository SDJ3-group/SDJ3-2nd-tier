package dk.via.Model;

import java.util.ArrayList;

public class CategoryPackage extends Package {

    private Category category;

    @Override
    public ArrayList<Part> getParts() {
        return super.getParts();
    }

    public CategoryPackage(ArrayList<Part> parts, Category category) {
        super(parts);
        this.category = category;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "CategoryPackage{" +
                "category=" + category +
                super.toString()+
                '}';
    }

}
