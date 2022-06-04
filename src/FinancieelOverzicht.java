import java.util.ArrayList;

public class FinancieelOverzicht extends Overzicht {
    private static ArrayList<FinancieelOverzicht> financieleGegevens = new ArrayList<>();
    private int currentWeek;
    private double verdiend;
    private double uitgegeven;

    public FinancieelOverzicht(int currentWeek, double verdiend, double uitgegeven) {
        this.currentWeek = currentWeek;
        this.verdiend = verdiend;
        this.uitgegeven = uitgegeven;
    }

    public ArrayList<FinancieelOverzicht> getFinancieleGegevens() {return financieleGegevens;}

    public static void ophalenGegevens(int week, double verdiend, double uitgaven) {
        financieleGegevens.add(new FinancieelOverzicht(week, verdiend, uitgaven));
        System.out.println("Gegevens succesvol toegevoegd");
    }

    public static void printOverzicht(int currentWeek, int aantalWekenTerug) {
        int thisweek;
        for (int i = 0; i <= aantalWekenTerug; i++) {
            thisweek = currentWeek - aantalWekenTerug + i;
            System.out.println("\nWeek " + thisweek + ": ");
            try {
                for (int x = 0; x < financieleGegevens.size(); x++) {
                    if (financieleGegevens.get(x).currentWeek == thisweek) {
                        System.out.println("Verdiend: " + financieleGegevens.get(x).verdiend + " euro\nUitgegeven: " + financieleGegevens.get(x).uitgegeven + " euro\nWinst: " + (financieleGegevens.get(x).verdiend - financieleGegevens.get(x).uitgegeven) + " euro");
                        try {
                            System.out.println("Winstverschil t.o.v. vorige week: " + ((financieleGegevens.get(x).verdiend - financieleGegevens.get(x).uitgegeven) - (financieleGegevens.get(x - 1).verdiend - financieleGegevens.get(x - 1).uitgegeven)) + " euro");
                        }
                        catch (Exception e) {}
                    }
                }
            }
            catch (Exception e) {
                System.out.println("Er zijn van week " + thisweek + " geen gegevens bekend.");
            }
            System.out.println();
        }
    }
}