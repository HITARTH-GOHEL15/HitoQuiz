package com.example.hitoquiz.domain.di

import com.example.hitoquiz.data.remote.data_trans_object.QuizApi
import com.example.hitoquiz.data.repository.QuizRepositoryImpl
import com.example.hitoquiz.domain.repository.QuizRepository
import com.example.hitoquiz.domain.usecases.GetQuizzesUsecases
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@InstallIn(SingletonComponent::class)
@Module
object DomainModule {


    @Provides
    @Singleton
    fun provideQuizUseCases(quizRepository: QuizRepository): GetQuizzesUsecases{

        return GetQuizzesUsecases(quizRepository)
    }
}