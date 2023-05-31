package com.demo.disclaimer.model.api;

import lombok.*;


@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Acceptance {

    public Long id;
    public Disclaimer disclaimer_id;
    public Long user_id;
    public String create_at;

}
