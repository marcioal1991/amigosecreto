package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Participante;
import model.Sorteio;
import model.SorteioParticipante;
import model.SorteioParticipanteResultado;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author marcio
 */
public class SorteioParticipanteResultadoDB {
    public void insert(SorteioParticipanteResultado sorteio_participante_resultado) {
         
        String sql = "insert into sorteio_participante_resultado(id_participante_para, id_participante_de, id_sorteio) values (?, ?, ?)";
        PreparedStatement ps;
        
        try {
            ps = DB.getConnection().prepareStatement(sql);
            ps.setInt(1, sorteio_participante_resultado.getIdParticipantePara());
            ps.setInt(2, sorteio_participante_resultado.getIdParticipanteDe());
            ps.setInt(3, sorteio_participante_resultado.getIdSorteio());
            ps.execute();
        } catch (SQLException ex) {
            Logger.getLogger(ParticipanteDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public ArrayList<SorteioParticipanteResultado> selectAllFromSorteio(Sorteio sorteio) {
        String sql = "select SPR.*, P.nome as nome_de, P.email as email_de, P2.nome as nome_para, P2.email as email_para"
                + "from sorteio_participante_resultado as SPR"
                + "inner join participante as P on P.id_participante = SPR.id_participante_de"
                + "inner join participante as P2 on P2.id_participante = SPR.id_participante_para"
                + "where SPR.id_sorteio = ?";
        
        PreparedStatement ps;
        ArrayList<SorteioParticipanteResultado> sorteios_participantes_resultados = new ArrayList<SorteioParticipanteResultado>();
        
        try {
             ps = DB.getConnection().prepareStatement(sql);
             ResultSet results = ps.executeQuery();
             
             while (results.next()) {
                 SorteioParticipanteResultado sorteio_participante_resultado = new SorteioParticipanteResultado();
                 sorteio_participante_resultado.setId(results.getInt("id"));
                 sorteio_participante_resultado.setIdParticipanteDe(results.getInt("id_participante_de"));
                 sorteio_participante_resultado.setIdParticipantePara(results.getInt("id_participante_para"));
                 sorteio_participante_resultado.setIdSorteio(results.getInt("id_sorteio"));
                 
                 sorteio_participante_resultado.setSorteio(sorteio);
                 
                 Participante participante_de = new Participante();
                 participante_de.setId(sorteio_participante_resultado.getIdParticipanteDe());
                 participante_de.setNome(results.getString("nome_de"));
                 participante_de.setEmail(results.getString("email_de"));
                 
                 sorteio_participante_resultado.setParticipanteDe(participante_de);
                 
                 Participante participante_para = new Participante();
                 participante_para.setId(sorteio_participante_resultado.getIdParticipanteDe());
                 participante_para.setNome(results.getString("nome_para"));
                 participante_para.setEmail(results.getString("email_para"));
                 sorteio_participante_resultado.setParticipantePara(participante_para);
                 
                 sorteios_participantes_resultados.add(sorteio_participante_resultado);
             }
             
        } catch (SQLException ex) {
            Logger.getLogger(ParticipanteDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return sorteios_participantes_resultados;
    }
}
