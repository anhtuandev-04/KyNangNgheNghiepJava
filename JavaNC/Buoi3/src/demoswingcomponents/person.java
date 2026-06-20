//TruongAnhTuan 220616
package demoswingcomponents;

public class person {
    private int id;
    private String name;

    public person(int id, String name) { 
        this.id = id;
        this.name = name;
    }

    public person() {
        this.id = 0;
        this.name = "";
    }

    @Override
    public String toString() {
        return this.id + " - " + name;
    }
}