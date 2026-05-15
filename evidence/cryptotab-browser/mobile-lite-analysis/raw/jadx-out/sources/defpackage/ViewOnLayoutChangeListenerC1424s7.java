package defpackage;

import android.graphics.Rect;
import android.view.View;

/* JADX INFO: renamed from: s7, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class ViewOnLayoutChangeListenerC1424s7 extends Lr1 implements View.OnLayoutChangeListener {
    public final View v;

    public ViewOnLayoutChangeListenerC1424s7(View view) {
        this.v = view;
        view.addOnLayoutChangeListener(this);
        Rect rect = this.t;
        view.getWindowVisibleDisplayFrame(rect);
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        rect.offset(-iArr[0], -iArr[1]);
    }

    @Override // android.view.View.OnLayoutChangeListener
    public final void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        View view2 = this.v;
        Rect rect = this.t;
        view2.getWindowVisibleDisplayFrame(rect);
        int[] iArr = new int[2];
        view2.getLocationOnScreen(iArr);
        rect.offset(-iArr[0], -iArr[1]);
    }
}
