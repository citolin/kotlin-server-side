package br.com.ume.utils

import java.time.Instant
import java.time.ZoneOffset
import java.time.format.DateTimeFormatter

class DateUtils {
    companion object {
        fun currentTimestamp(): Instant {
            return Instant.now()
        }

        val timezone get(): ZoneOffset {
            return ZoneOffset.UTC
        }

        fun currentISOTimestampToString(): String {
            return DateTimeFormatter.ISO_INSTANT.format(Instant.now())
        }
    }
}