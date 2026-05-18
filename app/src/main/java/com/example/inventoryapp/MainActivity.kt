package com.example.inventoryapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.*
import com.example.inventoryapp.ui.theme.InventoryAppTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            InventoryAppTheme {

                var screen by remember { mutableStateOf("dashboard") }

                // shared asset list
                var assetList by remember { mutableStateOf(listOf<Asset>()) }

                when (screen) {

                    "dashboard" -> DashboardScreen(
                        total = assetList.size,
                        working = assetList.count { it.status == "Working" },
                        repair = assetList.count { it.status == "Repair" },
                        broken = assetList.count { it.status == "Broken" },
                        onAddClick = { screen = "add" },
                        onListClick = { screen = "list" }
                    )

                    "add" -> AddAssetScreen(
                        onBack = { screen = "dashboard" },
                        onSave = { asset ->
                            assetList = assetList + asset
                            screen = "list"
                        }
                    )

                    "list" -> AssetListScreen(
                        assets = assetList,
                        onBack = { screen = "dashboard" }
                    )
                }
            }
        }
    }
}
