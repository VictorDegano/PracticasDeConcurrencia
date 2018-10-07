package Semaforo;


public class Semaforo
{
    private int permisos;

    public Semaforo(int permisos)
    {   this.permisos = permisos; }

    public synchronized void acquire()
    {
        while(this.permisos == 0)
        {
            try
            {   wait(); }
            catch(InterruptedException e)
            {   return; }
        }
        this.permisos--;
    }

    public synchronized void release()
    {
        this.permisos++;
        notifyAll();
    }

}
