package com.example.admin.repository;

import com.example.admin.AdminApplicationTests;
import com.example.admin.model.entity.OrderDetail;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class OrderDetailRepositoryTest extends AdminApplicationTests {

    //Dependency Injection (DI)
    @Autowired
    private OrderDetailRepository orderDetailRepository;

    @Test
    public void create() {
        OrderDetail orderDetail = new OrderDetail();
        orderDetail.setStatus("WAITING");
        orderDetail.setArrivalDate(LocalDateTime.now().plusDays(2));
        orderDetail.setQuantity(1);
        orderDetail.setTotalPrice(BigDecimal.valueOf(900000));
//        orderDetail.setItemId(1L);           // 어떤 상
//        orderDetail.setOrderGroupId(1L);     // 어떤 장바구니
        orderDetail.setCreatedAt(LocalDateTime.now());
        orderDetail.setCreatedBy("AdminServer");

        OrderDetail newOrderDetail = orderDetailRepository.save(orderDetail);

        assertNotNull(newOrderDetail);
    }

    @Test
    public void read() {

    }
}