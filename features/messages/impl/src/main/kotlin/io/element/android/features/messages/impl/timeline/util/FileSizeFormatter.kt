/*
 * Copyright (c) 2023 New Vector Ltd
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

package io.element.android.features.messages.impl.timeline.util

import android.content.Context
import android.text.format.Formatter
import com.squareup.anvil.annotations.ContributesBinding
import io.element.android.libraries.di.AppScope
import io.element.android.libraries.di.ApplicationContext
import javax.inject.Inject

interface FileSizeFormatter {
    /**
     * Formats a content size to be in the form of bytes, kilobytes, megabytes, etc.
     */
    fun format(fileSize: Long): String
}

@ContributesBinding(AppScope::class)
class AndroidFileSizeFormatter @Inject constructor(@ApplicationContext private val context: Context) : FileSizeFormatter {
    override fun format(fileSize: Long): String {
        return Formatter.formatShortFileSize(context, fileSize)
    }
}