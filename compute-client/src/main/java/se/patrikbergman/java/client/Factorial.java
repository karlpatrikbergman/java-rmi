package se.patrikbergman.java.client;

import se.patrikbergman.java.compute.Task;

import java.io.Serializable;
import java.math.BigInteger;

public class Factorial implements Task<BigInteger>, Serializable {
    private static final long serialVersionUID = 227L;
    private final BigInteger value;

    public Factorial(BigInteger value) {
        this.value = value;
    }

    @Override
    public BigInteger execute() {
        return factorial(value);
    }

    BigInteger factorial(BigInteger c) {
        if(c.signum() == -1)  {
            throw new IllegalArgumentException("Argument cannot be a negative value!");
        }
        if(c.signum() == 0) {
            return BigInteger.valueOf(1);
        } else {
            return c.multiply(factorial(c.subtract(BigInteger.ONE)));
        }
    }
}
