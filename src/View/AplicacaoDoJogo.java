/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Model.Jogador;
import View.TelaDoJogo;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.ButtonGroup;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

/**
 *
 * @author CarlosHVChaves
 */
public class AplicacaoDoJogo extends JFrame implements ActionListener, ItemListener {

    private static final long serialVersionUID = 1L;

    private Container container;
    private JComboBox<String> temasJogada;
    private int indiceTema = 1;
    private JTextField fieldNomeJogador;
    private boolean jogoFacil = false;
    private JLabel nivelDificuldade;

    /*os temas para os jogos*/
    private String nomesTemas[] = {"Sustentabilidade", "Desmatamento"};

    /*ìndices dos temas para os jogos*/
    private int indiceTemas[] = {1, 2};

    public AplicacaoDoJogo() {

        super("Bem-vindo ao Jogo da Memória!");

        /*adiciona um listener á janela*/
        addWindowListener(
                /*classe interna anÃ´nima*/
                new WindowAdapter() {
            /*trata o evento de quando o usuÃ¡rio fecha a janela*/
            public void windowClosing(WindowEvent windowEvent) {
                saidaPrograma();
            }
        }
        );

        inicializarComponentesDaTela();
    }
    /**
     * Inicialização dos componentes de tela
     */
    private void inicializarComponentesDaTela() {

        nivelDificuldade = new JLabel("Nível de dificuldade: Difícil");
        nivelDificuldade.setForeground(Color.red);

        setJMenuBar(construirBarraDeMenu());

        /*configuração do container */
        container = getContentPane();
        container.setLayout(new BorderLayout(5, 5));
        container.setBackground(Color.lightGray);
        container.add(construirPainelVazio(), BorderLayout.SOUTH);
        container.add(configurarPainelDeDados());

        setSize(550, 380);
        setVisible(true);
        setResizable(false);
    }

    /**
     * Construção da barra de menus
     *
     * @return barra de menus configurada
     */
    private JMenuBar construirBarraDeMenu() {

        JMenuBar barraMenu = new JMenuBar();
        barraMenu.setBackground(Color.lightGray);
        barraMenu.add(construirMenuDeDificuldade());
        return barraMenu;
    }

    /**
     * Construção do menu de seleção do nível de dificuldade
     *
     * @return o menu configurado
     */
    private JMenu construirMenuDeDificuldade() {

        JMenu menuDificuldade = new JMenu("Nível de Dificuldade");
        menuDificuldade.setBackground(Color.lightGray);

        ButtonGroup dificuldadeGroup = new ButtonGroup();

        JRadioButtonMenuItem dificil = new JRadioButtonMenuItem("Difícil (6X6)");
        dificil.setSelected(true);

        dificil.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent evt) {
                jogoFacil = false;
                nivelDificuldade.setText("Nível de dificuldade: Difícil");
                nivelDificuldade.setForeground(Color.red);
            }
        });

        JRadioButtonMenuItem facil = new JRadioButtonMenuItem("Fácil (4X4)");

        facil.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent evt) {
                jogoFacil = true;
                nivelDificuldade.setText("Nível de dificuldade: Fácil");
                nivelDificuldade.setForeground(Color.blue);
            }
        });

        dificuldadeGroup.add(dificil);
        dificuldadeGroup.add(facil);
        menuDificuldade.add(dificil);
        menuDificuldade.add(facil);

        return menuDificuldade;
    }

    /**
     * Configuração do painel de dados (que possui o painel de cabeçalho, o
     * painel central e o painel de botões
     *
     * @return o painel configurado
     */
    private JPanel configurarPainelDeDados() {

        JPanel painelDados = new JPanel();
        painelDados.setLayout(new BorderLayout(5, 5));
        painelDados.setBackground(Color.lightGray);

        painelDados.add(construirPainelVazio(), BorderLayout.EAST);
        painelDados.add(construirPainelVazio(), BorderLayout.WEST);
        painelDados.add(configurarPainelCabecalho(), BorderLayout.NORTH);
        painelDados.add(configurarPainelCentral());

        return painelDados;
    }

    /**
     * Configuração de um painel vazio para ser usado no rodapé e laterais
     *
     * @return o painel configurado
     */
    private JPanel construirPainelVazio() {

        JPanel painelRodape = new JPanel();
        painelRodape.setBackground(Color.lightGray);

        return painelRodape;
    }

    /**
     * Configura o ícone Jogar
     *
     * @return o ícone configurado
     */
    private Icon configurarIconeJogar() {
        Icon imagemJogar = new ImageIcon(getClass().getClassLoader().getResource("imagens/jogo/jogar.png"));
        return imagemJogar;
    }

    /**
     * Configura o ícone JogarRol
     *
     * @return o ícone configurado
     */
    private Icon configurarIconeJogarRol() {
        Icon imagemJogarRoll = new ImageIcon(getClass().getClassLoader().getResource("imagens/jogo/jogarroll.png"));
        return imagemJogarRoll;
    }

    /**
     * Configura o ícone Sair
     *
     * @return o ícone configurado
     */
    private Icon configurarIconeSair() {
        Icon imagemSair = new ImageIcon(getClass().getClassLoader().getResource("imagens/jogo/sair.png"));
        return imagemSair;
    }

    /**
     * Configura o ícone SairRoll
     *
     * @return o ícone configurado
     */
    private Icon configurarIconeSairRoll() {
        Icon imagemSairRoll = new ImageIcon(getClass().getClassLoader().getResource("imagens/jogo/sairroll.png"));
        return imagemSairRoll;
    }

    /**
     * Configuração do painel de cabeçalho
     *
     * @return o painel configurado
     */
    private JPanel configurarPainelCabecalho() {

        Icon titulo = new ImageIcon(getClass().getClassLoader().getResource("imagens/jogo/titulo.gif"));
        JLabel texto1 = new JLabel(titulo);
        texto1.setHorizontalAlignment(SwingConstants.CENTER);

        GridLayout gridCabecalho = new GridLayout(1, 1, 10, 10);

        JPanel painelCabecalho = new JPanel();
        painelCabecalho.setLayout(gridCabecalho);
        painelCabecalho.setBackground(Color.lightGray);
        painelCabecalho.add(texto1);

        return painelCabecalho;
    }

    /**
     * Configuração do painel central
     *
     * @return o painel configurado
     */
    private JPanel configurarPainelCentral() {

        /*label do nome do jogador*/
        JLabel nomeJogador = new JLabel("Informe seu nome:");
        nomeJogador.setHorizontalAlignment(SwingConstants.LEFT);

        /*campo do nome do jogador*/
        fieldNomeJogador = new JTextField(15);
        fieldNomeJogador.setHorizontalAlignment(SwingConstants.LEFT);

        /*label do tema da jogada*/
        JLabel temaJogada = new JLabel("Escolha o tema:");
        temaJogada.setHorizontalAlignment(SwingConstants.LEFT);

        /*ComboBox do tema da jogada*/
        temasJogada = new JComboBox<String>(nomesTemas);
        temasJogada.addItemListener(this);
        temasJogada.setMaximumRowCount(4);

        GridLayout gridDados = new GridLayout(6, 1, 10, 10);

        JPanel painelCentro = new JPanel();
        painelCentro.setLayout(gridDados);
        painelCentro.setBackground(Color.lightGray);
        painelCentro.add(temaJogada);
        painelCentro.add(temasJogada);
        painelCentro.add(nomeJogador);
        painelCentro.add(fieldNomeJogador);

        painelCentro.add(nivelDificuldade);

        painelCentro.add(configurarPainelDeBotoes());

        return painelCentro;
    }

    /**
     * Configuração do painel de botões
     *
     * @return o painel configurado
     */
    private JPanel configurarPainelDeBotoes() {

        /*botão Iniciar Jogo*/
        JButton botaoIniciarJogo = new JButton("Iniciar Jogo", configurarIconeJogar());
        botaoIniciarJogo.setRolloverIcon(configurarIconeJogarRol());
        botaoIniciarJogo.setActionCommand("botaoIniciarJogo");
        botaoIniciarJogo.addActionListener(this);
        botaoIniciarJogo.setSize(250, 15);
        botaoIniciarJogo.setHorizontalAlignment(SwingConstants.LEFT);

        /*botão Sair*/
        JButton botaoSair = new JButton("Abandonar o Jogo", configurarIconeSair());
        botaoSair.setRolloverIcon(configurarIconeSairRoll());
        botaoSair.setActionCommand("botaoSair");
        botaoSair.addActionListener(this);
        botaoSair.setSize(250, 15);
        botaoSair.setHorizontalAlignment(SwingConstants.RIGHT);
        botaoSair.setHorizontalTextPosition(SwingConstants.LEFT);

        /*painel de botões (inferior)*/
        GridLayout gridBotoes = new GridLayout(1, 2, 10, 10);

        JPanel painelBotoes = new JPanel();
        painelBotoes.setBackground(Color.lightGray);
        painelBotoes.setLayout(gridBotoes);
        painelBotoes.add(botaoSair);
        painelBotoes.add(botaoIniciarJogo);
        return painelBotoes;
    }

    /**
     * Mensagem de finalização do jogo
     */
    private void saidaPrograma() {

        StringBuilder sb = new StringBuilder();

        sb.append("\n\n");

        sb.append("\t Jogo da Memória Ambiental - 2018 \n");
        sb.append("\t “Seja a mudança que você quer ver no mundo”. – Mahatma Gandhi. \n");
        sb.append("\t “Ambiente limpo não é o que mais se limpa e sim o que menos se suja”. – Chico Xavier. \n");
        sb.append("\t “Cada dia a natureza produz o suficiente para nossa carência. Se cada um tomasse o que lhe fosse necessário, não haveria pobreza no mundo e ninguém morreria de fome”. – Mahatma Gandhi. \n");
        sb.append("\t “Quando a última árvore for derrubada, quando o último rio for envenenado, quando o último peixe for pescado, só então nos daremos conta de que dinheiro não se come”. – Provérbio Indígena. \n");
        sb.append("\t “O custo do cuidado é sempre menor que o custo do reparo”. – Marina Silva. \n");
        sb.append("\t “Revolucionário é todo aquele que quer mudar o mundo e tem a coragem de começar por si mesmo”. – Sérgio Vaz. \n");
        sb.append("\t “Tentamos proteger a árvore, esquecidos de que ela é que nos protege”. – Carlos Drummond de Andrade. \n");
        sb.append("\t “Semear ideias ecológicas e plantar sustentabilidade é ter a garantia de colhermos um futuro fértil e consciente”. – Sivaldo Filho. \n");
        sb.append("\t “O maior de todos os erros é não fazer nada só porque se pode fazer pouco. Faça o que lhe for possível”. – Sydney Smith. \n");
        sb.append("\t “Chegará um dia no qual os homens conhecerão o íntimo dos animais. E, nesse dia, um crime contra um animal será considerado crime contra a humanidade”. – Leonardo da Vinci. \n");
        sb.append("\t “Os que são loucos o suficiente para pensar que podem mudar o mundo, são aqueles que realmente o fazem”. – Steve Jobs. \n");
        sb.append("\t “Nós vivemos na terra como se tivéssemos outra para ir”. – Terry Swearingen. \n");
        sb.append("\t “O futuro dependerá daquilo que fazemos no presente”. – Mahatma Gandhi. \n");
        sb.append("\t “Não tenha medo de ir devagar, só tenha medo de ficar parado”. – Provérbio Chinês. \n");
        sb.append("\t “Um livro, uma caneta, uma criança e um professor podem mudar o mundo”. – Malala Yousafzai. \n");
        sb.append("\t “A falta de amor é a maior de todas as pobrezas”. – Madre Teresa de Calcutá. \n");
        sb.append("\t “Olho por olho e o mundo acabará cego”. – Mahatma Gandhi. \n");
        sb.append("\t “Do ponto de vista do planeta, não existe jogar lixo fora, porque não existe fora”. – Autor Desconhecido. \n");
        sb.append("\t “A água de boa qualidade é como a saúde ou a liberdade, só tem valor quando acaba”. – Guimarães Rosa. \n");
        sb.append("\t “Uma nação que destrói seu território, destrói a si mesma”. – Franklin Roosevelt. \n");
        sb.append("\t “Todas as flores do futuro estão contidas nas sementes de hoje”. – Provérbio Chinês. \n");
        sb.append("\t “O coração do homem, quando longe da natureza, endurece”. – Ditado Lakota. \n");

        sb.append("\n\n");

        JTextArea telaSaida = new JTextArea();
        telaSaida.setText(sb.toString());

        JOptionPane.showMessageDialog(null, telaSaida, "Textos de reflexões", JOptionPane.PLAIN_MESSAGE);

        System.exit(0);
    }

    /**
     * Listener de eventos para os botões
     */
    public void actionPerformed(ActionEvent event) {

        /*se o evento for do botão sair*/
        if (event.getActionCommand().equals("botaoSair")) {
            saidaPrograma();
        } /*senão do botão iniciar jogo*/ else if (event.getActionCommand().equals("botaoIniciarJogo")) {

            String nomeObjJogador = fieldNomeJogador.getText();

            Jogador jogador = new Jogador(nomeObjJogador);

            if (jogoFacil) {
                new TelaDoJogo(jogador, indiceTema, 4);
            } else {
                new TelaDoJogo(jogador, indiceTema, 6);
            }
        }
    }

    /**
     * Listener de eventos para o combobox de temas
     */
    public void itemStateChanged(ItemEvent event) {

        if (event.getSource() == temasJogada) {
            if (event.getStateChange() == ItemEvent.SELECTED) {
                indiceTema = indiceTemas[temasJogada.getSelectedIndex()];
            }
        }
    }

}
