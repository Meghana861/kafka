package com.amzur.userentities

import groovy.transform.ToString
import io.micronaut.core.annotation.Introspected
import io.micronaut.serde.annotation.Serdeable

@ToString(includeNames = true)
@Serdeable.Deserializable
@Introspected
class User {
    String id
    String name
    String email
    String phoneNumber
    String event
}
