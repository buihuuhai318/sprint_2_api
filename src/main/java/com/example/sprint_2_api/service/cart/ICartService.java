package com.example.sprint_2_api.service.cart;

import com.example.sprint_2_api.dto.cart.ICartDto;
import com.example.sprint_2_api.dto.customer.ICustomerDtoForProject;
import com.example.sprint_2_api.dto.history.IHistoryDto;
import com.example.sprint_2_api.model.cart.Cart;
import com.example.sprint_2_api.service.IGenerateService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface ICartService extends IGenerateService<Cart> {

    Optional<Cart> findCartByUser(Long id, int status, Long userId);

    List<Cart> findCarts(Long id, int status);

    Long sumCart(Long id, int status);

    List<ICartDto> findCartsDto(Long id);

    List<ICartDto> findCartsDtoByBill(Long id);

    List<ICustomerDtoForProject> findCustomerMost(Long id);

    List<ICustomerDtoForProject> findCustomerLast(Long id);

    Page<IHistoryDto> findAllHistory(Pageable pageable);
}
