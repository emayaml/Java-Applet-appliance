
package archivos;

public class Queue {
    private Node first;   // el que sacamos de la cola
    private Node last;    // en donde ingresamos
    
    public Queue()
    {
        first= null;
        last = null;
    }
    
    public boolean isEmpty()
    {
        return first==null && last==null;
    }
    
    public void Enqueue(Object data)
    {
        if(isEmpty())
        {
            first = new Node(data);
            last = first;
        }
        else
        {
            Node nuevo = new Node(data);
            last.setLink(nuevo);
            last = nuevo;
        }
    }
    
    public Object Dequeue()
    {
        Object obj = null;
        if(!isEmpty())
        {
            obj = first.getData();  //guarda el objeto a retornar
            first = first.getLink();
            if(first == null)
                last = null;
        }
        return obj;
    }
    
    
}
