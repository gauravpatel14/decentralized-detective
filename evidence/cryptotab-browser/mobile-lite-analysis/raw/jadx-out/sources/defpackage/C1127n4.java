package defpackage;

import android.content.Context;
import android.content.Intent;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.IntentSenderRequest;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;

/* JADX INFO: renamed from: n4, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class C1127n4 extends AbstractC1065m4 {
    public final /* synthetic */ int a;

    public /* synthetic */ C1127n4(int i) {
        this.a = i;
    }

    @Override // defpackage.AbstractC1065m4
    public final Intent a(Object obj) {
        switch (this.a) {
            case 0:
                return new Intent("androidx.activity.result.contract.action.REQUEST_PERMISSIONS").putExtra("androidx.activity.result.contract.extra.PERMISSIONS", (String[]) obj);
            case 1:
                return (Intent) obj;
            default:
                return new Intent("androidx.activity.result.contract.action.INTENT_SENDER_REQUEST").putExtra("androidx.activity.result.contract.extra.INTENT_SENDER_REQUEST", (IntentSenderRequest) obj);
        }
    }

    @Override // defpackage.AbstractC1065m4
    public l4 b(Context context, Object obj) {
        switch (this.a) {
            case 0:
                String[] strArr = (String[]) obj;
                if (strArr.length == 0) {
                    return new l4(V60.t);
                }
                for (String str : strArr) {
                    if (U3.a(context, str) != 0) {
                        return null;
                    }
                }
                int iB = EL0.b(strArr.length);
                if (iB < 16) {
                    iB = 16;
                }
                LinkedHashMap linkedHashMap = new LinkedHashMap(iB);
                for (String str2 : strArr) {
                    linkedHashMap.put(str2, Boolean.TRUE);
                }
                return new l4(linkedHashMap);
            default:
                return super.b(context, obj);
        }
    }

    @Override // defpackage.AbstractC1065m4
    public final Object c(Intent intent, int i) {
        switch (this.a) {
            case 0:
                V60 v60 = V60.t;
                if (i == -1 && intent != null) {
                    String[] stringArrayExtra = intent.getStringArrayExtra("androidx.activity.result.contract.extra.PERMISSIONS");
                    int[] intArrayExtra = intent.getIntArrayExtra("androidx.activity.result.contract.extra.PERMISSION_GRANT_RESULTS");
                    if (intArrayExtra != null && stringArrayExtra != null) {
                        ArrayList arrayList = new ArrayList(intArrayExtra.length);
                        for (int i2 : intArrayExtra) {
                            arrayList.add(Boolean.valueOf(i2 == 0));
                        }
                        ArrayList arrayList2 = new ArrayList();
                        for (String str : stringArrayExtra) {
                            if (str != null) {
                                arrayList2.add(str);
                            }
                        }
                        Iterator it = arrayList2.iterator();
                        Iterator it2 = arrayList.iterator();
                        ArrayList arrayList3 = new ArrayList(Math.min(PG.d(arrayList2), PG.d(arrayList)));
                        while (it.hasNext() && it2.hasNext()) {
                            arrayList3.add(new I81(it.next(), it2.next()));
                        }
                        break;
                    }
                }
                break;
        }
        return new ActivityResult(intent, i);
    }
}
