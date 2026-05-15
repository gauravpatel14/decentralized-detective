package defpackage;

import org.json.JSONObject;

/* JADX INFO: renamed from: fM2, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class C0635fM2 implements BM2 {
    public final /* synthetic */ C0565eF2 a;
    public final /* synthetic */ UL2 b;

    public C0635fM2(UL2 ul2, C0565eF2 c0565eF2) {
        this.b = ul2;
        this.a = c0565eF2;
    }

    @Override // defpackage.BM2
    public final void a(long j) {
        C0565eF2 c0565eF2 = this.a;
        if (c0565eF2 != null) {
            c0565eF2.a(j);
        }
    }

    @Override // defpackage.BM2
    public final void b(long j, int i, JSONObject jSONObject) {
        this.b.f = null;
        C0565eF2 c0565eF2 = this.a;
        if (c0565eF2 != null) {
            c0565eF2.b(j, i, jSONObject);
        }
    }
}
