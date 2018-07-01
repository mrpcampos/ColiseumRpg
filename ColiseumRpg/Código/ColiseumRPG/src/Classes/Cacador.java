/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import Classes.Classes;
import NetGames.Time;
import Poderes.Adaptavel;
import Poderes.Armadilhas;
import coliseumrpg.Personagem;
import Poderes.Poder;
import javax.swing.ImageIcon;

/**
 *
 * @author Matheus
 */
public class Cacador extends Personagem {

    public Cacador(Time time) {
        super("Caçador",
                "Ágil e sorrateiro ele é habilidoso tanto com a faca"
                + " quanto com o arco.\nCuidado onde pisa, "
                + "ele esconde armadilhas mortais!", Classes.Cacador,
                8, 3, 3, 1, time, "../resources/Cacador.png", "../resources/CacadorMorto.png");
        poderes = new Poder[2];
        poderes[0] = new Armadilhas(time);
        poderes[1] = new Adaptavel();

    }

    public Cacador() {
        super("Caçador",
                "Ágil e sorrateiro ele é habilidoso tanto com a faca"
                + " quanto com o arco.\nCuidado onde pisa, "
                + "ele esconde armadilhas mortais!", Classes.Cacador);
    }

}
