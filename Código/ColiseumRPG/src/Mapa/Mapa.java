/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Mapa;

import Erros.ErroTolo;
import Erros.ForaDoAlcanceException;
import Erros.UmPassoDeCadaVezException;
import NetGames.Time;
import coliseumrpg.Personagem;
import java.util.HashMap;
import javafx.geometry.Dimension2D;

/**
 *
 * @author Matheus
 */
public class Mapa {

    private final HashMap<Time, Personagem> personagens;

    private HashMap<Personagem, Dimension2D> posicoesPersonagens;
    protected Lugar mapa[][];

    public Mapa(Personagem pers1Jog1, Personagem pers2Jog1, Personagem pers1Jog2, Personagem pers2Jog2) {
        this.personagens = new HashMap<>();
        this.posicoesPersonagens = new HashMap<>();

        personagens.put(pers1Jog1.getTime(), pers1Jog1);
        personagens.put(pers1Jog2.getTime(), pers1Jog2);
        personagens.put(pers2Jog1.getTime(), pers2Jog1);
        personagens.put(pers2Jog2.getTime(), pers2Jog2);

        this.mapa = new Lugar[20][12];
        for (int i = 0; i < mapa.length; i++) {
            for (int j = 0; j < mapa[i].length; j++) {
                mapa[i][j] = new Lugar();
            }
        }

        posicionarPersonagem(pers1Jog1, new Dimension2D(1, 4));
        posicionarPersonagem(pers1Jog2, new Dimension2D(1, 8));
        posicionarPersonagem(pers2Jog1, new Dimension2D(18, 4));
        posicionarPersonagem(pers2Jog2, new Dimension2D(18, 8));
    }

    /**
     * Limite de velocidade igual a 4 para manter o código de calculo de rota
     * simples
     *
     * @param p personagem que esta tentando se mover
     * @param destino local para onde o personagem deve se mover
     * @return numero de quadrantes que essa movimentação gastou
     */
    public int andar(Personagem p, Dimension2D destino) {
        int distancia = calculaDistancia(getPosicaoPersonagem(p), destino);
        if (p.getVelocidade() <= distancia) {
            switch (distancia) {
                case 1:
                    getTarget(destino).ocupar(p);
                    break;
                case 0:
                    throw new ErroTolo("Você acabou de tentar andar para o lugar onde ja estava...\nPor que??");
                default:
                    throw new UmPassoDeCadaVezException("Voce deve andar um quadrante por vez, para poder escolher seu caminho.");
            }
        }
        throw new ForaDoAlcanceException("O personagem não tem movimetação sobrando para andar tão longe.");
    }

    private void posicionarPersonagem(Personagem personagem, Dimension2D dimension2D) {
        Lugar destino = getTarget(dimension2D);
        Lugar origem = getTarget(posicoesPersonagens.get(personagem));
        if (origem != null) {
            origem.desocupar();
        }
        destino.ocupar(personagem);
        posicoesPersonagens.put(personagem, dimension2D);
    }

    public Dimension2D getPosicaoPersonagem(Personagem p) {
        return posicoesPersonagens.get(p);
    }

    private int calculaDistancia(Dimension2D origem, Dimension2D destino) {
        int distanciaVertical = Math.abs((int) origem.getHeight() - (int) destino.getHeight());
        int distanciaHorizontal = Math.abs((int) origem.getWidth() - (int) destino.getWidth());
        return distanciaHorizontal + distanciaVertical;
    }

    public Lugar getTarget(Dimension2D d) {
        return mapa[(int) d.getWidth()][(int) d.getHeight()];
    }

}
