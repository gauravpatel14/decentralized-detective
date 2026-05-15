package defpackage;

import org.chromium.components.crash.CrashKeys;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class Xd implements Td {
    public String t;

    @Override // defpackage.Td
    public final void q(int i) {
        String str = (i == 1 || i == 2) ? "app_foreground" : "app_background";
        if (str.equals(this.t)) {
            return;
        }
        this.t = str;
        CrashKeys.getInstance().set(2, str);
    }
}
