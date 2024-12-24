package com.plcoding.bookpedia.features.book.presentation.book_list

import com.plcoding.bookpedia.core.presentation.UiText
import com.plcoding.bookpedia.features.book.domain.models.Book

data class BookListState(
    val searchQuery: String = "Kotlin",
    val searchResults: List<Book> = emptyList(),
    val favoriteBooks: List<Book> = emptyList(),
    val isLoading: Boolean = true,
    val selectedTabIndex: Int = 0,
    // UiText is used to show error messages in a more readable way like a toast message.
    val errorMessage: UiText? = null
)