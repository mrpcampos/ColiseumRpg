/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coliseumrpg.Poderes;

import coliseumrpg.Poderes.TiposDeAlvo.Poder;
import coliseumrpg.Poderes.TiposDeAlvo.AutoModificacao;
import coliseumrpg.Personagem;

/**
 *
 * @author Matheus
 */
public class Adaptavel extends Poder implements AutoModificacao{

    @Override
    public void usar(Personagem utilizador){
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
