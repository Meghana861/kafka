package com.amzur.userentities

import io.micronaut.core.annotation.Introspected
import io.micronaut.serde.annotation.Serdeable

@Introspected
@Serdeable
class User {
    int id
    String name
    int age
    User(int id,String name,int age){
        this.id=id
        this.name=name
        this.age=age
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
