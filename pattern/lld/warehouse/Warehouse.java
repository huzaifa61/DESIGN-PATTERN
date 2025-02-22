package warehouse;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Warehouse implements Subject{

    private ArrayList<Observer> stores = new ArrayList<>();
    Map<String,Integer> inventory = new HashMap<>();

    @Override
    public void registerObserver(Observer o) {
        if (!stores.contains(o)) { // Avoid duplicates
            stores.add(o);
        }
    }

    public void addInventory(String item,int quantity) {
        inventory.put(item,inventory.getOrDefault(item,0)+quantity);
        notifyObservers();
    }

    @Override
    public void removeObserver(Observer o) {
        stores.remove(o);
    }

    @Override
    public void notifyObservers() {
        for (Observer store : stores) {
            store.update(this); // Notify all stores
        }
    }

    public Map<String, Integer> getInventory() {
        return new HashMap<>(inventory); // Return copy for encapsulation
    }
}
