/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes.Cacador;

import Erros.SemMaisArmadilhasException;
import NetGames.Time;
import coliseumrpg.Personagem;
import Poderes.TiposDeAlvo.Poder;

/**
 *
 * @author Matheus
 */
public class Cacador extends Personagem {

    public Cacador(Time time) {
        super(8, 3, 3, 1, time);
        this.descricao = "Ágil e sorrateiro ele é habilidoso tanto com a faca quanto com o arco, mas cudiado!/nEle esconde armadilhas mortais";
        poderes = new Poder[2];
        poderes[0] = new Armadilhas(time);
        poderes[1] = new Adaptavel();

    }

}
