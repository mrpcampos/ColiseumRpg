/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coliseumrpg;

import Classes.Cacador;
import Classes.Classes;
import Classes.Guerreiro;
import Classes.Mago;
import Erros.ErroTolo;
import Erros.ForaDoAlcanceException;
import Erros.SemRecursoParaAtoException;
import NetGames.ControladorNetGames;
import InterfaceVisual.ControladorTelas;
import Mapa.Mapa;
import NetGames.Ato;
import NetGames.Jogador;
import NetGames.Time;
import Poderes.Poder;
import Poderes.TipoDePoderes.PoderAutoModificacao;
import Poderes.TipoDePoderes.Custo;
import Poderes.TipoDePoderes.PoderLocalAlvo;
import java.util.logging.Level;
import java.util.logging.Logger;
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
        jogadores = new Jogador[2]; //Por definição o jogadores[0] sempre será o da instância do jogo
    }                               //e o jogadores[1] o adversário

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
        throw new UnsupportedOperationException("A classe selecionada: " + classe + " deve ser adicionada na lista criar Personagem na classe ColiseumRPG.");
    }

    /**
     * Atualiza o jogo local com as ações do adversário, algumas coisas são
     * requeridas para que funcine normalmente: -Cada jogo local considera que o
     * jogador 0 é o seu, esse método deve receber ja na ordem certa, com
     * personagens[0] sendo o seu e personagens[1] do advesário -O time inimigo
     * deve sempre ser o preto e o aliado da cor que o jogador escolheu, para
     * evitar colisões.
     *
     * @param ato As alterações feitas na ação mais recente do turno inimigo
     */
    public void tratarJogada(Ato ato) {

        //Coloca o time dos adversários para preto,
        //assim sempre será diferente do jogador dessa maquina
        ato.getPersonagens()[1][0].setTime(Time.PRETO);
        ato.getPersonagens()[1][1].setTime(Time.PRETO);

        if (jogadores[1] == null) {
            //Se for a primeira jogada desse jogador temos que criar o jogador 
            //inimigo, com os personagens recebidos e o devido time
            //Tambem não atualizamos os personagens desse jogador pois o inimigo
            //não os conhece ainda, por isso os enviou null.
            jogadores[1] = new Jogador(Time.PRETO, ato.getPersonagens()[1][0], ato.getPersonagens()[1][1]);
            if (mapa == null) {
                mapa = new Mapa(jogadores[1].getPersonagens()[0], jogadores[1].getPersonagens()[1]);
                mapa.adicionaPersonagensSegundoAJogar(jogadores[0].getPersonagens()[0], jogadores[0].getPersonagens()[1]);
            } else{
            mapa.adicionaPersonagensSegundoAJogar(jogadores[1].getPersonagens()[0], jogadores[1].getPersonagens()[1]);
            }
            ControladorTelas.getInstance().setClassesJogadores(jogadores[0].getPersonagens()[0].getNome(), jogadores[0].getPersonagens()[2].getNome(), jogadores[1].getPersonagens()[0].getNome(), jogadores[1].getPersonagens()[1].getNome());
        } else {
            //Se não só atualiza os personagens dos dois jogadores
            //Volta os personagens aliados para a cor do jogador dessa
            //maquina, pois foram temporariamente colocados como preto
            //na maquina do adversario
            ato.getPersonagens()[0][0].setTime(jogadores[0].getTime());
            ato.getPersonagens()[0][1].setTime(jogadores[0].getTime());

            //Atualiza os personagens com as alterações
            jogadores[0].setPersonagens(ato.getPersonagens()[0]);
            jogadores[1].setPersonagens(ato.getPersonagens()[1]);
        }

        //Atualiza na tela as mudanças do turno inimigo
        ControladorTelas.getInstance().mostrarResultadoAto(ato);

        //Verifica se alguem perdeu e encerra o jogo se sim
        if (isJogoAcabado()) {
            encerrarJogo();
        } else if (!turno.isTurnoAtivo()) {
            //Se o jogo continua e o turno inimigo tiver encerrado o turno
            //vamos começar o turno do próximo personagem desse jogador
            turno = jogadores[0].tomarVez();

            //Mostra na tela as informações do novo turno
            ControladorTelas.getInstance().mostrarNovoTurno(turno);

            //Envia para o outro jogador o novo turno
            enviarJogada();
        }
    }

    private void enviarJogada() {
        ControladorNetGames.getInstance().enviarJogada(new Ato(turno, mapa.getPosicoesPersonagens(), mapa.getAlteracoesAndReset(), getPersonagensEstadoAtual()));
    }

    private Personagem[][] getPersonagensEstadoAtual() {
        Personagem[][] personagensAtualmente = new Personagem[2][2];
        //Perceba que invertemos a ordem para manter o jogador [0] como o jogador da maquina
        if (jogadores[1] != null) {
            personagensAtualmente[0] = jogadores[1].getPersonagens();
        }

        personagensAtualmente[1] = jogadores[0].getPersonagens();

        return personagensAtualmente;
    }

    public static ColiseumRPG getInstance() {
        return instance;
    }

    public void iniciarPartida(boolean minhaVez) {
        if (minhaVez) {
            mapa = new Mapa(jogadores[0].getPersonagens()[0], jogadores[0].getPersonagens()[1]);
            turno = jogadores[0].tomarVez();
            ControladorTelas.getInstance().abrirTelaEmJogo();
            passarVez();
        }
    }

    public void pedirInicioDePartida() {
        ControladorNetGames.getInstance().pedirIniciarPartida();
    }

    public void atacar(Dimension2D destino) {
        if (!podeAgir()) {
            throw new ErroTolo("Não é sua vez.");
        }
        if (turno.has(Custo.AtoMaior)) {
            mapa.atacar(turno.getPersonagem(), destino);
            turno.usar(Custo.AtoMaior);
        } else {
            throw new SemRecursoParaAtoException("Você ja gastou sua ação maior nesse turno. Não pode mais usar habilidades que consumam esse recurso.");
        }
        if (isJogoAcabado()) {
            encerrarJogo();
        }
    }

    public void mover(Dimension2D destino) {
        if (!podeAgir()) {
            throw new ErroTolo("Não é sua vez.");
        }
        if (turno.getPersonagem().getVelocidade() < 1) {
            throw new ForaDoAlcanceException("O personagem ja andou tudo que podia nesse turno.");
        }
        mapa.andar(turno.getPersonagem(), destino);
        enviarJogada();
        if (isJogoAcabado()) {
            encerrarJogo();
        }
    }

    public void passarVez() {
        if (podeAgir()) {
            turno.encerrar();
            enviarJogada();
        } else {
            throw new ErroTolo("A vez precisa ser sua para passar.");
        }
    }

    public void usarPoderLocalAlvo(PoderLocalAlvo poder, Dimension2D destino) {
        if (!podeAgir()) {
            throw new ErroTolo("Não é sua vez.");
        }
        for (Custo custo : poder.getCustos()) {
            if (!turno.has(custo)) {
                throw new ErroTolo("Sem recurso para o poder.");
            }
        }
        mapa.poderLocalAlvo(mapa.getPosicaoPersonagem(turno.getPersonagem()), poder, destino);
        if (isJogoAcabado()) {
            encerrarJogo();
        }
    }

    public void usarPoderAutoModificacao(PoderAutoModificacao autoModificacao) {
        if (!podeAgir()) {
            throw new ErroTolo("Não é sua vez.");
        }

        for (Custo custo : autoModificacao.getCustos()) {
            if (!turno.has(custo)) {
                throw new SemRecursoParaAtoException("Você ja gastou seu " + custo.toString() + " desse turno.");
            }
        }
        autoModificacao.usar(turno.getPersonagem());
        for (Custo custo : autoModificacao.getCustos()) {
            turno.usar(custo);
        }
    }

    public void desistir() {
        if (podeAgir()) {
            for (Personagem p : jogadores[0].getPersonagens()) {
                p.receberDano(999);
            }
            passarVez();
        } else {
            throw new ErroTolo("Você só pode se render na sua vez");
        }
    }

    private void encerrarJogo() {
        try {
            wait(1500);
        } catch (InterruptedException ex) {
            Logger.getLogger(ColiseumRPG.class.getName()).log(Level.SEVERE, null, ex);
            ControladorTelas.errorDialog("Problema em esperar??\nNão é dono da thread?");
        }
        ControladorNetGames.getInstance().desconectar();
        ControladorTelas.getInstance().abrirTelaFimDeJogo();
    }

    public Poder[] getPoderesPersonagemDoTurno() {
        return turno.getPersonagem().getPoderes();
    }

    public Turno getTurno() {
        return turno;
    }

    private boolean podeAgir() {
        return turno.isTurnoAtivo() && turno.getTime() == jogadores[0].getTime();
    }

    private boolean isJogoAcabado() {
        for (Jogador j : jogadores) {
            boolean personagemUmMorto = false;
            for (Personagem p : j.getPersonagens()) {
                if (p.estaVivo()) {
                    break;
                } else {
                    if (personagemUmMorto) {
                        return true;
                    }
                    personagemUmMorto = true;
                }

            }
        }
        return true;
    }
}
