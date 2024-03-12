package com.example.service.user;

import com.example.model.Role;
import com.example.model.User;
import com.example.repositories.blog.IBlogRepository;
import com.example.repositories.user.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BlogUserDetailService implements UserDetailsService {
    @Autowired
    private IUserService iUserService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = iUserService.findByUsername(username);
        if (user != null) {
            List<GrantedAuthority> grantList = new ArrayList<GrantedAuthority>();
            for (Role role : user.getRoles()) {
                grantList.add(new SimpleGrantedAuthority(role.getRoleName()));
            }
//            GrantedAuthority authority = new SimpleGrantedAuthority("ADMIN_USER");
//            grantList.add(authority);
            UserDetails userDetails = new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), grantList);
            return userDetails;
        } else {
            new UsernameNotFoundException("Login fail !");
        }
        return null;
    }
}
