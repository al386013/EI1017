package ecuaciones;

import java.util.HashSet;

public class EcuacionCuadratica {
    float a, b, c;

    public EcuacionCuadratica(float a, float b, float c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public HashSet<Float> resolver() {
        HashSet<Float> conjunto = new HashSet<Float>();
        if (a == 0) { // bx + c = 0; ecuacion lineal
            EcuacionLineal ecLineal = new EcuacionLineal(b, c);
            conjunto.add(ecLineal.resolver());
        } else if (b == 0 && c == 0) // ax^2 = 0
            conjunto.add(0.0f);
        else if (b == 0) { // ax^2 + c = 0
            if (c < 0) {
                conjunto.add((float) Math.sqrt(-c / a));
                conjunto.add(-(float) Math.sqrt(-c / a));
            }
            else  //raíz cuadrada negativa, número imaginario con parte real e imaginaria
                return numImaginario(0,(float) Math.sqrt(c/a));
        } else if (c == 0) { // ax^2 + bx = 0 --> x*(ax + b) = 0
            EcuacionLineal ecLineal = new EcuacionLineal(a, b);
            conjunto.add(ecLineal.resolver());
            conjunto.add(0.0f);
        } else { //ax^2 + bx + c = 0
            float discriminante = (b * b) - (4 * a * c);
            if (discriminante >= 0) {
                conjunto.add((float) (-b + Math.sqrt(discriminante)) / (2 * a));
                conjunto.add((float) (-b - Math.sqrt(discriminante)) / (2 * a));
            }
            else {
                conjunto.addAll(numImaginario(-b/(2*a), (float)Math.sqrt(-discriminante)/(2*a)));
                conjunto.addAll(numImaginario(-b/(2*a), -(float)Math.sqrt(-discriminante)/(2*a)));
            }
        }
        return conjunto;
    }

    private HashSet<Float> numImaginario(float parteReal, float parteImaginaria) {
        HashSet<Float> conjunto = new HashSet<Float>();
        NumeroImaginario imaginario = new NumeroImaginario(parteReal,parteImaginaria);
        conjunto.add(imaginario.getParteReal());
        conjunto.add(imaginario.getParteImag());
        return conjunto;
    }
}
