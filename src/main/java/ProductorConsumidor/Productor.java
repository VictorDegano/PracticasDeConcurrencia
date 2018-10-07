package ProductorConsumidor;

public class Productor implements Runnable
{
    private Buffer buffer;

    public Productor(Buffer unBuffer)
    {   this.buffer = unBuffer; }

    public void run()
    {
        int valor   = 0;
        while(true)
        {
            this.buffer.push(valor);
            valor++;
        }
    }
}
