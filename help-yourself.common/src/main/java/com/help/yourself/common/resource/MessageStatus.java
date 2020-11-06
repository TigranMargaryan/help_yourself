package com.help.yourself.common.resource;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;
import org.json.simple.JSONObject;

import javax.validation.constraints.NotNull;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum MessageStatus {

    RECEIVED(1, "received"),
    DELIVERED(2, "delivered");

    @NotNull
    private final int value;

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private final String label;

    MessageStatus(int value, String label) {
        this.value = value;
        this.label = label;
    }

    @JsonCreator
    public static MessageStatus valueOf(int value) {
        for (MessageStatus e : MessageStatus.values()) {
            if (e.value == value) {
                return e;
            }
        }
        return null;
    }

    @JsonValue
    public int getValue() {
        return value;
    }

    public String getLabel() {
        return label;
    }

    public JSONObject toJSON() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("value", value);
        jsonObject.put("label", label);
        return jsonObject;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("filtered{");
        sb.append("value=").append(value);
        sb.append(", label='").append(label).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
