package com.yourview.moview.repository;

import com.yourview.moview.entity.Tag;
import com.yourview.moview.entity.TagConnectUser;
import com.yourview.moview.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TagConnectUserRepository extends JpaRepository<TagConnectUser, Long> {
    List<TagConnectUser> findAllByUser(User user);
}
