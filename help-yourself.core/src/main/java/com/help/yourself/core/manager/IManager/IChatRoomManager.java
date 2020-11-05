package com.help.yourself.core.manager.IManager;

import com.help.yourself.core.context.UserContext;
import com.help.yourself.core.data.ChatRoom;

public interface IChatRoomManager {
    ChatRoom getById(String id);
    void create(UserContext userContext, ChatRoom chatRoom);
}
