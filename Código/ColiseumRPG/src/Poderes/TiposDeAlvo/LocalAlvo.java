/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Poderes.TiposDeAlvo;

import Mapa.Lugar;

public interface LocalAlvo{
    public void usar(Lugar lugar);
    public int getAlcance();
}
