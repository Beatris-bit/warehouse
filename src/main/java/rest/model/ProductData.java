package rest.model;

public class ProductData {
    private String productID;
    private String productName;
    private String productCategory;
    private String productQuantity;
    private String productUnit;

    public ProductData(String productID, String productName, String productCategory, String productQuantity, String productUnit) {
        this.productID = productID;
        this.productName = productName;
        this.productCategory = productCategory;
        this.productQuantity = productQuantity;
        this.productUnit = productUnit;
    }

    public void setProductID(String productID) { this.productID = productID;}
    public void setProductName(String productName) { this.productName = productName;}
    public void setProductCategory(String productCategory) { this.productCategory = productCategory;}
    public void setProductQuantity(String productQuantity) { this.productQuantity = productQuantity;}
    public void setProductUnit(String productUnit) { this.productUnit = productUnit;}

    public String getProductID() { return this.productID; }
    public String getProductName() { return this.productName; }
    public String getProductCategory() { return this.productCategory; }
    public String getProductQuantity() { return this.productQuantity; }
    public String getProductUnit() { return this.productUnit; }



}
