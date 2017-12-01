/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JDialog;

import Stammdatenverwaltung.MainFrame;
import Stammdatenverwaltung.ProduktController;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import javax.swing.JOptionPane;

/**
 *
 * @author dachs
 */
public class produktAnlegenDialog extends javax.swing.JDialog {

    MainFrame mainFrame;
    String bezeichnung;
    int klasse = 1;
    double preis;
    DecimalFormat df = new DecimalFormat("#.##");

    /**
     * Creates new form produktAnlegenDialog
     */
    public produktAnlegenDialog(MainFrame mainFrame, boolean modal) {
        super(mainFrame, modal);
        this.mainFrame = mainFrame;
        initComponents();
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

        jLabel1 = new javax.swing.JLabel();
        parentPanel = new javax.swing.JPanel();
        bezPanel = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        bezTextField = new javax.swing.JTextField();
        cancelBtnBez = new javax.swing.JButton();
        nextBtnBez = new javax.swing.JButton();
        preisPanel = new javax.swing.JPanel();
        preisLabel = new javax.swing.JLabel();
        preisTextField = new javax.swing.JTextField();
        cancelBtnPreis = new javax.swing.JButton();
        nextBtnPreis = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        preisBackBtn = new javax.swing.JButton();
        klassenPanel = new javax.swing.JPanel();
        tierischRadioBtn = new javax.swing.JRadioButton();
        vegetarischRadioBtn = new javax.swing.JRadioButton();
        veganRadioBtn = new javax.swing.JRadioButton();
        klassenLabel = new javax.swing.JLabel();
        cancelBtnKlasse = new javax.swing.JButton();
        finishBtnKlasse = new javax.swing.JButton();
        klasseBackBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("Neues Produkt anlegen");
        getContentPane().add(jLabel1, java.awt.BorderLayout.PAGE_START);

        parentPanel.setLayout(new java.awt.CardLayout());

        jLabel2.setText("Bitte geben Sie eine passende Bezeichnung ein:");

        bezTextField.setText("Bezeichnung");

        cancelBtnBez.setText("Cancel");
        cancelBtnBez.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelBtnBezActionPerformed(evt);
            }
        });

        nextBtnBez.setText("Next");
        nextBtnBez.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nextBtnBezActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout bezPanelLayout = new javax.swing.GroupLayout(bezPanel);
        bezPanel.setLayout(bezPanelLayout);
        bezPanelLayout.setHorizontalGroup(
            bezPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bezPanelLayout.createSequentialGroup()
                .addGroup(bezPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(bezPanelLayout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addGroup(bezPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(bezTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(bezPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(cancelBtnBez)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(nextBtnBez)))
                .addContainerGap())
        );
        bezPanelLayout.setVerticalGroup(
            bezPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bezPanelLayout.createSequentialGroup()
                .addGap(64, 64, 64)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(bezTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 93, Short.MAX_VALUE)
                .addGroup(bezPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cancelBtnBez)
                    .addComponent(nextBtnBez))
                .addContainerGap())
        );

        parentPanel.add(bezPanel, "card2");

        preisLabel.setText("Wie teuer ist das Produkt?");

        preisTextField.setText("1.00");

        cancelBtnPreis.setText("Cancel");
        cancelBtnPreis.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelBtnPreisActionPerformed(evt);
            }
        });

        nextBtnPreis.setText("Next");
        nextBtnPreis.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nextBtnPreisActionPerformed(evt);
            }
        });

        jLabel3.setText("Euro");

        preisBackBtn.setText("Back");
        preisBackBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                preisBackBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout preisPanelLayout = new javax.swing.GroupLayout(preisPanel);
        preisPanel.setLayout(preisPanelLayout);
        preisPanelLayout.setHorizontalGroup(
            preisPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(preisPanelLayout.createSequentialGroup()
                .addGroup(preisPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(preisPanelLayout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addGroup(preisPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(preisPanelLayout.createSequentialGroup()
                                .addComponent(preisTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel3))
                            .addComponent(preisLabel))
                        .addGap(0, 208, Short.MAX_VALUE))
                    .addGroup(preisPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(cancelBtnPreis)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(preisBackBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(nextBtnPreis)))
                .addContainerGap())
        );
        preisPanelLayout.setVerticalGroup(
            preisPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(preisPanelLayout.createSequentialGroup()
                .addGap(58, 58, 58)
                .addComponent(preisLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(preisPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(preisTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 98, Short.MAX_VALUE)
                .addGroup(preisPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cancelBtnPreis)
                    .addComponent(nextBtnPreis)
                    .addComponent(preisBackBtn))
                .addContainerGap())
        );

        parentPanel.add(preisPanel, "card3");

        tierischRadioBtn.setSelected(true);
        tierischRadioBtn.setText("Tierisch");
        tierischRadioBtn.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                tierischRadioBtnItemStateChanged(evt);
            }
        });

        vegetarischRadioBtn.setText("Vegetarisch");
        vegetarischRadioBtn.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                vegetarischRadioBtnItemStateChanged(evt);
            }
        });

        veganRadioBtn.setText("Vegan");
        veganRadioBtn.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                veganRadioBtnStateChanged(evt);
            }
        });

        klassenLabel.setText("Zu welcher Klasse gehört das Produkt?");

        cancelBtnKlasse.setText("Cancel");
        cancelBtnKlasse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelBtnKlasseActionPerformed(evt);
            }
        });

        finishBtnKlasse.setText("Finish");
        finishBtnKlasse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                finishBtnKlasseActionPerformed(evt);
            }
        });

        klasseBackBtn.setText("Back");
        klasseBackBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                klasseBackBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout klassenPanelLayout = new javax.swing.GroupLayout(klassenPanel);
        klassenPanel.setLayout(klassenPanelLayout);
        klassenPanelLayout.setHorizontalGroup(
            klassenPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(klassenPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(klassenPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(klassenPanelLayout.createSequentialGroup()
                        .addComponent(cancelBtnKlasse)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(klasseBackBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(finishBtnKlasse))
                    .addGroup(klassenPanelLayout.createSequentialGroup()
                        .addGroup(klassenPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(klassenPanelLayout.createSequentialGroup()
                                .addComponent(tierischRadioBtn)
                                .addGap(18, 18, 18)
                                .addComponent(vegetarischRadioBtn)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(veganRadioBtn))
                            .addComponent(klassenLabel))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        klassenPanelLayout.setVerticalGroup(
            klassenPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(klassenPanelLayout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addComponent(klassenLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(56, 56, 56)
                .addGroup(klassenPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tierischRadioBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(vegetarischRadioBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(veganRadioBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(klassenPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cancelBtnKlasse, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(finishBtnKlasse, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(klasseBackBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(69, 69, 69))
        );

        parentPanel.add(klassenPanel, "card4");

        getContentPane().add(parentPanel, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cancelBtnBezActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelBtnBezActionPerformed
        this.dispose();
    }//GEN-LAST:event_cancelBtnBezActionPerformed

    private void nextBtnBezActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nextBtnBezActionPerformed
        if (bezTextField.getText().matches("[ A-Za-z]*") || bezTextField.getText().length() != 0) {
            parentPanel.removeAll();
            parentPanel.add(preisPanel);
            parentPanel.revalidate();
            parentPanel.repaint();

        } else {

            JOptionPane.showMessageDialog(parentPanel, "Bitte geben Sie eine aus Buchstaben bestehende Zeichenkette ein!", "Warning", JOptionPane.OK_OPTION);
        }
    }//GEN-LAST:event_nextBtnBezActionPerformed

    private void cancelBtnPreisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelBtnPreisActionPerformed
        this.dispose();
    }//GEN-LAST:event_cancelBtnPreisActionPerformed

    private void nextBtnPreisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nextBtnPreisActionPerformed
        df.setRoundingMode(RoundingMode.FLOOR);
        try {
            String eingabe = preisTextField.getText();
            if (eingabe.contains(",")) {
                eingabe = eingabe.replaceAll(",", ".");
            }
            preis = Double.parseDouble(eingabe);
            eingabe = df.format(preis);
            eingabe = eingabe.replaceAll(",", ".");
            preis = Double.parseDouble(eingabe);
            System.out.println(preis);
            if (preis <= 0) {
                JOptionPane.showMessageDialog(parentPanel, "Bitte geben Sie eine Zahl ein, die größer als Null ist!", "Warning", JOptionPane.OK_OPTION);
            } else {
                parentPanel.removeAll();
                parentPanel.add(klassenPanel);
                parentPanel.revalidate();
                parentPanel.repaint();
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(parentPanel, "Bitte geben Sie eine Zahl ein! Sie muss außerdem größer 0 sein.", "Warning", JOptionPane.OK_OPTION);
        }
    }//GEN-LAST:event_nextBtnPreisActionPerformed

    private void preisBackBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_preisBackBtnActionPerformed
        parentPanel.removeAll();
        parentPanel.add(bezPanel);
        parentPanel.revalidate();
        parentPanel.repaint();
    }//GEN-LAST:event_preisBackBtnActionPerformed

    private void tierischRadioBtnItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_tierischRadioBtnItemStateChanged
        if (tierischRadioBtn.isSelected() == true) {
            klasse = 1;
        }
    }//GEN-LAST:event_tierischRadioBtnItemStateChanged

    private void vegetarischRadioBtnItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_vegetarischRadioBtnItemStateChanged
        if (vegetarischRadioBtn.isSelected() == true) {
            klasse = 2;
        }
    }//GEN-LAST:event_vegetarischRadioBtnItemStateChanged

    private void veganRadioBtnStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_veganRadioBtnStateChanged
        if (veganRadioBtn.isSelected() == true) {
            klasse = 3;
        }
    }//GEN-LAST:event_veganRadioBtnStateChanged

    private void cancelBtnKlasseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelBtnKlasseActionPerformed
        this.dispose();
    }//GEN-LAST:event_cancelBtnKlasseActionPerformed

    private void finishBtnKlasseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_finishBtnKlasseActionPerformed
        bezeichnung = bezTextField.getText();

        ProduktController.produktAnlegen(bezeichnung, preis, klasse);
        if (JOptionPane.YES_OPTION == JOptionPane.showConfirmDialog(parentPanel, "Wollen Sie ein weiteres Produkt hinzufügen?", "Weiteres Produkt", JOptionPane.YES_NO_OPTION)) {
            bezTextField.setText("Bezeichnung");
            preisTextField.setText("1.00");
            parentPanel.removeAll();
            parentPanel.add(bezPanel);
            parentPanel.revalidate();
            parentPanel.repaint();
            MainFrame.produktListeAktualisieren();
        } else {
            MainFrame.produktListeAktualisieren();
            this.dispose();
        }
    }//GEN-LAST:event_finishBtnKlasseActionPerformed

    private void klasseBackBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_klasseBackBtnActionPerformed
        parentPanel.removeAll();
        parentPanel.add(preisPanel);
        parentPanel.revalidate();
        parentPanel.repaint();
    }//GEN-LAST:event_klasseBackBtnActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel bezPanel;
    private javax.swing.JTextField bezTextField;
    private javax.swing.JButton cancelBtnBez;
    private javax.swing.JButton cancelBtnKlasse;
    private javax.swing.JButton cancelBtnPreis;
    private javax.swing.JButton finishBtnKlasse;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JButton klasseBackBtn;
    private javax.swing.JLabel klassenLabel;
    private javax.swing.JPanel klassenPanel;
    private javax.swing.JButton nextBtnBez;
    private javax.swing.JButton nextBtnPreis;
    private javax.swing.JPanel parentPanel;
    private javax.swing.JButton preisBackBtn;
    private javax.swing.JLabel preisLabel;
    private javax.swing.JPanel preisPanel;
    private javax.swing.JTextField preisTextField;
    private javax.swing.JRadioButton tierischRadioBtn;
    private javax.swing.JRadioButton veganRadioBtn;
    private javax.swing.JRadioButton vegetarischRadioBtn;
    // End of variables declaration//GEN-END:variables
}