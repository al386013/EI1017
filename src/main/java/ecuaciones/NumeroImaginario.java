package ecuaciones;

// todo Esta clase no la usáis para los tests.
public class NumeroImaginario {
    private float parteReal;
    private float parteImag;

    public NumeroImaginario() {
        parteReal = parteImag = 0;
    }

    public NumeroImaginario(float parteReal, float parteImag) {
        this.parteReal = parteReal;
        this.parteImag = parteImag;
    }

    public float getParteReal() {
        return parteReal;
    }

    public float getParteImag() {
        return parteImag;
    }

    // todo Cuidado con los acentos y letras que no sean inglesas.
    // todo Si no lo necesitáis, no lo defináis.
    public float getMódulo() {
        return (float)Math.sqrt(Math.pow(parteReal, 2) + Math.pow(parteImag, 2));
    }

    public float getArgumento() {
        return (float)Math.atan2(parteImag, parteReal);
    }

}
