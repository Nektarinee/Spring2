package ru.geekbrains.april.market.HW;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import ru.geekbrains.april.market.dtos.UserDto;
import ru.geekbrains.april.market.error_handling.ResourceNotFoundException;
import ru.geekbrains.april.market.models.User;
import ru.geekbrains.april.market.services.UserService;

import java.security.Principal;

@RestController
@RequestMapping("api/v1/users")
@RequiredArgsConstructor
public class UserController
{
    private final UserService userService;
    private final PasswordEncoder passwordEncoder;

    public void save(String userName, String password, String email)
    {
        userRepository.save(new User(userName, password, email));
    }

    @GetMapping("/me")
    public UserDto getCurrentUsername(Principal principal)
    {
        User currentUser = userService.findByUsername(principal.getName()).orElseThrow(()->
                new ResourceNotFoundException("User doesn't exist"));
        return new UserDto(currentUser.getUsername(),currentUser.getPassword() ,currentUser.getEmail() );
    }

    @PostMapping("/registration")
    public void registration(@RequestParam String userName, @RequestParam String password, @RequestParam String email)
    {
        if (userService.findByUsername(userName).isPresent())
        {
            throw new UserIsAlreadyRegistratedExeption("Пользователь " + userName) + " ужк зарегистрирован");
        }
        UserService.save(userName,passwordEncoder.encode(password),email);
    }
}
