package pages;

import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;
import com.codeborne.selenide.Selenide;
import utils.DataReader;
import com.codeborne.selenide.Condition;


public class CalculatorPage {

    String testUrl = DataReader.getUrl();

    private final SelenideElement inputField = $("#input");
    private final SelenideElement calcButtonField = $("#BtnCalc");
    private final SelenideElement historyDropDownField = $("#hist");
    private final SelenideElement historyValue = $("#histframe");
    private final SelenideElement historyFrameLastValue = $x("//*[@id=\"histframe\"]/ul/li/p[2]");
    private final SelenideElement denyConsent = $x("//button[contains(text(), 'Do not consent')]");

    public void open() {
       Selenide.open(testUrl);
    }

    public void denyConsent() {
        denyConsent.click();
     }

    public void calculate(String expression) {
        inputField.setValue(expression);
        calcButtonField.click();
    }


    public String getResult() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return inputField.getValue();
    }

    public String getHistory() {
        historyDropDownField.click();
        return historyFrameLastValue.getText();
    }
}
