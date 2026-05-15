package defpackage;

import android.text.Editable;

/* JADX INFO: renamed from: v60, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class C1595v60 extends Editable.Factory {
    public static final Object a = new Object();
    public static volatile C1595v60 b;
    public static Class c;

    @Override // android.text.Editable.Factory
    public final Editable newEditable(CharSequence charSequence) {
        Class cls = c;
        return cls != null ? new C1082mM1(cls, charSequence) : super.newEditable(charSequence);
    }
}
