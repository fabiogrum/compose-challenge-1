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
package com.example.androiddevchallenge.ui.detail

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.data.fakeAnimals
import com.example.androiddevchallenge.model.Animal
import com.example.androiddevchallenge.ui.theme.MyTheme

@Composable
fun AnimalDetailScreen(
    animals: List<Animal>,
    animalId: String,
    modifier: Modifier = Modifier
) {
    animals.find { animal -> animal.id == animalId }?.let {
        AnimalDetail(it, modifier)
    }
}

@Composable
fun AnimalDetail(animal: Animal, modifier: Modifier) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier.fillMaxWidth()
    ) {
        Image(
            painter = painterResource(animal.imageId),
            contentDescription = null,
            modifier = modifier.size(184.dp, 184.dp)
        )
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            animal.name,
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.h3
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            animal.description,
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.body1
        )
    }
}

@Composable
fun AnimalImage(@DrawableRes imageId: Int, modifier: Modifier = Modifier) {
    Image(
        painter = painterResource(imageId),
        contentDescription = null,
        modifier = modifier.size(80.dp, 80.dp)
    )
}

@Preview("Detail Light Theme", widthDp = 360, heightDp = 640)
@Composable
fun AnimalDetailScreenLightPreview() {
    MyTheme {
        AnimalDetailScreen(fakeAnimals, fakeAnimals.first().id)
    }
}

@Preview("Detail Dark Theme", widthDp = 360, heightDp = 640)
@Composable
fun AnimalDetailScreenDarkPreview() {
    MyTheme(darkTheme = true) {
        AnimalDetailScreen(fakeAnimals, fakeAnimals.first().id)
    }
}
