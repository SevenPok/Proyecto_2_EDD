package Estructura.BTree;

import Entidad.Vehiculo;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import static jdk.nashorn.internal.objects.Global.print;

public class BTree {

    private BTree nodoauxiliar = null;
    ArrayList<Vehiculo> lstnodos = new ArrayList<>();
    ArrayList<Vehiculo> lst = new ArrayList<>();
    public Node raiz, aux;
    private static BTree instancia = null;
    private String valor;

    public static BTree getInstancia() {
        if (instancia == null) {
            instancia = new BTree();
        }
        return instancia;
    }

    public int comparer(String s1, String s2) {
        if (s1.compareToIgnoreCase(s2) > 0) {
            return 0;
        } else if (s1.compareToIgnoreCase(s2) < 0) {
            return -1;
        } else if (s1.compareToIgnoreCase(s2) == 0) {
            return 0;
        } else {
            return s1.compareToIgnoreCase(s2);
        }
    }

    private Node buscar(Vehiculo vehiculo, Node node) {
        if (node != null) {
            int i = 1;
            while (i <= node.ULlave && (comparer(node.llaves[i - 1].getPlaca(), vehiculo.getPlaca()) < 0)) {
                i++;
            }
            if (i > node.ULlave || (comparer(node.llaves[i - 1].getPlaca(), vehiculo.getPlaca()) > 0)) {
                return buscar(vehiculo, node.punteros[i - 1]);
            } else {
                return node;
            }
        } else {
            return null;
        }
    }

    public Vehiculo exi(String vehiculo) {
        Vehiculo aux = recorrer(vehiculo);
        if (aux == null) {
            System.out.println("no existe");
            return null;
        } else {
            return aux;
        }
    }

    private Vehiculo recorrer(String libro) {
        Node aux = buscaris(libro, this.raiz);
        if (aux != null) {
            for (int i = 0; i < aux.llaves.length; i++) {
                if (aux.llaves[i] != null) {
                    if (aux.llaves[i].getPlaca() == null ? libro == null : aux.llaves[i].getPlaca().equals(libro)) {
                        return aux.llaves[i];
                    }
                }
            }

        }
        return null;
    }

    private Node buscaris(String vehiculo, Node node) {
        if (node != null) {
            int i = 1;
            while (i <= node.ULlave && (comparer(node.llaves[i - 1].getPlaca(), vehiculo) < 0)) {
                i++;
            }
            if (i > node.ULlave || (comparer(node.llaves[i - 1].getPlaca(), vehiculo) > 0)) {
                return buscaris(vehiculo, node.punteros[i - 1]);
            } else {
                return node;
            }
        } else {
            return null;
        }
    }

    public Boolean existe(Vehiculo vehiculo) {
        if (buscar(vehiculo, raiz) == null) {
            return false;
        } else {
            return true;
        }
    }

    public void insert(Vehiculo temporal) {
        if (existe(temporal) == true) {
            System.out.println("ya existe");
        } else {
            insertar(temporal);
            ordenar(this.raiz);
        }
    }

    private void ordenar(Node nodo) {
        if (nodo != null) {
            for (int i = 0; i < (nodo.llaves.length - 1); i++) {
                if (nodo.llaves[i] != null) {
                    for (int j = i + 1; j < nodo.llaves.length; j++) {
                        if (nodo.llaves[j] != null) {
                            String val = nodo.llaves[i].getPlaca();
                            String val2 = nodo.llaves[j].getPlaca();
                            if (comparer(val, val2) > 0) {
                                Vehiculo aux = nodo.llaves[i];
                                nodo.llaves[i] = nodo.llaves[j];
                                nodo.llaves[j] = aux;
                            }
                        }
                    }
                }
            }
            for (int i = 0; i < 5; i++) {
                if (nodo.punteros[i] != null) {
                    ordenar(nodo.punteros[i]);
                }
            }

        }
    }

    private void insertar(Vehiculo libro) {
        if (this.raiz == null) {
            this.raiz = new Node(libro);
            return;
        }
        Node nodo = raiz;

        while (nodo.hoja == false) {
            int i = 1;
            while (i <= nodo.ULlave && (nodo.llaves[i - 1].getPlaca() == null ? libro.getPlaca() != null : !nodo.llaves[i - 1].getPlaca().equals(libro.getPlaca()))) {
                i++;
            }
            nodo = nodo.punteros[i - 1];
        }

        Boolean posInLeaf = true;
        Node node1 = null;
        Node node2 = null;

        while (true) {
            int i = 1;
            while (i <= nodo.ULlave && !nodo.llaves[i - 1].getPlaca().equals(libro.getPlaca())) {
                i++;
            }

            if (i <= nodo.ULlave) {
                int finalPointer = nodo.ULlave - 1;
                while (finalPointer >= i - 1) {
                    nodo.llaves[finalPointer + 1] = nodo.llaves[finalPointer];

                    nodo.punteros[finalPointer + 2] = nodo.punteros[finalPointer + 1];
                    finalPointer--;
                }
            }

            nodo.llaves[i - 1] = libro;

            nodo.ULlave = nodo.ULlave + 1;

            if (node1 != null && node2 != null) {
                nodo.punteros[i - 1] = node1;
                nodo.punteros[i] = node2;

                node1 = null;
                node2 = null;
            }

            int order = 6;

            if (nodo.ULlave < order - 1) {
                return;
            } else {
                int posInMiddleKey = (order / 2) - 1;

                libro = nodo.llaves[posInMiddleKey];

                node1 = nodo;
                node2 = new Node();

                if (posInLeaf) {
                    node1.hoja = true;
                    node2.hoja = true;
                } else {
                    node1.hoja = false;
                    node2.hoja = false;
                }

                node1.llaves[posInMiddleKey] = null;

                node1.ULlave = (order / 2) - 1;
                node2.ULlave = (order / 2) - 1;
                int posInNode1 = posInMiddleKey + 1;
                int posInNode2 = 0;
                while (posInNode1 < order - 1) {

                    node2.llaves[posInNode2] = node1.llaves[posInNode1];

                    node1.llaves[posInNode1] = null;

                    node2.punteros[posInNode2] = node1.punteros[posInNode1];
                    if (node2.punteros[posInNode2] != null) {
                        node2.punteros[posInNode2].Padre = node2;
                    }

                    node1.punteros[posInNode1] = null;

                    posInNode1++;
                    posInNode2++;

                    if (posInNode1 == order - 1) {
                        node2.punteros[posInNode2] = node1.punteros[posInNode1];
                        if (node2.punteros[posInNode2] != null) {
                            node2.punteros[posInNode2].Padre = node2;
                        }

                        node1.punteros[posInNode1] = null;
                    }

                }

                if (nodo == this.raiz) {

                    Node auxRaiz = new Node(libro);
                    auxRaiz.hoja = false;
                    auxRaiz.punteros[0] = node1;
                    auxRaiz.punteros[1] = node2;

                    node1.Padre = auxRaiz;
                    node2.Padre = auxRaiz;

                    this.raiz = auxRaiz;
                    return;

                } else {
                    nodo = nodo.Padre;
                    node2.Padre = node1.Padre;
                    posInLeaf = false;
                }

            }
        }
    }

    public void Eliminar(String isbn) {
        nodoauxiliar = new BTree();
        eliminar(this.raiz, isbn);
        this.raiz = nodoauxiliar.raiz;
        nodoauxiliar = null;
    }

    private void eliminar(Node nodo, String valor) {
        if (nodo != null) {
            for (int i = 0; i < 4; i++) {
                if (nodo.llaves[i] != null) {
                    if (!nodo.llaves[i].getPlaca().equals(valor)) {
                        Vehiculo nuevo = new Vehiculo(nodo.llaves[i].getPlaca(), nodo.llaves[i].getMarca(), nodo.llaves[i].getModelo(), nodo.llaves[i].getAnio(), nodo.llaves[i].getColor(),
                                nodo.llaves[i].getPrecio(), nodo.llaves[i].getTipoCaja());
                        nodoauxiliar.insert(nuevo);
                    }
                }
            }
            for (int i = 0; i < 5; i++) {
                if (nodo.punteros[i] != null) {
                    eliminar(nodo.punteros[i], valor);
                }
            }
        }
    }

    public void printGraphviz() throws IOException {
        Node auxNode = this.raiz;

        PrintWriter sw = new PrintWriter(new FileWriter("ArbolB.txt"));
        sw.println("digraph G {");
        sw.println("\t rankdir = TB; \n");
        sw.println("\t node[shape=record]; \n");
        sw.println("\t subgraph clusterBTree { \n");
        sw.println("\t node [shape=record];\nnode [style=filled];\nnode [fillcolor=\"#EEEEEE\"];\nnode [color=\"#8C8C8E\"];\nedge [color=\"#31CEF0\"]; \n");
        print(auxNode, sw);
        sw.println("\t } \n");
        sw.println("\t } \n");
        sw.close();
        String dotPath = "dot";
        String fileInputPath = "ArbolB.txt";
        String fileOutputPath = "ArbolB.png";
        String tParam = "-Tpng";
        String tOParam = "-o";
        String[] cmd = new String[5];
        cmd[0] = dotPath;
        cmd[1] = tParam;
        cmd[2] = fileInputPath;
        cmd[3] = tOParam;
        cmd[4] = fileOutputPath;

        ExecuteCommand(cmd[0] + " " + cmd[1] + " " + cmd[2] + " " + cmd[3] + " " + cmd[4]);
    }

    private void print(Node nodo, PrintWriter sw) {
        if (nodo != null) {
            if (nodo.Padre != null) {
                sw.println("\"" + "Placa: " + nodo.Padre.llaves[0].getPlaca() + "\" -> \"" + "Placa: " + nodo.llaves[0].getPlaca() + "\"");
            }
            sw.println("\n\"" + "Placa: " + nodo.llaves[0].getPlaca() + "\"[label=\"|");
            for (int i = 0; i < 4; i++) {
                if (i != 0) {
                    sw.println("|");
                }
                if (nodo.llaves[i] != null) {
                    sw.println(" Placa: " + nodo.llaves[i].getPlaca());
                } else {
                    sw.println(0);
                }

            }
            sw.println("\"];\n");
            for (int i = 0; i < 5; i++) {
                if (nodo.punteros[i] != null) {
                    print(nodo.punteros[i], sw);
                }
            }
        }
    }

    static void ExecuteCommand(String _Command) throws IOException {

        Runtime.getRuntime().exec(_Command);

    }

    public void set(Vehiculo valor, Vehiculo Reemplazo) {
        if (this.existe(valor)) {
            Node nodo = this.buscar(valor, this.raiz);
            this.ReemplazarLlave(nodo, valor, Reemplazo);
        }
    }

    public Node PrecedenciaNodo(Vehiculo valor, Node nodo) {
        int i = 1;
        while (i <= nodo.ULlave) {
            if (nodo.llaves[i - 1].equals(valor)) {
                nodo = nodo.punteros[i];
                break;
            }
            i++;
        }
        while (true) {
            if (nodo.hoja) {
                return nodo;
            } else {
                nodo = nodo.punteros[0];
            }
        }
    }

    public void ReemplazarLlave(Node nodo, Vehiculo valor, Vehiculo valor2) {
        int i = 1;
        while (i <= nodo.ULlave) {
            if (nodo.llaves[i - 1].equals(valor)) {
                nodo.llaves[i - 1] = valor2;
                break;
            }
            i++;
        }
    }

    public void EliminarHoja(Node nodo, Vehiculo valor) {
        int i = 0;
        while (i < nodo.ULlave) {
            if (nodo.llaves[i].equals(valor)) {
                while (i < nodo.ULlave - 1) {
                    nodo.llaves[i] = nodo.llaves[i + 1];

                    i++;
                }
                nodo.llaves[nodo.ULlave - 1] = null;

                nodo.ULlave--;
            } else {
                i++;
            }
        }
    }

    private Boolean VerificarMinimo(Node nodo) {
        if (nodo == this.raiz) {
            if (nodo.ULlave == 0) {
                this.raiz = null;
            }
            return true;
        }
        int minKeys = 2;
        if (nodo.ULlave >= minKeys) {
            return true;
        } else {
            return false;
        }
    }

    private Node izquierda(Node nodo) {
        int i = 0;
        Node Padre = nodo.Padre;
        while (i <= Padre.ULlave) {
            if (Padre.punteros[i] == nodo) {
                if (i == 0) {
                    return null;
                } else {
                    return Padre.punteros[i - 1];
                }
            }
            i++;
        }
        return null;
    }

    private Node derecha(Node nodo) {
        int i = 0;
        Node Padre = nodo.Padre;
        while (i <= Padre.ULlave) {
            if (Padre.punteros[i] == nodo) {
                if (i == Padre.ULlave) {
                    return null;
                } else {
                    return Padre.punteros[i + 1];
                }
            }
            i++;
        }
        return null;
    }

    private void TomardeDerecha(Node nodo) {
        Node Padre = nodo.Padre;
        int i = 0;
        while (i < Padre.ULlave) {
            if (Padre.punteros[i] == nodo) {
                Node derecha = Padre.punteros[i + 1];
                nodo.llaves[nodo.ULlave] = Padre.llaves[i];

                nodo.ULlave++;
                nodo.punteros[nodo.ULlave] = derecha.punteros[0];
                Padre.llaves[i] = derecha.llaves[0];

                int k = 0;
                while (k < derecha.ULlave - 1) {
                    derecha.llaves[k] = derecha.llaves[k + 1];

                    derecha.punteros[k] = derecha.punteros[k + 1];
                    k++;
                }
                derecha.llaves[k] = null;

                derecha.punteros[k] = derecha.punteros[k + 1];
                derecha.ULlave--;
            }
            i++;
        }
    }

    private void TomardeIzquierda(Node nodo) {
        Node Padre = nodo.Padre;
        int i = 0;
        while (i <= Padre.ULlave) {
            if (Padre.punteros[i] == nodo) {
                Node izquierda = Padre.punteros[i - 1];
                int k = 0;
                while (k < nodo.ULlave) {
                    nodo.llaves[k + 1] = nodo.llaves[k];

                    nodo.punteros[k + 1] = nodo.punteros[k];
                    k++;
                }
                nodo.punteros[k + 1] = nodo.punteros[k];
                nodo.llaves[0] = Padre.llaves[i - 1];

                nodo.punteros[0] = izquierda.punteros[izquierda.ULlave];
                Padre.llaves[i - 1] = izquierda.llaves[izquierda.ULlave - 1];

                izquierda.llaves[izquierda.ULlave - 1] = null;

                izquierda.punteros[izquierda.ULlave] = null;
                izquierda.ULlave--;
                nodo.ULlave++;
                break;
            }
            i++;
        }
    }

    private void NuevaRaiz(Node left, Node right) {
        left.llaves[left.ULlave] = raiz.llaves[0];

        left.ULlave++;
        int leftPointer = left.ULlave;
        int i = 0;
        while (i < right.ULlave) {
            left.llaves[leftPointer] = right.llaves[i];

            if (right.punteros[i] != null) {
                left.punteros[leftPointer] = right.punteros[i];
                right.punteros[i].Padre = left;
            }
            i++;
            leftPointer++;
            left.ULlave++;
        }
        if (right.punteros[i] != null) {
            left.punteros[leftPointer] = right.punteros[i];
            right.punteros[i].Padre = left;
        }
        raiz = left;
        raiz.Padre = null;
    }

    private void combinar(Node nodo) {
        if (derecha(nodo) != null) {
            Node Padre = nodo.Padre;
            int i = 0;
            while (i < Padre.ULlave) {
                if (Padre.punteros[i] == nodo) {
                    nodo.llaves[nodo.ULlave] = Padre.llaves[i];
                    nodo.ULlave++;
                    Node partner = derecha(nodo);
                    int k = 0;
                    while (k < partner.ULlave) {
                        nodo.llaves[nodo.ULlave] = partner.llaves[k];
                        nodo.punteros[nodo.ULlave] = partner.punteros[k];
                        nodo.ULlave++;
                        k++;
                    }
                    nodo.punteros[nodo.ULlave] = partner.punteros[k];
                    int pointer = i;
                    while (pointer < Padre.ULlave) {
                        Padre.llaves[pointer] = Padre.llaves[pointer + 1];
                        Padre.punteros[pointer + 1] = Padre.punteros[pointer + 2];
                        pointer++;
                    }
                    Padre.ULlave--;
                    break;
                }
                i++;
            }
        } else {
            combinar(izquierda(nodo));
        }
    }

    public void Remover(int valor) {

        for (int i = 0; i < lstnodos.size(); i++) {

            Node nodo = buscar(lstnodos.get(i), this.raiz);

            if (nodo != null) {

                if (nodo.hoja == false) {
                    Node hoja = PrecedenciaNodo(lstnodos.get(i), nodo);
                    Vehiculo presedencia = hoja.llaves[0];
                    ReemplazarLlave(nodo, lstnodos.get(i), presedencia);
                    nodo = hoja;
                    EliminarHoja(hoja, presedencia);
                } else {

                    EliminarHoja(nodo, lstnodos.get(i));
                }

                while (true) {
                    if (VerificarMinimo(nodo)) {
                        break;
                    } else if (derecha(nodo) != null && derecha(nodo).ULlave > 2) {
                        TomardeDerecha(nodo);
                        break;
                    } else if (izquierda(nodo) != null && izquierda(nodo).ULlave > 2) {
                        TomardeIzquierda(nodo);
                        break;
                    } else if (nodo.Padre == this.raiz) {
                        if (nodo.Padre.ULlave == 1) {
                            if (derecha(nodo) != null) {
                                NuevaRaiz(nodo, derecha(nodo));
                            } else if (izquierda(nodo) != null) {
                                NuevaRaiz(izquierda(nodo), nodo);
                            }
                        } else {
                            combinar(nodo);
                        }
                        break;
                    } else {
                        combinar(nodo);
                        nodo = nodo.Padre;

                    }
                }
            }
        }
    }

    public boolean cargaMasiva(String ruta) {
        try {

            FileReader fr = new FileReader(ruta);
            BufferedReader br = new BufferedReader(fr);
            String linea = "";
            while ((linea = br.readLine()) != null) {
                String[] cadena = linea.split(";");
                String[] data = cadena[0].split(":");
                try {
                    insert(new Entidad.Vehiculo(data[0], data[1], data[2], Integer.parseInt(data[3]), data[4], data[5], data[6]));
                } catch (NumberFormatException e) {
                }
            }
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
