package com.payease.scfordermis.service;

import com.payease.scfordermis.bo.responseBo.PageResponseCommBean;
import com.payease.scfordermis.entity.User;
import org.springframework.data.domain.Page;

import java.util.List;


/**
 * Created by lch on 2018/1/4.
 */
public interface IUserService {

    List<User> getUsers();

    User getUserById(Long id);

    User saveUser(User user);

    User updateUser(User user);

    List<User> getByExample(String name,String password);

    Page<User> findUserList(String username, int page, int size);

    List<User> findAllEm();

    PageResponseCommBean testPage();
}
