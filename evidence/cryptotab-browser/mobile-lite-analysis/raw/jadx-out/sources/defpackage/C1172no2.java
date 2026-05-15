package defpackage;

import android.view.View;
import android.view.ViewGroup;

/* JADX INFO: renamed from: no2, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class C1172no2 extends RC0 implements InterfaceC0926jk0 {
    public static final C1172no2 u = new C1172no2(1);

    @Override // defpackage.InterfaceC0926jk0
    public final Object j(Object obj) {
        View view = (View) obj;
        ViewGroup viewGroup = view instanceof ViewGroup ? (ViewGroup) view : null;
        if (viewGroup != null) {
            return new C1235oo2(viewGroup);
        }
        return null;
    }
}
