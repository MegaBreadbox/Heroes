package com.example.superhero

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.superhero.model.Hero
import com.example.superhero.model.HeroRepository
import com.example.superhero.ui.theme.SuperHeroTheme

@Composable
fun HeroCard(
    hero: Hero,
    modifier: Modifier = Modifier
){
    Card(
        elevation = CardDefaults.cardElevation(dimensionResource(R.dimen.card_elevation)),
        modifier = modifier
            .height(dimensionResource(R.dimen.card_height))
            .fillMaxWidth()
            .padding(
                start = dimensionResource(id = R.dimen.big_padding),
                end = dimensionResource(id = R.dimen.big_padding)
            )
    ){
        Row{
            Column(
                modifier.padding(dimensionResource(R.dimen.big_padding))
                    .weight(1f)
            ){
                Text(
                    text = stringResource(hero.nameRes),
                    style = MaterialTheme.typography.bodyLarge,

                )
                Text(
                    text = stringResource(hero.descriptionRes),
                    style = MaterialTheme.typography.displaySmall,
                )
            }
            Spacer(
                modifier.size(dimensionResource(R.dimen.big_padding))
            )
            Box(
                modifier
                    .size(dimensionResource(R.dimen.card_height)),
                contentAlignment = Alignment.Center
            ) {
                Image(
                    painter = painterResource(hero.imageRes),
                    contentDescription = null,
                    modifier
                        .padding(dimensionResource(R.dimen.big_padding))
                        .clip(MaterialTheme.shapes.small)
                        .size(dimensionResource(R.dimen.card_height))

                )
            }
        }
    }
}

@Composable
fun HeroListLayout(
){
    LazyColumn(


    ){
        items(HeroRepository.heroList){
            HeroCard(it)
        }
    }
}

@Preview
@Composable
fun HeroPreview(){
    SuperHeroTheme{
        HeroCard(HeroRepository.heroList[0])
    }
}