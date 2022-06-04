import java.util.Scanner;

public class MenuUI {
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
                case 1 -> productUitvoering.product(1);
                case 2 -> productUitvoering.product(2);
                case 3 -> productUitvoering.product(3);
                case 4 -> InformatieOverzicht.ophalenGegevens();
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