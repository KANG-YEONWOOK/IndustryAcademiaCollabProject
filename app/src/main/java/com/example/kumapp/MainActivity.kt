package com.example.kumapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.example.kumapp.component.MainScreen
import com.example.kumapp.ui.theme.KumAppTheme

class MainActivity : ComponentActivity() {

    private val viewModel by viewModels<MainActivityViewModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            KumAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val navController = rememberNavController()
                    MainScreen(navController = navController, viewModel)
                }
            }
        }
    }

//    private fun getLocationPermission(){
//        if(ContextCompat.checkSelfPermission(this.applicationContext, Manifest.permission.ACCESS_FINE_LOCATION)== PackageManager.PERMISSION_GRANTED){
//            viewModel.permissionGrant(true)
//            getDeviceLocation()
//        }else{
//            Log.d("execption","permission not granted")
//        }
//    }
//
//    private fun getDeviceLocation(){
//        val fusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(this)
//
//        try{
//            if(viewModel.locationPermissionGranted.value ==true){
//                val locationResult = fusedLocationProviderClient.lastLocation
//
//                locationResult.addOnCompleteListener{task ->
//                    if(task.isSuccessful){
//                        val lastKnownLocation = task.result
//
//                        if(lastKnownLocation != null){
//                            viewModel.currentUserGeoCDord(
//                                LatLng(lastKnownLocation.latitude,lastKnownLocation.longitude)
//                            )
//                        }
//                    }
//
//                }
//            }
//        }catch(e: SecurityException){
//            e.printStackTrace()
//        }
//    }

}