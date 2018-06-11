/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes.Cacador;

import coliseumrpg.Personagem;
import Poderes.TipoDePoderes.AutoModificacao;
import Poderes.Poder;

/**
 *
 * @author Matheus
 */
public class Adaptavel extends Poder implements AutoModificacao{

    public Adaptavel() {
        super("Adaptável", "Graças a seus anos de experiência em caça ele é capaz de lutar tanto com sua adaga que causa 2 de dano, tanto com seu arco que casa um de dano.");
    }

    @Override
    public void usar(Personagem personagem) {
            if (personagem.getAlcance() == 1) {
                personagem.setAlcance(3);
                personagem.setDano(1);
            }else {
                personagem.setAlcance(1);
                personagem.setDano(2);
            }
        }
    
}
