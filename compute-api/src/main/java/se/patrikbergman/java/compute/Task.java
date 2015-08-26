package se.patrikbergman.java.compute;

import java.io.Serializable;

public interface Task<T> extends Serializable {
    long serialVersionUID = 227L;
    T execute();
}
