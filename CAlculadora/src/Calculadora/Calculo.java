package Calculadora;

public class Calculo {
    public static  Double Calcular(String operador , Double resultado, String firstNumber, String currentText){
        switch (operador) {
            case "+":
                resultado = Double.parseDouble(firstNumber) + Double.parseDouble(currentText);
                break;
            case "-":
                resultado =  Double.parseDouble(firstNumber) -  Double.parseDouble(currentText);
                break;
            case "*":
                resultado =  Double.parseDouble(firstNumber) *  Double.parseDouble(currentText);
                break;
            case "/":
                if ( Double.parseDouble(currentText) != 0) {
                    resultado =  Double.parseDouble(firstNumber) /  Double.parseDouble(currentText);
                } else {
                    return resultado;
                }
                break;
        }
        return resultado;
    }
}
