/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes.Mago;

import Mapa.Lugar;

/**
 *
 * @author Matheus
 */
public class Explosao extends Magia{
    private final int dano;

    public Explosao() {
        super("Explosão",
                "Causa uma poderosa explosão de chamas no local,"
                        + " causando bastante dano e destruindo"
                        + " qualquer objeto no quadrante."
                , 3, 3);
        this.dano = 3;
    }
    
    
    @Override
    public void usar(Lugar alvo) {
        //TODO verificação de distância e de custo de mana
        alvo.getPersonagem().receberDano(dano);
        alvo.destruir();
    }

}
