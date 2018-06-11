/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Poderes.TipoDePoderes;

import NetGames.Time;
import coliseumrpg.Personagem;

/**
 *
 * @author Matheus
 */
public interface Colocavel {
    public void destruir();
    public Time getTime();
    public void pisar(Personagem p);
}