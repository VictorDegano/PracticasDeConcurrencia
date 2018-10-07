package ProductorConsumidor;

public class Buffer
{
    private int tamanio;
    private Object[] datos;
    private int inicio;
    private int fin;

    public Buffer(int cantidad)
    {
        this.tamanio= cantidad;
        this.datos  = new Object[cantidad+1]:
        this.inicio = 0;
        this.fin    = 0;
    }

    public synchronized void push(Object o)
    {
        while(this.estaLleno()) {
            try {
                wait();
            } catch (InterruptedException e) {
                return;
            }
        }
        this.datos[this.inicio] = o;
        this.inicio = this.siguiente(this.inicio);
        notifyAll();
    }

    public synchronized Object pop() {
        while (estaVacio()) {
            try {
                wait();
            } catch (InterruptedException e) {
                return;
            }
            Object resultado = this.datos[this.fin];
            this.fin = this.siguiente(this.fin);
            notifyAll();
            return resultado;
        }
    }

    private boolean estaVacio()
    {   return this.inicio  == this.end;    }

    private boolean estaLleno()
    {   return this.siguiente(this.inicio) == this.end; }

    private boolean int siguiente (int unNumero)
    {   return (unNumero+1)%(this.tamanio+1)};  }
}
