package reviews.Observable;

import reviews.Observer.Supplier;

import java.util.ArrayList;
import java.util.List;

public class ProductObservable implements Product {

    List<Supplier> supplierList;
    String ratings;

    public ProductObservable() {
        supplierList = new ArrayList<>();
        ratings = "";
    }

    @Override
    public void registerObserver(Supplier supplier) {
        supplierList.add(supplier);
    }

    @Override
    public void removeObserver(Supplier supplier) {
        supplierList.remove(supplier);
    }

    @Override
    public void notifyObservers() {
        for(Supplier supplier : supplierList) {
            supplier.update();
        }
    }

    @Override
    public void setData(String ratings) {
        String oldRatings = this.ratings;
        this.ratings = ratings;
        if(oldRatings.equals("")){
            notifyObservers();
        }

    }
}
