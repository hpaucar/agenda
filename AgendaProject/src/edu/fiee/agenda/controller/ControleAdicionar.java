package edu.fiee.agenda.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;

import edu.fiee.agenda.model.Contato;

public class ControleAdicionar implements ActionListener {

    private final DefaultListModel<Contato> contatos;
    
    public ControleAdicionar (DefaultListModel<Contato> contatos) {
        this.contatos = contatos;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        contatos.addElement(new Contato());
    }
}