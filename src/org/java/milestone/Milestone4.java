package org.java.milestone;

import java.text.ParseException;
import java.util.List;
import org.java.event.Evento;
import org.java.main.ProgrammEventi;

public class Milestone4 {
	

	    public static void main(String[] args) {
	        try {
	            ProgrammEventi programma = new ProgrammEventi("Programma Eventi");

	            Evento evento1 = new Evento("Evento 1", "01/10/2025", 50);
	            Evento evento2 = new Evento("Evento 2", "15/09/2024", 30);
	            Evento evento3 = new Evento("Evento 3", "20/10/2024", 40);

	            programma.aggiungiEvento(evento1);
	            programma.aggiungiEvento(evento2);
	            programma.aggiungiEvento(evento3);

	            System.out.println("Numero di eventi nel programma: " + programma.numeroEventi());
	            System.out.println("Elenco eventi per data:");
	            System.out.println(programma.elencoEventiPerData());

	            List<Evento> eventiInData = programma.eventiInData("15/09/2024");
	            System.out.println("Eventi in data 15/09/2024:");
	            for (Evento evento : eventiInData) {
	                System.out.println(evento.getTitolo());
	            }

	            programma.svuotaEventi();
	            System.out.println("\nNumero di eventi nel programma dopo averli svuotati: " + programma.numeroEventi());
	        } catch (ParseException e) {
	            e.printStackTrace();
	        } catch (IllegalArgumentException e) {
	            e.printStackTrace();
	        }
	    }
	
	}

