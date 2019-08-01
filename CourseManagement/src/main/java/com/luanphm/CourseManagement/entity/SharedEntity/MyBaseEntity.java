package com.luanphm.CourseManagement.entity.SharedEntity;

import lombok.*;
import lombok.experimental.Accessors;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@MappedSuperclass
@Data
@Getter
@Setter
@Accessors(fluent = true)
@NoArgsConstructor
public class MyBaseEntity<IdType extends Serializable>{

    @NotNull
    @Id
    protected IdType id;

//    public IdType getId() {
//        return id;
//    }
//
//    public void setId(IdType id) {
//        this.id = id;
//    }
}
