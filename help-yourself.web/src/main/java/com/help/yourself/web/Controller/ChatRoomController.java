package com.help.yourself.web.Controller;

import com.help.yourself.core.data.ChatRoom;
import com.help.yourself.core.manager.IManager.IChatRoomManager;
import com.help.yourself.web.config.Response;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.messaging.handler.annotation.MessageMapping;

@RestController
public class ChatRoomController {

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    IChatRoomManager chatRoomManager;

    @PostMapping(value = "/help-yourself/chat", produces = MediaType.APPLICATION_JSON_VALUE)
    public Response createChatRoom(@Payload ChatRoom chatRoom){

        System.out.println(chatRoom);
        return new Response("Ok");
    }
}
