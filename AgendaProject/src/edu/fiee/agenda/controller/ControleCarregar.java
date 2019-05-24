package edu.fiee.agenda.controller;

import javax.swing.JList;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import edu.fiee.agenda.model.Contato;

public class ControleCarregar implements ListSelectionListener {

    private final JList<Contato> listaContatos;
    private final JTextField campoNome;
    private final JTextField campoTelefone;
    private final JTextArea campoDetalhes;
    
    public ControleCarregar (JList<Contato> listaContatos, JTextField campoNome, JTextField campoTelefone, JTextArea campoDetalhes) {
        this.listaContatos = listaContatos;
        this.campoNome = campoNome;
        this.campoTelefone = campoTelefone;
        this.campoDetalhes = campoDetalhes;
    }

    @Override
    public void valueChanged(ListSelectionEvent e) {
        Contato contatoSelecionado = listaContatos.getSelectedValue();
        
        if (contatoSelecionado != null) {
            campoNome.setText(contatoSelecionado.getNome());
            campoTelefone.setText(contatoSelecionado.getTelefone());
            campoDetalhes.setText(contatoSelecionado.getDetalhes());
        } else {
            campoNome.setText("");
            campoTelefone.setText("");
            campoDetalhes.setText("");
        }

        campoNome.setEnabled(contatoSelecionado != null);
        campoTelefone.setEnabled(contatoSelecionado != null);
        campoDetalhes.setEnabled(contatoSelecionado != null);

        listaContatos.repaint();        
    }
}