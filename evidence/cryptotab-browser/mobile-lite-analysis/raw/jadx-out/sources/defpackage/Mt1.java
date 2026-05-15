package defpackage;

import com.google.android.gms.common.api.Status;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class Mt1 implements It1 {
    public final Status t;

    public Mt1(Status status) {
        this.t = status;
    }

    @Override // com.google.android.gms.common.api.Result
    public final Status getStatus() {
        return this.t;
    }
}
