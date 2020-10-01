package com.example.adboard.service.moderate;

import org.springframework.security.access.prepost.PreAuthorize;

@PreAuthorize("hasRole('MODERATOR')")
public interface ModeratorManagement<E> {

    void publish(E entity);

    void reject(E entity);

    default void ban(Iterable<E> list) {
        list.forEach(this::ban);
    }

    void ban(E entity);

    void unban(E entity);
}
