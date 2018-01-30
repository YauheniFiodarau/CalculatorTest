package epam.tat.task3;

import com.epam.tat.module4.Calculator;
import org.testng.annotations.BeforeClass;

public class BaseCalculationTest {
    Calculator calculator;

    @BeforeClass
    public void initCalculator() {
        calculator = new Calculator();
    }
}
