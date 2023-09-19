package com.tech.sciatech.DTO;

import com.tech.sciatech.mysqlentities.Gender;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserDetailsDTO {

    private String firstName;

    private String lastName;

    private String email;

    private Gender gender;

    private int age;

    private int height;

    private int weight;

    private Integer credentials_id;
}
