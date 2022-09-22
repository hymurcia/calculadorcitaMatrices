package calculadorcita;

import java.util.Random;
import javax.swing.JOptionPane;
/**
 *
 * @author Yessid Murcia
 */
public class CalculadoraDeMatrices {

    private JCTextField[][] matriz;

    /**
     * Constructor de clase
     */
    CalculadoraDeMatrices(int dimensionx, int dimensiony) {
        matriz = new JCTextField[dimensionx][dimensiony];
        for (int fila = 0; fila < dimensionx; fila++) {
            for (int columna = 0; columna < dimensiony; columna++) {
                matriz[fila][columna] = new JCTextField();
            }
        }
    }

    public JCTextField[][] getMatriz() {
        return matriz;
    }

    public void setMatriz(JCTextField[][] matriz) {
        this.matriz = matriz;
    }

    /**
     * metodo de suma de matrices nxn
     */
    public int[][] sumar(JCTextField[][] matrizB) {
        int m[][] = new int[matriz.length][matriz.length];
        for (int k = 0; k < matriz.length; k++) {
            for (int j = 0; j < matriz.length; j++) {

                m[k][j] += Integer.parseInt(matriz[k][j].getText()) + Integer.parseInt(matrizB[k][j].getText());
            }
        }
        return m;
    }

    /**
     * metodo de resta de matrices nxn
     */
    public int[][] restar(JCTextField[][] matrizB) {
        int m[][] = new int[matriz.length][matriz.length];
        for (int k = 0; k < matriz.length; k++) {
            for (int j = 0; j < matriz.length; j++) {

                m[k][j] += Integer.parseInt(this.matriz[k][j].getText()) - Integer.parseInt(matrizB[k][j].getText());
            }
        }
        return m;
    }

    /**
     * metodo de traza de matrices nxn
     */
    public void traza(JCTextField[][] matrizA) {
        int m[][] = new int[matriz.length][matriz.length];
        int r = 0;
        for (int k = 0; k < matriz.length; k++) {
            for (int j = 0; j < matriz.length; j++) {
                if (k == j) {
                    int a = Integer.parseInt(matriz[k][j].getText());
                    r = r + a;
                }
            }
        }
        JOptionPane.showMessageDialog(null, "El resultado de la Traza es:" + r);
    }

    public void conversorJCTField(JCTextField[][] matriz, int n) {
        int m[][] = new int[matriz.length][matriz.length];
        for (int k = 0; k < matriz.length; k++) {
            for (int j = 0; j < matriz.length; j++) {
                m[k][j] = Integer.parseInt(matriz[k][j].getText());
            }
        }
        JOptionPane.showMessageDialog(null, "Su determinante es: "+determinante(m, n));
    }

    /**
     * metodo de cofactor de matrices nxn
     */
    public void obtenerCofactor(int matriza[][], int temp[][], int p, int q, int n) {
        int i = 0, j = 0;

        for (int fila = 0; fila < n; fila++) {
            for (int columna = 0; columna < n; columna++) {
                if (fila != p && columna != q) {
                    temp[i][j++] = matriza[fila][columna];

                    if (j == n - 1) {
                        j = 0;
                        i++;
                    }

                }
            }
        }
    }

    /**
     * metodo de determinante de matrices nxn
     */
    public int determinante(int matriza[][], int n) {

        int determinante = 0;
        if (n == 1) {
            return matriza[0][0];
        }
        if (n != 1) {
            int temp[][] = new int[n][n];
            int multiplicador = 1;
            for (int f = 0; f < n; f++) {
                obtenerCofactor(matriza, temp, 0, f, n);
                determinante += multiplicador * matriza[0][f] * determinante(temp, n - 1);
                multiplicador = -multiplicador;
            }

        }
        return determinante;
    }

    /**
     * metodo de multplicacion de matrices nxn
     *
     * public int[][] multiplicar(JCTextField[][] matrizB) { int m[][] = new
     * int[matriz.length][matriz.length]; for ( int k = 0; k < matriz.length;
     * k++) { for ( int j = 0; j < matriz.length; j++) { for ( int i = 0; i <
     * matriz.length; i++ ) m[ k ][j ] +=
     * Integer.parseInt(matriz[k][i].getText()) *
     * Integer.parseInt(matrizB[i][j].getText()); } } return m; }
     */
    
    
    
    
    /**
     * Llena la matriz con numeros aleatorios
     *
     */
    public void generate() {
        Random rn = new Random();
        for (int fila = 0; fila < matriz.length; fila++) {
            for (int columna = 0; columna < matriz.length; columna++) {
                matriz[fila][columna].setText(String.valueOf((rn.nextInt(55) + 1)));
            }
        }
    }

}
