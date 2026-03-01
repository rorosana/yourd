package com.rosana.yourdead.di

import android.content.Context
import androidx.room.Room
import com.rosana.yourdead.data.local.TaskDao
import com.rosana.yourdead.data.local.TaskDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton
import com.rosana.yourdead.data.repository.TaskRepositoryImpl
import com.rosana.yourdead.domain.repository.TaskRepository

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    private const val DB_NAME = "yourdead_db"

    @Provides
    @Singleton
    fun provideTaskDatabase(
        @ApplicationContext context: Context
    ): TaskDatabase {
        return Room.databaseBuilder(
            context,
            TaskDatabase::class.java,
            DB_NAME
        )
            .fallbackToDestructiveMigration()
            .build()
    }

    @Provides
    fun provideTaskDao(db: TaskDatabase): TaskDao = db.taskDao()

    @Provides
    @Singleton
    fun provideTaskRepository(dao: TaskDao): TaskRepository {
        return TaskRepositoryImpl(dao)
    }

}
