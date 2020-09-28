package test;

import es.upm.miw.iwvg_devops.code.Fraction;
import es.upm.miw.iwvg_devops.code.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class UserTest {
    private User user;
    private List<Fraction> fractions;

    @BeforeEach
    void before() {
        fractions = new ArrayList<Fraction>();
        fractions.add(new Fraction(1, 2));
        fractions.add(new Fraction(2, 3));
        fractions.add(new Fraction(5, 9));
        user = new User("1", "Alejandro", "Rodriguez", fractions);
    }

    @Test
    void testNewUser() {
        user = new User();
        assertEquals(null, user.getId());
        assertEquals(null, user.getName());
        assertEquals(null, user.getFamilyName());
        assertEquals(new ArrayList<Fraction>(), user.getFractions());
    }

    @Test
    void testUser() {
        assertEquals("1", user.getId());
        assertEquals("Alejandro", user.getName());
        assertEquals("Rodriguez", user.getFamilyName());
        assertEquals(fractions, user.getFractions());
    }

    @Test
    void testAddFraction() {
        Fraction f1 = new Fraction(6, 8);
        user.addFraction(f1);
        assertEquals(f1, user.getFractions().get(3));
    }

    @Test
    void testFullName() {
        assertEquals("Alejandro Rodriguez", user.fullName());
    }

    @Test
    void testInititals() {
        assertEquals("A.", user.initials());
    }

}