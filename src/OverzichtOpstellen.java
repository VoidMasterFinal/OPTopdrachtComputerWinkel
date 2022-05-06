import java.util.ArrayList;
import java.util.Scanner;

public class OverzichtOpstellen {

    interface Overzicht {

        public static void ophalenGegevens() {}

        public static void printOverzicht() {}
    }

    public class InformatieOverzicht implements Overzicht {
        private ArrayList<InformatieOverzicht> gegevensVoorOverzicht = new ArrayList<>();
    }

    public class FinancieelOverzicht implements Overzicht {
        private ArrayList<FinancieelOverzicht> financieleGegevens = new ArrayList<>();
        private int currentWeek;
        //private int aantalWekenTerug;
        private double winst;
        private double verdiend;
        private double uitgegeven;

        public FinancieelOverzicht(int currentWeek, double verdiend, double uitgegeven) {
            this.currentWeek = currentWeek;
            this.verdiend = verdiend;
            this.uitgegeven = uitgegeven;
        }

        public void ophalenGegevens(int week, double verdiend, double uitgaven) {
            financieleGegevens.add(new FinancieelOverzicht(week, verdiend, uitgaven));
            System.out.println("Gegevens succesvol toegevoegd");
        }

        public void printOverzicht(int currentWeek, int aantalWekenTerug) {
            int thisweek;
            for (int i = 0; i < aantalWekenTerug; i++) {
                thisweek = currentWeek - aantalWekenTerug + i;
                System.out.println("Week " + thisweek + ": ");
                try {
                    System.out.println("Verdiend: " + financieleGegevens.get(financieleGegevens.indexOf(thisweek).verdiend) + "Uitgegeven" + "Winst");
                }
                catch (Exception e) {
                    System.out.println("Er zijn van week " + thisweek + " geen gegevens bekend.");
                }
            }
        }
    }
}




/*

    public Overzicht(boolean zelfOpstellen, String gegevensInvoeren) {
        this.zelfOpstellen = zelfOpstellen;
        this.gegevensInvoeren = gegevensInvoeren;
    }

    public void printSchema() {
        for (int i = 0; i < overzichtOpstellen.size(); i++) {
            System.out.println(overzichtOpstellen.get(i));
        }
    }
}

*/