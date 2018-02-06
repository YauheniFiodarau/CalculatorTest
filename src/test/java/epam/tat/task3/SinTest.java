package epam.tat.task3;

import exception.InvalidDataException;
import util.Converter;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class SinTest extends BaseCalculationTest {

    @DataProvider(name = "dataProviderForSin")
    public Object[][] dataProviderForSin() {
        return new Object[][]{
                {0.0, 0.0},
                {Math.PI / 2.0, 1.0},
                {"0", "0"}
        };
    }

    @Test(dataProvider = "dataProviderForSin", groups = "Trigonometry")
    public void testSin(Object aObj, Object expObj) {
        try {
            double a = Converter.toDouble(aObj);
            double expected = Converter.toDouble(expObj);
            double actual = calculator.sin(a);
            double delta = 0.0;
            Assert.assertEquals(actual, expected, delta);
        } catch (InvalidDataException e) {
            Assert.fail(e.getMessage());
        }
    }
}
