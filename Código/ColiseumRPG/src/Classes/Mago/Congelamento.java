/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes.Mago;

import Erros.NenhumPersonagemNoQuadranteException;
import Mapa.Lugar;

/**
 *
 * @author Matheus
 */
public class Congelamento extends Magia{

    public Congelamento(){
        super("Congelamento"
                , "Criando cristais de gelo ao redor de seu inimigo,"
                        + " o mago é capaz de imobiliza-lo por uma rodada."
                , 1, 2);
    }

    @Override
    public void usar(Lugar alvo) {
        //TODO verificação de custo de mana
        if(alvo.getPersonagem()!=null){
            alvo.getPersonagem().incapacitar(1);
        }else{
            throw new NenhumPersonagemNoQuadranteException();
        }
    }
}
