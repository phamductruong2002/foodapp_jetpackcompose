package com.example.foodapp.Activity.Dashboard

import android.R.attr.onClick
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.BottomAppBar
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.foodapp.R

@Composable
@Preview
fun MyBottombar() {
    val bottomMenuItemList = prepareBottomMenu()
    val context = LocalContext.current
    val selectedItem by remember { mutableStateOf("Home") }
//    BottomAppBar(backgroundColor = colorResource(R.color.white), elevation = 3.dp) {
//        bottomMenuItemList.forEach { bottomMenuItem ->
//            BottomNavigationItem(
//                selected = (selectedItem == bottomMenuItem.label),
//                onClick = {},
//                icon = {
//                    Icon(
//                        painter = bottomMenuItem.icon,
//                        contentDescription = null,
//                        modifier = Modifier
//                            .padding(top = 8.dp)
//                            .size(20.dp)
//                    )
//                })
//        }
//    }

    NavigationBar(
        containerColor = colorResource(R.color.white),
        tonalElevation = 3.dp,

        ) {
        bottomMenuItemList.forEach { bottomMenuItem ->
            val isSelected = selectedItem == bottomMenuItem.label
            NavigationBarItem(
                selected = isSelected,
                onClick = {  },
                icon = {
                    Icon(
                        painter = bottomMenuItem.icon,
                        contentDescription = null,
                        modifier = Modifier
                            .padding(top = 8.dp)
                            .size(20.dp)
                    )
                },
                colors = NavigationBarItemDefaults.colors(indicatorColor = Color.Transparent, selectedIconColor = colorResource(R.color.black), unselectedIconColor = colorResource(R.color.grey))
            )

        }
    }
}

data class BottomMenuItem(
    val label: String, val icon: Painter
)

@Composable
fun prepareBottomMenu(): List<BottomMenuItem> {
    val bottomMenuItemList = arrayListOf<BottomMenuItem>()
    bottomMenuItemList.add(BottomMenuItem(label = "Home", icon = painterResource(R.drawable.btn_1)))
    bottomMenuItemList.add(BottomMenuItem(label = "Cart", icon = painterResource(R.drawable.btn_2)))
    bottomMenuItemList.add(
        BottomMenuItem(
            label = "Favorite", icon = painterResource(R.drawable.btn_3)
        )
    )
    bottomMenuItemList.add(
        BottomMenuItem(
            label = "Order", icon = painterResource(R.drawable.btn_4)
        )
    )
    bottomMenuItemList.add(
        BottomMenuItem(
            label = "Profile", icon = painterResource(R.drawable.btn_5)
        )
    )
    return bottomMenuItemList
}