package com.example.admin.repository;

import com.example.admin.AdminApplicationTests;
import com.example.admin.model.entity.Item;
import com.example.admin.model.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class UserRepositoryTest extends AdminApplicationTests {

    //Dependency Injection (DI)
    @Autowired
    private UserRepository userRepository;

    @Test
    public void create() {
        String account = "TestUser03";
        String password = "Test03";
        String status = "REGISTERED";
        String email = "Test03@gmail.com";
        String phoneNumber = "010-1111-3333";
        LocalDateTime registeredAt = LocalDateTime.now();

        User user = new User();
        user.setAccount(account);
        user.setPassword(password);
        user.setStatus(status);
        user.setEmail(email);
        user.setPhoneNumber(phoneNumber);
        user.setRegisteredAt(registeredAt);

        // Builder Example lombok!
//        User user1 = User.builder().account(account).password(password).status(status).build();

        User newUser = userRepository.save(user);

        assertNotNull(newUser);
        assertEquals(account, newUser.getAccount());
        assertEquals(password, newUser.getPassword());
        assertEquals(email, newUser.getEmail());
    }

    @Test
    @Transactional
    public void read() {
        Optional<User> user = userRepository.findFirstByPhoneNumberOrderByIdDesc("010-1111-2222");

        // Accessors Chaining Example lombok!
//        User user1 = new User().setAccount("").setEmail("");

        user.ifPresent(selectedUser -> {
            selectedUser.getOrderGroupList().forEach(orderGroup -> {
                System.out.println("----------------주문묶음----------------");
                System.out.println("수령인 : " + orderGroup.getRevName());
                System.out.println("수령지 : " + orderGroup.getRevAddress());
                System.out.println("총금액 : " + orderGroup.getTotalPrice());
                System.out.println("총수량 : " + orderGroup.getTotalQuantity());

                System.out.println("----------------주문상세----------------");

                orderGroup.getOrderDetailList().forEach(orderDetail -> {
                    System.out.println("파트너사 이름 : " + orderDetail.getItem().getPartner().getName());
                    System.out.println("파트너사 카테고리 : " + orderDetail.getItem().getPartner().getCategory().getTitle());
                    System.out.println("주문 상품 : " + orderDetail.getItem().getName());
                    System.out.println("고객센터 번호 : " + orderDetail.getItem().getPartner().getCallCenter());
                    System.out.println("주문의 상태 : " + orderDetail.getStatus());
                    System.out.println("도착예정일자 : " + orderDetail.getArrivalDate());

                });
            });
        });

        assertNotNull(user);
//        Optional<User> user = userRepository.findByAccountAndEmail("TestUser03", "TestUser03@gmail.com");
//
//        user.ifPresent(selectedUser -> {
//            selectedUser.getOrderDetailList().forEach(detail -> {
//                Item item = detail.getItem();
//                System.out.println(item);
//            });
//        });
    }

//    @Test
//    public void update() {
//        Optional<User> user = userRepository.findById(2L);
//
//        user.ifPresent(selectedUser -> {
//            selectedUser.setAccount("PPPP");
//            selectedUser.setUpdatedAt(LocalDateTime.now());
//            selectedUser.setUpdatedBy("update method()");
//
//            userRepository.save(selectedUser);
//        });
//    }
//
//    @Test
//    @Transactional
//    // Transactional -> 기존과 마찬가지로 method는 실행이 되지만
//    // 실제 데이터베이스는 영향을 받지 않는다.
//    public void delete() {
//        Optional<User> user = userRepository.findById(1L);
//
//        user.ifPresent(selectedUser -> userRepository.delete(selectedUser));
//    }
}