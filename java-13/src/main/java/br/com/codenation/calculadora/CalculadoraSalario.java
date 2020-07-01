package br.com.codenation.calculadora;


public class CalculadoraSalario implements OperationINSSandIRRF
{

	private final double SALARIO_MINIMO = 1039.00;

	public long calcularSalarioLiquido(double salarioBase)
	{
		//Use o Math.round apenas no final do método para arredondar o valor final.
		//Documentação do método: https://docs.oracle.com/javase/8/docs/api/java/lang/Math.html#round-double-

		if (salarioBase < SALARIO_MINIMO)
		{
			return (long) 0.0;
		}
		double discountIrrf = salarioBase - (calcularInss(salarioBase));
		double salarioLiquido = discountIrrf - (calcularIrrf(discountIrrf));

		return Math.round(salarioLiquido);
	}
	
	
	//Exemplo de método que pode ser criado para separar melhor as responsábilidades de seu algorítmo
	private double calcularInss(double salarioBase)
	{
		double salaryRangeInss_01 = 1500;
		double salaryRangeInss_02 = 4000;

		if (salarioBase == 0.0)
		{
			return 0.0;
		}

		//Here - first evaluate if the salary is less or equal to the salaryRange_02...
		if (salarioBase <= salaryRangeInss_02)
		{
			//...and reevaluate if the salary is less or equal to the salaryRange_01
			if (salarioBase <= salaryRangeInss_01)
			{
				return salarioBase * INSS_DiscountRange_01;
			}
			return salarioBase * INSS_DiscountRange_02;
		}
		else
		{
			return salarioBase * INSS_DiscountRange_03;
		}

		//return 0.0;
	}

	private double calcularIrrf(double salarioBase)
	{
		double salaryRangeIrrf_01 = 3000;
		double salaryRangeIrrf_02 = 6000;

		if (salarioBase == 0.0)
		{
			return 0.0;
		}

		//Here - first evaluate if the salary is less or equal to the salaryRangeIrff_02...
		if (salarioBase <= salaryRangeIrrf_02)
		{
			if (salarioBase <= salaryRangeIrrf_01)
			{
				return salarioBase * IRRF_DiscountRange_01;
			}
			return salarioBase * IRRF_DiscountRange_02;
		}
		else
		{
			return salarioBase * IRRF_DiscountRange_03;
		}
	}

}
/*Dúvidas ou Problemas?
Manda e-mail para o meajuda@codenation.dev que iremos te ajudar! 
*/