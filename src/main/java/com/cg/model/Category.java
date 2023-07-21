package com.cg.model;


import com.cg.model.dto.category.CategoryDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "categories")
public class Category extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String slug;

    public CategoryDTO toCategoryDTO() {
        return new CategoryDTO()
                .setId(id)
                .setTitle(title)
                .setSlug(slug)
                ;
    }
}
