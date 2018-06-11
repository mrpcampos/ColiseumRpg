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

    public Congelamento(Mago caster){
        super("Congelamento"
                , "Criando cristais de gelo ao redor de seu inimigo,"
                        + " o mago é capaz de imobiliza-lo por uma rodada."
                , 1, 2, caster);
    }

    @Override
    public void usar(Lugar alvo) {
        temManaSuficiente(caster);
        if(alvo.getPersonagem()!=null){
            alvo.getPersonagem().incapacitar(1);
            caster.gastarMana(custo);
        }else{
            throw new NenhumPersonagemNoQuadranteException();
        }
    }
}
