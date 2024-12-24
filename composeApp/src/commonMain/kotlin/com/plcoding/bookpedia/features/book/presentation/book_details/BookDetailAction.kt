package com.plcoding.bookpedia.features.book.presentation.book_details

import com.plcoding.bookpedia.features.book.domain.models.Book


sealed interface BookDetailAction {
    data object OnBackClick: BookDetailAction
    data object OnFavoriteClick: BookDetailAction
    data class OnSelectedBookChange(val book: Book): BookDetailAction
}