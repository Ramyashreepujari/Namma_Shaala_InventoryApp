package com.example.inventoryapp

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun DashboardScreen(
    total: Int,
    working: Int,
    repair: Int,
    broken: Int,
    onAddClick: () -> Unit,
    onListClick: () -> Unit
) {

    Column(modifier = Modifier.padding(16.dp)) {

        Text(
            text = "📊 Inventory Dashboard",
            style = MaterialTheme.typography.headlineMedium
        )

        Spacer(modifier = Modifier.height(20.dp))

        Row {
            Card(
                modifier = Modifier.weight(1f),
                colors = CardDefaults.cardColors(containerColor = Color(0xFFE3F2FD))
            ) {
                Text("📦 $total\nAssets", modifier = Modifier.padding(16.dp))
            }

            Spacer(modifier = Modifier.width(10.dp))

            Card(
                modifier = Modifier.weight(1f),
                colors = CardDefaults.cardColors(containerColor = Color(0xFFFFF3E0))
            ) {
                Text("🛠 $repair\nRepair", modifier = Modifier.padding(16.dp))
            }
        }

        Spacer(modifier = Modifier.height(10.dp))

        Card(
            modifier = Modifier.fillMaxWidth(),
            colors = CardDefaults.cardColors(containerColor = Color(0xFFE8F5E9))
        ) {
            Text("✅ $working Working", modifier = Modifier.padding(16.dp))
        }

        Spacer(modifier = Modifier.height(20.dp))

        Card(
            modifier = Modifier.fillMaxWidth(),
            colors = CardDefaults.cardColors(containerColor = Color(0xFFFFEBEE))
        ) {
            Text(
                text = "❌ $broken Broken",
                modifier = Modifier.padding(16.dp)
            )
        }

        Spacer(modifier = Modifier.height(20.dp))

        Button(
            onClick = onAddClick,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("➕ Add Asset")
        }

        Spacer(modifier = Modifier.height(10.dp))

        OutlinedButton(
            onClick = onListClick,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("📋 View Assets")
        }
    }
}