package com.electroshop.controller;

import java.util.regex.Pattern;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import org.springframework.lang.NonNull;

import com.electroshop.controller.form.LoginForm;
import com.electroshop.controller.form.RegisterForm;

public class AuthFormValidator implements Validator {
    private static final Pattern EMAIL_PATTERN = Pattern.compile("^[^@\\s]+@[^@\\s]+\\.[^@\\s]+$");

    @Override
    public boolean supports(@NonNull Class<?> clazz) {
        return LoginForm.class.isAssignableFrom(clazz) || RegisterForm.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(@NonNull Object target, @NonNull Errors errors) {
        if (target instanceof RegisterForm) {
            RegisterForm form = (RegisterForm) target;
            if (form.getFullName() == null || form.getFullName().trim().isEmpty()) {
                errors.rejectValue("fullName", "fullName.required", "Ho va ten khong duoc de trong");
            }
            validateEmail(form.getEmail(), errors);
            validatePassword(form.getPassword(), errors);
            return;
        }
        LoginForm form = (LoginForm) target;
        validateEmail(form.getEmail(), errors);
        validatePassword(form.getPassword(), errors);
    }

    private void validateEmail(String email, Errors errors) {
        if (email == null || !EMAIL_PATTERN.matcher(email.trim()).matches()) {
            errors.rejectValue("email", "email.invalid", "Email khong hop le");
        }
    }

    private void validatePassword(String password, Errors errors) {
        if (password == null || password.length() < 6) {
            errors.rejectValue("password", "password.size", "Mat khau phai co it nhat 6 ky tu");
        }
    }
}
