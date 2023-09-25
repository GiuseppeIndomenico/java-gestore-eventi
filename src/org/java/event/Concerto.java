package org.java.event;

import java.math.BigDecimal;
import java.text.ParseException;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Concerto extends Evento {
    private LocalTime ora;
    private BigDecimal prezzo;

    public Concerto(String titolo, String data, int postiTot, LocalTime ora, BigDecimal prezzo)
            throws ParseException, IllegalArgumentException {
        super(titolo, data, postiTot);
        setOra(ora);
        setPrezzo(prezzo);
    }

    public LocalTime getOra() {
        return ora;
    }

    public void setOra(LocalTime ora) {
        this.ora = ora;
    }

    public BigDecimal getPrezzo() {
        return prezzo;
    }

    public void setPrezzo(BigDecimal prezzo) {
        this.prezzo = prezzo;
    }

    public String getFormattedDataOra() {
        String ora = getOra().format(DateTimeFormatter.ofPattern("HH:mm"));
        return getData() + " - " + ora;
    }


    public String getFormattedPrezzo() {
        return String.format("%.2f€", prezzo);
    }

    @Override
    public String toString() {
        return getFormattedDataOra() + " - " + getTitolo() + " - " + getFormattedPrezzo();
    }
}
