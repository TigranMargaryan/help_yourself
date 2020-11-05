package com.help.yourself.core.repository;

import com.help.yourself.core.data.ChatRoom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ChatRoomRepository extends JpaRepository<ChatRoom, String> {

    @Override
    Optional<ChatRoom> findById(String s);
}
