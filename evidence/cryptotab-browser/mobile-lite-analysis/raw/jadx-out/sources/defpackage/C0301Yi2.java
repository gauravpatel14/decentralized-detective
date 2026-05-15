package defpackage;

import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.graphics.fonts.FontVariationAxis;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import android.util.Log;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: renamed from: Yi2, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public class C0301Yi2 extends AbstractC0493cj2 {
    public static Class h = null;
    public static Constructor i = null;
    public static Method j = null;
    public static Method k = null;
    public static boolean l = false;
    public final Class a;
    public final Constructor b;
    public final Method c;
    public final Method d;
    public final Method e;
    public final Method f;
    public final Method g;

    public C0301Yi2() throws NoSuchMethodException {
        Method methodN;
        Constructor<?> constructor;
        Method methodM;
        Method method;
        Method method2;
        Method method3;
        Class<?> cls = null;
        try {
            Class<?> cls2 = Class.forName("android.graphics.FontFamily");
            constructor = cls2.getConstructor(null);
            methodM = m(cls2);
            Class cls3 = Integer.TYPE;
            method = cls2.getMethod("addFontFromBuffer", ByteBuffer.class, cls3, FontVariationAxis[].class, cls3, cls3);
            method2 = cls2.getMethod("freeze", null);
            method3 = cls2.getMethod("abortCreation", null);
            methodN = n(cls2);
            cls = cls2;
        } catch (ClassNotFoundException | NoSuchMethodException e) {
            Log.e("TypefaceCompatApi26Impl", "Unable to collect necessary methods for class ".concat(e.getClass().getName()), e);
            methodN = null;
            constructor = null;
            methodM = null;
            method = null;
            method2 = null;
            method3 = null;
        }
        this.a = cls;
        this.b = constructor;
        this.c = methodM;
        this.d = method;
        this.e = method2;
        this.f = method3;
        this.g = methodN;
    }

    public static boolean g(Object obj, String str, boolean z, int i2) throws NoSuchMethodException {
        j();
        try {
            return ((Boolean) j.invoke(obj, str, Integer.valueOf(i2), Boolean.valueOf(z))).booleanValue();
        } catch (IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }

    public static void j() throws NoSuchMethodException {
        Method method;
        Class<?> cls;
        Method method2;
        if (l) {
            return;
        }
        l = true;
        Constructor<?> constructor = null;
        try {
            cls = Class.forName("android.graphics.FontFamily");
            Constructor<?> constructor2 = cls.getConstructor(null);
            method2 = cls.getMethod("addFontWeightStyle", String.class, Integer.TYPE, Boolean.TYPE);
            method = Typeface.class.getMethod("createFromFamiliesWithDefault", Array.newInstance(cls, 1).getClass());
            constructor = constructor2;
        } catch (ClassNotFoundException | NoSuchMethodException e) {
            Log.e("TypefaceCompatApi21Impl", e.getClass().getName(), e);
            method = null;
            cls = null;
            method2 = null;
        }
        i = constructor;
        h = cls;
        j = method2;
        k = method;
    }

    public static Method m(Class cls) {
        Class cls2 = Integer.TYPE;
        return cls.getMethod("addFontFromAssetManager", AssetManager.class, String.class, cls2, Boolean.TYPE, cls2, cls2, cls2, FontVariationAxis[].class);
    }

    @Override // defpackage.AbstractC0493cj2
    public final Typeface a(Context context, C0983kh0 c0983kh0, Resources resources, int i2) throws NoSuchMethodException {
        if (k()) {
            Object objL = l();
            if (objL == null) {
                return null;
            }
            for (C1043lh0 c1043lh0 : c0983kh0.a) {
                if (!f(context, objL, c1043lh0.a, c1043lh0.e, c1043lh0.b, c1043lh0.c ? 1 : 0, FontVariationAxis.fromFontVariationSettings(c1043lh0.d))) {
                    e(objL);
                    return null;
                }
            }
            if (i(objL)) {
                return h(objL);
            }
            return null;
        }
        j();
        try {
            Object objNewInstance = i.newInstance(null);
            for (C1043lh0 c1043lh02 : c0983kh0.a) {
                File fileD = AbstractC0544dj2.d(context);
                if (fileD == null) {
                    return null;
                }
                try {
                    if (AbstractC0544dj2.b(fileD, resources, c1043lh02.f)) {
                        if (g(objNewInstance, fileD.getPath(), c1043lh02.c, c1043lh02.b)) {
                            fileD.delete();
                        }
                    }
                } catch (RuntimeException unused) {
                } catch (Throwable th) {
                    fileD.delete();
                    throw th;
                }
                fileD.delete();
                return null;
            }
            j();
            try {
                Object objNewInstance2 = Array.newInstance((Class<?>) h, 1);
                Array.set(objNewInstance2, 0, objNewInstance);
                return (Typeface) k.invoke(null, objNewInstance2);
            } catch (IllegalAccessException | InvocationTargetException e) {
                throw new RuntimeException(e);
            }
        } catch (IllegalAccessException | InstantiationException | InvocationTargetException e2) {
            throw new RuntimeException(e2);
        }
    }

    @Override // defpackage.AbstractC0493cj2
    public final Typeface b(Context context, C1289ph0[] c1289ph0Arr, int i2) {
        Typeface typefaceH;
        boolean zBooleanValue;
        if (c1289ph0Arr.length < 1) {
            return null;
        }
        if (!k()) {
            C1289ph0 c1289ph0D = d(i2, c1289ph0Arr);
            try {
                ParcelFileDescriptor parcelFileDescriptorOpenFileDescriptor = context.getContentResolver().openFileDescriptor(c1289ph0D.a, "r", null);
                if (parcelFileDescriptorOpenFileDescriptor == null) {
                    if (parcelFileDescriptorOpenFileDescriptor != null) {
                    }
                    return null;
                }
                try {
                    Typeface typefaceBuild = new Typeface.Builder(parcelFileDescriptorOpenFileDescriptor.getFileDescriptor()).setWeight(c1289ph0D.c).setItalic(c1289ph0D.d).build();
                    parcelFileDescriptorOpenFileDescriptor.close();
                    return typefaceBuild;
                } finally {
                    try {
                        parcelFileDescriptorOpenFileDescriptor.close();
                    } catch (Throwable unused) {
                    }
                }
            } catch (IOException unused2) {
                return null;
            }
        }
        HashMap map = new HashMap();
        for (C1289ph0 c1289ph0 : c1289ph0Arr) {
            if (c1289ph0.e == 0) {
                Uri uri = c1289ph0.a;
                if (map.containsKey(uri)) {
                    continue;
                } else {
                    MappedByteBuffer mappedByteBuffer = null;
                    try {
                        ParcelFileDescriptor parcelFileDescriptorOpenFileDescriptor2 = context.getContentResolver().openFileDescriptor(uri, "r", null);
                        if (parcelFileDescriptorOpenFileDescriptor2 != null) {
                            try {
                                FileInputStream fileInputStream = new FileInputStream(parcelFileDescriptorOpenFileDescriptor2.getFileDescriptor());
                                try {
                                    FileChannel channel = fileInputStream.getChannel();
                                    MappedByteBuffer map2 = channel.map(FileChannel.MapMode.READ_ONLY, 0L, channel.size());
                                    fileInputStream.close();
                                    parcelFileDescriptorOpenFileDescriptor2.close();
                                    mappedByteBuffer = map2;
                                } catch (Throwable th) {
                                    try {
                                        fileInputStream.close();
                                    } catch (Throwable unused3) {
                                    }
                                    throw th;
                                }
                            } finally {
                                try {
                                    parcelFileDescriptorOpenFileDescriptor2.close();
                                } catch (Throwable unused4) {
                                }
                            }
                        } else if (parcelFileDescriptorOpenFileDescriptor2 != null) {
                            parcelFileDescriptorOpenFileDescriptor2.close();
                        }
                    } catch (IOException unused5) {
                    }
                    map.put(uri, mappedByteBuffer);
                }
            }
        }
        Map mapUnmodifiableMap = Collections.unmodifiableMap(map);
        Object objL = l();
        if (objL == null) {
            return null;
        }
        int length = c1289ph0Arr.length;
        int i3 = 0;
        boolean z = false;
        while (i3 < length) {
            C1289ph0 c1289ph02 = c1289ph0Arr[i3];
            ByteBuffer byteBuffer = (ByteBuffer) mapUnmodifiableMap.get(c1289ph02.a);
            if (byteBuffer != null) {
                try {
                    zBooleanValue = ((Boolean) this.d.invoke(objL, byteBuffer, Integer.valueOf(c1289ph02.b), null, Integer.valueOf(c1289ph02.c), Integer.valueOf(c1289ph02.d ? 1 : 0))).booleanValue();
                } catch (IllegalAccessException | InvocationTargetException unused6) {
                    zBooleanValue = false;
                }
                if (!zBooleanValue) {
                    e(objL);
                    return null;
                }
                z = true;
            }
            i3++;
            z = z;
        }
        if (!z) {
            e(objL);
            return null;
        }
        if (i(objL) && (typefaceH = h(objL)) != null) {
            return Typeface.create(typefaceH, i2);
        }
        return null;
    }

    @Override // defpackage.AbstractC0493cj2
    public final Typeface c(Context context, Resources resources, int i2, String str, int i3) {
        if (!k()) {
            return super.c(context, resources, i2, str, i3);
        }
        Object objL = l();
        if (objL == null) {
            return null;
        }
        if (!f(context, objL, str, 0, -1, -1, null)) {
            e(objL);
            return null;
        }
        if (i(objL)) {
            return h(objL);
        }
        return null;
    }

    public final void e(Object obj) {
        try {
            this.f.invoke(obj, null);
        } catch (IllegalAccessException | InvocationTargetException unused) {
        }
    }

    public final boolean f(Context context, Object obj, String str, int i2, int i3, int i4, FontVariationAxis[] fontVariationAxisArr) {
        try {
            return ((Boolean) this.c.invoke(obj, context.getAssets(), str, 0, Boolean.FALSE, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), fontVariationAxisArr)).booleanValue();
        } catch (IllegalAccessException | InvocationTargetException unused) {
            return false;
        }
    }

    public Typeface h(Object obj) {
        try {
            Object objNewInstance = Array.newInstance((Class<?>) this.a, 1);
            Array.set(objNewInstance, 0, obj);
            return (Typeface) this.g.invoke(null, objNewInstance, -1, -1);
        } catch (IllegalAccessException | InvocationTargetException unused) {
            return null;
        }
    }

    public final boolean i(Object obj) {
        try {
            return ((Boolean) this.e.invoke(obj, null)).booleanValue();
        } catch (IllegalAccessException | InvocationTargetException unused) {
            return false;
        }
    }

    public final boolean k() {
        Method method = this.c;
        if (method == null) {
            Log.w("TypefaceCompatApi26Impl", "Unable to collect necessary private methods. Fallback to legacy implementation.");
        }
        return method != null;
    }

    public final Object l() {
        try {
            return this.b.newInstance(null);
        } catch (IllegalAccessException | InstantiationException | InvocationTargetException unused) {
            return null;
        }
    }

    public Method n(Class cls) throws NoSuchMethodException {
        Class<?> cls2 = Array.newInstance((Class<?>) cls, 1).getClass();
        Class cls3 = Integer.TYPE;
        Method declaredMethod = Typeface.class.getDeclaredMethod("createFromFamiliesWithDefault", cls2, cls3, cls3);
        declaredMethod.setAccessible(true);
        return declaredMethod;
    }
}
