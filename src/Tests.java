import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class Tests {

    //Formulier kandidaat!
    //@Test
    //public void testPrintOverzicht() {
    //    OverzichtOpstellen.
    //}

    //@Test
    //public void testOphalenGegevensFinancien() {
    //   ArrayList<OverzichtOpstellen.FinancieelOverzicht> financieelOverzichts = OverzichtOpstellen.FinancieelOverzicht.getFinancieleGegevens();
    //   ArrayList<OverzichtOpstellen.FinancieelOverzicht> expectedResult = new ArrayList<>();
    //    expectedResult.add(5,3000,2850);
    //    OverzichtOpstellen.FinancieelOverzicht.ophalenGegevens(5,3000,2850);
    //    Assert.assertEquals((5, 3000, 2850), financieelOverzichts.get(financieelOverzichts.indexOf(5)));
    //}

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
        Assert.assertEquals(Autorisatie.inloggen(false, true),false);
        Assert.assertEquals(Autorisatie.inloggen(true, false),false);
        Assert.assertEquals(Autorisatie.inloggen(false, true),false);
        Assert.assertEquals(Autorisatie.inloggen(true, true),true);
    }

}
