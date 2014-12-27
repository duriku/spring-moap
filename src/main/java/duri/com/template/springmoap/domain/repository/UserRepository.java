package duri.com.template.springmoap.domain.repository;

import duri.com.template.springmoap.domain.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Duri on 2014.12.11..
 */
public interface UserRepository extends JpaRepository<User, Long> {
}
