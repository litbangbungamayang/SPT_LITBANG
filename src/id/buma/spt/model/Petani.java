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

public class Petani {

    private String idKelompok;
    private String kodeBlok;
    private String noKontrak;
    private String namaKelompok;
    private String namaPetani;
    private Double luas;
    private String varietas;
    private String masaTanam;
    
    public Petani(String idKelompok, String kodeBlok, String noKontrak, String namaKelompok, 
            String namaPetani, Double luas, String varietas, String masaTanam){
        this.idKelompok = idKelompok;
        this.kodeBlok = kodeBlok;
        this.noKontrak = noKontrak;
        this.namaKelompok = namaKelompok;
        this.namaPetani = namaPetani;
        this.luas = luas;
        this.varietas = varietas;
        this.masaTanam = masaTanam;
    }

    public String getIdKelompok() {
        return idKelompok;
    }

    public void setIdKelompok(String idKelompok) {
        this.idKelompok = idKelompok;
    }

    public String getKodeBlok() {
        return kodeBlok;
    }

    public void setKodeBlok(String kodeBlok) {
        this.kodeBlok = kodeBlok;
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

    public String getNamaPetani() {
        return namaPetani;
    }

    public void setNamaPetani(String namaPetani) {
        this.namaPetani = namaPetani;
    }

    public Double getLuas() {
        return luas;
    }

    public void setLuas(Double luas) {
        this.luas = luas;
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
    
}
