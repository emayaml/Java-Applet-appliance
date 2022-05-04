package archivos;

public class List {

    private Node first;  //se puede llamar cabeza, inicio, primero

    //Métodos de la lista
    public List() {
        first = null;
    }

    public Node getFirst() {
        return first;
    }

    //determina si la lista no tiene elementos(true) y si tiene (false)
    public boolean isEmpty() {
        return first == null;
    }

    //AddFirst-- el elemento que adicionemos queda como la cabeza de la lista
    public void AddFirst(Object data) {
        if (isEmpty()) {
            first = new Node(data);
        } else {
            Node N = new Node(data);   //paso 1
            N.setLink(first);          //paso 2
            first = N;                   //paso 3
        }
    }

    @Override
    public String toString() {
        String mess = "";
        Node aux = first;  //paso 1.

        while (aux != null) //paso 2.
        {
            mess = mess + aux.getData() + "\n"; //paso 2.1
            aux = aux.getLink();                //paso 2.2
        }
        return mess;
    }

    public Node Last() {
        Node aux = first, previuos = null;
        while (aux != null) {
            previuos = aux;
            aux = aux.getLink();
        }
        return previuos;
    }

    //AddLast, la informacion la guarda siempre al final, quedando este de último.
    public void AddLast(Object data) {
        if (isEmpty()) {
            AddFirst(data);
        } else {
            Node last = Last(); //paso 1
            Node N = new Node(data); //paso 2
            last.setLink(N);  //paso 3.            
        }
    }

//    public Node Previuos(Object search)
//    {
//        Node aux = first, previuos=null;
//        //busco por el atributo que lo identifica de forma unica
//        while(aux!=null && ((Vehicule)aux.getData()).getCode()!=((Vehicule)(search)).getCode())
//        {
//            previuos = aux;
//            aux=aux.getLink();
//        }
//        if (aux!=null)
//            return previuos;
//        else
//            return null;
//    }
    public int size() {
        Node aux = first;
        int counter = 0;
        while (aux != null) {
            counter++;
            aux = aux.getLink();
        }
        return counter;
    }

    public boolean RemoveFirst() {

        if (!isEmpty()) {
            Node aux = first;
            first = first.getLink();
            aux = null;
            return true;
        }
        return false;
    }

//    public boolean RemoveLast()
//    {
//        if(!isEmpty())
//        {
//            Node last = Last();
//            Node previuos = Previuos(last.getData());
//            if(previuos == null)
//                first = null;
//            else
//            {
//                previuos.setLink(null);
//                last = null;
//            }
//            return true;            
//        }
//        return false;
//    }
//    public void Add(Object data, int pos)
//    {
//        if(pos==1)
//            AddFirst(data);
//        else
//        {
//            if (pos==(size() + 1))
//                AddLast(data);
//            else
//            {
//                Node aux = first;
//                int counter = 1;
//                while(counter<pos)
//                {
//                    counter++;
//                    aux=aux.getLink();
//                }
//                Node N = new Node(data);
//                N.setLink(aux);
//                Node previuos = Previuos(aux.getData());
//                previuos.setLink(N);
//            }
//        }
//    }
//    
//    public void Remove (int pos)
//    {
//        if(pos == 1)
//            RemoveFirst();
//        else
//        {
//             if(pos==size())
//                 RemoveLast();
//             else
//             {
//                 Node aux = first;
//                 int counter=1;
//                 while ( counter < pos)
//                 {
//                     counter++;
//                     aux=aux.getLink();
//                 }
//                 Node previuos = Previuos(aux.getData());
//                 previuos.setLink(aux.getLink());
//                 aux=null;
//             }
//        }
////    }
//    /*--------------------------------------------------------------*/
//    public void Add(Vehicule data)
//    {
//        if(isEmpty())
//            AddFirst(data);
//        else
//        {
//            //Recorremos la lista
//            Node aux = first;
//            while(aux!=null && data.getBrand().compareTo(((Vehicule)aux.getData()).getBrand())>0)  //ordenar por texto
//          
//                
//                while(aux!=null  && data.getModel()>((Vehicule)aux.getData()).getModel())
//                    aux=aux.getLink();
//            
//            //preguntamos en que parte queda el auxiliar -  inicio, final o en una posición intermedia
//            if(aux==null)  //final
//                AddLast(data);
//            else
//            {
//                Node previuos = Previuos(aux.getData());
//                if(previuos==null)  //inicio
//                    AddFirst(data);  
//                else  //posición intermedia
//                {
//                    Node n=new Node(data);
//                    n.setLink(aux);
//                    previuos.setLink(n);
//                }
//            }
//        }
//    }
//    
//    public Vehicule RemoveVehicule(int code)
//    {
//        Vehicule v = null;
//        Node aux=first, previuos=null;
//        //Recorremos la lista
//        while(aux!=null && ((Vehicule)aux.getData()).getCode()!=code)
//            aux=aux.getLink();
//        
//        //verificamos donde quedo el auxiliar
//        if(aux!=null)
//        {
//            v=(Vehicule)aux.getData();  //guardamos el dato para retornarlo
//            previuos=Previuos(v);
//            if(previuos==null)
//                RemoveFirst();
//            else
//            {
//                previuos.setLink(aux.getLink());
//                aux=null;
//            }
//        }
//        return v;
//    }
//    
//    public String Search(String brand)
//    {
//        String message="";
//        Node aux = first;
//        while(aux!=null)
//        {
//            if(((Vehicule)aux.getData()).getBrand().equals(brand))
//                message = message + aux.getData().toString() + "\n";
//            
//            aux=aux.getLink();
//        }
//        return message;
//    }
//    
//    public double Total()
//    {
//        double total=0;
//        Node aux=first;
//        while(aux!=null)
//        {
//            total += ((Vehicule)(aux.getData())).getPrice();
//            aux = aux.getLink();
//        }
//        return total;
//    }
//    
//    public List SearchType(String type)
//    {
//        List listoftype = new List();
//        Node aux = first;
//        while(aux!=null)
//        {
//            if(((Vehicule)aux.getData()).getType().equals(type))
//                listoftype.AddLast(aux.getData());
//            
//            aux = aux.getLink();
//        }
//        return listoftype;
//    }
// /*++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
//
//    public int CantidadxEspecie(String especie)
//    {
//        int cont=0;
//        Node aux=first;
//        while(aux!=null)
//        {
//            if(((Animal)aux.getData()).getEspecie().equals(especie))
//                cont++;
//            
//            aux = aux.getLink();
//        }
//        return cont;
//    }
//    
//    public Animal BuscarAleatorio(int number, String especie)
//    {
//       
//        int cont=0;
//        Node aux=first;
//        while(aux!=null)
//        {
//            if(((Animal)aux.getData()).getEspecie().equals(especie)){
//                cont++;
//            
//            if(cont==number)
//                return (Animal)aux.getData();
//            }
//            aux=aux.getLink();
//        }
//        return null;
//    }
}
