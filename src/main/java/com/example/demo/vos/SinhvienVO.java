package com.example.demo.vos;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;


@Data
public class SinhvienVO implements Serializable {
    private static final long serialVersionUID = 1L;

    @NotNull(message = "name can not null")
    private String name;

    @NotNull(message = "lop can not null")
    private String lop;

    @NotNull(message = "tuoi can not null")
    private Integer tuoi;

}
