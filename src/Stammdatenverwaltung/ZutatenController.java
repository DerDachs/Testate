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
public class ZutatenController {

    public static ArrayList<Zutat> zutatenliste = new ArrayList();

    public static ArrayList<Zutat> getZutatenliste() {
        return zutatenliste;
    }

    private static final int MAXZUTATEN = 1000;

    static int kriteriumzNr = 0;
    static String kriteriumBezeichnung = "";
    static double kriteriumPreis = 0.0;
    static double minPreis = 0.0;
    static double maxPreis = 0.0;
    static String kriteriumKlasse = "";
    static boolean spanne = false;
    static Zutat zutat;
    static Scanner reader = new Scanner(System.in);
    static int wahl = 0;

    public static void zutatenVerwalten() {

    }

    public static void zutatAnlegen(String bezeichnung, double preis, int klasse) {

        String attr = "";
        switch (klasse) {
            case 1:
                attr = "Grundzutat";
                break;
            case 2:
                attr = "Geschmackszutat";
                break;
            case 3:
                attr = "Dekozutat";
                break;
        }
        //Es darf Maximal 1000 Zutaten geben
//        if (zutatenliste.size() >= MAXZUTATEN) {
//
//            System.out.println("Die Maximale Anzahl von 1000 gespeicherten Zutaten wurde bereits erreicht");
//            System.out.println("Löschen Sie Zutaten um neue Anzulegen");
//
//            zutatenVerwalten();
//        } else {
//
//            System.out.print("Bezeichnung: ");
//            try {
//                bezeichnung = reader.next();
//            } catch (InputMismatchException e) {
//                System.out.println("Fehler in der Eingabe! Bitte erneut versuchen.");
//                zutatAnlegen();
//            }
//
//            System.out.print("Bitte Preis in Euro angeben: ");
//            try {
//                preis = reader.nextDouble();
//            } catch (InputMismatchException e) {
//                System.out.println("Fehler in der Eingabe! Bitte erneut versuchen.");
//                zutatAnlegen();
//            }
//            System.out.println("Klasse wählen\n");
//            System.out.println("Grundzutat          1");
//            System.out.println("Geschmackszutat     2");
//            System.out.println("Dekozutat           3");
//            String klasse = "";

        Zutat neueZutat = new Zutat(bezeichnung, preis, attr);
        zutatenliste.add(neueZutat);

    }

    public static String zutatLoeschen(Zutat zutat) {

        zutatenliste.remove(zutat);
        String ausgabe = "Die Zutat wurde erfolgreich gelöscht.";
        return ausgabe;

    }

    private static Zutat zutatWahl() {

        // Hilfsvariable erstellen
        Zutat z = null;

        //Liste ausgeben
        System.out.println("Es werden alle möglichen Zutatennummern mit Bezeichnungen angezeigt: ");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
        zutatenliste.forEach((o) -> {
            System.out.println("\nZutatennummer:\t " + o.getzNr()
                    + "\nBezeichnung:\t " + o.getBezeichnung());
        });
        //Solange die Hilfsvariable noch keine Zutat zugewiesen bekommen hat,
        //soll nach einer gültigen Zutatnummer gefragt werden
        while (z == null) {

            //Am Anfang wird die Auswahl erstellt und auf eine ungültige Zutatnnummer gesetzt
            int auswahl = -1;
            //Hilfsvariable, welche die Eingabe zwischenspeichert

            //Solange keine ganze Zahl Eingeben wurde
            while (auswahl == -1) {
                System.out.print("\nBitte wählen Sie die gewünschte Zutatennummer:       ");
                //Eingabe in Hilfsvariable speichern
                try {
                    auswahl = reader.nextInt();
                    //Eingabe ist eine ganze Zahl
                } catch (InputMismatchException e) {
                    System.out.println("\nDie Zutatnummer muss eine ganze Zahl sein, korrigieren Sie die Eingabe");
                }
            }
            // Es wurde bereits eine ganze Zahl Eingegeben

            //Ist die Eingabe auch eine gültige Zutatnummer?
            //Wie vorgeben kann die Auswahl einer Zutat mit einer "0" unterbrochen werden,
            //da es kein Zutat mit der Nummer 0 geben kann
            if (auswahl == 0) {
                zutatenVerwalten();
                break;
            }

            boolean gefunden = false;

            //In den gespeicherten Zutaten suchen, ob es eine Zutat mit dieser Nummer gibt
            for (Zutat i : zutatenliste) {

                if (i.getzNr() == auswahl) {
                    gefunden = true;
                    //Die gefundene Zutat an die Hilfsvariable übergebn
                    z = i;
                    //Wenn die Zutat gefunden wurde, macht es kein Sinn die Restlichen auch zu überprüfen
                    //Suchschleife beenden
                    break;
                }
            }

            //Wenn in der Suchschleife ein keine Zutat gefunden wurde, muss der Benutzer darüber informiert werden
            if (gefunden == false) {
                System.out.println("\nEine Zutat mit dieser Zutatnummer existiert nicht.");
                System.out.println("Geben Sie eine gültige Zutatnummer ein.");
            }

        }
        //Wenn die Schleife für die Auswahl nach einem Zutat erfolgreich war, wird das Zutat für überprüfungszwecke ausgegeben
        System.out.println("\n Zutat wurde gefunden: " + z.getBezeichnung() + "\n");

        //Die gefundene Zutat wird zurück gegeben.
        return z;
    }

    public static String zutatEditieren(Zutat zutat, String bezeichnung, double preis, String klasse) {

        Zutat z;
        z = zutat;
        z.setBezeichnung(bezeichnung);
        z.setPreis(preis);
        z.setKlasse(klasse);
        String ausgabe = "Zutat wurde erfolgreich editiert!";
        return ausgabe;

    }

    public static void zutatListe() {
        //Sind schon Zutaten gespeichert?
        if (zutatenliste.isEmpty()) {
            System.out.println("\nEs muss erstmal eine Zutat angelegt werden, bevor dieser Menüpunkt ausgewählt werden kann.");
            zutatenVerwalten();
        } else {
            //Wenn es bereits Zutaten gibt, können diese angezeigt werden
            //Auswahlmenü
            System.out.println("\nAnzeigen der Zutaten:\n");
            System.out.println("Alle Zutaten            anzeigen                1");
            System.out.println("Zutaten gefiltert       anzeigen                2");
            System.out.println("Ein bestimmtes Produkt  anzeigen                3");
            System.out.println("Zutatenverwaltung       zurückkehren            0");
            System.out.print("\nIhre Wahl?   ");
        }

        //Auswahl für Anzeigemenü: Zutaten
        wahl = reader.nextInt();
        switch (wahl) {
            case 1:
                //Zutatenliste anzeigen, ohne Kriterien
                zutatenliste.forEach((i) -> {
                    System.out.println("Zutatnummer: " + i.getzNr()
                            + "\nBezeichnung:\t " + i.getBezeichnung()
                            + "\nPreis:\t\t " + i.getPreis() + " Euro"
                            + "\nKlasse:\t\t " + i.getKlasse());
                });
                break;
            case 2:
//              Ausgabe mit Kriterien
                zutatenFilter();
                break;
            case 3:
                //Kriteritum Produktnummer
                Zutat z = zutatWahl();
                kriteriumzNr = z.getzNr();
                zutatenListeKriterien();
                System.out.println("\nWollen Sie das gewählte Produkt bearbeiten?\n");
                System.out.println("Produkt     ändern                          1");
                System.out.println("Produkt     löschen                         2");
                System.out.println("Zurück zur  Produktverwaltung               0");
                System.out.print("\nIhre Wahl?   ");
                wahl = reader.nextInt();
                switch (wahl) {
                    case 1:
//                        zutatEditieren(z);
                        break;
                    case 2:
                        zutatLoeschen(z);
                        break;
                    case 0:
                        zutatenVerwalten();
                        break;
                    default:
                        zutatenVerwalten();
                }
                break;
            case 0:
                //zurück zur Zutatenverwaltung
                zutatenVerwalten();
                break;
            default:
                zutatListe();
        }
        zutatenVerwalten();
    }

    private static void zutatenFilter() {

        wahl = reader.nextInt();
        switch (wahl) {
            case 1:
                //Kriteritum Name
                System.out.print("Kriterium Zutaten Bezeichnung:    ");
                kriteriumBezeichnung = reader.nextLine();
                zutatenListeKriterien();
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
                        zutatenListeKriterien();
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
                        zutatenListeKriterien();
                        break;
                    default:
                        zutatenFilter();

                }
                break;

            case 3:
                //Klasse festlegen
                //Dies ist sichergestellt indem ein kleines Menü mit diesen Möglichkeiten angezeigt wird
                System.out.println("Kriterium Zutaten Klasse:    \n");
                System.out.println("Grundzutat                                  1");
                System.out.println("Geschmackszutat                             2");
                System.out.println("Dekozutat                                   3");

                //Navigation für die Entscheidung
                wahl = reader.nextInt();

                switch (wahl) {
                    case 1:
                        kriteriumKlasse = ("Grundzutat");
                        break;
                    case 2:
                        kriteriumKlasse = ("Geschmackszutat");
                        break;
                    case 3:
                        kriteriumKlasse = ("Dekozutat");
                        break;

                }
                zutatenListeKriterien();
                break;

            case 4:
                zutatenListeKriterien();
                break;
            case 0:
                //zurück zur ProduktVerwaltung
                zutatenVerwalten();
                break;
            default:
                zutatenFilter();

        }

    }

    private static void zutatenListeKriterien() {
        if (kriteriumzNr == 0 && "".equals(kriteriumBezeichnung) && kriteriumPreis == 0.0 && minPreis == 0.0 && maxPreis == 0.0 && "".equals(kriteriumKlasse)) {
            System.out.println("Es wurden noch keine Filter benutzt.");
            zutatenFilter();
        } else {

            if (spanne == false) {
                //Ausgabe der Produkte mit Kriterien
                zutatenliste.stream().filter((o) -> ((o.getzNr() == kriteriumzNr || kriteriumzNr == 0)
                        && (o.getBezeichnung().equals(kriteriumBezeichnung) || kriteriumBezeichnung.isEmpty())
                        && (o.getPreis() == kriteriumPreis || kriteriumPreis == 0)
                        && (o.getKlasse().equals(kriteriumKlasse) || kriteriumKlasse.isEmpty())))
                        .forEachOrdered((o) -> {

                            System.out.println("\nZutatennummer:\t " + o.getzNr()
                                    + "\nBezeichnung:\t " + o.getBezeichnung()
                                    + "\nPreis:\t\t " + o.getPreis() + " Euro"
                                    + "\nKlasse:\t\t " + o.getKlasse());
                        });
            } else {
                zutatenliste.stream().filter((o) -> ((o.getzNr() == kriteriumzNr || kriteriumzNr == 0)
                        && (o.getBezeichnung().equals(kriteriumBezeichnung) || kriteriumBezeichnung.isEmpty())
                        && (o.getPreis() > minPreis && o.getPreis() < maxPreis || minPreis == 0 && maxPreis == 0)
                        && (o.getKlasse().equals(kriteriumKlasse) || kriteriumKlasse.isEmpty())))
                        .forEachOrdered((o) -> {
                            System.out.println("\nZutatennummer:\t " + o.getzNr()
                                    + "\nBezeichnung:\t " + o.getBezeichnung()
                                    + "\nPreis:\t\t " + o.getPreis() + " Euro"
                                    + "\nKlasse:\t\t " + o.getKlasse());
                        });
            }
        }

    }
}
