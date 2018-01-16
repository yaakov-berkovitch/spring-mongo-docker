package org.demo.springmongo;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection = "users")
public class User {

    @Id
    public String id;

    public String email;
    public String password;

    public User() {}

    public User(String email, String password) {
        this.email = email;
        this.password = password;
    }

    @Override
    public String toString() {
        return String.format(
                "User[id=%s, email='%s']",
                id, email);
    }

}

