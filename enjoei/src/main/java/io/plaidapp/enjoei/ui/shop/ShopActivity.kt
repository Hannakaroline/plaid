package io.plaidapp.enjoei.ui.shop

import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.apollographql.apollo.ApolloClient
import com.apollographql.apollo.api.Input
import com.apollographql.apollo.api.toInput
import com.apollographql.apollo.coroutines.await
import io.plaidapp.SearchForProductQuery
import io.plaidapp.enjoei.R
import io.plaidapp.type.ProductsSearchInput
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import okhttp3.internal.wait
import kotlin.math.log

val apolloClient = ApolloClient.builder()
    .serverUrl("https://enjusearch.enjoei.com.br/graphql-search")
    .build()

class ShopActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.enjoei_feed)
        val feedRecyclerView = findViewById<RecyclerView>(R.id.feed)

        GlobalScope.launch {
            val response = apolloClient.query(SearchForProductQuery(
                query = ProductsSearchInput("android"), aggregations = false
            )).await()

            Log.d("SearchForProductQuery", "Sucess ${response.data}")
        }
    }
}