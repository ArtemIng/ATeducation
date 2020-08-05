import org.testng.Assert;
import org.testng.annotations.Test;

public class UnitTests {

    @Test()
    public void unitTestCalc(){
        Calc myCalc = new Calc();
        Assert.assertEquals(3+5,myCalc.sum(3,5),"Ошибка операции сложения");
    }
}
