package org.java.main;

import java.util.List;
import java.util.stream.Collectors;

import org.java.event.Evento;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;


public class ProgrammEventi {
	private String titolo;
	private List<Evento> eventi;

	public ProgrammEventi(String titolo) {
		this.titolo = titolo;
		this.eventi = new ArrayList<>();
	}

	public void aggiungiEvento(Evento evento) {
		eventi.add(evento);
	}

	public List<Evento> eventiInData(String data) throws ParseException {
	    SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
	    Date targetDate = dateFormat.parse(data);

	    return eventi.stream()
	                 .filter(evento -> {
	                     try {
	                         Date eventoDate = dateFormat.parse(evento.getData());
	                         return eventoDate.equals(targetDate);
	                     } catch (ParseException e) {
	                         e.printStackTrace();
	                         return false;
	                     }
	                 })
	                 .collect(Collectors.toList());
	}


	public long numeroEventi() {
	    return eventi.stream().count();
	}

	public void svuotaEventi() {
	    eventi.clear();
	}
	
	public String elencoEventiPerData() {
		Collections.sort(eventi, (e1, e2) -> {
			try {
				SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
				Date data1 = dateFormat.parse(e1.getData());
				Date data2 = dateFormat.parse(e2.getData());
				return data1.compareTo(data2);
			} catch (ParseException e) {
				e.printStackTrace();
				return 0;
			}
		});

		String result = "";
		for (Evento evento : eventi) {
		    result += "- " + evento.getData() + " - " + evento.getTitolo() + "\n";
		}

		return result;

	}
}
