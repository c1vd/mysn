package com.company.mysn.dto;

import jakarta.annotation.Nullable;
import lombok.Data;

@Data
public class RegistrationDto {
    public String username;
    public String password;
    @Nullable
    public String check(){
        // Проверка имени пользователя
        if(username.contains(" ")) return "Имя пользователя не должно содержать пробелов";
        if(username.length() < 8) return "Имя пользователя должно быть больше 7 символов";
        if(username.length() > 255) return "Пожалуйста, не ставьте такое имя пользователя";


        // Проверка пароля
        if(password.contains(" ")) return "Пароль не должен содержать пробелов";
        if(password.length() < 8) return "Пароль должен быть больше 7 символов";
        if(password.length() > 255) return "Пожалуйста, не ставьте такой пароль";
        if(password.chars().filter(
            c -> "0123456789".contains(String.valueOf((char)c))
        ).count() < 3) return "Пароль должен содержать не менее 3 цифр";

        
        return null;
    }
}
