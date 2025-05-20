package org.restdev.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import org.restdev.domain.User;

@ApplicationScoped
public class UserRepository implements PanacheRepository<User> {
}
