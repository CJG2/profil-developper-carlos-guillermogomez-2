package com.example.profildeveloppeurcarlos.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.profildeveloppeurcarlos.R
import com.example.profildeveloppeurcarlos.ui.theme.ProfilDeveloppeurCarlosTheme

// Box : l'image de l'avatar en fond, et un badge de disponibilité superposé en bas à droite.
@Composable
fun ProfileAvatar(
    name: String,
    isAvailable: Boolean,
    modifier: Modifier = Modifier,
    size: Dp = 112.dp,
    // Couleur de l'anneau autour du badge : celle du fond sur lequel l'avatar est posé.
    badgeBorderColor: Color = MaterialTheme.colorScheme.surface
) {
    Box(modifier = modifier.size(size)) {
        Image(
            painter = painterResource(R.drawable.avatar_placeholder),
            contentDescription = "Avatar de $name",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxSize()
                .clip(CircleShape)
        )
        // Pastille décorative : la disponibilité est aussi écrite en texte dans la section contact.
        Box(
            modifier = Modifier
                .align(Alignment.BottomEnd)
                .padding(4.dp)
                .size(size / 4)
                .clip(CircleShape)
                .background(badgeBorderColor)
                .padding(4.dp)
                .clip(CircleShape)
                .background(
                    if (isAvailable) {
                        MaterialTheme.colorScheme.primary
                    } else {
                        MaterialTheme.colorScheme.error
                    }
                )
        )
    }
}

// Les deux états côte à côte : disponible (pastille verte) et non disponible (pastille rouge).
@Preview(showBackground = true)
@Composable
fun ProfileAvatarPreview() {
    ProfilDeveloppeurCarlosTheme {
        Row(
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            modifier = Modifier.padding(16.dp)
        ) {
            ProfileAvatar(name = "Carlos Guillermo Gómez", isAvailable = true)
            ProfileAvatar(name = "Thomas Durand", isAvailable = false)
        }
    }
}
