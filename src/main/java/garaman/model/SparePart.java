package garaman.model;

public class SparePart extends Item{
    private Integer quantityInStock;

    public SparePart(){
    }

    public Integer getQuantityInStock() {
        return quantityInStock;
    }

    public void setQuantityInStock(Integer quantityInStock) {
        this.quantityInStock = quantityInStock;
    }
}
