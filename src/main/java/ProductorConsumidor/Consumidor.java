package ProductorConsumidor;

public class Consumidor implements Runnable
{
    private Buffer buffer;

    public Consumidor(Buffer buffer)
    {   this.buffer = buffer;   }

    public void run()
    {
        while(true)
        {
            Object numero   = this.buffer.pop();
            System.out.print("Numero: " + numero);
        }

    }
}
