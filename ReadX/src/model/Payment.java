// `package model;` is declaring that the class `Payment` belongs to the `model` package. This is a way
// of organizing classes and avoiding naming conflicts with classes in other packages.
package model;

import java.util.Calendar;

/**
 * The class is named "Payment" and its contents are not yet defined.
 */
public class Payment {
    // These are instance variables of the class `Payment`. `private Calendar
    // dateOperation` represents
    // the date of the payment, `private double mountPayment` represents the amount
    // of the payment,
    // `private String typeTransaction` represents the type of transaction, and
    // `BibliographicResources
    // resources` represents the bibliographic resources associated with the
    // payment.
    private Calendar dateOperation;
    private double mountPayment;
    private String typeTransaction;
    BibliographicResources resources;

    // This is a constructor method for the `Payment` class. It takes in four
    // parameters:
    // `dateOperation` of type `Calendar`, `mountPayment` of type `double`,
    // `typeTransaction` of type
    // `String`, and `resources` of type `BibliographicResources`. The constructor
    // initializes the
    // instance variables of the class with the values passed in as parameters.
    public Payment(Calendar dateOperation, double mountPayment, String typeTransaction,
            BibliographicResources resources) {
        this.typeTransaction = typeTransaction;
        this.dateOperation = dateOperation;
        this.mountPayment = mountPayment;
        this.resources = resources;
    }

    /**
     * The function returns the type of transaction as the invoice ID.
     * 
     * @return The method `getIdInvoice()` is returning the value of the instance
     *         variable
     *         `typeTransaction`.
     */
    public String getIdInvoice() {
        return this.typeTransaction;
    }

    /**
     * This function sets the type of transaction for an object.
     * 
     * @param type The parameter "type" is a String that represents the type of
     *             transaction being set.
     *             However, the code is assigning the value of "typeTransaction" to
     *             "type", which seems to be a
     *             mistake. It should be changed to "this.typeTransaction = type;".
     */
    public void setTransaction(String type) {
        this.typeTransaction = typeTransaction;
    }

    /**
     * The function returns the date of an operation as a Calendar object.
     * 
     * @return The method `getDateOperation()` is returning a `Calendar` object.
     */
    public Calendar getDateOperation() {
        return this.dateOperation;
    }

    /**
     * This function sets the value of the dateOperation variable to the provided
     * Calendar object.
     * 
     * @param dateOperation It is a variable of type Calendar that represents the
     *                      date of an operation.
     *                      The method sets the value of this variable to the value
     *                      passed as a parameter.
     */
    public void setDateOperation(Calendar dateOperation) {
        this.dateOperation = dateOperation;
    }

    /**
     * The function returns the value of the mountPayment variable as a double.
     * 
     * @return The method is returning the value of the instance variable
     *         `mountPayment` of the current
     *         object.
     */
    public double getMountPayment() {
        return this.mountPayment;
    }

    /**
     * This function sets the value of the mountPayment variable.
     * 
     * @param mountPayment a variable of type double that represents the amount of
     *                     payment to be set.
     *                     The method sets the value of the instance variable
     *                     mountPayment to the value passed as a
     *                     parameter.
     */
    public void setMountPayment(double mountPayment) {
        this.mountPayment = mountPayment;
    }

    /**
     * This function returns the bibliographic resources.
     * 
     * @return The method `getResources()` is returning an object of type
     *         `BibliographicResources`.
     */
    public BibliographicResources getResources() {
        return this.resources;
    }

    /**
     * This function sets the bibliographic resources for an object.
     * 
     * @param resources The "resources" parameter is an object of the class
     *                  "BibliographicResources".
     *                  The method "setResources" sets the value of the instance
     *                  variable "resources" to the value
     *                  passed as the parameter.
     */
    public void setResources(BibliographicResources resources) {
        this.resources = resources;
    }

    /**
     * This function sets the bibliographic resources for an object.
     * 
     * @param resources The parameter "resources" is of type
     *                  "BibliographicResources", which is likely
     *                  a class representing a collection of bibliographic resources
     *                  such as books, articles, or other
     *                  sources of information. The method "setRecurso" sets the
     *                  value of the instance variable
     *                  "resources" to the value passed in
     */
    public void setRecurso(BibliographicResources resources) {
        this.resources = resources;
    }
}
