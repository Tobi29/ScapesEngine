/*
 * Copyright 2012-2019 Tobi29
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.tobi29.io.tag

import org.spekframework.spek2.Spek
import org.spekframework.spek2.style.specification.describe
import org.tobi29.assertions.shouldEqual

object TagMapTests : Spek({
    describe("a tag map") {
        describe("remap") {
            val tagStructure = MutableTagMap {
                this["Replace"] = "Value".toTag()
                this["Keep"] = "Value".toTag()
                this["Get"] = TagMap {
                    this["Check"] = "Value".toTag()
                }
            }
            val testStructure = TagMap {
                this["Add"] = TagMap()
                this["Replace"] = TagMap()
                this["Keep"] = "Value".toTag()
                this["Get"] = TagMap {
                    this["Check"] = "Value".toTag()
                }
            }
            tagStructure.mapMut("Add")
            tagStructure.mapMut("Replace")
            tagStructure.mapMut("Get")
            it("should result in equal map") {
                tagStructure shouldEqual testStructure
            }
        }
        describe("inserting an array and retrieving it as a list") {
            val tagStructure = TagMap {
                this["Array"] = byteArrayOf(0, 1, 2, 3, 4).toTag()
            }
            it("should return an equal list") {
                tagStructure["Array"]?.toList() shouldEqual tagListOf(
                    0, 1,
                    2, 3, 4
                )
            }
        }
        describe("inserting a list and retrieving it as an array") {
            val tagStructure = TagMap {
                this["List"] = tagListOf(0, 1, 2, 3, 4)
            }
            it("should return an equal array") {
                tagStructure["List"]?.toByteArray() shouldEqual byteArrayOf(
                    0,
                    1, 2, 3, 4
                )
            }
        }
        describe("inserting an array into one tag map and an equal list into another") {
            val tagStructure1 = TagMap {
                this["Array"] = byteArrayOf(0, 1, 2, 3, 4).toTag()
                this["List"] = tagListOf(0, 1, 2, 3, 4)
            }
            val tagStructure2 = TagMap {
                this["List"] = byteArrayOf(0, 1, 2, 3, 4).toTag()
                this["Array"] = tagListOf(
                    0, 1, 2, 3,
                    4
                )
            }
            it("should make equal tag maps") {
                tagStructure2 shouldEqual tagStructure1
            }
        }
        val tagsEqual = listOf(
            Pair(TagMap {
                this["Data"] = byteArrayOf(1, 2, 3, 4).toTag()
            }, TagMap {
                this["Data"] = tagListOf(
                    1, 2, 3,
                    4
                )
            })
        )
        for ((first, second) in tagsEqual) {
            it("should equal") {
                first shouldEqual second
            }
            it("should give the same hash code") {
                first.hashCode() shouldEqual second.hashCode()
            }
        }
    }
})
