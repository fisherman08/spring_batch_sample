package com.github.fisherman08.spring_batch_sample.job

import com.github.fisherman08.spring_batch_sample.domain.User
import org.springframework.batch.item.ItemReader
import org.springframework.context.annotation.Configuration

val users = listOf(
    User(id = 1, name = "aa"),
    User(id = 2, name = "bb"),
    User(id = 3, name = "cc")
)

@Configuration
class UserReader: ItemReader<User> {

    private var currentIndex = 0

    override fun read(): User? {
        if (currentIndex >= users.size) return null
        val user = users[currentIndex]
        currentIndex++
        println("read: $user")
        return user
    }
}
