package com.em.databindingexp

import android.content.Context
import android.graphics.Canvas
import android.graphics.Rect
import android.graphics.drawable.Drawable
import android.support.annotation.DrawableRes
import android.support.v4.content.ContextCompat
import android.support.v7.widget.RecyclerView
import android.view.View


/**
 * <pre>
 *      author  :   E.M
 *      e-mail  :   ratchet@qq.com
 *      time    :   2017/09/22
 *      desc    :
 *      version :   1.0
 * </pre>
 */
class LineItemDecorator(context: Context, @DrawableRes drawableId: Int, val padding: Int = 0, val orientation: Int) : RecyclerView.ItemDecoration() {
    companion object {
        const val HORIZONTAL = 0
        const val VERTICAL = 1
    }

    private val drawable: Drawable = ContextCompat.getDrawable(context, drawableId)

    init {
        if (orientation != HORIZONTAL && orientation != VERTICAL) {
            throw IllegalArgumentException("orientation is illegal : $orientation")
        }
    }

    override fun getItemOffsets(outRect: Rect?, view: View?, parent: RecyclerView?, state: RecyclerView.State?) {
        if (orientation == HORIZONTAL) {
            outRect?.set(0, 0, 0, drawable.intrinsicHeight)
        } else if (orientation == VERTICAL) {
            outRect?.set(0, 0, drawable.intrinsicWidth, 0)
        }
    }

    override fun onDraw(c: Canvas, parent: RecyclerView, state: RecyclerView.State?) {
        super.onDraw(c, parent, state)
        if (orientation == HORIZONTAL) {
            drawHorizontal(c, parent)
        } else if (orientation == VERTICAL) {
            drawVertical(c, parent)
        }
    }

    private fun drawHorizontal(c: Canvas, parent: RecyclerView) {
        val rect = Rect()
        rect.left = parent.paddingLeft + padding
        rect.right = parent.width - parent.paddingRight - padding
        for (i in 0..(parent.childCount - 1)) {
            val child = parent.getChildAt(i)
            val params = child.layoutParams as RecyclerView.LayoutParams

            rect.top = child.bottom + params.bottomMargin
            rect.bottom = rect.top + drawable.intrinsicHeight

            drawable.bounds = rect
            drawable.draw(c)
        }
    }

    private fun drawVertical(c: Canvas, parent: RecyclerView) {
        val rect = Rect()
        rect.top = parent.paddingTop + padding
        rect.bottom = parent.height - parent.paddingBottom - padding
        for (i in 0..(parent.childCount - 1)) {
            val child = parent.getChildAt(i)
            val params = child.layoutParams as RecyclerView.LayoutParams

            rect.left = child.right + params.rightMargin
            rect.right = rect.left + drawable.intrinsicWidth

            drawable.bounds = rect
            drawable.draw(c)
        }
    }
}