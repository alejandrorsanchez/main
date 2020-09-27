package test;

import es.upm.miw.iwvg_devops.code.Fraction;
import es.upm.miw.iwvg_devops.code.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

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

    @Test
    void testProper() {
        Fraction f1 = new Fraction(2, 3);
        assertTrue(fraction.isProper(f1));
    }

    @Test
    void testNoProper() {
        Fraction f1 = new Fraction(3, 2);
        assertTrue(fraction.isNoProper(f1));
    }

    @Test
    void testIsEquivalent() {
        Fraction f1 = new Fraction(1, 2);
        Fraction f2 = new Fraction(2, 4);
        assertTrue(f1.isEquivalent(f2));
    }

    @Test
    void testAdd() {
        Fraction f1 = new Fraction(3, 2);
        Fraction f2 = new Fraction(2, 3);
        assertEquals(13, f1.add(f2).getNumerator());
        assertEquals(6, f1.add(f2).getDenominator());
    }

    @Test
    void testMultiply() {
        Fraction f1 = new Fraction(3, 2);
        Fraction f2 = new Fraction(2, 3);
        assertEquals(6, f1.multiply(f2).getNumerator());
        assertEquals(6, f1.multiply(f2).getDenominator());
    }

    @Test
    void testDivide() {
        Fraction f1 = new Fraction(3, 2);
        Fraction f2 = new Fraction(2, 3);
        assertEquals(9, f1.divide(f2).getNumerator());
        assertEquals(4, f1.divide(f2).getDenominator());
    }

    @Test
    void testFindFractionAdition() {
        Fraction f = new Fraction(3, 1);
        assertEquals(f.getNumerator(), new Fraction().findFractionAdditionByUserId("1").getNumerator());
        assertEquals(f.getDenominator(), new Fraction().findFractionAdditionByUserId("1").getDenominator());
    }

    @Test
    void testFindFirstDecimal() {
        assertEquals(0, new Fraction().findFirstDecimalFractionByUserName("Antonio"));
    }

    @Test
    void testFindNegativeFraction() {
        assertEquals(List.of("Blanco","López", "Blanco"), new Fraction().findUserFamilyNameByAllNegativeSignFractionDistinct()
                .collect(Collectors.toList()));
    }

}
