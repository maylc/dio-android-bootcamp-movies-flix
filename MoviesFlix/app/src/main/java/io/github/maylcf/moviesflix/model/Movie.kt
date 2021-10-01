package io.github.maylcf.moviesflix.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Movie(
    val id: Int,
    @SerializedName("titulo")
    val title: String,
    @SerializedName("imagem")
    val image: String?,
    @SerializedName("descricao")
    val description: String?,
    @SerializedName("data_lancamento")
    val releaseDate: String?
) : Parcelable