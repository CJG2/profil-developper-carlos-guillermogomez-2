package com.example.profildeveloppeurcarlos.model

// Un projet ou une expérience affiché dans la liste du profil.
data class Project(
    val title: String,
    val description: String,
    val technologies: List<String>,
    val year: String
)
