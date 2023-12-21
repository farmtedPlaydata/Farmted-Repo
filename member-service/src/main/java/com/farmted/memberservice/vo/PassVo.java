package com.farmted.memberservice.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class PassVo {

    @JsonProperty("uuid")
    private String memberUuid;
    @JsonProperty("role")
    private String memberRole;
    @JsonProperty("email")
    private String email;

}
