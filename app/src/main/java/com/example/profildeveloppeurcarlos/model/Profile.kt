package com.example.profildeveloppeurcarlos.model

// Toutes les informations affichées sur l'écran de profil.
data class Profile(
    val name: String,
    val role: String,
    val description: String,
    val email: String,
    val location: String,
    val isAvailable: Boolean,
    val skills: List<String>,
    val projects: List<Project>
)
