/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JDialog;

import Stammdatenverwaltung.MainFrame;
import java.text.DecimalFormat;
import Stammdatenverwaltung.Zutat;
import Stammdatenverwaltung.ZutatenController;
import javax.swing.JOptionPane;

/**
 *
 * @author dachs
 */
public class zutatEditierenDialog extends javax.swing.JDialog {

    MainFrame mainFrame;
    static double preis;
    static String bezeichnung;
    static String klasse;
    static int reihe;
    DecimalFormat df = new DecimalFormat("#.##");
    static Zutat z = null;

    /**
     * Creates new form zutatEditierenDialog
     */
    public zutatEditierenDialog(MainFrame mainFrame, boolean modal, int inhalt) {
        super(mainFrame, modal);
        reihe = inhalt;
        this.mainFrame = mainFrame;
        initComponents();
        zutatEditieren(reihe);
        this.setLocationRelativeTo(this.getParent());
        this.setVisible(true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        klasseBtnGroup = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        bezTextField = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        preisTextField = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        saveBtn = new javax.swing.JButton();
        cancelBtn = new javax.swing.JButton();
        tierischRadioBtn = new javax.swing.JRadioButton();
        vegetarischRadioBtn = new javax.swing.JRadioButton();
        veganRadioBtn = new javax.swing.JRadioButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("Aktuelle Werte");

        jLabel2.setText("Zutat editieren");

        jLabel3.setText("Bezeichnung");

        jLabel4.setText("Preis");

        jLabel5.setText("Klasse");

        saveBtn.setText("Save");
        saveBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveBtnActionPerformed(evt);
            }
        });

        cancelBtn.setText("Cancel");
        cancelBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelBtnActionPerformed(evt);
            }
        });

        klasseBtnGroup.add(tierischRadioBtn);
        tierischRadioBtn.setSelected(true);
        tierischRadioBtn.setText("Grundzutat");

        klasseBtnGroup.add(vegetarischRadioBtn);
        vegetarischRadioBtn.setText("Geschmackszutat");

        klasseBtnGroup.add(veganRadioBtn);
        veganRadioBtn.setText("Dekozutat");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel2)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(saveBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 206, Short.MAX_VALUE)
                        .addComponent(cancelBtn))
                    .addComponent(jLabel1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5))
                        .addGap(77, 77, 77)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(bezTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(preisTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tierischRadioBtn)
                            .addComponent(vegetarischRadioBtn)
                            .addComponent(veganRadioBtn))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(bezTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(preisTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(tierischRadioBtn))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(vegetarischRadioBtn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(veganRadioBtn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(saveBtn)
                    .addComponent(cancelBtn))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void saveBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveBtnActionPerformed
        tierischRadioBtn.setActionCommand("Tierisch");
        vegetarischRadioBtn.setActionCommand("Vegetarisch");
        veganRadioBtn.setActionCommand("Vegan");

        if (bezTextField.getText().matches("[ A-Za-z]*") || bezTextField.getText().length() != 0) {
            bezeichnung = bezTextField.getText();
            try {
                String eingabe = preisTextField.getText();
                if (eingabe.contains(",")) {
                    eingabe = eingabe.replaceAll(",", ".");
                }
                preis = Double.parseDouble(eingabe);
                eingabe = df.format(preis);
                eingabe = eingabe.replaceAll(",", ".");
                preis = Double.parseDouble(eingabe);
                if (preis <= 0) {
                    JOptionPane.showMessageDialog(this, "Bitte geben Sie eine Zahl über null ein!", "Warning", JOptionPane.OK_OPTION);
                } else {
                    klasse = klasseBtnGroup.getSelection().getActionCommand();
                    String ausgabe = ZutatenController.zutatEditieren(z, bezeichnung, preis, klasse);
                    MainFrame.zutatenListeAktualisieren();
                    MainFrame.zutatenListLabel.setText(ausgabe);
                    JOptionPane.showInternalMessageDialog(rootPane, "Die Zutat wurde erfolgreich editiert!", "Info", JOptionPane.INFORMATION_MESSAGE);
                    this.dispose();
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this, "Bitte geben Sie eine Zahl über null ein!", "Warning", JOptionPane.OK_OPTION);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Bitte geben Sie eine aus Buchstaben bestehende Zeichenkette ein!", "Warning", JOptionPane.OK_OPTION);
        }
    }//GEN-LAST:event_saveBtnActionPerformed

    private void cancelBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelBtnActionPerformed
        if (JOptionPane.YES_OPTION == JOptionPane.showConfirmDialog(rootPane, "Wollen Sie die Bearbeitung wirklich abbrechen? Bereits geänderte Daten gehen verloren.", "Warning", JOptionPane.YES_NO_OPTION)) {
            this.dispose();
        }
    }//GEN-LAST:event_cancelBtnActionPerformed

    public static void zutatEditieren(int reihe){
        boolean gefunden = false;

        for (Zutat o : ZutatenController.zutatenliste) {

            if (o.getzNr() == reihe) {
                gefunden = true;
                z = o;
                break;
            }
        }
        bezTextField.setText(z.getBezeichnung());
        System.out.println("Bez: " + z.getBezeichnung());
        preisTextField.setText(String.valueOf(z.getPreis()));
        klasseBtnGroup.clearSelection();
        klasse = z.getKlasse();
        switch (klasse) {
            case "Tierisch":
                tierischRadioBtn.setSelected(true);
                break;
            case "Vegetarisch":
                vegetarischRadioBtn.setSelected(true);
                break;
            case "Vegan":
                veganRadioBtn.setSelected(true);
                break;
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private static javax.swing.JTextField bezTextField;
    private javax.swing.JButton cancelBtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private static javax.swing.ButtonGroup klasseBtnGroup;
    private static javax.swing.JTextField preisTextField;
    private javax.swing.JButton saveBtn;
    private static javax.swing.JRadioButton tierischRadioBtn;
    private static javax.swing.JRadioButton veganRadioBtn;
    private static javax.swing.JRadioButton vegetarischRadioBtn;
    // End of variables declaration//GEN-END:variables

    
}