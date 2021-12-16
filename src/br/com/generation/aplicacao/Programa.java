package br.com.generation.aplicacao;

import java.util.Locale;
import java.util.Scanner;

import br.com.generation.dominio.Pessoa;
import br.com.generation.dominio.Utilitarios;

public class Programa {

	public static void main(String[] args) {
		
		double salarioMinimo = 1100.00;
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Digite a sua renda total: ");
		double renda = sc.nextDouble();
		
		System.out.println("Informe o total de seus gastos fixos mensais: ");
		System.out.println("Considere: água, luz, telefone/internet, aluguel/financiamento, alimentação");
		double gastosFixos = sc.nextDouble();
		
		//Instanciando a classe Pessoa e criando o objeto
		//Pessoa pessoaApta = new Pessoa("Armando", 26, 20000.00, 500.00);
		//Pessoa pessoaInaptaAMenorUmSaleMeio = new Pessoa("Paulo", 26, 1000.00, 700.00);
		//Pessoa pessoaInaptaBMaior5SalMin = new Pessoa("Maria", 40, 20000.00, 15000.00);
		//Pessoa pessoaInaptaCSalMinMaior1emeioEMenor60PorCent = new Pessoa("João", 50, 1700.00, 900.00);
		Pessoa pessoaInaptaDGastoMaior60ERendaEntreUmEMeioECincoSalMin = new Pessoa("Lucas", 48, 2200.00, 1800.00);
		
		//System.out.printf("Seu nome é: %s. Sua idade é: %d. Sua renda é: %.2f. Seus gastos são: %.2f", p1.getNome(), p1.getIdade(), p1.getRenda(), p1.getGastosFixos());
		
		// Calculo da porcentagem de gastos pela renda
		double porcenGastos = gastosFixos / renda;
		
		//System.out.println("Renda: " + porcenGastos);
		
		if (porcenGastos <= 0.50) {
			System.out.println("Qual valor mensal você pretende poupar: ");
			double poupancaMensal = sc.nextDouble();
			
			/*System.out.println("Quanto meses de reserva você quer: ");
			System.out.println("Considere: 6, 12 ou 18 meses: ");
			int reservaTotal = sc.nextInt();*/
			
			int TotalMesesReserva;
			
			do {
				System.out.println("Considere: 6, 12 ou 18 meses: ");
				System.out.println("Quanto meses de reserva você quer: ");
				TotalMesesReserva = sc.nextInt();
				
			} while (TotalMesesReserva != 6 && TotalMesesReserva != 12 && TotalMesesReserva != 18);
			
			Utilitarios conta = new Utilitarios();

			System.out.println("Sua reserva total necessária será: " + conta.calculaReservaTotal(gastosFixos, TotalMesesReserva));
			System.out.println("Tempo necessário para atingir a reserva desejada : " + conta.calculaTempoReservaTotal(poupancaMensal) + " meses");
			
		} else {
			if (porcenGastos <= 0.60) {
				if (renda <= (salarioMinimo * 1.5)) {
					System.out.println("Boas práticas para poupar <= 1.5 salario Mínimo");
				} else {
					System.out.println("Boas práticas para poupar > 1.5 salario Mínimo e <= 0.60");
				}
			} else {
				if (renda <= (salarioMinimo * 1.5)) {
					System.out.println("Boas práticas para poupar < 1.5 salario Mínimo");
				} else {
					if(renda > (salarioMinimo * 5)) {
						System.out.println("Boas práticas para poupar > 5 salario Mínimo");
					} else {
						System.out.println("Boas práticas para poupar gastos > 60%. Renda Entre 1.5 Salário Min e 5 Salário Min");
					}
				}
			}
		}
	}
}
