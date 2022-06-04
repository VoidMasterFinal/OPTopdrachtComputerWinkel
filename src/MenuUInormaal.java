import java.util.Scanner;

public class MenuUInormaal {
    public void maakKeuze() {
        Scanner scanner = new Scanner(System.in);
        boolean actief = true;
        while (actief) {
            System.out.println("""
                    Keuzemenu
                    1) Bekijk producten
                    2) Voeg producten toe
                    3) Verwijder producten
                    0) Exit
                    Maak een keuze: """);
            int keuze = scanner.nextInt();
            switch (keuze) {
                case 1 -> productUitvoering.product(1);
                case 2 -> productUitvoering.product(2);
                case 3 -> productUitvoering.product(3);
                case 0 -> actief = false;
                default -> System.out.println("Ongeldige keuze");
            }
        }
    }
}