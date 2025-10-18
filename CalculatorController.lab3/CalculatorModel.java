package labs_WP.lab2;
enum Operation {
    PLUS , MINUS, MULTIPLY, DIVIDE
}
public class CalculatorModel {
    private double num;
    private double answer;
    private Operation operation;

    public void setNum(double num) {
        this.num = num;
    }

    public void setOperation(Operation operation) {
        this.operation = operation;
    }

    public double calculate(double secondNum) {
        switch (operation) {
            case PLUS: answer = num + secondNum; break;
            case MINUS: answer = num - secondNum; break;
            case MULTIPLY: answer = num * secondNum; break;
            case DIVIDE: answer = num / secondNum; break;
            default: answer = 0;
        }
        return answer;
    }
}

