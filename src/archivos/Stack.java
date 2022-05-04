
package archivos;

public class Stack {
    private Node top;
    
    public Stack()
    {
        top=null;
    }
    
    public boolean isEmpty()
    {
        return top==null;
    }
    
    public void Push(Object data)
    {
        if(isEmpty())
            top = new Node(data);
        else
        {
            Node N = new Node(data);
            N.setLink(top);
            top = N;
        }
    }
    
    public Object Pop()
    {
        Object data=null;
        if(!isEmpty())
        {
            data = top.getData();
            Node aux = top;  //no es obligatorio
            top = top.getLink();
            aux = null;     // no es obligatorio
        }
        return data;
    }
 
    
}