package epam.tat.task3;

import epam.tat.task3.exception.InvalidDataException;
import epam.tat.task3.util.Converter;
import org.junit.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class MultiplyLongTest extends BaseCalculationTest {

    @DataProvider(name = "dataProviderForLongMultiply")
    public Object[][] dataProviderForLongMultiply() {
        return new Object[][]{
                {1, 1, 1},
                {1, 0, 0},
                {-1, 1, -1},
                {"12", "2", "24"}
        };
    }

    @Test(dataProvider = "dataProviderForLongMultiply", groups = "Arithmetic")
    public void testMultiplyLong(Object aObj, Object bObj, Object expObj) {
        try {
            long a = Converter.toLong(aObj);
            long b = Converter.toLong(bObj);
            long expected = Converter.toLong(expObj);
            long actual = calculator.mult(a, b);
            Assert.assertEquals(actual, expected);
        } catch (InvalidDataException e) {
            org.testng.Assert.fail(e.getMessage());
        }
    }

}
