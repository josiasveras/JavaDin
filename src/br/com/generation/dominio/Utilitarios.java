package br.com.generation.dominio;

public class Utilitarios {
	
	double reservaTotal;
	
	public double calculaReservaTotal(double gastosFixos, int TotalMesesReserva) {
		reservaTotal = gastosFixos * TotalMesesReserva;
		return reservaTotal;
	}
	
	public double calculaTempoReservaTotal(double poupancaMensal) {
		 double tempoReservaTotal = reservaTotal / poupancaMensal;
		 Math.round(tempoReservaTotal * 365);
		 return tempoReservaTotal;
	}
	
	/*public int calculaTempo() {
		/PROCESSAMENTO
		/*anos = tempoReservaTotal * 365;
		meses = (totalDias % 365) / 30;
		dias = (totalDias % 365) % 30;
		
		//SAÍDA
		System.out.printf("Sua idade total é: %d anos %d meses e %d dias", anos, meses, dias);
	}*/
	
}
