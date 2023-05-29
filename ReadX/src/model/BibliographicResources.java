// `package model;` is a declaration that specifies the package name for the Java class file. In this
// case, it indicates that the `BibliographicResources` class belongs to the `model` package. This
// helps to organize and group related classes together and avoid naming conflicts with classes in
// other packages.
package model;

import java.util.Calendar;

/**
 * This is an abstract class for bibliographic resources.
 */
public abstract class BibliographicResources {
    // These are instance variables or fields of the `BibliographicResources` class.
    // They represent the
    // attributes or properties of a bibliographic resource such as its ID, name,
    // number of pages, URL,
    // value, date of publication, number of pages read, and current page. These
    // fields are used to
    // store and manipulate data related to a bibliographic resource object.
    private String id;
    private String nameResource;
    private int numPages;
    private String URL;
    private double valueResource;
    protected Calendar datePublication;
    private int numPagesRead;
    private int currentPage;

    // This is a constructor method for the `BibliographicResources` class. It takes
    // in several
    // parameters such as `id`, `nameResource`, `numPages`, `URL`, `valueResource`,
    // and
    // `datePublication` and initializes the corresponding instance variables of the
    // class with these
    // values. It also sets the `numPagesRead` and `currentPage` variables to 0.
    // This constructor is
    // used to create new instances of the `BibliographicResources` class with the
    // specified
    // attributes.
    public BibliographicResources(String id, String nameResource, int numPages, String URL, double valueResource,
            Calendar datePublication) {
        this.id = id;
        this.nameResource = nameResource;
        this.numPages = numPages;
        this.URL = URL;
        this.valueResource = valueResource;
        this.datePublication = datePublication;
        this.numPagesRead = 0;
        this.currentPage = 0;
    }

    /**
     * The function returns the value of the "id" variable as a string.
     * 
     * @return The method `getId()` is returning a `String` value which is the `id`
     *         of the object.
     */
    public String getId() {
        return this.id;
    }

    /**
     * The function returns the date of publication as a Calendar object.
     * 
     * @return The method `getDatePublication()` is returning a `Calendar` object.
     */
    public Calendar getDatePublication() {
        return this.datePublication;
    }

    /**
     * This Java function sets the value of the "id" variable.
     * 
     * @param id The parameter "id" is a String type variable that is being passed
     *           as an argument to
     *           the method "setId". The method sets the value of the instance
     *           variable "id" to the value of the
     *           parameter "id".
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * The function returns the name of a resource.
     * 
     * @return The method `getNameResource()` is returning the value of the instance
     *         variable
     *         `nameResource`.
     */
    public String getNameResource() {
        return this.nameResource;
    }

    /**
     * This Java function returns the number of pages read.
     * 
     * @return The method `getNumPagesRead()` is returning the value of the instance
     *         variable
     *         `numPagesRead`.
     */
    public int getNumPagesRead() {
        return this.numPagesRead;
    }

    /**
     * This function sets the value of the "numPagesRead" variable.
     * 
     * @param numPagesRead The parameter `numPagesRead` is an integer value
     *                     representing the number of
     *                     pages read. This method sets the value of the instance
     *                     variable `numPagesRead` to the value
     *                     passed as the parameter.
     */
    public void setNumPagesRead(int numPagesRead) {
        this.numPagesRead = numPagesRead;
    }

    /**
     * This function sets the value of the "nameResource" variable.
     * 
     * @param nameResource The parameter nameResource is a String that represents
     *                     the name of a
     *                     resource. The method sets the value of the instance
     *                     variable nameResource to the value of the
     *                     parameter nameResource.
     */
    public void setNameResource(String nameResource) {
        this.nameResource = nameResource;
    }

    /**
     * This Java function returns the number of pages.
     * 
     * @return The method `getNumPages()` is returning the value of the instance
     *         variable `numPages`.
     */
    public int getNumPages() {
        return this.numPages;
    }

    /**
     * This Java function sets the number of pages for a book object.
     * 
     * @param numPages numPages is an integer parameter that represents the number
     *                 of pages in a book.
     *                 The method setNumPages() sets the value of the instance
     *                 variable numPages to the value passed as
     *                 the parameter.
     */
    public void setNumPages(int numPages) {
        this.numPages = numPages;
    }

    /**
     * The function returns the URL of an object.
     * 
     * @return The method `getURL()` is returning the value of the instance variable
     *         `URL`.
     */
    public String getURL() {
        return this.URL;
    }

    /**
     * This function sets the URL for a Java object.
     * 
     * @param URL The URL parameter is a string that represents the Uniform Resource
     *            Locator (URL) of a
     *            web page or resource. This method sets the value of the URL
     *            instance variable to the value
     *            passed as a parameter.
     */
    public void setURL(String URL) {
        this.URL = URL;
    }

    /**
     * The function returns the value of a resource as a double data type.
     * 
     * @return The method `getValueResource()` is returning a `double` value which
     *         is the value of the
     *         `valueResource` variable.
     */
    public double getValueResource() {
        return this.valueResource;
    }

    /**
     * This Java function sets the value of a resource.
     * 
     * @param valueResource valueResource is a variable of type double that
     *                      represents the value of a
     *                      resource. The method `setValueResource` sets the value
     *                      of this variable to the value passed as a
     *                      parameter.
     */
    public void setValueResource(double valueResource) {
        this.valueResource = valueResource;
    }

    /**
     * The function returns the current page number.
     * 
     * @return The method `getCurrentPage()` is returning an integer value which
     *         represents the current
     *         page.
     */
    public int getCurrentPage() {
        return currentPage;
    }

    /**
     * This function sets the current page to the specified value.
     * 
     * @param currentPage currentPage is an integer variable that represents the
     *                    current page number in
     *                    a pagination system. The method `setCurrentPage` sets the
     *                    value of the `currentPage` variable to
     *                    the value passed as a parameter.
     */
    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    /**
     * This Java function increases the number of pages read by a given amount.
     * 
     * @param pages The parameter "pages" is an integer value representing the
     *              number of pages that
     *              will be added to the "numPagesRead" variable.
     */
    public void increasePagesRead(int pages) {
        numPagesRead += pages;
    }

    /**
     * The function increments the current page number if it is less than the total
     * number of pages.
     */
    public void nextPage() {
        if (currentPage < numPages - 1) {
            currentPage++;
        }
    }

    /**
     * The function decreases the current page number by 1 if it is greater than 0.
     */
    public void previousPage() {
        if (currentPage > 0) {
            currentPage--;
        }
    }

    /**
     * This Java function returns the total number of pages.
     * 
     * @return The method is returning the total number of pages in a book, which is
     *         stored in the
     *         variable `numPages`.
     */
    public int getTotalPages() {
        return numPages;
    }

    @Override
    public String toString() {
        String format = "| %-10s | %-20s | %-10s | %-10s |\n";
        StringBuilder sb = new StringBuilder();

        sb.append("+------------+----------------------+------------+------------+\n");
        sb.append("|     id     |      Resource        |   Pages    |   Value    |\n");
        sb.append("+------------+----------------------+------------+------------+\n");
        sb.append(String.format(format, getId(), getNameResource(), getNumPages(), getValueResource()));
        sb.append("+------------+----------------------+------------+------------+\n");

        return sb.toString();
    }

}