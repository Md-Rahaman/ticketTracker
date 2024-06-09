package com.glgraded.TicketTracker.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TicketDTO {
	private Long id;

	private String title;

	private String shortDescription;

	private String content;

	private LocalDateTime createdOn;

	private LocalDateTime updatedOn;

}
