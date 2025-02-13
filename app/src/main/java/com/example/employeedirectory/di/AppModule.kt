package com.example.employeedirectory.di

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.employeedirectory.constant.BASE_URL
import com.example.employeedirectory.data.local.dao.EmployeeDao
import com.example.employeedirectory.data.local.database.AppDatabase
import com.example.employeedirectory.data.remote.service.EmployeesService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Singleton
    @Provides
    fun provideHttpClient(): OkHttpClient {
        return OkHttpClient
            .Builder()
            .readTimeout(30, TimeUnit.SECONDS)
            .connectTimeout(30, TimeUnit.SECONDS)
            .build()
    }

    @Singleton
    @Provides
    fun provideConverterFactory(): GsonConverterFactory =
        GsonConverterFactory.create()

    @Singleton
    @Provides
    fun provideRetrofit(
        okHttpClient: OkHttpClient,
        gsonConverterFactory: GsonConverterFactory
    ): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(gsonConverterFactory)
            .build()
    }

    @Singleton
    @Provides
    fun provideEmployeesService(retrofit: Retrofit): EmployeesService =
        retrofit.create(EmployeesService::class.java)

    @Singleton
    @Provides
    fun provideDatabase(@ApplicationContext applicationContext: Context): AppDatabase {
        return Room.databaseBuilder(
            applicationContext,
            AppDatabase::class.java, "database-employees"
        ).build()
    }

    @Singleton
    @Provides
    fun provideEmployeeDao(appDatabase: AppDatabase): EmployeeDao {
        return appDatabase.employeeDao()
    }
}