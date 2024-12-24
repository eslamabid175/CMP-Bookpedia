package com.plcoding.bookpedia.features.book.data.remote.network

import com.plcoding.bookpedia.core.domain.DataError
import com.plcoding.bookpedia.features.book.data.remote.dto.BookWorkDto
import com.plcoding.bookpedia.features.book.data.remote.dto.SearchResponseDto
import com.plcoding.bookpedia.core.domain.Result

interface RemoteBookDataSource {
    suspend fun searchBooks(
        query: String,
        resultLimit: Int? = null
    ): Result<SearchResponseDto, DataError.Remote>

    suspend fun getBookDetails(bookWorkId: String): Result<BookWorkDto, DataError.Remote>
}