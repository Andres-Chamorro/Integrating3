package model;

import java.util.Calendar;
import model.Users;
import model.BibliographicResources;

public class ControllerSystem {

    public static final int SIZE_USER = 50;
    public static final int SIZE_BOOK = 100;
    public static final int SIZE_BIBLIOGRAPHIC = 100;
    public static final int SIZE_MAGAZINE = 100;
    private BibliographicResources[] resources;
    private Users[] users;
    private Book[] book;
    private Magazine[] magazines;

    public ControllerSystem() {
        users = new Users[SIZE_USER];
        book = new Book[SIZE_BOOK];
        magazines = new Magazine[SIZE_MAGAZINE];
        resources = new BibliographicResources[SIZE_BIBLIOGRAPHIC];

    }

    public Users[] getUsers() {
        return users;
    }

    public void addUser(Users user) {
        int pos = getFirstValidPosition(SIZE_USER, users);
        if (pos != -1) {
            users[pos] = user;
            System.out.println("User register correctly");
        } else {
            System.out.println("Users array is full.");
        }
    }

    public void addBook(String id, String nameResource, int numPages, String URL, double valueResource, String review,
            int genreBooks) {
        int pos = getFirstValidPosition(SIZE_BOOK, book);
        Book books = new Book(id, nameResource, numPages, URL, valueResource, review, null);

        GenreBook genre;
        switch (genreBooks) {
            case 1:
                genre = GenreBook.SCIENCE_FICTION;
                break;
            case 2:
                genre = GenreBook.FANTASY;
                break;
            case 3:
                genre = GenreBook.HISTORICAL_NOVEL;
                break;
            default:
                System.out.println("invalid option");
                return;
        }

        if (pos != -1) {
            book[pos] = books;
            System.out.println("Book register correctly");
        } else {
            System.out.println("Book array is full.");
        }
    }

    public void addMagazine(String id, String nameResource, int numPages, String URL, double valueResource,
            int category, int emissionPeriodicity) {

        int pos = getFirstValidPosition(SIZE_MAGAZINE, magazines);

        Magazine magazine = new Magazine(id, nameResource, numPages, URL, valueResource, null,
                emissionPeriodicity);

        Category categories;
        switch (category) {
            case 1:
                categories = Category.VARIETIES;
                break;
            case 2:
                categories = Category.DESIGN;
                break;
            case 3:
                categories = Category.SCIENTIFIC;
                break;
            default:
                System.out.println("invalid option");
                return;
        }

        if (pos != -1) {
            magazines[pos] = magazine;
            System.out.println("Magazine register correctly");
        } else {
            System.out.println("Magazine array is full.");
        }
    }

    public int getFirstValidPosition(int SIZE, Object[] array) {
        int pos = -1;
        boolean isFound = false;
        for (int i = 0; i < SIZE && !isFound; i++) {
            if (array[i] == null) {
                pos = i;
                isFound = true;
            }
        }
        return pos;
    }

    public boolean verifyUserExists(String id) {
        for (int i = 0; i < users.length; i++) {
            if (users[i] != null && users[i].getId().equalsIgnoreCase(id)) {
                return true;
            }
        }
        return false;
    }

    public boolean verifyNameBookExists(String name) {
        for (int i = 0; i < book.length; i++) {
            if (book[i] != null && book[i].getNameResource().equalsIgnoreCase(name)) {
                return true;
            }
        }
        return false;
    }

    public void verify() {
    }

    public void removeBook(String id) {
        for (int i = 0; i < book.length; i++) {
            if (book[i] != null && book[i].getId().equalsIgnoreCase(id)) {
                book[i] = null;
                System.out.println("Book removed successfully");
                return;
            }
        }
        System.out.println("Book with ID " + id + " not found");
    }

    public void removeMagazine(String id) {
        for (int i = 0; i < magazines.length; i++) {
            if (magazines[i] != null && magazines[i].getId().equalsIgnoreCase(id)) {
                magazines[i] = null;
                System.out.println("Magazine removed successfully");
                return;
            }
        }
        System.out.println("Magazine with ID " + id + " not found");
    }

    public void addResource(BibliographicResources resource, int option) {
        int pos = getFirstValidPosition(SIZE_BIBLIOGRAPHIC, resources);
        switch (option) {
            case 1:

                break;
            case 2:

                break;
        }
    }

}