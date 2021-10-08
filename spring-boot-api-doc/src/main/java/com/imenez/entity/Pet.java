package com.imenez.entity;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value = "My Pet Model", description = "Pet model")
public class Pet {

    @ApiModelProperty(value = "Pet id")
    private int id;
    @ApiModelProperty(value = "Pet name")
    private String name;
    @ApiModelProperty(value = "Pet date")
    private Date date;
}
