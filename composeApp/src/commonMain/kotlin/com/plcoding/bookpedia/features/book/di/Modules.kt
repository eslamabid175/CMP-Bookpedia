package com.plcoding.bookpedia.features.book.di

import androidx.sqlite.driver.bundled.BundledSQLiteDriver

import com.plcoding.bookpedia.core.data.HttpClientFactory
import com.plcoding.bookpedia.features.book.data.local.database.DatabaseFactory
import com.plcoding.bookpedia.features.book.data.local.database.FavoriteBookDatabase
import com.plcoding.bookpedia.features.book.data.remote.network.KtorRemoteBookDataSource
import com.plcoding.bookpedia.features.book.data.remote.network.RemoteBookDataSource
import com.plcoding.bookpedia.features.book.data.repositoryimpl.DefaultBookRepository
import com.plcoding.bookpedia.features.book.domain.repository.BookRepository
import com.plcoding.bookpedia.features.book.presentation.SelectedBookViewModel
import com.plcoding.bookpedia.features.book.presentation.book_details.BookDetailViewModel
import com.plcoding.bookpedia.features.book.presentation.book_list.BookListViewModel
import org.koin.compose.viewmodel.dsl.viewModelOf
import org.koin.core.module.Module
import org.koin.core.module.dsl.singleOf
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.bind
import org.koin.dsl.module
import org.koin.core.module.dsl.singleOf
import org.koin.core.module.dsl.viewModelOf

expect val platformModule: Module

val sharedModule = module {
    single { HttpClientFactory.create(get()) }
  //  single<RemoteBookDataSource>{ KtorRemoteBookDataSource(get()) }
    singleOf(::KtorRemoteBookDataSource).bind<RemoteBookDataSource>()
    singleOf(::DefaultBookRepository).bind<BookRepository>()
//single<BookRepository> { DefaultBookRepository(get(), get())  }
    single {
        get<DatabaseFactory>().create()
            .setDriver(BundledSQLiteDriver())
            .build()
    }
    single { get<FavoriteBookDatabase>().favoriteBookDao }
viewModel { BookListViewModel(get()) }
  //  viewModelOf(::BookListViewModel)

viewModel { BookDetailViewModel(get(), get()) }
viewModel { SelectedBookViewModel() }
}