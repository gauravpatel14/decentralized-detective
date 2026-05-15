package defpackage;

import android.os.Bundle;

/* JADX INFO: renamed from: m33, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class C1064m33 implements InterfaceC1507tR1 {
    public static final C1064m33 a = new C1064m33();

    @Override // defpackage.InterfaceC1507tR1
    public final G62 then(Object obj) {
        Bundle bundle = (Bundle) obj;
        return (bundle == null || !bundle.containsKey("google.messenger")) ? Y62.e(bundle) : Y62.e(null);
    }
}
