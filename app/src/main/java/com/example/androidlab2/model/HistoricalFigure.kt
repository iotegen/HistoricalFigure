package com.example.androidlab2.model

import com.google.gson.annotations.SerializedName

data class HistoricalFigure(
    @SerializedName("name")  val name: String?,
    @SerializedName("title") val title: String?,
    @SerializedName("info")  val info: Info
)

data class Info(
    @SerializedName("born")  val born: String?,
    @SerializedName("died")  val died: String?,
    @SerializedName("years")  val years: String?,
    @SerializedName("office")  val office: List<String>?,
    @SerializedName("parents")  val parents: List<String>?,
    @SerializedName("partners")  val partners: String?,
    @SerializedName("conflicts")  val conflicts: List<String>?,
    @SerializedName("resting_place")  val restingPlace: String?,
    @SerializedName("cause_of_death")  val causeOfDeath: String?,
    @SerializedName("years_active") val yearsActive: String,
    @SerializedName("region") val region :String
)
