/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Poderes;

import NetGames.Time;
import Poderes.TipoDePoderes.Colocavel;
import coliseumrpg.Personagem;

/**
 *
 * @author Matheus
 */
public class Armadilha implements Colocavel {

    private final int dano;

    private String icon = "../resources/Armadilha.png";
    private boolean estaFuncional;
    private final Time time;

    public Armadilha(Time time) {
        this.dano = 2;
        this.time = time;
        this.estaFuncional = true;
    }

    @Override
    public void destruir() {
        this.estaFuncional = false;
    }

    /**
     * Método para ser chamado quando um personagem pisar na armadilha
     *
     * @param p personagem que esta pisando na armadilha
     */
    @Override
    public void pisar(Personagem p) {
        if (p.getTime() == time) {
            return;
        }
        destruir();
        p.receberDano(dano);
        if(p.estaVivo()){
            icon = "../resources/ArmadilhaPressionada.png";
        }else{
            icon = "../resources/ArmadilhaPressionadaComPe.png";
        }
        
    }

    @Override
    public Time getTime() {
        return this.time;
    }

    @Override
    public boolean estaFuncional() {
        return estaFuncional;
    }
    
    @Override
    public Boolean visivelPeloInimigo(){
        return false;
    }

    @Override
    public String getIcon() {
        return this.icon;
    }

}
