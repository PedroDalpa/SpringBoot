package academy.dev.esssencialspringboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import academy.dev.esssencialspringboot.domain.DevDojoUser;

public interface DevDojoUserRepository extends JpaRepository<DevDojoUser, Long> {
  DevDojoUser findByUsername(String username);
}
