import java.util.ArrayList;
import java.util.Scanner;

import static java.lang.System.exit;

class Main {

    public static void main(String[] args) {
        MedewerkersPool medewerkersPool = new MedewerkersPool();
        medewerkersPool.bootstrap();
        ProductManager productManager = new ProductManager();
        productManager.bootstrap();
        FinancieelOverzichtManager financieelOverzichtManager = new FinancieelOverzichtManager();
        financieelOverzichtManager.bootstrap();

        Autorisatie autorisatie = new Autorisatie();

        //Een eigenaar heeft alle 9 functies, terwijl een Werknemer maar de eerste 4 heeft

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
