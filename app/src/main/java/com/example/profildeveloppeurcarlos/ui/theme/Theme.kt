package com.example.profildeveloppeurcarlos.ui.theme

import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext

// Thème sombre : fond Gunmetal, cartes légèrement plus claires que le fond,
// vert plus lumineux pour rester lisible sur fond sombre.
private val DarkColorScheme = darkColorScheme(
    primary = ForestGreenLight,
    onPrimary = GreenNight,
    primaryContainer = ForestGreenDark,
    onPrimaryContainer = White,
    secondary = DustGrey,
    onSecondary = Gunmetal,
    secondaryContainer = GunmetalLighter,
    onSecondaryContainer = SoftLinen,
    background = Gunmetal,
    onBackground = SoftLinen,
    surface = Gunmetal,
    onSurface = SoftLinen,
    surfaceVariant = GunmetalLight,
    onSurfaceVariant = DustGrey,
    surfaceContainerLowest = GunmetalDark,
    surfaceContainerLow = GunmetalLight,
    surfaceContainer = GunmetalLight,
    surfaceContainerHigh = GunmetalLight,
    surfaceContainerHighest = GunmetalLighter,
    outline = SlateLight,
    outlineVariant = GunmetalLighter
)

// Thème clair : fond DustGrey, cartes plus claires (SoftLinen) pour les détacher du fond.
private val LightColorScheme = lightColorScheme(
    primary = ForestGreen,
    onPrimary = White,
    primaryContainer = Gunmetal,
    onPrimaryContainer = SoftLinen,
    secondary = Gunmetal,
    onSecondary = SoftLinen,
    secondaryContainer = DustGrey,
    onSecondaryContainer = Gunmetal,
    background = DustGrey,
    onBackground = Gunmetal,
    surface = DustGrey,
    onSurface = Gunmetal,
    surfaceVariant = SoftLinen,
    onSurfaceVariant = Gunmetal,
    surfaceContainerLowest = White,
    surfaceContainerLow = LinenLight,
    surfaceContainer = LinenLight,
    surfaceContainerHigh = SoftLinen,
    surfaceContainerHighest = SoftLinen,
    outline = Slate,
    outlineVariant = DustGreyDark
)

@Composable
fun ProfilDeveloppeurCarlosTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    // Désactivé pour utiliser notre palette au lieu des couleurs du fond d'écran (Android 12+)
    dynamicColor: Boolean = false,
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }

        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        shapes = Shapes,
        content = content
    )
}
