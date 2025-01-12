package com.example.noteapp.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Notifications
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.noteapp.R
import com.example.noteapp.components.NoteButton
import com.example.noteapp.components.NoteTextInput
import com.example.noteapp.components.SavedNote
import com.example.noteapp.model.Note
import java.time.LocalDateTime
import java.util.Date

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NoteScreen() {
    val title = remember { mutableStateOf("") }
    val description = remember { mutableStateOf("") }
    val notes = remember { mutableStateListOf<Note>() }

    Column(
        modifier = Modifier.padding(6.dp)
    ) {
        TopAppBar(
            title = { Text(text = stringResource(id = R.string.app_name)) },
            actions = {
                Icon(
                    imageVector = Icons.Rounded.Notifications,
                    contentDescription = "Icon"
                )
            },
            colors = TopAppBarDefaults.topAppBarColors(
                containerColor = Color(0xFF6B6969)
            )
        )
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            NoteTextInput(
                modifier = Modifier.padding(top = 9.dp, bottom = 8.dp),
                text = title.value,
                label = "Title",
                onTextChange = { it ->
                    if(it.all { char -> char.isLetter() || char.isWhitespace() }) title.value = it
                }
            )
            NoteTextInput(
                modifier = Modifier.padding(top = 9.dp, bottom = 8.dp),
                text = description.value,
                label = "Description",
                onTextChange = { it->
                    if(it.all { char -> char.isLetter() || char.isWhitespace() }) description.value = it
                }
            )
            NoteButton(
                text = "Save",
                OnClick = {
                    if (title.value.isNotEmpty() && description.value.isNotEmpty()) {
                        notes.add(Note(title = title.value, description = description.value))
                        title.value = ""
                        description.value = ""
                    }
                }
            )
            HorizontalDivider(modifier = Modifier.padding(10.dp))
            LazyColumn {
                items(notes) { note ->
                    SavedNote(
                        modifier = Modifier
                            .padding(4.dp),
                        title = note.title,
                        description = note.description,
                        entryDate = note.entryDate

                        )
                }
            }
        }
    }
}





@Preview
@Composable
fun NoteScreenPreview() {

}

//
//package com.example.noteapp.screen
//
//import androidx.compose.foundation.layout.Column
//import androidx.compose.foundation.layout.fillMaxSize
//import androidx.compose.foundation.layout.padding
//import androidx.compose.foundation.rememberScrollState
//import androidx.compose.foundation.verticalScroll
//import androidx.compose.material.icons.Icons
//import androidx.compose.material.icons.rounded.Notifications
//import androidx.compose.material3.ExperimentalMaterial3Api
//import androidx.compose.material3.HorizontalDivider
//import androidx.compose.material3.Icon
//import androidx.compose.material3.Text
//import androidx.compose.material3.TopAppBar
//import androidx.compose.material3.TopAppBarDefaults
//import androidx.compose.runtime.Composable
//import androidx.compose.runtime.mutableStateOf
//import androidx.compose.runtime.remember
//import androidx.compose.runtime.mutableStateListOf
//import androidx.compose.ui.Alignment
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.graphics.Color
//import androidx.compose.ui.res.stringResource
//import androidx.compose.ui.tooling.preview.Preview
//import androidx.compose.ui.unit.dp
//import com.example.noteapp.R
//import com.example.noteapp.components.NoteButton
//import com.example.noteapp.components.NoteTextInput
//import com.example.noteapp.components.SavedNote
//import com.example.noteapp.model.Note
//
//@OptIn(ExperimentalMaterial3Api::class)
//@Composable
//fun NoteScreen() {
//    val title = remember { mutableStateOf("") }
//    val description = remember { mutableStateOf("") }
//    val notes = remember { mutableStateListOf<Note>() }
//    val scrollState = rememberScrollState()
//
//    Column(
//        modifier = Modifier.padding(6.dp)
//    ) {
//        TopAppBar(
//            title = { Text(text = stringResource(id = R.string.app_name)) },
//            actions = {
//                Icon(
//                    imageVector = Icons.Rounded.Notifications,
//                    contentDescription = "Icon"
//                )
//            },
//            colors = TopAppBarDefaults.topAppBarColors(
//                containerColor = Color(0xFF6B6969)
//            )
//        )
//        Column(
//            modifier = Modifier
//                .fillMaxSize()
//                .verticalScroll(scrollState),
//            horizontalAlignment = Alignment.CenterHorizontally
//        ) {
//            NoteTextInput(
//                modifier = Modifier.padding(top = 9.dp, bottom = 8.dp),
//                text = title.value,
//                label = "Title",
//                onTextChange = { it ->
//                    if(it.all { char -> char.isLetter() || char.isWhitespace() }) title.value = it
//                }
//            )
//            NoteTextInput(
//                modifier = Modifier.padding(top = 9.dp, bottom = 8.dp),
//                text = description.value,
//                label = "Description",
//                onTextChange = { it->
//                    if(it.all { char -> char.isLetter() || char.isWhitespace() }) description.value = it
//                }
//            )
//            NoteButton(
//                text = "Save",
//                OnClick = {
//                    if (title.value.isNotEmpty() && description.value.isNotEmpty()) {
//                        notes.add(Note(title = title.value, description = description.value))
//                        title.value = ""
//                        description.value = ""
//                    }
//                }
//            )
//            HorizontalDivider(modifier = Modifier.padding(10.dp))
//
//            // Replace LazyColumn with Column for notes
//            notes.forEach { note ->
//                SavedNote(
//                    modifier = Modifier.padding(4.dp),
//                    title = note.title,
//                    description = note.description,
//                    entryDate = note.entryDate
//                )
//            }
//        }
//    }
//}
//
//@Preview
//@Composable
//fun NoteScreenPreview() {
//    NoteScreen()
//}