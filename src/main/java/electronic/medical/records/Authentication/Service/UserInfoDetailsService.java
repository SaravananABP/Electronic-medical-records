package electronic.medical.records.Authentication.Service;

import electronic.medical.records.Authentication.Pojo.UserDetailsInfo;
import electronic.medical.records.Authentication.Repository.UserDetailsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;


/**
 *Custom implementation of UserDetailsService.
 *This class retrieves UserDetails based on the provided username from the UserInfoRepo repository.
 */
@Component
public class UserInfoDetailsService implements UserDetailsService {
    @Autowired
    private UserDetailsRepo userDetailsRepo;


    String getEmailId=null;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserDetailsInfo userDetailsInfo = userDetailsRepo.findByUserName(username);

        if (userDetailsInfo == null) {
            throw new UsernameNotFoundException("User not found: " + username);
        }
        getEmailId=userDetailsInfo.getEmailId();
        String[] roles = userDetailsInfo.getRole().split(",");

        return User.withUsername(userDetailsInfo.getUserName())
                .password(userDetailsInfo.getPassword())
                .roles(roles)
                .build();
    }
    public String getUserEmail(){
        return getEmailId;
    }
    public String currentEmailId(String username){
        UserDetailsInfo userDetailsInfo = userDetailsRepo.findByUserName(username);

        if (userDetailsInfo == null) {
            throw new UsernameNotFoundException("User not found: " + username);
        }
        return userDetailsInfo.getEmailId();
    }

}
