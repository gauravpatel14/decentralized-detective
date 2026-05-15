package defpackage;

import android.app.PendingIntent;
import android.os.Bundle;
import com.google.android.play.core.install.InstallException;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

/* JADX INFO: renamed from: s13, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class BinderC1420s13 extends PZ2 {
    public final /* synthetic */ F13 w;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BinderC1420s13(F13 f13, H62 h62, String str) {
        super(f13, new C1224oY2("OnRequestInstallCallback"), h62);
        this.w = f13;
    }

    @Override // defpackage.PZ2, defpackage.InterfaceC1509tS2
    public final void b(Bundle bundle) {
        super.b(bundle);
        int i = bundle.getInt("error.code", -2);
        H62 h62 = this.u;
        if (i != 0) {
            h62.c(new InstallException(bundle.getInt("error.code", -2)));
            return;
        }
        int i2 = bundle.getInt("version.code", -1);
        int i3 = bundle.getInt("update.availability");
        bundle.getInt("install.status", 0);
        if (bundle.getInt("client.version.staleness", -1) != -1) {
            bundle.getInt("client.version.staleness");
        }
        bundle.getInt("in.app.update.priority", 0);
        bundle.getLong("bytes.downloaded");
        bundle.getLong("total.bytes.to.download");
        long j = bundle.getLong("additional.size.required");
        C0937k23 c0937k23 = this.w.d;
        c0937k23.getClass();
        long jA = C0937k23.a(new File(c0937k23.a.getFilesDir(), "assetpacks"));
        PendingIntent pendingIntent = (PendingIntent) bundle.getParcelable("blocking.intent");
        PendingIntent pendingIntent2 = (PendingIntent) bundle.getParcelable("nonblocking.intent");
        PendingIntent pendingIntent3 = (PendingIntent) bundle.getParcelable("blocking.destructive.intent");
        PendingIntent pendingIntent4 = (PendingIntent) bundle.getParcelable("nonblocking.destructive.intent");
        HashMap map = new HashMap();
        ArrayList<Integer> integerArrayList = bundle.getIntegerArrayList("update.precondition.failures:blocking.destructive.intent");
        HashSet hashSet = new HashSet();
        if (integerArrayList != null) {
            hashSet.addAll(integerArrayList);
        }
        map.put("blocking.destructive.intent", hashSet);
        ArrayList<Integer> integerArrayList2 = bundle.getIntegerArrayList("update.precondition.failures:nonblocking.destructive.intent");
        HashSet hashSet2 = new HashSet();
        if (integerArrayList2 != null) {
            hashSet2.addAll(integerArrayList2);
        }
        map.put("nonblocking.destructive.intent", hashSet2);
        ArrayList<Integer> integerArrayList3 = bundle.getIntegerArrayList("update.precondition.failures:blocking.intent");
        HashSet hashSet3 = new HashSet();
        if (integerArrayList3 != null) {
            hashSet3.addAll(integerArrayList3);
        }
        map.put("blocking.intent", hashSet3);
        ArrayList<Integer> integerArrayList4 = bundle.getIntegerArrayList("update.precondition.failures:nonblocking.intent");
        HashSet hashSet4 = new HashSet();
        if (integerArrayList4 != null) {
            hashSet4.addAll(integerArrayList4);
        }
        map.put("nonblocking.intent", hashSet4);
        h62.d(new Gd(i2, i3, j, jA, pendingIntent, pendingIntent2, pendingIntent3, pendingIntent4));
    }
}
