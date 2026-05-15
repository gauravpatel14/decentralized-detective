package defpackage;

import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BasePendingResult;
import com.google.android.gms.common.api.internal.zaad;

/* JADX INFO: renamed from: Jy2, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class C0115Jy2 implements PendingResult.StatusListener {
    public final /* synthetic */ BasePendingResult a;
    public final /* synthetic */ zaad b;

    public C0115Jy2(zaad zaadVar, BasePendingResult basePendingResult) {
        this.b = zaadVar;
        this.a = basePendingResult;
    }

    @Override // com.google.android.gms.common.api.PendingResult.StatusListener
    public final void onComplete(Status status) {
        this.b.zaa.remove(this.a);
    }
}
