package br.com.generation.aplicacao;

import java.util.Scanner;

import br.com.generation.dominio.Pessoa;

public class Programa {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Digite a sua renda total: ");
		double renda = sc.nextDouble();
		
		System.out.print("Informe o total de seus gastos fixos mensais: ");
		System.out.print("Considere: água, luz, telefone/internet, aluguel/financiamento, alimentação");
		double gastosFixos = sc.nextDouble();
		
		//Instanciando a classe Pessoa e criando o objeto
		Pessoa p1 = new Pessoa("Armando", 26, renda, gastosFixos);
		
		//System.out.printf("Seu nome é: %s. Sua idade é: %d. Sua renda é: %.2f. Seus gastos são: %.2f", p1.getNome(), p1.getIdade(), p1.getRenda(), p1.getGastosFixos());
		
		// Calculo da porcentagem de gastos pela renda
		double porcenGastos = gastosFixos / renda;
		
		System.out.println("Renda: " + porcenGastos);
		
	}

}
