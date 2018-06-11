/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes.Guerreiro;

import Classes.Classes;
import NetGames.Time;
import coliseumrpg.Personagem;

/**
 *
 * @author Matheus
 */
public class Guerreiro extends Personagem{

    private Guerreiro(int vida, int velocidade, int alcance, int dano, Time time) {
        super("Guerreiro", "Treinado para batalha e em excelente forma física, "
                + "o guerreiro é extremamente ágil e forte. Possui uma poderosa"
                + " espada capaz de matar seus inimigos com poucos golpes,"
                + " mas terá que alcança-los primeiro.", Classes.Guerreiro, 
                vida, velocidade, alcance, dano, time);
    }
    public Guerreiro(Time time) {
        this(10, 3, 1, 3, time);
    }

    public Guerreiro() {
        super("Guerreiro", "Treinado para batalha e em excelente forma física, "
                + "o guerreiro é extremamente ágil e forte. Possui uma poderosa"
                + " espada capaz de matar seus inimigos com poucos golpes,"
                + " mas terá que alcança-los primeiro.", Classes.Guerreiro);
    }
    
    
    
    public void melhorarVelocidade(){
        velocidadeAtual+=1;
    }
}