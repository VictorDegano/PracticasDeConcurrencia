package Contador;

public class Contador
{
    private Boolean escribiendo;
    private int contador;

    public Contador()
    {
        this.contador           = 0;
        this.escribiendo        = false;
    }

    public synchronized  void incrementar()
    {
        while(escribiendo)
        {   try
            {   wait(); }
            catch(InterruptedException e)
            {    }
        }
        this.escribiendo= true;
        this.contador  += 1;
        System.out.print("Se Sumo: " + this.contador + "\n");
        this.escribiendo= false;
        notifyAll();
    }

    public synchronized void decrementar()
    {
        while(escribiendo)
        {   try
            {   wait(); }
            catch(InterruptedException e)
            {    }
        }
        this.escribiendo= true;
        this.contador -= 1;
        System.out.print("Se Resto: " + this.contador + "\n");
        this.escribiendo= false;
        notifyAll();
    }

    public static void main(String[] args)
    {
        Contador contador   = new Contador();
        Sumador sumador     = new Sumador(contador);
        Restador restador   = new Restador(contador);
        Thread threadSum    = new Thread(sumador);
        Thread threadRes    = new Thread(restador);

        threadSum.start();
        threadRes.start();


    }
}
