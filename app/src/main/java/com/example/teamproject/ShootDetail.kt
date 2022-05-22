package com.example.teamproject

data class ShootDetail(
    val assist: Boolean,
    val assistSpId: Int,
    val assistX: Double,
    val assistY: Double,
    val goalTime: Int,
    val hitPost: Boolean,
    val inPenalty: Boolean,
    val result: Int,
    val spGrade: Int,
    val spId: Int,
    val spIdType: Boolean,
    val spLevel: Int,
    val type: Int,
    val x: Double,
    val y: Double
)