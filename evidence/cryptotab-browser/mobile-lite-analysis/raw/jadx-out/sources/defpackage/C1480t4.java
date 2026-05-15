package defpackage;

import java.util.ArrayList;
import java.util.LinkedHashMap;

/* JADX INFO: renamed from: t4, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class C1480t4 extends o4 {
    public final /* synthetic */ int a;
    public final /* synthetic */ u4 b;
    public final /* synthetic */ String c;
    public final /* synthetic */ AbstractC1065m4 d;

    public /* synthetic */ C1480t4(u4 u4Var, String str, AbstractC1065m4 abstractC1065m4, int i) {
        this.a = i;
        this.b = u4Var;
        this.c = str;
        this.d = abstractC1065m4;
    }

    @Override // defpackage.o4
    public final void a(Object obj) {
        switch (this.a) {
            case 0:
                u4 u4Var = this.b;
                LinkedHashMap linkedHashMap = u4Var.b;
                String str = this.c;
                Object obj2 = linkedHashMap.get(str);
                AbstractC1065m4 abstractC1065m4 = this.d;
                if (obj2 == null) {
                    throw new IllegalStateException(("Attempting to launch an unregistered ActivityResultLauncher with contract " + abstractC1065m4 + " and input " + obj + ". You must ensure the ActivityResultLauncher is registered before calling launch().").toString());
                }
                int iIntValue = ((Number) obj2).intValue();
                ArrayList arrayList = u4Var.d;
                arrayList.add(str);
                try {
                    u4Var.b(iIntValue, abstractC1065m4, obj);
                    return;
                } catch (Exception e) {
                    arrayList.remove(str);
                    throw e;
                }
            default:
                u4 u4Var2 = this.b;
                LinkedHashMap linkedHashMap2 = u4Var2.b;
                String str2 = this.c;
                Object obj3 = linkedHashMap2.get(str2);
                AbstractC1065m4 abstractC1065m42 = this.d;
                if (obj3 == null) {
                    throw new IllegalStateException(("Attempting to launch an unregistered ActivityResultLauncher with contract " + abstractC1065m42 + " and input " + obj + ". You must ensure the ActivityResultLauncher is registered before calling launch().").toString());
                }
                int iIntValue2 = ((Number) obj3).intValue();
                ArrayList arrayList2 = u4Var2.d;
                arrayList2.add(str2);
                try {
                    u4Var2.b(iIntValue2, abstractC1065m42, obj);
                    return;
                } catch (Exception e2) {
                    arrayList2.remove(str2);
                    throw e2;
                }
        }
    }

    public void b() {
        this.b.f(this.c);
    }
}
