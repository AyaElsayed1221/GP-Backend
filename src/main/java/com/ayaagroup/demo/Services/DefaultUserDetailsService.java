package com.ayaagroup.demo.Services;

import com.ayaagroup.demo.repository.UserRepository;
import com.ayaagroup.demo.security.user.DefaultUserDetails;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DefaultUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    //This class used to map between two objects of different class
    //(either by configuration done or mapping between two objects having the same object name)
    private final ModelMapper mapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        User user = userRepository.findByUserName(username)
//                .orElseThrow(() -> new UsernameNotFoundException("No user exist with this username: " + username));;
//
//        return mapper.map(user, DefaultUserDetails.class);

        var u = userRepository.findByUserName(username);
        return u.map(DefaultUserDetails::new)
                .orElseThrow(() -> new UsernameNotFoundException("Username not found exception " + username));
    }
}
