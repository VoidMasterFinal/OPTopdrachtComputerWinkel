import java.util.ArrayList;
import java.util.Scanner;

import static java.lang.System.exit;

class Main {

    public static void main(String[] args) {
        MedewerkersPool medewerkersPool = new MedewerkersPool();
        ProductManager productManager = new ProductManager();
        productManager.bootstrap();
        FinancieelOverzichtManager financieelOverzichtManager = new FinancieelOverzichtManager();
        Autorisatie autorisatie = new Autorisatie();

        medewerkersPool.addMedewerker("Jan", "Kabel", "123", "Eigenaar");
        medewerkersPool.addMedewerker("Karel", "van der Plank", "321", "Werknemer");
        medewerkersPool.addMedewerker("Piet", "Stoel", "101", "Administratief Medewerker");

        //Een eigenaar heeft alle 9 functies, terwijl een Werknemer maar de eerste 4 heeft

        financieelOverzichtManager.toevoegenFinancieleGegevens(1, 1000, 600);
        financieelOverzichtManager.toevoegenFinancieleGegevens(2, 1200, 800);
        financieelOverzichtManager.toevoegenFinancieleGegevens(3, 1600, 850);
        financieelOverzichtManager.toevoegenFinancieleGegevens(4, 2200, 2000);

        System.out.println("\nWelkom bij het systeem!\nGelieve hieronder in te loggen.");
        Medewerker medewerker = autorisatie.startAutorisatie(medewerkersPool);
        if (medewerker == null) {
            System.out.println("Inloggen 3 keer mislukt. Toegang geweigerd.");
            exit(1);
        } else {
            MenuManager menuManager = new MenuManager();
            menuManager.startMenu(medewerker, medewerkersPool, productManager, financieelOverzichtManager);
        }
    }
}
