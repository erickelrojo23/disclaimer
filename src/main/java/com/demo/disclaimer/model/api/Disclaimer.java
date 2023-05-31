package com.demo.disclaimer.model.api;


import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Disclaimer {

    public Long id;
    public String name;
    public String text;
    public String version;
    public String create_at;
    public String update_at;

}
