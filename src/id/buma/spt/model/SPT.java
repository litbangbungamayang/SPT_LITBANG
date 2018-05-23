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

public class SPT {
    
    private String kodeBlok;
    private String noSurat;
    private Double brixKebun;
    private Double brix;
    private Double pol;
    private Double fk;
    private Double kp;
    private Double kdt;
    private Double score;
    private java.sql.Date tglAnalisa;
    private String ket;
    private String userAct;
    private java.sql.Timestamp tglAct;
    private int status;

    public SPT(String kodeBlok, String noSurat, Double brixKebun, Double brix, Double pol, Double fk, Double kp,
            Double kdt, Double score, java.sql.Date tglAnalisa, String ket, String userAct, java.sql.Timestamp tglAct, int status){
        this.kodeBlok = kodeBlok;
        this.noSurat = noSurat;
        this.brixKebun = brixKebun;
        this.brix = brix;
        this.pol = pol;
        this.fk = fk;
        this.kp = kp;
        this.kdt = kdt;
        this.score = score;
        this.tglAnalisa = tglAnalisa;
        this.ket = ket;
        this.userAct = userAct;
        this.tglAct = tglAct;
        this.status = status;
    }
    
    public String getKodeBlok() {
        return kodeBlok;
    }

    public void setKodeBlok(String kodeBlok) {
        this.kodeBlok = kodeBlok;
    }

    public String getNoSurat() {
        return noSurat;
    }

    public void setNoSurat(String noSurat) {
        this.noSurat = noSurat;
    }

    public Double getBrixKebun() {
        return brixKebun;
    }

    public void setBrixKebun(Double brixKebun) {
        this.brixKebun = brixKebun;
    }

    public Double getBrix() {
        return brix;
    }

    public void setBrix(Double brix) {
        this.brix = brix;
    }

    public Double getPol() {
        return pol;
    }

    public void setPol(Double pol) {
        this.pol = pol;
    }

    public Double getFk() {
        return fk;
    }

    public void setFk(Double fk) {
        this.fk = fk;
    }

    public Double getKp() {
        return kp;
    }

    public void setKp(Double kp) {
        this.kp = kp;
    }

    public Double getKdt() {
        return kdt;
    }

    public void setKdt(Double kdt) {
        this.kdt = kdt;
    }

    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }

    public java.sql.Date getTglAnalisa() {
        return tglAnalisa;
    }

    public void setTglAnalisa(java.sql.Date tglAnalisa) {
        this.tglAnalisa = tglAnalisa;
    }

    public String getKet() {
        return ket;
    }

    public void setKet(String ket) {
        this.ket = ket;
    }

    public String getUserAct() {
        return userAct;
    }

    public void setUserAct(String userAct) {
        this.userAct = userAct;
    }

    public java.sql.Timestamp getTglAct() {
        return tglAct;
    }

    public void setTglAct(java.sql.Timestamp tglAct) {
        this.tglAct = tglAct;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
    
}
