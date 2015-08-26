package se.patrikbergman.java.client;

import se.patrikbergman.java.compute.Compute;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class ComputeClient {
    static Compute comp;

    public static void main(String args[]) {
        if(System.getSecurityManager() == null) {
            System.setSecurityManager(new SecurityManager());
        }
        try {
            lookupRemoteComputeService();
            System.out.printf("Computed pi with ten decimals: %s%n", computePi(10));
            System.out.printf("Computed factorial(4): %s ", computeFactorial(BigInteger.valueOf(4)));
        } catch (Exception e) {
            System.err.printf("%s caught exception: %s%n", ComputeClient.class.getSimpleName(), e.getMessage());
        }
    }

    static void lookupRemoteComputeService() throws RemoteException, NotBoundException {
        String name = "Compute";
        Registry registry = LocateRegistry.getRegistry();
        comp = (Compute) registry.lookup(name);
    }

    private static BigDecimal computePi(int nrOfDecimals) throws RemoteException {
        if(comp == null) {
            throw new RuntimeException("Remote compute service must not be null!");
        }
        return comp.executeTask(new Pi(nrOfDecimals));
    }

    private static BigInteger computeFactorial(BigInteger value) throws RemoteException {
        if(comp == null) {
            throw new RuntimeException("Remote compute service must not be null!");
        }
        return comp.executeTask(new Factorial(value));
    }
}
