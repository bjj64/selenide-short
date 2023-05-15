package com.example;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import static com.codeborne.selenide.Selenide.closeWebDriver;
import utils.DataReader;
import pages.CalculatorPage;


public class CalculatorTest {
    private CalculatorPage calculatorPage;
    String firstExpressionString = DataReader.getFirstExpression();
    String secondExpressionString = DataReader.getSecondExpression();
    String thirdExpressionString = DataReader.getThirdExpression();
    String fourthExpressionString = DataReader.getFourthExpression();

    @BeforeEach
    public void setUp() {
        calculatorPage = new CalculatorPage();
        calculatorPage.open();
        calculatorPage.denyConsent();
    }

    @AfterEach
    public void tearDown() {
        closeWebDriver();
    }

    @Test
    public void testAddition() {
        calculatorPage.calculate(firstExpressionString);
        assertEquals("5", calculatorPage.getResult());
        assertEquals("2+3", calculatorPage.getHistory().trim());
    }

    @Test
    public void testSubtraction() {
        calculatorPage.calculate(secondExpressionString);
        assertEquals("8", calculatorPage.getResult());
        assertEquals("10-2", calculatorPage.getHistory().trim());
    }

    @Test
    public void testMultiplication() {
        calculatorPage.calculate(thirdExpressionString);
        assertNotEquals("20", calculatorPage.getResult());
        assertEquals("(10-2)*2", calculatorPage.getHistory().trim());
    }

    @Test
    public void testSine() {
        calculatorPage.calculate(fourthExpressionString);
        assertEquals("0.5", calculatorPage.getResult());
        assertEquals("sin(30)", calculatorPage.getHistory().trim());
    }
}
