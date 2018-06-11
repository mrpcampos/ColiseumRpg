package NetGames;

import Mapa.Lugar;
import br.ufsc.inf.leobr.cliente.Jogada;
import coliseumrpg.Personagem;
import coliseumrpg.Turno;
import java.util.Collection;
import java.util.HashMap;
import javafx.geometry.Dimension2D;

public class Ato implements Jogada{
    protected final Turno turno;
    protected final Personagem[][] personagens;
    protected final HashMap<Personagem, Dimension2D> novaPosicoesPersonagens;
    protected final HashMap<Dimension2D, Lugar> alteracoesMapa;

    public Ato(Turno turno, HashMap<Personagem, Dimension2D> novaPosicoesPersonagens, HashMap<Dimension2D, Lugar> alteracoesMapa, Personagem[][] personagens) {
        this.turno = turno;
        this.alteracoesMapa = alteracoesMapa;
        this.novaPosicoesPersonagens=novaPosicoesPersonagens;
        this.personagens = personagens;
    }

    public Turno getTurno() {
        return turno;
    }

    public HashMap<Dimension2D, Lugar> getAlteracoesMapa() {
        return alteracoesMapa;
    }

    public Personagem[][] getPersonagens() {
        return personagens;
    }

    public HashMap<Personagem, Dimension2D> getNovaPosicoesPersonagens() {
        return novaPosicoesPersonagens;
    }

}