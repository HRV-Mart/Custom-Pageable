package com.hrv.mart.custompageable

import org.springframework.data.domain.PageRequest
import java.lang.Integer.min
import java.util.Optional
import kotlin.math.max

object CustomPageRequest {
    private const val maxSize = 10;
    private const val minSize = 1;

    fun getPageRequest(optionalPage: Optional<Int>, optionalSize: Optional<Int>): PageRequest {
        val size = if (optionalSize.isPresent) {
            sizeLimit(optionalSize.get())
        }
        else {
            maxSize
        }
        val page = if (optionalPage.isPresent) {
            optionalPage.get()
        }
        else {
            0
        }
        return PageRequest.of(page, size)
    }
    private fun sizeLimit(size: Int) =
        min(maxSize, max(minSize, size))
}
