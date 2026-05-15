package defpackage;

import android.view.KeyEvent;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public abstract class GB0 {
    public static boolean a(KeyEvent keyEvent) {
        return keyEvent.getAction() == 0;
    }

    public static boolean b(KeyEvent keyEvent) {
        return keyEvent.getKeyCode() == 66 || keyEvent.getKeyCode() == 160;
    }
}
