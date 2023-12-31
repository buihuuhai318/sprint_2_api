package com.example.sprint_2_api.service.cart.impl;

import com.example.sprint_2_api.dto.cart.ICartDto;
import com.example.sprint_2_api.dto.customer.ICustomerDtoForProject;
import com.example.sprint_2_api.dto.history.IHistoryDto;
import com.example.sprint_2_api.model.cart.Cart;
import com.example.sprint_2_api.repository.cart.ICartRepository;
import com.example.sprint_2_api.service.cart.ICartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CartService implements ICartService {

    @Autowired
    private ICartRepository cartRepository;

    @Override
    public List<Cart> findAll() {
        return cartRepository.findAll();
    }

    @Override
    public Optional<Cart> findById(Long id) {
        return cartRepository.findById(id);
    }

    @Override
    public void save(Cart cart) {
        cartRepository.save(cart);
    }

    @Override
    public void remove(Long id) {
        cartRepository.deleteById(id);
    }

    @Override
    public Optional<Cart> findCartByUser(Long id, int status, Long userId) {
        return cartRepository.findCartByCharitableProject_IdAndPayStatusAndAppUser_Id(id, status, userId);
    }

    @Override
    public List<Cart> findCarts(Long id, int status) {
        return cartRepository.findCartsByAppUser_IdAndPayStatus(id, status);
    }

    @Override
    public Long sumCart(Long id, int status) {
        List<Cart> list = findCarts(id, status);
        long sum = 0;
        for (Cart cart : list) {
            sum += cart.getMoney();
        }
        return sum;
    }

    @Override
    public List<ICartDto> findCartsDto(Long id) {
        return cartRepository.findCartsDto(id);
    }

    @Override
    public List<ICartDto> findCartsDtoByBill(Long id) {
        return cartRepository.findCartsDtoByBill(id);
    }

    @Override
    public List<ICustomerDtoForProject> findCustomerMost(Long id) {
        return cartRepository.findCustomerMost(id);
    }

    @Override
    public List<ICustomerDtoForProject> findCustomerLast(Long id) {
        return cartRepository.findCustomerLast(id);
    }

    @Override
    public Page<IHistoryDto> findAllHistory(Pageable pageable) {
        return cartRepository.findAllHistory(pageable);
    }
}
