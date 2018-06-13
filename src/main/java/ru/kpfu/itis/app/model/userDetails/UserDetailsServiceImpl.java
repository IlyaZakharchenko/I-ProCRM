package ru.kpfu.itis.app.model.userDetails;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ru.kpfu.itis.app.model.entities.AppUser;
import ru.kpfu.itis.app.repo.UserRepo;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private UserRepo repo;

    public UserDetailsServiceImpl(UserRepo repo) {
        this.repo = repo;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        AppUser user = repo.getOneByLogin(username).orElseThrow(()
                -> new IllegalArgumentException("User not found by login <" + username + ">"));
        return new UserDetailsImpl(user);
    }
}
