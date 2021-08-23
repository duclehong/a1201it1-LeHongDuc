package service;

import model.Product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductServiceImpl implements ProductService {
    private static Map<Integer, Product> products;
    static{
        products = new HashMap<>();
        products.put(1,new Product(1,"apple",25000,"vjp1"));
        products.put(2,new Product(2,"apple2",2000,"vjp2"));
        products.put(3,new Product(3,"apple3",200,"vjp3"));
        products.put(4,new Product(4,"apple4",20,"vjp4"));
        products.put(5,new Product(5,"apple5",2,"vjp5"));
    }

    @Override
    public List<Product> findAll() {
        return new ArrayList<>(products.values());
    }

    @Override
    public void save(Product product) {
        products.put(product.getId(), product);
    }

    @Override
    public Product findById(int id) {
        return products.get(id);
    }

    @Override
    public List<Product> findByName(String name) {
        List<Product> productList = new ArrayList<>();
        for (Map.Entry<Integer, Product> entry : products.entrySet()) {
            if (entry.getValue().getName().equals(name)){
                productList.add(entry.getValue());
            }
        }
        return productList;
    }

    @Override
    public void update(int id, Product product) {
        products.put(id, product);
    }

    @Override
    public void remove(int id) {
        products.remove(id);
    }
}
