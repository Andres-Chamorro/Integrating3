package ui;

import java.util.Scanner;

import model.Book;
import model.ControllerSystem;
import java.util.Calendar;
import model.Users;
import model.Regular;
import model.Premium;

public class Main {

    // esta relación nos ayuda a crear un estado inicial de nuestro programa
    private Scanner reader;
    private ControllerSystem controller;
    private boolean idExist;

    public Main() {
        reader = new Scanner(System.in);
        controller = new ControllerSystem();
        idExist = true;

    }

    public static void main(String[] args) {
        Main main = new Main();
        int option = -1;
        do {

            option = main.getOptionShowMenuPrimary();
            main.executeOption(option);

        } while (option != 0);

    }

    public int getOptionShowMenuPrimary() {
        int option = 0;
        System.out.println(Menu());
        option = validateIntegerOption();
        return option;
    }

    public int getOptionShowMenuBibliographic() {
        int option = 0;

        System.out.println(bibliographicProductMenu());
        option = validateIntegerOption();

        return option;
    }

    public String Menu() {
        return "\n" +
                "<< --------------------------------------------------------------------- >>\n" +
                "<< -                                Welcome                            - >>\n" +
                "<< --------------------------------------------------------------------- >>\n" +
                "1. Register User\n" +
                "2. Bibliographic product management\n" +
                "3. Automation\n" +
                "4. Buy book\n" +
                "5. Subscribe to magazine\n" +
                "6. Simulate reading session\n" +
                "0. Exit the program.\n";

    }

    public void executeOption(int option) {

        switch (option) {
            case 1:
                registerUser();
                break;

            case 2:
                option = getOptionShowMenuBibliographic();
                executeOptionBibliographic(option);
                break;

            case 3:
                break;

            case 4:
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

    public String bibliographicProductMenu() {
        return "\n" +
                "<< --------------------------------------------------------------------- >>\n" +
                "<< -                  Bibliographic product management                 - >>\n" +
                "<< --------------------------------------------------------------------- >>\n" +
                "     Book      \n" +
                "-----------------------\n" +
                "1. Add book\n" +
                "2. Modify book\n" +
                "3. Delete book\n" +
                "-----------------------\n" +
                "     Magazine      \n" +
                "-----------------------\n" +
                "4. Add Magazine\n" +
                "5. Modify magazine\n" +
                "6. Delete magazine\n" +
                "0. Return to main menu.\n";
    }

    public void executeOptionBibliographic(int option) {
        switch (option) {
            case 1:
                registerBook();
                break;

            case 2:
                // edit product
                break;

            case 3:
                deleteBook();
                break;
            case 4:
                registerMagazine();
                break;
            case 5:

                break;
            case 6:
                deleteMagazine();
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

    public int validateIntegerOption() {
        int option = 0;

        if (reader.hasNextInt()) {
            option = reader.nextInt();
        } else {
            // clear reader.
            reader.nextLine();
            option = -1;
        }

        return option;
    }

    public void registerUser() {
        reader.nextLine();
        System.out.println("Enter user name: ");
        String name = reader.nextLine();

        do {
            System.out.println("Enter user ID");
            String id = reader.nextLine();
            idExist = controller.verifyUserExists(id);
            if (idExist) {
                System.out.println("ID already exists, please enter another ID.");
            } else {
                Calendar dateVinculation = Calendar.getInstance();
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
                    System.out.println("Invalid option.");
                }
            }

        } while (idExist);
    }

    public void registerBook() {
        reader.nextLine();
        String id;
        System.out.println("Enter book id - (3 hexadecimal characters)");
        do {
            id = reader.nextLine();
            if (id.length() != 3 || !id.matches("[0-9A-Fa-f]{3}")) {
                System.out.println("Enter three valid hexadecimal characters - (A-F and 0-9 (ABC - ab7))");
            }
        } while (id.length() != 3 || !id.matches("[0-9A-Fa-f]{3}"));
        System.out.println("Enter book name");
        String nameBook = reader.nextLine();
        System.out.println("Enter the number of pages");
        int numberPages = reader.nextInt();
        reader.nextLine();
        System.out.println("Enter a short review");
        String review = reader.nextLine();
        System.out.println("Enter the book genre:");
        System.out.println("1. Science Fiction");
        System.out.println("2. Fantasy");
        System.out.println("3. Historical Novel");
        int genre = reader.nextInt();
        reader.nextLine();
        System.out.println("Enter the publication date of the book - (dd/mm/yyyy)");
        String datePublication = reader.nextLine();
        System.out.println("Enter the URL of book cover");
        String URL = reader.nextLine();
        System.out.println("Enter the sale value in dollars of the book");
        double valueSale = reader.nextDouble();

        controller.addBook(id, nameBook, numberPages, URL, valueSale, review, genre);
    }

    public void registerMagazine() {
        reader.nextLine();
        String id;
        System.out.println("Enter magazine id - (3 hexadecimal alphanumeric)");
        do {
            id = reader.nextLine();
            if (id.length() != 3 || !id.matches("[0-9a-zA-Z]{3}")) {
                System.out.println("Enter three valid alphanumeric characters - (A-Z and 0-9 (ABZ - aX8))");
            }
        } while (id.length() != 3 || !id.matches("[0-9a-zA-Z]{3}"));
        System.out.println("Enter magazine name");
        String nameMagazine = reader.nextLine();
        System.out.println("Enter the number of pages");
        int numberPages = reader.nextInt();
        reader.nextLine();
        System.out.println("Enter the publication date of the magazine - (dd/mm/yyyy)");
        String datePublication = reader.nextLine();
        System.out.println("Enter the magazine category:");
        System.out.println("1. Varieties");
        System.out.println("2. Design");
        System.out.println("3. Scientific");
        int category = reader.nextInt();
        reader.nextLine();
        System.out.println("Enter the URL of magazine cover");
        String URL = reader.nextLine();
        System.out.println("Enter the sale value in dollars of the magazine");
        double valueSale = reader.nextDouble();
        System.out.println("Enter the emission periodicity");
        int emissionPeriodicity = reader.nextInt();

        controller.addMagazine(id, nameMagazine, numberPages, URL, valueSale, category,
                emissionPeriodicity);
    }

    public void deleteBook() {
        reader.nextLine();
        System.out.println("Enter the book's ID to eliminate");
        String id = reader.nextLine();

        controller.removeBook(id);
    }

    public void verify() {

    }

    public void deleteMagazine() {
        reader.nextLine();
        System.out.println("Enter the magazine's ID to eliminate");
        String id = reader.nextLine();

        controller.removeMagazine(id);
    }

    public void buyBook() {
        System.out.println("Enter the Book's name to buy");
        String nameBook = reader.nextLine();
    }

    public void buyMagazine() {
        System.out.println("Enter the Magazine's name to buy");
        String nameMagazine = reader.nextLine();
    }

}