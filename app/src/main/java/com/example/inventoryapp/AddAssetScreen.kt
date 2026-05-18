package com.example.inventoryapp

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun AddAssetScreen(
    onBack: () -> Unit,
    onSave: (Asset) -> Unit
) {

    var name by remember { mutableStateOf("") }
    var serial by remember { mutableStateOf("") }
    var status by remember { mutableStateOf("Working") }

    Column(modifier = Modifier.padding(16.dp)) {

        Text("➕ Add Asset", style = MaterialTheme.typography.headlineMedium)

        Spacer(modifier = Modifier.height(20.dp))

        OutlinedTextField(
            value = name,
            onValueChange = { name = it },
            label = { Text("Asset Name") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(10.dp))

        OutlinedTextField(
            value = serial,
            onValueChange = { serial = it },
            label = { Text("Serial Number") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(20.dp))

        Text("Select Condition")

        Row {
            FilterChip(
                selected = status == "Working",
                onClick = { status = "Working" },
                label = { Text("✅") }
            )
            Spacer(modifier = Modifier.width(8.dp))

            FilterChip(
                selected = status == "Repair",
                onClick = { status = "Repair" },
                label = { Text("🛠") }
            )
            Spacer(modifier = Modifier.width(8.dp))

            FilterChip(
                selected = status == "Broken",
                onClick = { status = "Broken" },
                label = { Text("❌") }
            )
        }

        Spacer(modifier = Modifier.height(20.dp))

        Button(
            onClick = {
                onSave(Asset(name, serial, status))
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Save Asset")
        }

        Spacer(modifier = Modifier.height(10.dp))

        TextButton(onClick = onBack) {
            Text("⬅ Back")
        }
    }
}