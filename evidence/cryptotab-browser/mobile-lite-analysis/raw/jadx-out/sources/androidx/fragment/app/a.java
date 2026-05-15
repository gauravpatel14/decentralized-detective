package androidx.fragment.app;

import defpackage.AbstractC0092Hi0;
import defpackage.Ii0;
import defpackage.InterfaceC1166ni0;
import defpackage.Ji0;
import defpackage.Xh0;
import defpackage.cF0;
import java.lang.reflect.Modifier;
import java.util.ArrayList;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class a extends Ji0 implements InterfaceC1166ni0 {
    public final s r;
    public boolean s;
    public int t;

    public a(s sVar) {
        sVar.G();
        Xh0 xh0 = sVar.w;
        if (xh0 != null) {
            xh0.u.getClassLoader();
        }
        this.a = new ArrayList();
        this.h = true;
        this.p = false;
        this.t = -1;
        this.r = sVar;
    }

    @Override // defpackage.InterfaceC1166ni0
    public final boolean a(ArrayList arrayList, ArrayList arrayList2) {
        arrayList.add(this);
        arrayList2.add(Boolean.FALSE);
        if (!this.g) {
            return true;
        }
        this.r.d.add(this);
        return true;
    }

    @Override // defpackage.Ji0
    public final void d(int i, n nVar, String str, int i2) {
        String str2 = nVar.mPreviousWho;
        if (str2 != null) {
            AbstractC0092Hi0.b(nVar, str2);
        }
        Class<?> cls = nVar.getClass();
        int modifiers = cls.getModifiers();
        if (cls.isAnonymousClass() || !Modifier.isPublic(modifiers) || (cls.isMemberClass() && !Modifier.isStatic(modifiers))) {
            throw new IllegalStateException("Fragment " + cls.getCanonicalName() + " must be a public static class to be  properly recreated from instance state.");
        }
        if (str != null) {
            String str3 = nVar.mTag;
            if (str3 != null && !str.equals(str3)) {
                throw new IllegalStateException("Can't change tag of fragment " + nVar + ": was " + nVar.mTag + " now " + str);
            }
            nVar.mTag = str;
        }
        if (i != 0) {
            if (i == -1) {
                throw new IllegalArgumentException("Can't add fragment " + nVar + " with tag " + str + " to container view with no id");
            }
            int i3 = nVar.mFragmentId;
            if (i3 != 0 && i3 != i) {
                throw new IllegalStateException("Can't change container ID of fragment " + nVar + ": was " + nVar.mFragmentId + " now " + i);
            }
            nVar.mFragmentId = i;
            nVar.mContainerId = i;
        }
        b(new Ii0(nVar, i2));
        nVar.mFragmentManager = this.r;
    }

    public final void g(int i) {
        if (this.g) {
            ArrayList arrayList = this.a;
            int size = arrayList.size();
            for (int i2 = 0; i2 < size; i2++) {
                n nVar = ((Ii0) arrayList.get(i2)).b;
                if (nVar != null) {
                    nVar.mBackStackNesting += i;
                }
            }
        }
    }

    public final int h() {
        return i(false, true);
    }

    public final int i(boolean z, boolean z2) {
        if (this.s) {
            throw new IllegalStateException("commit already called");
        }
        this.s = true;
        boolean z3 = this.g;
        s sVar = this.r;
        if (z3) {
            this.t = sVar.k.getAndIncrement();
        } else {
            this.t = -1;
        }
        if (z2) {
            sVar.w(this, z);
        }
        return this.t;
    }

    public final void j() {
        if (this.g) {
            throw new IllegalStateException("This transaction is already being added to the back stack");
        }
        this.h = false;
        this.r.z(this, false);
    }

    public final a k(n nVar) {
        s sVar = nVar.mFragmentManager;
        if (sVar == null || sVar == this.r) {
            b(new Ii0(nVar, 3));
            return this;
        }
        throw new IllegalStateException("Cannot remove Fragment attached to a different FragmentManager. Fragment " + nVar.toString() + " is already attached to a FragmentManager.");
    }

    public final a l(n nVar, cF0 cf0) {
        s sVar = nVar.mFragmentManager;
        s sVar2 = this.r;
        if (sVar != sVar2) {
            throw new IllegalArgumentException("Cannot setMaxLifecycle for Fragment not attached to FragmentManager " + sVar2);
        }
        if (cf0 == cF0.u && nVar.mState > -1) {
            throw new IllegalArgumentException("Cannot set maximum Lifecycle to " + cf0 + " after the Fragment has been created");
        }
        if (cf0 == cF0.t) {
            throw new IllegalArgumentException("Cannot set maximum Lifecycle to " + cf0 + ". Use remove() to remove the fragment from the FragmentManager and trigger its destruction.");
        }
        Ii0 ii0 = new Ii0();
        ii0.a = 10;
        ii0.b = nVar;
        ii0.c = false;
        ii0.h = nVar.mMaxState;
        ii0.i = cf0;
        b(ii0);
        return this;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder(128);
        sb.append("BackStackEntry{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        if (this.t >= 0) {
            sb.append(" #");
            sb.append(this.t);
        }
        if (this.i != null) {
            sb.append(" ");
            sb.append(this.i);
        }
        sb.append("}");
        return sb.toString();
    }
}
