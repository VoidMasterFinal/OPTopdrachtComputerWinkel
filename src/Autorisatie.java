import java.util.Scanner;

public class Autorisatie {

    public Medewerker startAutorisatie(MedewerkersPool medewerkersPool) {
        Scanner scanner = new Scanner(System.in);
        int gegevenAntwoordCode = -1;
        String gegevenAntwoordPassword;
        for (int x = 1; x <= 3; x++) {
            // Get werknemer by code
            System.out.print("Poging " + x + "/3,\nGeef uw medewerkercode: ");
            gegevenAntwoordCode = scanner.nextInt();
            Medewerker medewerker = medewerkersPool.getWerknemerByCode(gegevenAntwoordCode);
            if (medewerker == null) {
                System.out.println("Gebruikerscode is niet correct");
                continue;
            }
            // Get password
            System.out.print("Geef uw password: ");
            scanner.nextLine();
            gegevenAntwoordPassword = scanner.nextLine();
            if (!medewerker.authenticate(gegevenAntwoordPassword)) {
                System.out.println("Wachtwoord is niet correct");
                continue;
            }
            // Succesvol ingelogd
            System.out.println("\nWelkom " + medewerker.getVoornaam() + " " + medewerker.getAchternaam() + "!\n");
            return medewerker;
        }
        System.out.println("Inloggen gefaald, alle pogingen verbruikt");
        return null;
    }
}
