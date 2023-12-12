package MezclaNatural;

import java.util.ArrayList;
import java.util.List;

public class MergeNaturalSort {
    public static void main(String[] args) {
        List<Integer> elementos = new ArrayList<>();
        elementos.add(3);
        elementos.add(4);
        elementos.add(1);
        elementos.add(9);
        elementos.add(2);

        System.out.println("Orden original: " + elementos);

        naturalMergeSort(elementos);

        System.out.println("Orden final: " + elementos);
    }

    static void naturalMergeSort(List<Integer> arr) {
        List<Integer> resultadoParcial = null;

        while (true) {
            List<Integer> aux1 = new ArrayList<>();
            List<Integer> aux2 = new ArrayList<>();
            List<Integer> merged = new ArrayList<>();

            int i = 0;
            while (i < arr.size() - 1) {
                if (arr.get(i) > arr.get(i + 1)) {
                    break;
                }
                i++;
            }

            if (i == arr.size() - 1) {
                resultadoParcial = new ArrayList<>(arr);
                break;
            }

            aux1 = arr.subList(0, i + 1);
            aux2 = arr.subList(i + 1, arr.size());

            System.out.println("\nAuxiliar 1: " + aux1);
            System.out.println("Auxiliar 2: " + aux2);

            while (!aux1.isEmpty() && !aux2.isEmpty()) {
                if (aux1.get(0) <= aux2.get(0)) {
                    merged.add(aux1.get(0));
                    aux1.remove(0);
                } else {
                    merged.add(aux2.get(0));
                    aux2.remove(0);
                }
            }

            merged.addAll(aux1);
            merged.addAll(aux2);
            arr = new ArrayList<>(merged);

            resultadoParcial = new ArrayList<>(arr);

            System.out.println("Orden parcial: " + arr);
        }

        // Imprimir el resultado del último paso parcial como Orden final
        System.out.println("\nOrden final: " + resultadoParcial);
    }
}
