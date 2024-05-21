import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class MainViewModel(private val start: Int) : ViewModel() {

    private val _timer = MutableStateFlow(start)
    val timer = _timer.asStateFlow()


    init {
        startTimer()
    }

    fun startTimer() {
        viewModelScope.launch {
            while (true) {
                delay(1000)
                _timer.update { it + 1 }
            }
        }
    }
}