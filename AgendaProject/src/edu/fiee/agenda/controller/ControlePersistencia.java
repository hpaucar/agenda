package edu.fiee.agenda.controller;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.DefaultListModel;

import edu.fiee.agenda.model.Contato;

public class ControlePersistencia extends WindowAdapter {

    private static final String NOME_ARQUIVO = "agenda.dat";

    private final DefaultListModel<Contato> contatos;

    public ControlePersistencia(DefaultListModel<Contato> contatos) {
        this.contatos = contatos;
    }

    @Override
    public void windowOpened(WindowEvent e) {
        try (FileInputStream fileIn = new FileInputStream(NOME_ARQUIVO);
             ObjectInputStream in = new ObjectInputStream(fileIn)) {            
            for (Object objeto : (Object[])in.readObject()) {
                contatos.addElement((Contato)objeto);
            }
        } catch (IOException | ClassNotFoundException ex) {
            Logger.getLogger(ControlePersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void windowClosing(WindowEvent e) {
        try (FileOutputStream fileOut = new FileOutputStream(NOME_ARQUIVO);
             ObjectOutputStream out = new ObjectOutputStream(fileOut)) {
            out.writeObject(contatos.toArray());
        } catch (IOException ex) {
            Logger.getLogger(ControlePersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}