package com.ecomexpress.customerpanel.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ecomexpress.customerpanel.ui.theme.grey4F
import com.ecomexpress.customerpanel.ui.theme.white
import com.ecomexpress.customerpanel.utils.constants.bottomSheetHelp
import com.ecomexpress.customerpanel.utils.constants.bottomSheetHelpOne
import com.ecomexpress.customerpanel.utils.constants.bottomSheetHelpThree
import com.ecomexpress.customerpanel.utils.constants.bottomSheetHelpTwo

@Composable
fun ShowHelpBottomSheet() {
    Column(
        modifier = Modifier

            .fillMaxWidth()
            .wrapContentHeight()
            .background(
                color = white,
                shape = RoundedCornerShape(
                    topStart = 6.dp,
                    topEnd = 6.dp,
                    bottomEnd = 0.dp,
                    bottomStart = 0.dp
                )
            )
    ) {
        // Wrap the Column with a Box and specify a fixed width to limit the width of the bottom sheet


                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .padding(20.dp)
                        .fillMaxWidth()
                ) {
                    Text(
                        text ="Need Help",
                        style = bottomSheetHelp(grey4F),

                    )
                    Spacer(modifier = Modifier.width(6.dp))
                    // Row with Image and Main Text
                    Image(
                        painter = painterResource(id = com.ecomexpress.customerpanel.R.drawable.help_icon),
                        contentDescription = "Icon_top",
                        modifier = Modifier
                            .width(18.dp)
                            .height(18.dp)
                    )
                }

                // Row with Icon and Three Text Elements
                Row(
                    verticalAlignment = Alignment.Top,
                    modifier = Modifier.padding(start = 10.dp, top = 25.dp)

                ) {
                    Image(
                        painter = painterResource(id = com.ecomexpress.customerpanel.R.drawable.mobile_big),
                        contentDescription = "Icon",
                        modifier = Modifier
                            .height(55.dp)
                            .width(32.dp)
                            .padding(start = 10.dp, bottom = 10.dp)
                    )
                    Spacer(modifier = Modifier.width(25.dp))
                    Column{
                        Text(
                            text = "For Any Queries call us",
                            style = bottomSheetHelpThree
                        )
                        Spacer(modifier = Modifier.height(3.dp))
                        Text(
                            text = "+91-328378273",
                            style = bottomSheetHelpTwo
                        )
                        Spacer(modifier = Modifier.height(3.dp))
                        Text(
                            text = ("(8AM to 10PM)"),
                            style = bottomSheetHelpOne
                        )
                        Spacer(modifier = Modifier.height(32.dp))

                    }
                }

        }

}

@Preview
@Composable
fun showHelp(){
    ShowHelpBottomSheet()
}
