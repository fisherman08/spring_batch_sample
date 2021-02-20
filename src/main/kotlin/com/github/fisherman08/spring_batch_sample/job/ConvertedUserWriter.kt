package com.github.fisherman08.spring_batch_sample.job

import com.github.fisherman08.spring_batch_sample.domain.ConvertedUser
import org.springframework.batch.item.ItemWriter

class ConvertedUserWriter : ItemWriter<ConvertedUser> {
    override fun write(items: MutableList<out ConvertedUser>) {
        items.forEach { u ->
            println("write: $u")
        }
    }
}
