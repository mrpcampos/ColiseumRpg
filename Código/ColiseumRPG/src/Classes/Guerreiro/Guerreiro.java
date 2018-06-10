/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes.Guerreiro;

import NetGames.Time;
import coliseumrpg.Personagem;

/**
 *
 * @author Matheus
 */
public class Guerreiro extends Personagem{
    
    public Guerreiro(Time time) {
        super(10, 3, 1, 3, time);
        this.descricao="Treinado para batalha e em excelente forma física, "
                + "o guerreiro é extremamente ágil e forte. Possui uma poderosa"
                + " espada capaz de matar seus inimigos com poucos golpes,"
                + " mas terá que alcança-los primeiro.";
    }
    
    public void melhorarVelocidade(){
        velocidadeAtual+=1;
    }
}