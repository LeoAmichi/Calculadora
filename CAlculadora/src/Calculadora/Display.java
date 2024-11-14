package Calculadora;

import javax.swing.*;
import java.awt.*;
public class Display{

private JTextField display; // O campo de texto é privado para controle interno

public Display() {
    display = new JTextField();
    display.setEditable(false); // Não permite edição direta
    display.setFont(new Font("Arial", Font.PLAIN, 32)); // Definindo fonte
    display.setHorizontalAlignment(JTextField.CENTER); // Alinhamento à direita
    display.setBackground(Color.BLACK); // Cor de fundo preta
    display.setForeground(Color.WHITE); // Cor do texto branca
    display.setPreferredSize(new Dimension(300, 80));
}

// Metodo para retornar o JTextField, permitindo usá-lo na classe Frame
public JTextField getDisplay() {
    return display;
}
}
