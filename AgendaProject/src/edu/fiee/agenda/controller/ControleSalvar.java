package edu.fiee.agenda.controller;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JList;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import edu.fiee.agenda.model.Contato;

public class ControleSalvar extends KeyAdapter {

    private final JList<Contato> listaContatos;
    private final JTextField campoNome;
    private final JTextField campoTelefone;
    private final JTextArea campoDetalhes;
    
    public ControleSalvar (JList<Contato> listaContatos, JTextField campoNome, JTextField campoTelefone, JTextArea campoDetalhes) {
        this.listaContatos = listaContatos;
        this.campoNome = campoNome;
        this.campoTelefone = campoTelefone;
        this.campoDetalhes = campoDetalhes;
    }
    
    @Override
    public void keyReleased(KeyEvent e) {
        Contato contatoSelecionado = listaContatos.getSelectedValue();
        if (contatoSelecionado != null) {
            contatoSelecionado.setNome(campoNome.getText());
            contatoSelecionado.setTelefone(campoTelefone.getText());
            contatoSelecionado.setDetalhes(campoDetalhes.getText());
        }
        listaContatos.repaint();        
    }    
}