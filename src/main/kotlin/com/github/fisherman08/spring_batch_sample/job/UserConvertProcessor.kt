package com.github.fisherman08.spring_batch_sample.job

import com.github.fisherman08.spring_batch_sample.domain.ConvertedUser
import com.github.fisherman08.spring_batch_sample.domain.User
import org.springframework.batch.item.ItemProcessor
import java.time.LocalDateTime


class UserConvertProcessor : ItemProcessor<User, ConvertedUser> {
    override fun process(item: User): ConvertedUser {
        println("process: $item")
        return item.convert()
    }
}

private fun User.convert(): ConvertedUser =
    ConvertedUser(
        id = this.id,
        name = "${this.name}: Converted!!!",
        convertedOn = LocalDateTime.now()
    )
