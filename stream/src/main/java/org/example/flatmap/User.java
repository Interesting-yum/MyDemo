package org.example.flatmap;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @className: org.example.flatmap.User
 * @title: User
 * @description:
 * @author: LiuYun
 * @datetime: 2022/10/22 23:27
 * @version: 1.0.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private String name;

    private String hobby;
}
