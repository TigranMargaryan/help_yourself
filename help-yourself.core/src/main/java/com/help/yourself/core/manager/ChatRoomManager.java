package com.help.yourself.core.manager;

import com.help.yourself.core.context.UserContext;
import com.help.yourself.core.data.ChatRoom;
import com.help.yourself.core.manager.IManager.IChatRoomManager;
import org.springframework.stereotype.Service;

@Service
public class ChatRoomManager implements IChatRoomManager {



    @Override
    public ChatRoom getById(String id) {
        return null;
    }

    @Override
    public void create(UserContext userContext, ChatRoom chatRoom) {

    }
}
