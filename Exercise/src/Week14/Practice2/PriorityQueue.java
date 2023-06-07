package Week14.Practice2;

import java.util.ArrayList;

public class PriorityQueue<T> {
    private ArrayList<T> items;
    private ArrayList<Integer> priorityList;

    public ArrayList<T> getItems(){
        return new ArrayList<>(items);
    }

    public PriorityQueue(){
        items = new ArrayList<>();
        priorityList = new ArrayList<>();
    }
    public void add(T item, int priority){
        int index = priorityList.size();


        for(int x: priorityList){
            if(priority > x){
                index = priorityList.indexOf(x);
                break;
            }
        }

        items.add(index, item);
        priorityList.add(index, priority);
    }

    public T remove(){
        if(items.isEmpty()){
            return null;
        }
        else{
            T item = items.get(0);
            items.remove(0);
            return item;
        }
    }

}
