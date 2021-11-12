/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conexao;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author felipe.souza7
 */
public class SimpleTableModel extends AbstractTableModel {
    private ArrayList linhas = null;
    private String [] colunas = null;
    
    
    public ArrayList getLinhas(){
           return linhas;   
    }
    
    
    public void setLinhas(ArrayList list){
    
        linhas = list;
    }
    
    public void setColunas(String[] strings){
    
        colunas = strings;
        
    }
    
    public String[] getColunas(){
   
         return colunas;
    }
    
    

    @Override
    public int getRowCount() {
        return getLinhas().size();
    }

    @Override
    public int getColumnCount() {
        return getColunas().length;
        
    }
    
   
    @Override
    public String getColumnName(int coluna){
         return colunas[coluna];
    }

    @Override
    public Object getValueAt(int rowIdex, int colIdex) {
        String [] linhas =(String[])getLinhas().get(rowIdex);
        return linhas[colIdex];
    }

    public SimpleTableModel(ArrayList dados, String[] colunas) {
        this.setColunas(colunas);
        this.setLinhas(dados);
        
    }
    
    
}
