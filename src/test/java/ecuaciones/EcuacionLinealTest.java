package ecuaciones;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class EcuacionLinealTest {

    // todo Tenéis importada la anotación, no hace falta que añadáis el paquete.
    @Test
	public void terminoIndependienteCeroTest() {
		EcuacionLineal ecuacionLineal = new EcuacionLineal(1, 0); // x + 0 = 0
        assertThat(ecuacionLineal, notNullValue());
        assertThat(ecuacionLineal.resolver(), is(0.0f));
    }

    @Test
	public void distintosDeCeroTest() {
		EcuacionLineal ecuacionLineal = new EcuacionLineal(1, 1); // x + 1 = 0
        assertThat(ecuacionLineal, notNullValue());
        assertThat(ecuacionLineal.resolver(), is(-1.0f));

		ecuacionLineal = new EcuacionLineal(2, 1); // 2x + 1 = 0
        assertThat(ecuacionLineal, notNullValue());
        assertThat(ecuacionLineal.resolver(), is(-0.5f));
	}

    @Test
    public void terminoIndependienteNegativo() {
        EcuacionLineal ecuacionLineal = new EcuacionLineal(1, -4); // x - 4 = 0
        // A partir de aquí, el código que comprueba que la solución es correcta
        assertThat(ecuacionLineal, notNullValue());
        assertThat(ecuacionLineal.resolver(), is(4.0f));
    }

    @Test
    public void terminoNoIndependienteNegativo() {
        EcuacionLineal ecuacionLineal = new EcuacionLineal(-2, 1); // -2x + 1 = 0
        // A partir de aquí, el código que comprueba que la solución es correcta
        assertEquals(0.5, ecuacionLineal.resolver());
        assertThat(ecuacionLineal, notNullValue());
        assertThat(ecuacionLineal.resolver(), is(0.5f));
    }

    @Test
    public void terminosNegativos() {
        EcuacionLineal ecuacionLineal = new EcuacionLineal(-2, -4); // -2x - 4 = 0
        // A partir de aquí, el código que comprueba que la solución es correcta
        assertThat(ecuacionLineal, notNullValue());
        assertThat(ecuacionLineal.resolver(), is(-2.0f));
    }
}
