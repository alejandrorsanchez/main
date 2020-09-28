package test;

import es.upm.miw.iwvg_devops.code.Fraction;
import es.upm.miw.iwvg_devops.code.Searches;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SearchesTest {

    @Test
    void testFindFractionAdition() {
        Fraction f = new Fraction(3, 1);
        assertEquals(f.getNumerator(), new Searches().findFractionAdditionByUserId("1").getNumerator());
        assertEquals(f.getDenominator(), new Searches().findFractionAdditionByUserId("1").getDenominator());
    }

    @Test
    void testFindFirstDecimal() {
        assertEquals(0, new Searches().findFirstDecimalFractionByUserName("Antonio"));
    }

    @Test
    void testFindNegativeFraction() {
        assertEquals(List.of("Blanco", "López", "Blanco"), new Searches().findUserFamilyNameByAllNegativeSignFractionDistinct()
                .collect(Collectors.toList()));
    }

    @Test
    void testFindImproperFraction() {
        assertEquals(List.of("Fernandez", "Blanco", "López", "Blanco", "Torres"), new Searches().findUserFamilyNameByImproperFraction()
                .collect(Collectors.toList()));
    }
}
