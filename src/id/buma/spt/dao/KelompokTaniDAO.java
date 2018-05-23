/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.buma.spt.dao;

import id.buma.spt.model.KelompokTani;
import id.buma.spt.model.Petani;
import id.buma.spt.model.SPT;
import java.util.List;

/**
 *
 * @author Bayu Anandavi Muhardika
 * 
 */

public interface KelompokTaniDAO {
    
    public List<KelompokTani> getAllKelompokTani();
    
    public List<KelompokTani> getKelompokTaniByFilter(String filter);
    
    public int getNoSuratBaru();
    
    public List<Petani> getPetaniByIdKelompok(String idKelompok);
    
    public boolean insertNewSPT(List<SPT> lsSpt); 
    
}
