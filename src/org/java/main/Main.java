package org.java.main;

import java.text.ParseException;
import java.util.Scanner;

import org.java.event.Evento;

public class Main {
	public static void main(String[] args) throws ParseException, Exception {
		//MILESTONE 1-2
		Scanner sc = new Scanner(System.in);
		boolean eventoCreato = false;
		int postiPren;
		int postiDis;
		Evento ev1=null;
		// creazione evento
		while (!eventoCreato) {
			try {
				String titolo;
				String data;
				int postiTot;

				System.out.println("Creare un nuovo evento!\nNome evento:");
				titolo = sc.nextLine();

				System.out.println("Inserire data evento in formato dd/MM/yyyy:");
				data = sc.nextLine();

				System.out.println("Numero di posti totali:");
				String postiTotInput = sc.nextLine();
				postiTot = Integer.parseInt(postiTotInput);

				ev1 = new Evento(titolo, data, postiTot);

				System.out.println("\nIl tuo evento: " + ev1);
				eventoCreato = true;
			} catch (ParseException | IllegalArgumentException e) {
				System.err.println("Errore: " + e.getMessage());
				System.out.println("Riprovare a creare l'evento.");
			}
		}
			
			System.out.println("quanti posti vuoi prenotare?");
			
			postiPren= sc.nextInt();
			
			for(int x=0; x<postiPren; x++) {
				ev1.prenota();
			}

			System.out.println( "posti prenotati: " + ev1.getPostiPren() +
					"\nposti ancora disponibili: " + ev1.postiRimanenti() );
			
			
			System.out.println("quanti posti vuoi disdire");
			
			postiDis=sc.nextInt();
			
			for(int x=0; x<postiDis; x++) {
				ev1.disdici();
			}
			
			System.out.println( "posti prenotati: " + ev1.getPostiPren() +
					"\nposti ancora disponibili: " + ev1.postiRimanenti() );
		
		sc.close();
	}
}
