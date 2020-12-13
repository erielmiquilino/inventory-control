package com.inventoryControl.domain.base;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;

import java.time.LocalDateTime;

@Data
@Getter
@Setter
public class BaseEntity {

    @Id
    private String id;

    private LocalDateTime insertDateTime;

}
