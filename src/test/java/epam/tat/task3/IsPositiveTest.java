package epam.tat.task3;

import exception.InvalidDataException;
import util.Converter;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class IsPositiveTest extends BaseCalculationTest {

    @DataProvider(name = "dataProviderPositive")
    public Object[][] dataProviderPositive() {
        return new Object[][]{
                {0, false},
                {15, true},
                {5200, true},
                {"-17", "false"},
        };
    }

    @Test(dataProvider = "dataProviderPositive", groups = "Arithmetic")
    public void testIsPositive(Object aObj, Object expObj) {
        try {
            long a = Converter.toLong(aObj);
            boolean expected = Boolean.valueOf(expObj.toString());
            boolean actualAngle = calculator.isPositive(a);
            Assert.assertEquals(actualAngle, expected);
        } catch (InvalidDataException e) {
            Assert.fail(e.getMessage());
        }
    }

}
