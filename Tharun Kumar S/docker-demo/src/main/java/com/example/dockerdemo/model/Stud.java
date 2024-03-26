package com.example.dockerdemo.model;

import lombok.*;

@Data
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class Stud {
    private String sid;
    private String sname;
    private int marks;
}
