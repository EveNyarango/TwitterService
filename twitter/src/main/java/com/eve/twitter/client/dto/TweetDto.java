package com.eve.twitter.client.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class TweetDto {
private List<DataDto> data;
private MetaDto meta;
}
