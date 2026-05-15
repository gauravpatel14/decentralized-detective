package defpackage;

import android.content.Context;
import android.text.TextUtils;
import java.util.Arrays;
import java.util.TreeSet;
import org.chromium.components.crash.CrashKeys;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public abstract class wO {
    public static void a() {
        Context context = AbstractC1499tM.a;
        CrashKeys crashKeys = CrashKeys.getInstance();
        TreeSet treeSet = new TreeSet();
        char[] cArr = C61.a;
        int i = AbstractC1872zv.a;
        String[] strArr = C61.c(Bv.a.d, 0).splitNames;
        if (strArr != null) {
            treeSet.addAll(Arrays.asList(strArr));
        }
        TreeSet treeSet2 = new TreeSet();
        if (cN1.a) {
            treeSet2.addAll(AbstractC1085mN1.a(context).b());
            treeSet2.removeAll(treeSet);
        }
        crashKeys.set(3, treeSet.isEmpty() ? "<none>" : TextUtils.join(",", treeSet).replace('.', '$'));
        crashKeys.set(4, treeSet2.isEmpty() ? "<none>" : TextUtils.join(",", treeSet2).replace('.', '$'));
    }
}
