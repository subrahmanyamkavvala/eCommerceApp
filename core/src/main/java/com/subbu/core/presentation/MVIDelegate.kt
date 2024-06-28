package com.subbu.core.presentation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.repeatOnLifecycle
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import kotlin.coroutines.CoroutineContext
import kotlin.coroutines.EmptyCoroutineContext

class MVIDelegate<UiState, UiAction, SideEffect> internal constructor(
    initialUiState: UiState,
) : MVI<UiState, UiAction, SideEffect> {

    private val _uiState = MutableStateFlow(initialUiState)
    override val uiState: StateFlow<UiState> = _uiState.asStateFlow()

    private val _sideEffect by lazy { Channel<SideEffect>(100)}
    override val sideEffect: Flow<SideEffect> by lazy { _sideEffect.receiveAsFlow() }

    override fun onAction(uiAction: UiAction) {}

    override fun updateUiState(newUiState: UiState) {
        _uiState.update { newUiState }
    }

    override fun updateUiState(block: UiState.() -> UiState) {
        _uiState.update(block)
    }

    override fun CoroutineScope.emitSideEffect(effect: SideEffect) {
        this.launch{ _sideEffect.send(effect) }
    }
}

fun <UiState, UiAction, SideEffect> mvi(
    initialUiState: UiState,
): MVI<UiState, UiAction, SideEffect> = MVIDelegate(initialUiState)