package defpackage;

import android.view.View;

/* JADX INFO: renamed from: bo2, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC0438bo2 {
    public static CharSequence a(View view) {
        return view.getStateDescription();
    }

    public static void b(CharSequence charSequence, View view) {
        view.setStateDescription(charSequence);
    }
}
