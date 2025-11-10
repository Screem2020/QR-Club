package com.example.service;

import com.example.model.User;
import com.example.repository.UserRepository;
import java.sql.SQLException;
import java.util.UUID;

public class QrCodeService {
    public String qrTouch(String uuid, UserRepository userRepository) throws SQLException {
        UUID uuidUser = UUID.fromString(uuid);
        User findUser = userRepository.checkQrCode(uuidUser);
        userRepository.updateQrCode(findUser);
        return findUser.toString();
    }
}
