/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coliseumrpg.Poderes;

import coliseumrpg.Poderes.TiposDeAlvo.Poder;
import coliseumrpg.Poderes.TiposDeAlvo.LocalAlvo;
import Mapa.Lugar;

/**
 *
 * @author Matheus
 */
public class Armadilha extends Poder implements LocalAlvo{
    protected int quantidade;
    protected int alcance;

    public Armadilha(int quantidade, int alcance) {
        this.quantidade = quantidade;
        this.alcance = alcance;
    }
    
    
    
    @Override
    public void usar(int distancia, Lugar alvo) {
        if(distancia<=alcance){
            alvo.colocar(c);
        }
    }
}
