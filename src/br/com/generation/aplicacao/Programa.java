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
		
		System.out.println("Considere: �gua, luz, telefone/internet, aluguel/financiamento, alimenta��o");
		System.out.print("Informe o total de seus gastos fixos mensais: ");
		double gastosFixos = sc.nextDouble();
		System.out.println();
		
		// Instanciando a classe Pessoa
		Pessoa pessoa = new Pessoa(nome, idade, renda, gastosFixos);
		
		// Calculo da porcentagem de gastos pela renda
		double porcenGastos = gastosFixos / renda;
		
		//System.out.println("Renda: " + porcenGastos);
		
		if (porcenGastos <= 0.50) {
			System.out.print("Qual valor mensal voc� pretende poupar: ");
			double poupancaMensal = sc.nextDouble();
			
			int TotalMesesReserva;
			
			do {
				System.out.println("Considere: 6, 12 ou 18 meses: ");
				System.out.print("Quanto meses de reserva voc� quer: ");
				TotalMesesReserva = sc.nextInt();
				
			} while (TotalMesesReserva != 6 && TotalMesesReserva != 12 && TotalMesesReserva != 18);
			
			Utilitarios conta = new Utilitarios();
			
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
						//"Boas praticas para poupar/ padr�o de vida alto\r\n"
						// + "\r\n"
						System.out.println(
								"Baseado na sua renda acreditamos que a melhor forma de te ajudar a ter aquele dinheirinho no bolso � estabilizar sua \n"
								+ "renda de forma saud�vel.\r\n"
								+ "Aqui vai uma dica: Leve em conta um limite de 50% de gastos fixos no m�s e voc� vai conseguir estabilizar suas dividas.\r\n"
								+ "Vamos falar dos custos fixos, em casos que os custos fixos s�o maiores que uma renda generosa, onde talvez o custo de vida \n"
								+ "seja muito alto � sempre bom considerar os valores pagos mensalmente, como aluguel, contas de �gua, luz e internet, \n"
								+ "gasolina se ouver ve�culos e servi�os de assinatura mensal.\r\n"
								+ "Coloque no papel todos esses gastos e compare seus valores com novas oportunidades como uma casa com um aluguel \n"
								+ "mais barato e se voc� utiliza todos esses servi�os por assinatura.");
					} else {
						System.out.println("Boas pr�ticas para poupar gastos > 60%. Renda Entre 1.5 Sal�rio Min e 5 Sal�rio Min");
					}
				}
			}
		}
	}
}
