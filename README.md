# Penjelasan Mengenai Penggunaan LazyRow, NavigationBar, dan Font Family dalam Project Kotlin

## 1. **LazyRow**
LazyRow adalah komponen yang sangat berguna dalam Jetpack Compose, yang memungkinkan kita untuk membuat daftar horizontal dengan cara yang efisien. Dengan menggunakan LazyRow, hanya item yang terlihat di layar yang akan dimuat, sehingga dapat menghemat memori dan meningkatkan performa aplikasi, terutama ketika jumlah item di dalamnya sangat banyak.

### Cara Penggunaan LazyRow:
Untuk menggunakan LazyRow, kita cukup menggunakan komponen `LazyRow` di dalam layout kita, lalu menambahkan item-item yang ingin ditampilkan di dalamnya. Berikut adalah contoh penggunaannya:

```kotlin
LazyRow(
    modifier = Modifier.padding(16.dp)
) {
    items(20) { index ->
        Text(text = "Item $index")
    }
}

## 2. **NavigationBar**
NavigationBar memungkinkan kita untuk membuat bilah navigasi bawah (bottom navigation bar) dalam aplikasi mobile. Komponen ini membantu pengguna untuk berpindah antar halaman atau bagian di aplikasi dengan cepat.

Scaffold(
    bottomBar = {
        BottomNavigation {
            BottomNavigationItem(
                icon = { Icon(Icons.Default.Home, contentDescription = null) },
                selected = currentRoute == "home",
                onClick = { navController.navigate("home") }
            )
            BottomNavigationItem(
                icon = { Icon(Icons.Default.Favorite, contentDescription = null) },
                selected = currentRoute == "favorites",
                onClick = { navController.navigate("favorites") }
            )
        }
    }
) { innerPadding ->
    // Content goes here
}

