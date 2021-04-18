package crcApp.crcAPI.data.model;


import lombok.*;
import lombok.experimental.SuperBuilder;


@SuperBuilder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class UserLogin extends AbstractEntity {

    private String email;

    private String password;




}

