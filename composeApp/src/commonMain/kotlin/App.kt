import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.koin.compose.KoinContext
import org.koin.compose.currentKoinScope
import org.koin.core.context.KoinContext

@Composable
@Preview
fun App() {
    MaterialTheme {


        KoinContext {

            val navController = rememberNavController()
            NavHost(navController, "screenA") {
                composable("screenA") {
                    val viewModel = koinViewModel<MainViewModel>()
                    val timer = viewModel.timer.collectAsState()
                    Box(
                        modifier = Modifier.fillMaxSize(),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(timer.value.toString())
                    }
                }
            }
        }

    }
}


@Composable

inline fun <reified T : ViewModel> koinViewModel(): T {
    val scope = currentKoinScope()

    return viewModel {
        scope.get<T>()
    }
}