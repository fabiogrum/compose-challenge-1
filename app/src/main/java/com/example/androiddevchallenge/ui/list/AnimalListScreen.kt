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
package com.example.androiddevchallenge.ui.list

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.Screen
import com.example.androiddevchallenge.data.fakeAnimals
import com.example.androiddevchallenge.model.Animal
import com.example.androiddevchallenge.ui.theme.MyTheme

@Composable
fun AnimalListScreen(
    animals: List<Animal>,
    navigateTo: (Screen) -> Unit,
    modifier: Modifier = Modifier
) {
    AnimalList(animals, navigateTo, modifier)
}

@Composable
fun AnimalList(animals: List<Animal>, navigateTo: (Screen) -> Unit, modifier: Modifier = Modifier) {
    LazyColumn(modifier = modifier) {
        for (animal in animals) {
            item {
                AnimalItem(
                    animal,
                    navigateTo,
                    Modifier
                        .fillMaxWidth()
                        .padding(8.dp)
                )
            }
        }
    }
}

@Composable
fun AnimalItem(animal: Animal, navigateTo: (Screen) -> Unit, modifier: Modifier = Modifier) {
    Card(modifier, elevation = 8.dp) {
        Row(
            modifier = Modifier
                .clickable { navigateTo(Screen.Detail(animal.id)) }
                .padding(8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            AnimalImage(animal.imageId)
            Spacer(modifier = Modifier.width(16.dp))
            AnimalText(animal.name)
        }
    }
}

@Composable
fun AnimalImage(@DrawableRes imageId: Int, modifier: Modifier = Modifier) {
    Image(
        painter = painterResource(imageId),
        contentDescription = null,
        contentScale = ContentScale.Crop,
        modifier = modifier
            .clip(RoundedCornerShape(8.dp))
            .size(80.dp, 80.dp)
    )
}

@Composable
fun AnimalText(text: String, modifier: Modifier = Modifier) {
    Text(text, modifier = modifier, style = MaterialTheme.typography.subtitle1)
}

@Preview("List Light Theme", widthDp = 360, heightDp = 640)
@Composable
fun AnimalListScreenLightPreview() {
    MyTheme {
        AnimalListScreen(fakeAnimals, {})
    }
}

@Preview("List Dark Theme", widthDp = 360, heightDp = 640)
@Composable
fun AnimalListScreenDarkPreview() {
    MyTheme(darkTheme = true) {
        AnimalListScreen(fakeAnimals, {})
    }
}
