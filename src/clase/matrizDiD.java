/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clase;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Joel
 */
public class matrizDiD {

    private int tamaño;

    private int contador = 1, limiteFila = 0, limiteColumna = 0, f = 0, c = 0;
    private int serie[][];

    public matrizDiD(int tamaño) {
        this.tamaño = tamaño;
    }

    public int[][] llenarMatriz() {
        serie = new int[this.tamaño][this.tamaño];
        c = this.tamaño - 1;
        limiteColumna = this.tamaño - 1;
        //COMPLETA ESQUINA INFERIOR
        do {
            for (f = this.tamaño - 1; c >= 0; f--, c--) {
                serie[f][c] = contador;
                contador++;
            }

            c = c + 1;
            limiteFila++;

            for (f +=2; c < limiteColumna; f++, c++) {
                serie[f][c] = contador;
                contador++;
            }
            limiteColumna-=2;
            c -=2;
            limiteFila++;
            //mientras fila menor tamaño haga
        } while (limiteFila < this.tamaño);
        return serie;

    }

    public void imprimirM(int[][] matriz, JTable nombre) {
        DefaultTableModel modelo = (DefaultTableModel) nombre.getModel();
        modelo.setColumnCount(this.tamaño);
        modelo.setRowCount(this.tamaño);

        for (int fil = 0; fil < this.tamaño; fil++) {
            for (int col = 0; col < this.tamaño; col++) {
                nombre.setValueAt(matriz[fil][col], fil, col);
            }
        }
    }

}
