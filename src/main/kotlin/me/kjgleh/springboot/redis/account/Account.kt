package me.kjgleh.springboot.redis.account

import org.springframework.data.annotation.Id
import org.springframework.data.redis.core.RedisHash
import java.util.*

@RedisHash("accounts")
class Account(
    @Id
    val id: String = UUID.randomUUID().toString(),

    val userName: String,

    val email: String
)
