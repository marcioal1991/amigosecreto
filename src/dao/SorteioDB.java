package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Sorteio;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author marcio
 */
public class SorteioDB {
     public void insert(Sorteio sorteio) {
        
        String sql = "insert into sorteio(nome) values (?)";
        PreparedStatement ps;
        
        try {
            ps = DB.getConnection().prepareStatement(sql);
            ps.setString(1, sorteio.getNome());
            ps.execute();
        } catch (SQLException ex) {
            Logger.getLogger(SorteioDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void update(Sorteio sorteio) {
        String sql = "update sorteio set nome = ? where id = ?";
        PreparedStatement ps;
        
        try {
            ps = DB.getConnection().prepareStatement(sql);
            ps.setString(1, sorteio.getNome());
            ps.setInt(2, sorteio.getId());
            ps.execute();
        } catch (SQLException ex) {
            Logger.getLogger(SorteioDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void delete(Sorteio sorteio) {
        String sql = "delete from sorteio where id = ?";
        PreparedStatement ps;
        
        try {
            ps = DB.getConnection().prepareStatement(sql);
            ps.setInt(1, sorteio.getId());
            ps.execute();
        } catch (SQLException ex) {
            Logger.getLogger(SorteioDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public Sorteio selectOne(int id) {
        String sql = "select * from sorteio where id = ?";
        PreparedStatement ps;
        Sorteio sorteio = new Sorteio();
        
        try {
            ps = DB.getConnection().prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet results = ps.executeQuery();
             
            
            while (results.next()) {
                sorteio.setId(results.getInt("id"));
                sorteio.setNome(results.getString("nome"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(SorteioDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return sorteio;
    }
    
    public ArrayList<Sorteio> selectAll() {
        String sql = "select * from sorteio";
        PreparedStatement ps;
        ArrayList<Sorteio> sorteios = new ArrayList<Sorteio>();
        
        try {
             ps = DB.getConnection().prepareStatement(sql);
             ResultSet results = ps.executeQuery();
             
             while (results.next()) {
                 Sorteio sorteio = new Sorteio();
                 
                 sorteio.setId(results.getInt("id"));
                 sorteio.setNome(results.getString("nome"));
                 sorteios.add(sorteio);
             }
             
        } catch (SQLException ex) {
            Logger.getLogger(SorteioDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return sorteios;
    }
}
