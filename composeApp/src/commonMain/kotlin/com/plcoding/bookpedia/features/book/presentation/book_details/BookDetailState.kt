package com.plcoding.bookpedia.features.book.presentation.book_details

import com.plcoding.bookpedia.features.book.domain.models.Book

data class BookDetailState(
    val isLoading: Boolean = true,
    val isFavorite: Boolean = false,
    val book: Book? = null
)