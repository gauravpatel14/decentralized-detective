package defpackage;

import org.json.JSONObject;

/* JADX INFO: renamed from: Xk2, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class C0288Xk2 implements nv1 {
    public final /* synthetic */ C0374al2 a;

    @Override // defpackage.nv1
    public final void a(Object obj) {
        C0374al2 c0374al2 = this.a;
        c0374al2.getClass();
        String strOptString = ((JSONObject) obj).optString("min", null);
        int i = AbstractC1872zv.a;
        c0374al2.a = Jd.a(strOptString);
        Zk2 zk2 = c0374al2.b;
        if (zk2 != null) {
            zk2.run();
        }
    }
}
