package me.kjgleh.springboot.redis.account

import org.springframework.data.repository.CrudRepository

interface AccountRepository: CrudRepository<Account, String> {
}
