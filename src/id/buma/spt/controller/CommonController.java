/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.buma.spt.controller;

import id.buma.spt.dao.KelompokTaniDAOSQL;
import id.buma.spt.model.KelompokTani;
import id.buma.spt.model.Petani;
import id.buma.spt.model.SPT;
import id.buma.spt.view.DefaultHeaderRenderer;
import id.buma.spt.view.KelompokTani_RowRenderer;
import id.buma.spt.view.KelompokTani_TableModel;
import id.buma.spt.view.MainWindow;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Bayu Anandavi Muhardika
 * 
 */

public class CommonController {
    
    private MainWindow mw;
    
    public CommonController(MainWindow mw){
        this.mw = mw;
    }
    
    public MainWindow getMw(){
        return mw;
    }
    
    public void loadTabelKelompokTani(){
        KelompokTaniDAOSQL ktDao = new KelompokTaniDAOSQL();
        DefaultHeaderRenderer dhr = new DefaultHeaderRenderer();
        KelompokTani_RowRenderer ktrr = new KelompokTani_RowRenderer();
        mw.getTblKelompokTani().getTableHeader().setDefaultRenderer(dhr);
        mw.getTblKelompokTani().setDefaultRenderer(Object.class, ktrr);
        List<KelompokTani> lsKt = ktDao.getAllKelompokTani();
        refreshTableKelompokTani(lsKt);
    }
    
    public void refreshTableKelompokTani(List<KelompokTani> lsKt){
        KelompokTani_TableModel kttm = new KelompokTani_TableModel(lsKt);
        mw.getTblKelompokTani().setModel(kttm);
    }
    
    public void searchKelompokTani(String keyword){
        KelompokTaniDAOSQL ktDao = new KelompokTaniDAOSQL();
        List<KelompokTani> lsKt = ktDao.getKelompokTaniByFilter(keyword);
        refreshTableKelompokTani(lsKt);
    }
    
    public int getNoSuratBaru(){
        KelompokTaniDAOSQL ktDao = new KelompokTaniDAOSQL();
        return ktDao.getNoSuratBaru();
    }
    
    public List<Petani> getDetailPetani(){
        if (mw.getTblKelompokTani().getSelectedRow() > -1){
            KelompokTaniDAOSQL ktDao = new KelompokTaniDAOSQL();
            KelompokTani_TableModel kttm = (KelompokTani_TableModel) mw.getTblKelompokTani().getModel();
            List<KelompokTani> lsKt = kttm.getContentList();
            String idKelompok = lsKt.get(mw.getTblKelompokTani().getSelectedRow()).getIdKelompok();
            List<Petani> lsPt = ktDao.getPetaniByIdKelompok(idKelompok);
            return lsPt;
        } else {
            JOptionPane.showMessageDialog(null, "Pilih salah satu kelompok!", "", JOptionPane.ERROR_MESSAGE);
        }
        return null;
    }
    
    public boolean insertSpt(List<Petani> lsPt){
        KelompokTaniDAOSQL ktDao = new KelompokTaniDAOSQL();
        List<SPT> lsSpt = new ArrayList<>();
        Double brix;
        Double pol;
        Double fk;
        Double kp;
        Double kdt;
        if (mw.getftxtBrix().getText().equals("")){
            brix = 0.00;
        } else {
            brix = Double.parseDouble(mw.getftxtBrix().getText());
        }
        if (mw.getftxtPol().getText().equals("")){
            pol = 0.00;
        } else {
            pol = Double.parseDouble(mw.getftxtPol().getText());
        }
        if (mw.getftxtFk().getText().equals("")){
            fk = 0.00;
        } else {
            fk = Double.parseDouble(mw.getftxtFk().getText());
        }
        if (mw.getftxtKp().getText().equals("")){
            kp = 0.00;
        } else {
            kp = Double.parseDouble(mw.getftxtKp().getText());
        }
        if (mw.getftxtKdt().getText().equals("")){
            kdt = 0.00;
        } else {
            kdt = Double.parseDouble(mw.getftxtKdt().getText());
        }
        java.sql.Date tglAnalisa = new java.sql.Date(mw.getdtpTglAnalisa().getDate().getTime());
        java.sql.Date timestamp = new java.sql.Date(new java.util.Date().getTime());
        java.sql.Timestamp updateTime = new java.sql.Timestamp(new java.util.Date().getTime());
        for (Petani pt : lsPt){
            SPT spt = new SPT(
                    pt.getKodeBlok(), 
                    "", 
                    0.00, 
                    brix, 
                    pol, 
                    fk, 
                    kp, 
                    kdt, 
                    0.00, 
                    tglAnalisa, 
                    "", 
                    "Operator Tanaman", 
                    updateTime, 
                    0
            );
            lsSpt.add(spt);
        }
        return ktDao.insertNewSPT(lsSpt);
    }
    
    public void resetForm(){
        mw.getftxtBrix().setText("");
        mw.getftxtPol().setText("");
        mw.getftxtFk().setText("");
        mw.getftxtKp().setText("");
        mw.getftxtKdt().setText("");
        mw.getTxtKeyword().setText("");
        mw.getdtpTglAnalisa().setDate(null);
    }
    
    public boolean cekTglAnalisa(){
        return mw.getdtpTglAnalisa().getDate() != null;
    }
    
    public void buatSpt(){
        if (cekTglAnalisa()){
            List<Petani> lsPt = getDetailPetani();
            String namaKelompok = lsPt.get(0).getNamaKelompok();
            String noKontrak = lsPt.get(0).getNoKontrak();
            String confirmPage = "<html>Buat SPT untuk petani pada kelompok :<br><b>"+
                    namaKelompok+" ("+noKontrak+")</b><br>Simpan data?</html>";
            if (JOptionPane.showConfirmDialog(null, confirmPage, "", JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION){
                if (insertSpt(lsPt)){
                    JOptionPane.showMessageDialog(null, "Data telah tersimpan!","",JOptionPane.INFORMATION_MESSAGE);
                    resetForm();
                    mw.getTxtKeyword().requestFocus();
                    loadTabelKelompokTani();
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Tanggal analisa belum diisi!", "", JOptionPane.ERROR_MESSAGE);
        }
    }
    
}
