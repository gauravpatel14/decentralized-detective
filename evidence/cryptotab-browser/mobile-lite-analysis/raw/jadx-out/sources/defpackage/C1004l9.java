package defpackage;

import android.util.FloatProperty;

/* JADX INFO: renamed from: l9, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class C1004l9 extends FloatProperty {
    @Override // android.util.Property
    public final Float get(Object obj) {
        return Float.valueOf(((o9) obj).o);
    }

    @Override // android.util.FloatProperty
    public final void setValue(Object obj, float f) {
        o9 o9Var = (o9) obj;
        o9Var.o = f;
        o9Var.h.updateDragShadow(o9Var);
    }
}
