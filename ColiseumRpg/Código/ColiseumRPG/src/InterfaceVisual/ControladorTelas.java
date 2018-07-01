package InterfaceVisual;

import Classes.Classes;
import NetGames.Ato;
import javax.swing.JOptionPane;
import NetGames.Time;
import Poderes.Poder;
import Poderes.TipoDePoderes.PoderAutoModificacao;
import Poderes.TipoDePoderes.PoderLocalAlvo;
import coliseumrpg.ColiseumRPG;
import coliseumrpg.Turno;
import javafx.geometry.Dimension2D;

public class ControladorTelas {

    private final Janela janela;
    private final MenuInicial menuInicial;
    private final TelaEmJogo telaEmJogo;
    private final TelaFimDeJogo telaFimDeJogo;

    private static final ControladorTelas instance = new ControladorTelas();

    public static ControladorTelas getInstance() {
        return instance;
    }

    private ControladorTelas() {
        janela = new Janela();
        telaEmJogo = new TelaEmJogo();
        menuInicial = new MenuInicial();
        telaFimDeJogo = new TelaFimDeJogo();
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

    void passarVez() {
        try {
            ColiseumRPG.getInstance().passarVez();
        } catch (RuntimeException err) {
            errorDialog(err.getMessage());
        }
    }

    Poder[] getPoderesPersonagemDoTurno() {
        return ColiseumRPG.getInstance().getPoderesPersonagemDoTurno();
    }

    void usarPoderLocalAlvo(PoderLocalAlvo poder, Dimension2D destino) {
        try {
            ColiseumRPG.getInstance().usarPoderLocalAlvo(poder, destino);
        } catch (RuntimeException err) {
            errorDialog(err.getMessage());
        }
    }

    void usarPoderAutoModificacao(PoderAutoModificacao autoModificacao) {
        try {
            ColiseumRPG.getInstance().usarPoderAutoModificacao(autoModificacao);
        } catch (RuntimeException err) {
            errorDialog(err.getMessage());
        }
    }

    void desistir() {
        try {
            ColiseumRPG.getInstance().desistir();
        } catch (RuntimeException err) {
            errorDialog(err.getMessage());
        }
    }

    public void abrirTelaFimDeJogo() {
        janela.setContentPane(telaFimDeJogo);
    }

    public void mostrarResultadoAto(Ato ato) {
        telaEmJogo.atualizaTela(ato);
    }

    public void mostrarNovoTurno(Turno turno) {
        telaEmJogo.atualizaTurno(turno);
    }

    public void setClassesJogadores(String pers1Jog1, String pers2Jog1, String pers1Jog2, String pers2Jog2) {
        telaEmJogo.setClassesPersonagensJogadores(pers1Jog1, pers2Jog1, pers1Jog2,pers2Jog2);
    }
}
