package org.openclassroom.escalade.business.impl;


import org.openclassroom.escalade.enume.RoleEnum;
import org.openclassroom.escalade.model.UtilisateurBo;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.sun.media.jfxmedia.logging.Logger;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.Table;


public class MyUserPrincipal implements UserDetails {
    private UtilisateurBo utilisateurBo;

    public MyUserPrincipal(UtilisateurBo utilisateurBo) {
    	System.out.println("classe my user");
        this.utilisateurBo = utilisateurBo;
    }

    public UtilisateurBo getUtilisateurBo() {
		return utilisateurBo;
	}


	public void setUtilisateurBo(UtilisateurBo utilisateurBo) {
		this.utilisateurBo = utilisateurBo;
	}

	@Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
		System.out.println("getauthorities");
        if (utilisateurBo.getRole() == RoleEnum.ROLE_ASSO.getNum()) {
            return AuthorityUtils.createAuthorityList(RoleEnum.ROLE_ASSO.getName());
        } else {
            return AuthorityUtils.createAuthorityList(RoleEnum.ROLE_USER.getName());
        }
    }

    @Override
    public String getPassword() {
    	System.out.println("getmdp="+utilisateurBo.getMdp());
         String cryptPwd = new BCryptPasswordEncoder().encode(utilisateurBo.getMdp());

         return cryptPwd;
    }

    @Override
    public String getUsername() {
    	System.out.println("getpseudo");
        return utilisateurBo.getPseudo();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}