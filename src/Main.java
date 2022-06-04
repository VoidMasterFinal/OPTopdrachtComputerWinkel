import java.util.Scanner;

import static java.lang.System.exit;

public class Main {
    public static void main(String[] args) {
        Product.addProduct("Intel5D","Intel",500,600,5);
        Product.addProduct("DELLG2","DELL",580,680,3);

        Autorisatie.addMedewerker("Jan", "Kabel", "123", "Eigenaar");
        Autorisatie.addMedewerker("Karel", "van der Plank", "321", "Werknemer");

        FinancieelOverzicht.ophalenGegevens(1,1000,600);
        FinancieelOverzicht.ophalenGegevens(2,1200,800);
        FinancieelOverzicht.ophalenGegevens(3,1600,850);
        FinancieelOverzicht.ophalenGegevens(4,2200,2000);

        System.out.println("\nWelkom bij het systeem!\nGelieve hieronder in te loggen.");
        if (Autorisatie.startAutorisatie() == false) {
            System.out.println("Inloggen 3 keer mislukt. Toegang geweigerd.");
            exit(420);
        }
    }

    public static void addMedewerker() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Geef de voornaam van de medewerker die u wilt toevoegen:");
        String voornaam = scanner.nextLine();
        System.out.println("Geef de achternaam van de medewerker die u wilt toevoegen:");
        String achternaam = scanner.nextLine();
        System.out.println("Geef het password van de medewerker die u wilt toevoegen:");
        String password = scanner.nextLine();
        System.out.println("Geef de bedrijfsrol van de medewerker die u wilt toevoegen:");
        String bedrijfsrol = scanner.nextLine();
        Autorisatie.addMedewerker(voornaam, achternaam, password, bedrijfsrol);
        System.out.println("Druk enter als u terug wilt naar het menu.");
        scanner.nextLine();
    }

    public static void removeMedewerker() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Geef de medewerkercode van de medewerker die u wilt verwijderen:");
        int medewerkercodeSelected = scanner.nextInt();
        Autorisatie.removeMedewerker(medewerkercodeSelected);
        scanner.nextLine();
        System.out.println("Druk enter als u terug wilt naar het menu.");
        scanner.nextLine();
    }

    public static void opstellenFinancieelOverzicht() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Van welke week, en hoeveel weken daar van terug wilt u de financiële informatie bekijken?");
        System.out.print("Geef de week: ");
        int week = scanner.nextInt();
        System.out.print("Geef het aantal weken dat u ervoor wilt zien: ");
        int aantalWeken = scanner.nextInt();
        FinancieelOverzicht.printOverzicht(week, aantalWeken);
        scanner.nextLine();
        System.out.println("Druk enter als u terug wilt naar het menu.");
        scanner.nextLine();
    }

    public static void addFinanciëleGegevens() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Geef de week: ");
        int week = scanner.nextInt();
        System.out.print("Geef het verdiende bedrag: ");
        double verdiend = scanner.nextDouble();
        System.out.print("Geef het uitgegeven bedrag: ");
        double uitgegeven = scanner.nextDouble();
        FinancieelOverzicht.ophalenGegevens(week, verdiend, uitgegeven);
        scanner.nextLine();
        System.out.println("Druk enter als u terug wilt naar het menu.");
        scanner.nextLine();
    }
}