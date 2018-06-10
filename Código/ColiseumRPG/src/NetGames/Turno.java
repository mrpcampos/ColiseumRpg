/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NetGames;

import coliseumrpg.Personagem;

/**
 *
 * @author Matheus
 */
public class Turno {
    private final Jogador jogador;
    private final Personagem personagem;
    private boolean AtoMaior;
    private boolean AtoMenor;
    private boolean turnoAtivo;

    public Turno(Jogador jogador, Personagem personagem) {
        this.personagem = personagem;
        this.jogador = jogador;
        this.AtoMaior = true;
        this.AtoMenor = true;
        this.turnoAtivo = true;
    }

    public Jogador getJogador() {
        return jogador;
    }

    public Personagem getPersonagem() {
        return personagem;
    }

    public boolean hasAtoMaior() {
        return AtoMaior;
    }

    public boolean hasAtoMenor() {
        return AtoMenor;
    }
    
    public void usarAtoMaior(){
        this.AtoMaior=false;
    }
    
    public void usarAtoMenor(){
        this.AtoMenor=false;
    }

    public boolean isTurnoAtivo() {
        return turnoAtivo;
    }

    void encerrar() {
        turnoAtivo=false;
    }
    
}
