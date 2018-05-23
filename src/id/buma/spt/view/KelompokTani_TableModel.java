/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.buma.spt.view;

import id.buma.spt.model.KelompokTani;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Bayu Anandavi Muhardika
 * 
 */

public class KelompokTani_TableModel extends AbstractTableModel{
    
    private List<KelompokTani> lsKt = new ArrayList<>();
    
    public KelompokTani_TableModel(List<KelompokTani> lsDt){
        this.lsKt = lsDt;
    }
    
    public List<KelompokTani> getContentList(){
        return lsKt;
    }
    
    public final String[] columnNames = new String[]{
            "No.",
            "ID Kelompok",
            "No. Kontrak",
            "Nama Kelompok",
            "Luas",
            "Varietas",
            "MT"
        };

    @Override
    public int getRowCount() {
        return lsKt.size();
    }

    @Override
    public String getColumnName(int column) {
        return columnNames[column];
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        DecimalFormatSymbols dfs = new DecimalFormatSymbols();
        dfs.setDecimalSeparator(',');
        dfs.setGroupingSeparator('.');
        DecimalFormat df = new DecimalFormat("#,##0.00",dfs);
        switch (columnIndex){
            case 0:
                return rowIndex + 1;
            case 1:
                return lsKt.get(rowIndex).getIdKelompok();
            case 2:
                return lsKt.get(rowIndex).getNoKontrak();
            case 3:
                return lsKt.get(rowIndex).getNamaKelompok();
            case 4:
                return df.format(lsKt.get(rowIndex).getLuas());
            case 5:
                return lsKt.get(rowIndex).getVarietas();
            case 6:
                return lsKt.get(rowIndex).getMasaTanam();
        }
        return null;
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }
    
}
