package defpackage;

import android.util.SparseBooleanArray;
import android.view.DragEvent;
import android.view.View;

/* JADX INFO: renamed from: s30, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class ViewOnDragListenerC1421s30 implements View.OnDragListener {
    public static final int[] w = {1, 2, 3, 4, 5, 6};
    public final View t;
    public final InterfaceC1362r30 u;
    public final SparseBooleanArray v = new SparseBooleanArray(6);

    public ViewOnDragListenerC1421s30(View view, InterfaceC1362r30 interfaceC1362r30) {
        this.t = view;
        this.u = interfaceC1362r30;
        view.setOnDragListener(this);
        int[] iArr = w;
        for (int i = 0; i < 6; i++) {
            int i2 = iArr[i];
            boolean z = true;
            if (i2 == 1 || i2 == 4) {
                z = false;
            }
            this.v.put(i2, z);
        }
    }

    @Override // android.view.View.OnDragListener
    public final boolean onDrag(View view, DragEvent dragEvent) {
        boolean z = dragEvent.getAction() == 1;
        InterfaceC1362r30 interfaceC1362r30 = this.u;
        View viewA = interfaceC1362r30.a();
        if (viewA.isEnabled() && viewA.isAttachedToWindow()) {
            if (this.v.get(dragEvent.getAction())) {
                if (dragEvent.getAction() == 5 || dragEvent.getAction() == 6 || dragEvent.getAction() == 4) {
                    return interfaceC1362r30.e(dragEvent, 0, 0) || z;
                }
                int[] iArr = new int[2];
                this.t.getLocationOnScreen(iArr);
                int[] iArr2 = new int[2];
                viewA.getLocationOnScreen(iArr2);
                return interfaceC1362r30.e(dragEvent, iArr[0] - iArr2[0], iArr[1] - iArr2[1]) || z;
            }
        }
        return z;
    }
}
