/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Stammdatenverwaltung;

import java.util.InputMismatchException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Tobias, Timo, Musie
 */
public class ProduktController extends ProduktControllerUI {

    public static ArrayList<Produkt> produktliste = new ArrayList();

    public static ArrayList<Produkt> getProduktliste() {
        return produktliste;
    }
    private static final int MAXPRODUKTE = 1000;

    static int kriteriumPNr = 0;
    static String kriteriumBezeichnung = "";
    static double kriteriumPreis = 0.0;
    static double minPreis = 0.0;
    static double maxPreis = 0.0;
    static String kriteriumKlasse = "";
    static boolean spanne = false;
    static Produkt produkt;
    static Scanner reader = new Scanner(System.in);
    static int wahl = 0;

    public static void produkteVerwalten() {

    }

    public static void produktAnlegen(String bezeichnung, double preis, int klasse) {
        String attr = "";
        switch (klasse) {
            case 1:
                attr = "Tierisch";
                break;
            case 2:
                attr = "Vegetarisch";
                break;
            case 3:
                attr = "Vegan";
                break;
        }

        Produkt neuesProdukt = new Produkt(bezeichnung, preis, attr);
        produktliste.add(neuesProdukt);

    }

    public static String produktLoeschen(Produkt produkt) {
                    
                    //Das Produkt wird gelöscht
                    produktliste.remove(produkt);
                    String ausgabe = "Das Produkt wurde erfolgreich gelöscht!";
                    return ausgabe;
        
    }

    private static Produkt produktWahl() {

        // Hilfsvariable erstellen
        Produkt p = null;

        //Liste ausgeben
        System.out.println("Es werden alle möglichen Produktnummern mit Bezeichnungen angezeigt: ");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
        produktliste.forEach((o) -> {
            System.out.println("\nProduktnummer:\t " + o.getpNr()
                    + "\nBezeichnung:\t " + o.getBezeichnung());
        });
        //Solange die Hilfsvariable noch kein Produkt zugewiesen bekommen hat,
        //soll nach einer gültigen Produktnnummer gefragt werden
        while (p == null) {

            //Am Anfang wird die Auswahl erstellt und auf eine ungültige Produktnnummer gesetzt
            int auswahl = -1;
            //Hilfsvariable, welche die Eingabe zwischenspeichert

            //Solange keine ganze Zahl Eingeben wurde
            while (auswahl == -1) {
                System.out.print("\nBitte wählen Sie die gewünschte Produktnummer:     ");
                //Eingabe in Hilfsvariable speichern
                try {
                    auswahl = reader.nextInt();
                    //Eingabe ist eine ganze Zahl
                } catch (InputMismatchException e) {
                    System.out.println("\nDie Produktnummer muss eine ganze Zahl sein, korrigieren Sie die Eingabe");
                }
            }
            // Es wurde bereits eine ganze Zahl Eingegeben

            //Ist die Eingabe auch eine gültige Produktnummer?
            //Wie vorgeben kann die Auswahl eines Produktes mit einer "0" unterbrochen werden,
            //da es kein Produkt mit der Nummer 0 geben kann
            if (auswahl == 0) {
                produkteVerwalten();
                break;
            }

            boolean gefunden = false;

            //In den gespeicherten Produkten suchen, ob es ein Produkt mit dieser Nummer gibt
            for (Produkt o : produktliste) {

                if (o.getpNr() == auswahl) {
                    gefunden = true;
                    //Den gefundenen Produkt an die Hilfsvariable übergebn
                    p = o;
                    //Wenn das Produkt gefunden wurde, macht es kein Sinn die Restlichen auch zu überprüfen
                    //Suchschleife beenden
                    break;
                }
            }

            //Wenn in der Suchschleife kein Produkt gefunden wurde, muss der Benutzer darüber informiert werden
            if (gefunden == false) {
                System.out.println("\nEin Produkt mit dieser Produktnummer existiert nicht.");
                System.out.println("Geben Sie eine gültige Produktnnummer ein.");
            }

        }
        //Wenn die Schleife für die Auswahl nach einem Produkt erfolgreich war, wird das Produkt für überprüfungszwecke ausgegeben
        System.out.println("\nProdukt wurde gefunden: " + p.getBezeichnung() + "\n");

        //Das gefundene Produkt wird zurück gegeben.
        return p;
    }

    public static void produktEditieren(Produkt produkt, String bezeichnung, double preis, String klasse) {
        Produkt p;
        p = produkt;

        p.setBezeichnung(bezeichnung);
        p.setPreis(preis);
        p.setKlasse(klasse);

    }

    public static void produktListe() {
        //Sind schon Produkte gespeichert?
        if (produktliste.isEmpty()) {
            System.out.println("\nEs muss erstmal ein Produkt angelegt werden, bevor dieser Menüpunkt ausgewählt werden kann.");
            produkteVerwalten();
        } else {
            //Wenn es bereits Produkte gibt, können diese angezeigt werden
            //Auswahlmenü
            System.out.println("\nAnzeigen der Produkte:\n");
            System.out.println("Alle Produkte               anzeigen            1");
            System.out.println("Produkte gefiltert          anzeigen            2");
            System.out.println("Ein bestimmtes Produkt      anzeigen            3");
            System.out.println("Zur Produktverwaltung       zurückkehren        0");
            System.out.print("\nIhre Wahl?   ");
        }

        //Auswahl für Anzeigemenü: Produkte
        wahl = reader.nextInt();
        switch (wahl) {
            case 1:
                //Produktliste anzeigen, ohne Kriterien
                produktliste.forEach((o) -> {
                    System.out.println("\nProduktnummer:\t " + o.getpNr()
                            + "\nBezeichnung:\t " + o.getBezeichnung()
                            + "\nPreis:\t\t " + o.getPreis() + " Euro"
                            + "\nKlasse:\t\t " + o.getKlasse());
                });
                break;
            case 2:
                //Ausgabe mit Kriterien
                produktFilter();
                break;
            case 3:
                //Kriteritum Produktnummer
                Produkt p = produktWahl();
                kriteriumPNr = p.getpNr();
                produktListeKriterien();
                System.out.println("\nWollen Sie das gewählte Produkt bearbeiten?\n");
                System.out.println("Produkt     ändern                          1");
                System.out.println("Produkt     löschen                         2");
                System.out.println("Zurück zur  Produktverwaltung               0");
                System.out.print("\nIhre Wahl?   ");
                wahl = reader.nextInt();
                switch (wahl) {
                    case 1:
//                        produktEditieren(p);
                        break;
                    case 2:
                        produktLoeschen(p);
                        break;
                    case 0:
                        produkteVerwalten();
                        break;
                    default:
                        produkteVerwalten();
                }
                break;
            case 0:
                //zurück zur ProduktVerwaltung
                produkteVerwalten();
                break;
            default:
                produktListe();
        }
        produkteVerwalten();
    }

    private static void produktFilter() {
        System.out.println("\nNach was soll gefiltert werden?\n");
        System.out.println("Nach Bezeichnung    filtern                         1");
        System.out.println("Nach Preis          filtern                         2");
        System.out.println("Nach Klasse         filtern                         3");
        System.out.println("Letzten Filter      anzeigen                        4");
        System.out.println("Abbrechen                                           0");
        System.out.print("\nIhre Wahl?   ");

        wahl = reader.nextInt();
        switch (wahl) {
            case 1:
                //Kriteritum Name
                System.out.print("Kriterium Produkt Bezeichnung:    ");
                kriteriumBezeichnung = reader.nextLine();
                produktListeKriterien();
                break;
            case 2:
                //Kriteritum Preis
                System.out.println("\nWollen Sie nach einem genauen Preis oder einer Preisspanne filtern?\n");
                System.out.println("Genauer Preisfilter                         1");
                System.out.println("Preisspannenfilter                          2");
                System.out.println("Abbrechen                                   0");
                System.out.print("\nIhre Wahl?   ");

                wahl = reader.nextInt();
                switch (wahl) {
                    case 1:
                        spanne = false;
                        System.out.println("Genauen Preisfilter setzen: ");
                        System.out.print("Preis:       ");
                        kriteriumPreis = Math.round(reader.nextDouble() * Math.pow(10, 2)) / Math.pow(10, 2);
                        produktListeKriterien();
                        break;
                    case 2:
                        spanne = true;
                        System.out.println("Preisspannenfilter setzen: ");
                        System.out.println("Bitte geben Sie nacheinander zwei Zahlen ein.");
                        System.out.println("Diese stellen die Preisspanne dar");
                        System.out.print("Minimum:   ");
                        minPreis = reader.nextDouble();
                        System.out.print("Maximum:   ");
                        maxPreis = reader.nextDouble();
                        System.out.println("Die Preisspanne geht von " + minPreis + " bis " + maxPreis + " .");
                        produktListeKriterien();
                        break;
                    default:
                        produktFilter();

                }
                break;

            case 3:
                //Klasse festlegen
                //Dies ist sichergestellt indem ein kleines Menü mit diesen Möglichkeiten angezeigt wird
                System.out.println("Kriterium Produkt Klasse:    \n");
                System.out.println("Tierisch        1");
                System.out.println("Vegetarisch     2");
                System.out.println("Vegan           3");

                //Navigation für die Entscheidung
                wahl = reader.nextInt();

                switch (wahl) {
                    case 1:
                        kriteriumKlasse = ("Tierisch");
                        break;
                    case 2:
                        kriteriumKlasse = ("Vegetarisch");
                        break;
                    case 3:
                        kriteriumKlasse = ("Vegan");
                        break;

                }
                produktListeKriterien();
                break;

            case 4:
                produktListeKriterien();
                break;
            case 0:
                //zurück zur ProduktVerwaltung
                produkteVerwalten();
                break;
            default:
                produktFilter();

        }

    }

    private static void produktListeKriterien() {
        if (kriteriumPNr == 0 && "".equals(kriteriumBezeichnung) && kriteriumPreis == 0.0 && minPreis == 0.0 && maxPreis == 0.0 && "".equals(kriteriumKlasse)) {
            System.out.println("Es wurden noch keine Filter benutzt.");
            produktFilter();
        } else {

            if (spanne == false) {
                //Ausgabe der Produkte mit Kriterien
                produktliste.stream().filter((o) -> ((o.getpNr() == kriteriumPNr || kriteriumPNr == 0)
                        && (o.getBezeichnung().equals(kriteriumBezeichnung) || kriteriumBezeichnung.isEmpty())
                        && (o.getPreis() == kriteriumPreis || kriteriumPreis == 0)
                        && (o.getKlasse().equals(kriteriumKlasse) || kriteriumKlasse.isEmpty())))
                        .forEachOrdered((o) -> {

                            System.out.println("\nProduktnummer:\t " + o.getpNr()
                                    + "\nBezeichnung:\t " + o.getBezeichnung()
                                    + "\nPreis:\t\t " + o.getPreis() + " Euro"
                                    + "\nKlasse:\t\t " + o.getKlasse());
                        });
            } else {
                produktliste.stream().filter((o) -> ((o.getpNr() == kriteriumPNr || kriteriumPNr == 0)
                        && (o.getBezeichnung().equals(kriteriumBezeichnung) || kriteriumBezeichnung.isEmpty())
                        && (o.getPreis() > minPreis && o.getPreis() < maxPreis || minPreis == 0 && maxPreis == 0)
                        && (o.getKlasse().equals(kriteriumKlasse) || kriteriumKlasse.isEmpty())))
                        .forEachOrdered((o) -> {
                            System.out.println("\nProduktnummer:\t " + o.getpNr()
                                    + "\nBezeichnung:\t " + o.getBezeichnung()
                                    + "\nPreis:\t\t " + o.getPreis() + " Euro"
                                    + "\nKlasse:\t\t " + o.getKlasse());
                        });
            }
        }
    }
}
