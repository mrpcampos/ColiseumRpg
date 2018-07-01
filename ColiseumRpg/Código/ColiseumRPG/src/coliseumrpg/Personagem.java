/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coliseumrpg;

import Classes.Classes;
import NetGames.Time;
import Poderes.Poder;

public abstract class Personagem {

    private final String nome;
    private final String descricao;
    protected Classes classe;

    protected String caminhoIconeVivo;
    protected String caminhoIconeMorto;

    private int vidaMaxima;
    protected int vidaAtual;
    private int velocidadeBase;
    protected int velocidadeAtual;
    protected int dano;
    protected int alcance;
    private Time time;

    protected Poder[] poderes;

    private boolean vivo;
    protected int tempoIncapacitado;

    public Personagem(String nome, String descricao, Classes classe, int vida, int velocidade, int alcance, int dano, Time time, String caminhoIconeVivo, String caminhoIconeMorto) {
        this.nome = nome;
        this.descricao = descricao;
        this.classe = classe;
        this.vidaMaxima = vida;
        this.vidaAtual = vida;
        this.velocidadeBase = velocidade;
        this.velocidadeAtual = velocidade;
        this.alcance = alcance;
        this.dano = dano;

        this.caminhoIconeMorto = caminhoIconeMorto;
        this.caminhoIconeVivo = caminhoIconeVivo;

        this.time = time;
        this.vivo = true;
        this.tempoIncapacitado = 0;
    }

    /**
     * Serve apenas para testar se a classe é a que queremos. Não deve ser
     * utilizada em jogo.
     *
     * @param nome
     * @param descricao
     * @param classe
     */
    public Personagem(String nome, String descricao, Classes classe) {
        this.nome = nome;
        this.descricao = descricao;
        this.classe = classe;
    }

    public void receberDano(int dano) {
        vidaAtual -= dano;
        if (vidaAtual <= 0) {
            declararMorte();
        }
    }

    public int atacar() {
        return this.dano;
    }

    private void declararMorte() {
        vivo = false;
    }

    public boolean estaVivo() {
        return vivo;
    }

    public int getPorcentagemVidaAtual() {
        return (int)(( ((float)vidaAtual) /((float)vidaMaxima) )*100);
    }

    public int getVidaMaxima() {
        return vidaMaxima;
    }

    public Time getTime() {
        return time;
    }

    public Poder[] getPoderes() {
        return poderes;
    }

    public void setTime(Time time) {
        this.time = time;
    }

    public void setDano(int dano) {
        this.dano = dano;
    }

    public void setAlcance(int alcance) {
        this.alcance = alcance;
    }

    public void curar(int cura) {
        vidaAtual += cura;
        if (vidaAtual > vidaMaxima) {
            vidaAtual = vidaMaxima;
        }
    }

    public int getVelocidade() {
        return velocidadeAtual;
    }

    public int getAlcance() {
        return alcance;
    }

    public void incapacitar(int tempoDeIncapacitacao) {
        this.tempoIncapacitado += tempoDeIncapacitacao;
    }

    public void passarTempo() {
        tempoIncapacitado--;
        velocidadeAtual = velocidadeBase;
    }

    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public boolean ehEssaClasse(Classes classeParaTestar) {
        return classeParaTestar.equals(classe);
    }

    public String getIcone() {
        if (estaVivo()) {
            return caminhoIconeVivo;
        }else{
            return this.caminhoIconeMorto;
        }
    }
}
