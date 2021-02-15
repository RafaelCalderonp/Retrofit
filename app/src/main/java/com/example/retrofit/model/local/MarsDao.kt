package com.example.retrofit.model.local

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.retrofit.model.local.MarsEntity
import com.example.retrofit.model.remote.MarsEstate

@Dao
interface MarsDao {

    // Inserta un terreno
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertLand(land : MarsEntity)

    // Inserta un listado de terrenos
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAllLand(listLand: List<MarsEntity>)

    //Actualizar un terreno
    @Update
    suspend fun updateLand(land: MarsEntity)

    //Borrar un terreno
    @Delete
    suspend fun deleteLand(land: MarsEntity)

    // Borra todos los elementos de la tabla
    @Query("DELETE FROM mars_table")
    suspend fun deleteAll()

    // Traer todos los elementos de la tabla (LEER)
    @Query("SELECT * FROM mars_table ORDER BY id DESC")
    fun getAllLand() : LiveData<List<MarsEntity>>

    //Trae un terreno por ID
    @Query("SELECT * FROM mars_table WHERE id = :id")
    fun getLandByID(id: Int) : LiveData<MarsEntity>

}
