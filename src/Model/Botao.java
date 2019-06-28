/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import javax.swing.Icon;
import javax.swing.JButton;

/**
 *
 * @author CarlosHVChaves
 */
public class Botao extends JButton {

    private static final long serialVersionUID = 1L;

    private Icon imagemPadrao;
    private Icon imagemBotao;

    public Botao(Icon imagemPadrao, Icon imagemBotao) {
        super();
        this.imagemBotao = imagemBotao;
        this.imagemPadrao = imagemPadrao;
        setImagemPadrao();
    }

    public void setImagemPadrao() {
        this.setIcon(imagemPadrao);
    }

    public void setImagemBotao() {
        this.setIcon(imagemBotao);
    }

    public Icon getImagemBotao() {
        return this.imagemBotao;
    }
}
