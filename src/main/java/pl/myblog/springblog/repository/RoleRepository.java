package pl.myblog.springblog.repository;

import org.hibernate.metamodel.model.convert.spi.JpaAttributeConverter;
import org.springframework.data.jpa.repository.JpaRepository;
import pl.myblog.springblog.model.Role;

public interface RoleRepository extends JpaRepository<Role, Long>{


}
