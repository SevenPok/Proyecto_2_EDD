package Estructura.Arbol;

public class Nodo<T extends Comparable<T>> {

    public T[] keys;
    public int n;
    public Nodo<T>[] children;
    public int t;
    public boolean leaf;

    public Nodo(int t, boolean leaf) {
        this.t = t;
        this.leaf = leaf;
        this.keys = (T[]) new Comparable[2 * t - 1];
        this.children = new Nodo[2 * t];
        this.n = 0;
    }

    public void traverse() {

        int i = 0;
        for (i = 0; i < this.n; i++) {

            if (this.leaf == false) {
                children[i].traverse();
            }
            System.out.println(keys[i].toString());
        }

        if (leaf == false) {
            children[i].traverse();
        }
    }

    public Nodo<T> search(T data) {

        int i = 0;
        while (i < n && data.compareTo(keys[i]) > 0) {
            i++;
        }

        if (keys[i].compareTo(data) == 0) {
            return this;
        }

        if (leaf == true) {
            return null;
        }

        return children[i].search(data);

    }

    public void insertNonNull(T data) {
        int i = n - 1;
        if (leaf == true) {
            while (i >= 0 && keys[i].compareTo(data) > 0) {
                keys[i + 1] = keys[i];
                i--;
            }

            keys[i + 1] = data;
            n = n + 1;
        } else {
            while (i >= 0 && keys[i].compareTo(data) > 0) {
                i--;
            }
            if (children[i + 1].n == 2 * t - 1) {
                splitChild(i + 1, children[i + 1]);
                if (keys[i + 1].compareTo(data) < 0) {
                    i++;
                }
            }
            children[i + 1].insertNonNull(data);
        }
    }

    public void splitChild(int index, Nodo<T> node) {
        Nodo aux = new Nodo(node.t, node.leaf);
        aux.n = t - 1;

        for (int j = 0; j < t - 1; j++) {
            aux.keys[j] = node.keys[j + t];
        }
        if (node.leaf == false) {
            for (int j = 0; j < t; j++) {
                aux.children[j] = node.children[j + t];
            }
        }
        node.n = t - 1;

        for (int j = n; j >= index + 1; j--) {
            children[j + 1] = children[j];
        }

        children[index + 1] = aux;

        for (int j = n - 1; j >= index; j--) {
            keys[j + 1] = keys[j];
        }

        keys[index] = node.keys[t - 1];

        n = n + 1;
    }

    public int findKey(T data) {
        int index = 0;
        while (index < n && keys[index].compareTo(data) < 0) {
            index++;
        }
        return index;
    }

    public void remove(T data) {
        int index = findKey(data);
        if (index < n && keys[index].compareTo(data) == 0) {
            if (leaf) {
                removeFromLeaf(index);
            } else {
                removeFromNonLeaf(index);
            }
        } else {
            if (leaf) {
                System.out.println("Le data" + data.toString() + "\nNo existe");
                return;
            }
            boolean flag = ((index == n) ? true : false);

            if (children[index].n < t) {
                fill(index);
            }
            if (flag && index > n) {
                children[index - 1].remove(data);
            } else {
                children[index].remove(data);
            }
        }
    }

    public void removeFromLeaf(int index) {
        for (int i = index + 1; i < n; ++i) {
            keys[i - 1] = keys[i];
        }
        n--;
    }

    public void removeFromNonLeaf(int index) {
        T key = keys[index];

        if (children[index].n >= t) {
            T pred = getPred(index);
            keys[index] = pred;
            children[index].remove(pred);
        } else if (children[index + 1].n >= t) {
            T succ = getSucc(index);
            keys[index] = succ;
            children[index + 1].remove(succ);
        } else {
            merge(index);
            children[index].remove(key);
        }
    }

    public T getPred(int index) {
        Nodo<T> aux = children[index];
        while (!aux.leaf) {
            aux = aux.children[aux.n];
        }
        return aux.keys[aux.n - 1];
    }

    public T getSucc(int index) {
        Nodo<T> aux = children[index + 1];
        while (!aux.leaf) {
            aux = aux.children[0];
        }
        return aux.keys[0];
    }

    public void merge(int index) {
        Nodo<T> child = children[index];
        Nodo<T> sibling = children[index + 1];

        child.keys[t - 1] = keys[index];

        for (int i = 0; i < sibling.n; ++i) {
            child.keys[i + t] = sibling.keys[i];
        }

        if (!child.leaf) {
            for (int i = 0; i <= sibling.n; ++i) {
                child.children[i + t] = sibling.children[i];
            }
        }

        for (int i = index + 1; i < n; ++i) {
            keys[i - 1] = keys[i];
        }

        for (int i = index + 2; i <= n; ++i) {
            children[i - 1] = children[i];
        }
        child.n += sibling.n + 1;
        n--;
    }

    public void fill(int index) {
        if (index != 0 && children[index - 1].n >= t) {
            borrowFromPrev(index);
        } else if (index != n && children[index + 1].n >= t) {
            borrowFromNext(index);
        } else {
            if (index != n) {
                merge(index);
            } else {
                merge(index - 1);
            }
        }
    }

    public void borrowFromPrev(int index) {
        Nodo<T> child = children[index];
        Nodo<T> sibling = children[index - 1];

        for (int i = child.n - 1; i >= 0; --i) {
            child.keys[i + 1] = child.keys[i];
        }

        if (!child.leaf) {
            for (int i = child.n; i >= 0; --i) {
                child.children[i + 1] = child.children[i];
            }
        }

        child.keys[0] = keys[index - 1];

        if (!child.leaf) {
            child.children[0] = sibling.children[sibling.n];
        }
        keys[index - 1] = sibling.keys[sibling.n - 1];
        child.n += 1;
        sibling.n -= 1;
    }

    public void borrowFromNext(int index) {
        Nodo<T> child = children[index];
        Nodo<T> sibling = children[index + 1];
        child.keys[(child.n)] = keys[index];

        if (!child.leaf) {
            child.children[(child.n) + 1] = sibling.children[0];
        }

        keys[index] = sibling.keys[0];

        for (int i = 1; i < sibling.n; ++i) {
            sibling.keys[i - 1] = sibling.keys[i];
        }

        if (!sibling.leaf) {
            for (int i = 1; i <= sibling.n; ++i) {
                sibling.children[i - 1] = sibling.children[i];
            }
        }

        child.n += 1;
        sibling.n -= 1;
    }
}
