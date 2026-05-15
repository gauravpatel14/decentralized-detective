package defpackage;

import com.google.android.gms.common.api.internal.zaaw;

/* JADX INFO: renamed from: Ny2, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class RunnableC0167Ny2 implements Runnable {
    public final /* synthetic */ zaaw t;

    public RunnableC0167Ny2(zaaw zaawVar) {
        this.t = zaawVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zaaw zaawVar = this.t;
        zaawVar.zad.cancelAvailabilityErrorNotifications(zaawVar.zac);
    }
}
