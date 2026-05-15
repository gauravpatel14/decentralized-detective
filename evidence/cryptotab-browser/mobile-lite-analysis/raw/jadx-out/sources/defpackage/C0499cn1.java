package defpackage;

import org.chromium.ui.modelutil.PropertyModel;

/* JADX INFO: renamed from: cn1, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class C0499cn1 {
    public final Object a;
    public final PropertyModel b;
    public final InterfaceC0436bn1 c;
    public final C0379an1 d = new InterfaceC0546dn1() { // from class: an1
        @Override // defpackage.InterfaceC0546dn1
        public final void a(PropertyModel propertyModel, AbstractC0197Qm1 abstractC0197Qm1) {
            C0499cn1 c0499cn1 = this.t;
            c0499cn1.c.f(c0499cn1.b, c0499cn1.a, abstractC0197Qm1);
        }
    };

    /* JADX WARN: Type inference failed for: r0v0, types: [an1] */
    public C0499cn1(PropertyModel propertyModel, Object obj, InterfaceC0436bn1 interfaceC0436bn1, boolean z) {
        this.b = propertyModel;
        this.a = obj;
        this.c = interfaceC0436bn1;
        if (z) {
            for (Object obj2 : propertyModel.i()) {
                this.c.f(this.b, this.a, obj2);
            }
        }
        propertyModel.a(this.d);
    }

    public static C0499cn1 a(PropertyModel propertyModel, Object obj, InterfaceC0436bn1 interfaceC0436bn1) {
        return new C0499cn1(propertyModel, obj, interfaceC0436bn1, true);
    }

    public final void b() {
        this.b.k(this.d);
    }
}
