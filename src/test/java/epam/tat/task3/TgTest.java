package epam.tat.task3;

import exception.InvalidDataException;
import util.Converter;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TgTest extends BaseCalculationTest {

    @DataProvider(name = "dataProviderForTg")
    public Object[][] dataProviderForTg() {
        return new Object[][]{
                {"0.0", "0.0"},
                {Math.PI / 4, 1.0},
                {Math.PI, 0.0}
        };
    }

    @Test(dataProvider = "dataProviderForTg", groups = "Trigonometry")
    public void testTg(Object aObj, Object expObj) {
        try {
            double a = Converter.toDouble(aObj);
            double expected = Converter.toDouble(expObj);
            double actual = calculator.tg(a);
            double delta = 0.0;
            Assert.assertEquals(actual, expected, delta);
        } catch (InvalidDataException e) {
            Assert.fail(e.getMessage());
        }
    }

    @Test
    public void testForTgInfinity() {
        Assert.assertTrue(Double.isInfinite(calculator.tg(Math.PI / 2)));
    }
}
