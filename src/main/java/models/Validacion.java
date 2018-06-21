package models;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JTextField;

public class Validacion {

    public void validarSoloLetras(JTextField campo) {
        campo.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (Character.isDigit(c)) {
                    e.consume();
                }
            }
        }
        );
    }

    public void validarNumerosPuntos(JTextField campo) {
        campo.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (((c < '0') || (c > '9'))
                        && (c != KeyEvent.VK_BACK_SPACE)
                        && (c != '.' || campo.getText().contains("."))) {
                    e.consume();
                }
            }
        }
        );
    }

    public void validarSoloNumeros(JTextField campo) {
        campo.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (!Character.isDigit(c)) {
                    e.consume();
                }

            }
        }
        );
    }

    public void limitarCaracteres(JTextField campo, int cantidad) {
        campo.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                int tam = campo.getText().length();
                if (tam >= cantidad) {
                    e.consume();
                }
            }
        }
        );
    }

        public static float formatearDecimales(float numero, Integer numeroDecimales) {
    return (float) (Math.round(numero * Math.pow(10, numeroDecimales)) / Math.pow(10, numeroDecimales));
}
    
    
}
