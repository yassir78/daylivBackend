package com.dayliv.dayliv.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DeleteImageRequest {
   private String fileName;
   private long productImageId;
}
