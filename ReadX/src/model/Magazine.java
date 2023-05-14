package model;

import java.util.Calendar;

public class Magazine extends BibliographicResources {
    private Category category;
    private int emissionPeriodicity;
    private int numSubsActives;

    public Magazine(String id, String nameResource, int numPages, String URL, double valueResource,
            String datePublication,
            Category category, int emissionPeriodicity) {

        super(id, nameResource, numPages, URL, valueResource, datePublication);
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

    public void subscribe(Calendar dateOperation, double mountPayment) {
        this.numSubsActives++;
        Payment payment = new Payment(this.getId() + "-" + this.numSubsActives, dateOperation, mountPayment);
        payment.setResources(this);
    }

    public void cancelSubscription() {
        this.numSubsActives--;
    }

}