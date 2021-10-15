package view;

import controller.MahasiswaController;
import entity.TableModelMahasiswa;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class FormMahasiswa extends javax.swing.JFrame {

    private JTextField fieldNRP;
    private JTextField fieldNama;
    private JTextField fieldAngkatan;
    private JTextField fieldSMA;
    private JTable tableMahasiswa;
    private JButton updateButton;
    private JButton inputButton;
    private JButton deleteButton;
    private JPanel mainPanel;

    private TableModelMahasiswa tableModelMahasiswa;
    private MahasiswaController controller;

    public FormMahasiswa()
    {
        tableModelMahasiswa = new TableModelMahasiswa();
        tableMahasiswa.setModel(tableModelMahasiswa);

        controller =  new MahasiswaController(this);
        controller.select();

        inputButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.create();
            }
        });

        updateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.update();
            }
        });

        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.delete();
            }
        });
        tableMahasiswa.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                tableMahasiswaMouseClicked(e);
            }
        });
    }

    public TableModelMahasiswa getTableModelMahasiswa() {
        return tableModelMahasiswa;
    }

    public JTable getTableMahasiswa() {
        return tableMahasiswa;
    }


    public JTextField getFieldNRP() {
        return fieldNRP;
    }

    public JTextField getFieldNama() {
        return fieldNama;
    }

    public JTextField getFieldAngkatan() {
        return fieldAngkatan;
    }

    public JTextField getFieldSMA() {
        return fieldSMA;
    }

    private void tableMahasiswaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableMahasiswaMouseClicked
        // TODO add your handling code here:
        JTable source = (JTable)evt.getSource();
        int row = source.rowAtPoint(evt.getPoint());
        fieldNRP.setText(source.getModel().getValueAt(row, 0)+"");
        fieldNama.setText(source.getModel().getValueAt(row, 1)+"");
        fieldAngkatan.setText(source.getModel().getValueAt(row, 2)+"");
        fieldSMA.setText(source.getModel().getValueAt(row, 3)+"");
    }

    private void initComponents()
    {
        tableMahasiswa.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{
                        {null, null, null, null},
                        {null, null, null, null},
                        {null, null, null, null},
                        {null, null, null, null}
                },
                new String[]{
                        "Nrp", "Nama", "Angkatan", "SMA Asal"
                }
        ));
    }

    public static void main(String args[]) {
        JFrame frame = new JFrame("APP");
        frame.setContentPane(new FormMahasiswa().mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

    }
}
