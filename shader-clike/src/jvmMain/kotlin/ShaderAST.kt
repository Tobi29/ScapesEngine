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

package org.tobi29.scapes.engine.shader

import org.antlr.v4.runtime.ParserRuleContext
import org.antlr.v4.runtime.Token
import org.antlr.v4.runtime.tree.TerminalNode

fun <E : Expression> E.attach(context: ParserRuleContext): E = apply {
    attach(context.start)
}

fun <E : Expression> E.attach(context: TerminalNode): E = apply {
    attach(context.symbol)
}

fun <E : Expression> E.attach(token: Token): E = apply {
    location = SourceLocation(token.line, token.charPositionInLine)
}

inline fun <E : Expression> ParserRuleContext.parse(
    crossinline block: ParserRuleContext.() -> E
): E = block().attach(this)

inline fun <E : Expression> TerminalNode.parse(
    crossinline block: TerminalNode.() -> E
): E = block().attach(this)

inline fun <E : Expression> Token.parse(
    crossinline block: Token.() -> E
): E = block().attach(this)
