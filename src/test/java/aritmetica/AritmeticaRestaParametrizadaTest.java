package aritmetica;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class AritmeticaRestaParametrizadaTest {
    private static Aritmetica aritmetica;

    static Stream<Arguments> datos() {
        return Stream.of(
                Arguments.of(1.0f, 1.0f, 0.0f),
                Arguments.of(2.0f, 1.0f, 1.0f),
                Arguments.of(1.0f, 2.0f, -1.0f)
        );
    }

    @BeforeAll
    public static void setUp() {
        aritmetica = new Aritmetica();
    }

    @ParameterizedTest
    @MethodSource("datos")
    public void restasTest(float minuendo, float sustraendo, float resultado) {
        assertThat(aritmetica.resta(minuendo, sustraendo), is(resultado));

    }
}