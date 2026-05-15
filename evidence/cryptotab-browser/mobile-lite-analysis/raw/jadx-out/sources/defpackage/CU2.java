package defpackage;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public abstract class CU2 {
    protected int zzb;

    public static void a(Iterable iterable, List list) {
        Charset charset = NW2.a;
        iterable.getClass();
        if (iterable instanceof XW2) {
            List listB = ((XW2) iterable).b();
            XW2 xw2 = (XW2) list;
            int size = list.size();
            for (Object obj : listB) {
                if (obj == null) {
                    String str = "Element at index " + (xw2.size() - size) + " is null.";
                    int size2 = xw2.size();
                    while (true) {
                        size2--;
                        if (size2 < size) {
                            throw new NullPointerException(str);
                        }
                        xw2.remove(size2);
                    }
                } else if (obj instanceof WU2) {
                    xw2.C((WU2) obj);
                } else {
                    xw2.add((String) obj);
                }
            }
            return;
        }
        if (iterable instanceof InterfaceC0421bY2) {
            list.addAll((Collection) iterable);
            return;
        }
        if ((list instanceof ArrayList) && (iterable instanceof Collection)) {
            ((ArrayList) list).ensureCapacity(((Collection) iterable).size() + list.size());
        }
        int size3 = list.size();
        for (Object obj2 : iterable) {
            if (obj2 == null) {
                String str2 = "Element at index " + (list.size() - size3) + " is null.";
                int size4 = list.size();
                while (true) {
                    size4--;
                    if (size4 < size3) {
                        throw new NullPointerException(str2);
                    }
                    list.remove(size4);
                }
            } else {
                list.add(obj2);
            }
        }
    }

    public final byte[] b() {
        try {
            int iC = c();
            byte[] bArr = new byte[iC];
            BV2 bv2 = new BV2(iC, bArr);
            AbstractC1852zW2 abstractC1852zW2 = (AbstractC1852zW2) this;
            InterfaceC0784hY2 interfaceC0784hY2A = C0482cY2.c.a(abstractC1852zW2.getClass());
            FV2 fv2 = bv2.a;
            if (fv2 == null) {
                fv2 = new FV2(bv2);
            }
            interfaceC0784hY2A.e(abstractC1852zW2, fv2);
            if (iC - bv2.d == 0) {
                return bArr;
            }
            throw new IllegalStateException("Did not write as much data as expected.");
        } catch (IOException e) {
            throw new RuntimeException(BN0.a("Serializing ", getClass().getName(), " to a byte array threw an IOException (should never happen)."), e);
        }
    }

    public abstract int c();
}
