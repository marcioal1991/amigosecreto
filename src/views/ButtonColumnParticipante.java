/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.AbstractCellEditor;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.WindowConstants;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumnModel;

/**
 *
 * @author marcio
 */
class ButtonColumnParticipante extends AbstractCellEditor
implements TableCellRenderer, TableCellEditor, ActionListener
{
    JTable table;
    JButton renderButton;
    JButton editButton;
    String text;
    int id;

    public ButtonColumnParticipante(JTable table, int column, int id)
    {
        super();
        this.table = table;
        this.id = id;
        renderButton = new JButton();
        editButton = new JButton();
        editButton.setFocusPainted( false );
        editButton.addActionListener( this );
       
        TableColumnModel columnModel = table.getColumnModel();
        columnModel.getColumn(column).setCellRenderer( this );
        columnModel.getColumn(column).setCellEditor( this );
    }

    public Component getTableCellRendererComponent(
        JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column)
    {
        if (hasFocus)
        {
            renderButton.setForeground(table.getForeground());
            renderButton.setBackground(UIManager.getColor("Button.background"));
        }
        else if (isSelected)
        {
            renderButton.setForeground(table.getSelectionForeground());
             renderButton.setBackground(table.getSelectionBackground());
        }
        else
        {
            renderButton.setForeground(table.getForeground());
            renderButton.setBackground(UIManager.getColor("Button.background"));
        }

        renderButton.setText("Atualizar");
        return renderButton;
    }

    public Component getTableCellEditorComponent(
        JTable table, Object value, boolean isSelected, int row, int column)
    {
        editButton.setText("Atualizar");
        return editButton;
    }

    public Object getCellEditorValue()
    {
        return text;
    }

    public void actionPerformed(ActionEvent e)
    {
        
        fireEditingStopped();
        EditParticipante view = new EditParticipante(this.id);
        view.setVisible(true);
        view.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    }
}