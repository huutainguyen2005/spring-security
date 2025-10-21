package vn.edu.fpt.musicstore.services;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import vn.edu.fpt.musicstore.entities.User;
import vn.edu.fpt.musicstore.repositories.UserRepository;

@Service
public class UserService implements UserDetailsService {
    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    //Thực hiện gọi repo để truy xuất dữ liệu người dùng trong DB
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        //Flow -> Repo gọi vào DB tìm đầy đủ thông tin của 1  User với username người dùng cung cấp
        User user = userRepository.getUserByUsernameIgnoreCase(username);
        if (user == null) {
            throw new UsernameNotFoundException("User not found!");
        }

        //Trả về 1 object thuộc kiểu UserDetails (Spring Security)
        //Object này gọi là Principal, Authorities là quyền hạn của Principal
        return org.springframework.security.core.userdetails.User
                .withUsername(user.getUsername())
                .password(user.getPassword())
                .authorities("ROLE_" + user.getRole())
                .build();
    }
}
