package com.makemyshow.authentication.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class PasswordModel {

    private String email;
    private String oldPassword;
    private String newPassword;
}
