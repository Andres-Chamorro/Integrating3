package model;

public class Book extends BibliographicResources {
    private String review;
    private GenreBook genreBook;
    private int numBookSold;

    public Book(String id, String nameResource, int numPages, String URL, double valueResource,
            String review, GenreBook genreBook) {
        super(id, nameResource, numPages, URL, valueResource);
        this.review = review;
        this.genreBook = genreBook;
        this.numPagesRead = 0;
        this.numBookSold = 0;
    }

    public String getReview() {
        return this.review;
    }

    public void setReview(String review) {
        this.review = review;
    }

    public GenreBook getGenreBook() {
        return this.genreBook;
    }

    public void setGenreBook(GenreBook genreBook) {
        this.genreBook = genreBook;
    }

    public int getNumBookSold() {
        return this.numBookSold;
    }

    public void setNumBookSold(int numBookSold) {
        this.numBookSold = numBookSold;
    }

}