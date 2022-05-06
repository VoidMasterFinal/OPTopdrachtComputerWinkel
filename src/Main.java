import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Product.addProduct("Intel5D","Intel",239,500,600,5);
        Product.addProduct("DELLG2","DELL",240,580,680,3);

        Autorisatie.addMedewerker("Jan", "Kabel", "123", "Eigenaar");
        Autorisatie.addMedewerker("Karel", "van der Plank", "321", "Werknemer");

        OverzichtOpstellen.FinancieelOverzicht.ophalenGegevens(1,1000,600);
        OverzichtOpstellen.FinancieelOverzicht.ophalenGegevens(2,1200,800);
        OverzichtOpstellen.FinancieelOverzicht.ophalenGegevens(3,1600,850);
        OverzichtOpstellen.FinancieelOverzicht.ophalenGegevens(4,2200,1200);
/*
        //Autorisatie Stuff

        System.out.println("Welkom bij het systeem!\nGelieve hieronder in te loggen.");
        //TODO: Fixen class "Autorisatie" en "AutorisatieLijst" (size() is 0)
        //TODO: remove jan
        if (jan.startAutorisatie() == true) {
            //TODO: test for bedrijfsrol
        if (Autorisatie.startAutorisatie() == true) {
            if (persoon.bedrijfsrol.equals("Eigenaar")) {
                MenuInterfaceB menuInterface = new MenuInterfaceB();
            }
            else {
                MenuInterfaceW mainInterface = new MenuInterfaceW();
            }
            mainInterface.maakKeuze();
        }
*/
            MenuInterface mainInterface = new MenuInterface();
            mainInterface.maakKeuze();
        }
    //}

        //Programma functionaliteit

    public static void addProduct() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Geef de naam van het product dat u wilt toevoegen:");
        String productNaamSelected = scanner.nextLine();
        System.out.println("Geef het merk van het product dat u wilt toevoegen:");
        String productMerkSelected = scanner.nextLine();
        System.out.println("Geef de productcode van het product dat u wilt toevoegen:");
        int productCodeSelected = scanner.nextInt();
        System.out.println("Geef de inkoopprijs van het product dat u wilt toevoegen:");
        Double inkoopPrijsSelected = scanner.nextDouble();
        System.out.println("Geef de verkoopprijs van het product dat u wilt toevoegen:");
        Double verkoopPrijsSelected = scanner.nextDouble();
        System.out.println("Geef de voorraad van het product dat u wilt toevoegen:");
        int voorraadProduct = scanner.nextInt();
        Product.addProduct(productNaamSelected,productMerkSelected,productCodeSelected,inkoopPrijsSelected,verkoopPrijsSelected,voorraadProduct);
        scanner.nextLine();
        System.out.println("Druk enter als u terug wilt naar het menu.");
        scanner.nextLine();
    }

    public static void removeProduct() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Geef de productcode van het product dat u wilt verwijderen:");
        int productCodeSelected = scanner.nextInt();
        Product.removeProduct(productCodeSelected);
        scanner.nextLine();
        System.out.println("Druk enter als u terug wilt naar het menu.");
        scanner.nextLine();
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
        scanner.nextLine();
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
        OverzichtOpstellen.FinancieelOverzicht.printOverzicht(week, aantalWeken);
    }

    public static void addFinanciëleGegevens() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Geef de week: ");
        int week = scanner.nextInt();
        System.out.print("Geef het verdiende bedrag: ");
        double verdiend = scanner.nextDouble();
        System.out.print("Geef het uitgegeven bedrag: ");
        double uitgegeven = scanner.nextDouble();
        OverzichtOpstellen.FinancieelOverzicht.ophalenGegevens(week, verdiend, uitgegeven);
    }

}

/*
    public int maakKeuze() {
        boolean geldigeKeuze;
        Scanner scanner = new Scanner(System.in);
        String keuze = scanner.next();
        while (!(keuze.equals("1")^keuze.equals("2")^keuze.equals("3")^keuze.equals("4"))) {
            System.out.println("Kies een geldige optie");
            keuze = scanner.next();
        }
        if (keuze.equals("1")) {
            System.out.println("U koos 1");
            ProductList.printProducten();
            return 1;
        }
        if (keuze.equals("2")) {
            System.out.println("U koos 2");
            return 2;
        }
        if (keuze.equals("3")) {
            System.out.println("U koos 3");
            return 3;
        }
        if (keuze.equals("4")) {
            System.out.println("U koos 4");
            return 4;
        }
        return 0;
    }
}
*/