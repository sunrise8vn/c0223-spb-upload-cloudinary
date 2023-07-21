package com.cg.model.dto.product.avatar;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.persistence.Column;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Accessors(chain = true)
public class ProductAvatarDTO {

    private String id;
    private String fileName;
    private String fileFolder;
    private String fileUrl;
    private String fileType;
    private String cloudId;
}
