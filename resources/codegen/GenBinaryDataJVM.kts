#!/usr/bin/kotlinc -script
/*
 * Copyright 2012-2018 Tobi29
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

val pkg = args[0]
val name = args[1]

var size = 0
val buffer = ByteArray(0x10000)
while (true) {
    val read = System.`in`.read(buffer)
    if (read < 0) break
    size += read
}

println(
    """/*
 * Copyright 2012-2018 Tobi29
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

// GENERATED FILE, DO NOT EDIT DIRECTLY!!!
// Generation script can be found in `resources/codegen/GenBinaryDataJVM.kts`.
// Run `resources/codegen/codegen.sh` to update sources.

package $pkg

internal actual val $name: ByteArray
    get() = ${name.capitalize()}::class.java.getResourceAsStream("$name").readBytes($size)

private class ${name.capitalize()}"""
)