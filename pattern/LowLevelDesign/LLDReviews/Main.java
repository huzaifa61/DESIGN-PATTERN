package LLDReviews;

import LLDReviews.Observable.Product;
import LLDReviews.Observable.ProductObservable;
import LLDReviews.Observer.Supplier;
import LLDReviews.Observer.SupplierObserverInterface;

public class Main {

    public static void main(String[] args) {
        Product product = new ProductObservable();
        Supplier supplier = new SupplierObserverInterface();
        product.registerObserver(supplier);
        product.setData("your product is good");

    }
}
