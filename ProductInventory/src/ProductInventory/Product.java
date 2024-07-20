package ProductInventory;

import java.io.Serializable;

public class Product implements Serializable{
    
    private String id;
    private String name;
    private int qty;
    private double price;

    public Product(){
        id = ""; name= ""; qty= 0 ; price = 0.0;
    }
    public Product(String i, String n, int q, double p){
        id = i; name= n; qty= q; price = p;
    }
    public String getId(){return id;}
    public String getName(){return name;}
    public int getQty(){return qty;}
    public double getPrice(){return price;}

    public void setId(String i){id = i;}
    public void setName(String n){name = n;}
    public void setQty(int q){qty = q;}
    public void setPrice(double p){price = p;}

    public String toString(){
        return getId() + "\t" +getName()+"\t"+ getQty()+ "\t"+getPrice();
    }
}
