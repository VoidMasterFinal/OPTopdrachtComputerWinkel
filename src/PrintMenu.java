import java.util.Scanner;

public class PrintMenu {
    public void printMenu1() {
            System.out.println("""
                    Keuzemenu
                    1) Bekijk producten
                    2) Voeg producten toe
                    3) Verwijder producten
                    4) Overzich opstellen""");
    }

    public void printMenu2() {
            System.out.println("""
                    5) Financiele gegevens toevoegen
                    6) Genereer een financieel overzicht
                    7) Opvragen gegevens personeel
                    8) Voeg personeel toe
                    9) Verwijder personeel""");
    }
}

class MenuManager {
    private PrintMenu printMenu = new PrintMenu();

    private void pressEnterForMenu(Scanner scanner) {
        scanner.nextLine();
        System.out.println("Druk enter als u terug wilt naar het menu.");
        scanner.nextLine();
    }

    private void menuKeuzeGetProduct(Scanner scanner, ProductManager productManager) {
        System.out.println("Geef de productcode van het product dat u wilt bekijken");
        int gegevenProductcode = scanner.nextInt();
        BaseProduct testProduct = productManager.getProductByCode(gegevenProductcode);
        if (testProduct != null) {
            testProduct.print();
        }
        else {
            System.out.println("Dat product staat niet in het systeem");
        }
        pressEnterForMenu(scanner);
    }

    private void menuKeuzeAddProduct(Scanner scanner, ProductManager productManager) {
        BaseProduct newProduct = productManager.informationToAddProduct();
        System.out.println("Product succesvol toegevoegd.\nDe productcode is: " + newProduct.getCode());
        pressEnterForMenu(scanner);
    }

    private void menuKeuzeRemoveProduct(Scanner scanner, ProductManager productManager) {
        System.out.println("Geef de productcode van het product dat u wilt verwijderen");
        int gegevenProductcode = scanner.nextInt();
        BaseProduct testProduct = productManager.getProductByCode(gegevenProductcode);
        if (testProduct != null) {
            if (productManager.removeProduct(testProduct)) {
                System.out.println("Product successvol verwijderd!");
            }
            else {
                System.out.println("Product niet verwijderd, product niet gevonden tijdens het verwijderen");
            }
        }
        else {
            System.out.println("Dat product staat niet in het systeem");
        }
    }

    private void menuKeuzeOpstellenInformatieOverzicht(Scanner scanner, ProductManager productManager, InformatieOverzicht informatieOverzicht) {
        informatieOverzicht.setupGegevens();
        pressEnterForMenu(scanner);
    }

    private void menuKeuzeFinancieleGegevensToevoegen(Scanner scanner, ProductManager productManager, FinancieelOverzichtManager financieelOverzichtManager) {
        financieelOverzichtManager.ophalenGegevens();
        pressEnterForMenu(scanner);
    }

    private void menuKeuzeOpstellenFinancieelOverzicht(Scanner scanner, ProductManager productManager, FinancieelOverzichtManager financieelOverzichtManager) {
        financieelOverzichtManager.opstellenFinancieelOverzicht();
        pressEnterForMenu(scanner);
    }

    private void menuKeuzeGetWerknemers(Scanner scanner, ProductManager productManager, MedewerkersPool medewerkersPool) {
        medewerkersPool.printWithWerknemersCode();
        pressEnterForMenu(scanner);
    }

    private void menuKeuzeAddMedewerker(Scanner scanner, ProductManager productManager, MedewerkersPool medewerkersPool) {
        medewerkersPool.getInformatieToAddMedewerker();
        pressEnterForMenu(scanner);
    }

    private void menuKeuzeRemoveMedewerker(Scanner scanner, ProductManager productManager, MedewerkersPool medewerkersPool) {
        medewerkersPool.getInformatieToRemoveMedewerker();
        pressEnterForMenu(scanner);
    }

    public void startMenu(Medewerker medewerker, MedewerkersPool medewerkersPool, ProductManager productManager, FinancieelOverzichtManager financieelOverzichtManager) {
        InformatieOverzicht informatieOverzicht = new InformatieOverzicht();
        Scanner scanner = new Scanner(System.in);
        boolean actief = true;
        while (actief) {
            printMenu.printMenu1();
            if (medewerker.getBedrijfsrol().equals("Eigenaar") || medewerker.getBedrijfsrol().equals("Administratief Medewerker")) {
                printMenu.printMenu2();
                System.out.println("0) Exit\nMaak een keuze: ");
                int keuze = scanner.nextInt();
                switch (keuze) {
                    case 1 -> {
                        menuKeuzeGetProduct(scanner, productManager);
                    }
                    case 2 -> {
                        menuKeuzeAddProduct(scanner, productManager);
                    }
                    case 3 -> {
                        menuKeuzeRemoveProduct(scanner, productManager);
                    }
                    case 4 -> {
                        menuKeuzeOpstellenInformatieOverzicht(scanner, productManager, informatieOverzicht);
                    }
                    case 5 -> {
                        menuKeuzeFinancieleGegevensToevoegen(scanner, productManager, financieelOverzichtManager);
                    }
                    case 6 -> {
                        menuKeuzeOpstellenFinancieelOverzicht(scanner, productManager, financieelOverzichtManager);
                    }
                    case 7 -> {
                        menuKeuzeGetWerknemers(scanner, productManager, medewerkersPool);
                    }
                    case 8 -> {
                        menuKeuzeAddMedewerker(scanner, productManager, medewerkersPool);
                    }
                    case 9 -> {
                        menuKeuzeRemoveMedewerker(scanner, productManager, medewerkersPool);
                    }
                    case 0 -> {actief = false;}
                    default -> {System.out.println("Ongeldige keuze");}
                }
            }

            if (medewerker.getBedrijfsrol().equals("Werknemer")) {
                System.out.println("0) Exit\nMaak een keuze: ");
                int keuze = scanner.nextInt();
                switch (keuze) {
                    case 1 -> {
                        menuKeuzeGetProduct(scanner, productManager);
                    }
                    case 2 -> {
                        menuKeuzeAddProduct(scanner, productManager);
                    }
                    case 3 -> {
                        menuKeuzeRemoveProduct(scanner, productManager);
                    }
                    case 4 -> {
                        menuKeuzeOpstellenInformatieOverzicht(scanner, productManager, informatieOverzicht);
                    }
                    case 0 -> {
                        actief = false;
                    }
                    default -> {
                        System.out.println("Ongeldige keuze");
                    }
                }
            }
        }
    }
}
