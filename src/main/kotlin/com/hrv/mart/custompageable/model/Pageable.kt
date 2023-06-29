package com.hrv.mart.custompageable.model

data class Pageable<T>(
    val size: Long,
    val nextPage: Long?,
    val data: List<T>
) {
    companion object {
        fun getNextPage(pageSize: Long, page: Long, totalSize: Long) =
            if ((page + 1)*pageSize >= totalSize) {
                null
            }
            else{
                page + 1
            }

    }
}
