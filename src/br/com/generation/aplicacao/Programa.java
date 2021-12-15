package br.com.generation.aplicacao;

import java.util.Locale;
import java.util.Scanner;

import br.com.generation.dominio.Pessoa;

public class Programa {

	public static void main(String[] args) {
		
		double salarioMinimo = 1100.00;
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Digite a sua renda total: ");
		double renda = sc.nextDouble();
		
		System.out.print("Informe o total de seus gastos fixos mensais: ");
		System.out.print("Considere: �gua, luz, telefone/internet, aluguel/financiamento, alimenta��o");
		double gastosFixos = sc.nextDouble();
		
		//Instanciando a classe Pessoa e criando o objeto
		//Pessoa pessoaApta = new Pessoa("Armando", 26, 20000.00, 500.00);
		//Pessoa pessoaInaptaAMenorUmSaleMeio = new Pessoa("Paulo", 26, 1000.00, 700.00);
		//Pessoa pessoaInaptaBMaior5SalMin = new Pessoa("Maria", 40, 20000.00, 15000.00);
		//Pessoa pessoaInaptaCSalMinMaior1emeioEMenor60PorCent = new Pessoa("Jo�o", 50, 1700.00, 900.00);
		Pessoa pessoaInaptaDGastoMaior60ERendaEntreUmEMeioECincoSalMin = new Pessoa("Lucas", 48, 2200.00, 1800.00);
		
		//System.out.printf("Seu nome �: %s. Sua idade �: %d. Sua renda �: %.2f. Seus gastos s�o: %.2f", p1.getNome(), p1.getIdade(), p1.getRenda(), p1.getGastosFixos());
		
		// Calculo da porcentagem de gastos pela renda
		double porcenGastos = gastosFixos / renda;
		
		//System.out.println("Renda: " + porcenGastos);
		
		if (porcenGastos <= 0.50) {
			System.out.println("Pretende poupar");
		} else {
			if (porcenGastos <= 0.60) {
				if (renda <= (salarioMinimo * 1.5)) {
					System.out.println("Boas pr�ticas para poupar <= 1.5 salario M�nimo");
				} else {
					System.out.println("Boas pr�ticas para poupar > 1.5 salario M�nimo e <= 0.60");
				}
			} else {
				if (renda <= (salarioMinimo * 1.5)) {
					System.out.println("Boas pr�ticas para poupar < 1.5 salario M�nimo");
				} else {
					if(renda > (salarioMinimo * 5)) {
						System.out.println("Boas pr�ticas para poupar > 5 salario M�nimo");
					} else {
						System.out.println("Boas pr�ticas para poupar gastos > 60%. Renda Entre 1.5 Sal�rio Min e 5 Sal�rio Min");
					}
				}
			}
		}
	}
}
