package defpackage;

import android.content.Context;
import android.view.View;
import android.view.Window;

/* JADX INFO: renamed from: fd2, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class ViewOnClickListenerC0661fd2 implements View.OnClickListener {
    public final v3 t;
    public final /* synthetic */ C0791hd2 u;

    public ViewOnClickListenerC0661fd2(C0791hd2 c0791hd2) {
        this.u = c0791hd2;
        Context context = c0791hd2.a.getContext();
        CharSequence charSequence = c0791hd2.h;
        v3 v3Var = new v3();
        v3Var.e = 4096;
        v3Var.g = 4096;
        v3Var.l = null;
        v3Var.m = null;
        v3Var.n = false;
        v3Var.o = false;
        v3Var.p = 16;
        v3Var.i = context;
        v3Var.a = charSequence;
        this.t = v3Var;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        C0791hd2 c0791hd2 = this.u;
        Window.Callback callback = c0791hd2.k;
        if (callback == null || !c0791hd2.l) {
            return;
        }
        callback.onMenuItemSelected(0, this.t);
    }
}
