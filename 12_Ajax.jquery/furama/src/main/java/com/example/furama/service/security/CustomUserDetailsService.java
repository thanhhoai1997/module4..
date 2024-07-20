//package com.example.furama.service.security;
//
//import com.example.furama.model.CustomUserDetail;
//import com.example.furama.model.Role;
//import com.example.furama.model.User;
//import com.example.furama.repositories.user.IUserRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//
//import java.util.ArrayList;
//import java.util.List;

//@Service
//public class CustomUserDetailsService implements UserDetailsService {
//    @Autowired
//    private IUserRepository iUserRepository;
//
//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        User user = iUserRepository.findByUsername(username);
//        if (user == null){
//            throw new UsernameNotFoundException("Invalid username or password");
//        }
//            List<SimpleGrantedAuthority> list = new ArrayList<>();
//            for (Role role: user.getRoles()
//                 ) {
//                list.add(new SimpleGrantedAuthority(role.getName()));
//
//            }
//
//
//        return new CustomUserDetail(user,list);
//    }
//}
