package fr.istic.vv;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

class BinaryHeap<T> {

    public Noeud root;
    public Comparator<T> comparator;

    public BinaryHeap(Comparator<T> comparator) {
        this.root = null;
        this.comparator = comparator;
    }

    public T pop() {
        T out = this.root.value;
        this.root = remove(this.root);
        return out;
    }

    public T peek() {
        T out = this.root.value;
        return out;
    }

    public void push(T element) {
        add(element);
    }

    public int count() {
        return countNode(root);
    }


    /**
    Classe Noeud pour représentation sous forme de graphe
     */
    class Noeud {
        T value;
        Noeud lhs;
        Noeud rhs;

        public Noeud (T element){
        }

        public Noeud(){
        }
    }

    /**
     * Pour retirer un noeud du graphe à la racine
     * et redimensioner le graphe de façon à avoir un graphe trié
     * @param root le noeud à enlever
     * @return le noeud enlevé
     */
    private Noeud remove(Noeud root){
        if (root.lhs != null & root.rhs != null){
            if (0 > comparator.compare(root.lhs.value, root.rhs.value)){
                Noeud out = root.lhs;
                Noeud newrhs = root.rhs;
                Noeud newlhs = remove(out);
                out.lhs = newlhs;
                out.rhs = newrhs;
                return out;
            } else {
                Noeud out = root.rhs;
                Noeud newlhs = root.lhs;
                Noeud newrhs = remove(out);
                out.rhs = newrhs;
                out.lhs = newlhs;
                return out;
            }
        }
        if(root.lhs != null){
            return root.lhs;
        } else {
            return root.rhs;
        }
    }


    /**
     * Pour faire le parcours en largeur du graphe et retrouver les valeurs des noeuds
     * et ajouter l'élément de façon à avoir un graphe trié
     * @param element élément à ajouter au graphe
     */
    private void add (T element) {
        if(root==null){
            root = new Noeud(element);
        }
        else {
            List<Noeud> noeuds = new ArrayList<>();
            int index = 0;
            noeuds.add(root);
            while (true) {
                Noeud n = noeuds.get(0);
                if (n.lhs == null) {
                    n.lhs = new Noeud(element);
                    noeuds.add(n.lhs);
                    break;
                } else if (n.rhs == null) {
                    n.rhs = new Noeud(element);
                    noeuds.add(n.rhs);
                    break;
                } else {
                    noeuds.add(n.lhs);
                    noeuds.add(n.rhs);
                    index++;
                }

            }
            index = noeuds.size() - 1;
            Noeud n = noeuds.get(index);
            Noeud parent = noeuds.get((index - 1) / 2);
            while (index > 0 && 0 > comparator.compare(n.value, parent.value)) {

                //invert
                T temp = n.value;
                n.value = parent.value;
                parent.value = temp;

                //reverse index
                noeuds.set((index - 1) / 2, n);
                noeuds.set(index, parent);
            }
        }
    }

    /**
     * Pour compter le nombre de noeuds en  parcourant dans la largeur le graphe
     * @return le nombre de noeud du graphe
     */
    private int countNode(Noeud n) {
        if (n == null) return 0;
        int left = countNode(n.lhs);
        int right = countNode(n.rhs);
        return left + right + 1;
    }



       /*
        List<Noeud> noeuds = new ArrayList<>();
        int index = 1;
        noeuds.add(root);
        while (true) {
            Noeud n = noeuds.get(0);
            if (n.lhs == null) {
                n.lhs = new Noeud();
                noeuds.add(n.lhs);
                break;
            } else if (n.rhs == null) {
                n.rhs = new Noeud();
                noeuds.add(n.rhs);
                break;
            } else {
                noeuds.add(n.lhs);
                noeuds.add(n.rhs);
                index++;
            }

        }
        return index;
    }


        */
/*
    private void add2 (Noeud child) {
        while((0 < comparator.compare(root.lhs.value, child.value)) &
                (0 < comparator.compare(root.rhs.value, child.value)) ) {
            if (root.lhs == null) {
                root.lhs = child;
                add(child);
            } else if (root.rhs == null) {
                root.rhs = child;
                add(child);
            } else {
                if (0 < comparator.compare(root.lhs.value, root.rhs.value)) {
                    Noeud rhs = root.rhs;
                    rhs.rhs = child;
                    add(child);
                }
            }
        }
    }

 */


}