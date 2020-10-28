package com.help.yourself.core.manager;

import com.help.yourself.core.context.UserContext;
import org.springframework.stereotype.Service;

import java.nio.file.AccessDeniedException;

@Service
public class SecurityManager {

    public void check(UserContext userContext) throws AccessDeniedException{

    }
}
