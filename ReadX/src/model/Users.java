// `package model;` is declaring that the class belongs to the `model` package, which is a way of
// organizing related classes in a Java project. This package can be imported by other classes in the
// project to use the classes and methods defined in it.
package model;

import java.util.Calendar;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Random;
import java.util.Scanner;

/**
 * The class "Users" is an abstract class.
 */
public abstract class Users {
    // These are instance variables of the abstract class `Users`. They represent
    // the attributes and
    // behavior of a user in the system, such as their name, ID, date of
    // vinculation, payments, library
    // of resources, ads, current page being read, total pages read, and a scanner
    // object to read user
    // input.
    private String nameUser;
    private String id;
    private Calendar dateVinculation;
    private ArrayList<Payment> payments;
    private ArrayList<BibliographicResources> library;
    private ArrayList<String> ads;
    private int currentPage;
    private static final int ITEMS_PER_PAGE = 25;
    private int totalPagesRead;
    private Scanner reader;

    // This is a constructor method for the abstract class `Users`. It takes in
    // three parameters:
    // `nameUser` (a String representing the name of the user), `id` (a String
    // representing the ID of
    // the user), and `dateVinculation` (a Calendar object representing the date of
    // vinculation of the
    // user).
    public Users(String nameUser, String id, Calendar dateVinculation) {
        this.nameUser = nameUser;
        this.id = id;
        this.dateVinculation = dateVinculation;
        payments = new ArrayList<>();
        library = new ArrayList<>();
        this.currentPage = 0;
        this.totalPagesRead = 0;
        this.reader = new Scanner(System.in);
        ads = new ArrayList<>();
        ads.add("¡Suscríbete al Combo Plus y llévate Disney+ y Star+ a un precio increíble!");
        ads.add("Ahora tus mascotas tienen una app favorita: Laika. Los mejores productos para tu peludito.");
        ads.add("¡Estamos de aniversario! Visita tu Éxito más cercano y sorpréndete con las mejores ofertas.");

    }

    /**
     * The function adds a payment object to a list of payments.
     * 
     * @param payment The parameter "payment" is an object of the class Payment that
     *                is being passed as
     *                an argument to the method addPayment(). The method adds this
     *                payment object to a list called
     *                "payments".
     */
    public void addPayment(Payment payment) {
        payments.add(payment);
    }

    /**
     * The function randomly selects an advertisement from a list and displays it.
     */
    public void showAds() {
        Random random = new Random();
        int posAds = random.nextInt(ads.size());
        String anuncio = ads.get(posAds);
        System.out.println("--------------------------------------------------");
        System.out.println("---- Advertisement ----");
        System.out.println("");
        System.out.println(anuncio);
    }

    /**
     * The function returns an ArrayList of Payment objects.
     * 
     * @return An ArrayList of Payment objects is being returned.
     */
    public ArrayList<Payment> getPayments() {
        return payments;
    }

    /**
     * This function returns an ArrayList of BibliographicResources representing a
     * library.
     * 
     * @return An ArrayList of BibliographicResources objects named "library" is
     *         being returned.
     */
    public ArrayList<BibliographicResources> getLibrary() {
        return library;
    }

    /**
     * The function returns the name of the user.
     * 
     * @return The method `getNameUser()` is returning the value of the instance
     *         variable `nameUser`.
     */
    public String getNameUser() {
        return this.nameUser;
    }

    /**
     * This function sets the value of the "nameUser" variable in a Java class.
     * 
     * @param nameUser The parameter `nameUser` is a `String` type variable that
     *                 represents the name of
     *                 a user. The `setNameUser` method sets the value of the
     *                 `nameUser` variable to the value passed
     *                 as an argument to the method.
     */
    public void setNameUser(String nameUser) {
        this.nameUser = nameUser;
    }

    /**
     * The function returns the ID of an object.
     * 
     * @return The method `getId()` is returning a `String` value which is the `id`
     *         of the object.
     */
    public String getId() {
        return this.id;
    }

    /**
     * This Java function sets the value of the "id" variable to the input parameter
     * "id".
     * 
     * @param id The parameter "id" is a String type variable that is being passed
     *           as an argument to
     *           the method. The method sets the value of the instance variable "id"
     *           to the value of the
     *           parameter "id".
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * This function returns the date of vinculation.
     * 
     * @return A Calendar object representing the date of vinculation.
     */
    public Calendar getDateVinculation() {
        return this.dateVinculation;
    }

    /**
     * This function sets the date of vinculation for an object.
     * 
     * @param dateVinculation It is a variable of type Calendar that represents the
     *                        date of vinculation
     *                        (or joining) of an employee to a company. This method
     *                        sets the value of the dateVinculation
     *                        variable to the specified Calendar object.
     */
    public void setDateVinculation(Calendar dateVinculation) {
        this.dateVinculation = dateVinculation;
    }

    /**
     * This function removes a bibliographic resource from a library.
     * 
     * @param resource The parameter "resource" is an object of the class
     *                 "BibliographicResources". It
     *                 is the resource that needs to be removed from the library.
     */
    public void removeFromLibrary(BibliographicResources resource) {
        library.remove(resource);
    }

    /**
     * The function displays a library of bibliographic resources in a grid format
     * with a limit of 25
     * resources per page.
     */
    public void displayLibrary() {
        int startIndex = currentPage * ITEMS_PER_PAGE;
        int endIndex = Math.min(startIndex + ITEMS_PER_PAGE, library.size());

        System.out.println("Library of " + nameUser);
        System.out.println("");
        System.out.println("y/x  |  0  |  1  |  2  |  3  |  4  |");

        for (int y = 0; y < 5; y++) {
            System.out.print(y + "    |");

            for (int x = 0; x < 5; x++) {
                int index = startIndex + y * 5 + x;
                if (index < endIndex) {
                    BibliographicResources resource = library.get(index);
                    System.out.print(" " + resource.getId() + " |");
                } else {
                    System.out.print("_____|");
                }
            }

            System.out.println();
        }
    }

    /**
     * This function adds a bibliographic resource to a library and sorts the
     * library by publication
     * date.
     * 
     * @param resource an object of type BibliographicResources that represents a
     *                 bibliographic
     *                 resource (e.g. a book, article, or website) that is being
     *                 added to a library.
     */
    public void addResourceToLibrary(BibliographicResources resource) {
        library.add(resource);
        sortLibraryByPublicationDate();
    }

    /**
     * The function allows navigation through a library by either moving to the
     * previous or next page,
     * selecting a resource by its coordinates or code, or displaying an error
     * message for invalid
     * input.
     * 
     * @param input A string input that represents the user's navigation choice in a
     *              library system. It
     *              can be "A" to go to the previous page, "B" to go to the next
     *              page, a three-digit code to access
     *              a specific resource, or a three-digit coordinate to access a
     *              specific resource.
     */
    public void navigateLibrary(String input) {
        if (input.equalsIgnoreCase("A")) {
            currentPage--;
            if (currentPage < 0) {
                currentPage = 0;
            }
        } else if (input.equalsIgnoreCase("B")) {
            int totalPageCount = (int) Math.ceil((double) library.size() / ITEMS_PER_PAGE);
            currentPage++;
            if (currentPage >= totalPageCount) {
                currentPage = totalPageCount - 1;
            }
        } else if (input.length() == 3 && input.charAt(1) == '/') {
            int x = Character.getNumericValue(input.charAt(0));
            int y = Character.getNumericValue(input.charAt(2));
            BibliographicResources resource = getResourceByCoordinates(x, y);
            if (resource != null) {
                startReadingSession(resource);
            } else {
                System.out.println("--------------------------------------------------");
                System.out.println("The entered coordinate is not in the library.");
                System.out.println("--------------------------------------------------");
            }
        } else if (input.length() == 3) {
            BibliographicResources resource = getResourceByCode(input);
            if (resource != null) {
                startReadingSession(resource);
            } else {
                System.out.println("--------------------------------------------------");
                System.out.println("The entered code is not in the library");
                System.out.println("--------------------------------------------------");
            }
        } else {
            System.out.println("--------------------------------------------------");
            System.out.println("Invalid entry");
            System.out.println("--------------------------------------------------");
        }
    }

    /**
     * This function sorts a library of bibliographic resources by their publication
     * date using a
     * comparator.
     */
    private void sortLibraryByPublicationDate() {
        library.sort(Comparator.comparing(BibliographicResources::getDatePublication));
    }

    /**
     * This function starts a reading session for a given bibliographic resource and
     * allows the user to
     * navigate through its pages.
     * 
     * @param resource The bibliographic resource (book or magazine) that the user
     *                 wants to read. It
     *                 contains information such as the name of the resource, the
     *                 current page being read, and the
     *                 total number of pages.
     */
    public void startReadingSession(BibliographicResources resource) {
        System.out.println("--------------------------------------------------");
        System.out.println("Reading session in progress:");
        System.out.println("");
        System.out.println("Reading: " + resource.getNameResource());
        System.out.println("");
        System.out.println("Reading page " + (resource.getCurrentPage() + 1) + " of " + resource.getTotalPages());
        System.out.println("--------------------------------------------------");
        while (true) {
            System.out.println("Type A to go to the next page");
            System.out.println("Type S to go to the previous page");
            System.out.println("Enter B to return to the library");

            String input = reader.next();

            if (input.equalsIgnoreCase("A")) {
                resource.nextPage();
                totalPagesRead++;
                if (resource instanceof Book && resource.getTotalPages() > 0 && resource.getCurrentPage() % 20 == 0) {
                    showAds();
                } else if (resource instanceof Magazine && resource.getTotalPages() > 0
                        && resource.getCurrentPage() % 5 == 0) {
                    showAds();
                }
            } else if (input.equalsIgnoreCase("S")) {
                resource.previousPage();
            } else if (input.equalsIgnoreCase("B")) {
                break;
            } else {
                System.out.println("--------------------------------------------------");
                System.out.println("Invalid entry");
                System.out.println("--------------------------------------------------");
            }

            System.out.println("--------------------------------------------------");
            System.out.println("");
            System.out.println("Reading: " + resource.getNameResource());
            System.out.println("");
            System.out.println("Reading page " + (resource.getCurrentPage() + 1) + " of " + resource.getTotalPages());
            System.out.println("");
            System.out.println("--------------------------------------------------");

        }
        displayLibrary();
        System.out.println("--------------------------------------------------");
        System.out.println("Type the coordinate (x/y) or the corresponding code");
        System.out.println("Type A to go to the previous page");
        System.out.println("Type B to go to the next page");
        System.out.println("Enter E to exit");
        System.out.println("--------------------------------------------------");

    }

    /**
     * This Java function searches for a BibliographicResource in a library by its
     * code and returns it
     * if found.
     * 
     * @param code A String representing the unique identifier of a
     *             BibliographicResource object.
     * @return The method is returning a BibliographicResources object that matches
     *         the input code
     *         parameter, or null if no match is found in the library list.
     */
    private BibliographicResources getResourceByCode(String code) {
        for (int i = 0; i < library.size(); i++) {
            BibliographicResources resource = library.get(i);
            if (resource.getId().equals(code)) {
                return resource;
            }
        }
        return null;
    }

    /**
     * This function returns a BibliographicResource object from a library based on
     * its coordinates on
     * a page.
     * 
     * @param x The x-coordinate of the item in a grid of items on a page.
     * @param y The y parameter in the method represents the row number of the item
     *          in a grid layout.
     * @return The method is returning a BibliographicResources object or null if
     *         the index is out of
     *         bounds.
     */
    private BibliographicResources getResourceByCoordinates(int x, int y) {
        int index = currentPage * ITEMS_PER_PAGE + y * 5 + x;
        if (index >= 0 && index < library.size()) {
            return library.get(index);
        }
        return null;
    }

}