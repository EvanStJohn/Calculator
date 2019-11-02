package sample;

import javafx.scene.control.Button;
import javafx.scene.control.Label;

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
    public Label result;

    public void clickOne(){
        result.setText(result.getText() + "1");
    }

    public void clickTwo(){
        result.setText(result.getText() + "2");
    }

    public void clickThree(){
        result.setText(result.getText() + "3");
    }

    public void clickFour(){
        result.setText(result.getText() + "4");
    }

    public void clickFive(){
        result.setText(result.getText() + "5");
    }

    public void clickSix(){
        result.setText(result.getText() + "6");
    }

    public void clickSeven(){
        result.setText(result.getText() + "7");
    }

    public void clickEight(){
        result.setText(result.getText() + "8");
    }

    public void clickNine(){
        result.setText(result.getText() + "9");
    }

    public void  clickClear(){
        result.setText("");
    }

    public void clickPoint(){
        result.setText(result.getText() + ".");
    }

    public void clickNegative(){
        result.setText(result.getText() + "-");
    }

    public void clickLeftPar(){
        result.setText(result.getText() + "( ");
    }

    public void clickRightPar(){
        result.setText(result.getText() + " )");
    }

    public void clickPower(){
        result.setText(result.getText() + " ^ ");
    }

    public void clickDivide(){
        result.setText(result.getText() + " / ");
    }

    public void clickMultiply(){
        result.setText(result.getText() + " * ");
    }

    public void clickSubtract(){
        result.setText(result.getText() + " - ");
    }

    public void clickAdd(){
        result.setText(result.getText() + " + ");
    }

    public void clickEqual(){

    }


}
