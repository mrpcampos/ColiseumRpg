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
public class Cura extends Magia{
    private int cura;

    public Cura(int custo, int cura) {
        super(custo);
        this.cura = cura;
    }
    
    @Override
    public void usar(int distancia, Lugar alvo) {
        alvo.getPersonagem().curar(cura);
    }
}
