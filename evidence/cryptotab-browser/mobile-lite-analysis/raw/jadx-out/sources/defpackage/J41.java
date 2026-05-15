package defpackage;

import android.os.Build;
import android.window.OnBackInvokedCallback;
import android.window.OnBackInvokedDispatcher;
import java.util.Iterator;
import java.util.ListIterator;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class J41 {
    public final Runnable a;
    public final Ye b = new Ye();
    public AbstractC1815z41 c;
    public final OnBackInvokedCallback d;
    public OnBackInvokedDispatcher e;
    public boolean f;
    public boolean g;

    public J41(Runnable runnable) {
        OnBackInvokedCallback e41;
        this.a = runnable;
        int i = Build.VERSION.SDK_INT;
        if (i >= 33) {
            if (i >= 34) {
                e41 = new E41(new A41(this, 0), new A41(this, 1), new B41(this, 0), new B41(this, 1));
            } else {
                final B41 b41 = new B41(this, 2);
                e41 = new OnBackInvokedCallback() { // from class: C41
                    public final void onBackInvoked() {
                        b41.c();
                    }
                };
            }
            this.d = e41;
        }
    }

    public final void a(InterfaceC0762hF0 interfaceC0762hF0, AbstractC1815z41 abstractC1815z41) {
        AbstractC0514dF0 lifecycle = interfaceC0762hF0.getLifecycle();
        if (((C0886jF0) lifecycle).c == cF0.t) {
            return;
        }
        abstractC1815z41.b.add(new G41(this, lifecycle, abstractC1815z41));
        f();
        abstractC1815z41.c = new I41(0, this, J41.class, "updateEnabledCallbacks", "updateEnabledCallbacks()V", 0);
    }

    public final H41 b(AbstractC1815z41 abstractC1815z41) {
        this.b.addLast(abstractC1815z41);
        H41 h41 = new H41(this, abstractC1815z41);
        abstractC1815z41.b.add(h41);
        f();
        abstractC1815z41.c = new I41(0, this, J41.class, "updateEnabledCallbacks", "updateEnabledCallbacks()V", 1);
        return h41;
    }

    public final void c() {
        Object objPrevious;
        AbstractC1815z41 abstractC1815z41 = this.c;
        if (abstractC1815z41 == null) {
            Ye ye = this.b;
            ListIterator<E> listIterator = ye.listIterator(ye.size());
            while (true) {
                if (!listIterator.hasPrevious()) {
                    objPrevious = null;
                    break;
                } else {
                    objPrevious = listIterator.previous();
                    if (((AbstractC1815z41) objPrevious).a) {
                        break;
                    }
                }
            }
            abstractC1815z41 = (AbstractC1815z41) objPrevious;
        }
        this.c = null;
        if (abstractC1815z41 != null) {
            abstractC1815z41.a();
        }
    }

    public final void d() {
        Object objPrevious;
        AbstractC1815z41 abstractC1815z41 = this.c;
        if (abstractC1815z41 == null) {
            Ye ye = this.b;
            ListIterator<E> listIterator = ye.listIterator(ye.size());
            while (true) {
                if (!listIterator.hasPrevious()) {
                    objPrevious = null;
                    break;
                } else {
                    objPrevious = listIterator.previous();
                    if (((AbstractC1815z41) objPrevious).a) {
                        break;
                    }
                }
            }
            abstractC1815z41 = (AbstractC1815z41) objPrevious;
        }
        this.c = null;
        if (abstractC1815z41 != null) {
            abstractC1815z41.b();
            return;
        }
        Runnable runnable = this.a;
        if (runnable != null) {
            runnable.run();
        }
    }

    public final void e(boolean z) {
        OnBackInvokedDispatcher onBackInvokedDispatcher = this.e;
        OnBackInvokedCallback onBackInvokedCallback = this.d;
        if (onBackInvokedDispatcher == null || onBackInvokedCallback == null) {
            return;
        }
        if (z && !this.f) {
            D41.a(onBackInvokedDispatcher, onBackInvokedCallback);
            this.f = true;
        } else {
            if (z || !this.f) {
                return;
            }
            D41.b(onBackInvokedDispatcher, onBackInvokedCallback);
            this.f = false;
        }
    }

    public final void f() {
        boolean z = this.g;
        boolean z2 = false;
        Ye ye = this.b;
        if (ye == null || !ye.isEmpty()) {
            Iterator<E> it = ye.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                } else if (((AbstractC1815z41) it.next()).a) {
                    z2 = true;
                    break;
                }
            }
        }
        this.g = z2;
        if (z2 == z || Build.VERSION.SDK_INT < 33) {
            return;
        }
        e(z2);
    }
}
