package se.patrikbergman.java.client;

import org.junit.Test;

import java.math.BigInteger;

import static org.junit.Assert.assertEquals;

public class ComputeFactorialTest {

    @Test
    public void calculateFactorialThreeTest() {
        assertEquals(BigInteger.valueOf(6), new Factorial(BigInteger.valueOf(3)).execute());
    }

    @Test
    public void calculateFactorialFourTest() {
        assertEquals(BigInteger.valueOf(24), new Factorial(BigInteger.valueOf(4)).execute());
    }

    @Test(expected = IllegalArgumentException.class)
    public void calculateFactorialNegativeValueTest() {
        new Factorial(BigInteger.valueOf(-10)).execute();
    }
}
