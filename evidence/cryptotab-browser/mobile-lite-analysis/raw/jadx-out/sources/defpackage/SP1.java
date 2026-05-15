package defpackage;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public abstract class SP1 {
    public static void a(StringBuilder sb, Object obj, InterfaceC0926jk0 interfaceC0926jk0) {
        if (interfaceC0926jk0 != null) {
            sb.append((CharSequence) interfaceC0926jk0.j(obj));
            return;
        }
        if (obj == null ? true : obj instanceof CharSequence) {
            sb.append((CharSequence) obj);
        } else if (obj instanceof Character) {
            sb.append(((Character) obj).charValue());
        } else {
            sb.append((CharSequence) String.valueOf(obj));
        }
    }
}
