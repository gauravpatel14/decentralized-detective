package defpackage;

import android.content.Context;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class PV implements InterfaceC0988kn1 {
    public final /* synthetic */ Context a;
    public final /* synthetic */ String b;

    public /* synthetic */ PV(Context context, String str) {
        this.a = context;
        this.b = str;
    }

    @Override // defpackage.InterfaceC0988kn1
    public final Object get() {
        return new Mn0(this.a, this.b);
    }
}
