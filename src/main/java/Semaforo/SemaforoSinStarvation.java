package Semaforo;

import java.util.ArrayDeque;
import java.util.Collection;
import java.util.Iterator;
import java.util.Queue;

public class SemaforoSinStarvation
{
    private Queue<Object> waitingThreads;
    private int permisos;
    private int permisosPasados;

    public SemaforoSinStarvation(int permisos)
    {
        this.permisos       = permisos;
        this.permisosPasados= 0;
        this.waitingThreads = new ArrayDeque<Object>();
    }

    public synchronized void acquire()
    {
        this.waitingThreads.add(Thread.currentThread());
        while(this.permisos == 0)
        {
            try
            {   wait(); }
            catch(InterruptedException e)
            {   return; }
            if (this.permisosPasados > 0 && this.waitingThreads.contains(Thread.currentThread()))
            {
                this.permisosPasados--;
                this.waitingThreads.remove(Thread.currentThread());
                return;
            }
        }
        this.permisos--;
    }

    public synchronized void release()
    {
        if (this.waitingThreads.isEmpty())
        {   this.permisos++;    }
        else
        {
            this.permisosPasados++;
            notifyAll();
        }

    }
}
