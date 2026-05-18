package com.example.inventoryapp

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

data class Asset(
    val name: String,
    val serial: String,
    val status: String
)


@Composable
fun AssetListScreen(
    assets: List<Asset>,
    onBack: () -> Unit
) {

    Column(modifier = Modifier.padding(16.dp)) {

        Text("📋 Asset List", style = MaterialTheme.typography.headlineMedium)

        Spacer(modifier = Modifier.height(20.dp))

        if (assets.isEmpty()) {
            Text("No assets added yet")
        } else {
            LazyColumn {
                items(assets) { asset ->

                    val color = when (asset.status) {
                        "Working" -> Color(0xFF4CAF50)
                        "Repair" -> Color(0xFFFF9800)
                        else -> Color(0xFFF44336)
                    }

                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(bottom = 10.dp),
                        elevation = CardDefaults.cardElevation(6.dp)
                    ) {
                        Column(modifier = Modifier.padding(16.dp)) {

                            Text("📦 ${asset.name}",
                                style = MaterialTheme.typography.titleMedium)

                            Text("🔢 ${asset.serial}")

                            Text(
                                text = "Status: ${asset.status}",
                                color = color
                            )
                        }
                    }
                }
            }
        }

        Spacer(modifier = Modifier.height(10.dp))

        TextButton(onClick = onBack) {
            Text("⬅ Back")
        }
    }
}