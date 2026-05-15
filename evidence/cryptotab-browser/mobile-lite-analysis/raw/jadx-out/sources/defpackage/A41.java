package defpackage;

import java.util.ListIterator;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class A41 extends RC0 implements InterfaceC0926jk0 {
    public final /* synthetic */ int u;
    public final /* synthetic */ J41 v;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ A41(J41 j41, int i) {
        super(1);
        this.u = i;
        this.v = j41;
    }

    @Override // defpackage.InterfaceC0926jk0
    public final Object j(Object obj) {
        Object objPrevious;
        Object objPrevious2;
        switch (this.u) {
            case 0:
                C0375am c0375am = (C0375am) obj;
                J41 j41 = this.v;
                Ye ye = j41.b;
                ListIterator listIterator = ye.listIterator(ye.size());
                while (true) {
                    if (listIterator.hasPrevious()) {
                        objPrevious = listIterator.previous();
                        if (((AbstractC1815z41) objPrevious).a) {
                        }
                    } else {
                        objPrevious = null;
                    }
                }
                AbstractC1815z41 abstractC1815z41 = (AbstractC1815z41) objPrevious;
                if (j41.c != null) {
                    j41.c();
                }
                j41.c = abstractC1815z41;
                if (abstractC1815z41 != null) {
                    abstractC1815z41.d(c0375am);
                }
                break;
            default:
                C0375am c0375am2 = (C0375am) obj;
                J41 j412 = this.v;
                AbstractC1815z41 abstractC1815z412 = j412.c;
                if (abstractC1815z412 == null) {
                    Ye ye2 = j412.b;
                    ListIterator listIterator2 = ye2.listIterator(ye2.size());
                    while (true) {
                        if (listIterator2.hasPrevious()) {
                            objPrevious2 = listIterator2.previous();
                            if (((AbstractC1815z41) objPrevious2).a) {
                            }
                        } else {
                            objPrevious2 = null;
                        }
                    }
                    abstractC1815z412 = (AbstractC1815z41) objPrevious2;
                }
                if (abstractC1815z412 != null) {
                    abstractC1815z412.c(c0375am2);
                }
                break;
        }
        return C0302Yj2.a;
    }
}
