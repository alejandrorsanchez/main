package test;

import es.upm.miw.iwvg_devops.code.Fraction;
import es.upm.miw.iwvg_devops.code.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FractionTest {

    private Fraction fraction;

    @BeforeEach
    void before() {
        fraction = new Fraction(3, 7);
    }

    @Test
    void testNewFraction() {
        Fraction f1 = new Fraction();
        assertEquals( 1, f1.getNumerator());
        assertEquals( 1, f1.getDenominator());
    }

    @Test
    void testFraction() {
        Fraction f1 = new Fraction(6, 15);
        assertEquals(6, f1.getNumerator());
        assertEquals(15, f1.getDenominator());
    }

    @Test
    void testFractionAtributes() {
        assertEquals(3, fraction.getNumerator());
        assertEquals(7, fraction.getDenominator());
        fraction.setNumerator(4);
        assertEquals(4, fraction.getNumerator());
        fraction.setDenominator(9);
        assertEquals(9, fraction.getDenominator());
    }

    @Test
    void testDecimal() {
        assertEquals(0.42857142857142855, fraction.decimal());
    }

}
