package calculadorcita;

/**
 *
 * @author Dirley Puentes && Yessid Murcia
 */
public class Operaciones_Punto2 implements Numero {

    @Override
    public double suma(double num, double num2) {
        return num+num2;
    }

    @Override
    public double resta(double num, double num2) {
        return num-num2;
    }

    @Override
    public double multiplicacion(double num, double num2) {
        return num*num2;
    }

    @Override
    public double division(double num, double num2) {
        return num/num2;
    }    
    
}
