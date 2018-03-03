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
    int quantidade;

    @Override
    public void usar(int distancia, Lugar alvo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
