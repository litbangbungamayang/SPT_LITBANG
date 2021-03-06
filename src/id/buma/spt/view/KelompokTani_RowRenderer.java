/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.buma.spt.view;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import javax.swing.JTable;
import static javax.swing.SwingConstants.CENTER;
import static javax.swing.SwingConstants.LEFT;
import static javax.swing.SwingConstants.RIGHT;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;

/**
 *
 * @author Bayu Anandavi Muhardika
 * 
 */

public class KelompokTani_RowRenderer extends DefaultTableCellRenderer implements TableCellRenderer {

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, 
            boolean isSelected, boolean hasFocus, int row, int column) {
        Component c = super.getTableCellRendererComponent(table, value, isSelected,
                hasFocus, row, column);
        setBorder(noFocusBorder);
        TableColumn tc = table.getColumnModel().getColumn(column);
        table.setRowSelectionAllowed(true);
        table.getParent().setBackground(new Color(255,255,255));
        int tableWidth = table.getParent().getWidth();
        switch(column){
            /*
            "No.",
            "ID Kelompok",
            "No. Kontrak",
            "Nama Kelompok",
            "Luas",
            "Varietas",
            "MT"
            */
            case 0:
                this.setHorizontalAlignment(CENTER);
                tc.setCellRenderer(this);
                tc.setPreferredWidth((int) Math.round(0.05*tableWidth));
                break;
            case 1:
                this.setHorizontalAlignment(CENTER);
                tc.setCellRenderer(this);
                tc.setPreferredWidth((int) Math.round(0.15*tableWidth));
                break;
            case 2:
                this.setHorizontalAlignment(LEFT);
                tc.setCellRenderer(this);
                tc.setPreferredWidth((int) Math.round(0.2*tableWidth));
                break;
            case 3:
                this.setHorizontalAlignment(LEFT);
                tc.setCellRenderer(this);
                tc.setPreferredWidth((int) Math.round(0.25*tableWidth) - 1);
                break;
            case 4:
                this.setHorizontalAlignment(RIGHT);
                tc.setCellRenderer(this);
                tc.setPreferredWidth((int) Math.round(0.1*tableWidth));
                break;
            case 5:
                this.setHorizontalAlignment(CENTER);
                tc.setCellRenderer(this);
                tc.setPreferredWidth((int) Math.round(0.13*tableWidth));
                break;
            case 6:
                this.setHorizontalAlignment(CENTER);
                tc.setCellRenderer(this);
                tc.setPreferredWidth((int) Math.round(0.12*tableWidth));
                break;
        }
        if (row % 2 == 0){
            c.setBackground(new Color(179,179,179));
            c.setForeground(Color.BLACK);
            c.setFont(new Font("Consolas", Font.PLAIN, 12));
        } else {
            setBackground(new Color(235,235,235));
            c.setForeground(Color.BLACK);
            c.setFont(new Font("Consolas", Font.PLAIN, 12));
        }
        
        if (isSelected){
            setBackground(new Color(70,70,70));
            setForeground(Color.WHITE);
            c.setFont(new Font("Consolas", Font.PLAIN, 12));
        }
        return c;
    }
    
    
    
}
