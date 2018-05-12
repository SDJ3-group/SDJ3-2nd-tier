package dk.via.Model;

import java.util.ArrayList;

public class CategoryPackage extends Package {


    private Category category;

    public CategoryPackage(int id, ArrayList<Part> parts, boolean repacking) {
        super(id, parts, repacking);
    }

    @Override
    public ArrayList<Part> getParts() {
        return super.getParts();
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
