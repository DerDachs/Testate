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
public class Zutat {

    static private int zaehlerZNR = 1;

    private int zNr;
    private String bezeichnung;
    private double preis; // in €
    private String klasse;

    public Zutat(String bezeichnung, double preis, String klasse) {
        this.bezeichnung = bezeichnung;
        this.preis = preis;
        this.klasse = klasse;
        this.zNr = zaehlerZNR;
        zaehlerZNR++;
    }

    public int getzNr() {
        return zNr;
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
