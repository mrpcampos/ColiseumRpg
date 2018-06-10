/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package InterfaceVisual;

/**
 *
 * @author Matheus
 */
public class ControladorTelas {

    
    Janela janela;
    MenuInicial menuInicial;
    TelaEmJogo telaEmJogo;
    TelaFimDeJogo TelaFimDeJogo;
    
    private static ControladorTelas instance;
    
    public static ControladorTelas getInstance() {
        return instance;
    }
    
    private ControladorTelas() {
        janela = new Janela();
        telaEmJogo = new TelaEmJogo();
        menuInicial= new MenuInicial();
        TelaFimDeJogo = new TelaFimDeJogo();
        
    }

    public void abrirTelaInicial() {
        janela.setContentPane(menuInicial);
        janela.setVisible(true);
    }
    
    
}
