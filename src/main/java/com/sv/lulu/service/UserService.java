package com.sv.lulu.service;

import com.sv.lulu.entity.Rol;
import com.sv.lulu.entity.User;
import com.sv.lulu.repository.UserRepository;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;

@Service("userDetailsService")
@Log4j
public class UserService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        //se busca por usuario
        User _user = userRepository.findByUsername(username);

        //Si está null se manda una exception
        if (_user == null) {
            throw new UsernameNotFoundException(username);
        }

        //Se crea un array list
        var roles = new ArrayList<GrantedAuthority>();

        //Se asignan los roles
        for (Rol rol : _user.getRoles()) {
            roles.add(new SimpleGrantedAuthority(rol.getRol()));
        }

        //Se retorna un nuevo user
        return new org.springframework.security.core.userdetails.User(_user.getUsername(), _user.getPassword(), roles);
    }
}
