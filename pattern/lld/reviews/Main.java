package reviews;

import reviews.Observable.Product;
import reviews.Observable.ProductObservable;
import reviews.Observer.Supplier;
import reviews.Observer.SupplierObserverInterface;

public class Main {

    public static void main(String[] args) {
        Product product = new ProductObservable();
        Supplier supplier = new SupplierObserverInterface();
        product.registerObserver(supplier);
        product.setData("your product is good");

    }
}
