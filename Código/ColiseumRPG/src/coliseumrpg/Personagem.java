/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coliseumrpg;

import NetGames.Time;
import Poderes.TiposDeAlvo.Poder;

public abstract class Personagem {
    protected String descricao;
    
    private final int vidaMaxima;
    protected int vidaAtual;
    private final int velocidadeBase;
    protected int velocidadeAtual;
    protected int dano;
    protected int alcance;
    private final Time time;
    
    protected Poder [] poderes;
    
    private boolean vivo;
    protected int tempoIncapacitado;
    
    public Personagem(int vida, int velocidade, int alcance, int dano, Time time) {
        this.vidaMaxima = vida;
        this.vidaAtual = vida;
        this.velocidadeBase = velocidade;
        this.velocidadeAtual = velocidade;
        this.alcance = alcance;
        this.dano = dano;
        
        this.time=time;
        this.vivo=true;
        this.tempoIncapacitado = 0;
    }

    public void receberDano(int dano){
        vidaAtual -= dano;
        if(vidaAtual<=0){
            declararMorte();
        }
    }

    public int atacar(){
        return this.dano;
    }

    private void declararMorte(){
        vivo=false;
    }

    public boolean estaVivo() {
        return vivo;
    }

    public int getVidaAtual() {
        return vidaAtual;
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
    
    public void setDano(int dano){
        this.dano=dano;
    }
    
    public void setAlcance(int alcance){
        this.alcance=alcance;
    }

    public void curar(int cura) {
        vidaAtual+=cura;
        if(vidaAtual>vidaMaxima){
            vidaAtual=vidaMaxima;
        }
    }

    public int getVelocidade() {
        return velocidadeAtual;
    }

    public int getDano() {
        return dano;
    }

    public int getAlcance() {
        return alcance;
    }

    public void incapacitar(int tempoDeIncapacitacao) {
        this.tempoIncapacitado += tempoDeIncapacitacao;
    }
    
    public void passarTempo(){
        tempoIncapacitado--;
        velocidadeAtual=velocidadeBase;
    }

}
