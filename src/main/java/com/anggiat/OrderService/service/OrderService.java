package com.anggiat.OrderService.service;

import com.anggiat.OrderService.dto.OrderLineItemsDTO;
import com.anggiat.OrderService.dto.OrderRequest;
import com.anggiat.OrderService.model.Order;
import com.anggiat.OrderService.model.OrderLineItems;
import com.anggiat.OrderService.repository.OrderRepository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Transactional
public class OrderService {

    private final OrderRepository orderRepository;

    public void placeOrder(OrderRequest orderRequest){
        Order order = new Order();
        order.setOderNumber(UUID.randomUUID().toString());
        List<OrderLineItems> orderLineItems = orderRequest.getOrderLineItemsDTOList()
                .stream()
                .map(this::mapToDTO)
                .toList();
        order.setOrderLineItemsList(orderLineItems);
    }



    private OrderLineItems mapToDTO(OrderLineItemsDTO orderLineItemsDTO) {
        OrderLineItems orderLineItems = new OrderLineItems();
        orderLineItems.setPrice(orderLineItemsDTO.getPrice());
        orderLineItems.setQuantity(orderLineItemsDTO.getQuantity());
        orderLineItems.setSkuCode(orderLineItemsDTO.getSkuCode());
        return orderLineItems;
    }
}
