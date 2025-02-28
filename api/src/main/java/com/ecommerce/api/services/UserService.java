package com.ecommerce.api.services;

import com.ecommerce.api.dto.UserDTO;
import java.util.List;

public interface UserService {
    UserDTO getUserById(Long id);
    List<UserDTO> getAllUsers();
    UserDTO create(UserDTO userDTO);
    UserDTO update(Long id, UserDTO userDTO);
    UserDTO delete(Long id);
}
