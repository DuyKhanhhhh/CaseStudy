package com.example.casestudy_web.controller;

import com.example.casestudy_web.service.IProductService;
import com.example.casestudy_web.service.ProductService;
import com.example.casestudy_web.model.Product;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "ProductServer", value = "/product")
public class ProductServer extends HttpServlet {
    private IProductService product;
    private static List<Product> list = new ArrayList<>();

    @Override
    public void init(){
        product = new ProductService();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null){
            action = "";
        }
        switch (action) {
            case "create":
                insertProduct(request,response);
                break;
            case "search":
                searchProduct(request,response);
                break;
        }

    }
    private void searchProduct(HttpServletRequest request, HttpServletResponse response) {
        String name = request.getParameter("name");
        List<Product> listProduct = product.searchProduct(name);
        request.setAttribute("searchProduct",listProduct);
        try {
            request.getRequestDispatcher("view/search.jsp").forward(request,response);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    private void insertProduct(HttpServletRequest request, HttpServletResponse response) {
        String name = request.getParameter("name");
        String price = request.getParameter("price");
        String img = request.getParameter("img");
        Product newProduct = new Product(name,price,img);
        product.insertProduct(newProduct);
        try {
            response.sendRedirect("/product");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null){
            action = "";
        }
        switch (action){
            case "create":
                createProduct(request,response);
                break;
            case "delete":
                deleteCart(request,response);
                break;
            case "add":
                showCart(request,response);
                break;
            default:
                showProduct(request,response);
                break;
        }

    }

    private void createProduct(HttpServletRequest request, HttpServletResponse response) {
        try {
            request.getRequestDispatcher("view/create.jsp").forward(request,response);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void deleteCart(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        try {
            product.deleteProduct(id);
            request.getRequestDispatcher("view/list.jsp").forward(request, response);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void showCart(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Product existingProduct = product.selectProduct(id);
        list.add(existingProduct);
        HttpSession session = request.getSession();
        session.setAttribute("list", list);
        request.getRequestDispatcher("view/cart.jsp").forward(request,response);
    }

    private void showProduct(HttpServletRequest request, HttpServletResponse response) throws IOException {
        List<Product> listProduct = product.selectAllProduct();
       request.setAttribute("listProduct", listProduct);
        try {
            request.getRequestDispatcher("view/index.jsp").forward(request,response);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        }
    }
}

