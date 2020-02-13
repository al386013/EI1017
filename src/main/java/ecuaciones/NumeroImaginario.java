package ecuaciones;

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

    public float getMódulo() {
        return (float)Math.sqrt(Math.pow(parteReal, 2) + Math.pow(parteImag, 2));
    }

    public float getArgumento() {
        return (float)Math.atan2(parteImag, parteReal);
    }

}
