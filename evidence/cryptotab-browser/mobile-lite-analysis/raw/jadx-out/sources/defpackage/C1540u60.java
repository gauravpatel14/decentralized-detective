package defpackage;

import android.widget.EditText;

/* JADX INFO: renamed from: u60, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class C1540u60 {
    public final EditText a;
    public final H60 b;

    public C1540u60(EditText editText) {
        this.a = editText;
        H60 h60 = new H60(editText);
        this.b = h60;
        editText.addTextChangedListener(h60);
        if (C1595v60.b == null) {
            synchronized (C1595v60.a) {
                try {
                    if (C1595v60.b == null) {
                        C1595v60 c1595v60 = new C1595v60();
                        try {
                            C1595v60.c = Class.forName("android.text.DynamicLayout$ChangeWatcher", false, C1595v60.class.getClassLoader());
                        } catch (Throwable unused) {
                        }
                        C1595v60.b = c1595v60;
                    }
                } finally {
                }
            }
        }
        editText.setEditableFactory(C1595v60.b);
    }
}
