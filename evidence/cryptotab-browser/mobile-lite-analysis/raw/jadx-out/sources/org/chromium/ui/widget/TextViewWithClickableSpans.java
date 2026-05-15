package org.chromium.ui.widget;

import android.content.Context;
import android.os.Bundle;
import android.text.Layout;
import android.text.SpannableString;
import android.text.style.ClickableSpan;
import android.util.AttributeSet;
import android.view.Menu;
import android.view.MotionEvent;
import android.view.View;
import android.widget.PopupMenu;
import defpackage.H82;
import defpackage.I82;
import org.chromium.ui.accessibility.AccessibilityState;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public class TextViewWithClickableSpans extends TextViewWithLeading implements View.OnLongClickListener {
    public PopupMenu z;

    public TextViewWithClickableSpans(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        j();
    }

    public final ClickableSpan[] i() {
        CharSequence text = getText();
        if (!(text instanceof SpannableString)) {
            return null;
        }
        SpannableString spannableString = (SpannableString) text;
        return (ClickableSpan[]) spannableString.getSpans(0, spannableString.length(), ClickableSpan.class);
    }

    public final void j() {
        setSaveEnabled(false);
        super.setOnLongClickListener(this);
    }

    public final void k() {
        ClickableSpan[] clickableSpanArrI = i();
        if (clickableSpanArrI == null || clickableSpanArrI.length == 0 || this.z != null) {
            return;
        }
        SpannableString spannableString = (SpannableString) getText();
        PopupMenu popupMenu = new PopupMenu(getContext(), this);
        this.z = popupMenu;
        Menu menu = popupMenu.getMenu();
        for (ClickableSpan clickableSpan : clickableSpanArrI) {
            menu.add(spannableString.subSequence(spannableString.getSpanStart(clickableSpan), spannableString.getSpanEnd(clickableSpan))).setOnMenuItemClickListener(new H82(this, clickableSpan));
        }
        this.z.setOnDismissListener(new I82(this));
        this.z.show();
    }

    public final boolean l(MotionEvent motionEvent) {
        CharSequence text = getText();
        if (!(text instanceof SpannableString)) {
            return false;
        }
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        int totalPaddingLeft = x - getTotalPaddingLeft();
        int totalPaddingTop = y - getTotalPaddingTop();
        int scrollX = getScrollX() + totalPaddingLeft;
        int scrollY = getScrollY() + totalPaddingTop;
        Layout layout = getLayout();
        int offsetForHorizontal = layout.getOffsetForHorizontal(layout.getLineForVertical(scrollY), scrollX);
        return ((ClickableSpan[]) ((SpannableString) text).getSpans(offsetForHorizontal, offsetForHorizontal, ClickableSpan.class)).length > 0;
    }

    @Override // android.view.View.OnLongClickListener
    public final boolean onLongClick(View view) {
        if (!AccessibilityState.g()) {
            return false;
        }
        k();
        return true;
    }

    @Override // android.widget.TextView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean zOnTouchEvent = super.onTouchEvent(motionEvent);
        if (motionEvent.getAction() == 1 || !AccessibilityState.g() || l(motionEvent)) {
            return zOnTouchEvent;
        }
        ClickableSpan[] clickableSpanArrI = i();
        if (clickableSpanArrI != null && clickableSpanArrI.length != 0) {
            if (clickableSpanArrI.length == 1) {
                clickableSpanArrI[0].onClick(this);
            } else {
                k();
            }
        }
        return true;
    }

    @Override // android.view.View
    public final boolean performAccessibilityAction(int i, Bundle bundle) {
        if (i != 16) {
            return super.performAccessibilityAction(i, bundle);
        }
        ClickableSpan[] clickableSpanArrI = i();
        if (clickableSpanArrI != null && clickableSpanArrI.length != 0) {
            if (clickableSpanArrI.length == 1) {
                clickableSpanArrI[0].onClick(this);
            } else {
                k();
            }
        }
        return true;
    }

    public TextViewWithClickableSpans(Context context) {
        super(context, null);
        j();
    }
}
