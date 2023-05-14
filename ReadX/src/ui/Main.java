package ui;

import java.util.Scanner;
import java.util.Calendar;
import model.Book;
import model.ControllerSystem;
import model.Users;
import model.Regular;
import model.Premium;

public class Main {

    private Scanner reader;
    private ControllerSystem controller;
    private boolean verifyExist;

    public Main() {
        reader = new Scanner(System.in);
        controller = new ControllerSystem();
        verifyExist = true;

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
                break;
            case 4:
                registerMagazine();
                break;
            case 5:

                break;
            case 6:
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
            verifyExist = controller.verifyIdExists(id);
            if (verifyExist) {
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

        } while (verifyExist);
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
        do {
            System.out.println("Enter book name");
            String nameBook = reader.nextLine();
            verifyExist = controller.verifyNameExists(nameBook);

            if (verifyExist) {
                System.out.println("Book's name already exists, please enter another name.");
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
                String datePublication = validateDate();
                System.out.println("Enter the URL of book cover");
                String URL = reader.nextLine();
                System.out.println("Enter the sale value in dollars of the book");
                double valueSale = validerDoubleInput(reader);

                controller.addBook(id, nameBook, numberPages, URL, valueSale, datePublication, review, genre);
            }

        } while (verifyExist);
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
        do {
            System.out.println("Enter magazine name");
            String nameMagazine = reader.nextLine();
            if (verifyExist) {
                System.out.println("Magazine's name already exists, please enter another name.");
            } else {
                System.out.println("Enter the number of pages");
                int numberPages = validerIntegerInput(reader);
                System.out.println("Enter the magazine category:");
                System.out.println("1. Varieties");
                System.out.println("2. Design");
                System.out.println("3. Scientific");
                int category = reader.nextInt();
                reader.nextLine();
                String datePublication = validateDate();
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

    public void deleteResource() {
        reader.nextLine();
        System.out.println("Enter the resource's ID to eliminate");
        String id = reader.nextLine();

        controller.removeResource(id);
    }

    public void buyBook() {
        System.out.println("Enter the Book's name to buy");
        String nameBook = reader.nextLine();
    }

    public void buyMagazine() {
        System.out.println("Enter the Magazine's name to buy");
        String nameMagazine = reader.nextLine();
    }

    public String validateDate() {
        boolean validDate;
        String date;
        do {
            System.out.println("Enter publication date (dd/MM/yyyy):");
            date = reader.nextLine();
            validDate = controller.validateDate(date);
            if (!validDate) {
                System.out.println("Invalid date format. Please enter a date in the format dd/MM/yyyy.");
            }
        } while (!validDate);
        return date;
    }

    public static int validerIntegerInput(Scanner reader) {
        while (!reader.hasNextInt()) {
            System.out.println("Input inválido. Por favor ingrese un número entero.");
            reader.next();
        }
        return reader.nextInt();
    }

    public static double validerDoubleInput(Scanner reader) {
        while (!reader.hasNextDouble()) {
            System.out.println("Input inválido. Por favor ingrese un número valido en dolares.");
            reader.next();
        }
        return reader.nextDouble();
    }

    public void menuModify() {
        System.out.println("Seleccione la información a modificar:");
        System.out.println("1. Nombre");
        System.out.println("2. Reseña");
        System.out.println("3. URL de portada");
        System.out.println("4. Valor de venta / Suscripción");
        int option = validerIntegerInput(reader);

        switch (option) {
            case 1:
                break;
            case 2:
                break;
            case 3:
                break;
            case 4:
                break;

        }
    }

}