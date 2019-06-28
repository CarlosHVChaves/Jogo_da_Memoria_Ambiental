/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import View.AplicacaoDoJogo;
import javax.swing.JFrame;

/**
 *
 * @author CarlosHVChaves
 */
public class Principal {
    /**
     * Método principal
     *
     * @param args
     */
    public static void main(String args[]) {

        AplicacaoDoJogo application = new AplicacaoDoJogo();

        application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        application.setLocationRelativeTo(null);
    }
}
