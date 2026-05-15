package androidx.fragment.app;

import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Looper;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.s;
import com.google.android.gms.common.ConnectionResult;
import defpackage.AQ0;
import defpackage.AbstractC0068Fh0;
import defpackage.AbstractC0092Hi0;
import defpackage.AbstractC0132Lp1;
import defpackage.AbstractC0246Uh0;
import defpackage.BN0;
import defpackage.C0083Go2;
import defpackage.C0600ei0;
import defpackage.C0665fi0;
import defpackage.C0730gi0;
import defpackage.C0862ii0;
import defpackage.C0925ji0;
import defpackage.C1127n4;
import defpackage.C1480t4;
import defpackage.DO;
import defpackage.F;
import defpackage.Gs1;
import defpackage.Ii0;
import defpackage.InterfaceC0105Io2;
import defpackage.InterfaceC0762hF0;
import defpackage.InterfaceC1166ni0;
import defpackage.InterfaceC1463si0;
import defpackage.J41;
import defpackage.K41;
import defpackage.O41;
import defpackage.QK;
import defpackage.Qh0;
import defpackage.RunnableC0796hi0;
import defpackage.S3;
import defpackage.S41;
import defpackage.T41;
import defpackage.TI0;
import defpackage.V41;
import defpackage.Xd0;
import defpackage.Xh0;
import defpackage.Zh0;
import defpackage.ai0;
import defpackage.cF0;
import defpackage.di0;
import defpackage.iF;
import defpackage.sz1;
import defpackage.tz1;
import defpackage.u4;
import defpackage.v4;
import defpackage.vx;
import defpackage.vz1;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public abstract class s {
    public final C0665fi0 A;
    public final C0730gi0 B;
    public C1480t4 C;
    public C1480t4 D;
    public C1480t4 E;
    public ArrayDeque F;
    public boolean G;
    public boolean H;
    public boolean I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public boolean f16J;
    public boolean K;
    public ArrayList L;
    public ArrayList M;
    public ArrayList N;
    public t O;
    public final RunnableC0796hi0 P;
    public boolean b;
    public ArrayList e;
    public J41 g;
    public final ArrayList n;
    public final Zh0 o;
    public final CopyOnWriteArrayList p;
    public final ai0 q;
    public final ai0 r;
    public final ai0 s;
    public final ai0 t;
    public final C0600ei0 u;
    public int v;
    public Xh0 w;
    public AbstractC0246Uh0 x;
    public n y;
    public n z;
    public final ArrayList a = new ArrayList();
    public final v c = new v();
    public ArrayList d = new ArrayList();
    public final p f = new p(this);
    public a h = null;
    public boolean i = false;
    public final q j = new q(this);
    public final AtomicInteger k = new AtomicInteger();
    public final Map l = Collections.synchronizedMap(new HashMap());
    public final Map m = Collections.synchronizedMap(new HashMap());

    /* JADX WARN: Type inference failed for: r0v16, types: [ai0] */
    /* JADX WARN: Type inference failed for: r0v17, types: [ai0] */
    /* JADX WARN: Type inference failed for: r0v18, types: [ai0] */
    /* JADX WARN: Type inference failed for: r0v19, types: [ai0] */
    public s() {
        Collections.synchronizedMap(new HashMap());
        this.n = new ArrayList();
        this.o = new Zh0(this);
        this.p = new CopyOnWriteArrayList();
        final int i = 0;
        this.q = new QK(this) { // from class: ai0
            public final /* synthetic */ s u;

            {
                this.u = this;
            }

            @Override // defpackage.QK
            public final void accept(Object obj) {
                switch (i) {
                    case 0:
                        Configuration configuration = (Configuration) obj;
                        s sVar = this.u;
                        if (sVar.J()) {
                            sVar.h(false, configuration);
                        }
                        break;
                    case 1:
                        Integer num = (Integer) obj;
                        s sVar2 = this.u;
                        if (sVar2.J() && num.intValue() == 80) {
                            sVar2.l(false);
                            break;
                        }
                        break;
                    case 2:
                        XV0 xv0 = (XV0) obj;
                        s sVar3 = this.u;
                        if (sVar3.J()) {
                            sVar3.m(xv0.a, false);
                        }
                        break;
                    default:
                        Og1 og1 = (Og1) obj;
                        s sVar4 = this.u;
                        if (sVar4.J()) {
                            sVar4.r(og1.a, false);
                        }
                        break;
                }
            }
        };
        final int i2 = 1;
        this.r = new QK(this) { // from class: ai0
            public final /* synthetic */ s u;

            {
                this.u = this;
            }

            @Override // defpackage.QK
            public final void accept(Object obj) {
                switch (i2) {
                    case 0:
                        Configuration configuration = (Configuration) obj;
                        s sVar = this.u;
                        if (sVar.J()) {
                            sVar.h(false, configuration);
                        }
                        break;
                    case 1:
                        Integer num = (Integer) obj;
                        s sVar2 = this.u;
                        if (sVar2.J() && num.intValue() == 80) {
                            sVar2.l(false);
                            break;
                        }
                        break;
                    case 2:
                        XV0 xv0 = (XV0) obj;
                        s sVar3 = this.u;
                        if (sVar3.J()) {
                            sVar3.m(xv0.a, false);
                        }
                        break;
                    default:
                        Og1 og1 = (Og1) obj;
                        s sVar4 = this.u;
                        if (sVar4.J()) {
                            sVar4.r(og1.a, false);
                        }
                        break;
                }
            }
        };
        final int i3 = 2;
        this.s = new QK(this) { // from class: ai0
            public final /* synthetic */ s u;

            {
                this.u = this;
            }

            @Override // defpackage.QK
            public final void accept(Object obj) {
                switch (i3) {
                    case 0:
                        Configuration configuration = (Configuration) obj;
                        s sVar = this.u;
                        if (sVar.J()) {
                            sVar.h(false, configuration);
                        }
                        break;
                    case 1:
                        Integer num = (Integer) obj;
                        s sVar2 = this.u;
                        if (sVar2.J() && num.intValue() == 80) {
                            sVar2.l(false);
                            break;
                        }
                        break;
                    case 2:
                        XV0 xv0 = (XV0) obj;
                        s sVar3 = this.u;
                        if (sVar3.J()) {
                            sVar3.m(xv0.a, false);
                        }
                        break;
                    default:
                        Og1 og1 = (Og1) obj;
                        s sVar4 = this.u;
                        if (sVar4.J()) {
                            sVar4.r(og1.a, false);
                        }
                        break;
                }
            }
        };
        final int i4 = 3;
        this.t = new QK(this) { // from class: ai0
            public final /* synthetic */ s u;

            {
                this.u = this;
            }

            @Override // defpackage.QK
            public final void accept(Object obj) {
                switch (i4) {
                    case 0:
                        Configuration configuration = (Configuration) obj;
                        s sVar = this.u;
                        if (sVar.J()) {
                            sVar.h(false, configuration);
                        }
                        break;
                    case 1:
                        Integer num = (Integer) obj;
                        s sVar2 = this.u;
                        if (sVar2.J() && num.intValue() == 80) {
                            sVar2.l(false);
                            break;
                        }
                        break;
                    case 2:
                        XV0 xv0 = (XV0) obj;
                        s sVar3 = this.u;
                        if (sVar3.J()) {
                            sVar3.m(xv0.a, false);
                        }
                        break;
                    default:
                        Og1 og1 = (Og1) obj;
                        s sVar4 = this.u;
                        if (sVar4.J()) {
                            sVar4.r(og1.a, false);
                        }
                        break;
                }
            }
        };
        this.u = new C0600ei0(this);
        this.v = -1;
        this.A = new C0665fi0(this);
        this.B = new C0730gi0();
        this.F = new ArrayDeque();
        this.P = new RunnableC0796hi0(this);
    }

    public static HashSet E(a aVar) {
        HashSet hashSet = new HashSet();
        for (int i = 0; i < aVar.a.size(); i++) {
            n nVar = ((Ii0) aVar.a.get(i)).b;
            if (nVar != null && aVar.g) {
                hashSet.add(nVar);
            }
        }
        return hashSet;
    }

    public static boolean I(n nVar) {
        if (!nVar.mHasMenu || !nVar.mMenuVisible) {
            boolean zI = false;
            for (n nVar2 : nVar.mChildFragmentManager.c.e()) {
                if (nVar2 != null) {
                    zI = I(nVar2);
                }
                if (zI) {
                }
            }
            return false;
        }
        return true;
    }

    public static boolean K(n nVar) {
        if (nVar == null) {
            return true;
        }
        s sVar = nVar.mFragmentManager;
        return nVar.equals(sVar.z) && K(sVar.y);
    }

    /* JADX WARN: Removed duplicated region for block: B:110:0x0224 A[PHI: r14
      0x0224: PHI (r14v9 int) = (r14v8 int), (r14v10 int) binds: [B:103:0x0214, B:108:0x0220] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:118:0x0251  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x0164  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void A(java.util.ArrayList r24, java.util.ArrayList r25, int r26, int r27) {
        /*
            Method dump skipped, instruction units count: 1412
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.fragment.app.s.A(java.util.ArrayList, java.util.ArrayList, int, int):void");
    }

    public final n B(int i) {
        v vVar = this.c;
        ArrayList arrayList = vVar.a;
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            n nVar = (n) arrayList.get(size);
            if (nVar != null && nVar.mFragmentId == i) {
                return nVar;
            }
        }
        for (u uVar : vVar.b.values()) {
            if (uVar != null) {
                n nVar2 = uVar.c;
                if (nVar2.mFragmentId == i) {
                    return nVar2;
                }
            }
        }
        return null;
    }

    public final n C(String str) {
        v vVar = this.c;
        ArrayList arrayList = vVar.a;
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            n nVar = (n) arrayList.get(size);
            if (nVar != null && str.equals(nVar.mTag)) {
                return nVar;
            }
        }
        for (u uVar : vVar.b.values()) {
            if (uVar != null) {
                n nVar2 = uVar.c;
                if (str.equals(nVar2.mTag)) {
                    return nVar2;
                }
            }
        }
        return null;
    }

    public final void D() {
        for (g gVar : d()) {
            if (gVar.f) {
                gVar.f = false;
                gVar.e();
            }
        }
    }

    public final ViewGroup F(n nVar) {
        ViewGroup viewGroup = nVar.mContainer;
        if (viewGroup != null) {
            return viewGroup;
        }
        if (nVar.mContainerId > 0 && this.x.c()) {
            View viewB = this.x.b(nVar.mContainerId);
            if (viewB instanceof ViewGroup) {
                return (ViewGroup) viewB;
            }
        }
        return null;
    }

    public final C0665fi0 G() {
        n nVar = this.y;
        return nVar != null ? nVar.mFragmentManager.G() : this.A;
    }

    public final C0730gi0 H() {
        n nVar = this.y;
        return nVar != null ? nVar.mFragmentManager.H() : this.B;
    }

    public final boolean J() {
        n nVar = this.y;
        if (nVar == null) {
            return true;
        }
        return nVar.isAdded() && this.y.getParentFragmentManager().J();
    }

    public final boolean L() {
        return this.H || this.I;
    }

    public final void M(int i, boolean z) {
        HashMap map;
        Xh0 xh0;
        if (this.w == null && i != -1) {
            throw new IllegalStateException("No activity");
        }
        if (z || i != this.v) {
            this.v = i;
            v vVar = this.c;
            Iterator it = vVar.a.iterator();
            while (true) {
                boolean zHasNext = it.hasNext();
                map = vVar.b;
                if (!zHasNext) {
                    break;
                }
                u uVar = (u) map.get(((n) it.next()).mWho);
                if (uVar != null) {
                    uVar.g();
                }
            }
            for (u uVar2 : map.values()) {
                if (uVar2 != null) {
                    uVar2.g();
                    n nVar = uVar2.c;
                    if (nVar.mRemoving && !nVar.isInBackStack()) {
                        if (nVar.mBeingSaved && !vVar.c.containsKey(nVar.mWho)) {
                            vVar.i(nVar.mWho, uVar2.j());
                        }
                        vVar.h(uVar2);
                    }
                }
            }
            for (u uVar3 : vVar.d()) {
                n nVar2 = uVar3.c;
                if (nVar2.mDeferStart) {
                    if (this.b) {
                        this.K = true;
                    } else {
                        nVar2.mDeferStart = false;
                        uVar3.g();
                    }
                }
            }
            if (this.G && (xh0 = this.w) != null && this.v == 7) {
                ((Qh0) xh0).x.invalidateOptionsMenu();
                this.G = false;
            }
        }
    }

    public final void N() {
        if (this.w == null) {
            return;
        }
        this.H = false;
        this.I = false;
        this.O.g = false;
        for (n nVar : this.c.f()) {
            if (nVar != null) {
                nVar.noteStateNotSaved();
            }
        }
    }

    public final boolean O() {
        return P(-1, 0);
    }

    public final boolean P(int i, int i2) {
        y(false);
        x(true);
        n nVar = this.z;
        if (nVar != null && i < 0 && nVar.getChildFragmentManager().O()) {
            return true;
        }
        boolean zQ = Q(this.L, this.M, i, i2);
        if (zQ) {
            this.b = true;
            try {
                T(this.L, this.M);
            } finally {
                c();
            }
        }
        d0();
        boolean z = this.K;
        v vVar = this.c;
        if (z) {
            this.K = false;
            for (u uVar : vVar.d()) {
                n nVar2 = uVar.c;
                if (nVar2.mDeferStart) {
                    if (this.b) {
                        this.K = true;
                    } else {
                        nVar2.mDeferStart = false;
                        uVar.g();
                    }
                }
            }
        }
        vVar.b.values().removeAll(Collections.singleton(null));
        return zQ;
    }

    public final boolean Q(ArrayList arrayList, ArrayList arrayList2, int i, int i2) {
        boolean z = (i2 & 1) != 0;
        int size = -1;
        if (!this.d.isEmpty()) {
            if (i < 0) {
                size = z ? 0 : this.d.size() - 1;
            } else {
                int size2 = this.d.size() - 1;
                while (size2 >= 0) {
                    a aVar = (a) this.d.get(size2);
                    if (i >= 0 && i == aVar.t) {
                        break;
                    }
                    size2--;
                }
                if (size2 >= 0) {
                    if (z) {
                        while (size2 > 0) {
                            a aVar2 = (a) this.d.get(size2 - 1);
                            if (i < 0 || i != aVar2.t) {
                                break;
                            }
                            size2--;
                        }
                    } else if (size2 != this.d.size() - 1) {
                        size2++;
                    }
                    size = size2;
                } else {
                    size = size2;
                }
            }
        }
        if (size < 0) {
            return false;
        }
        for (int size3 = this.d.size() - 1; size3 >= size; size3--) {
            arrayList.add((a) this.d.remove(size3));
            arrayList2.add(Boolean.TRUE);
        }
        return true;
    }

    public final void R(Bundle bundle, String str, n nVar) {
        if (nVar.mFragmentManager == this) {
            bundle.putString(str, nVar.mWho);
        } else {
            c0(new IllegalStateException(AbstractC0068Fh0.a("Fragment ", nVar, " is not currently in the FragmentManager")));
            throw null;
        }
    }

    public final void S(n nVar) {
        boolean zIsInBackStack = nVar.isInBackStack();
        if (nVar.mDetached && zIsInBackStack) {
            return;
        }
        v vVar = this.c;
        synchronized (vVar.a) {
            vVar.a.remove(nVar);
        }
        nVar.mAdded = false;
        if (I(nVar)) {
            this.G = true;
        }
        nVar.mRemoving = true;
        b0(nVar);
    }

    public final void T(ArrayList arrayList, ArrayList arrayList2) {
        if (arrayList.isEmpty()) {
            return;
        }
        if (arrayList.size() != arrayList2.size()) {
            throw new IllegalStateException("Internal error with the back stack records");
        }
        int size = arrayList.size();
        int i = 0;
        int i2 = 0;
        while (i < size) {
            if (!((a) arrayList.get(i)).p) {
                if (i2 != i) {
                    A(arrayList, arrayList2, i2, i);
                }
                i2 = i + 1;
                if (((Boolean) arrayList2.get(i)).booleanValue()) {
                    while (i2 < size && ((Boolean) arrayList2.get(i2)).booleanValue() && !((a) arrayList.get(i2)).p) {
                        i2++;
                    }
                }
                A(arrayList, arrayList2, i, i2);
                i = i2 - 1;
            }
            i++;
        }
        if (i2 != size) {
            A(arrayList, arrayList2, i2, size);
        }
    }

    public final void U(Bundle bundle) {
        Zh0 zh0;
        Bundle bundle2;
        Bundle bundle3;
        for (String str : bundle.keySet()) {
            if (str.startsWith("result_") && (bundle3 = bundle.getBundle(str)) != null) {
                bundle3.setClassLoader(this.w.u.getClassLoader());
                this.m.put(str.substring(7), bundle3);
            }
        }
        HashMap map = new HashMap();
        for (String str2 : bundle.keySet()) {
            if (str2.startsWith("fragment_") && (bundle2 = bundle.getBundle(str2)) != null) {
                bundle2.setClassLoader(this.w.u.getClassLoader());
                map.put(str2.substring(9), bundle2);
            }
        }
        v vVar = this.c;
        HashMap map2 = vVar.c;
        map2.clear();
        map2.putAll(map);
        FragmentManagerState fragmentManagerState = (FragmentManagerState) bundle.getParcelable("state");
        if (fragmentManagerState == null) {
            return;
        }
        HashMap map3 = vVar.b;
        map3.clear();
        Iterator it = fragmentManagerState.t.iterator();
        while (true) {
            boolean zHasNext = it.hasNext();
            zh0 = this.o;
            if (!zHasNext) {
                break;
            }
            Bundle bundleI = vVar.i((String) it.next(), null);
            if (bundleI != null) {
                n nVar = (n) this.O.b.get(((FragmentState) bundleI.getParcelable("state")).u);
                u uVar = nVar != null ? new u(zh0, vVar, nVar, bundleI) : new u(this.o, this.c, this.w.u.getClassLoader(), G(), bundleI);
                n nVar2 = uVar.c;
                nVar2.mSavedFragmentState = bundleI;
                nVar2.mFragmentManager = this;
                uVar.h(this.w.u.getClassLoader());
                vVar.g(uVar);
                uVar.e = this.v;
            }
        }
        t tVar = this.O;
        tVar.getClass();
        for (n nVar3 : new ArrayList(tVar.b.values())) {
            if (map3.get(nVar3.mWho) == null) {
                this.O.d(nVar3);
                nVar3.mFragmentManager = this;
                u uVar2 = new u(zh0, vVar, nVar3);
                uVar2.e = 1;
                uVar2.g();
                nVar3.mRemoving = true;
                uVar2.g();
            }
        }
        ArrayList<String> arrayList = fragmentManagerState.u;
        vVar.a.clear();
        if (arrayList != null) {
            for (String str3 : arrayList) {
                n nVarB = vVar.b(str3);
                if (nVarB == null) {
                    throw new IllegalStateException(BN0.a("No instantiated fragment for (", str3, ")"));
                }
                vVar.a(nVarB);
            }
        }
        if (fragmentManagerState.v != null) {
            this.d = new ArrayList(fragmentManagerState.v.length);
            int i = 0;
            while (true) {
                BackStackRecordState[] backStackRecordStateArr = fragmentManagerState.v;
                if (i >= backStackRecordStateArr.length) {
                    break;
                }
                BackStackRecordState backStackRecordState = backStackRecordStateArr[i];
                backStackRecordState.getClass();
                a aVar = new a(this);
                int i2 = 0;
                int i3 = 0;
                while (true) {
                    int[] iArr = backStackRecordState.t;
                    if (i2 >= iArr.length) {
                        break;
                    }
                    Ii0 ii0 = new Ii0();
                    ii0.a = iArr[i2];
                    ii0.h = cF0.values()[backStackRecordState.v[i3]];
                    ii0.i = cF0.values()[backStackRecordState.w[i3]];
                    int i4 = i2 + 2;
                    ii0.c = iArr[i2 + 1] != 0;
                    int i5 = iArr[i4];
                    ii0.d = i5;
                    int i6 = iArr[i2 + 3];
                    ii0.e = i6;
                    int i7 = i2 + 5;
                    int i8 = iArr[i2 + 4];
                    ii0.f = i8;
                    i2 += 6;
                    int i9 = iArr[i7];
                    ii0.g = i9;
                    aVar.b = i5;
                    aVar.c = i6;
                    aVar.d = i8;
                    aVar.e = i9;
                    aVar.b(ii0);
                    i3++;
                }
                aVar.f = backStackRecordState.x;
                aVar.i = backStackRecordState.y;
                aVar.g = true;
                aVar.j = backStackRecordState.A;
                aVar.k = backStackRecordState.B;
                aVar.l = backStackRecordState.C;
                aVar.m = backStackRecordState.D;
                aVar.n = backStackRecordState.E;
                aVar.o = backStackRecordState.F;
                aVar.p = backStackRecordState.G;
                aVar.t = backStackRecordState.z;
                int i10 = 0;
                while (true) {
                    ArrayList arrayList2 = backStackRecordState.u;
                    if (i10 < arrayList2.size()) {
                        String str4 = (String) arrayList2.get(i10);
                        if (str4 != null) {
                            ((Ii0) aVar.a.get(i10)).b = vVar.b(str4);
                        }
                        i10++;
                    }
                }
                aVar.g(1);
                this.d.add(aVar);
                i++;
            }
        } else {
            this.d = new ArrayList();
        }
        this.k.set(fragmentManagerState.w);
        String str5 = fragmentManagerState.x;
        if (str5 != null) {
            n nVarB2 = vVar.b(str5);
            this.z = nVarB2;
            q(nVarB2);
        }
        ArrayList arrayList3 = fragmentManagerState.y;
        if (arrayList3 != null) {
            for (int i11 = 0; i11 < arrayList3.size(); i11++) {
                this.l.put((String) arrayList3.get(i11), (BackStackState) fragmentManagerState.z.get(i11));
            }
        }
        this.F = new ArrayDeque(fragmentManagerState.A);
    }

    public final Bundle V() {
        ArrayList arrayList;
        BackStackRecordState[] backStackRecordStateArr;
        Bundle bundle = new Bundle();
        D();
        v();
        y(true);
        this.H = true;
        this.O.g = true;
        v vVar = this.c;
        vVar.getClass();
        HashMap map = vVar.b;
        ArrayList arrayList2 = new ArrayList(map.size());
        for (u uVar : map.values()) {
            if (uVar != null) {
                n nVar = uVar.c;
                vVar.i(nVar.mWho, uVar.j());
                arrayList2.add(nVar.mWho);
            }
        }
        HashMap map2 = this.c.c;
        if (!map2.isEmpty()) {
            v vVar2 = this.c;
            synchronized (vVar2.a) {
                try {
                    if (vVar2.a.isEmpty()) {
                        arrayList = null;
                    } else {
                        arrayList = new ArrayList(vVar2.a.size());
                        Iterator it = vVar2.a.iterator();
                        while (it.hasNext()) {
                            arrayList.add(((n) it.next()).mWho);
                        }
                    }
                } finally {
                }
            }
            int size = this.d.size();
            if (size > 0) {
                backStackRecordStateArr = new BackStackRecordState[size];
                for (int i = 0; i < size; i++) {
                    backStackRecordStateArr[i] = new BackStackRecordState((a) this.d.get(i));
                }
            } else {
                backStackRecordStateArr = null;
            }
            FragmentManagerState fragmentManagerState = new FragmentManagerState();
            fragmentManagerState.x = null;
            ArrayList arrayList3 = new ArrayList();
            fragmentManagerState.y = arrayList3;
            ArrayList arrayList4 = new ArrayList();
            fragmentManagerState.z = arrayList4;
            fragmentManagerState.t = arrayList2;
            fragmentManagerState.u = arrayList;
            fragmentManagerState.v = backStackRecordStateArr;
            fragmentManagerState.w = this.k.get();
            n nVar2 = this.z;
            if (nVar2 != null) {
                fragmentManagerState.x = nVar2.mWho;
            }
            arrayList3.addAll(this.l.keySet());
            arrayList4.addAll(this.l.values());
            fragmentManagerState.A = new ArrayList(this.F);
            bundle.putParcelable("state", fragmentManagerState);
            for (String str : this.m.keySet()) {
                bundle.putBundle(Xd0.a("result_", str), (Bundle) this.m.get(str));
            }
            for (String str2 : map2.keySet()) {
                bundle.putBundle(Xd0.a("fragment_", str2), (Bundle) map2.get(str2));
            }
        }
        return bundle;
    }

    public final Fragment$SavedState W(n nVar) {
        u uVar = (u) this.c.b.get(nVar.mWho);
        if (uVar == null || !uVar.c.equals(nVar)) {
            c0(new IllegalStateException(AbstractC0068Fh0.a("Fragment ", nVar, " is not currently in the FragmentManager")));
            throw null;
        }
        if (uVar.c.mState > -1) {
            return new Fragment$SavedState(uVar.j());
        }
        return null;
    }

    public final void X() {
        synchronized (this.a) {
            try {
                if (this.a.size() == 1) {
                    this.w.v.removeCallbacks(this.P);
                    this.w.v.post(this.P);
                    d0();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void Y(n nVar, boolean z) {
        ViewGroup viewGroupF = F(nVar);
        if (viewGroupF == null || !(viewGroupF instanceof FragmentContainerView)) {
            return;
        }
        ((FragmentContainerView) viewGroupF).w = !z;
    }

    public final void Z(n nVar, cF0 cf0) {
        if (nVar.equals(this.c.b(nVar.mWho)) && (nVar.mHost == null || nVar.mFragmentManager == this)) {
            nVar.mMaxState = cf0;
            return;
        }
        throw new IllegalArgumentException("Fragment " + nVar + " is not an active fragment of FragmentManager " + this);
    }

    public final u a(n nVar) {
        String str = nVar.mPreviousWho;
        if (str != null) {
            AbstractC0092Hi0.b(nVar, str);
        }
        u uVarF = f(nVar);
        nVar.mFragmentManager = this;
        v vVar = this.c;
        vVar.g(uVarF);
        if (!nVar.mDetached) {
            vVar.a(nVar);
            nVar.mRemoving = false;
            if (nVar.mView == null) {
                nVar.mHiddenChanged = false;
            }
            if (I(nVar)) {
                this.G = true;
            }
        }
        return uVarF;
    }

    public final void a0(n nVar) {
        if (nVar != null) {
            if (!nVar.equals(this.c.b(nVar.mWho)) || (nVar.mHost != null && nVar.mFragmentManager != this)) {
                throw new IllegalArgumentException("Fragment " + nVar + " is not an active fragment of FragmentManager " + this);
            }
        }
        n nVar2 = this.z;
        this.z = nVar;
        q(nVar2);
        q(this.z);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void b(Xh0 xh0, AbstractC0246Uh0 abstractC0246Uh0, n nVar) {
        if (this.w != null) {
            throw new IllegalStateException("Already attached");
        }
        this.w = xh0;
        this.x = abstractC0246Uh0;
        this.y = nVar;
        CopyOnWriteArrayList copyOnWriteArrayList = this.p;
        if (nVar != null) {
            copyOnWriteArrayList.add(new C0862ii0(nVar));
        } else if (xh0 instanceof InterfaceC1463si0) {
            copyOnWriteArrayList.add((InterfaceC1463si0) xh0);
        }
        if (this.y != null) {
            d0();
        }
        if (xh0 instanceof K41) {
            K41 k41 = (K41) xh0;
            J41 j41L = k41.l();
            this.g = j41L;
            InterfaceC0762hF0 interfaceC0762hF0 = k41;
            if (nVar != null) {
                interfaceC0762hF0 = nVar;
            }
            j41L.a(interfaceC0762hF0, this.j);
        }
        if (nVar != null) {
            t tVar = nVar.mFragmentManager.O;
            HashMap map = tVar.c;
            t tVar2 = (t) map.get(nVar.mWho);
            if (tVar2 == null) {
                tVar2 = new t(tVar.e);
                map.put(nVar.mWho, tVar2);
            }
            this.O = tVar2;
        } else if (xh0 instanceof InterfaceC0105Io2) {
            C0083Go2 c0083Go2 = new C0083Go2(((InterfaceC0105Io2) xh0).getViewModelStore(), t.h, DO.b);
            iF iFVarA = Gs1.a(t.class);
            String strB = iFVarA.b();
            if (strB == null) {
                throw new IllegalArgumentException("Local and anonymous classes can not be ViewModels");
            }
            this.O = (t) c0083Go2.a(iFVarA, "androidx.lifecycle.ViewModelProvider.DefaultKey:".concat(strB));
        } else {
            this.O = new t(false);
        }
        this.O.g = L();
        this.c.d = this.O;
        Object obj = this.w;
        if ((obj instanceof vz1) && nVar == null) {
            tz1 savedStateRegistry = ((vz1) obj).getSavedStateRegistry();
            savedStateRegistry.c("android:support:fragments", new sz1() { // from class: bi0
                @Override // defpackage.sz1
                public final Bundle a() {
                    return this.a.V();
                }
            });
            Bundle bundleA = savedStateRegistry.a("android:support:fragments");
            if (bundleA != null) {
                U(bundleA);
            }
        }
        Object obj2 = this.w;
        if (obj2 instanceof v4) {
            u4 u4VarM0 = ((v4) obj2).m0();
            String strA = Xd0.a("FragmentManager:", nVar != null ? S3.a(new StringBuilder(), nVar.mWho, ":") : "");
            this.C = u4VarM0.c(F.a(strA, "StartActivityForResult"), new C1127n4(1), new di0(this, 1));
            this.D = u4VarM0.c(F.a(strA, "StartIntentSenderForResult"), new C0925ji0(), new di0(this, 2));
            this.E = u4VarM0.c(F.a(strA, "RequestPermissions"), new C1127n4(0), new di0(this, 0));
        }
        Object obj3 = this.w;
        if (obj3 instanceof O41) {
            ((O41) obj3).L(this.q);
        }
        Object obj4 = this.w;
        if (obj4 instanceof V41) {
            ((V41) obj4).P(this.r);
        }
        Object obj5 = this.w;
        if (obj5 instanceof S41) {
            ((S41) obj5).s0(this.s);
        }
        Object obj6 = this.w;
        if (obj6 instanceof T41) {
            ((T41) obj6).c0(this.t);
        }
        Object obj7 = this.w;
        if ((obj7 instanceof AQ0) && nVar == null) {
            ((AQ0) obj7).k0(this.u);
        }
    }

    public final void b0(n nVar) {
        ViewGroup viewGroupF = F(nVar);
        if (viewGroupF != null) {
            if (nVar.getPopExitAnim() + nVar.getPopEnterAnim() + nVar.getExitAnim() + nVar.getEnterAnim() > 0) {
                if (viewGroupF.getTag(AbstractC0132Lp1.visible_removing_fragment_view_tag) == null) {
                    viewGroupF.setTag(AbstractC0132Lp1.visible_removing_fragment_view_tag, nVar);
                }
                ((n) viewGroupF.getTag(AbstractC0132Lp1.visible_removing_fragment_view_tag)).setPopDirection(nVar.getPopDirection());
            }
        }
    }

    public final void c() {
        this.b = false;
        this.M.clear();
        this.L.clear();
    }

    public final void c0(IllegalStateException illegalStateException) {
        Log.e("FragmentManager", illegalStateException.getMessage());
        Log.e("FragmentManager", "Activity state:");
        PrintWriter printWriter = new PrintWriter(new TI0());
        Xh0 xh0 = this.w;
        if (xh0 == null) {
            try {
                u("  ", null, printWriter, new String[0]);
                throw illegalStateException;
            } catch (Exception e) {
                Log.e("FragmentManager", "Failed dumping state", e);
                throw illegalStateException;
            }
        }
        try {
            ((Qh0) xh0).x.dump("  ", null, printWriter, new String[0]);
            throw illegalStateException;
        } catch (Exception e2) {
            Log.e("FragmentManager", "Failed dumping state", e2);
            throw illegalStateException;
        }
    }

    public final HashSet d() {
        g gVar;
        HashSet hashSet = new HashSet();
        Iterator it = this.c.d().iterator();
        while (it.hasNext()) {
            ViewGroup viewGroup = ((u) it.next()).c.mContainer;
            if (viewGroup != null) {
                H();
                Object tag = viewGroup.getTag(AbstractC0132Lp1.special_effects_controller_view_tag);
                if (tag instanceof g) {
                    gVar = (g) tag;
                } else {
                    gVar = new g(viewGroup);
                    viewGroup.setTag(AbstractC0132Lp1.special_effects_controller_view_tag, gVar);
                }
                hashSet.add(gVar);
            }
        }
        return hashSet;
    }

    public final void d0() {
        synchronized (this.a) {
            try {
                if (this.a.isEmpty()) {
                    this.j.e(this.d.size() + (this.h != null ? 1 : 0) > 0 && K(this.y));
                } else {
                    this.j.e(true);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final HashSet e(ArrayList arrayList, int i, int i2) {
        ViewGroup viewGroup;
        g gVar;
        HashSet hashSet = new HashSet();
        while (i < i2) {
            Iterator it = ((a) arrayList.get(i)).a.iterator();
            while (it.hasNext()) {
                n nVar = ((Ii0) it.next()).b;
                if (nVar != null && (viewGroup = nVar.mContainer) != null) {
                    H();
                    Object tag = viewGroup.getTag(AbstractC0132Lp1.special_effects_controller_view_tag);
                    if (tag instanceof g) {
                        gVar = (g) tag;
                    } else {
                        gVar = new g(viewGroup);
                        viewGroup.setTag(AbstractC0132Lp1.special_effects_controller_view_tag, gVar);
                    }
                    hashSet.add(gVar);
                }
            }
            i++;
        }
        return hashSet;
    }

    public final u f(n nVar) {
        String str = nVar.mWho;
        v vVar = this.c;
        u uVar = (u) vVar.b.get(str);
        if (uVar != null) {
            return uVar;
        }
        u uVar2 = new u(this.o, vVar, nVar);
        uVar2.h(this.w.u.getClassLoader());
        uVar2.e = this.v;
        return uVar2;
    }

    public final void g(n nVar) {
        if (nVar.mDetached) {
            return;
        }
        nVar.mDetached = true;
        if (nVar.mAdded) {
            v vVar = this.c;
            synchronized (vVar.a) {
                vVar.a.remove(nVar);
            }
            nVar.mAdded = false;
            if (I(nVar)) {
                this.G = true;
            }
            b0(nVar);
        }
    }

    public final void h(boolean z, Configuration configuration) {
        if (z && (this.w instanceof O41)) {
            c0(new IllegalStateException("Do not call dispatchConfigurationChanged() on host. Host implements OnConfigurationChangedProvider and automatically dispatches configuration changes to fragments."));
            throw null;
        }
        for (n nVar : this.c.f()) {
            if (nVar != null) {
                nVar.performConfigurationChanged(configuration);
                if (z) {
                    nVar.mChildFragmentManager.h(true, configuration);
                }
            }
        }
    }

    public final boolean i(MenuItem menuItem) {
        if (this.v < 1) {
            return false;
        }
        for (n nVar : this.c.f()) {
            if (nVar != null && nVar.performContextItemSelected(menuItem)) {
                return true;
            }
        }
        return false;
    }

    public final boolean j(Menu menu, MenuInflater menuInflater) {
        if (this.v < 1) {
            return false;
        }
        ArrayList arrayList = null;
        boolean z = false;
        for (n nVar : this.c.f()) {
            if (nVar != null && nVar.isMenuVisible() && nVar.performCreateOptionsMenu(menu, menuInflater)) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.add(nVar);
                z = true;
            }
        }
        if (this.e != null) {
            for (int i = 0; i < this.e.size(); i++) {
                n nVar2 = (n) this.e.get(i);
                if (arrayList == null || !arrayList.contains(nVar2)) {
                    nVar2.onDestroyOptionsMenu();
                }
            }
        }
        this.e = arrayList;
        return z;
    }

    public final void k() {
        boolean zIsChangingConfigurations = true;
        this.f16J = true;
        y(true);
        v();
        Xh0 xh0 = this.w;
        boolean z = xh0 instanceof InterfaceC0105Io2;
        v vVar = this.c;
        if (z) {
            zIsChangingConfigurations = vVar.d.f;
        } else {
            FragmentActivity fragmentActivity = xh0.u;
            if (fragmentActivity != null) {
                zIsChangingConfigurations = true ^ fragmentActivity.isChangingConfigurations();
            }
        }
        if (zIsChangingConfigurations) {
            Iterator it = this.l.values().iterator();
            while (it.hasNext()) {
                Iterator it2 = ((BackStackState) it.next()).t.iterator();
                while (it2.hasNext()) {
                    vVar.d.c((String) it2.next(), false);
                }
            }
        }
        t(-1);
        Object obj = this.w;
        if (obj instanceof V41) {
            ((V41) obj).I(this.r);
        }
        Object obj2 = this.w;
        if (obj2 instanceof O41) {
            ((O41) obj2).j(this.q);
        }
        Object obj3 = this.w;
        if (obj3 instanceof S41) {
            ((S41) obj3).F0(this.s);
        }
        Object obj4 = this.w;
        if (obj4 instanceof T41) {
            ((T41) obj4).n0(this.t);
        }
        Object obj5 = this.w;
        if ((obj5 instanceof AQ0) && this.y == null) {
            ((AQ0) obj5).w(this.u);
        }
        this.w = null;
        this.x = null;
        this.y = null;
        if (this.g != null) {
            Iterator it3 = this.j.b.iterator();
            while (it3.hasNext()) {
                ((vx) it3.next()).cancel();
            }
            this.g = null;
        }
        C1480t4 c1480t4 = this.C;
        if (c1480t4 != null) {
            c1480t4.b();
            this.D.b();
            this.E.b();
        }
    }

    public final void l(boolean z) {
        if (z && (this.w instanceof V41)) {
            c0(new IllegalStateException("Do not call dispatchLowMemory() on host. Host implements OnTrimMemoryProvider and automatically dispatches low memory callbacks to fragments."));
            throw null;
        }
        for (n nVar : this.c.f()) {
            if (nVar != null) {
                nVar.performLowMemory();
                if (z) {
                    nVar.mChildFragmentManager.l(true);
                }
            }
        }
    }

    public final void m(boolean z, boolean z2) {
        if (z2 && (this.w instanceof S41)) {
            c0(new IllegalStateException("Do not call dispatchMultiWindowModeChanged() on host. Host implements OnMultiWindowModeChangedProvider and automatically dispatches multi-window mode changes to fragments."));
            throw null;
        }
        for (n nVar : this.c.f()) {
            if (nVar != null) {
                nVar.performMultiWindowModeChanged(z);
                if (z2) {
                    nVar.mChildFragmentManager.m(z, true);
                }
            }
        }
    }

    public final void n() {
        for (n nVar : this.c.e()) {
            if (nVar != null) {
                nVar.onHiddenChanged(nVar.isHidden());
                nVar.mChildFragmentManager.n();
            }
        }
    }

    public final boolean o(MenuItem menuItem) {
        if (this.v < 1) {
            return false;
        }
        for (n nVar : this.c.f()) {
            if (nVar != null && nVar.performOptionsItemSelected(menuItem)) {
                return true;
            }
        }
        return false;
    }

    public final void p(Menu menu) {
        if (this.v < 1) {
            return;
        }
        for (n nVar : this.c.f()) {
            if (nVar != null) {
                nVar.performOptionsMenuClosed(menu);
            }
        }
    }

    public final void q(n nVar) {
        if (nVar != null) {
            if (nVar.equals(this.c.b(nVar.mWho))) {
                nVar.performPrimaryNavigationFragmentChanged();
            }
        }
    }

    public final void r(boolean z, boolean z2) {
        if (z2 && (this.w instanceof T41)) {
            c0(new IllegalStateException("Do not call dispatchPictureInPictureModeChanged() on host. Host implements OnPictureInPictureModeChangedProvider and automatically dispatches picture-in-picture mode changes to fragments."));
            throw null;
        }
        for (n nVar : this.c.f()) {
            if (nVar != null) {
                nVar.performPictureInPictureModeChanged(z);
                if (z2) {
                    nVar.mChildFragmentManager.r(z, true);
                }
            }
        }
    }

    public final boolean s(Menu menu) {
        boolean z = false;
        if (this.v < 1) {
            return false;
        }
        for (n nVar : this.c.f()) {
            if (nVar != null && nVar.isMenuVisible() && nVar.performPrepareOptionsMenu(menu)) {
                z = true;
            }
        }
        return z;
    }

    public final void t(int i) {
        try {
            this.b = true;
            for (u uVar : this.c.b.values()) {
                if (uVar != null) {
                    uVar.e = i;
                }
            }
            M(i, false);
            Iterator it = d().iterator();
            while (it.hasNext()) {
                ((g) it.next()).i();
            }
            this.b = false;
            y(true);
        } catch (Throwable th) {
            this.b = false;
            throw th;
        }
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder(128);
        sb.append("FragmentManager{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append(" in ");
        n nVar = this.y;
        if (nVar != null) {
            sb.append(nVar.getClass().getSimpleName());
            sb.append("{");
            sb.append(Integer.toHexString(System.identityHashCode(this.y)));
            sb.append("}");
        } else {
            Xh0 xh0 = this.w;
            if (xh0 != null) {
                sb.append(xh0.getClass().getSimpleName());
                sb.append("{");
                sb.append(Integer.toHexString(System.identityHashCode(this.w)));
                sb.append("}");
            } else {
                sb.append("null");
            }
        }
        sb.append("}}");
        return sb.toString();
    }

    public final void u(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        String str2;
        int size;
        String strA = F.a(str, "    ");
        v vVar = this.c;
        vVar.getClass();
        String str3 = str + "    ";
        HashMap map = vVar.b;
        if (!map.isEmpty()) {
            printWriter.print(str);
            printWriter.println("Active Fragments:");
            for (u uVar : map.values()) {
                printWriter.print(str);
                if (uVar != null) {
                    n nVar = uVar.c;
                    printWriter.println(nVar);
                    nVar.dump(str3, fileDescriptor, printWriter, strArr);
                } else {
                    printWriter.println("null");
                }
            }
        }
        ArrayList arrayList = vVar.a;
        int size2 = arrayList.size();
        if (size2 > 0) {
            printWriter.print(str);
            printWriter.println("Added Fragments:");
            for (int i = 0; i < size2; i++) {
                n nVar2 = (n) arrayList.get(i);
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(i);
                printWriter.print(": ");
                printWriter.println(nVar2.toString());
            }
        }
        ArrayList arrayList2 = this.e;
        if (arrayList2 != null && (size = arrayList2.size()) > 0) {
            printWriter.print(str);
            printWriter.println("Fragments Created Menus:");
            for (int i2 = 0; i2 < size; i2++) {
                n nVar3 = (n) this.e.get(i2);
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(i2);
                printWriter.print(": ");
                printWriter.println(nVar3.toString());
            }
        }
        int size3 = this.d.size();
        if (size3 > 0) {
            printWriter.print(str);
            printWriter.println("Back Stack:");
            for (int i3 = 0; i3 < size3; i3++) {
                a aVar = (a) this.d.get(i3);
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(i3);
                printWriter.print(": ");
                printWriter.println(aVar.toString());
                printWriter.print(strA);
                printWriter.print("mName=");
                printWriter.print(aVar.i);
                printWriter.print(" mIndex=");
                printWriter.print(aVar.t);
                printWriter.print(" mCommitted=");
                printWriter.println(aVar.s);
                if (aVar.f != 0) {
                    printWriter.print(strA);
                    printWriter.print("mTransition=#");
                    printWriter.print(Integer.toHexString(aVar.f));
                }
                if (aVar.b != 0 || aVar.c != 0) {
                    printWriter.print(strA);
                    printWriter.print("mEnterAnim=#");
                    printWriter.print(Integer.toHexString(aVar.b));
                    printWriter.print(" mExitAnim=#");
                    printWriter.println(Integer.toHexString(aVar.c));
                }
                if (aVar.d != 0 || aVar.e != 0) {
                    printWriter.print(strA);
                    printWriter.print("mPopEnterAnim=#");
                    printWriter.print(Integer.toHexString(aVar.d));
                    printWriter.print(" mPopExitAnim=#");
                    printWriter.println(Integer.toHexString(aVar.e));
                }
                if (aVar.j != 0 || aVar.k != null) {
                    printWriter.print(strA);
                    printWriter.print("mBreadCrumbTitleRes=#");
                    printWriter.print(Integer.toHexString(aVar.j));
                    printWriter.print(" mBreadCrumbTitleText=");
                    printWriter.println(aVar.k);
                }
                if (aVar.l != 0 || aVar.m != null) {
                    printWriter.print(strA);
                    printWriter.print("mBreadCrumbShortTitleRes=#");
                    printWriter.print(Integer.toHexString(aVar.l));
                    printWriter.print(" mBreadCrumbShortTitleText=");
                    printWriter.println(aVar.m);
                }
                ArrayList arrayList3 = aVar.a;
                if (!arrayList3.isEmpty()) {
                    printWriter.print(strA);
                    printWriter.println("Operations:");
                    int size4 = arrayList3.size();
                    for (int i4 = 0; i4 < size4; i4++) {
                        Ii0 ii0 = (Ii0) arrayList3.get(i4);
                        switch (ii0.a) {
                            case 0:
                                str2 = "NULL";
                                break;
                            case 1:
                                str2 = "ADD";
                                break;
                            case 2:
                                str2 = "REPLACE";
                                break;
                            case 3:
                                str2 = "REMOVE";
                                break;
                            case 4:
                                str2 = "HIDE";
                                break;
                            case 5:
                                str2 = "SHOW";
                                break;
                            case 6:
                                str2 = "DETACH";
                                break;
                            case 7:
                                str2 = "ATTACH";
                                break;
                            case 8:
                                str2 = "SET_PRIMARY_NAV";
                                break;
                            case ConnectionResult.SERVICE_INVALID /* 9 */:
                                str2 = "UNSET_PRIMARY_NAV";
                                break;
                            case 10:
                                str2 = "OP_SET_MAX_LIFECYCLE";
                                break;
                            default:
                                str2 = "cmd=" + ii0.a;
                                break;
                        }
                        printWriter.print(strA);
                        printWriter.print("  Op #");
                        printWriter.print(i4);
                        printWriter.print(": ");
                        printWriter.print(str2);
                        printWriter.print(" ");
                        printWriter.println(ii0.b);
                        if (ii0.d != 0 || ii0.e != 0) {
                            printWriter.print(strA);
                            printWriter.print("enterAnim=#");
                            printWriter.print(Integer.toHexString(ii0.d));
                            printWriter.print(" exitAnim=#");
                            printWriter.println(Integer.toHexString(ii0.e));
                        }
                        if (ii0.f != 0 || ii0.g != 0) {
                            printWriter.print(strA);
                            printWriter.print("popEnterAnim=#");
                            printWriter.print(Integer.toHexString(ii0.f));
                            printWriter.print(" popExitAnim=#");
                            printWriter.println(Integer.toHexString(ii0.g));
                        }
                    }
                }
            }
        }
        printWriter.print(str);
        printWriter.println("Back Stack Index: " + this.k.get());
        synchronized (this.a) {
            try {
                int size5 = this.a.size();
                if (size5 > 0) {
                    printWriter.print(str);
                    printWriter.println("Pending Actions:");
                    for (int i5 = 0; i5 < size5; i5++) {
                        Object obj = (InterfaceC1166ni0) this.a.get(i5);
                        printWriter.print(str);
                        printWriter.print("  #");
                        printWriter.print(i5);
                        printWriter.print(": ");
                        printWriter.println(obj);
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        printWriter.print(str);
        printWriter.println("FragmentManager misc state:");
        printWriter.print(str);
        printWriter.print("  mHost=");
        printWriter.println(this.w);
        printWriter.print(str);
        printWriter.print("  mContainer=");
        printWriter.println(this.x);
        if (this.y != null) {
            printWriter.print(str);
            printWriter.print("  mParent=");
            printWriter.println(this.y);
        }
        printWriter.print(str);
        printWriter.print("  mCurState=");
        printWriter.print(this.v);
        printWriter.print(" mStateSaved=");
        printWriter.print(this.H);
        printWriter.print(" mStopped=");
        printWriter.print(this.I);
        printWriter.print(" mDestroyed=");
        printWriter.println(this.f16J);
        if (this.G) {
            printWriter.print(str);
            printWriter.print("  mNeedMenuInvalidate=");
            printWriter.println(this.G);
        }
    }

    public final void v() {
        Iterator it = d().iterator();
        while (it.hasNext()) {
            ((g) it.next()).i();
        }
    }

    public final void w(InterfaceC1166ni0 interfaceC1166ni0, boolean z) {
        if (!z) {
            if (this.w == null) {
                if (!this.f16J) {
                    throw new IllegalStateException("FragmentManager has not been attached to a host.");
                }
                throw new IllegalStateException("FragmentManager has been destroyed");
            }
            if (L()) {
                throw new IllegalStateException("Can not perform this action after onSaveInstanceState");
            }
        }
        synchronized (this.a) {
            try {
                if (this.w == null) {
                    if (!z) {
                        throw new IllegalStateException("Activity has been destroyed");
                    }
                } else {
                    this.a.add(interfaceC1166ni0);
                    X();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void x(boolean z) {
        if (this.b) {
            throw new IllegalStateException("FragmentManager is already executing transactions");
        }
        if (this.w == null) {
            if (!this.f16J) {
                throw new IllegalStateException("FragmentManager has not been attached to a host.");
            }
            throw new IllegalStateException("FragmentManager has been destroyed");
        }
        if (Looper.myLooper() != this.w.v.getLooper()) {
            throw new IllegalStateException("Must be called from main thread of fragment host");
        }
        if (!z && L()) {
            throw new IllegalStateException("Can not perform this action after onSaveInstanceState");
        }
        if (this.L == null) {
            this.L = new ArrayList();
            this.M = new ArrayList();
        }
    }

    public final boolean y(boolean z) {
        boolean zA;
        a aVar;
        x(z);
        if (!this.i && (aVar = this.h) != null) {
            aVar.s = false;
            aVar.i(false, false);
            this.a.add(0, this.h);
            Iterator it = this.h.a.iterator();
            while (it.hasNext()) {
                n nVar = ((Ii0) it.next()).b;
                if (nVar != null) {
                    nVar.mTransitioning = false;
                }
            }
            this.h = null;
        }
        boolean z2 = false;
        while (true) {
            ArrayList arrayList = this.L;
            ArrayList arrayList2 = this.M;
            synchronized (this.a) {
                if (this.a.isEmpty()) {
                    zA = false;
                } else {
                    try {
                        int size = this.a.size();
                        zA = false;
                        for (int i = 0; i < size; i++) {
                            zA |= ((InterfaceC1166ni0) this.a.get(i)).a(arrayList, arrayList2);
                        }
                    } finally {
                    }
                }
            }
            if (!zA) {
                break;
            }
            this.b = true;
            try {
                T(this.L, this.M);
                c();
                z2 = true;
            } catch (Throwable th) {
                c();
                throw th;
            }
        }
        d0();
        if (this.K) {
            this.K = false;
            for (u uVar : this.c.d()) {
                n nVar2 = uVar.c;
                if (nVar2.mDeferStart) {
                    if (this.b) {
                        this.K = true;
                    } else {
                        nVar2.mDeferStart = false;
                        uVar.g();
                    }
                }
            }
        }
        this.c.b.values().removeAll(Collections.singleton(null));
        return z2;
    }

    public final void z(a aVar, boolean z) {
        if (z && (this.w == null || this.f16J)) {
            return;
        }
        x(z);
        a aVar2 = this.h;
        if (aVar2 != null) {
            aVar2.s = false;
            aVar2.i(false, false);
            this.h.a(this.L, this.M);
            Iterator it = this.h.a.iterator();
            while (it.hasNext()) {
                n nVar = ((Ii0) it.next()).b;
                if (nVar != null) {
                    nVar.mTransitioning = false;
                }
            }
            this.h = null;
        }
        aVar.a(this.L, this.M);
        this.b = true;
        try {
            T(this.L, this.M);
            c();
            d0();
            boolean z2 = this.K;
            v vVar = this.c;
            if (z2) {
                this.K = false;
                for (u uVar : vVar.d()) {
                    n nVar2 = uVar.c;
                    if (nVar2.mDeferStart) {
                        if (this.b) {
                            this.K = true;
                        } else {
                            nVar2.mDeferStart = false;
                            uVar.g();
                        }
                    }
                }
            }
            vVar.b.values().removeAll(Collections.singleton(null));
        } catch (Throwable th) {
            c();
            throw th;
        }
    }
}
