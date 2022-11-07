package com.example.aulateste

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.aulateste.ui.theme.AulaTesteTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MessageCard(Message("Android" , "Jetpack Compose")) //metódo para exibir as mensagens que vão ser exibidas
        }
    }
}

data class Message(val author: String, val body: String)

@Composable //anotação que permite que funções compostas sejam criadas
fun MessageCard(msg: Message) { //função criada para a visualização da função "MessageCard"

    Row(modifier = Modifier.padding(all = 8.dp)) {
        Image(
            painter = painterResource(R.drawable.profile_picture),
            contentDescription = "Contact profile picture",
            modifier = Modifier
                .size(40.dp)
                .clip(CircleShape)
        )
        Spacer(modifier = Modifier.height(4.dp)) //função de outra biblioteca que serve para modificar as dimensões da imagem


        //função para deixar os elementos na verticl, em colunas
        Column {
            Text(text = msg.author)
            Text(text = msg.body)
        }
    }
}
@Preview //anotação que permite a visualização das funções de composição, sem a necessidade de usar emuladores
@Composable //anotação que permite que funções compostas sejam criadas
fun PreviewMessageCard() { //função criada para a visualização da função "MessageCard"
    MessageCard(
        msg = Message("Colleague", "Hey, take a look at Jetpack Compose, it's great!")
    )
}