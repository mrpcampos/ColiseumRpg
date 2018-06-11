/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes.Cacador;

import NetGames.Time;
import Poderes.TipoDePoderes.Colocavel;
import coliseumrpg.Personagem;

/**
 *
 * @author Matheus
 */
public class Armadilha implements Colocavel {
    
    private final int dano;
    
    private boolean estaFuncional;
    private final Time time;
    
    public Armadilha(Time time) {
        this.dano = 2;
        this.time=time;
        this.estaFuncional=true;
    }
    
    
    @Override
    public void destruir(){
        this.estaFuncional=false;
    }
    
    /**
     * Método para ser chamado quando um personagem pisar na armadilha
     * 
     * @param p personagem que esta pisando na armadilha
     */
    @Override
    public void pisar(Personagem p){
        if(p.getTime()==time){
            return;
        }
        destruir();
        p.receberDano(dano);
    }

    @Override
    public Time getTime() {
        return this.time;
    }

    public boolean estaFuncional() {
        return estaFuncional;
    }
    
}
