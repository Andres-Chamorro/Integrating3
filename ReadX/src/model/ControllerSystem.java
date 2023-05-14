package model;

import java.util.Calendar;
import java.util.ArrayList;

public class ControllerSystem {

    private ArrayList<Users> users;
    private ArrayList<BibliographicResources> resources;

    public ControllerSystem() {
        users = new ArrayList<Users>();
        resources = new ArrayList<BibliographicResources>();

    }

    public ArrayList<Users> getUsers() {
        return users;
    }

    public void addUser(Users user) {
        users.add(user);
        System.out.println("User register correctly");
    }

    public void addBook(String id, String nameResource, int numPages, String URL, double valueResource,
            String datePublication, String review, int genreBooks) {
        Book book = new Book(id, nameResource, numPages, URL, valueResource, datePublication, review, null);

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

        book.setGenreBook(genre);

        resources.add(book);
        System.out.println("Book register correctly");
    }

    public void addMagazine(String id, String nameResource, int numPages, String URL, double valueResource,
            String datePublication, int category, int emissionPeriodicity) {
        Magazine magazine = new Magazine(id, nameResource, numPages, URL, valueResource, datePublication, null,
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

        magazine.setCategory(categories);

        resources.add(magazine);
        System.out.println("Magazine register correctly");
    }

    public boolean verifyNameExists(String name) {
        for (int i = 0; i < resources.size(); i++) {
            if (resources.get(i) != null && resources.get(i).getNameResource().equalsIgnoreCase(name)) {
                return true;
            }
        }
        return false;
    }

    public boolean verifyIdExists(String id) {
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i) != null && users.get(i).getId().equalsIgnoreCase(id)) {
                return true;
            }
        }
        return false;
    }

    public boolean verifyCodeExists(String id) {
        for (int i = 0; i < resources.size(); i++) {
            if (resources.get(i) != null && resources.get(i).getId().equalsIgnoreCase(id)) {
                return true;
            }
        }
        return false;
    }

    public boolean validateDate(String dateString) {
        String dateFormat = "\\d{2}/\\d{2}/\\d{4}";
        return dateString.matches(dateFormat);
    }

    public void removeResource(String id) {
        for (int i = 0; i < resources.size(); i++) {
            if (resources.get(i) != null && resources.get(i).getId().equalsIgnoreCase(id)) {
                resources.remove(i);
                System.out.println("Resource removed successfully");
                return;
            }
        }
        System.out.println("Resource with ID " + id + " not found");
    }

}