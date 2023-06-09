package br.com.intelibank.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Entity
@Table(name = "user")
@EqualsAndHashCode(callSuper = false, onlyExplicitlyIncluded = true)
@ToString(callSuper = true, onlyExplicitlyIncluded = true)
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Builder(toBuilder = true)
@Getter
@Setter
public class User extends AbstractAuditingEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Size(min = 1, max = 50)
    @Column(length = 50, nullable = false)
    @NotBlank
    private String login;

    @JsonIgnore
    @NotNull
    @Size(min = 60, max = 60)
    @Column(name = "password_hash", length = 60, nullable = false)
    private String password;

    @Column(name = "name")
    @NotBlank
    private String name;

    @Email
    @Size(min = 5, max = 254)
    @Column(length = 254)
    @NotBlank
    private String email;

    @Builder.Default
    @NotNull
    @Column(nullable = false)
    private boolean activated = false;

    @Builder.Default
    @Column(nullable = false, name = "email_verified")
    @NotBlank
    private Boolean emailVerified = false;

    @Size(max = 20)
    @Column(name = "email_verification_key", length = 20)
    @JsonIgnore
    @NotBlank
    private String emailVerificationKey;

    @Size(max = 256)
    @Column(name = "image_url", length = 256)
    @NotBlank
    private String imageUrl;

    @Size(max = 20)
    @Column(name = "activation_key", length = 20)
    @JsonIgnore
    @NotBlank
    private String activationKey;

    @Size(max = 20)
    @Column(name = "reset_key", length = 20)
    @JsonIgnore
    private String resetKey;

}
