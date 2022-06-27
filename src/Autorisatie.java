import java.util.Scanner;

class PrintAutorisatie {

    public void printPoging(int currentPoging, int maxPogingen) {
        System.out.println("Poging " + currentPoging + "/" + maxPogingen + ",");
    }

    public void infoVragen(String infoType) {
        System.out.print("Geef uw " + infoType + ": ");
    }

    public void foutmeldingInloggen(String errorType, boolean isFatal) {
        if (isFatal == true) {
            System.out.println("Inloggen gefaald, alle pogingen verbruikt");
        } else {
            System.out.println("" + errorType + " is niet correct");
        }
    }

    public void welkomsBericht(String voornaam, String achternaam) {
        System.out.println("\nWelkom " + voornaam + " " + achternaam + "!\n");
    }
}

public class Autorisatie {
    PrintAutorisatie printAutorisatie = new PrintAutorisatie();

    public Medewerker startAutorisatie(MedewerkersPool medewerkersPool) {
        Scanner scanner = new Scanner(System.in);
        int gegevenAntwoordCode = -1;
        String gegevenAntwoordPassword;
        int maxPogingen = 3;
        for (int x = 1; x <= maxPogingen; x++) {
            // Get werknemer by code
            printAutorisatie.printPoging(x, maxPogingen);
            printAutorisatie.infoVragen("medewerkercode");
            gegevenAntwoordCode = scanner.nextInt();
            Medewerker medewerker = medewerkersPool.getWerknemerByCode(gegevenAntwoordCode);
            if (medewerker == null) {
                printAutorisatie.foutmeldingInloggen("Gebruikerscode",false);
                continue;
            }
            // Get password
            printAutorisatie.infoVragen("password");
            scanner.nextLine();
            gegevenAntwoordPassword = scanner.nextLine();
            if (!medewerker.authenticate(gegevenAntwoordPassword)) {
                printAutorisatie.foutmeldingInloggen("Wachtwoord",false);
                continue;
            }
            // Succesvol ingelogd
            printAutorisatie.welkomsBericht(medewerker.getVoornaam(),medewerker.getAchternaam());
            return medewerker;
        }
        printAutorisatie.foutmeldingInloggen("",true);
        return null;
    }
}
