import java.util.Scanner;

public class MenuUIextra {
    public void maakKeuze(MedewerkersPool medewerkersPool, ProductManager productManager, FinancieelOverzichtManager financieelOverzichtManager) {
        InformatieOverzicht informatieOverzicht = new InformatieOverzicht();
        Scanner scanner = new Scanner(System.in);
        boolean actief = true;
        while (actief) {
            System.out.println("""
                    Keuzemenu
                    1) Bekijk producten
                    2) Voeg producten toe
                    3) Verwijder producten
                    4) Overzich opstellen
                    5) Financiele gegevens toevoegen
                    6) Genereer een financieel overzicht
                    7) Opvragen gegevens personeel
                    8) Voeg personeel toe
                    9) Verwijder personeel
                    0) Exit
                    Maak een keuze: """);
            int keuze = scanner.nextInt();
            switch (keuze) {

                case 1 -> {
                    System.out.println("Geef de productcode van het product dat u wilt bekijken");
                    int gegevenProductcode = scanner.nextInt();
                    Product testProduct = productManager.getProductByCode(gegevenProductcode);
                    if (testProduct != null) {
                        testProduct.print();
                    }
                    else {
                        System.out.println("Dat product staat niet in het systeem");
                    }
                    scanner.nextLine();
                    System.out.println("Druk enter als u terug wilt naar het menu.");
                    scanner.nextLine();
                }

                case 2 -> {
                    productManager.informationToAddProduct();
                    scanner.nextLine();
                    System.out.println("Druk enter als u terug wilt naar het menu.");
                    scanner.nextLine();
                }

                case 3 -> {
                    System.out.println("Geef de productcode van het product dat u wilt verwijderen");
                    int gegevenProductcode = scanner.nextInt();
                    Product testProduct = productManager.getProductByCode(gegevenProductcode);
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
                    scanner.nextLine();
                    System.out.println("Druk enter als u terug wilt naar het menu.");
                    scanner.nextLine();
                }

                case 4 -> {
                    informatieOverzicht.ophalenGegevens();
                    scanner.nextLine();
                    System.out.println("\nDruk enter als u terug wilt naar het menu.\n");
                    scanner.nextLine();
                }

                case 5 -> {
                    financieelOverzichtManager.ophalenGegevens();
                    scanner.nextLine();
                    System.out.println("Druk enter als u terug wilt naar het menu.");
                    scanner.nextLine();
                }

                case 6 -> {
                    financieelOverzichtManager.opstellenFinancieelOverzicht();
                    scanner.nextLine();
                    System.out.println("Druk enter als u terug wilt naar het menu.");
                    scanner.nextLine();
                }

                case 7 -> {
                    medewerkersPool.printWithWerknemersCode();
                    scanner.nextLine();
                    System.out.println("Druk enter als u terug wilt naar het menu.");
                    scanner.nextLine();
                }

                case 8 -> {
                    medewerkersPool.getInformatieToAddMedewerker();
                    scanner.nextLine();
                    System.out.println("Druk enter als u terug wilt naar het menu.");
                    scanner.nextLine();
                }

                case 9 -> {
                    medewerkersPool.getInformatieToRemoveMedewerker();
                    scanner.nextLine();
                    System.out.println("Druk enter als u terug wilt naar het menu.");
                    scanner.nextLine();
                }

                case 0 -> {
                    actief = false;
                }

                default -> System.out.println("Ongeldige keuze");
            }
        }
    }
}