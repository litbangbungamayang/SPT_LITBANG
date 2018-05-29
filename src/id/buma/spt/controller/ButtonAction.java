/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.buma.spt.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

/**
 *
 * @author Bayu Anandavi Muhardika
 * 
 */

public class ButtonAction implements ActionListener {
    
    private final CommonController cc;
    
    public ButtonAction(CommonController cc){
        this.cc = cc;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton btn = (JButton) e.getSource();
        String btnName = btn.getName();
        if (btnName.equals("btnCari")){
            cc.searchKelompokTani(cc.getMw().getTxtKeyword().getText());
        }
        if (btnName.equals("btnBuat")){
            cc.buatSpt();
        }
    }
    
}
