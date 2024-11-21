package com.example.ucp1

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.focusable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlin.math.round


@Composable
fun InputNameScreen(modifier: Modifier = Modifier) {
    var name by remember { mutableStateOf("") }
    var phoneNumber by remember { mutableStateOf("") }
    var selectedGender by remember { mutableStateOf("Male") }
    var snackbarVisible by remember { mutableStateOf(false) } // Track if Snackbar is visible
    var snackbarMessage by remember { mutableStateOf("") } // Track Snackbar message


    // BOX HEADER untuk logo dan text
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color(0xFF0D92F4))
            .padding(10.dp)
            .padding(top = 10.dp),
        // contentAlignment = Alignment.CenterStart
    )




    {
        Row(verticalAlignment = Alignment.CenterVertically) {


            Column {


                Text(
                    text = "Halo,",
                    fontWeight = FontWeight.Bold,
                    style = MaterialTheme.typography.titleMedium.copy(color = Color.White, fontSize = 40.sp),
                    modifier = Modifier
                        .padding(4.dp)
                        .padding(top = 50.dp)
                )

                Text(
                    text = name,
                )

            }


            Image(

                painter = painterResource(id = R.drawable.umy2),
                contentDescription = "Logo UMY",
                modifier = Modifier
                    .size(100.dp)
                    .padding(10.dp)

            )


        }
    }



    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp)
            .padding(top = 210.dp),
        // horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {



        Spacer(modifier = Modifier.height(10.dp))

        // Text Sub Judul
        Text(
            text = "Yuk lengkapi data dirimu!",
            fontWeight = FontWeight.Bold,
            style = MaterialTheme.typography.bodyLarge.copy(fontSize = 16.sp)


        )
        Spacer(modifier = Modifier.height(25.dp))

        // FORM INPUT
        // Input Nama
        TextField(
            value = name,
            onValueChange = { name = it },
            label = { Text("Masukkan Nama") },
            modifier = Modifier
                .fillMaxWidth()
                .border(
                    width = 1.dp,
                    color = if (name.isNotEmpty()) Color(0xFF4CAF50) else Color.Gray,
                    shape = MaterialTheme.shapes.medium
                )
                .focusable() // Add focusable modifier
        )
        Spacer(modifier = Modifier.height(16.dp))

        // Input No tel
        TextField(
            value = phoneNumber,
            onValueChange = { phoneNumber = it },
            label = { Text("Masukkan Nomor Telepon") },
            keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Phone),
            modifier = Modifier
                .fillMaxWidth()
                .border(
                    width = 1.dp,
                    color = if (phoneNumber.isNotEmpty()) Color(0xFF4CAF50) else Color.Gray,
                    shape = MaterialTheme.shapes.medium
                )
                .focusable()
        )
        Spacer(modifier = Modifier.height(16.dp))


        // Radio Buttons untuk memilih jenis kelamin
        Text("Jenis Kelamin:",
            style = MaterialTheme.typography.bodyMedium)




        Row(modifier = Modifier
            .fillMaxWidth(),




            horizontalArrangement = Arrangement.SpaceEvenly) {
            RadioButton(
                selected = selectedGender == "Male",
                onClick = { selectedGender = "Male" },
                colors = RadioButtonDefaults.colors(selectedColor = Color(0xFF0D92F4))
            )
            Text("Laki-laki")
            RadioButton(
                selected = selectedGender == "Female",
                onClick = { selectedGender = "Female" },
                colors = RadioButtonDefaults.colors(selectedColor = Color(0xFF0D92F4))
            )
            Text("Perempuan")
        }
        Spacer(modifier = Modifier.height(16.dp))

        // Buttons to save data and display data side by side
        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
            Button(
                onClick = {
                    // Check if all fields are filled
                    if (name.isNotEmpty() && phoneNumber.isNotEmpty() ) {
                        snackbarMessage = "Data berhasil disimpan!"
                        snackbarVisible = true
                    } else {
                        snackbarMessage = "Harap lengkapi semua data!"
                        snackbarVisible = true
                    }
                },
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF0D92F4)),
                modifier = Modifier.weight(1f)
            ) {
                Text("Simpan", color = Color.White)
            }

            Spacer(modifier = Modifier.width(8.dp))


        }

            Spacer(modifier = Modifier.height(16.dp))


        Box(

            modifier = Modifier
                .clip(RoundedCornerShape(25.dp))
                .fillMaxWidth()
                .background(Color(0xFF808080))
                .padding(5.dp),



            contentAlignment = Alignment.CenterStart

        ) {

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    //.background(Color(0xFF0D92F4))
                    .padding(10.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            )

            {


                    Text(
                        text = "Nomor Handphone",
                        // color = Color.White,

                        style = MaterialTheme.typography.titleMedium.copy(color = Color.Black, fontSize = 20.sp),
                        modifier = Modifier
                            .fillMaxWidth()
                            // .background(Color(0xFF0D92F4))
                            .padding(10.dp)
                            .weight(1f),
                    )

                    Text(
                        text = phoneNumber,
                        color = Color.White,
                        style = MaterialTheme.typography.titleMedium.copy(color = Color.White, fontSize = 20.sp),
                        modifier = Modifier
                            .fillMaxWidth()
                            .clip(RoundedCornerShape(10.dp))
                            .background(Color(0xFF0D92F4))
                            .padding(10.dp)
                            .weight(1f),

                    )



                Spacer(modifier = Modifier.height(10.dp))


                    Text(
                        text = "Jenis Kelamin",

                        // color = Color.White,

                        style = MaterialTheme.typography.titleMedium.copy(color = Color.Black, fontSize = 20.sp),
                        modifier = Modifier
                            .fillMaxWidth()

                            // .background(Color(0xFF0D92F4))
                            .padding(10.dp)
                            .weight(1f),

                    )

                    Text(
                        text = selectedGender,
                        color = Color.White,

                        style = MaterialTheme.typography.titleMedium.copy(color = Color.White, fontSize = 20.sp),
                        modifier = Modifier
                            .fillMaxWidth()
                            .clip(RoundedCornerShape(10.dp))
                            .background(Color(0xFF0D92F4))
                            .padding(10.dp)
                            .weight(1f),
                    )

            }
        }

        // Show Snackbar for notifications
        if (snackbarVisible) {
            Snackbar(
                modifier = Modifier.padding(16.dp),
                action = {
                    Button(
                        onClick = { snackbarVisible = false },
                        colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF4CAF50))
                    ) {
                        Text("Tutup", color = Color.White)
                    }
                }
            ) {
                Text(text = snackbarMessage)
            }
        }
    }
}


















@Preview(showBackground = true)
@Composable
fun PreviewInputNameScreen() {
    InputNameScreen()
}
