/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes.Mago;

import NetGames.Time;
import coliseumrpg.Personagem;
import Poderes.TiposDeAlvo.Poder;

/**
 *
 * @author Matheus
 */
public class Mago extends Personagem{
    protected int mana;

    public Mago(Time time) {
        super(6, 2, 4, 1, time);
        
        this.mana=6;
        
        poderes = new Poder[3];
        
        poderes[0] = new Congelamento();
        poderes[1] = new Cura();
        poderes[2] = new Explosao();
    }
}
