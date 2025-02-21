import org.ed05_1.Coche;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class CocheTest {

    @Test
    void testValidarNumBastidorValido() {
        assertTrue(Coche.validarNumBastidor("12345678901234567"));
    }

    @Test
    void testValidarNumBastidorNull() {
        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> {
            Coche.validarNumBastidor(null);
        });
        assertEquals("El número de bastidor no puede ser nulo", thrown.getMessage());
    }

    @Test
    void testValidarNumBastidorLengthUnder17() {
        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> {
            Coche.validarNumBastidor("1234567890123456");
        });
        assertEquals("El número de bastidor debe tener 17 caracteres", thrown.getMessage());
    }

    @ParameterizedTest
    @ValueSource(strings = {"12345678901234567", "12345678901234568", "12345678901234569"})
    void testValidarNumBastidorValidos(String numBastidor) {
        assertTrue(Coche.validarNumBastidor(numBastidor));
    }

    @ParameterizedTest
    @CsvSource({
            "I2345678901234567, 'El número de bastidor no puede contener las letras I, O o Q'",
            "O2345678901234567, 'El número de bastidor no puede contener las letras I, O o Q'",
            "Q2345678901234567, 'El número de bastidor no puede contener las letras I, O o Q'"
    })
    void testValidarNumBastidorInvalidos(String numBastidor, String expectedMessage) {
        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> {
            Coche.validarNumBastidor(numBastidor);
        });
        assertEquals(expectedMessage, thrown.getMessage());
    }
}
