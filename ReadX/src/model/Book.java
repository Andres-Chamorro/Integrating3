// `package model;` is declaring that the `Book` class belongs to the `model` package. This is a way of
// organizing classes and avoiding naming conflicts with classes in other packages.
package model;

import java.util.Calendar;

/**
 * The "Book" class extends the "BibliographicResources" class in Java.
 */
public class Book extends BibliographicResources {
    private String review;
    private GenreBook genreBook;
    private int numBookSold;

    // This is a constructor method for the `Book` class that takes in several
    // parameters including
    // `id`, `nameResource`, `numPages`, `URL`, `valueResource`, `datePublication`,
    // `review`, and
    // `genreBook`. It calls the constructor of the superclass
    // `BibliographicResources` using the
    // `super` keyword and passes in some of the parameters. It also initializes the
    // `review` and
    // `genreBook` instance variables with the corresponding parameters passed in,
    // and sets the
    // `numBookSold` instance variable to 0.
    public Book(String id, String nameResource, int numPages, String URL, double valueResource,
            Calendar datePublication, String review, GenreBook genreBook) {
        super(id, nameResource, numPages, URL, valueResource, datePublication);
        this.review = review;
        this.genreBook = genreBook;
        this.numBookSold = 0;
    }

    /**
     * The function returns the review string.
     * 
     * @return The method `getReview()` is returning a `String` value which is the
     *         review stored in the
     *         object.
     */
    public String getReview() {
        return this.review;
    }

    /**
     * This function sets the review for a particular object.
     * 
     * @param review The parameter "review" is a String that represents the review
     *               of a product or
     *               service. The method "setReview" sets the value of the instance
     *               variable "review" to the value
     *               passed as a parameter.
     */
    public void setReview(String review) {
        this.review = review;
    }

    /**
     * The function returns the genre of a book.
     * 
     * @return The method is returning an object of the class GenreBook.
     */
    public GenreBook getGenreBook() {
        return this.genreBook;
    }

    /**
     * This function sets the genre of a book.
     * 
     * @param genreBook The parameter "genreBook" is an object of the class
     *                  "GenreBook". The method
     *                  "setGenreBook" sets the value of the instance variable
     *                  "genreBook" to the value passed as the
     *                  parameter.
     */
    public void setGenreBook(GenreBook genreBook) {
        this.genreBook = genreBook;
    }

    /**
     * The function returns the number of books sold.
     * 
     * @return The method `getNumBookSold()` is returning the value of the instance
     *         variable
     *         `numBookSold`.
     */
    public int getNumBookSold() {
        return this.numBookSold;
    }

    /**
     * This function sets the value of the variable "numBookSold".
     * 
     * @param numBookSold The parameter "numBookSold" is an integer value
     *                    representing the number of
     *                    books sold. The method "setNumBookSold" sets the value of
     *                    the instance variable "numBookSold" to
     *                    the value passed as the parameter.
     */
    public void setNumBookSold(int numBookSold) {
        this.numBookSold = numBookSold;
    }

    /**
     * The function increments the number of books sold by one.
     */
    public void sellBook() {
        this.numBookSold++;
    }

}
