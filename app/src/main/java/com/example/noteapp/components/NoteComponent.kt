package com.example.noteapp.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.Surface
import androidx.compose.ui.Alignment
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp
import java.time.LocalDateTime
import java.util.Date

@Composable
fun NoteTextInput(
    modifier: Modifier = Modifier,
    text: String,
    label: String,
    maxLine: Int = 1,
    onTextChange: (String) -> Unit,
    onImeAction: () -> Unit = {}
) {
    val keyboardController = LocalSoftwareKeyboardController.current
    OutlinedTextField(
        value = text,
        onValueChange = onTextChange,
        label = { Text(text = label) },
        maxLines = maxLine,
        keyboardOptions = KeyboardOptions.Default.copy(
            imeAction = ImeAction.Done
        ),
        keyboardActions = KeyboardActions(
            onDone = {
                onImeAction()
                keyboardController?.hide()
            }
        ),
        modifier = modifier
    )
}


@Composable
fun NoteButton(
    modifier: Modifier = Modifier,
    text: String,
    OnClick: () -> Unit,
    enabled: Boolean = true
){
    Button(
        onClick = OnClick,
        enabled = enabled,
        modifier = modifier,
        shape = CircleShape
        ) {
        Text(text = text)
    }
}

@Composable
fun SavedNote(
    modifier: Modifier = Modifier,
    title: String,
    description: String,
    entryDate: LocalDateTime
){

    Surface(modifier = modifier
        .wrapContentSize()
        .padding(4.dp)
        .clip(RoundedCornerShape(topEnd = 33.dp, bottomStart = 33.dp)),
        color = Color(0xFF03A9F4),
        shadowElevation = 6.dp

    ) {
        Column(
            modifier = Modifier.padding(horizontal = 14.dp, vertical = 6.dp),
            horizontalAlignment = Alignment.Start
        ) {

            Text(text = title, color = Color.White)
            Text(text = description, color = Color.White)
            Text(text = entryDate.toString(), color = Color.White)

        }
    }
}