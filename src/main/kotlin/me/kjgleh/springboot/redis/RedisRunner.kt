package me.kjgleh.springboot.redis

import me.kjgleh.springboot.redis.account.Account
import me.kjgleh.springboot.redis.account.AccountRepository
import org.springframework.boot.ApplicationArguments
import org.springframework.boot.ApplicationRunner
import org.springframework.data.redis.core.StringRedisTemplate
import org.springframework.stereotype.Component

@Component
class RedisRunner(
    private val redisTemplate: StringRedisTemplate,
    private val accountRepository: AccountRepository
) : ApplicationRunner {

    override fun run(args: ApplicationArguments?) {
        // StringRedisTemplate을 사용하여 데이터 등록
        val values = redisTemplate.opsForValue()
        values.set("name", "kjgleh")

        // CrudRepository를 사용하여 데이터 등록
        val account = Account(
            userName = "tester",
            email = "test@test.com"
        )
        accountRepository.save(account)
        val savedAccount = accountRepository.findById(account.id)
        println(savedAccount.get().id)
        println(savedAccount.get().userName)
        println(savedAccount.get().email)
    }
}
