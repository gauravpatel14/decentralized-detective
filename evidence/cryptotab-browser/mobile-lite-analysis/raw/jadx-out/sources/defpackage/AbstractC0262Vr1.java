package defpackage;

import android.graphics.Canvas;
import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: renamed from: Vr1, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC0262Vr1 {
    public void f(Rect rect, int i, RecyclerView recyclerView) {
        rect.set(0, 0, 0, 0);
    }

    public void g(Rect rect, View view, RecyclerView recyclerView, ms1 ms1Var) {
        f(rect, ((C0321Zr1) view.getLayoutParams()).a.f(), recyclerView);
    }

    public void h(Canvas canvas, RecyclerView recyclerView) {
    }

    public void i(Canvas canvas, RecyclerView recyclerView) {
    }
}
