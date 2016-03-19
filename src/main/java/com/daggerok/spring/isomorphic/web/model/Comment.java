package com.daggerok.spring.isomorphic.web.model;

import lombok.Builder;
import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.experimental.Accessors;

@Data
@Builder
@Accessors(chain = true)
@RequiredArgsConstructor(staticName = "of")
public class Comment {
    @NonNull String author, content;
}
