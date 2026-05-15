package defpackage;

import android.content.Context;

/* JADX INFO: renamed from: nG2, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class C1137nG2 implements BI2 {
    public final AC2 a;

    public C1137nG2(AC2 ac2) {
        this.a = ac2;
    }

    @Override // defpackage.BI2
    public final Object zza() {
        Context context = this.a.a.a;
        return new C0765hG2(context, context.getPackageName());
    }
}
