package com.example.jpatest.service;

import com.example.jpatest.models.ProductDetailPropertyDetails;
import com.example.jpatest.models.ProductDetails;
import com.example.jpatest.models.Properties;
import com.example.jpatest.models.responobject.Respon;
import com.example.jpatest.repository.dbcontext.Dbcontext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ProductDetailsService implements IProductDetails {
    @Autowired
    private Dbcontext dbcontext;

    private int ThuocTinhDoiCuoicung() {
        int thuocTinhDoiCuoi = 0;
        for (ProductDetails x : dbcontext.productDetailsRepo.findAll()) {
            if (x.getParentId() >= thuocTinhDoiCuoi)
                thuocTinhDoiCuoi = x.getParentId();
        }
        return thuocTinhDoiCuoi;
    }

    @Override
    public List<ProductDetails> ShowProductDetails() {
        List<ProductDetails> lstAdd = new ArrayList<>();
        for (ProductDetails x : dbcontext.productDetailsRepo.findAll()) {
            List<ProductDetails> productChild = new ArrayList<>();
            productChild = x.getChildren();
            if (productChild.size() == 0) {
                lstAdd.add(x);
            }
        }
        return lstAdd;
    }

    @Override
    public Respon<ProductDetails> order(String name, int quantity) {
        Respon<ProductDetails> respon = new Respon<>();
        boolean tonTaiSanPham = false;
        for (ProductDetails x : dbcontext.productDetailsRepo.findAll()) {
            if (x.getProductPropertyName().toLowerCase().contains(name.toLowerCase())) {
                tonTaiSanPham = true;
                int num = x.getQuantity();
                if (num == 0) {
                    respon.setError("San pham het hang");
                    return respon;
                }
                if (num < quantity) {
                    respon.setError("San pham khong du hang de ban");
                    return respon;
                }
                int idParent = x.getParentId();
                x.setQuantity(num - quantity);
                dbcontext.productDetailsRepo.save(x);
                do {
                    ProductDetails productParent = new ProductDetails();
                    productParent = dbcontext.productDetailsRepo.findById(idParent).get();
                    productParent.setQuantity(productParent.getQuantity() - quantity);
                    dbcontext.productDetailsRepo.save(productParent);
                    if (productParent.getParentId() == null) {
                        break;
                    }
                    idParent = productParent.getParentId();
                } while (true);
            }
        }
        if (!tonTaiSanPham) {
            respon.setError("Khong ton tai san pham");
            return respon;
        }
        respon.setError("Mua thanh cong");
        return respon;
    }

    @Override
    public Respon<ProductDetails> addQuantity(String name, int quantity) {
        Respon<ProductDetails> respon = new Respon<>();
        boolean tonTaiSanPham = false;
        for (ProductDetails x : dbcontext.productDetailsRepo.findAll()) {
            if (x.getProductPropertyName().toLowerCase().contains(name.toLowerCase())) {
                tonTaiSanPham = true;
                int num = x.getQuantity();
                int higher = 0;
                int lower = 0;
                if(num > quantity)
                    lower = num - quantity;
                else
                    higher = quantity-num;
                int idParent = x.getParentId();
                x.setQuantity(quantity);
                dbcontext.productDetailsRepo.save(x);
                do {
                    ProductDetails productParent = new ProductDetails();
                    productParent = dbcontext.productDetailsRepo.findById(idParent).get();
                    productParent.setQuantity(productParent.getQuantity() + higher-lower);
                    dbcontext.productDetailsRepo.save(productParent);
                    if (productParent.getParentId() == null) {
                        break;
                    }
                    idParent = productParent.getParentId();
                } while (true);
            }
        }
        if (!tonTaiSanPham) {
            respon.setError("Khong ton tai san pham");
            return respon;
        }
        respon.setError("Cap nhat thanh cong");
        return respon;
    }

    @Override
    public List<ProductDetails> ShowAllProductDetails() {
        return dbcontext.productDetailsRepo.findAll();
    }
}