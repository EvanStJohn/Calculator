package sample;

import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.util.*;

public class Controller {
    public Button one;
    public Button two;
    public Button three;
    public Button four;
    public Button five;
    public Button six;
    public Button seven;
    public Button eight;
    public Button nine;
    public Button zero;
    public Button point;
    public Button negative;
    public Button clear;
    public Button leftPar;
    public Button rightPar;
    public Button power;
    public Button divide;
    public Button multiply;
    public Button add;
    public Button equal;
    public Label output;
    boolean reset = false;
    boolean error = false;

    public void clickOne(){
        if (reset)
        {
            output.setText("");
            reset = false;
        }

        output.setText(output.getText() + "1");
    }

    public void clickTwo(){
        if (reset)
        {
            output.setText("");
            reset = false;
        }

        output.setText(output.getText() + "2");
    }

    public void clickThree(){
        if (reset)
        {
            output.setText("");
            reset = false;
        }

        output.setText(output.getText() + "3");
    }

    public void clickFour(){
        if (reset)
        {
            output.setText("");
            reset = false;
        }

        output.setText(output.getText() + "4");
    }

    public void clickFive(){
        if (reset)
        {
            output.setText("");
            reset = false;
        }

        output.setText(output.getText() + "5");
    }

    public void clickSix(){
        if (reset)
        {
            output.setText("");
            reset = false;
        }

        output.setText(output.getText() + "6");
    }

    public void clickSeven(){
        if (reset)
        {
            output.setText("");
            reset = false;
        }

        output.setText(output.getText() + "7");
    }

    public void clickEight(){
        if (reset)
        {
            output.setText("");
            reset = false;
        }

        output.setText(output.getText() + "8");
    }

    public void clickNine(){
        if (reset)
        {
            output.setText("");
            reset = false;
        }

        output.setText(output.getText() + "9");
    }

    public void clickZero(){
        if (reset)
        {
            output.setText("");
            reset = false;
        }

        output.setText(output.getText() + "0");
    }

    public void  clickClear(){
        output.setText("");
        reset = false;
        error = false;
    }

    public void clickPoint(){
        if (reset)
        {
            output.setText("");
            reset = false;
        }

        output.setText(output.getText() + ".");
    }

    public void clickNegative(){
        if (reset)
        {
            output.setText("");
            reset = false;
        }

        output.setText(output.getText() + "-");
    }

    public void clickLeftPar(){
        if (reset)
        {
            output.setText("");
            reset = false;
        }

        output.setText(output.getText() + "( ");
    }

    public void clickRightPar(){
        if (reset)
        {
            output.setText("");
            reset = false;
        }

        output.setText(output.getText() + " )");
    }

    public void clickPower(){
        if (error)
        {
            output.setText("");
            reset = false;
            error = false;
        }

        output.setText(output.getText() + " ^ ");
    }

    public void clickDivide(){
        if (error)
        {
            output.setText("");
            reset = false;
            error = false;
        }

        output.setText(output.getText() + " / ");
    }

    public void clickMultiply(){
        if (error)
        {
            output.setText("");
            reset = false;
            error = false;
        }

        output.setText(output.getText() + " * ");
    }

    public void clickSubtract(){
        if (error)
        {
            output.setText("");
            reset = false;
            error = false;
        }

        output.setText(output.getText() + " - ");
    }

    public void clickAdd(){
        if (error)
        {
            output.setText("");
            reset = false;
            error = false;
        }

        output.setText(output.getText() + " + ");
    }

    public void clickEqual(){
        try
        {
            output.setText(calculate(postfix()));
        }
        catch (InputMismatchException e)
        {
            output.setText("Invalid Expression");
            error = true;
        }
        catch (ArithmeticException e)
        {
            output.setText("Indeterminate");
            error = true;
        }
        catch (EmptyStackException e)
        {
            output.setText("Invalid Expression");
            error = true;
        }
        catch (RuntimeException e)
        {
            output.setText("Error");
            error = true;
        }

        reset = true;
    }

    static int priority(String x){
        switch (x){
            case "+":
            case "-":
                return 1;
            case "*":
            case "/":
                return 2;
            case "^":
                return 3;
        }
        return -1;
    }

    public ArrayList<String> postfix(){
        String[] token = output.getText().split(" ");
        ArrayList<String> postfix = new ArrayList<>();
        Stack<String> stack = new Stack<>();

        for (int i = 0; i < token.length; i++)
        {
            if (priority(token[i]) > 0)
            {
                while (stack.isEmpty() == false && priority(stack.peek()) >= priority(token[i]))
                {
                    postfix.add(stack.pop());
                }

                stack.push(token[i]);
            }
            else if (token[i] == ")")
            {
                String temp = stack.pop();

                while (temp != "(")
                {
                    postfix.add(temp);
                    temp = stack.pop();
                }
            }
            else if (token[i] == "(")
            {
                stack.push(token[i]);
            }
            else
            {
                postfix.add(token[i]);
            }
        }

        for (int i = 0; i <= stack.size(); i++)
        {
            postfix.add(stack.pop());
        }

        return postfix;
    }

    public String calculate(ArrayList<String> postfix){
        double result = 0;
        double num;
        Stack<Double> stack = new Stack<Double>();

        for (int i = 0; i < postfix.size(); i++)
        {
            try
            {
                num = Double.parseDouble(postfix.get(i));
                stack.push(num);
            }
            catch (NumberFormatException e)
            {
                num = calculate(postfix.get(i), stack);
                stack.push(num);
            }
        }

        result = stack.pop();

        if (!stack.isEmpty())
        {
            throw new RuntimeException();
        }

        return Double.toString(result);
    }

    public static Double calculate(String operator, Stack<Double> stack)
    {
        double x;
        double y;
        double result = 0;

        y = stack.pop();
        x = stack.pop();

        switch (operator)
        {
            case "+":
                result = x + y;
                break;
            case "-":
                result = x - y;
                break;
            case "*":
                result = x * y;
                break;
            case "/":
                if (y == 0)
                    throw new ArithmeticException();
                result = x / y;
                break;
            case "^":
                result = Math.pow(x, y);
                break;
            default:
                throw new InputMismatchException();
        }
        return result;
    }
}