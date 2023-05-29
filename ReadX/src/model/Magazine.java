/**
 * The Magazine class extends the BibliographicResources class and contains information about a
 * magazine's category, emission periodicity, and number of active subscriptions.
 */
package model;

import java.util.Calendar;

/**
 * The "Magazine" class extends the "BibliographicResources" class in Java.
 */
public class Magazine extends BibliographicResources implements Sellable {
    // These are instance variables of the `Magazine` class in Java.
    private Category category;
    private int emissionPeriodicity;
    private int numSubsActives;

    // This is a constructor method for the Magazine class that takes in several
    // parameters including
    // id, nameResource, numPages, URL, valueResource, datePublication, category,
    // and
    // emissionPeriodicity. It calls the constructor of the parent class
    // (BibliographicResources) using
    // the "super" keyword and passes in some of the parameters. It then sets the
    // values of the
    // instance variables category, emissionPeriodicity, and numSubsActives using
    // the remaining
    // parameters.
    public Magazine(String id, String nameResource, int numPages, String URL, double valueResource,
            Calendar datePublication,
            Category category, int emissionPeriodicity) {

        super(id, nameResource, numPages, URL, valueResource, datePublication);
        this.category = category;
        this.emissionPeriodicity = emissionPeriodicity;
        this.numSubsActives = 0;
    }

    /**
     * This function returns the category of an object.
     * 
     * @return This method is returning an object of the Category class.
     */
    public Category getCategory() {
        return this.category;
    }

    /**
     * This Java function sets the category of an object.
     * 
     * @param category The parameter "category" is an object of the class
     *                 "Category". The method
     *                 "setCategory" sets the value of the instance variable
     *                 "category" to the value passed as the
     *                 parameter.
     */
    public void setCategory(Category category) {
        this.category = category;
    }

    /**
     * This Java function returns the emission periodicity.
     * 
     * @return The method `getEmissionPeriodicity` is returning an integer value
     *         which represents the
     *         emission periodicity.
     */
    public int getEmissionPeriodicity() {
        return this.emissionPeriodicity;
    }

    /**
     * This function sets the emission periodicity value for an object.
     * 
     * @param emissionPeriodicity an integer value representing the frequency or
     *                            time interval at which
     *                            emissions occur. It is being set by the method
     *                            setEmissionPeriodicity().
     */
    public void setEmissionPeriodicity(int emissionPeriodicity) {
        this.emissionPeriodicity = emissionPeriodicity;
    }

    /**
     * This function returns the number of active subscriptions.
     * 
     * @return The method `getNumSubsActives` is returning an integer value which
     *         represents the number
     *         of active subscriptions.
     */
    public int getNumSubsActives() {
        return this.numSubsActives;
    }

    /**
     * This function sets the number of active subscriptions.
     * 
     * @param numSubsActives numSubsActives is an integer variable that represents
     *                       the number of active
     *                       subscriptions. The method setNumSubsActives sets the
     *                       value of this variable.
     */
    public void setNumSubsActives(int numSubsActives) {
        this.numSubsActives = numSubsActives;
    }

    /**
     * The "sell" function increments the number of active subscriptions.
     */
    @Override
    public void sell() {
        this.numSubsActives++;
    }

    /**
     * The function decreases the number of active subscriptions by one if there are
     * any.
     */
    public void stopSuscription() {
        if (numSubsActives > 0) {
            numSubsActives--;
        }
    }

}