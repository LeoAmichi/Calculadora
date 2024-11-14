package Calculadora;

import javax.swing.*;
import java.awt.*;


public class Botões {

    private JButton button;  // Botão que será criado

    public Botões(String texto) {
        button = new JButton(texto);  // Cria o botão com o texto fornecido
        button.setFont(new Font("Arial", Font.PLAIN, 24));  // Definindo o estilo da fonte
        button.setBackground(Color.GRAY);  // Cor de fundo para os botões
        button.setForeground(Color.WHITE);  // Cor do texto

    }

    // Metodo para obter o botão
    public JButton getButton() {
        return button;
    }
}
