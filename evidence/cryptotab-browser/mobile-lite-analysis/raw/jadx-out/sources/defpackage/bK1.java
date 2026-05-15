package defpackage;

import org.chromium.ui.modelutil.PropertyModel;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class bK1 extends ps1 {
    public C0499cn1 N;
    public InterfaceC0436bn1 O;
    public PropertyModel P;

    public final void v(PropertyModel propertyModel) {
        C0499cn1 c0499cn1 = this.N;
        if (c0499cn1 != null) {
            c0499cn1.b();
        }
        this.P = propertyModel;
        if (propertyModel == null) {
            return;
        }
        this.N = C0499cn1.a(propertyModel, this.t, this.O);
    }
}
