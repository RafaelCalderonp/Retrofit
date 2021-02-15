package com.example.retrofit.model.local

import androidx.room.Entity
import androidx.room.PrimaryKey
import org.jetbrains.annotations.NotNull

@Entity(tableName = "mars_table")
data class MarsEntity (
        @PrimaryKey
        @NotNull
        val id: String,
        val price: Long,
        val type: String,
        val imgSrc: String)
