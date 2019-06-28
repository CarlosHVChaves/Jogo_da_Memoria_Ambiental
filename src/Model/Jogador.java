/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author CarlosHVChaves
 */
public class Jogador {

    private String nome;
    private int pontos;

    public Jogador(String nomeJogador) {
        nome = (nomeJogador.equals("") ? "Jogador" : nomeJogador);
        pontos = 0;
    }

    public String obterNome() {
        return nome;
    }

    public int obterPontos() {
        return pontos;
    }

    public void incrementarPontos() {
        pontos += 5;
    }

    public void decrementarPontos() {
        pontos--;
    }
}
