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
package com.example.androiddevchallenge.data

import com.example.androiddevchallenge.R
import com.example.androiddevchallenge.model.Animal

val fakeAnimals = listOf(
    Animal(
        "1",
        "Lassie",
        "Lassie has appeared in novels, movies, TV shows, and video games over the years, always as a heroic rough collie.",
        R.drawable.lassie
    ),
    Animal(
        "2",
        "Scooby-Doo",
        "Just the thought of Scooby-Doo is enough to get theme song stuck in our heads.",
        R.drawable.scoobydoo
    ),
    Animal(
        "3",
        "Lady and the Tramp",
        "The spaghetti kiss from \"Lady and the Tramp\" will forever live on in movie history as one of the best kisses ever, animal or otherwise.",
        R.drawable.ladyandthetramp
    ),
    Animal("4", "Snoopy", "Snoopy is arguably the best member of the Peanuts.", R.drawable.snoopy),
    Animal(
        "5",
        "Rin Tin Tin",
        "Rin Tin Tin was a silent film star that appeared in 27 movies.",
        R.drawable.rintintin
    ),
    Animal(
        "6",
        "Santa's Little Helper",
        "Santa's Little Helper was introduced on the very first episode of \"The Simpsons\" when he's adopted by Homer and Bart.",
        R.drawable.santaslittlehelper
    ),
    Animal("7", "Doge", ";)", R.drawable.doge)
)
