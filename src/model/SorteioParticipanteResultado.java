package model;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author marcio
 */
public class SorteioParticipanteResultado {
    private int id;
    private int id_participante_de;
    private int id_participante_para;
    private int id_sorteio;
    private Sorteio sorteio;
    private Participante participante_de;
    private Participante participante_para;
    
    public void setId(int id) {
        this.id = id;
    }
    
    public void setIdParticipanteDe(int id) {
        this.id_participante_de = id;
    }
    
    public void setIdParticipantePara(int id) {
        this.id_participante_de = id;
    }
    
    public void setIdSorteio(int id) {
        this.id_sorteio = id;
    }
    
    public void setSorteio(Sorteio sorteio) {
        this.sorteio = sorteio;
    }
    
    public void setParticipanteDe(Participante participante) {
        this.participante_de = participante;
    }
    
    public void setParticipantePara(Participante participante) {
        this.participante_para = participante;
    }
    
    public int getId() {
        return this.id;
    }
    
    public int getIdParticipanteDe() {
        return this.id_participante_de;
    }
    
    public int getIdParticipantePara() {
        return this.id_participante_para;
    }
    
    public int getIdSorteio() {
        return this.id_sorteio;
    }
    
    public Sorteio getSorteio() {
        return this.sorteio;
    }
    
    public Participante getParticipanteDe() {
        return this.participante_de;
    }
    
    public Participante getParticipantePara() {
        return this.participante_para;
    }
}
