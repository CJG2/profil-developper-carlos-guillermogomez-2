package com.example.profildeveloppeurcarlos

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import com.example.profildeveloppeurcarlos.data.carlosProfile
import com.example.profildeveloppeurcarlos.ui.screens.ProfileScreen
import com.example.profildeveloppeurcarlos.ui.theme.ProfilDeveloppeurCarlosTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ProfilDeveloppeurCarlosTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    ProfileScreen(
                        profile = carlosProfile,
                        onContactClick = {
                            // Plus tard : ouvrir l'application e-mail
                        },
                        onPortfolioClick = {
                            // Plus tard : ouvrir le portfolio dans le navigateur
                        },
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(innerPadding)
                    )
                }
            }
        }
    }
}
