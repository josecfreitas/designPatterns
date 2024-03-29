package br.com.gbd.apostiladesignpatterns.comportamental.strategy;

import java.util.ArrayList;
import java.util.List;

/*
    Autor: José Carlos de Freitas
    Data: 09/08/2016, 15:16:20
    Arquivo: SelectionSorter
 */
public class SelectionSorter implements Sorter {

    @Override
    public <T extends Comparable<? super T>> List<T> sort(List<T> list) {
        int index_min;
        T aux;
        list = new ArrayList<>(list);
        for (int i = 0; i < list.size(); i++) {
            index_min = i;
            for (int j = i + 1; j < list.size(); j++) {
                if (list.get(j).compareTo(list.get(index_min)) < 0) {
                    index_min = j;
                }
            }
            if (index_min != i) {
                aux = list.get(index_min);
                list.remove(index_min);
                list.add(index_min, list.get(i));
                list.remove(i);
                list.add(i, aux);
            }
        }
        return list;
    }

}
