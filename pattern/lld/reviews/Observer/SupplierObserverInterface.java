package reviews.Observer;

public class SupplierObserverInterface implements Supplier {

    @Override
    public void update() {
        System.out.println("Supplier got some reviews on your product.");
    }
}
