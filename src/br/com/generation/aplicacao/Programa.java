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
		
		System.out.print("Digite seu nome: ");
		String nome = sc.nextLine();
		
		System.out.print("Digite sua idade: ");
		int idade = sc.nextInt();
		
		System.out.print("Digite a sua renda total: ");
		double renda = sc.nextDouble();
		
		System.out.println("Considere: água, luz, telefone/internet, aluguel/financiamento, alimentação");
		System.out.print("Informe o total de seus gastos fixos mensais: ");
		double gastosFixos = sc.nextDouble();
		
		// Instanciando a classe Pessoa
		Pessoa pessoa = new Pessoa(nome, idade, renda, gastosFixos);
		
		// Calculo da porcentagem de gastos pela renda
		double porcenGastos = gastosFixos / renda;
		
		//System.out.println("Renda: " + porcenGastos);
		
		if (porcenGastos <= 0.50) {
			System.out.print("Qual valor mensal você pretende poupar: ");
			double poupancaMensal = sc.nextDouble();
			
			int TotalMesesReserva;
			
			do {
				System.out.println("Considere: 6, 12 ou 18 meses: ");
				System.out.print("Quanto meses de reserva você quer: ");
				TotalMesesReserva = sc.nextInt();
				
			} while (TotalMesesReserva != 6 && TotalMesesReserva != 12 && TotalMesesReserva != 18);
			
			Utilitarios conta = new Utilitarios();
			
			System.out.println("");
			System.out.println("Nome: " + pessoa.getNome());
			System.out.println("Idade: " + pessoa.getIdade() + " anos");

			System.out.println("Sua reserva total necessária será: R$ " + conta.calculaReservaTotal(gastosFixos, TotalMesesReserva));
			System.out.println("Investindo R$ " + poupancaMensal + " por mês no Tesouro SELIC: ");
			
			conta.calculaTempoReservaTotal(poupancaMensal);
			conta.calculaTempo();
			
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
