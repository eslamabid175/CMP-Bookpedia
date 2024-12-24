package com.plcoding.bookpedia.features.book.di

import com.plcoding.bookpedia.features.book.data.local.database.DatabaseFactory
import io.ktor.client.engine.HttpClientEngine
import io.ktor.client.engine.okhttp.OkHttp
import org.koin.android.ext.koin.androidApplication
import org.koin.core.module.Module
import org.koin.dsl.module

actual val platformModule: Module
    get() = module { 
        single<HttpClientEngine> {
            OkHttp.create()

        }
        single { DatabaseFactory(androidApplication()) }

    }