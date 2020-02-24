package admin.portal.user.service;

import admin.portal.user.Repository.RoleRepository;
import admin.portal.user.entities.Role;
import admin.portal.user.enums.RoleType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleRepository roleRepository;

    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;

        this.initialise();
    }



    @Override
    public void initialise() {
        if(roleRepository.count()>0){
            return;
        }
        for(RoleType roleType: RoleType.values()){
            Role role = new Role();
            role.setRole(roleType.name());
            this.roleRepository.save(role);
        }
            this.roleRepository.flush();

    }

    @Override
    public Role find(RoleType roleType) {
        return this.roleRepository.findRoleByRole(roleType.name());
    }

    @Override
    public List<Role> findAll() {
        return this.roleRepository.findAll();
    }
}
