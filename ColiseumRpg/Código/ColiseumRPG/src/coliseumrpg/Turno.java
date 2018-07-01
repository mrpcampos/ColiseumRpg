package coliseumrpg;

import Erros.SemRecursoParaAtoException;
import NetGames.Time;
import Poderes.TipoDePoderes.Custo;
import java.util.HashMap;

/**
 *
 * @author Matheus
 */
public class Turno {

    private final Time time;
    private final Personagem personagem;
    private HashMap<Custo, Boolean> atos;
    private boolean turnoAtivo;

    public Turno(Time time, Personagem personagem) {
        this.personagem = personagem;
        this.time = time;
        atos.put(Custo.AtoMenor, true);
        atos.put(Custo.AtoMaior, true);
        this.turnoAtivo = true;
    }

    public Time getTime() {
        return time;
    }

    public Personagem getPersonagem() {
        return personagem;
    }

    public void usar(Custo custo) {
        if (has(custo)) {
            atos.put(custo, false);
        } else {
            throw new SemRecursoParaAtoException("Você ja gastou seu " + custo.toString() + " nesse turno.");
        }
    }

    public boolean isTurnoAtivo() {
        return turnoAtivo;
    }

    public void encerrar() {
        if (isTurnoAtivo()) {
            personagem.passarTempo();
        }
        turnoAtivo = false;
    }

    public boolean has(Custo custo) {
        return atos.get(custo);
    }

}
