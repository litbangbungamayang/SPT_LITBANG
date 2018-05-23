/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.buma.spt.model;

/**
 *
 * @author Bayu Anandavi Muhardika
 * 
 */

public class KelompokTani {
    
    private String idKelompok;
    private String noKontrak;
    private String namaKelompok;
    private String varietas;
    private String masaTanam;
    private Double luas;
    
    public KelompokTani(String idKelompok, String noKontrak, String namaKelompok, 
            String varietas, String masaTanam, Double luas){
        this.idKelompok = idKelompok;
        this.noKontrak = noKontrak;
        this.namaKelompok = namaKelompok;
        this.varietas = varietas;
        this.masaTanam = masaTanam;
        this.luas = luas;
    }

    public String getIdKelompok() {
        return idKelompok;
    }

    public void setIdKelompok(String idKelompok) {
        this.idKelompok = idKelompok;
    }

    public String getNoKontrak() {
        return noKontrak;
    }

    public void setNoKontrak(String noKontrak) {
        this.noKontrak = noKontrak;
    }

    public String getNamaKelompok() {
        return namaKelompok;
    }

    public void setNamaKelompok(String namaKelompok) {
        this.namaKelompok = namaKelompok;
    }

    public String getVarietas() {
        return varietas;
    }

    public void setVarietas(String varietas) {
        this.varietas = varietas;
    }

    public String getMasaTanam() {
        return masaTanam;
    }

    public void setMasaTanam(String masaTanam) {
        this.masaTanam = masaTanam;
    }

    public Double getLuas() {
        return luas;
    }

    public void setLuas(Double luas) {
        this.luas = luas;
    }
    
}
