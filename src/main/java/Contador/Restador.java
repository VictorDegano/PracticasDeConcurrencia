package Contador;

public class Restador implements Runnable
{

    private Contador contador;

    public Restador(Contador contador)
    {   this.contador = contador;   }

    public void run()
    {
        while(true)
        {   this.contador.decrementar();    }
    }
}
