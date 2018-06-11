/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package InterfaceVisual;

import NetGames.Time;
import Classes.Classes;
import java.util.Enumeration;
import java.util.List;
import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.ButtonModel;
import javax.swing.JRadioButton;

public class MenuInicial extends javax.swing.JPanel {

    /**
     * Creates new form MenuInicial
     */

    public MenuInicial() {
        initComponents();
        postInit();
        
    }

    public void postInit() {
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    private void initComponents() {//GEN-BEGIN:initComponents

        radioGroup = new javax.swing.ButtonGroup();
        lblTitulo = new javax.swing.JLabel();
        btnConectar = new javax.swing.JButton();
        lblEscolhaClasse = new javax.swing.JLabel();
        lblEscolhaTime = new javax.swing.JLabel();
        radioPreto = new javax.swing.JRadioButton();
        radioVermelho = new javax.swing.JRadioButton();
        radioAmarelo = new javax.swing.JRadioButton();
        radioAzul = new javax.swing.JRadioButton();
        radioBranco = new javax.swing.JRadioButton();
        labelComoSelecionar = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        listaEscolherClasses = new javax.swing.JList<>();

        setPreferredSize(new java.awt.Dimension(800, 550));

        lblTitulo.setFont(new java.awt.Font("Imprint MT Shadow", 1, 56)); // NOI18N
        lblTitulo.setForeground(new java.awt.Color(255, 51, 51));
        lblTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitulo.setText("ColiseumRPG");
        lblTitulo.setAlignmentX(0.5F);
        lblTitulo.setPreferredSize(new java.awt.Dimension(400, 66));

        btnConectar.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        btnConectar.setText("Jogar");
        btnConectar.setAlignmentX(0.5F);
        btnConectar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConectarActionPerformed(evt);
            }
        });

        lblEscolhaClasse.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lblEscolhaClasse.setText("Escolha duas classes para seus personagens:");
        lblEscolhaClasse.setAlignmentX(0.5F);

        lblEscolhaTime.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lblEscolhaTime.setText("Escolha a cor de seu time:");
        lblEscolhaTime.setAlignmentX(0.5F);

        radioGroup.add(radioPreto);
        radioPreto.setText(Time.PRETO.toString());
        radioPreto.setAlignmentX(0.5F);

        radioGroup.add(radioVermelho);
        radioVermelho.setText(Time.VERMELHO.toString());
        radioVermelho.setAlignmentX(0.5F);

        radioGroup.add(radioAmarelo);
        radioAmarelo.setText(Time.AMARELO.toString());
        radioAmarelo.setAlignmentX(0.5F);

        radioGroup.add(radioAzul);
        radioAzul.setText(Time.AZUL.toString());
        radioAzul.setAlignmentX(0.5F);

        radioGroup.add(radioBranco);
        radioBranco.setText(Time.BRANCO.toString());
        radioBranco.setAlignmentX(0.5F);

        labelComoSelecionar.setText("*Segure ctrl para selecionar duas ao mesmo tempo.");
        labelComoSelecionar.setAlignmentX(0.5F);

        listaEscolherClasses.setModel(new javax.swing.AbstractListModel<String>() {
            Classes[] classes = Classes.values();

            public int getSize() { return classes.length; }
            public String getElementAt(int i) { return classes[i].toString(); }
        });
        jScrollPane1.setViewportView(listaEscolherClasses);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(136, 136, 136)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(labelComoSelecionar)
                        .addComponent(jScrollPane1)
                        .addComponent(lblEscolhaClasse))
                    .addComponent(lblEscolhaTime)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(radioPreto)
                        .addGap(31, 31, 31)
                        .addComponent(radioVermelho)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(radioAmarelo)
                        .addGap(30, 30, 30)
                        .addComponent(radioAzul)
                        .addGap(32, 32, 32)
                        .addComponent(radioBranco)))
                .addGap(136, 136, 136))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(lblTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 440, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(200, 200, 200))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnConectar, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(330, 330, 330))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addComponent(lblTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(48, 48, 48)
                .addComponent(lblEscolhaTime)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(radioPreto)
                    .addComponent(radioVermelho)
                    .addComponent(radioAmarelo)
                    .addComponent(radioAzul)
                    .addComponent(radioBranco))
                .addGap(35, 35, 35)
                .addComponent(lblEscolhaClasse)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(labelComoSelecionar)
                .addGap(18, 18, 18)
                .addComponent(btnConectar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(102, Short.MAX_VALUE))
        );
    }//GEN-END:initComponents

    private void btnConectarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConectarActionPerformed
        if (radioGroup.getSelection() == null) {
            ControladorTelas.errorDialog("Selecione um time para fazer parte.");
            return;
        }
        String selectedButtonText = getSelectedButtonText(radioGroup);
        List<String> selectedIndices = listaEscolherClasses.getSelectedValuesList();
        if (selectedIndices.size() != 2) {
            ControladorTelas.errorDialog("Selecione duas classes para jogar.");
            return;
        }
        ControladorTelas.getInstance().comecar(Time.valueOf(selectedButtonText), Classes.valueOf(selectedIndices.get(0)), Classes.valueOf(selectedIndices.get(1)));
    }//GEN-LAST:event_btnConectarActionPerformed
    
    public String getSelectedButtonText(ButtonGroup buttonGroup) {
        for (Enumeration<AbstractButton> buttons = buttonGroup.getElements(); buttons.hasMoreElements();) {
            AbstractButton button = buttons.nextElement();

            if (button.isSelected()) {
                return button.getText();
            }
        }

        return null;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnConectar;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelComoSelecionar;
    private javax.swing.JLabel lblEscolhaClasse;
    private javax.swing.JLabel lblEscolhaTime;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JList<String> listaEscolherClasses;
    private javax.swing.JRadioButton radioAmarelo;
    private javax.swing.JRadioButton radioAzul;
    private javax.swing.JRadioButton radioBranco;
    private javax.swing.ButtonGroup radioGroup;
    private javax.swing.JRadioButton radioPreto;
    private javax.swing.JRadioButton radioVermelho;
    // End of variables declaration//GEN-END:variables
}
