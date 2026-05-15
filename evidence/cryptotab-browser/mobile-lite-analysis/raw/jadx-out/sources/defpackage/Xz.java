package defpackage;

import android.content.Context;
import android.content.Intent;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class Xz {
    public final /* synthetic */ Context a;
    public final /* synthetic */ C0619fA b;

    public Xz(C0619fA c0619fA, Context context) {
        this.b = c0619fA;
        this.a = context;
    }

    public final DA a(Intent intent, int i, Zz zz, String str) {
        C0619fA c0619fA = this.b;
        return new DA(this.a, intent, i, c0619fA.b, c0619fA.c, zz, str);
    }
}
