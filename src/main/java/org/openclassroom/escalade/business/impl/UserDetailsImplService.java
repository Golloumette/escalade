package org.openclassroom.escalade.business.impl;




import org.openclassroom.escalade.business.UtilisateurService;
import org.openclassroom.escalade.model.UtilisateurBo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class UserDetailsImplService implements UserDetailsService {
   

    @Autowired
    UtilisateurService utilisateurService;

    public UserDetailsImplService() {
    }

    @Override
    public UserDetails loadUserByUsername(String pseudo) throws UsernameNotFoundException {
    	System.out.println("pseudo="+pseudo);
        UtilisateurBo utilisateurBo = findUserbyUsername(pseudo);
System.out.println("utilisateurBo="+utilisateurBo.toString());
        UserBuilder builder = null;
        if (utilisateurBo == null) {
            throw new UsernameNotFoundException("User not found.");
        }      
        return new MyUserPrincipal(utilisateurBo);
    }

    private UtilisateurBo findUserbyUsername(String pseudo) {
   
        return utilisateurService.findByPseudo(pseudo);
    }
}
