package admin.portal.user.service;

import admin.portal.user.Repository.UserRepository;
import admin.portal.user.entities.User;
import admin.portal.user.enums.RoleType;
import com.sun.tools.javac.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {


    @Autowired
    private UserRepository userRepository;

    private final String DEFULT_PASSWORD = "password";

    private BCryptPasswordEncoder passwordEncoder;

    private RoleService roleService;




    public UserServiceImpl(UserRepository userRepo, BCryptPasswordEncoder passwordEncoder, RoleService roleService) {
        this.userRepository =  userRepo;
        this.passwordEncoder = passwordEncoder;
        this.roleService = roleService;

        this.seed();
    }



    @Override
    public void seed() {
        if(this.userRepository.count() > 0) {
            return;
        }
        final String  password= this.passwordEncoder.encode(DEFULT_PASSWORD);
       // for(int i=0; i>2; i++) {

       // }


        final  User user = new User();
        user.setPassword(password);
        user.setUsername("user");
        user.setAuthorities(List.of(this.roleService.find(RoleType.ROLE_USER)));

        final  User admin = new User();
        admin.setPassword(password);
        admin.setUsername("admin");
        admin.setAuthorities(List.of(this.roleService.find(RoleType.ROLE_ADMIN), this.roleService.find(RoleType.ROLE_USER)));
        this.userRepository.save(user);
        this.userRepository.saveAndFlush(admin);

    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User user = this.userRepository.findUserByUsername(s);

        if(user != null){
            return user;
        }
        throw new UsernameNotFoundException("user not found " + s);

    }
}
