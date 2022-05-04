package archivos;

import javax.swing.JOptionPane;

public class Archivos {

    public static void main(String[] args) {
        Archivo a = new Archivo();
        Queue q = new Queue();
        String menu[] = { "Adicionar","Leer Cola", "Eliminar", "Mostrar", "Modificar", "Salir"};
        String opc, nombre;
        int codigo;
        double alto, ancho, largo;
        Electrodomestico el;
        Queue aux = new Queue();
        Stack s = a.LeerPila("ejemplo.txt");

        do {
            opc = (String) JOptionPane.showInputDialog(null, "Seleccione opcion", "Menu principal",
                    1, null, menu, menu[0]);
            switch (opc) {
                case "Leer Cola":
                    q = a.LeerCola("ejemplo.txt");
                    JOptionPane.showMessageDialog(null, "informacion cargada");
                    break;

                case "Adicionar":
                    codigo = Integer.parseInt(JOptionPane.showInputDialog("digite codigo"));
                    nombre = JOptionPane.showInputDialog("Digite nombre");
                    alto = Math.random() * 100;
                    ancho = Math.random() * 100;
                    largo = Math.random() * 100;
                    s.Push(new Electrodomestico(codigo, nombre, new Dimension(alto, ancho, largo)));
                    JOptionPane.showMessageDialog(null, "Electrodomestico creado");
                    a.EscribirPila("ejemplo.txt", s);
                    break;

                case "Eliminar":
                    codigo = Integer.parseInt(JOptionPane.showInputDialog("Digite codigo"));
                    while (!q.isEmpty()) {
                        el = (Electrodomestico) q.Dequeue();
                        if (el.getCodigo() != codigo) {
                            aux.Enqueue(el);
                        } else {
                            JOptionPane.showMessageDialog(null, "Elemento eliminado");
                        }
                    }
                    while (!aux.isEmpty()) {
                        q.Enqueue(aux.Dequeue());
                    }

                    a.EscribirCola("ejemplo.txt", q);
                    JOptionPane.showMessageDialog(null, "Eliminado");

                    break;

                case "Mostrar":
                    JOptionPane.showMessageDialog(null, toString(s));
                    break;

                case "Salir":
                    a.EscribirCola("ejemplo.txt", q);
                    break;

                case "Modificar":
                    codigo = Integer.parseInt(JOptionPane.showInputDialog("digite codigo"));
                    while (!q.isEmpty()) {
                        el = (Electrodomestico) q.Dequeue();
                        if (el.getCodigo() == codigo) {
                            el.setNombre(JOptionPane.showInputDialog("Digite nuevo nombre"));
                        }
                        aux.Enqueue(el);
                    }
                    while (!aux.isEmpty()) {
                        q.Enqueue(aux.Dequeue());
                    }
                    a.EscribirCola("ejemplo.txt", q);
                    JOptionPane.showMessageDialog(null, "Modificado");
                            

                    break;

            }
        } while (!opc.equals("Salir"));

    }

    public static String toString(Queue q) {
        Queue aux = new Queue();
        String text = "";
        Electrodomestico el;
        while (!q.isEmpty()) {
            el = (Electrodomestico) q.Dequeue();
            text = text + el.toString() + "\n";
            aux.Enqueue(el);
        }
        while (!aux.isEmpty()) {
            q.Enqueue(aux.Dequeue());
        }

        return text;
    }

    public static String toString(Stack q) {
        Stack aux = new Stack();
        String text = "";
        Electrodomestico el;
        while (!q.isEmpty()) {
            el = (Electrodomestico) q.Pop();
            text = text + el.toString() + "\n";
            aux.Push(el);
        }
        while (!aux.isEmpty()) {
            q.Push(aux.Pop());
        }
        return text;
    }

}
