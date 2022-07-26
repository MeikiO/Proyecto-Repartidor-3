package edu.mondragon.mikel_murua.proyecto_repartidor3.zzz_seguridad;

import java.util.Collection;
import java.util.Collections;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class UserDetails_Custom  implements UserDetails {

    private final UserAccount_Pojo userAccount;


    public UserDetails_Custom(UserAccount_Pojo userAccount) {
        this.userAccount = userAccount;
    }

    @Override
    public String getUsername() {
        return userAccount.getUsername();
    }

    @Override
    public String getPassword() {
        return userAccount.getContrasena();
    }

    @Override
    public boolean isAccountNonExpired() {
        return userAccount.isEstaActivo();
    }

    @Override
    public boolean isAccountNonLocked() {
        return userAccount.isEstaActivo();
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return userAccount.isEstaActivo();
    }

    @Override
    public boolean isEnabled() {
        return userAccount.isEstaActivo();
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.singletonList(new GrantedAuthority() {
            @Override
            public String getAuthority() {
                return "USER";
            }
        });
    }
}
