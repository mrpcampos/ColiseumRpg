/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coliseumrpg;

import Classes.Cacador.Cacador;
import Classes.Classes;
import static Classes.Classes.Guerreiro;
import Classes.Guerreiro.Guerreiro;
import Classes.Mago.Mago;
import Erros.ErroTolo;
import NetGames.ControladorNetGames;
import InterfaceVisual.ControladorTelas;
import Mapa.Mapa;
import NetGames.Ato;
import NetGames.Jogador;
import NetGames.Time;
import Poderes.Poder;
import Poderes.TipoDePoderes.AutoModificacao;
import Poderes.TipoDePoderes.LocalAlvo;
import javafx.geometry.Dimension2D;

/**
 *
 * @author Matheus
 */
public class ColiseumRPG {

    protected static final ColiseumRPG instance = new ColiseumRPG();
    protected ControladorTelas controladorTelas;
    protected Jogador jogadores[];
    protected Turno turno;
    protected Mapa mapa;

    private ColiseumRPG() {
        controladorTelas = ControladorTelas.getInstance();
        jogadores = new Jogador[2];
    }

    /**
     *
     * @param time ao qual o jogador a ser criado deve pertencer
     * @param p1
     * @param p2
     */
    public void comecar(Time time, Classes p1, Classes p2) {
        jogadores[0] = new Jogador(time, criarPersonagem(p1, time), criarPersonagem(p2, time));
        ControladorNetGames.getInstance().conectar("localhost", time);
    }

    public static void main(String[] args) {
        ControladorTelas.getInstance().abrirTelaInicial();
    }

    private Personagem criarPersonagem(Classes classe, Time time) {
        if (new Cacador().ehEssaClasse(classe)) {
            return new Cacador(time);
        }
        if (new Guerreiro().ehEssaClasse(classe)) {
            return new Guerreiro(time);
        }
        if (new Mago().ehEssaClasse(classe)) {
            return new Mago(time);
        }
        throw new UnsupportedOperationException("A classe deve ser adicionada na lista criar Personagem na classe ColiseumRPG e no enum Classes");
    }

    public void tratarJogada(Ato ato) {
        mapa.atualizar(ato.getAlteracoesMapa(), ato.getNovaPosicoesPersonagens());
        this.turno = ato.getTurno();
        for (int i = 0; i < 2; i++) {
            jogadores[i].setPersonagens(ato.getPersonagens()[i]);
        }
        if (!turno.isTurnoAtivo()) {
            passarVez();
        }
    }

    public void enviarJogada() {
        ControladorNetGames.getInstance().enviarJogada(new Ato(turno, mapa.getPosicoesPersonagens(), mapa.getAlteracoesAndReset(), getPersonagensEstadoAtual()));
    }

    public void passarVez() {
        turno.encerrar();
        Time timeDaVez = turno.getTime();
        if (timeDaVez == jogadores[0].getTime()) {
            turno = jogadores[1].tomarVez();
        } else {
            turno = jogadores[0].tomarVez();
        }
        enviarJogada();
    }

    private Personagem[][] getPersonagensEstadoAtual() {
        Personagem[][] personagensAtualmente = new Personagem[2][2];
        //Perceba que invertemos a ordem pois no outro lado os arrays de jogadores estão invertidos
        personagensAtualmente[0] = jogadores[1].getPersonagens();
        personagensAtualmente[1] = jogadores[0].getPersonagens();

        return personagensAtualmente;
    }

    public static ColiseumRPG getInstance() {
        return instance;
    }

    public void iniciarPartida(boolean minhaVez) {
        if (minhaVez) {
            Personagem per1 = jogadores[0].getPersonagens()[0];
            Personagem per2 = jogadores[0].getPersonagens()[1];
            mapa = new Mapa(per1, per2);
            turno = jogadores[0].tomarVez();
            passarVez();
        }
    }

    public void pedirInicioDePartida() {
        ControladorNetGames.getInstance().pedirIniciarPartida();
    }

    public void atacar(Dimension2D destino) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void mover(Dimension2D destino) {
        mapa.andar(turno.getPersonagem(), destino);
    }

    public Poder[] getPoderesPersonagemDoTurno() {
        return turno.getPersonagem().getPoderes();
    }

    public void usarPoderLocalAlvo(LocalAlvo poder, Dimension2D destino) {
        mapa.poderLocalAlvo(mapa.getPosicaoPersonagem(turno.getPersonagem()), poder, destino);
    }

    public void usarPoderAutoModificacao(AutoModificacao autoModificacao) {
        autoModificacao.usar(turno.getPersonagem());
    }
}
