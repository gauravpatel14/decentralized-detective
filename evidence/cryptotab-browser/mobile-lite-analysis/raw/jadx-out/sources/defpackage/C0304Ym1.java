package defpackage;

import android.util.FloatProperty;
import org.chromium.ui.modelutil.PropertyModel;

/* JADX INFO: renamed from: Ym1, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class C0304Ym1 extends FloatProperty {
    public final C0223Sm1 a;

    public C0304Ym1(C0223Sm1 c0223Sm1) {
        super(c0223Sm1.toString());
        this.a = c0223Sm1;
    }

    @Override // android.util.Property
    public final Float get(Object obj) {
        return Float.valueOf(((PropertyModel) obj).d(this.a));
    }

    @Override // android.util.FloatProperty
    public final void setValue(Object obj, float f) {
        ((PropertyModel) obj).l(this.a, f);
    }
}
