package com.luanphm.CourseManagement.model.category;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.luanphm.CourseManagement.entity.Category;
import lombok.*;
import lombok.experimental.Accessors;
import org.hibernate.validator.constraints.Length;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@ToString
@Accessors(fluent = true)
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class CategoryDTO {

    private int id;

    @Length(min = 2, max = 10)
    private String name;

    public CategoryDTO(Category category) {
        this.id = category.id();
        this.name = category.name();
    }

}
