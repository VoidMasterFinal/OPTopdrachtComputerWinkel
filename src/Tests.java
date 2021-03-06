import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class Tests {

    @Test
    public void testFinancieleGegevens() {
        FinancieelOverzichtManager testFinancieelOverzichtManager = new FinancieelOverzichtManager();
        testFinancieelOverzichtManager.toevoegenFinancieleGegevens(1,1000,800);
        Assert.assertEquals(testFinancieelOverzichtManager.getWinstByWeek(0), 200);
        testFinancieelOverzichtManager.toevoegenFinancieleGegevens(2,1500,900);
        Assert.assertEquals(testFinancieelOverzichtManager.getWinstByWeek(1), 600);
    }
}


/*    //                ---OUDE TESTEN---

    @Test
    public void testOphalenGegevensFinancien() {
       ArrayList<OverzichtOpstellen.FinancieelOverzicht> financieelOverzichts = OverzichtOpstellen.FinancieelOverzicht.getFinancieleGegevens();
       ArrayList<OverzichtOpstellen.FinancieelOverzicht> expectedResult = new ArrayList<>();
        expectedResult.add(5,3000,2850);
        OverzichtOpstellen.FinancieelOverzicht.ophalenGegevens(5,3000,2850);
        Assert.assertEquals((5, 3000, 2850), financieelOverzichts.get(financieelOverzichts.indexOf(5)));
    }

    @Test
    public void testGetProduct() {
        //ArrayList expectedResult = new ArrayList();
        //expectedResult + ;
        //Assert.assertEquals(expectedResult(0),Product.getProduct(1));
    }

    //@Test
    //public void testGetWerknemer() {
        //Autorisatie.getWerknemer()
    //}

    @Test
    public void testAddWerknemer() {
        //Autorisatie.getWerknemer()
    }

    @Test
    public void testRemoveWerknemer() {
        //Autorisatie.getWerknemer()
    }

    @Test
    public void testAddProduct() {
        //Autorisatie.getWerknemer()
    }

    @Test
    public void testRemoveProduct() {
        //Autorisatie.getWerknemer()
    }

    @Test
    public void testInloggen() {
        Assert.assertEquals(Medewerker.inloggen(false, true),false);
        Assert.assertEquals(Medewerker.inloggen(true, false),false);
        Assert.assertEquals(Medewerker.inloggen(false, true),false);
        Assert.assertEquals(Medewerker.inloggen(true, true),true);
    }

    @Test
    public void testBerekenPrijsLeeftijd() {
        Assert.assertEquals(Main.getPrijs(600,9), 600);
        Assert.assertEquals(Main.getPrijs(600,10), 480);
        Assert.assertEquals(Main.getPrijs(600,11), 480);
        Assert.assertEquals(Main.getPrijs(600,14), 480);
        Assert.assertEquals(Main.getPrijs(600,15), 480);
        Assert.assertEquals(Main.getPrijs(600,16), 600);
        Assert.assertEquals(Main.getPrijs(600,17), 600);
        Assert.assertEquals(Main.getPrijs(600,18), 450);
        Assert.assertEquals(Main.getPrijs(600,19), 450);
        Assert.assertEquals(Main.getPrijs(600,23), 450);
        Assert.assertEquals(Main.getPrijs(600,24), 450);
        Assert.assertEquals(Main.getPrijs(600,25), 600);
        Assert.assertEquals(Main.getPrijs(600,64), 600);
        Assert.assertEquals(Main.getPrijs(600,65), 510);
        Assert.assertEquals(Main.getPrijs(600,66), 510);
    }

    @Test
    public void testBerekenPrijsGeheel() {
        Assert.assertEquals(Main.getTotaalPrijs(1,1,false,true),510);
        Assert.assertEquals(Main.getTotaalPrijs(2,1,true,false),646);
        Assert.assertEquals(Main.getTotaalPrijs(1,1,true,false),570);
        Assert.assertEquals(Main.getTotaalPrijs(1,20,true,false),420);
        Assert.assertEquals(Main.getTotaalPrijs(2,20,false,true),408);
        Assert.assertEquals(Main.getTotaalPrijs(1,20,false,false),450);
        Assert.assertEquals(Main.getTotaalPrijs(1,70,true,true),390);
        Assert.assertEquals(Main.getTotaalPrijs(2,70,false,false),578);
        Assert.assertEquals(Main.getTotaalPrijs(1,70,false,true),420);
    }
}
*/