package pro.sky.calculator;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.calculator.service.CalculatorService;

@RestController
@RequestMapping("/calculator")
public class CalculatorController {

    private final CalculatorService calculatorService;

    public CalculatorController(CalculatorService calculatorService) {
        this.calculatorService = calculatorService;
    }

    @GetMapping
    public String helloInCalculator() {
        return "Добро пожаловать в калькулятор";
    }

    @GetMapping("/plus")
    public String addition(
            @RequestParam Integer num1,
            @RequestParam Integer num2

    ) {
        if (num1 == null || num2 == null) {
            return " пустое значение , выражжение не верно";

        }
        return num1 + " + "+ num2 + " = " + calculatorService.plus(num1,num2).toString();
    }
    @GetMapping("/minus")
    public String minus(
            @RequestParam Integer num1,
            @RequestParam Integer num2

    ) {
        if (num1 == null || num2 == null) {
            return " пустое значение , выражжение не верно";

        }

        return num1 + " - "+ num2 + " = " + calculatorService.minus(num1,num2).toString();
    }
    @GetMapping("/multiply")
    public String multiply(
            @RequestParam Integer num1,
            @RequestParam Integer num2

    ) {
        if (num1 == null || num2 == null) {
            return " пустое значение , выражжение не верно";

        }
        return num1 + " * "+ num2 + " = " +calculatorService.multiply(num1,num2).toString();
    }
    @GetMapping("/divide")
    public String divide(
            @RequestParam Integer num1,
            @RequestParam Integer num2

    ) {
        if (num2.equals(0)) {
            return " Деление на 0, передайте другое значение ";
        }
        return num1 + " / "+ num2 + " = " + calculatorService.divide(num1,num2).toString();
    }
}