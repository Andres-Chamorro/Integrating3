package model;

public class Magazine extends BibliographicResources {
    private Category category;
    private int emissionPeriodicity;
    private int numSubsActives;

    public Magazine(String id, String nameResource, int numPages, String URL, double valueResource,
            Category category, int emissionPeriodicity) {

        super(id, nameResource, numPages, URL, valueResource);
        this.category = category;
        this.emissionPeriodicity = emissionPeriodicity;
        this.numSubsActives = 0;
        this.numPagesRead = 0;
    }

    public Category getCategory() {
        return this.category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public int getEmissionPeriodicity() {
        return this.emissionPeriodicity;
    }

    public void setEmissionPeriodicity(int emissionPeriodicity) {
        this.emissionPeriodicity = emissionPeriodicity;
    }

    public int getNumSubsActives() {
        return this.numSubsActives;
    }

    public void setNumSubsActives(int numSubsActives) {
        this.numSubsActives = numSubsActives;
    }

}