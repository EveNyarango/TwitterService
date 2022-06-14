package com.eve.twitter.client.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class MetaDto {
    private String newest_id;
    private String oldest_id;
    private Integer result_count;
    private String next_token;
}
