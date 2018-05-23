/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.buma.spt.dao;

import id.buma.spt.database.DBConnection;
import id.buma.spt.model.KelompokTani;
import id.buma.spt.model.Petani;
import id.buma.spt.model.SPT;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Bayu Anandavi Muhardika
 * 
 */

public class KelompokTaniDAOSQL implements KelompokTaniDAO {

    @Override
    public List<KelompokTani> getAllKelompokTani() {
        List<KelompokTani> lsKt = new ArrayList<>();
        String sql =    "select " +
                            "kt.id_kelompok as id_kelompok," +
                            "kt.no_kontrak as no_kontrak," +
                            "kt.nama_kelompok as nama_kelompok," +
                            "round(sum(kt.luas),2) as luas," +  
                            "kt.varietas as varietas," +
                            "kt.masatanam as masatanam " +
                        "from simpg.t_kelompoktani kt " +
                        "left outer join simpg.sap_field_spt spt "+
                        "on spt.no_petak = kt.id_petani "+
                        "where spt.no_petak is null "+
                        "group by kt.id_kelompok";
        Connection conn = new DBConnection().getConn();
        try (PreparedStatement ps = conn.prepareStatement(sql)){
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                KelompokTani kt = new KelompokTani(
                        rs.getString("id_kelompok"), 
                        rs.getString("no_kontrak"), 
                        rs.getString("nama_kelompok"), 
                        rs.getString("varietas"), 
                        rs.getString("masatanam"), 
                        rs.getDouble("luas")
                );
                lsKt.add(kt);
            }
        } catch (SQLException ex) {
            Logger.getLogger(KelompokTaniDAOSQL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lsKt;
    }

    @Override
    public List<KelompokTani> getKelompokTaniByFilter(String filter) {
        List<KelompokTani> lsKt = new ArrayList<>();
        String sql =    "select " +
                            "kt.id_kelompok as id_kelompok," +
                            "kt.no_kontrak as no_kontrak," +
                            "kt.nama_kelompok as nama_kelompok," +
                            "round(sum(kt.luas),2) as luas," +  
                            "kt.varietas as varietas," +
                            "kt.masatanam as masatanam " +
                        "from simpg.t_kelompoktani kt " +
                        "left outer join simpg.sap_field_spt spt "+
                        "on spt.no_petak = kt.id_petani "+
                        "where spt.no_petak is null "+
                        "and (kt.no_kontrak like ? or kt.nama_kelompok like ?) "+
                        "group by kt.id_kelompok";
        Connection conn = new DBConnection().getConn();
        try (PreparedStatement ps = conn.prepareStatement(sql)){
            ps.setString(1, "%" + filter + "%");
            ps.setString(2, "%" + filter + "%");
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                KelompokTani kt = new KelompokTani(
                        rs.getString("id_kelompok"), 
                        rs.getString("no_kontrak"), 
                        rs.getString("nama_kelompok"), 
                        rs.getString("varietas"), 
                        rs.getString("masatanam"),
                        rs.getDouble("luas")
                );
                lsKt.add(kt);
            }
        } catch (SQLException ex) {
            Logger.getLogger(KelompokTaniDAOSQL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lsKt;
    }

    @Override
    public int getNoSuratBaru() {
        String sql = "select cast(max(left(spt.no_surat,5)) as signed) as nomor from simpg.sap_field_spt spt";
        Connection conn = new DBConnection().getConn();
        try (PreparedStatement ps = conn.prepareStatement(sql)){
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                return rs.getInt("nomor");
            }
        } catch (SQLException ex) {
            Logger.getLogger(KelompokTaniDAOSQL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }

    @Override
    public List<Petani> getPetaniByIdKelompok(String idKelompok) {
        List<Petani> lsPt = new ArrayList<>();
        String sql =    "select "+
                            "kt.id_kelompok as id_kelompok,"+
                            "kt.id_petani as id_petani,"+
                            "kt.no_kontrak as no_kontrak,"+
                            "kt.nama_kelompok as nama_kelompok,"+
                            "kt.nama_petani as nama_petani,"+
                            "kt.luas as luas,"+
                            "kt.varietas as varietas,"+
                            "kt.masatanam as masatanam "+
                        "from simpg.t_kelompoktani kt "+
                        "where kt.id_kelompok = ?";
        Connection conn = new DBConnection().getConn();
        try (PreparedStatement ps = conn.prepareStatement(sql)){
            ps.setString(1, idKelompok);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                Petani pt = new Petani(
                        rs.getString("id_kelompok"), 
                        rs.getString("id_petani"), 
                        rs.getString("no_kontrak"), 
                        rs.getString("nama_kelompok"), 
                        rs.getString("nama_petani"), 
                        rs.getDouble("luas"), 
                        rs.getString("varietas"), 
                        rs.getString("masatanam")
                );
                lsPt.add(pt);
            }
        } catch (SQLException ex) {
            Logger.getLogger(KelompokTaniDAOSQL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lsPt;
    }

    @Override
    public boolean insertNewSPT(List<SPT> lsSpt) {
        String sql = "insert into simpg.sap_field_spt("
                        + "no_petak,"
                        + "no_surat,"
                        + "h_brix_kebun,"
                        + "h_brix,"
                        + "h_pol,"
                        + "h_fk,"
                        + "h_kp,"
                        + "h_kdt,"
                        + "h_tscore,"
                        + "h_tglanalisa,"
                        + "keterangan,"
                        + "user_act,"
                        + "tgl_act,"
                        + "status"
                        + ") values (?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        Connection conn = new DBConnection().getConn();
        try {
            conn.setAutoCommit(false);
            conn.setTransactionIsolation(Connection.TRANSACTION_REPEATABLE_READ);
            try (PreparedStatement ps = conn.prepareStatement(sql)){
                for (SPT spt : lsSpt){
                    ps.setString(1, spt.getKodeBlok());
                    ps.setString(2, spt.getNoSurat());
                    ps.setDouble(3, spt.getBrixKebun());
                    ps.setDouble(4, spt.getBrix());
                    ps.setDouble(5, spt.getPol());
                    ps.setDouble(6, spt.getFk());
                    ps.setDouble(7, spt.getKp());
                    ps.setDouble(8, spt.getKdt());
                    ps.setDouble(9, spt.getScore());
                    ps.setDate(10, spt.getTglAnalisa());
                    ps.setString(11, spt.getKet());
                    ps.setString(12, spt.getUserAct());
                    ps.setTimestamp(13, spt.getTglAct());
                    ps.setInt(14, spt.getStatus());
                    ps.addBatch();
                }
                ps.executeBatch();
                conn.commit();
                conn.setAutoCommit(true);
                return true;
            } catch (SQLException ex){
                conn.rollback();
                JOptionPane.showMessageDialog(null, "Update SPT gagal!", "", JOptionPane.ERROR_MESSAGE);
            }
        } catch (SQLException ex) {
            Logger.getLogger(KelompokTaniDAOSQL.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(KelompokTaniDAOSQL.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return false;
    }
    
}
