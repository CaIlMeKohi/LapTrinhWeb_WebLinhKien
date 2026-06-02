package com.electroshop.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.electroshop.entity.CartLine;
import com.electroshop.entity.CustomerOrder;
import com.electroshop.entity.Product;
import com.electroshop.service.ProductService;

@Controller
public class ShoppingController {
    @Autowired
    private ProductService productService;

    @GetMapping("/cart")
    public String cart(HttpSession session, Model model) {
        model.addAttribute("cartLines", cartLines(session));
        return "cart";
    }

    @PostMapping("/cart/add/{id}")
    public String add(@PathVariable Long id, HttpSession session) {
        Product product = productService.findById(id);
        if (product != null && product.getStock() > 0) {
            CartLine line = findLine(cartLines(session), id);
            if (line == null) cartLines(session).add(new CartLine(product, 1));
            else if (line.getQuantity() < product.getStock()) line.setQuantity(line.getQuantity() + 1);
        }
        return "redirect:/cart";
    }

    @PostMapping("/cart/update/{id}")
    public String update(@PathVariable Long id, @RequestParam Integer quantity, HttpSession session) {
        CartLine line = findLine(cartLines(session), id);
        if (line != null && quantity != null && quantity > 0 && quantity <= line.getProduct().getStock()) line.setQuantity(quantity);
        return "redirect:/cart";
    }

    @PostMapping("/cart/remove/{id}")
    public String remove(@PathVariable Long id, HttpSession session) {
        CartLine line = findLine(cartLines(session), id);
        if (line != null) cartLines(session).remove(line);
        return "redirect:/cart";
    }

    @PostMapping("/cart/clear")
    public String clear(HttpSession session) {
        cartLines(session).clear();
        return "redirect:/cart";
    }

    @GetMapping("/checkout")
    public String checkout(HttpSession session) {
        return cartLines(session).isEmpty() ? "redirect:/cart" : "checkout";
    }

    @PostMapping("/checkout")
    public String checkout(@RequestParam String recipientName, @RequestParam String phone,
                           @RequestParam String address, @RequestParam(required = false) String note,
                           HttpSession session, Model model) {
        if (recipientName.isBlank() || phone.isBlank() || address.isBlank() || cartLines(session).isEmpty()) {
            model.addAttribute("checkoutError", "Vui long nhap du thong tin");
            return "checkout";
        }
        CustomerOrder order = new CustomerOrder();
        order.setId((long) (orders(session).size() + 1));
        order.setRecipientName(recipientName);
        order.setPhone(phone);
        order.setAddress(address);
        order.setNote(note);
        order.setLines(new ArrayList<>(cartLines(session)));
        for (CartLine line : cartLines(session)) {
            Product product = line.getProduct();
            if (line.getQuantity() > product.getStock()) {
                model.addAttribute("checkoutError", "So luong san pham khong du");
                return "checkout";
            }
            product.setStock(product.getStock() - line.getQuantity());
            productService.save(product);
        }
        orders(session).add(order);
        cartLines(session).clear();
        session.setAttribute("lastOrder", order);
        return "redirect:/order-success";
    }

    @GetMapping("/order-success")
    public String orderSuccess() { return "order-success"; }

    @GetMapping("/orders")
    public String orders(HttpSession session, Model model) {
        model.addAttribute("orders", orders(session));
        return "orders";
    }

    @GetMapping("/orders/{id}")
    public String orderDetail(@PathVariable Long id, HttpSession session, Model model) {
        for (CustomerOrder order : orders(session)) {
            if (order.getId().equals(id)) {
                model.addAttribute("order", order);
                return "order-detail";
            }
        }
        return "redirect:/orders";
    }

    @SuppressWarnings("unchecked")
    private List<CartLine> cartLines(HttpSession session) {
        List<CartLine> lines = (List<CartLine>) session.getAttribute("cartLines");
        if (lines == null) { lines = new ArrayList<>(); session.setAttribute("cartLines", lines); }
        return lines;
    }

    @SuppressWarnings("unchecked")
    private List<CustomerOrder> orders(HttpSession session) {
        List<CustomerOrder> orders = (List<CustomerOrder>) session.getAttribute("orders");
        if (orders == null) { orders = new ArrayList<>(); session.setAttribute("orders", orders); }
        return orders;
    }

    private CartLine findLine(List<CartLine> lines, Long productId) {
        for (CartLine line : lines) if (line.getProduct().getId().equals(productId)) return line;
        return null;
    }
}
