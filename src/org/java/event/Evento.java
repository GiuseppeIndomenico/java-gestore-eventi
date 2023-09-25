	package org.java.event;
	
	import java.text.ParseException;
	import java.text.SimpleDateFormat;
	import java.util.Date;
	
	public class Evento {
	    private String titolo;
	    private Date data;
	    private int postiTot;
	    private int postiPren;
	    
	    public Evento(String titolo, String data, int postiTot) throws ParseException, IllegalArgumentException {
	        setTitolo(titolo);
	        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
	        this.data = dateFormat.parse(data);
	        if (this.data.before(new Date())) {
	            throw new IllegalArgumentException("La data dell'evento è già passata.");
	        }
	        if (postiTot <= 0) {
	            throw new IllegalArgumentException("Il numero di posti totali deve essere positivo.");
	        }
	        setPostiTot(postiTot);
	        
	        this.postiPren = 0;
	    }
	
	    public String getTitolo() {
	        return titolo;
	    }
	
	    public void setTitolo(String titolo) {
	        this.titolo = titolo;
	    }
	
	    public String getData() {
	        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
	        return dateFormat.format(data);
	    }
	
	    public void setData(String data) throws ParseException, IllegalArgumentException {
	        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
	        Date newDate = dateFormat.parse(data);
	        if (newDate.before(new Date())) {
	            throw new IllegalArgumentException("La nuova data dell'evento è già passata.");
	        }
	        this.data = newDate;
	    }
	
	    public int getPostiTot() {
	        return postiTot;
	    }
	    
	    public void setPostiTot(int postiTot) {
	        this.postiTot = postiTot;
	    }
	
	    public int getPostiPren() {
	        return postiPren;
	    }
	
	    public void prenota() throws IllegalArgumentException {
	        if (data.before(new Date())) {
	            throw new IllegalArgumentException("Non è possibile prenotare un evento passato.");
	        }
	        if (postiPren >= postiTot) {
	            throw new IllegalArgumentException("Non ci sono posti disponibili per la prenotazione.");
	        }
	        postiPren++;
	    }
	
	    public void disdici() throws Exception {
	        if (data.before(new Date())) {
	            throw new Exception("Non è possibile disdire un evento passato.");
	        }
	        if (postiPren <= 0) {
	            throw new Exception("Non ci sono prenotazioni da disdire.");
	        }
	        postiPren--;
	    }
	    
	    public int postiRimanenti() {
	    	
	    	return getPostiTot() - getPostiPren();
	    }
	
	    @Override
	    public String toString() {
	        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
	        return dateFormat.format(data) + " - " + titolo +
	        		"\nposti disponibili: " + (postiRimanenti()==0? "non ci sono posti disponibili" : postiRimanenti()) +
	        		"\n-------------------------\n"
	        		
	        		;
	    }
	}
