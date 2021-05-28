package ru.geekbrains.april.market.HW;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;
import ru.geekbrains.april.market.models.User;

@Service
@RequiredArgsConstructor
public class UserService implements UserDetailsService
{
    public void save(String userName, String password, String email)
    {
        userRepository.save(new User(userName, password, email));
    }
}
