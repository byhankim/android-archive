package com.bhk.aac.mvvmshoppinglist

import android.app.Application
import com.bhk.aac.mvvmshoppinglist.data.db.ShoppingDatabase
import com.bhk.aac.mvvmshoppinglist.data.repositories.ShoppingRepository
import com.bhk.aac.mvvmshoppinglist.databinding.ActivityShoppingBinding.bind
import com.bhk.aac.mvvmshoppinglist.ui.shoppinglist.ShoppingViewModelFactory
import org.kodein.di.Kodein
import org.kodein.di.KodeinContainer
import org.kodein.di.android.x.androidXModule
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.provider
import org.kodein.di.generic.singleton

class ShoppingApplication:
    Application(), Kodein {

    override val kodein: Kodein = Kodein.lazy {
         import(androidXModule(this@ShoppingApplication))
        bind() from singleton { ShoppingDatabase(instance()) }
        bind() from singleton { ShoppingRepository(instance()) }
        bind() from provider {
            ShoppingViewModelFactory(instance())

        }
    }

    override val container: KodeinContainer
        get() = TODO()
}