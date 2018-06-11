/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package InterfaceVisual;

import Classes.Classes;
import javax.swing.JOptionPane;
import NetGames.Time;
import coliseumrpg.ColiseumRPG;
import javafx.geometry.Dimension2D;

/**
 *
 * @author Matheus
 */
public class ControladorTelas {

    private Janela janela;
    private MenuInicial menuInicial;
    private TelaEmJogo telaEmJogo;
    private TelaFimDeJogo TelaFimDeJogo;

    private static final ControladorTelas instance = new ControladorTelas();

    public static ControladorTelas getInstance() {
        return instance;
    }

    private ControladorTelas() {
        janela = new Janela();
        telaEmJogo = new TelaEmJogo();
        menuInicial = new MenuInicial();
        TelaFimDeJogo = new TelaFimDeJogo();
    }

    public void abrirTelaInicial() {
        janela.setContentPane(menuInicial);
        janela.setVisible(true);
    }

    public void abrirTelaEmJogo() {
        janela.setContentPane(telaEmJogo);
        janela.setVisible(true);
    }

    public static void errorDialog(String mensagem) {
        JOptionPane.showMessageDialog(getInstance().janela, mensagem, "Mensagem de Erro", JOptionPane.ERROR_MESSAGE);
    }

    void começar(Time time, Classes class1, Classes class2) {
        ColiseumRPG.getInstance().comecar(time, class1, class2);
    }

    void mover(Dimension2D destino) {
        try {
            ColiseumRPG.getInstance().mover(destino);
        } catch (RuntimeException e) {
            errorDialog(e.getMessage());
        }
    }

    void atacar(Dimension2D destino) {
        try {
            ColiseumRPG.getInstance().atacar(destino);
        } catch (RuntimeException e) {
            errorDialog(e.getMessage());
        }
    }

}
