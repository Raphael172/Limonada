package com.example.limonada

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.limonada.ui.theme.LimonadaTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LimonadaTheme {
                AppLimonada()
            }
        }
    }
}
@Preview(showSystemUi = true)
@Composable
fun AppLimonada(){
    var tela by remember { mutableStateOf(1)}
    var IdImage = 1
    var IdTexto =1
    var OnClickImage = {}
    var QtdClick by remember { mutableStateOf(0)}

    when(tela){
        1 ->{
            IdImage = R.drawable.limoeiro
            IdTexto = R.string.limoeiro
            OnClickImage= {
                tela=2
                QtdClick = (2..4).random()
            }
        }
        2 ->{
            IdImage = R.drawable.limao
            IdTexto = R.string.limao
            OnClickImage= {
                if (QtdClick>0)
                    QtdClick--
                else
                    tela=3
            }
        }
        3 ->{
            IdImage = R.drawable.limonada
            IdTexto = R.string.limonada
            OnClickImage= {tela=4}
        }
        4 ->{
            IdImage = R.drawable.copo_vazio
            IdTexto = R.string.copo_vazio
            OnClickImage= {tela=1}
        }
    }
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize()
    ) {
        Image(
            painter = painterResource(id = IdImage),
            contentDescription =null,
            modifier = Modifier.clickable (onClick = OnClickImage)
        )
        Text(
            text = stringResource(IdTexto)
        )

    }
}
