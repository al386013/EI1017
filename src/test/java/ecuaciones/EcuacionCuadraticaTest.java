package ecuaciones;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.HashSet;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class EcuacionCuadraticaTest {
	private static HashSet<Float> conjunto;

	@BeforeAll
	public static void init() {
		conjunto = new HashSet<Float>();
	}

	@AfterEach
	public void finish() {
		conjunto.clear();
	}

	@Test // todo La anotación de JUnit 5 es la del paquete jupiter
	public void ecuacionLinealTest() {
		EcuacionCuadratica ecuacionCuadratica = new EcuacionCuadratica(0, 1, 1); // x + 1 = 0
		conjunto.add(-1.0f);
		assertThat(ecuacionCuadratica.resolver(), is(conjunto));

		conjunto.clear();
		ecuacionCuadratica = new EcuacionCuadratica(0,2, 1); // 2x + 1 = 0
		conjunto.add(-0.5f);
		assertThat(ecuacionCuadratica.resolver(), is(conjunto));
	}

	@Test
	public void bycIgualACero() {
		EcuacionCuadratica ecuacionCuadratica = new EcuacionCuadratica(2, 0, 0); // 2x^2 = 0
		conjunto.add(0.0f);
		assertThat(ecuacionCuadratica.resolver(), is(conjunto));
	}

	@Test
	public void bCeroCNegativo() {
		EcuacionCuadratica ecuacionCuadratica = new EcuacionCuadratica(2, 0, -18); // 2x^2 - 18 = 0
		conjunto.add(3.0f);
		conjunto.add(-3.0f);
		assertThat(ecuacionCuadratica.resolver(), is(conjunto));
	}

	@Test
	public void bCeroCPositivo() {
		//parte real igual a cero
		EcuacionCuadratica ecuacionCuadratica = new EcuacionCuadratica(1, 0, 64); // x^2 + 64 = 0
		conjunto.add(0.0f); //parte real
		conjunto.add(8.0f); //parte imaginaria
		assertThat(ecuacionCuadratica.resolver(), is(conjunto));

		//parte real distinta de cero
		conjunto.clear();
		ecuacionCuadratica = new EcuacionCuadratica(1, -6, 13); // x^2 - 6x + 13 = 0
		conjunto.add(6/2.0f); //parte real
		conjunto.add(2.0f); //parte imaginaria
		conjunto.add(-2.0f); //parte imaginaria
		assertThat(ecuacionCuadratica.resolver(), is(conjunto));
	}

	@Test
	public void terminoIndependienteCero() {
		EcuacionCuadratica ecuacionCuadratica = new EcuacionCuadratica(4, -2, 0); // 4x^2 - 2x = 0
		conjunto.add(0.0f);
		conjunto.add(0.5f);
		assertThat(ecuacionCuadratica.resolver(), is(conjunto));

		conjunto.clear();
		ecuacionCuadratica = new EcuacionCuadratica(2, 4, 0); // 2x^2 + 4x = 0
		conjunto.add(0.0f);
		conjunto.add(-2.0f);
		assertThat(ecuacionCuadratica.resolver(), is(conjunto));
	}

	@Test
	public void discriminantePositivo() {
		EcuacionCuadratica ecuacionCuadratica = new EcuacionCuadratica(2, -7, 3); // 2x^2 - 7x + 3 = 0
		conjunto.add(3.0f);
		conjunto.add(0.5f);
		assertThat(ecuacionCuadratica.resolver(), is(conjunto));

		conjunto.clear();
		ecuacionCuadratica = new EcuacionCuadratica(7, 21, -28); // 7x^2 + 21x - 28 = 0
		conjunto.add(1.0f);
		conjunto.add(-4.0f);
		assertThat(ecuacionCuadratica.resolver(), is(conjunto));
	}

	@Test
	public void discriminanteCero() { //solucion doble
		EcuacionCuadratica ecuacionCuadratica = new EcuacionCuadratica(1, -2, 1); // x^2 - 2x + 1 = 0
		conjunto.add(1.0f);
		assertThat(ecuacionCuadratica.resolver(), is(conjunto));
	}

	// todo No tiene soluciones imaginarias ;)
	@Test
	public void discriminanteNegativo() { //numero imaginario
		EcuacionCuadratica ecuacionCuadratica = new EcuacionCuadratica(1, -2, 1); // x^2 - 2x + 1 = 0
		conjunto.add(1.0f);
		assertThat(ecuacionCuadratica.resolver(), is(conjunto));
	}
}
