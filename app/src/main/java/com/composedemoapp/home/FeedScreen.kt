package com.composedemoapp.home

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.sizeIn
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.rememberScaffoldState
import androidx.compose.material3.Button
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.composedemoapp.R
import com.composedemoapp.drawer.ComposeDemoDrawer
import kotlinx.coroutines.launch

@Composable
fun FeedScreen(
    modifier: Modifier = Modifier,
) {
    val scaffoldState = rememberScaffoldState()
    Scaffold(
        modifier = Modifier.statusBarsPadding(),
        scaffoldState = scaffoldState,
        drawerContent = {
            ComposeDemoDrawer()
        }
    ) { paddingValues ->
        val scope = rememberCoroutineScope()
        FeedContent(
            modifier.padding(paddingValues),
            openDrawer = {
                scope.launch {
                    scaffoldState.drawerState.open()
                }

            }
        )
    }

}

@OptIn(ExperimentalMaterial3Api::class, ExperimentalMaterialApi::class)
@Composable
fun FeedContent(
    modifier: Modifier = Modifier,
    openDrawer: () -> Unit
) {
    Column {
        FeedTabBar(
            modifier = modifier
                .wrapContentWidth()
                .sizeIn(maxWidth = 500.dp),
            onMenuClicked = openDrawer
        )
        Text(
            text = "Welcome, Jessie.",
            style = TextStyle(
                fontSize = 34.sp,
                fontFamily = FontFamily.SansSerif,
                fontWeight = FontWeight(700),
                color = Color(0xFF000000),
            ),
            modifier = modifier
                .padding(
                    start = 30.dp,
                    top = 18.dp
                )
                .fillMaxWidth()
        )

        GradientElevatedCard()
        BestPlanHeaderSection()
        BestPlanList()

    }
}


@Composable
fun FeedTabBar(
    modifier: Modifier = Modifier,
    onMenuClicked: () -> Unit
) {
    Row {
        Row(
            Modifier
                .padding(top = 8.dp)
        ) {
            Image(
                modifier = Modifier
                    .padding(start = 30.dp, top = 8.dp)
                    .size(30.dp)
                    .clickable(onClick = onMenuClicked),
                painter = painterResource(id = R.drawable.ic_menu),
                contentDescription = stringResource(id = R.string.cd_menu),
            )
        }

        Row(
            Modifier
                .padding(top = 8.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.End
        ) {
            Image(
                modifier = Modifier
                    .padding(end = 12.dp, top = 10.dp),
                painter = painterResource(id = R.drawable.ic_notification),
                contentDescription = null
            )
        }
    }

}

@Composable
fun GradientElevatedCard() {
    val gradient =
        Brush.horizontalGradient(listOf(Color(0xFF31A078), Color(0xFF31A05F)))
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(30.dp)
            .height(125.dp),
        elevation = 20.dp,
        shape = RoundedCornerShape(20.dp)
    ) {
        // Content inside the card
        // You can put any content here
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(gradient)
        ) {
            Column(
                modifier = Modifier
                    .padding(start = 30.dp, top = 30.dp)
                    .fillMaxWidth()
            ) {
                Text(
                    text = "Your total asset portfolio",
                    style = TextStyle(
                        fontSize = 16.sp,
                        fontFamily = FontFamily.SansSerif,
                        fontWeight = FontWeight(500),
                        color = Color(0xFFFFFFFF),
                    )
                )
                Row(
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(
                        modifier = Modifier.padding(top = 11.dp),
                        text = "N203,935",
                        style = TextStyle(
                            fontSize = 32.sp,
                            fontFamily = FontFamily.SansSerif,
                            fontWeight = FontWeight(600),
                            color = Color(0xFFFFFFFF),

                            )
                    )

                    Column(
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Button(
                            onClick = { },
                            modifier = Modifier
                                .padding(top = 11.dp, end = 10.dp)
                                .align(Alignment.End),
                            shape = RoundedCornerShape(30),
                            colors = androidx.compose.material3.ButtonDefaults.buttonColors(
                                containerColor = colorResource(id = R.color.white)
                            ),
                        ) {
                            Text(
                                text = "Invest now",
                                style = TextStyle(
                                    fontSize = 14.sp,
                                    fontFamily = FontFamily.SansSerif,
                                    fontWeight = FontWeight(600),
                                    color = Color(0xFF31A078),

                                    )
                            )
                        }
                    }

                }
            }


        }
    }
}

@Composable
fun BestPlanHeaderSection(
    modifier: Modifier = Modifier
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 30.dp, end = 30.dp, top = 20.dp)
    ) {
        Text(
            text = "Best Plans",
            style = TextStyle(
                fontSize = 22.sp,
                lineHeight = 28.sp,
                fontFamily = FontFamily.SansSerif,
                fontWeight = FontWeight(700),
                color = Color(0xFF000000),
                letterSpacing = 0.8.sp,
            )
        )

        Column(
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(
                modifier = Modifier.align(Alignment.End),
                text = "See All →",
                style = TextStyle(
                    fontSize = 18.sp,
                    lineHeight = 28.sp,
                    fontFamily = FontFamily.SansSerif,
                    fontWeight = FontWeight(500),
                    color = Color(0xFFFE555D),
                    textAlign = TextAlign.Right,
                    letterSpacing = 0.8.sp,
                )
            )
        }

    }
}

@Composable
fun BestPlanList(
    modifier: Modifier = Modifier
) {
    val rowState = rememberLazyListState()
    LazyRow(
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        contentPadding = PaddingValues(horizontal = 16.dp),
        modifier = modifier,
        state = rowState
    ) {
        items(bestPlanData) { item ->
            BestPlanListItem(drawableRes = item.drawable, text = item.text)
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BestPlanListItem(
    @DrawableRes drawableRes: Int, @StringRes text: Int, modifier: Modifier = Modifier
) {
    val cardSideMargin = dimensionResource(id = R.dimen.card_side_margin)
    ElevatedCard(
        onClick = {},
        modifier = Modifier
            .padding(
                start = cardSideMargin,
                end = cardSideMargin,
                top = cardSideMargin,
                bottom = dimensionResource(id = R.dimen.card_bottom_margin)
            )
            .width(134.dp)
            .height(170.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.secondaryContainer)
    ) {
        Text(
            modifier = Modifier.padding(start = 8.dp, top = 9.dp),
            text = stringResource(id = text),
            style = TextStyle(
                fontSize = 17.sp,
                lineHeight = 24.sp,
                fontFamily = FontFamily.SansSerif,
                fontWeight = FontWeight(600),
                color = Color(0xFFFFFFFF),

                )
        )
        Image(
            painter = painterResource(id = drawableRes),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(88.dp)
                .clip(CircleShape)
        )

    }

}

private val bestPlanData = listOf(
    R.drawable.ic_crane_drawer to R.string.gold,
    R.drawable.ic_crane_drawer to R.string.silver,
    R.drawable.ic_crane_drawer to R.string.platinum,
    R.drawable.ic_crane_drawer to R.string.diamond,
    R.drawable.ic_crane_drawer to R.string.uranium,
).map { DrawableStringPair(it.first, it.second) }

private data class DrawableStringPair(
    @DrawableRes val drawable: Int, @StringRes val text: Int
)

