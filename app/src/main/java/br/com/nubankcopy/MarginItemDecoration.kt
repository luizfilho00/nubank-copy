package br.com.nubankcopy

import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView

class MarginItemDecoration(
    private val marginBetweenElements: Int
) : RecyclerView.ItemDecoration() {

    override fun getItemOffsets(
        outRect: Rect, view: View,
        parent: RecyclerView, state: RecyclerView.State
    ) {
        with(outRect) {
            if (parent.getChildAdapterPosition(view) != 0)
                left = marginBetweenElements
            if (parent.getChildAdapterPosition(view) == 0)
                left = view.resources.getDimension(R.dimen.margin_20).toInt()
            if (parent.getChildAdapterPosition(view) + 1 == parent.adapter?.itemCount)
                right = view.resources.getDimension(R.dimen.margin_20).toInt()
        }
    }
}