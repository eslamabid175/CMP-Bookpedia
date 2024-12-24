package com.plcoding.bookpedia.features.book.presentation.book_list

import com.plcoding.bookpedia.features.book.domain.models.Book


sealed interface BookListAction {
    data class OnSearchQueryChange(val query: String): BookListAction
    data class OnBookClick(val book: Book): BookListAction
    data class OnTabSelected(val index: Int): BookListAction
}