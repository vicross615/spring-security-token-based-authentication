package admin.portal.user.Repository;


import admin.portal.user.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

    public Role findRoleByRole(String role);
}
