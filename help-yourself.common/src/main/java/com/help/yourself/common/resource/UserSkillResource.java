package com.help.yourself.common.resource;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UserSkillResource {

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private String id;

    private String skillId;

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private String userId;
}
