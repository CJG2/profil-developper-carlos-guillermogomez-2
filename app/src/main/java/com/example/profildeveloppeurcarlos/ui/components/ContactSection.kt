package com.example.profildeveloppeurcarlos.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.profildeveloppeurcarlos.data.thomasProfile
import com.example.profildeveloppeurcarlos.ui.theme.ProfilDeveloppeurCarlosTheme

// Carte de contact : les informations sont présentées dans des champs en lecture seule.
@Composable
fun ContactSection(
    email: String,
    location: String,
    isAvailable: Boolean,
    modifier: Modifier = Modifier
) {
    Card(
        shape = MaterialTheme.shapes.medium,
        modifier = modifier
    ) {
        Column(
            verticalArrangement = Arrangement.spacedBy(12.dp),
            modifier = Modifier.padding(16.dp)
        ) {
            ContactField(
                label = "E-mail",
                value = email,
                icon = Icons.Filled.Email
            )
            ContactField(
                label = "Localisation",
                value = location,
                icon = Icons.Filled.LocationOn
            )
            ContactField(
                label = "Disponibilité",
                value = if (isAvailable) {
                    "Disponible pour de nouveaux projets"
                } else {
                    "Non disponible actuellement"
                },
                icon = if (isAvailable) Icons.Filled.CheckCircle else Icons.Filled.Info
            )
        }
    }
}

// readOnly = true : le champ s'affiche comme un formulaire mais ne peut pas être modifié,
// donc onValueChange n'a rien à faire.
@Composable
fun ContactField(
    label: String,
    value: String,
    icon: ImageVector,
    modifier: Modifier = Modifier
) {
    OutlinedTextField(
        value = value,
        onValueChange = {},
        readOnly = true,
        singleLine = true,
        label = { Text(text = label) },
        leadingIcon = {
            Icon(imageVector = icon, contentDescription = null)
        },
        modifier = modifier.fillMaxWidth()
    )
}

@Preview(showBackground = true)
@Composable
fun ContactSectionPreview() {
    ProfilDeveloppeurCarlosTheme {
        ContactSection(
            email = thomasProfile.email,
            location = thomasProfile.location,
            isAvailable = thomasProfile.isAvailable,
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        )
    }
}
