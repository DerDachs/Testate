/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Stammdatenverwaltung;

import java.util.Scanner;

/**
 *
 * @author Tobias,Timo,Musie
 */
public class Stammdatenverwaltung {

    static Scanner reader = new Scanner(System.in);
    static int wahl;


    public static void main(String[] args) {

        new Stammdatenverwaltung();

    }

    public Stammdatenverwaltung() {
        Generator.produktGenerator();
        Generator.zutatenGenerator();
        MainFrame mainFrame = new MainFrame(this);
        mainFrame.setVisible(true);
 
    }
}
