// The above code is declaring a Java package named "model".
package model;

import java.util.Calendar;
import java.util.ArrayList;
import java.util.Random;

/**
 * The class is named ControllerSystem and its purpose is not specified as there
 * is no code written
 * inside it.
 */
public class ControllerSystem {

    // The above code is declaring three private fields in a Java class: an
    // ArrayList of Users, an
    // ArrayList of BibliographicResources, and a static final integer constant
    // named ITEMS_PER_PAGE
    // with a value of 25. The purpose of these fields is not clear from the code
    // snippet alone, but
    // they could be used to store and manage collections of user and resource
    // objects in a larger
    // program.
    private ArrayList<Users> users;
    private ArrayList<BibliographicResources> resources;
    private ArrayList<Object> testObjects = new ArrayList<>();
    Random random = new Random();
    private static final int ITEMS_PER_PAGE = 25;

    // The above code is defining a constructor for a class called
    // `ControllerSystem`. Within the
    // constructor, two empty ArrayLists are created: `users` of type `Users` and
    // `resources` of type
    // `BibliographicResources`.
    public ControllerSystem() {
        users = new ArrayList<Users>();
        resources = new ArrayList<BibliographicResources>();

    }

    /**
     * This function returns an ArrayList of Users.
     * 
     * @return An ArrayList of Users is being returned.
     */
    public ArrayList<Users> getUsers() {
        return users;
    }

    /**
     * This function returns an ArrayList of BibliographicResources objects
     * representing a library.
     * 
     * @return An ArrayList of BibliographicResources objects named "resources".
     */

    public ArrayList<BibliographicResources> getLibrary() {
        return resources;
    }

    /**
     * This function adds a user to a list and prints a confirmation message.
     * 
     * @param user The parameter "user" is an object of the class "Users" that
     *             represents a user to be
     *             added to a collection of users. The method "addUser" adds this
     *             user object to the collection and
     *             prints a message to indicate that the user has been registered
     *             successfully.
     */
    public void addUser(Users user) {
        users.add(user);
        System.out.println("--------------------------------------------------");
        System.out.println("User register correctly");
        System.out.println("--------------------------------------------------");
    }

    /**
     * This function adds a book to a list of resources with specified attributes
     * such as ID, name,
     * number of pages, URL, value, publication date, review, and genre.
     * 
     * @param id              The unique identifier for the book being added.
     * @param nameResource    The name of the book resource being added.
     * @param numPages        The number of pages in the book.
     * @param URL             The URL parameter is a String that represents the URL
     *                        (Uniform Resource Locator) of
     *                        the book's online location.
     * @param valueResource   The value or price of the book resource.
     * @param datePublication A Calendar object representing the date of publication
     *                        of the book.
     * @param review          A String representing the review or summary of the
     *                        book.
     * @param genreBooks      An integer representing the genre of the book being
     *                        added. The options are:
     */
    public void addBook(String id, String nameResource, int numPages, String URL, double valueResource,
            Calendar datePublication, String review, int genreBooks) {
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
                System.out.println("--------------------------------------------------");
                System.out.println("invalid option, genre incorrect, try again");
                System.out.println("--------------------------------------------------");

                return;
        }

        book.setGenreBook(genre);

        resources.add(book);
        System.out.println("--------------------------------------------------");
        System.out.println("Book register correctly");
        System.out.println("--------------------------------------------------");
    }

    /**
     * This function adds a new magazine to a list of resources with specified
     * attributes such as ID,
     * name, number of pages, URL, value, publication date, category, and emission
     * periodicity.
     * 
     * @param id                  A unique identifier for the magazine.
     * @param nameResource        The name of the magazine resource being added.
     * @param numPages            The number of pages in the magazine.
     * @param URL                 The URL parameter is a String that represents the
     *                            URL (Uniform Resource Locator) of
     *                            the magazine's online version or website.
     * @param valueResource       The value of the magazine resource, which is a
     *                            double data type.
     * @param datePublication     A Calendar object representing the date of
     *                            publication of the magazine.
     * @param category            The category parameter is an integer that
     *                            represents the category of the
     *                            magazine being added. It can have a value of 1, 2,
     *                            or 3, which correspond to the categories of
     *                            Varieties, Design, and Scientific, respectively.
     *                            If the value is not one of these options, an
     *                            error
     * @param emissionPeriodicity The emission periodicity refers to how often the
     *                            magazine is
     *                            published or released, such as weekly, monthly, or
     *                            quarterly. It is an integer value
     *                            representing the number of days between each
     *                            publication.
     */
    public void addMagazine(String id, String nameResource, int numPages, String URL, double valueResource,
            Calendar datePublication, int category, int emissionPeriodicity) {
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
                System.out.println("--------------------------------------------------");
                System.out.println("invalid option, category incorrect, try again");
                System.out.println("--------------------------------------------------");
                return;
        }

        magazine.setCategory(categories);

        resources.add(magazine);
        System.out.println("--------------------------------------------------");
        System.out.println("Magazine register correctly");
        System.out.println("--------------------------------------------------");
    }

    /**
     * This function checks if a given name exists in a list of resources.
     * 
     * @param name The name of the resource that needs to be verified if it exists
     *             in the list of
     *             resources.
     * @return A boolean value is being returned. It will be true if the name exists
     *         in the list of
     *         resources, and false otherwise.
     */
    public boolean verifyNameExists(String name) {
        for (int i = 0; i < resources.size(); i++) {
            if (resources.get(i) != null && resources.get(i).getNameResource().equalsIgnoreCase(name)) {
                return true;
            }
        }
        return false;
    }

    /**
     * This function checks if a given ID exists in a list of users.
     * 
     * @param id The parameter "id" is a String representing the unique identifier
     *           of a user. The method
     *           "verifyIdExists" checks if this id already exists in the list of
     *           users.
     * @return A boolean value is being returned. It will be true if the given ID
     *         exists in the list of
     *         users, and false otherwise.
     */
    public boolean verifyIdExists(String id) {
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i) != null && users.get(i).getId().equalsIgnoreCase(id)) {
                return true;
            }
        }
        return false;
    }

    /**
     * This function checks if a resource with a given ID exists in a list of
     * resources.
     * 
     * @param id The parameter "id" is a String representing the unique identifier
     *           of a resource that
     *           needs to be verified if it exists in a list of resources.
     * @return A boolean value is being returned. It will be true if a resource with
     *         the given id
     *         exists in the resources list, and false otherwise.
     */
    public boolean verifyCodeExists(String id) {
        for (int i = 0; i < resources.size(); i++) {
            if (resources.get(i) != null && resources.get(i).getId().equalsIgnoreCase(id)) {
                return true;
            }
        }
        return false;
    }

    /**
     * The function checks if a given date is valid or not.
     * 
     * @param day   The day of the month, represented as an integer.
     * @param month The month parameter is an integer representing the month of the
     *              year, with January
     *              being 1 and December being 12.
     * @param year  The year of the date being checked for validity.
     * @return A boolean value indicating whether the input date is valid or not.
     */
    public static boolean isValidDate(int day, int month, int year) {
        if (year < 0) {
            return false;
        }

        if (month < 1 || month > 12) {
            return false;
        }

        if (day < 1 || day > 31) {
            return false;
        }

        return true;
    }

    /**
     * This Java function removes a resource from a list of resources based on its
     * ID.
     * 
     * @param id The ID of the resource that needs to be removed from the list of
     *           resources.
     */
    public void removeResource(String id) {
        for (int i = 0; i < resources.size(); i++) {
            if (resources.get(i) != null && resources.get(i).getId().equalsIgnoreCase(id)) {
                resources.remove(i);
                System.out.println("--------------------------------------------------");
                System.out.println("Resource removed successfully");
                System.out.println("--------------------------------------------------");
                return;
            }
        }
        System.out.println("--------------------------------------------------");
        System.out.println("Resource with ID " + id + " not found");
        System.out.println("--------------------------------------------------");
    }

    /**
     * This Java function searches for a BibliographicResource object in a list by
     * its ID and returns it
     * if found.
     * 
     * @param id The parameter "id" is a String that represents the unique
     *           identifier of a bibliographic
     *           resource. The method "getResourceById" searches for a resource in a
     *           list of resources by
     *           comparing the id of each resource with the given id parameter. If a
     *           match is found, the method
     *           returns the resource object.
     * @return The method is returning a BibliographicResources object with the
     *         specified id, or null if
     *         no such object exists in the resources list.
     */
    public BibliographicResources getResourceById(String id) {
        for (int i = 0; i < resources.size(); i++) {
            BibliographicResources resource = resources.get(i);
            if (resource.getId().equals(id)) {
                return resource;
            }
        }
        return null;
    }

    /**
     * This function returns a User object from a list of Users based on a given ID.
     * 
     * @param id The parameter "id" is a String representing the unique identifier
     *           of a user. The
     *           method "getUserById" searches for a user in a list of users by
     *           comparing their IDs with the
     *           given "id" parameter. If a user with the matching ID is found, the
     *           method returns that user
     *           object.
     * @return This method returns a Users object with the specified id if it exists
     *         in the list of
     *         users, otherwise it returns null.
     */
    public Users getUserById(String id) {
        for (int i = 0; i < users.size(); i++) {
            Users user = users.get(i);
            if (user.getId().equals(id)) {
                return user;
            }
        }
        return null;
    }

    /**
     * The function sells a book and adds it to a user's library.
     * 
     * @param users The parameter "users" is an object of the class "Users". It
     *              represents a collection
     *              of users who have a library of resources, including books.
     * @param book  The book parameter is an instance of the Book class, which
     *              represents a book that is
     *              being sold.
     */
    public void sellBook(Users users, Book book) {
        book.sell();
        users.addResourceToLibrary(book);

    }

    /**
     * This function adds a magazine subscription to a user's library and increments
     * the active
     * subscription count for the magazine.
     * 
     * @param users    The parameter "users" is likely an object representing a user
     *                 or a collection of
     *                 users in a software system. It is being passed as an argument
     *                 to the method "suscribiteMagazine"
     *                 along with another parameter "magazine".
     * @param magazine The magazine parameter is an object of the Magazine class,
     *                 which represents a
     *                 magazine that a user can subscribe to.
     */
    public void suscribiteMagazine(Users users, Magazine magazine) {
        magazine.sell();
        users.addResourceToLibrary(magazine);

    }

    /**
     * This function stops the subscription of a magazine for a user.
     * 
     * @param users    The parameter "users" is likely an instance of a class
     *                 representing a user or a
     *                 collection of users who have subscribed to the magazine. It
     *                 is being passed as an argument to
     *                 the method "stopSuscriptionMagazine" which suggests that the
     *                 method is responsible for stopping
     *                 the subscription of the magazine for the
     * @param magazine an object of the Magazine class representing the magazine
     *                 that the user wants to
     *                 stop their subscription to.
     */
    public void stopSuscriptionMagazine(Users users, Magazine magazine) {
        magazine.stopSuscription();
    }

    /**
     * This Java function searches for a book in a list of bibliographic resources
     * by either its ID or
     * name and returns the book if found.
     * 
     * @param codeOrName A string that represents either the ID code or the name of
     *                   a book. The method
     *                   searches for a book in a list of bibliographic resources
     *                   and returns the book object that
     *                   matches the given code or name.
     * @return The method is returning a Book object that matches the given code or
     *         name, or null if no
     *         such book is found in the list of resources.
     */
    public Book getBookByCodeOrName(String codeOrName) {
        for (int i = 0; i < resources.size(); i++) {
            BibliographicResources resource = resources.get(i);
            if (resource instanceof Book) {
                Book book = (Book) resource;
                if (book.getId().equalsIgnoreCase(codeOrName) || book.getNameResource().equalsIgnoreCase(codeOrName)) {
                    return book;
                }
            }
        }
        return null;
    }

    /**
     * This Java function searches for a magazine in a list of bibliographic
     * resources by either its ID
     * or name and returns it if found.
     * 
     * @param codeOrName a String parameter that represents either the ID or the
     *                   name of a magazine.
     * @return The method is returning a Magazine object that matches the given code
     *         or name, or null
     *         if no such Magazine is found in the list of resources.
     */
    public Magazine getMagazineByCodeOrName(String codeOrName) {
        for (int i = 0; i < resources.size(); i++) {
            BibliographicResources resource = resources.get(i);
            if (resource instanceof Magazine) {
                Magazine magazine = (Magazine) resource;
                if (magazine.getId().equalsIgnoreCase(codeOrName)
                        || magazine.getNameResource().equalsIgnoreCase(codeOrName)) {
                    return magazine;
                }
            }
        }
        return null;
    }

    /**
     * This function displays the library of a user.
     * 
     * @param user The parameter "user" is an object of the class "Users". It is
     *             being passed as an
     *             argument to the method "displayLibrary". The method then calls
     *             the "displayLibrary" method of
     *             the "Users" class on the "user" object.
     */
    public void displayLibrary(Users user) {
        user.displayLibrary();
    }

    /**
     * This function allows a user to navigate a library based on their input.
     * 
     * @param user  The user parameter is an object of the Users class, which
     *              represents a user of the
     *              library system.
     * @param input The input parameter is a String that represents the user's
     *              desired navigation
     *              action in the library. It could be a command to search for a
     *              book, borrow a book, return a book,
     *              or any other action that the library system supports. The
     *              specific actions that are available
     *              will depend on the implementation of the
     */
    public void navigateLibrary(Users user, String input) {
        user.navigateLibrary(input);
    }

    /**
     * This function generates a report of the total number of pages read for books
     * and magazines in a
     * collection of bibliographic resources.
     */
    public void generateTotalPagesReadReport() {
        int totalBookPages = 0;
        int totalMagazinePages = 0;

        for (int i = 0; i < resources.size(); i++) {
            BibliographicResources resource = resources.get(i);
            if (resource instanceof Book) {
                Book book = (Book) resource;
                totalBookPages += book.getNumPages();
            } else if (resource instanceof Magazine) {
                Magazine magazine = (Magazine) resource;
                totalMagazinePages += magazine.getNumPages();
            }
        }

        System.out.println("----- Pages Read Report -----");
        System.out.println("Books:");
        System.out.println("Number of pages read: " + totalBookPages);
        System.out.println("------------------------");
        System.out.println("Magazines:");
        System.out.println("Number of pages read: " + totalMagazinePages);
    }

    /**
     * This function generates a report on the most read book genre and magazine
     * category based on the
     * number of pages read.
     */
    public void generateReportResourceMoreRead() {
        GenreBook mostReadGenre = null;
        int maxGenrePages = 0;
        Category mostReadCategory = null;
        int maxCategoryPages = 0;

        for (int i = 0; i < resources.size(); i++) {
            BibliographicResources resource = resources.get(i);
            if (resource instanceof Book) {
                Book book = (Book) resource;
                GenreBook genre = book.getGenreBook();
                int totalPages = book.getNumPages();
                if (totalPages > maxGenrePages) {
                    maxGenrePages = totalPages;
                    mostReadGenre = genre;
                }
            } else if (resource instanceof Magazine) {
                Magazine magazine = (Magazine) resource;
                Category category = magazine.getCategory();
                int totalPages = magazine.getNumPages();
                if (totalPages > maxCategoryPages) {
                    maxCategoryPages = totalPages;
                    mostReadCategory = category;
                }
            }
        }

        System.out.println("--------------------------------------------------");
        System.out.println("Report: Most Read Book Genre and Magazine Category");
        if (mostReadGenre != null) {
            System.out
                    .println("Most read book genre: " + mostReadGenre + " (" + maxGenrePages + " pages read)");
        } else {
            System.out.println("--------------------------------------------------");
            System.out.println("No books registered on the platform.");
            System.out.println("--------------------------------------------------");
        }
        if (mostReadCategory != null) {
            System.out.println("Most-read magazine category:" + mostReadCategory + " (" + maxCategoryPages
                    + " pages read)");
        } else {
            System.out.println("--------------------------------------------------");
            System.out.println("There are no journals registered on the platform.");
            System.out.println("--------------------------------------------------");
        }
    }

    /**
     * This function generates a report of the top 5 most read books and magazines,
     * displaying their
     * name, genre/category, and number of pages read.
     */
    public void generateTopReadsReport() {

        if (resources.isEmpty()) {
            System.out.println("No books available in the library.");
        } else {
            System.out.println("----- Top 5 Most Read Books -----");
            int bookCount = 0;
            for (int i = 0; i < resources.size() && bookCount < 5; i++) {
                BibliographicResources resource = resources.get(i);
                if (resource instanceof Book) {
                    Book book = (Book) resource;
                    System.out.println("Name: " + book.getNameResource());
                    System.out.println("Genre: " + book.getGenreBook().toString());
                    System.out.println("Pages read: " + book.getNumPagesRead());
                    System.out.println("------------------------");
                    bookCount++;
                }
            }
        }

        if (resources.isEmpty()) {
            System.out.println("No magazines available in the library.");

        } else {
            System.out.println("----- Top 5 Most Read Magazines -----");
            int magazineCount = 0;
            for (int i = 0; i < resources.size() && magazineCount < 5; i++) {
                BibliographicResources resource = resources.get(i);
                if (resource instanceof Magazine) {
                    Magazine magazine = (Magazine) resource;
                    System.out.println("Name: " + magazine.getNameResource());
                    System.out.println("Category: " + magazine.getCategory().toString());
                    System.out.println("Pages read: " + resource.getNumPagesRead());
                    System.out.println("------------------------");
                    magazineCount++;
                }
            }
        }
    }

    /**
     * This function generates a sales report for books categorized by genre.
     */
    public void generateGenreSalesReport() {
        int scienceFictionCount = 0;
        int fantasyCount = 0;
        int historicalNovelCount = 0;
        double scienceFictionSales = 0;
        double fantasySales = 0;
        double historicalNovelSales = 0;

        for (int i = 0; i < resources.size(); i++) {
            BibliographicResources resource = resources.get(i);
            if (resource instanceof Book) {
                Book book = (Book) resource;
                if (book.getGenreBook() == GenreBook.SCIENCE_FICTION) {
                    scienceFictionCount++;
                    scienceFictionSales += book.getValueResource();
                } else if (book.getGenreBook() == GenreBook.FANTASY) {
                    fantasyCount++;
                    fantasySales += book.getValueResource();
                } else if (book.getGenreBook() == GenreBook.HISTORICAL_NOVEL) {
                    historicalNovelCount++;
                    historicalNovelSales += book.getValueResource();
                }
            }
        }

        System.out.println("----- Sales Report by Gender -----");
        System.out.println("Genre: Science Fiction");
        System.out.println("Books sold: " + scienceFictionCount);
        System.out.println("Total sales value: $" + scienceFictionSales);
        System.out.println("------------------------");
        System.out.println("Genre: Fantasy");
        System.out.println("Books sold: " + fantasyCount);
        System.out.println("Total sales value: $" + fantasySales);
        System.out.println("------------------------");
        System.out.println("Genre: Historical Novel");
        System.out.println("Books sold: " + historicalNovelCount);
        System.out.println("Total sales value: $" + historicalNovelSales);
    }

    // The above code is generating a report of the number of active subscriptions
    // and the total
    // payment for each category of magazines (varieties, design, and scientific)
    // based on the
    // information stored in a list of BibliographicResources. It iterates through
    // the list, identifies
    // the magazines, and calculates the total number of active subscriptions and
    // the total payment for
    // each category. Finally, it prints the report to the console.
    public void generateCategorySubscriptionsReport() {
        int varietiesCount = 0;
        int designCount = 0;
        int scientificCount = 0;
        double varietiesTotalPayment = 0;
        double designTotalPayment = 0;
        double scientificTotalPayment = 0;

        for (int i = 0; i < resources.size(); i++) {
            BibliographicResources resource = resources.get(i);
            if (resource instanceof Magazine) {
                Magazine magazine = (Magazine) resource;
                if (magazine.getCategory() == Category.VARIETIES) {
                    varietiesCount += magazine.getNumSubsActives();
                    varietiesTotalPayment += magazine.getNumSubsActives() * magazine.getValueResource();
                } else if (magazine.getCategory() == Category.DESIGN) {
                    designCount += magazine.getNumSubsActives();
                    designTotalPayment += magazine.getNumSubsActives() * magazine.getValueResource();
                } else if (magazine.getCategory() == Category.SCIENTIFIC) {
                    scientificCount += magazine.getNumSubsActives();
                    scientificTotalPayment += magazine.getNumSubsActives() * magazine.getValueResource();
                }
            }
        }

        System.out.println("----- Subscription Report by Category -----");
        System.out.println("Category: Varieties");
        System.out.println("Active subscriptions: " + varietiesCount);
        System.out.println("Total amount paid: $" + varietiesTotalPayment);
        System.out.println("------------------------");
        System.out.println("Category: Design");
        System.out.println("Active subscriptions: " + designCount);
        System.out.println("Total amount paid: $" + designTotalPayment);
        System.out.println("------------------------");
        System.out.println("Category: Scientific");
        System.out.println("Active subscriptions: " + scientificCount);
        System.out.println("Total amount paid: $" + scientificTotalPayment);
    }

    /**
     * This function initializes and generates test data for users, books, and
     * magazines, and prints
     * them in formatted tables.
     */
    public void TestInit() {
        for (int i = 0; i < 10; i++) {
            String userName = "Regular User " + (i + 1);
            String userId = generateRandomNumber();
            Calendar joinDate = Calendar.getInstance();
            joinDate.add(Calendar.DAY_OF_MONTH, -random.nextInt(365));

            Regular regularUser = new Regular(userName, userId, joinDate);
            users.add(regularUser);
        }

        // Generate premium users
        for (int i = 0; i < 10; i++) {
            String userName = "Premium User " + (i + 1);
            String userId = generateRandomNumber();
            Calendar joinDate = Calendar.getInstance();
            joinDate.add(Calendar.DAY_OF_MONTH, -random.nextInt(365));

            Premium premiumUser = new Premium(userName, userId, joinDate);
            users.add(premiumUser);
        }
        // Generar libros
        for (int i = 0; i < 20; i++) {
            String bookId = generateRandomHexId(3);
            String bookName = "Book" + i;
            int numPages = random.nextInt(500) + 100;
            String url = "www.book" + (i + 1) + ".com";
            double value = Math.round((random.nextDouble() * 50 + 10) * 100.0) / 100.0;
            Calendar datePublication = Calendar.getInstance();
            String review = "Review for Book " + (i + 1);
            GenreBook genreBook = GenreBook.values()[random.nextInt(GenreBook.values().length)];

            Book book = new Book(bookId, bookName, numPages, url, value, datePublication, review, genreBook);
            resources.add(book);
        }

        // Generar revistas
        for (int i = 0; i < 20; i++) {
            String magazineId = generateRandomAlphanumericId(3);
            String magazineName = "Magazine " + (i + 1);
            int numPages = random.nextInt(100) + 50;
            String url = "www.magazine" + (i + 1) + ".com";
            double value = Math.round((random.nextDouble() * 50 + 10) * 100.0) / 100.0;
            Calendar datePublication = Calendar.getInstance();
            Category category = Category.values()[random.nextInt(Category.values().length)];
            int emissionPeriodicity = random.nextInt(30) + 1;

            Magazine magazine = new Magazine(magazineId, magazineName, numPages, url, value,
                    datePublication, category, emissionPeriodicity);
            resources.add(magazine);
        }

        System.out.println("+----------------------+------------+");
        System.out.println("|      NameUser        |     id     |");
        System.out.println("+----------------------+------------+");

        int maxRows = users.size();

        for (int i = 0; i < maxRows; i++) {
            Users user = users.get(i);
            String userName = String.format("%-20s",
                    user.getNameUser().substring(0, Math.min(user.getNameUser().length(), 19)));
            System.out.printf("| %s | %-10s |\n", userName, user.getId());
        }

        System.out.println("+----------------------+------------+");
        System.out.println();
        System.out.println("+------------+----------------------+------------+------------+");
        System.out.println("|     id     |      Resource        |   Pages    |   Value    |");
        System.out.println("+------------+----------------------+------------+------------+");

        for (int i = 0; i < resources.size(); i++) {
            if (resources.get(i) instanceof Book) {
                Book book = (Book) resources.get(i);
                System.out.printf("| %-10s | %-20s | %-10s | %-10s |\n", book.getId(),
                        book.getNameResource(), book.getNumPages(), book.getValueResource());
            }
        }

        System.out.println("+------------+----------------------+------------+------------+");
        System.out.println();
        System.out.println("+------------+----------------------+------------+------------+");
        System.out.println("|     id     |      Resource        |   Pages    |   Value    |");
        System.out.println("+------------+----------------------+------------+------------+");

        for (int i = 0; i < resources.size(); i++) {
            if (resources.get(i) instanceof Magazine) {
                Magazine magazine = (Magazine) resources.get(i);
                System.out.printf("| %-10s | %-20s | %-10s | %-10s |\n", magazine.getId(),
                        magazine.getNameResource(), magazine.getNumPages(), magazine.getValueResource());
            }
        }

        System.out.println("+------------+----------------------+------------+------------+");
    }

    private String generateRandomNumber() {
        StringBuilder cedulaNumber = new StringBuilder();

        for (int i = 0; i < 5; i++) {
            int digit = random.nextInt(5);
            cedulaNumber.append(digit);
        }

        return cedulaNumber.toString();
    }

    private String generateRandomHexId(int length) {
        StringBuilder hexId = new StringBuilder();

        for (int i = 0; i < length; i++) {
            int digit = random.nextInt(16); // Genera un número aleatorio de 0 a 15
            hexId.append(Integer.toHexString(digit)); // Convierte el número a su representación hexadecimal y lo agrega
                                                      // al StringBuilder
        }

        return hexId.toString().toUpperCase(); // Convierte la cadena a mayúsculas y la devuelve
    }

    private String generateRandomAlphanumericId(int length) {
        StringBuilder alphanumericId = new StringBuilder();

        String alphanumericChars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";

        for (int i = 0; i < length; i++) {
            int randomIndex = random.nextInt(alphanumericChars.length());
            char randomChar = alphanumericChars.charAt(randomIndex);
            alphanumericId.append(randomChar);
        }

        return alphanumericId.toString();
    }

}
