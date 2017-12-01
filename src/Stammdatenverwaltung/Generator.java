/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Stammdatenverwaltung;

import java.text.DecimalFormat;
import java.util.Random;

/**
 * Klasse zum initialen Generieren von Dateien
 *
 * @author Tobias, Timo, Musie
 */
public class Generator {

    static DecimalFormat df = new DecimalFormat("#.##");
    static Random rand = new Random();

    public static void produktGenerator() {
        for (int i = 0; i < 15; i++) {

            String bezeichnung = produktBezeichnung();
            double preis = produktPreis();
            String klasse = produktKlasse();

            Produkt neuesProdukt = new Produkt(bezeichnung, preis, klasse);
            ProduktController.produktliste.add(neuesProdukt);
        }
    }

    private static String produktBezeichnung() {
        String firma = "Mühlenbauer";
        String[] Bezeichnung = {"Mehl", "Brot", "Brötchen", "Kuchen", "Plätzchen", "Croissant"};
        String[] Attribut = {"fluffig", "süß", "flockig", "salzig", "luftig"};

        return firma + " " + Bezeichnung[rand.nextInt(Bezeichnung.length)] + " " + Attribut[rand.nextInt(Attribut.length)];
    }

    private static double produktPreis() {
        double preis = 0 + rand.nextDouble() * 39;
        String round = df.format(preis);
        round = round.replaceAll(",", ".");
        return Double.parseDouble(round);
    }

    private static String produktKlasse() {
        String[] Klasse = {"Tierisch", "Vegetarisch", "Vegan"};
        return Klasse[rand.nextInt(Klasse.length)];
    }

    public static void zutatenGenerator() {
        for (int i = 0; i < 15; i++) {

            String bezeichnung = zutatenBezeichnung();
            double preis = zutatenPreis();
            String klasse = zutatenKlasse();

            Zutat neueZutat = new Zutat(bezeichnung, preis, klasse);
            ZutatenController.zutatenliste.add(neueZutat);
        }
    }

    private static String zutatenBezeichnung() {
        String[] Firma = {"Mühlenbauer", "Eiermann", "Zuckerbauer", "Nussknacker", "Kirschenpflücker", "Wasserschöpfer"};
        String[] Bezeichnung = {"Mehl", "Eier", "Zucker", "Fondant", "Streusel", "Kirschen", "Mirabellen", "Äpfel", "Hefe", "Lauge", "Sirup", "Lebensmittelfarbe"};
        String[] Attribut = {"flockig", "gemahlen", "entkernt", "farbig", "bunt"};

        return Firma[rand.nextInt(Firma.length)] + " " + Bezeichnung[rand.nextInt(Bezeichnung.length)] + " " + Attribut[rand.nextInt(Attribut.length)];

    }

    private static double zutatenPreis() {
        double preis = 0 + rand.nextDouble() * 20;
        String round = df.format(preis);
        round = round.replaceAll(",", ".");
        return Double.parseDouble(round);
    }

    private static String zutatenKlasse() {
        String[] Klasse = {"Grundzutat", "Geschmackszutat", "Dekozutat"};
        return Klasse[rand.nextInt(Klasse.length)];
    }

}
