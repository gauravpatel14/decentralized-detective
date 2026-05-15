package defpackage;

import android.os.Bundle;
import android.text.TextUtils;

/* JADX INFO: renamed from: mU2, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class C1094mU2 implements InterfaceC0536dY2 {
    public final /* synthetic */ IU2 a;

    public C1094mU2(IU2 iu2) {
        this.a = iu2;
    }

    @Override // defpackage.InterfaceC0536dY2
    public final void a(String str, Bundle bundle) {
        boolean zIsEmpty = TextUtils.isEmpty(str);
        IU2 iu2 = this.a;
        if (zIsEmpty) {
            iu2.m("auto", "_err", bundle, true, true, iu2.a.n.currentTimeMillis());
        } else {
            iu2.getClass();
            throw new IllegalStateException("Unexpected call on client side");
        }
    }
}
