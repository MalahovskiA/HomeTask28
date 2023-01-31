package by.malahovski.hometask28.model;

public class AllDataMarket {
    private Product product;
    private Shelf shelf;
    private Shop shop;
    private Storage storage;

    public AllDataMarket(Product product, Shelf shelf, Shop shop, Storage storage) {
        this.product = product;
        this.shelf = shelf;
        this.shop = shop;
        this.storage = storage;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Shelf getShelf() {
        return shelf;
    }

    public void setShelf(Shelf shelf) {
        this.shelf = shelf;
    }

    public Shop getShop() {
        return shop;
    }

    public void setShop(Shop shop) {
        this.shop = shop;
    }

    public Storage getStorage() {
        return storage;
    }

    public void setStorage(Storage storage) {
        this.storage = storage;
    }

    @Override
    public String toString() {
        return "AllDataMarket{" +
                "product=" + product +
                ", shelf=" + shelf +
                ", shop=" + shop +
                ", storage=" + storage +
                '}';
    }
}
