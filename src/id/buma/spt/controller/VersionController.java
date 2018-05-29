/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.buma.spt.controller;

/**
 *
 * @author Bayu Anandavi Muhardika
 * 
 */

public class VersionController {
    
    private String version;
    private String desc;
    
    public VersionController(){
        
    }

    public String getVersion() {
        version = "1.0.23052018.1010";
        version = "1.0.29052018.1733";
        /*
        *+ Perubahan nama User, dari Operator Tanaman menjadi Askep Litbang
        */
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getDesc() {
        desc = "+ initial build";
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
    
    
}
