package io.plaidapp.core.enjoei.ui

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import io.plaidapp.core.designernews.data.stories.model.Story
import io.plaidapp.core.designernews.ui.stories.StoryViewHolder
import io.plaidapp.core.ui.recyclerview.Divided

class EnjoeiButtonViewHolder(
    itemView: View,
    private val onItemClicked: () -> Unit
) : RecyclerView.ViewHolder(itemView), Divided {
    init {
        itemView.setOnClickListener { onItemClicked() }
    }

}