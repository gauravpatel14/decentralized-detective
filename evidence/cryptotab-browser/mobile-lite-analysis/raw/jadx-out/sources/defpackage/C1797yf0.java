package defpackage;

import com.google.android.datatransport.TransportFactory;
import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.messaging.FirebaseMessaging;

/* JADX INFO: renamed from: yf0, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class C1797yf0 implements nI {
    public static final C1797yf0 a = new C1797yf0();

    @Override // defpackage.nI
    public Object a(Xv1 xv1) {
        C0488cf0 c0488cf0 = (C0488cf0) xv1.a(C0488cf0.class);
        FirebaseInstanceId firebaseInstanceId = (FirebaseInstanceId) xv1.a(FirebaseInstanceId.class);
        InterfaceC0988kn1 interfaceC0988kn1B = xv1.b(C1680wW.class);
        InterfaceC0988kn1 interfaceC0988kn1B2 = xv1.b(Ln0.class);
        of0 of0Var = (of0) xv1.a(of0.class);
        TransportFactory c1857zf0 = (TransportFactory) xv1.a(TransportFactory.class);
        if (c1857zf0 == null) {
            c1857zf0 = new C1857zf0();
        }
        return new FirebaseMessaging(c0488cf0, firebaseInstanceId, interfaceC0988kn1B, interfaceC0988kn1B2, of0Var, c1857zf0, (InterfaceC1390rR1) xv1.a(InterfaceC1390rR1.class));
    }
}
