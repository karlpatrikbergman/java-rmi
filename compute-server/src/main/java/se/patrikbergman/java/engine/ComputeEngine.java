package se.patrikbergman.java.engine;

import se.patrikbergman.java.compute.Compute;
import se.patrikbergman.java.compute.Task;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class ComputeEngine implements Compute {

    public <T> T executeTask(Task<T> task) throws RemoteException {
        return task.execute();
    }

    public static void main(String[] args) {
        System.out.println("In compute engine");
        if (System.getSecurityManager() == null) {
            System.setSecurityManager(new SecurityManager());
        }

        try {
            String name = "Compute";
            Compute engine = new ComputeEngine();

            //The static UnicastRemoteObject.exportObject method exports the supplied remote object so that it can
            // receive invocations of its remote methods from remote clients. The second argument, an int, specifies
            // which TCP port to use to listen for incoming remote invocation requests for the object.
            // It is common to use the value zero, which specifies the use of an anonymous port. The actual port will
            // then be chosen at runtime by RMI or the underlying operating system. However, a non-zero value can also
            // be used to specify a specific port to use for listening. Once the exportObject invocation has returned
            // successfully, the ComputeEngine remote object is ready to process incoming remote invocations.
            Compute stub = (Compute) UnicastRemoteObject.exportObject(engine, 0);

            Registry registry = LocateRegistry.getRegistry();
            registry.rebind(name, stub);
            System.out.println("ComputeEngine bound");

        } catch (Exception e) {
            System.err.println("ComputeEngine exception:");
            e.printStackTrace();
        }
    }
}
