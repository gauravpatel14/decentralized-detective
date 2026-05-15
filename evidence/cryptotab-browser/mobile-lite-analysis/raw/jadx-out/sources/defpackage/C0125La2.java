package defpackage;

import android.widget.Toast$Callback;

/* JADX INFO: renamed from: La2, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class C0125La2 extends Toast$Callback {
    public final /* synthetic */ RunnableC0089Ha2 a;

    public C0125La2(RunnableC0089Ha2 runnableC0089Ha2) {
        this.a = runnableC0089Ha2;
    }

    public final void onToastHidden() {
        this.a.run();
    }
}
