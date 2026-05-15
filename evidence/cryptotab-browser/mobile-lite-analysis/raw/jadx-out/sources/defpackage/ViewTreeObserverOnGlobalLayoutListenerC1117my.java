package defpackage;

import android.view.View;
import android.view.ViewTreeObserver;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: renamed from: my, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class ViewTreeObserverOnGlobalLayoutListenerC1117my implements ViewTreeObserver.OnGlobalLayoutListener {
    public final /* synthetic */ ry t;

    public ViewTreeObserverOnGlobalLayoutListenerC1117my(ry ryVar) {
        this.t = ryVar;
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public final void onGlobalLayout() {
        ry ryVar = this.t;
        if (ryVar.q()) {
            ArrayList arrayList = ryVar.A;
            if (arrayList.size() <= 0 || ((C1358qy) arrayList.get(0)).a.R) {
                return;
            }
            View view = ryVar.H;
            if (view == null || !view.isShown()) {
                ryVar.dismiss();
                return;
            }
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                ((C1358qy) it.next()).a.a();
            }
        }
    }
}
