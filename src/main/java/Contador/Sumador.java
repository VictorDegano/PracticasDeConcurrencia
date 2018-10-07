package Contador;

public class Sumador implements Runnable {

    private Contador contador;

    public Sumador(Contador contador)
    {   this.contador = contador;   }

    public void run()
    {
        while (true)
        {   this.contador.incrementar();    }
    }
}
