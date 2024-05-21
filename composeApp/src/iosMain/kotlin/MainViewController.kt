import androidx.compose.ui.window.ComposeUIViewController

fun MainViewController() = ComposeUIViewController(
    configure = {


        KoinInit().init()
    },

    ) {


    App()


}