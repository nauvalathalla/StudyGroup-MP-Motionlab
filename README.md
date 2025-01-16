# Navigation & Routing in Jetpack Compose

**Navigation** adalah proses berpindah dari satu layar (*composable*) ke layar lain di aplikasi. Jetpack Compose menyediakan library bernama **Navigation** untuk mempermudah implementasi navigasi. **Routing** mengacu pada pengelolaan jalur layar dan pengoperan data antar layar.

## Elemen Utama Navigation

### 1. NavHost
**NavHost** adalah komponen utama dalam Jetpack Compose yang mendefinisikan navigasi aplikasi. 
- **Fungsi utama**:
  - Menyediakan struktur navigasi aplikasi.
  - Mendefinisikan rute dan hubungan antar layar.
  - Mengelola navigasi antar layar.

#### Contoh Penggunaan:
```kotlin
NavHost(
    navController = navController,
    startDestination = "home"
) {
    composable("home") { HomeScreen() }
    composable("details") { DetailsScreen() }
}
```

---

### 2. NavController
**NavController** bertugas mengatur perpindahan antar layar (*composable*) di dalam aplikasi.
- **Fungsi utama**:
  - Mengontrol navigasi antar layar.
  - Menyimpan state *backstack* layar.
  - Memungkinkan navigasi dengan parameter.
  - Mengelola navigasi kembali (`popBackStack`).

#### Contoh Penggunaan:
```kotlin
val navController = rememberNavController()

Button(onClick = {
    navController.navigate("details")
}) {
    Text("Go to Details")
}
```

---

### 3. Composable
Setiap layar atau komponen dalam aplikasi didefinisikan dengan blok **composable** di dalam `NavHost`.
- **Fungsi utama**:
  - Mendefinisikan layar berdasarkan rute.
  - Menentukan data yang diterima melalui parameter (jika ada).

#### Contoh Penggunaan:
```kotlin
composable("details/{itemId}") { backStackEntry ->
    val itemId = backStackEntry.arguments?.getString("itemId")
    DetailsScreen(itemId = itemId)
}
```

---

### 4. NavBackStackEntry
**NavBackStackEntry** adalah representasi layar yang ada di *backstack* navigasi.
- **Fungsi utama**:
  - Menyimpan state dan argument layar yang aktif.
  - Mengakses argument yang dikirim melalui navigasi.

---

## Hierarki Navigation

### 1. Single Navigation Graph
Semua rute didefinisikan dalam satu `NavHost`. Cocok untuk aplikasi kecil hingga menengah.

### 2. Nested Navigation Graph
Navigasi dapat dibagi menjadi beberapa sub-graf untuk struktur yang lebih modular.

#### Contoh Penggunaan:
```kotlin
NavHost(navController, startDestination = "main") {
    navigation(startDestination = "home", route = "main") {
        composable("home") { HomeScreen() }
        composable("profile") { ProfileScreen() }
    }
}
```

### 3. Multiple Backstack Navigation
Setiap bagian aplikasi memiliki *backstack* sendiri, misalnya untuk *bottom navigation*.

---

## State Management

### Pendekatan:
1. **SavedStateHandle**: Menyimpan data di dalam *backstack* navigasi.
2. **ViewModel**: Mempertahankan state antar layar selama siklus hidup aktivitas.
3. **remember & rememberSaveable**:
   - `remember`: Menyimpan state selama composable tidak direkomposisi ulang.
   - `rememberSaveable`: Menyimpan state bahkan saat layar direkomposisi ulang (misalnya, rotasi perangkat).

#### Contoh Penggunaan ViewModel:
```kotlin
val viewModel: MyViewModel = viewModel()
val data by viewModel.data.observeAsState()

Text(text = data ?: "Loading...")
```

---

## Navigasi dengan Parameter

### Mengirim Data Antar Screen:
1. Mendefinisikan parameter di rute.
2. Mengakses parameter di layar tujuan.

#### Contoh Penggunaan:
```kotlin
// Navigasi dengan parameter
navController.navigate("details/$itemId")

// Mendefinisikan rute dengan parameter
composable("details/{itemId}") { backStackEntry ->
    val itemId = backStackEntry.arguments?.getString("itemId")
    DetailsScreen(itemId = itemId)
}
```

---

## Penutup

Jetpack Compose Navigation mempermudah pengelolaan navigasi dan state antar layar dengan berbagai fitur modular dan fleksibel. Dengan memahami elemen dan hierarki navigasi, Anda dapat membangun aplikasi yang responsif dan terstruktur dengan baik.
