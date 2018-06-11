package InterfaceVisual;

import Classes.Classes;
import javax.swing.JOptionPane;
import NetGames.Time;
import Poderes.Poder;
import Poderes.TipoDePoderes.AutoModificacao;
import Poderes.TipoDePoderes.LocalAlvo;
import coliseumrpg.ColiseumRPG;
import javafx.geometry.Dimension2D;

public class ControladorTelas {

    private final Janela janela;
    private final MenuInicial menuInicial;
    private final TelaEmJogo telaEmJogo;
    private final TelaFimDeJogo TelaFimDeJogo;

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

    void comecar(Time time, Classes class1, Classes class2) {
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

    public Poder[] getPoderesPersonagemDoTurno() {
        return ColiseumRPG.getInstance().getPoderesPersonagemDoTurno();
    }

    public void usarPoderLocalAlvo(LocalAlvo poder, Dimension2D destino) {
        try{
            ColiseumRPG.getInstance().usarPoderLocalAlvo(poder, destino);
        }catch(RuntimeException err){
            errorDialog(err.getMessage());
        }
    }

    void usarPoderAutoModificacao(AutoModificacao autoModificacao) {
        try{
            ColiseumRPG.getInstance().usarPoderAutoModificacao(autoModificacao);
        }catch(RuntimeException err){
            errorDialog(err.getMessage());
        }
    }

}
