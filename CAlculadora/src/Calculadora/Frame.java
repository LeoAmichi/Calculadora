package Calculadora;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Frame {

    public JFrame frame;
    public Botões[] botoes = new Botões[16];
    public Display display;
    public String firstNumber = "";
    public String operador = "";
    public Double resultado = 0.0;

    public Frame() {
        frame = new JFrame();
        frame.setTitle("Calculadora");
        frame.setSize(350, 500);
        frame.setVisible(true);
        frame.setResizable(false);

        ImageIcon image = new ImageIcon("calculadora.png");
        frame.setIconImage(image.getImage());
        frame.getContentPane().setBackground(Color.BLACK);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        display = new Display();
        frame.add(display.getDisplay(), BorderLayout.NORTH );

        JPanel painelBotoes = new JPanel();
        painelBotoes.setLayout(new GridLayout(4, 4, 10, 10));
        painelBotoes.setBackground(Color.darkGray);

        String[] textosBotoes = {
                "7", "8", "9", "/",
                "4", "5", "6", "*",
                "1", "2", "3", "-",
                "C", "0", "=", "+"
        };

        for (int i = 0; i < botoes.length; i++) {
            botoes[i] = new Botões(textosBotoes[i]);
            painelBotoes.add(botoes[i].getButton());
        }

        setUpButtonListeners();
        frame.add(painelBotoes, BorderLayout.CENTER);

        frame.setVisible(true);
    }

    public void setUpButtonListeners() {
        for (final Botões botao : botoes) {
            botao.getButton().addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String buttonText = botao.getButton().getText();
                    String currentText = display.getDisplay().getText();

                    if (buttonText.equals("C")) {
                        display.getDisplay().setText("");
                        firstNumber = "";
                        operador = "";
                        resultado = 0.0;
                    }
                    else if (buttonText.equals("+") || buttonText.equals("-") || buttonText.equals("*") || buttonText.equals("/")) {
                        display.getDisplay().setText("");
                        operador = buttonText;
                        firstNumber = currentText;
                    }
                    else if (buttonText.equals("=")) {
                        if (!firstNumber.isEmpty() && !currentText.isEmpty() && !operador.isEmpty()) {
                            resultado = Calculo.Calcular(operador, resultado, firstNumber, currentText);
                            display.getDisplay().setText(String.valueOf(resultado));
                        }
                    }
                    else {
                        display.getDisplay().setText(currentText + buttonText);
                    }
                }
            });
        }
    }

}
