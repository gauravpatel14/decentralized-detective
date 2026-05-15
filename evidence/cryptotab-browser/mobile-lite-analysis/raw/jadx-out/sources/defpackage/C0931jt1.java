package defpackage;

import com.google.firebase.iid.FirebaseInstanceId;

/* JADX INFO: renamed from: jt1, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class C0931jt1 implements nI {
    public static final C0931jt1 b = new C0931jt1(1);
    public static final C0931jt1 c = new C0931jt1(2);
    public final /* synthetic */ int a;

    public /* synthetic */ C0931jt1(int i) {
        this.a = i;
    }

    @Override // defpackage.nI
    public Object a(Xv1 xv1) {
        switch (this.a) {
            case 1:
                return new FirebaseInstanceId((C0488cf0) xv1.a(C0488cf0.class), xv1.b(C1680wW.class), xv1.b(Ln0.class), (of0) xv1.a(of0.class));
            default:
                return new C0931jt1(0);
        }
    }
}
