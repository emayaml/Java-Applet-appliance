package archivos;

import java.io.*;

public class Archivo {

    //leer
    public List LeerLista() {
        List lista = new List();
        File f;
        FileReader fr;
        BufferedReader br;
        String registro, campos[];
        try {
            f = new File("D:\\Documentos\\NetBeansProjects\\Archivos\\ejemplo.txt");
            fr = new FileReader(f);
            br = new BufferedReader(fr);
            while ((registro = br.readLine()) != null) {
                campos = registro.split("\t");
                Electrodomestico el = new Electrodomestico(
                        Integer.parseInt(campos[0]),
                        campos[1],
                        new Dimension(Double.parseDouble(campos[2].split(",")[0]),
                                Double.parseDouble(campos[2].split(",")[1]),
                                Double.parseDouble(campos[2].split(",")[2])));
                lista.AddLast(el);
            }
            br.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
        return lista;
    }

    //escribir
    public void EscribirLista(List lista) {
        File f;
        FileWriter fw;
        BufferedWriter bw;
        try {
            f = new File("ejemplo.txt");
            fw = new FileWriter(f);
            bw = new BufferedWriter(fw);
            Node aux = lista.getFirst();
            while (aux != null) {
                Electrodomestico e = (Electrodomestico) aux.getData();
                bw.write(e.getCodigo() + "\t" + e.getNombre() + "\t"
                        + e.getTam().getAlto() + "," + e.getTam().getAncho() + ","
                        + e.getTam().getLargo() + "\n");
                aux = aux.getLink();
            }
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Queue LeerCola(String ruta) {
        Queue q = new Queue();
        File f;
        FileReader fr;
        BufferedReader br;
        String registro, campoElec[], campoDim[];
        Electrodomestico el;
        try {
            f = new File(ruta);
            fr = new FileReader(f);
            br = new BufferedReader(fr);
            while ((registro = br.readLine()) != null) {
                campoElec = registro.split("\t");
                campoDim = campoElec[2].split(",");
                el = new Electrodomestico(Integer.parseInt(campoElec[0]), campoElec[1],
                        new Dimension(Double.parseDouble(campoDim[0]),
                                Double.parseDouble(campoDim[1]), Double.parseDouble(campoDim[2])));
                q.Enqueue(el);
            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return q;
    }

    public void EscribirCola(String ruta, Queue q) {
        File f;
        FileWriter fw;
        BufferedWriter bw;
        Queue aux = new Queue();

        try {
            f = new File(ruta);
            fw = new FileWriter(f);
            bw = new BufferedWriter(fw);
            Electrodomestico e;
            while (!q.isEmpty()) {
                e = (Electrodomestico) q.Dequeue();//MAGIA
                bw.write(e.getCodigo() + "\t" + e.getNombre() + "\t"
                        + e.getTam().getAlto() + "," + e.getTam().getAncho() + ","
                        + e.getTam().getLargo() + "\n");
                aux.Enqueue(e);
            }//FIN MAGIA
            while (!aux.isEmpty()) {
                q.Enqueue(aux.Dequeue());
            }

            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Stack LeerPila(String ruta) {
        Stack q = new Stack();
        File f;
        FileReader fr;
        BufferedReader br;
        String registro, campoElec[], campoDim[];
        Electrodomestico el;
        try {
            f = new File(ruta);
            fr = new FileReader(f);
            br = new BufferedReader(fr);
            while ((registro = br.readLine()) != null) {
                campoElec = registro.split("\t");
                campoDim = campoElec[2].split(",");
                el = new Electrodomestico(Integer.parseInt(campoElec[0]), campoElec[1],
                        new Dimension(Double.parseDouble(campoDim[0]),
                                Double.parseDouble(campoDim[1]), Double.parseDouble(campoDim[2])));
                q.Push(el);
            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return q;
    }

    public void EscribirPila(String ruta, Stack q) {
        File f;
        FileWriter fw;
        BufferedWriter bw;
        Stack aux = new Stack();

        try {
            f = new File(ruta);
            fw = new FileWriter(f);
            bw = new BufferedWriter(fw);
            Electrodomestico e;
            while (!q.isEmpty()) {//LA MAGIA
                e = (Electrodomestico) q.Pop();
                bw.write(e.getCodigo() + "\t" + e.getNombre() + "\t"
                        + e.getTam().getAlto() + "," + e.getTam().getAncho() + ","
                        + e.getTam().getLargo() + "\n");
                aux.Push(e);
            } //FIN DE LA MAGIA
            while (!aux.isEmpty()) {
                q.Push(aux.Pop());
            }

            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
