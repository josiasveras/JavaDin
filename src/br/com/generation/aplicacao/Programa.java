package br.com.generation.aplicacao;

import java.util.Locale;
import java.util.Scanner;

import br.com.generation.dominio.Pessoa;
import br.com.generation.dominio.Utilitarios;
import br.com.generation.ui.UI;

public class Programa {

	public static void main(String[] args) {
		
		// Instanciando as classes UI e Utilitarios
		UI ui = new UI();
		Utilitarios conta = new Utilitarios();
		
		//Iniciando vari�vel salarioMinimo com base no valor do sal�rio m�nimo ano base 2021
		double salarioMinimo = 1100.00;
		
		// Instanciando a classe Locale para usar o "." como separador de casas decimais
		Locale.setDefault(Locale.US);
		
		// Instanciando a classe Scanner para permitir entrada de dados a partir da digita��o do usu�rio
		Scanner sc = new Scanner(System.in);
		
		// Coletando dados do usu�rio
		System.out.print("Digite seu nome: ");
		String nome = sc.nextLine();
		
		System.out.print("Digite sua idade: ");
		int idade = sc.nextInt();
		
		System.out.print("Digite a sua renda total: ");
		double renda = sc.nextDouble();
		
		System.out.println("Considere: �gua, luz, telefone/internet, aluguel/financiamento, alimenta��o");
		System.out.print("Informe o total de seus gastos fixos mensais: ");
		double gastosFixos = sc.nextDouble();
		System.out.println();
		
		// Instanciando a classe Pessoa
		Pessoa pessoa = new Pessoa(nome, idade, renda, gastosFixos);
		
		// Calculo da porcentagem de gastos pela renda
		double porcenGastos = gastosFixos / renda;
		
		// Verificando se o usu�rio est� apto a come�ar a poupar ou precisa organizar sua vida financeira antes
		if (porcenGastos <= 0.50) {
			
			System.out.print("Qual valor mensal voc� pretende poupar: ");
			double poupancaMensal = sc.nextDouble();
			
			int TotalMesesReserva;
			
			do {
				System.out.println("Considere: 6, 12 ou 18 meses: ");
				System.out.print("Quanto meses de reserva voc� quer: ");
				TotalMesesReserva = sc.nextInt();
				
			} while (TotalMesesReserva != 6 && TotalMesesReserva != 12 && TotalMesesReserva != 18);
			
			System.out.println("");
			System.out.println("Nome: " + pessoa.getNome());
			System.out.println("Idade: " + pessoa.getIdade() + " anos");

			System.out.println("Sua reserva total necess�ria ser�: R$ " + conta.calculaReservaTotal(gastosFixos, TotalMesesReserva));
			System.out.println("Investindo R$ " + poupancaMensal + " por m�s no Tesouro SELIC: ");
			
			conta.calculaTempoReservaTotal(poupancaMensal);
			conta.calculaTempo();
			
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
						
						ui.dicaRendaMaiorCincoSalMin();
						
					} else {
						
						//System.out.println("Boas pr�ticas para poupar gastos > 60%. Renda Entre 1.5 Sal�rio Min e 5 Sal�rio Min");
						ui.dicaRendaMenorCincoSalMin();
						
					}
				}
			}
		}
	}
}
