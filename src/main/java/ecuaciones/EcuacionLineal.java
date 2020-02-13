package ecuaciones;

public class EcuacionLineal {
    float a, b;

    public EcuacionLineal(float a, float b) {
        this.a = a;
        this.b = b;
    }

    public float resolver() throws ArithmeticException {
        if(a!=0) {
            if (b == 0) return 0;
            else return -b / a;
        }
        else
            throw new ArithmeticException();
    }
}
