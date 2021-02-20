package com.github.fisherman08.spring_batch_sample.domain

import java.time.LocalDateTime

data class ConvertedUser(val id: Int, val name: String, val convertedOn: LocalDateTime)
