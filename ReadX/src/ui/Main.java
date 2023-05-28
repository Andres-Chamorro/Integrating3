// The above code is declaring a Java package named "ui".
package ui;

import java.util.Scanner;
import java.util.Calendar;
import model.Book;
import model.Magazine;
import model.ControllerSystem;
import model.Users;
import model.Regular;
import model.Premium;
import model.BibliographicResources;

/**
 * The above code defines a Java class named "Main".
 */
public class Main {

    // The above code is declaring private instance variables in a Java class.
    private Scanner reader;
    private ControllerSystem controller;
    private Users verifyUser;
    private boolean verifyExist;

    // The above code is defining a constructor for a class named "Main". Within the
    // constructor, it
    // initializes a Scanner object named "reader" to read input from the console,
    // creates a new
    // instance of a class named "ControllerSystem" and assigns it to a variable
    // named "controller",
    // sets a variable named "verifyUser" to null, and sets a boolean variable named
    // "verifyExist" to
    // true.
    public Main() {
        reader = new Scanner(System.in);
        controller = new ControllerSystem();
        verifyUser = null;
        verifyExist = true;

    }

    /**
     * The main function runs a loop that displays either a login menu or a main
     * menu based on whether
     * the user is verified or not.
     */
    public static void main(String[] args) {
        Main main = new Main();
        int option = -1;
        do {
            if (main.verifyUser == null) {
                option = main.showLoginMenu();
                main.executeLoginMenuOption(option);
            } else {
                option = main.showMainMenu();
                main.executeMainMenuOption(option);
            }
        } while (option != 0);

    }

    /**
     * This function displays a login menu, validates and returns the user's
     * selected option as an
     * integer.
     * 
     * @return The method is returning an integer value, which is the user's
     *         selected option from the
     *         login menu.
     */
    public int showLoginMenu() {
        int option = 0;
        System.out.println(loginMenu());
        option = validateIntegerOption();
        return option;
    }

    /**
     * This Java function gets an integer option for displaying a bibliographic
     * product menu after
     * printing the menu.
     * 
     * @return The method is returning an integer value, which is the option
     *         selected by the user from
     *         the bibliographic product menu.
     */
    public int getOptionShowMenuBibliographic() {
        int option = 0;
        /**
         * This function gets an integer option from the user after displaying a
         * bibliographic product
         * menu.
         * 
         * @return The method is returning an integer value, which is the validated
         *         option selected by the
         *         user from the bibliographic product menu.
         */

        System.out.println(bibliographicProductMenu());
        option = validateIntegerOption();

        return option;
    }

    /**
     * This function gets an integer option from the user after displaying a
     * bibliographic product menu.
     * 
     * @return The method is returning an integer value, which is the validated
     *         option selected by the
     *         user from the bibliographic product menu.
     */
    public int getOptionReports() {
        int option = 0;

        System.out.println(bibliographicProductMenu());
        option = validateIntegerOption();

        return option;
    }

    /**
     * This function displays a main menu and returns the user's validated integer
     * option.
     * 
     * @return The method is returning an integer value, which is the user's
     *         selected option from the
     *         main menu.
     */
    public int showMainMenu() {
        int option = 0;
        System.out.println(mainMenu());
        option = validateIntegerOption();
        return option;
    }

    /**
     * This function displays a menu of reports and returns the user's selected
     * option as an integer.
     * 
     * @return The method is returning an integer value, which is the user's
     *         selected option from the
     *         report menu.
     */
    public int showMenuReports() {
        int option = 0;
        System.out.println(reportMenu());
        option = validateIntegerOption();
        return option;
    }

    /**
     * The function returns a string containing a login menu with options for
     * logging in, registering a
     * user, managing bibliographical products, generating reports, or exiting the
     * program.
     * 
     * @return A string that represents a login menu with options for logging in,
     *         registering a user,
     *         managing bibliographical products, generating reports, and exiting
     *         the program.
     */
    public String loginMenu() {
        return "\n" +
                "<< --------------------------------------------------------------------- >>\n" +
                "<< -                            Login Menu                             - >>\n" +
                "<< --------------------------------------------------------------------- >>\n" +
                "1. Login\n" +
                "2. Register user\n" +
                "3. Manage Bibliographical Products\n" +
                "4. Reports\n" +
                "0. Exit the program.\n";
    }

    /**
     * This function executes different options based on the input parameter,
     * including login, user
     * registration, bibliographic menu, report menu, and program exit.
     * 
     * @param option an integer representing the user's selected option from a login
     *               menu. It is used
     *               in a switch statement to determine which action to take.
     */
    public void executeLoginMenuOption(int option) {
        switch (option) {
            case 1:
                login();
                break;
            case 2:
                registerUser();
                break;
            case 3:
                option = getOptionShowMenuBibliographic();
                executeOptionBibliographic(option);
                break;
            case 4:
                option = getOptionReports();
                executeReportMenuOption(option);
                break;

            case 0:
                System.out.println("--------------------------------------------------");
                System.out.println("Exit program.");
                System.out.println("--------------------------------------------------");
                break;
            default:
                System.out.println("--------------------------------------------------");
                System.out.println("Invalid Option");
                System.out.println("--------------------------------------------------");
                break;
        }
    }

    /**
     * This function prompts the user to enter their user ID, verifies if the ID
     * exists in the system,
     * and displays a welcome message if the user is found or an error message if
     * the user is not
     * found.
     */
    public void login() {
        reader.nextLine();
        System.out.println("--------------------------------------------------");
        System.out.println("Enter user ID: ");
        String id = reader.nextLine();

        if (controller.verifyIdExists(id)) {
            verifyUser = controller.getUserById(id);
            System.out.println("--------------------------------------------------");
            System.out.println("Welcome Login " + verifyUser.getNameUser());
            System.out.println("--------------------------------------------------");

        } else {
            System.out.println("--------------------------------------------------");
            System.out.println("User not found. Please try again.");
            System.out.println("--------------------------------------------------");
        }
    }

    /**
     * The function returns a string that displays the main menu options for a
     * program related to
     * buying books, subscribing to magazines, viewing a library, and logging
     * out/exiting the program.
     * 
     * @return A string that represents the main menu of a program, which includes
     *         options to buy a
     *         book, subscribe to a magazine, view the library, or logout and exit
     *         the program.
     */
    public String mainMenu() {
        return "\n" +
                "<< --------------------------------------------------------------------- >>\n" +
                "<< -                             Main Menu                             - >>\n" +
                "<< --------------------------------------------------------------------- >>\n" +
                "1. Buy book\n" +
                "2. Subscribe to magazine\n" +
                "3. view Library\n" +
                "0. Logout and Exit the program.\n";
    }

    /**
     * The function executes a main menu option based on the input option number.
     * 
     * @param option The option selected by the user from the main menu. It is an
     *               integer value that
     *               determines which action to perform.
     */
    public void executeMainMenuOption(int option) {
        switch (option) {
            case 1:
                buyBook();
                break;
            case 2:
                subscribeToMagazine();
                break;
            case 3:
                viewLibrary();
                break;
            case 0:
                System.out.println("--------------------------------------------------");
                System.out.println("Logout successful.");
                System.out.println("--------------------------------------------------");
                break;
            default:
                System.out.println("--------------------------------------------------");
                System.out.println("Invalid Option");
                System.out.println("--------------------------------------------------");
                break;
        }
    }

    /**
     * This function returns a string that displays a menu for managing
     * bibliographic products such as
     * books and magazines.
     * 
     * @return A string that represents a menu for managing bibliographic products,
     *         including options
     *         to add books and magazines, modify and delete resources, and return
     *         to the main menu.
     */
    public String bibliographicProductMenu() {
        return "\n" +
                "<< --------------------------------------------------------------------- >>\n" +
                "<< -                  Bibliographic product management                 - >>\n" +
                "<< --------------------------------------------------------------------- >>\n" +
                "<<                         Books  and  Magazines                         >>\n" +
                "<< --------------------------------------------------------------------- >>\n" +
                "1. Add book\n" +
                "2. Add Magazine\n" +
                "3. Modify Resource\n" +
                "4. Delete Resource\n" +
                "0. Return to main menu.\n";
    }

    /**
     * This function executes different options related to bibliographic resources
     * based on the user's
     * input.
     * 
     * @param option an integer representing the user's selected option in a
     *               bibliographic system menu.
     *               The method executes different actions based on the value of
     *               this option.
     */
    public void executeOptionBibliographic(int option) {
        switch (option) {
            case 1:
                registerBook();
                break;
            case 2:
                registerMagazine();
                break;

            case 3:
                modifyResource();
                break;
            case 4:
                deleteResource();
                break;
            case 0:
                System.out.println("You returned to the main menu");
                break;
            default:
                System.out.println("--------------------------------------------------");
                System.out.println("Invalid Option");
                System.out.println("--------------------------------------------------");
                break;
        }
    }

    /**
     * The function returns a string containing the main menu options for a platform
     * and its features.
     * 
     * @return A string that represents the main menu of a platform with different
     *         options such as
     *         cumulative total number of pages read, most read book genre and
     *         magazine category, top 5 books
     *         and top 5 most read magazines, number of books sold and total sales
     *         value by genre, number of
     *         active subscriptions and the total value paid for subscriptions by
     *         category, and an option to
     *         logout and exit the program.
     */
    public String reportMenu() {
        return "\n" +
                "<< --------------------------------------------------------------------- >>\n" +
                "<< -                             Main Menu                             - >>\n" +
                "<< --------------------------------------------------------------------- >>\n" +
                "1. Cumulative total number of pages read across the platform\n" +
                "2. Most read book genre and magazine category on the platform\n" +
                "3. Top 5 books and the Top 5 most read magazines on the platform\n" +
                "4. number of books sold and total sales value by genre\n" +
                "5. number of active subscriptions and the total value paid for subscriptions by category\n" +
                "0. Logout and Exit the program.\n";
    }

    /**
     * This function executes a report menu option based on the user's input.
     * 
     * @param option an integer representing the user's selected option from a
     *               report menu. The method
     *               executes a specific report generation method based on the
     *               selected option. If the option is not
     *               valid, an error message is displayed.
     */
    public void executeReportMenuOption(int option) {
        switch (option) {
            case 1:
                controller.generateTotalPagesReadReport();
                break;
            case 2:
                controller.generateReportResourceMoreRead();
                break;
            case 3:
                controller.generateTopReadsReport();
                break;
            case 4:
                controller.generateGenreSalesReport();
                break;
            case 5:
                controller.generateCategorySubscriptionsReport();
                break;
            case 0:
                System.out.println("--------------------------------------------------");
                System.out.println("Exit program.");
                System.out.println("--------------------------------------------------");
                break;
            default:
                System.out.println("--------------------------------------------------");
                System.out.println("Invalid Option");
                System.out.println("--------------------------------------------------");
                break;
        }
    }

    /**
     * This function validates an integer input from the user and returns it, or
     * returns -1 if the input
     * is not an integer.
     * 
     * @return The method is returning an integer value, which could be either the
     *         integer value entered
     *         by the user or -1 if the user did not enter a valid integer.
     */
    public int validateIntegerOption() {
        int option = 0;

        if (reader.hasNextInt()) {
            option = reader.nextInt();
        } else {
            reader.nextLine();
            option = -1;
        }

        return option;
    }

    /**
     * This function registers a new user by taking input for their name, ID, and
     * user type, and adding
     * them to the system if their ID is unique.
     */
    public void registerUser() {
        System.out.println("--------------------------------------------------");
        reader.nextLine();
        System.out.println("Enter user name: ");
        String name = reader.nextLine();

        do {
            System.out.println("Enter user ID");
            String id = reader.nextLine();
            verifyExist = controller.verifyIdExists(id);
            if (verifyExist) {
                System.out.println("--------------------------------------------------");
                System.out.println("ID already exists, please enter another ID.");
                System.out.println("--------------------------------------------------");
            } else {
                Calendar dateVinculation = Calendar.getInstance();
                System.out.println("--------------------------------------------------");
                System.out.println("Select user type: ");
                System.out.println("1. Regular user");
                System.out.println("2. Premium user");
                int userType = validateIntegerOption();

                if (userType == 1) {
                    Regular regularUser = new Regular(name, id, dateVinculation);
                    controller.addUser(regularUser);
                } else if (userType == 2) {
                    Premium premiumUser = new Premium(name, id, dateVinculation);
                    controller.addUser(premiumUser);
                } else {
                    System.out.println("--------------------------------------------------");
                    System.out.println("Invalid option.");
                    System.out.println("--------------------------------------------------");
                }
            }

        } while (verifyExist);
    }

    /**
     * This function registers a new book by prompting the user to input various
     * details such as the
     * book's ID, name, number of pages, genre, publication date, cover URL, sale
     * value, and review.
     */
    public void registerBook() {
        System.out.println("--------------------------------------------------");
        reader.nextLine();
        String id;
        System.out.println("Enter book id - (3 hexadecimal characters)");
        do {
            id = reader.nextLine();
            if (id.length() != 3 || !id.matches("[0-9A-Fa-f]{3}")) {
                System.out.println("-------------------------------------------------------------------");
                System.out.println("Enter three valid hexadecimal characters - (A-F and 0-9 (ABC - ab7))");
                System.out.println("-------------------------------------------------------------------");
            }
        } while (id.length() != 3 || !id.matches("[0-9A-Fa-f]{3}"));
        do {
            System.out.println("Enter book name");
            String nameBook = reader.nextLine();
            verifyExist = controller.verifyNameExists(nameBook);

            if (verifyExist) {
                System.out.println("-----------------------------------------------------");
                System.out.println("Book's name already exists, please enter another name.");
                System.out.println("-----------------------------------------------------");
            } else {
                System.out.println("Enter the number of pages");
                int numberPages = validateIntegerOption();
                System.out.println("Enter a short review");
                String review = reader.nextLine();
                System.out.println("Enter the book genre:");
                System.out.println("1. Science Fiction");
                System.out.println("2. Fantasy");
                System.out.println("3. Historical Novel");
                int genre = reader.nextInt();
                reader.nextLine();
                Calendar datePublication = validateDate();
                reader.nextLine();
                System.out.println("Enter the URL of book cover");
                String URL = reader.nextLine();
                System.out.println("Enter the sale value in dollars of the book");
                double valueSale = validerDoubleInput(reader);

                controller.addBook(id, nameBook, numberPages, URL, valueSale, datePublication, review, genre);
            }

        } while (verifyExist);
    }

    /**
     * This function registers a new magazine by prompting the user to input various
     * details and
     * validating the input before adding it to the system.
     */
    public void registerMagazine() {
        System.out.println("--------------------------------------------------");
        reader.nextLine();
        String id;
        System.out.println("Enter magazine id - (3 hexadecimal alphanumeric)");
        do {
            id = reader.nextLine();
            if (id.length() != 3 || !id.matches("[0-9a-zA-Z]{3}")) {
                System.out.println("----------------------------------------------------------------------");
                System.out.println("Enter three valid alphanumeric characters - (A-Z and 0-9 (ABZ - aX8))");
                System.out.println("----------------------------------------------------------------------");
            }
        } while (id.length() != 3 || !id.matches("[0-9a-zA-Z]{3}"));
        do {
            System.out.println("Enter magazine name");
            String nameMagazine = reader.nextLine();
            if (verifyExist) {
                System.out.println("-----------------------------------------------------------");
                System.out.println("Magazine's name already exists, please enter another name.");
                System.out.println("------------------------------------------------------------");
            } else {
                System.out.println("Enter the number of pages");
                int numberPages = validerIntegerInput(reader);
                System.out.println("Enter the magazine category:");
                System.out.println("1. Varieties");
                System.out.println("2. Design");
                System.out.println("3. Scientific");
                int category = reader.nextInt();
                reader.nextLine();
                Calendar datePublication = validateDate();
                reader.nextLine();
                System.out.println("Enter the URL of magazine cover");
                String URL = reader.nextLine();
                System.out.println("Enter the sale value in dollars of the magazine");
                double valueSale = validerDoubleInput(reader);
                System.out.println("Enter the emission periodicity");
                int emissionPeriodicity = validerIntegerInput(reader);

                controller.addMagazine(id, nameMagazine, numberPages, URL, valueSale, datePublication, category,
                        emissionPeriodicity);
            }
        } while (verifyExist);

    }

    /**
     * This Java function prompts the user to enter the ID of a resource to be
     * deleted and then calls a
     * controller method to remove the resource.
     */
    public void deleteResource() {
        System.out.println("--------------------------------------------------");
        reader.nextLine();
        System.out.println("Enter the resource's ID to eliminate");
        String id = reader.nextLine();

        controller.removeResource(id);
    }

    /**
     * This function prompts the user to enter a publication date and validates it
     * before returning a
     * Calendar object.
     * 
     * @return A Calendar object is being returned.
     */
    public Calendar validateDate() {
        boolean validDate;
        Calendar calendar = Calendar.getInstance();

        do {
            System.out.println("Enter publication date:");
            System.out.print("Day: ");
            int day = validateIntegerOption();
            System.out.print("Month: ");
            int month = validateIntegerOption();
            System.out.print("Year: ");
            int year = validateIntegerOption();

            if (controller.isValidDate(day, month, year)) {
                calendar.set(Calendar.DAY_OF_MONTH, day);
                calendar.set(Calendar.MONTH, month - 1); // El mes en Calendar se indexa desde 0 (enero = 0)
                calendar.set(Calendar.YEAR, year);
                validDate = true;
            } else {
                System.out.println("--------------------------------------------------");
                System.out.println("Invalid date. Please enter a valid date.");
                System.out.println("--------------------------------------------------");
                validDate = false;
            }
        } while (!validDate);

        return calendar;
    }

    /**
     * This function validates user input to ensure it is an integer and prompts the
     * user to enter a
     * valid integer if the input is invalid.
     * 
     * @param reader A Scanner object used to read input from the user.
     * @return The method is returning an integer value.
     */
    public static int validerIntegerInput(Scanner reader) {
        while (!reader.hasNextInt()) {
            System.out.println("--------------------------------------------------");
            System.out.println("Input inválido. Por favor ingrese un número entero.");
            System.out.println("--------------------------------------------------");
            reader.next();
        }
        return reader.nextInt();
    }

    /**
     * This Java function validates and returns a double input from the user using a
     * Scanner object.
     * 
     * @param reader The parameter "reader" is a Scanner object that is used to read
     *               input from the
     *               user. It is passed as an argument to the method
     *               "validerDoubleInput" so that the method can read
     *               and validate the user's input.
     * @return The method is returning a double value that is entered by the user
     *         through the Scanner
     *         object.
     */
    public static double validerDoubleInput(Scanner reader) {
        while (!reader.hasNextDouble()) {
            System.out.println("--------------------------------------------------");
            System.out.println("Input inválido. Por favor ingrese un número valido en dolares.");
            System.out.println("--------------------------------------------------");
            reader.next();
        }
        return reader.nextDouble();
    }

    /**
     * This Java function allows the user to modify a bibliographic resource by
     * selecting which
     * attribute to modify and entering the new value.
     */
    public void modifyResource() {
        System.out.println("--------------------------------------------------");
        reader.nextLine();
        System.out.println("Enter id's resource to modify");
        String id = reader.nextLine();
        BibliographicResources resource = controller.getResourceById(id);
        if (resource == null) {
            System.out.println("Resource with ID " + id + " not found");
            return;
        }

        System.out.println("What do you want to modify?");
        System.out.println("1. Name");
        System.out.println("2. Number of pages");
        System.out.println("3. URL");
        System.out.println("4. Value");

        switch (reader.nextInt()) {
            case 1:
                System.out.println("Enter the new name: ");
                resource.setNameResource(reader.next());
                System.out.println("--------------------------------------------------");
                System.out.println("Resource name updated successfully");
                System.out.println("--------------------------------------------------");
                break;
            case 2:
                System.out.println("Enter the new number of pages: ");
                resource.setNumPages(reader.nextInt());
                System.out.println("--------------------------------------------------");
                System.out.println("Resource number of pages updated successfully");
                System.out.println("--------------------------------------------------");
                break;
            case 3:
                System.out.println("Enter the new URL: ");
                resource.setURL(reader.next());
                System.out.println("--------------------------------------------------");
                System.out.println("Resource URL updated successfully");
                System.out.println("--------------------------------------------------");
                break;
            case 4:
                System.out.println("Enter the new value: ");
                resource.setValueResource(reader.nextDouble());
                System.out.println("--------------------------------------------------");
                System.out.println("Resource value updated successfully");
                System.out.println("--------------------------------------------------");

                break;
            default:
                System.out.println("--------------------------------------------------");
                System.out.println("Invalid option");
                System.out.println("--------------------------------------------------");
                break;
        }
    }

    /**
     * This function allows a user to buy a book by entering its code or name,
     * generates a bill, and
     * updates the book's sales information.
     */
    public void buyBook() {
        System.out.println("--------------------------------------------------");
        reader.nextLine();
        System.out.println("Enter the book code or name: ");
        String codeOrName = reader.nextLine();

        // Buscar el libro por código o nombre en el controlador del sistema
        Book book = controller.getBookByCodeOrName(codeOrName);

        if (book != null) {
            // Generar factura
            Calendar currentDate = Calendar.getInstance();
            double amount = book.getValueResource();
            String bookName = book.getNameResource();

            System.out.println("<< --------------------------------------------------------------------- >>\n"
                    + "<< -                             Bill                            - >>\n" +
                    "<< --------------------------------------------------------------------- >>\n");
            System.out.println("Book: " + bookName);
            System.out.println("Amount: $" + amount);
            System.out.println("Date: " + currentDate.getTime());
            System.out.println("<< --------------------------------------------------------------------- >>");

            System.out.println("Enter the payment amount: ");
            double payment = validerDoubleInput(reader);
            System.out.println("");

            if (payment >= amount) {
                double change = payment - amount;
                System.out.println("Change: $" + change);

                book.setNumBookSold(book.getNumBookSold() + 1);
                System.out.println("Number of books purchased: " + book.getNumBookSold());

                controller.sellBook(verifyUser, book);
            } else {
                System.out.println("--------------------------------------------------");
                System.out.println("Insufficient payment.");
                System.out.println("--------------------------------------------------");
            }
        } else {
            System.out.println("--------------------------------------------------");
            System.out.println("Book not found.");
            System.out.println("--------------------------------------------------");
        }
    }

    /**
     * This function allows a user to subscribe to a magazine by entering the
     * magazine code, generating
     * a bill, and verifying payment.
     */
    public void subscribeToMagazine() {
        System.out.println("--------------------------------------------------");
        reader.nextLine();
        System.out.println("Enter the magazine code: ");
        String code = reader.nextLine();

        // Buscar la revista por código en el controlador del sistema
        Magazine magazine = controller.getMagazineByCodeOrName(code);

        if (magazine != null) {
            // Generar factura
            Calendar currentDate = Calendar.getInstance();
            double amount = magazine.getValueResource();
            String magazineName = magazine.getNameResource();
            System.out.println("<< --------------------------------------------------------------------- >>\n"
                    + "<< -                             Bill                            - >>\n" +
                    "<< --------------------------------------------------------------------- >>\n");
            System.out.println("Magazine: " + magazineName);
            System.out.println("Amount: $" + amount);
            System.out.println("Date: " + currentDate.getTime());
            System.out.println("<< --------------------------------------------------------------------- >>");

            // Solicitar el valor a pagar al usuario
            System.out.println("Enter the payment amount: ");
            double payment = validerDoubleInput(reader);

            if (payment >= amount) {
                // Calcular cambio
                double change = payment - amount;
                System.out.println("Change: $" + change);

                magazine.setNumSubsActives(magazine.getNumSubsActives() + 1);
                System.out.println("Number of active subscriptions: " + magazine.getNumSubsActives());

                controller.suscribiteMagazine(verifyUser, magazine);
            } else {
                System.out.println("--------------------------------------------------");
                System.out.println("Insufficient payment.");
                System.out.println("--------------------------------------------------");
            }
        } else {
            System.out.println("--------------------------------------------------");
            System.out.println("Magazine not found.");
            System.out.println("--------------------------------------------------");
        }
    }

    /**
     * This function displays the library and allows the user to navigate through it
     * using various
     * commands.
     */
    public void viewLibrary() {
        System.out.println("--------------------------------------------------");
        String input = "";

        controller.displayLibrary(verifyUser);
        System.out.println("--------------------------------------------------");
        System.out.println("Digite la coordenada (x/y) o el código correspondiente");
        System.out.println("Digite A para ir a la página anterior");
        System.out.println("Digite B para ir a la página siguiente");
        System.out.println("Digite E para salir");
        System.out.println("--------------------------------------------------");

        while (!input.equalsIgnoreCase("E")) {
            input = reader.next();
            controller.navigateLibrary(verifyUser, input);

        }
    }

}