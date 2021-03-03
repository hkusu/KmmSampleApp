package io.github.hkusu.kmmsampleapp.androidApp

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import io.github.hkusu.kmmsampleapp.shared.model.GetUserUseCase
import io.github.hkusu.kmmsampleapp.shared.model.User
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(getUser: GetUserUseCase) : ViewModel() {

    private val _userList: MutableLiveData<List<User>> = MutableLiveData()
    val userList = _userList as LiveData<List<User>>

    init {
        viewModelScope.launch {
            _userList.value = getUser()
        }
    }
}
