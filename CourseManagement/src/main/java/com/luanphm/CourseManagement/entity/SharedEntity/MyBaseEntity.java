package com.luanphm.CourseManagement.entity.SharedEntity;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

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
}
