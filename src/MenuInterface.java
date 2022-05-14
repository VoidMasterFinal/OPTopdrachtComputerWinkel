import java.util.Scanner;

public class MenuInterface {
    public void maakKeuze() {
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
                    System.out.print("Geef de productcode van het product: ");
                    int OpzoekenProduct = scanner.nextInt();
                    Product.getProduct(OpzoekenProduct);
                    scanner.nextLine();
                    System.out.println("Druk enter als u terug wilt naar het menu.");
                    scanner.nextLine();
                }
                case 2 -> Main.addProduct();
                case 3 -> Main.removeProduct();
                case 4 -> OverzichtOpstellen.InformatieOverzicht.ophalenGegevens();
                case 5 -> Main.addFinanciëleGegevens();
                case 6 -> Main.opstellenFinancieelOverzicht();
                case 7 -> {
                    System.out.print("Geef de werknemercode: ");
                    int OpzoekenWerknemer = scanner.nextInt();
                    Autorisatie.getWerknemer(OpzoekenWerknemer);
                    scanner.nextLine();
                    System.out.println("Druk enter als u terug wilt naar het menu.");
                    scanner.nextLine();
                }
                case 8 -> Main.addMedewerker();
                case 9 -> Main.removeMedewerker();
                case 0 -> actief = false;
                default -> System.out.println("Ongeldige keuze");
            }
        }
    }
}