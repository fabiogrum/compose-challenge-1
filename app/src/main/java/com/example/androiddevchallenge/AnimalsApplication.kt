/*
 * Copyright 2021 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.androiddevchallenge

import androidx.compose.animation.Crossfade
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.example.androiddevchallenge.data.fakeAnimals
import com.example.androiddevchallenge.model.Animal
import com.example.androiddevchallenge.ui.detail.AnimalDetailScreen
import com.example.androiddevchallenge.ui.list.AnimalListScreen
import com.example.androiddevchallenge.ui.theme.MyTheme

@Composable
fun AnimalsApp(navigationViewModel: NavigationViewModel) {
    MyTheme {
        AppContent(fakeAnimals, navigationViewModel)
    }
}

@Composable
fun AppContent(animals: List<Animal>, navigationViewModel: NavigationViewModel) {
    Scaffold(
        topBar = {
            val title = stringResource(id = R.string.app_name)
            TopAppBar(
                title = { Text(text = title) }
            )
        },
        content = {
            val modifier = Modifier.padding(it)
            Crossfade(navigationViewModel.currentScreen) { screen ->
                when (screen) {
                    is Screen.List -> AnimalListScreen(
                        animals,
                        navigationViewModel::navigateTo,
                        modifier
                    )
                    is Screen.Detail -> AnimalDetailScreen(
                        animals = animals,
                        animalId = screen.animalId
                    )
                }
            }
        }
    )
}
