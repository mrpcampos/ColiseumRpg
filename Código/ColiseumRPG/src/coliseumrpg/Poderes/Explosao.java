/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coliseumrpg.Poderes;

import coliseumrpg.Poderes.TiposDeAlvo.Magia;
import Mapa.Lugar;

/**
 *
 * @author Matheus
 */
public class Explosao extends Magia{
    private final int dano;

    public Explosao(int custo, int dano) {
        super(custo);
        this.dano = dano;
    }
    
    
    @Override
    public void usar(int distancia, Lugar alvo) {
        alvo.getPersonagem().receberDano(dano);
        alvo.destruir();
    }
    
}
