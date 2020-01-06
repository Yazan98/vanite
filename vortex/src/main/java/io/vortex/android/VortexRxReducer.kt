package io.vortex.android

import io.reactivex.disposables.Disposable
import io.vortex.android.rx.VortexRxRepository
import io.vortex.android.state.VortexState

/**
 * Created By : Yazan Tarifi
 * Date : 10/10/2019
 * Time : 3:47 AM
 */

interface VortexRxReducer<State : VortexState , Action: VortexAction> {

    suspend fun reduce(newAction: Action)

    suspend fun acceptInitialState(initialState: State)

    suspend fun acceptLoadingState(newState: Boolean)

    suspend fun addRxRequest(request: Disposable)

    suspend fun getInitialState(): State

    suspend fun acceptNewState(newState: State)

    suspend fun destroyReducer()

}
