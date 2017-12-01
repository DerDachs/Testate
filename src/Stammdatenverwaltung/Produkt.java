/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Stammdatenverwaltung;

/**
 *
 * @author Tobias, Timo, Musie
 */
public class Produkt {

    static private int zaehlerPNR = 1;

    private int pNr;
    private String bezeichnung;
    private double preis; // in €
    private String klasse;

    public Produkt(String bezeichnung, double preis, String klasse) {
        this.bezeichnung = bezeichnung;
        this.preis = preis;
        this.klasse = klasse;
        this.pNr = zaehlerPNR;
        zaehlerPNR++;
    }

    public int getpNr() {
        return pNr;
    }

    public String getBezeichnung() {
        return bezeichnung;
    }

    public void setBezeichnung(String bezeichnung) {
        this.bezeichnung = bezeichnung;
    }

    public double getPreis() {
        return preis;
    }

    public void setPreis(double preis) {
        this.preis = preis;
    }

    public String getKlasse() {
        return klasse;
    }

    public void setKlasse(String klasse) {
        this.klasse = klasse;
    }
}
