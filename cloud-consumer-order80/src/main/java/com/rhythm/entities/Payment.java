package com.rhythm.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Payment implements Serializable {

    //@TableId(type = IdType.AUTO) // 设置主键自增，生成的主键号会放在传入的实体类中
    private Long id;
    private String serialno;
}
