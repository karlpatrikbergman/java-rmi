package se.patrikbergman.java.compute;

import java.io.Serializable;
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Compute extends Remote, Serializable {
    long serialVersionUID = 227L;
    <T> T executeTask(Task<T> task) throws RemoteException;
}
