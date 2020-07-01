package br.com.codenation.calculadora;

import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        CalculadoraSalario calculator = new CalculadoraSalario();
        Scanner read = new Scanner(System.in);
        System.out.println("Type/Declare the value (Salário Bruto): ");
        double value = Double.parseDouble(read.nextLine());
        double resultSalarioLiquido = calculator.calcularSalarioLiquido(value);
        System.out.println("Salário Líquido");
        System.out.println(resultSalarioLiquido);
        //double resultINSS = calculator.calcularInss(value);
        //System.out.println("INSS: ");
        //System.out.println(resultINSS);
    }
}
