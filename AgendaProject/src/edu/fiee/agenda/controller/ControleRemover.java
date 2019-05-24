package edu.fiee.agenda.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.JList;

import edu.fiee.agenda.model.Contato;

public class ControleRemover implements ActionListener {

    private final JList<Contato> listaContatos;
    private final DefaultListModel<Contato> contatos;
    
    public ControleRemover (JList<Contato> listaContatos, DefaultListModel<Contato> contatos) {
        this.listaContatos = listaContatos;
        this.contatos = contatos;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Contato contatoSelecionado = listaContatos.getSelectedValue();
        contatos.removeElement(contatoSelecionado);
    }
}